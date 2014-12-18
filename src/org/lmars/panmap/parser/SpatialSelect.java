package org.lmars.panmap.parser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.lmars.panmap.exception.NoPropertyException;
import org.lmars.panmap.exception.NoSelectVarException;
import org.lmars.panmap.exception.OntoNotDefineExcetion;
import org.lmars.panmap.exception.UnkownTripleTypeException;
import org.lmars.panmap.exception.VarNotDefineException;
import org.lmars.panmap.filter.Filters;
import org.lmars.panmap.geo.Geometry;
import org.lmars.panmap.geo.GeometryFactory;
import org.lmars.panmap.triple.Triple;
import org.lmars.panmap.triple.TripleRecall;
import org.lmars.sparql.parser.SparqlParser;
import org.owlapi.OWL;

public class SpatialSelect {

	/*
	 * ���캯��
	 */
	public SpatialSelect() {

		// �������ڲ�ѯ��������Ҫ�������м����
		excuteVar = ParseExcuteVar.getexcuteVar();
		// �����ѯ�����е�������Ԫ��
		this.Triples = new ArrayList<Triple>();
		this.Filters = new ArrayList<Filters>();

	}

	/*
	 * �ܵ���Ԫ��ִ�к���
	 */

	public void triple_excute(Map<String, String> paramMap)
			throws UnkownTripleTypeException, NoPropertyException,
			OntoNotDefineExcetion {
		// TODO Auto-generated method stub
		// ������Ԫ�鹤����
		Triple tripleFactory = new Triple(paramMap);
		tripleFactory = new Triple(paramMap);		
		this.Triples.add(tripleFactory);
		tripleFactory.tripleExcute();

	}

	/*
	 * ִ����һ��filter����ִ�д˺���������Ԫ����л��ݲ�ѯִ��
	 */

	public void tirple_excute_racall() throws VarNotDefineException,
			UnkownTripleTypeException {
		// TODO Auto-generated method stub
		int size = Triples.size();
		for (int i = size - 1; i >= 0; i--) {
			try {
				TripleRecall recall = new TripleRecall(
						Triples.get(i).triple.tripleMap);
				recall.tripleExcute();
			} catch (OntoNotDefineExcetion e) {

				// TODO: handle exception
			} catch (NoPropertyException e) {

				// TODO: handle exception
			}

		}

	}

	/*
	 * ��������filter����ĺ���
	 */

	public void filter_excute(SparqlParser.FilterContext ctx)
			throws VarNotDefineException, NoSelectVarException {
		Filters filterFactory = new Filters(ctx);
		this.Filters.add(filterFactory);
		excuteVar.index = new int[excuteVar.FilterVars.size()];
		// ����FilterVar����Լ����Ҫ�ı�������ô����������ж���Ҫ���ٳ�forѭ��
		filter_loop(excuteVar.FilterVars.size() - 1, ctx);
		filter_excute_update();
	}

	/*
	 * ����FilterVar����Լ����Ҫ�ı�������ô����������ж���Ҫ���ٳ�forѭ��
	 */
	private void filter_loop(int count, SparqlParser.FilterContext ctx)
			throws VarNotDefineException, NoSelectVarException {
		try {
			for (int i = 0; i < excuteVar.FilterVars.get(count).IriLength(); i++) {
				excuteVar.index[count] = i;
				// Ӧ��index�����Ա�����FilterVars��
				excuteVar.FilterVars.get(count).SetIndex(i);
				if (count != 0) {
					int temp = count - 1;
					filter_loop(temp, ctx);
				}

				if (count == 0)// ����ײ�ѭ�� ���Ե��ò�ѯ������ �õ���ǰFilter
				{

					Filters filterFactory = new Filters(ctx);
					// �ڵ��ò�ѯ����ʱ����index��ÿ����������ȡֵ
					boolean filterResult = filterFactory.filterExcute();
					// if������Լ�����������浱ǰ��index IndexSet.add(index);
					if (filterResult) {
						int[] temp = new int[excuteVar.index.length];
						for (int j = 0; j < temp.length; j++) {
							temp[j] = excuteVar.index[j];
						}
						excuteVar.IndexSet.add(temp);
					}
					Iterator iterator1 = excuteVar.IndexSet.iterator();// ������������index����

				}

			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new VarNotDefineException("����δ���������" + "\n");
		}

		return;

	}

	/*
	 * ִ����һ��filterԼ�������Լ���ı������и��µ�Vars������
	 */
	private void filter_excute_update() throws VarNotDefineException,
			NoSelectVarException {

		// ���ո���IndexSet��Vars�еı�������Լ��
		// ���ȶ�FilterVars�ı���Լ����֮������FilterVars��Vars���и���

		try {
			for (int i = 0; i < excuteVar.FilterVars.size(); i++) {
				String nameString = excuteVar.FilterVars.get(i).VarName();
				Set<String> set = new HashSet<String>();// ������˺��iri
				Iterator iterator = excuteVar.IndexSet.iterator();// ������������index����
				while (iterator.hasNext()) {
					int[] temp = (int[]) iterator.next();
					set.add(excuteVar.FilterVars.get(i).IndexIri(temp[i]));
				}
				excuteVar.SetValue(nameString, set);
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new VarNotDefineException("����δ���������" + "\n");
		}

	}

	/*
	 * ���ݱ�����IsSelect���Եõ�����Ҫ��ѯ�ı������
	 */
	public Map<String, Set<String>> SelectResult() {

		Map<String, Set<String>> selecetMap = new HashMap<String, Set<String>>();
		Iterator<Variable> iterator = excuteVar.Vars.iterator();
		while (iterator.hasNext()) {
			Variable variable = iterator.next();

			if (variable.IsSelect) {
				selecetMap.put(variable.NameString,
						excuteVar.GetValue(variable.NameString));
			}
		}
		return selecetMap;
	}

	/*
	 * ���û����ñ����ļ�·���ĺ���
	 */
	public void SetOWLFile(String fileStr) {

		excuteVar.owlFilePath = fileStr;
		excuteVar.instance = new OWL(excuteVar.owlFilePath);
	}

	/*
	 * ���û�����postgis���ݿ��ַ�ĺ���
	 */
	public void SetPgAddress(String ipaddress) {

		excuteVar.address = ipaddress;
	}

	/*
	 * ���û���������postgis���ݿ��û���������ĺ���
	 */
	public void SetPgUsernPass(String user, String pass) {

		excuteVar.user = user;
		excuteVar.pass = pass;
	}

	/*
	 * ����ID��postgis���ݿ��н����������Ϣ��ȡ����
	 */
	public Geometry GetGeometry(String ID) throws SQLException {

		Connection conn = null;
		java.sql.Statement st = null;
		ResultSet rs = null;
		String url = "jdbc:postgresql://localhost:5432/postgis_21_sample";
		String user = "postgres";
		String password = "admin";
		JSONObject resultJson = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			String sql = "select ST_AsGeoJSON(geom) from polygon_r_21 where gid="
					+ ID;
			rs = ((java.sql.Statement) st).executeQuery(sql);

			while (rs.next()) {
				resultJson = JSONObject.fromObject(rs.getObject(1).toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			conn.close();
		}
		Geometry geometry = GeometryFactory.createGeometryBase(resultJson);
		return geometry;
	}

	

	/*
	 * �洢��ѯ��������Ҫ�ı���������Prefix�Լ�һЩδ֪�ʹ���ı���
	 */
	public ParseExcuteVar excuteVar;
	public ArrayList<Triple> Triples;
	public ArrayList<Filters> Filters;

}
