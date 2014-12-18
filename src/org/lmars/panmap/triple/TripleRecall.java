package org.lmars.panmap.triple;

import java.util.Map;

import org.lmars.panmap.exception.NoPropertyException;
import org.lmars.panmap.exception.OntoNotDefineExcetion;
import org.lmars.panmap.exception.UnkownTripleTypeException;
import org.lmars.panmap.exception.VarNotDefineException;
import org.lmars.panmap.parser.ParseExcuteVar;

public class TripleRecall {

	/*
	 * �������� ���ɲ�ͬ�Ĳ���ʵ��
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
	 * ���ݲ�ͬ�Ĳ��Ե��ò�ͬ���Ե�ִ�к���
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
			throw new UnkownTripleTypeException("����Ϊֵ��δ֪����Ԫ������");
		}
	}

	/*
	 * ���ݴ���Ĳ������жϻ�����Ԫ��������һ������
	 */

	private int judge_triple_condition(Map<String, String> paramMap)
			throws VarNotDefineException {

		int resultType = 0;

		if (paramMap.get("Subject").startsWith("?")
				&& paramMap.get("Object").startsWith("?")) {
			// �ж���������FilterVars�г��ֹ��ұ���û����Filter�г���,���������3
			if (excuteVar.GetFilterValue(paramMap.get("Subject")) != null
					&& excuteVar.GetFilterValue(paramMap.get("Object")) == null) {
				resultType = 3;
				filterStr = paramMap.get("Object");

			} else if (excuteVar.GetFilterValue(paramMap.get("Subject")) == null
					&& excuteVar.GetFilterValue(paramMap.get("Object")) != null) {// �ж�������û����FilterVars�г��ֹ��ұ�����Filter�г���,���������2
				resultType = 2;
				filterStr = paramMap.get("Subject");
			} else {
				resultType = 1;

			}
		}

		return resultType;//
	}

	public TripleStrategy triple = null;
	private String filterStr;// ��ʾ��ǰ���ݵ���Ԫ��Ҫ���뵽filtervars�еı���������
	public ParseExcuteVar excuteVar = ParseExcuteVar.getexcuteVar();
}
