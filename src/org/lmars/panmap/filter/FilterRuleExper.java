package org.lmars.panmap.filter;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.tree.ParseTree;
import org.lmars.panmap.exception.NoSelectVarException;
import org.lmars.panmap.spatialcompute.SpatialCompute;
import org.lmars.sparql.parser.SparqlParser;
import org.lmars.sparql.parser.SparqlParser.FilterContext;

public class FilterRuleExper extends FilterStrategy {

	public FilterRuleExper(FilterContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean filterExcute() throws NoSelectVarException {
		// TODO Auto-generated method stub
		int type = judge_filter_condition(ctx);
		boolean result = false;
		switch (type) {
		case 0:// ���ʽԼ��
			result = Boolean.parseBoolean(filter_excute_exper(ctx.constraint()
					.expression()));
			break;
		case 1:
			// ����Լ��
			// �õ����������ƣ��õ������ĸ������õ����������ƣ�Ȼ�������Ӧ�ĺ������в�ѯ
			Map<String, String> funcMap = new HashMap<String, String>();
			// �õ��������� ֻ����һ����������
			String funcnameString = ctx.constraint().functionList().function()
					.get(0).ID().getText();
			// �õ���������
			String paramscountString = Integer.toString(ctx.constraint()
					.functionList().function().get(0).paramDeclList()
					.expression().size());
			// �õ����������ַ���
			String paramsString = ctx.constraint().functionList().function()
					.get(0).paramDeclList().getText();
			funcMap.put("FuncName", funcnameString);
			funcMap.put("ParamsCount", paramscountString);
			funcMap.put("Params", paramsString);
			result = Boolean.parseBoolean(filter_excute_func(funcMap));
		default:
			break;
		}
		return result;
	}

	private String filter_excute_exper(ParseTree expression)
			throws NoSelectVarException {

		// �õ���ǰ���������Ĳ�����
		String operation;
		// ��ʾ������������ֵ�����ַ�����ʾ�����ֻ��boolean��double���������������string��������ʾ
		String str_result_left, str_result_right;

		if (expression.getChildCount() == 3) {
			operation = expression.getChild(1).getText();
			str_result_left = filter_excute_exper(expression.getChild(0));// ��õ�һ����������ֵ
			str_result_right = filter_excute_exper(expression.getChild(2));// ��õڶ�����������ֵ

			if (str_result_left.startsWith("\"")) {
				str_result_left = str_result_left.split("\"")[1];
			}
			if (str_result_right.startsWith("\"")) {
				str_result_right = str_result_right.split("\"")[1];
			}
			double temp;
			boolean temp1;
			switch (operation) {
			case "+":
				temp = Double.parseDouble(str_result_left)
						+ Double.parseDouble(str_result_right);
				return Double.toString(temp);
			case "-":
				temp = Double.parseDouble(str_result_left)
						- Double.parseDouble(str_result_right);
				return Double.toString(temp);
			case ">":
				temp1 = (Double.parseDouble(str_result_left) > Double
						.parseDouble(str_result_right));
				return String.valueOf(temp1);
			case "=":
				temp1 = (Double.parseDouble(str_result_left) == Double
						.parseDouble(str_result_right));
				return String.valueOf(temp1);
			case "<":
				temp1 = (Double.parseDouble(str_result_left) < Double
						.parseDouble(str_result_right));
				return String.valueOf(temp1);

			default:
				break;
			}
		}
		if (expression.getChildCount() == 2) {
			operation = expression.getChild(0).getText();
			str_result_left = filter_excute_exper(expression.getChild(1));// ��ò�������ֵ
			switch (operation) {
			case "!":
				boolean temp = !Boolean.parseBoolean(str_result_left);
				return String.valueOf(temp);

			default:
				break;
			}
		}
		if (expression.getChildCount() == 1) {

			// ��ʱ��expression��������� ��һ�����exprassion��һ��ֵ���ڶ������expression��һ������
			// ��ȡprimaryExpression�ڵ㣬�ж��������ͣ�function numericLiteral rdfLiteral
			// boolean
			if (expression.getChild(0).getChild(0).getChildCount() > 1) {// ����Ϊ����
				// ���ú�����ѯ����

				// �õ����������ƣ��õ������ĸ������õ����������ƣ�Ȼ�������Ӧ�ĺ������в�ѯ
				Map<String, String> funcMap = new HashMap<String, String>();
				// �õ��������� ֻ����һ����������
				String funcnameString = expression.getChild(0).getChild(0)
						.getChild(0).getText();
				String paramsString = "";
				if (expression.getChild(0).getChild(0).getChildCount() > 2) {
					// �õ����������ַ���
					paramsString = expression.getChild(0).getChild(0)
							.getChild(2).getText();
				} else {
					paramsString = expression.getChild(0).getChild(0)
							.getChild(1).getText();
				}

				funcMap.put("FuncName", funcnameString);
				funcMap.put("Params", paramsString);
				String funcResult = filter_excute_func(funcMap);
				// return Double.toString(Distance("iri1","iri2"));
				return funcResult;

			} else {
				// ����Ϊ��ֵ���ַ���,�������ַ�������
				// ����Ҳ�п�����iri�ı���
				// �����index����ȡֵ�����ض�ȡ���Ľ��
				if (expression.getChild(0).getText().startsWith("?")) {

					return excuteVar.find_i_iri(expression.getChild(0)
							.getText());
				}
				return expression.getChild(0).getText();
			}
		}

		return "";
	}

	/*
	 * �ܵĺ���Լ����ִ�к�������������Ҫ�жϺ���Լ�������ͣ��ٵ�����Ӧ�ĺ���
	 */
	private String filter_excute_func(Map<String, String> args)
			throws NoSelectVarException {
		// �����жϺ���������
		String funcNameString = args.get("FuncName");// ����������
		String paramString = args.get("Params");
		String[] paramsString = paramString.split(",");// �洢�������Ƶ��ַ�������

		int paramsCount = paramsString.length;
		// ȡ��ÿһ��������iri
		String var1iriString = "";
		String var2iriString = "";

		var1iriString = excuteVar.find_i_iri(paramsString[0]);// ��ʱ�Ľ����һ��set<String>�γɵ��ַ���
		var2iriString = excuteVar.find_i_iri(paramsString[1]);
		if (Pattern.compile("opposite", Pattern.CASE_INSENSITIVE)
				.matcher(funcNameString).find()) {
			// ���õ�opposite����
			if (paramsCount == 2) {
				return String.valueOf(Opposite(var1iriString, var2iriString));
				// �������������ж� ����true false �ж�����ʵ���Ƿ��ж���Ĺ�ϵ
			}
		} else if (Pattern.compile("Adjacent", Pattern.CASE_INSENSITIVE)
				.matcher(funcNameString).find()) {
			// ���õ�Adjacent����
			if (paramsCount == 2) {
				// �������������ж� ����true false �ж�����ʵ���Ƿ������ڵĹ�ϵ
			}
		} else if (Pattern.compile("Contained", Pattern.CASE_INSENSITIVE)
				.matcher(funcNameString).find()) {
			// ���õ�Contained����

			// �������������ж� ����true false �ж�����ʵ���Ƿ��а����Ĺ�ϵ ��һ�����������ڶ�������

		} else if (Pattern.compile("Contain", Pattern.CASE_INSENSITIVE)
				.matcher(funcNameString).find()) {
			// ���õ�Contain����
		} else if (Pattern.compile("Distance", Pattern.CASE_INSENSITIVE)
				.matcher(funcNameString).find()) {
			// ���õ�Distance����
			// һ������������
			return "5";
		} else if (Pattern.compile("Direction", Pattern.CASE_INSENSITIVE)
				.matcher(funcNameString).find()) {
			// ���õ�Direction����
			// һ������������
		}

		return null;
	}

	/*
	 * �ж�Լ����������
	 */
	private int judge_filter_condition(SparqlParser.FilterContext ctx) {
		int type = 0;

		// �ж��Ǻ���Լ�����ǲ�����Լ��
		// ��Ϊ����Լ������õ���������������ֵ��ͨ��index�õ���Ӧ��ֻ��һ��ʵ���������ú���Լ��ִ�к���filter_execute_funcRule1�õ�true����false���жϵ�ǰ��index�Ƿ�����Ҫ��
		// ��Ϊ������Լ������ֱ�ӵ���excute_tree_exper�����õ�true����false���жϵ�ǰ��index�Ƿ�����Ҫ��
		if (ctx.constraint().expression() != null) {
			// ������Լ��������excute_tree_exper
			return 0;
		} else if (ctx.constraint().functionList() != null) {
			// ����Լ��
			return 1;
		}

		return type;
	}

	/*
	 * ���ݷ���iri�õ������ݿ��б����idֵ
	 */
	private String IriToID(String IRI) {
		String idString = "";

		String pvIri = "<http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#ObjID_2D>";
		Set<String> result = excuteVar.instance.readPropertyValueOfInstance(
				pvIri, IRI);
		Iterator iterator = result.iterator();
		if (iterator.hasNext()) {
			idString = (String) iterator.next();
		}
		if (idString.startsWith("\"")) {
			idString = idString.split("\"")[1];
		}
		return idString;
	}

	/*
	 * ������������ʵ��֮��ľ���
	 */
	private double Distance(String iri1, String iri2) {
		return 5;
	}

	/*
	 * ������������ʵ��֮��ĽǶ�
	 */
	private double Direction(String iri1, String iri2) {
		return 360;
	}

	/*
	 * �ж���������ʵ��֮���Ƿ���ڶ���Ĺ�ϵ
	 */
	private boolean Opposite(String iri1, String iri2) {
		// ����Ҫ�õ�iri1��iri2�����ʵ�������ݿ��д洢��id
		String ID1 = IriToID(iri1);
		String ID2 = IriToID(iri2);
		// System.out.print(ID1+","+ID2);
		SpatialCompute spatialCompute = new SpatialCompute("Opposite");
		boolean result = false;
		try {
			result = spatialCompute.judge(ID1, ID2);
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
		return result;
	}

	/*
	 * ����õ����������ı���ʵ���ж����ϵ�ı���ʵ���ļ��ϣ���iri��ʾ
	 */
	private Set<String> Opposite(String iri1) {
		Set<String> oppositeSet = new HashSet<String>();
		// ���ص��������ݿ��д洢��id����ô���iri
		return oppositeSet;
	}

	/*
	 * �ж���������ʵ��֮���Ƿ�������ڵĹ�ϵ
	 */
	private boolean Adjacent(String iri1, String iri2) {
		return true;
	}

	/*
	 * ����õ����������ı���ʵ�������ڹ�ϵ�ı���ʵ���ļ��ϣ���iri��ʾ
	 */
	private Set<String> Adjacent(String iri1) {
		Set<String> oppositeSet = new HashSet<String>();
		return oppositeSet;
	}

	/*
	 * �ж���������ʵ��֮���Ƿ���ڰ����Ĺ�ϵ��iri1�����ʵ������iri2�����ʵ����
	 */
	private boolean Contained(String iri1, String iri2) {
		return true;
	}

	/*
	 * ����õ�����iri1�����ʵ���ı���ʵ���ļ��ϣ���iri��ʾ
	 */
	private Set<String> Contain(String iri1) {
		Set<String> oppositeSet = new HashSet<String>();
		return oppositeSet;
	}
}
