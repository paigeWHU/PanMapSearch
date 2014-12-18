package org.lmars.panmap.triple;

import java.util.Map;

import org.apache.commons.lang.ObjectUtils.Null;
import org.lmars.panmap.exception.NoPropertyException;
import org.lmars.panmap.exception.OntoNotDefineExcetion;
import org.lmars.panmap.exception.UnkownTripleTypeException;
import org.lmars.panmap.parser.ParseExcuteVar;

public class Triple {

	/*
	 * 根据类型 生成不同的策略实例
	 */
	public Triple(Map<String, String> paramMap)
			throws UnkownTripleTypeException {
		// TODO Auto-generated constructor stub
		int triplerule = judge_triple_condition(paramMap);
		switch (triplerule) {
		case 1:/*
				 * 执行第一种语法规则的三元组查询函数:1、 待求变量+属性+值
				 */
			triple = new TripleRule1(paramMap);
			break;
		case 2:/*
				 * 执行第一种语法规则的三元组查询函数:2、 待求变量+属性+已知变量
				 */
			triple = new TripleRule2(paramMap);
			break;
		case 3:/*
				 * 行第一种语法规则的三元组查询函数:3、 已知变量+属性+待求变量
				 */
			triple = new TripleRule3(paramMap);
			break;
		case 4:/*
				 * 行第一种语法规则的三元组查询函数:4、 已知变量+属性+值
				 */
			triple = new TripleRule4(paramMap);
			break;
		case 5:/*
				 * 第一种语法规则的三元组查询函数:5、 已知变量+属性+已知变量
				 */
			triple = new TripleRule5(paramMap);
			break;
		case 6:
			throw new UnkownTripleTypeException("主语宾语均为值，未知的三元组类型");
		case 7:
			throw new UnkownTripleTypeException("主语为值，未知的三元组类型");
		case 8:
			throw new UnkownTripleTypeException("主语宾语均为待求变量，未知的三元组类型");
		case 9:
			throw new UnkownTripleTypeException("主语为值，未知的三元组类型");
		default:
			break;
		}

	}

	/*
	 * 根据不同的策略调用不同策略的执行函数
	 */
	public void tripleExcute() throws OntoNotDefineExcetion,
			NoPropertyException, UnkownTripleTypeException {

		try {
			triple.tripleExcute();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			throw new UnkownTripleTypeException("主语为值，未知的三元组类型");
		}
	}

	/*
	 * 根据传入的参数来判断三元组属于哪一种类型
	 */

	private int judge_triple_condition(Map<String, String> paramMap) {

		// 1:待求变量 2：已知变量 3：值
		String var1 = paramMap.get("Subject");
		String var2 = paramMap.get("Object");

		int type1 = 0, type2 = 0;// 分别代表第一个和第二个元素的类型
		int resultType = 0;// 代表三元组的类型

		// 得到第一个元素的类型
		if (var1.charAt(0) == '?') {// 说明一定是变量，待求变量或者已知变量
			if (excuteVar.GetValue(var1) != null || excuteVar.GetSelect(var1)) {

				// 从Vars中寻找，若没有找到说明一定是待求变量，否则为已知变量
				type1 = 2;
			} else {
				type1 = 1;
			}
		} else {
			type1 = 3;// 变量类型为值
		}

		// 得到第一个元素的类型
		if (var2.charAt(0) == '?') {// 说明一定是变量，待求变量或者已知变量
			if (excuteVar.GetValue(var2) != null || excuteVar.GetSelect(var2)) {
				// 从Vars中寻找，若没有找到说明一定是待求变量，否则为已知变量
				type2 = 2;
			} else {
				type2 = 1;// 已知变量
			}
		} else {
			type2 = 3;// 变量类型为值
		}
		if (type1 == 1 && type2 == 3) {
			resultType = 1;
		} else if (type1 == 1 && type2 == 2) {
			resultType = 2;
		} else if (type1 == 2 && type2 == 1) {
			resultType = 3;
		} else if (type1 == 2 && type2 == 3) {
			resultType = 4;
		} else if (type1 == 2 && type2 == 2) {
			resultType = 5;
		} else if (type1 == 3 && type2 == 3) {
			resultType = 6;
		} else if (type1 == 3 && type2 == 2) {
			resultType = 7;
		} else if (type1 == 1 && type2 == 1) {
			resultType = 8;
		} else if (type1 == 3 && type2 == 1) {
			resultType = 9;
		}

		return resultType;//
	}

	public TripleStrategy triple = null;
	public ParseExcuteVar excuteVar = ParseExcuteVar.getexcuteVar();
}
