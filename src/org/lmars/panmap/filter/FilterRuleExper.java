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
		case 0:// 表达式约束
			result = Boolean.parseBoolean(filter_excute_exper(ctx.constraint()
					.expression()));
			break;
		case 1:
			// 函数约束
			// 得到函数的名称，得到参数的个数，得到参数的名称，然后调用相应的函数进行查询
			Map<String, String> funcMap = new HashMap<String, String>();
			// 得到函数名称 只考虑一个函数名称
			String funcnameString = ctx.constraint().functionList().function()
					.get(0).ID().getText();
			// 得到参数个数
			String paramscountString = Integer.toString(ctx.constraint()
					.functionList().function().get(0).paramDeclList()
					.expression().size());
			// 得到参数名称字符串
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

		// 得到当前操作符语句的操作符
		String operation;
		// 表示两个操作符的值，用字符串表示，结果只有boolean好double两种情况，但都用string类型来表示
		String str_result_left, str_result_right;

		if (expression.getChildCount() == 3) {
			operation = expression.getChild(1).getText();
			str_result_left = filter_excute_exper(expression.getChild(0));// 求得第一个操作数的值
			str_result_right = filter_excute_exper(expression.getChild(2));// 求得第二个操作数的值

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
			str_result_left = filter_excute_exper(expression.getChild(1));// 求得操作数的值
			switch (operation) {
			case "!":
				boolean temp = !Boolean.parseBoolean(str_result_left);
				return String.valueOf(temp);

			default:
				break;
			}
		}
		if (expression.getChildCount() == 1) {

			// 此时的expression有两种情况 第一种情况exprassion是一个值，第二种情况expression是一个函数
			// 获取primaryExpression节点，判断他的类型：function numericLiteral rdfLiteral
			// boolean
			if (expression.getChild(0).getChild(0).getChildCount() > 1) {// 类型为函数
				// 调用函数查询函数

				// 得到函数的名称，得到参数的个数，得到参数的名称，然后调用相应的函数进行查询
				Map<String, String> funcMap = new HashMap<String, String>();
				// 得到函数名称 只考虑一个函数名称
				String funcnameString = expression.getChild(0).getChild(0)
						.getChild(0).getText();
				String paramsString = "";
				if (expression.getChild(0).getChild(0).getChildCount() > 2) {
					// 得到参数名称字符串
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
				// 类型为数值、字符串,均返回字符串类型
				// 类型也有可能是iri的变量
				// 则根据index进行取值，返回读取到的结果
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
	 * 总的函数约束的执行函数，包括首先要判断函数约束的类型，再调用相应的函数
	 */
	private String filter_excute_func(Map<String, String> args)
			throws NoSelectVarException {
		// 首先判断函数的名称
		String funcNameString = args.get("FuncName");// 函数的名称
		String paramString = args.get("Params");
		String[] paramsString = paramString.split(",");// 存储参数名称的字符串数组

		int paramsCount = paramsString.length;
		// 取出每一个参数的iri
		String var1iriString = "";
		String var2iriString = "";

		var1iriString = excuteVar.find_i_iri(paramsString[0]);// 此时的结果是一个set<String>形成的字符串
		var2iriString = excuteVar.find_i_iri(paramsString[1]);
		if (Pattern.compile("opposite", Pattern.CASE_INSENSITIVE)
				.matcher(funcNameString).find()) {
			// 调用的opposite函数
			if (paramsCount == 2) {
				return String.valueOf(Opposite(var1iriString, var2iriString));
				// 两个参数用来判断 返回true false 判断两个实例是否有对面的关系
			}
		} else if (Pattern.compile("Adjacent", Pattern.CASE_INSENSITIVE)
				.matcher(funcNameString).find()) {
			// 调用的Adjacent函数
			if (paramsCount == 2) {
				// 两个参数用来判断 返回true false 判断两个实例是否有相邻的关系
			}
		} else if (Pattern.compile("Contained", Pattern.CASE_INSENSITIVE)
				.matcher(funcNameString).find()) {
			// 调用的Contained函数

			// 两个参数用来判断 返回true false 判断两个实例是否有包含的关系 第一个参数包含第二个参数

		} else if (Pattern.compile("Contain", Pattern.CASE_INSENSITIVE)
				.matcher(funcNameString).find()) {
			// 调用的Contain函数
		} else if (Pattern.compile("Distance", Pattern.CASE_INSENSITIVE)
				.matcher(funcNameString).find()) {
			// 调用的Distance函数
			// 一定是两个参数
			return "5";
		} else if (Pattern.compile("Direction", Pattern.CASE_INSENSITIVE)
				.matcher(funcNameString).find()) {
			// 调用的Direction函数
			// 一定是两个参数
		}

		return null;
	}

	/*
	 * 判断约束语句的类型
	 */
	private int judge_filter_condition(SparqlParser.FilterContext ctx) {
		int type = 0;

		// 判断是函数约束还是操作符约束
		// 若为函数约束，则得到函数名，参数的值（通过index得到，应当只有一个实例），调用函数约束执行函数filter_execute_funcRule1得到true或者false来判断当前的index是否满足要求
		// 若为操作符约束，则直接调用excute_tree_exper函数得到true或者false来判断当前的index是否满足要求
		if (ctx.constraint().expression() != null) {
			// 操作符约束，调用excute_tree_exper
			return 0;
		} else if (ctx.constraint().functionList() != null) {
			// 函数约束
			return 1;
		}

		return type;
	}

	/*
	 * 根据房间iri得到在数据库中保存的id值
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
	 * 计算两个本体实例之间的距离
	 */
	private double Distance(String iri1, String iri2) {
		return 5;
	}

	/*
	 * 计算两个本体实例之间的角度
	 */
	private double Direction(String iri1, String iri2) {
		return 360;
	}

	/*
	 * 判断两个本体实例之间是否存在对面的关系
	 */
	private boolean Opposite(String iri1, String iri2) {
		// 首先要得到iri1、iri2代表的实例在数据库中存储的id
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
	 * 计算得到与参数代表的本体实例有对面关系的本体实例的集合，由iri表示
	 */
	private Set<String> Opposite(String iri1) {
		Set<String> oppositeSet = new HashSet<String>();
		// 返回的是在数据库中存储的id，怎么变成iri
		return oppositeSet;
	}

	/*
	 * 判断两个本体实例之间是否存在相邻的关系
	 */
	private boolean Adjacent(String iri1, String iri2) {
		return true;
	}

	/*
	 * 计算得到与参数代表的本体实例有相邻关系的本体实例的集合，由iri表示
	 */
	private Set<String> Adjacent(String iri1) {
		Set<String> oppositeSet = new HashSet<String>();
		return oppositeSet;
	}

	/*
	 * 判断两个本体实例之间是否存在包含的关系（iri1代表的实例包含iri2代表的实例）
	 */
	private boolean Contained(String iri1, String iri2) {
		return true;
	}

	/*
	 * 计算得到包含iri1代表的实例的本体实例的集合，由iri表示
	 */
	private Set<String> Contain(String iri1) {
		Set<String> oppositeSet = new HashSet<String>();
		return oppositeSet;
	}
}
