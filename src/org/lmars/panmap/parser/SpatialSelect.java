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
	 * 构造函数
	 */
	public SpatialSelect() {

		// 保存了在查询过程中需要的所有中间变量
		excuteVar = ParseExcuteVar.getexcuteVar();
		// 保存查询语言中的所有三元组
		this.Triples = new ArrayList<Triple>();
		this.Filters = new ArrayList<Filters>();

	}

	/*
	 * 总的三元组执行函数
	 */

	public void triple_excute(Map<String, String> paramMap)
			throws UnkownTripleTypeException, NoPropertyException,
			OntoNotDefineExcetion {
		// TODO Auto-generated method stub
		// 调用三元组工厂类
		Triple tripleFactory = new Triple(paramMap);
		tripleFactory = new Triple(paramMap);		
		this.Triples.add(tripleFactory);
		tripleFactory.tripleExcute();

	}

	/*
	 * 执行完一条filter语句后执行此函数，对三元组进行回溯查询执行
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
	 * 进行整个filter解算的函数
	 */

	public void filter_excute(SparqlParser.FilterContext ctx)
			throws VarNotDefineException, NoSelectVarException {
		Filters filterFactory = new Filters(ctx);
		this.Filters.add(filterFactory);
		excuteVar.index = new int[excuteVar.FilterVars.size()];
		// 现在FilterVar储存约束需要的变量，那么根据其个数判断需要多少成for循环
		filter_loop(excuteVar.FilterVars.size() - 1, ctx);
		filter_excute_update();
	}

	/*
	 * 现在FilterVar储存约束需要的变量，那么根据其个数判断需要多少成for循环
	 */
	private void filter_loop(int count, SparqlParser.FilterContext ctx)
			throws VarNotDefineException, NoSelectVarException {
		try {
			for (int i = 0; i < excuteVar.FilterVars.get(count).IriLength(); i++) {
				excuteVar.index[count] = i;
				// 应将index的属性保存造FilterVars中
				excuteVar.FilterVars.get(count).SetIndex(i);
				if (count != 0) {
					int temp = count - 1;
					filter_loop(temp, ctx);
				}

				if (count == 0)// 到最底层循环 可以调用查询函数了 得到当前Filter
				{

					Filters filterFactory = new Filters(ctx);
					// 在调用查询函数时根据index对每个变量进行取值
					boolean filterResult = filterFactory.filterExcute();
					// if（满足约束条件）保存当前的index IndexSet.add(index);
					if (filterResult) {
						int[] temp = new int[excuteVar.index.length];
						for (int j = 0; j < temp.length; j++) {
							temp[j] = excuteVar.index[j];
						}
						excuteVar.IndexSet.add(temp);
					}
					Iterator iterator1 = excuteVar.IndexSet.iterator();// 对满足条件的index遍历

				}

			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new VarNotDefineException("存在未定义变量！" + "\n");
		}

		return;

	}

	/*
	 * 执行完一个filter约束语句后对约束的变量进行更新到Vars变量中
	 */
	private void filter_excute_update() throws VarNotDefineException,
			NoSelectVarException {

		// 最终根据IndexSet对Vars中的变量进行约束
		// 首先对FilterVars的变量约束，之后再用FilterVars对Vars进行覆盖

		try {
			for (int i = 0; i < excuteVar.FilterVars.size(); i++) {
				String nameString = excuteVar.FilterVars.get(i).VarName();
				Set<String> set = new HashSet<String>();// 保存过滤后的iri
				Iterator iterator = excuteVar.IndexSet.iterator();// 对满足条件的index遍历
				while (iterator.hasNext()) {
					int[] temp = (int[]) iterator.next();
					set.add(excuteVar.FilterVars.get(i).IndexIri(temp[i]));
				}
				excuteVar.SetValue(nameString, set);
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new VarNotDefineException("存在未定义变量！" + "\n");
		}

	}

	/*
	 * 根据变量类IsSelect属性得到最终要查询的变量结果
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
	 * 让用户设置本体文件路径的函数
	 */
	public void SetOWLFile(String fileStr) {

		excuteVar.owlFilePath = fileStr;
		excuteVar.instance = new OWL(excuteVar.owlFilePath);
	}

	/*
	 * 让用户设置postgis数据库地址的函数
	 */
	public void SetPgAddress(String ipaddress) {

		excuteVar.address = ipaddress;
	}

	/*
	 * 让用户设置连接postgis数据库用户名和密码的函数
	 */
	public void SetPgUsernPass(String user, String pass) {

		excuteVar.user = user;
		excuteVar.pass = pass;
	}

	/*
	 * 根据ID从postgis数据库中将点线面的信息读取出来
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
	 * 存储查询过程中需要的变量。包括Prefix以及一些未知和带入的变量
	 */
	public ParseExcuteVar excuteVar;
	public ArrayList<Triple> Triples;
	public ArrayList<Filters> Filters;

}
