package org.lmars.panmap.triple;

import java.util.Map;

import org.lmars.panmap.exception.NoPropertyException;
import org.lmars.panmap.exception.OntoNotDefineExcetion;
import org.lmars.panmap.exception.UnkownTripleTypeException;
import org.lmars.panmap.exception.VarNotDefineException;
import org.lmars.panmap.parser.ParseExcuteVar;

public class TripleRecall {

	/*
	 * 根据类型 生成不同的策略实例
	 */
	public TripleRecall(Map<String, String> paramMap)
			throws UnkownTripleTypeException, VarNotDefineException {
		// TODO Auto-generated constructor stub
		int triplerule = judge_triple_condition(paramMap);
		switch (triplerule) {
		case 1:

			triple = null;
			break;
		case 2:
			triple = new TripleRule2(paramMap);
			break;
		case 3:
			triple = new TripleRule3(paramMap);
			break;

		default:
			break;
		}

	}

	/*
	 * 根据不同的策略调用不同策略的执行函数
	 */
	public void tripleExcute() throws OntoNotDefineExcetion,
			NoPropertyException, UnkownTripleTypeException,
			VarNotDefineException {

		if (triple == null) {
			return;
		}
		try {
			triple.tripleExcute();
			excuteVar.AddFikterVars(filterStr, excuteVar.GetVarsVar(filterStr));
			return;

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			throw new UnkownTripleTypeException("主语为值，未知的三元组类型");
		}
	}

	/*
	 * 根据传入的参数来判断回溯三元组属于哪一种类型
	 */

	private int judge_triple_condition(Map<String, String> paramMap)
			throws VarNotDefineException {

		int resultType = 0;

		if (paramMap.get("Subject").startsWith("?")
				&& paramMap.get("Object").startsWith("?")) {
			// 判断若主语在FilterVars中出现过且宾语没有在Filter中出现,则调用类型3
			if (excuteVar.GetFilterValue(paramMap.get("Subject")) != null
					&& excuteVar.GetFilterValue(paramMap.get("Object")) == null) {
				resultType = 3;
				filterStr = paramMap.get("Object");

			} else if (excuteVar.GetFilterValue(paramMap.get("Subject")) == null
					&& excuteVar.GetFilterValue(paramMap.get("Object")) != null) {// 判断若主语没有在FilterVars中出现过且宾语在Filter中出现,则调用类型2
				resultType = 2;
				filterStr = paramMap.get("Subject");
			} else {
				resultType = 1;

			}
		}

		return resultType;//
	}

	public TripleStrategy triple = null;
	private String filterStr;// 表示当前回溯的三元组要加入到filtervars中的变量的名称
	public ParseExcuteVar excuteVar = ParseExcuteVar.getexcuteVar();
}
