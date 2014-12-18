package org.lmars.panmap.triple;

import java.util.Map;

import org.apache.commons.lang.ObjectUtils.Null;
import org.lmars.panmap.exception.NoPropertyException;
import org.lmars.panmap.exception.OntoNotDefineExcetion;
import org.lmars.panmap.exception.UnkownTripleTypeException;
import org.lmars.panmap.parser.ParseExcuteVar;

public class Triple {

	/*
	 * �������� ���ɲ�ͬ�Ĳ���ʵ��
	 */
	public Triple(Map<String, String> paramMap)
			throws UnkownTripleTypeException {
		// TODO Auto-generated constructor stub
		int triplerule = judge_triple_condition(paramMap);
		switch (triplerule) {
		case 1:/*
				 * ִ�е�һ���﷨�������Ԫ���ѯ����:1�� �������+����+ֵ
				 */
			triple = new TripleRule1(paramMap);
			break;
		case 2:/*
				 * ִ�е�һ���﷨�������Ԫ���ѯ����:2�� �������+����+��֪����
				 */
			triple = new TripleRule2(paramMap);
			break;
		case 3:/*
				 * �е�һ���﷨�������Ԫ���ѯ����:3�� ��֪����+����+�������
				 */
			triple = new TripleRule3(paramMap);
			break;
		case 4:/*
				 * �е�һ���﷨�������Ԫ���ѯ����:4�� ��֪����+����+ֵ
				 */
			triple = new TripleRule4(paramMap);
			break;
		case 5:/*
				 * ��һ���﷨�������Ԫ���ѯ����:5�� ��֪����+����+��֪����
				 */
			triple = new TripleRule5(paramMap);
			break;
		case 6:
			throw new UnkownTripleTypeException("��������Ϊֵ��δ֪����Ԫ������");
		case 7:
			throw new UnkownTripleTypeException("����Ϊֵ��δ֪����Ԫ������");
		case 8:
			throw new UnkownTripleTypeException("��������Ϊ���������δ֪����Ԫ������");
		case 9:
			throw new UnkownTripleTypeException("����Ϊֵ��δ֪����Ԫ������");
		default:
			break;
		}

	}

	/*
	 * ���ݲ�ͬ�Ĳ��Ե��ò�ͬ���Ե�ִ�к���
	 */
	public void tripleExcute() throws OntoNotDefineExcetion,
			NoPropertyException, UnkownTripleTypeException {

		try {
			triple.tripleExcute();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			throw new UnkownTripleTypeException("����Ϊֵ��δ֪����Ԫ������");
		}
	}

	/*
	 * ���ݴ���Ĳ������ж���Ԫ��������һ������
	 */

	private int judge_triple_condition(Map<String, String> paramMap) {

		// 1:������� 2����֪���� 3��ֵ
		String var1 = paramMap.get("Subject");
		String var2 = paramMap.get("Object");

		int type1 = 0, type2 = 0;// �ֱ�����һ���͵ڶ���Ԫ�ص�����
		int resultType = 0;// ������Ԫ�������

		// �õ���һ��Ԫ�ص�����
		if (var1.charAt(0) == '?') {// ˵��һ���Ǳ������������������֪����
			if (excuteVar.GetValue(var1) != null || excuteVar.GetSelect(var1)) {

				// ��Vars��Ѱ�ң���û���ҵ�˵��һ���Ǵ������������Ϊ��֪����
				type1 = 2;
			} else {
				type1 = 1;
			}
		} else {
			type1 = 3;// ��������Ϊֵ
		}

		// �õ���һ��Ԫ�ص�����
		if (var2.charAt(0) == '?') {// ˵��һ���Ǳ������������������֪����
			if (excuteVar.GetValue(var2) != null || excuteVar.GetSelect(var2)) {
				// ��Vars��Ѱ�ң���û���ҵ�˵��һ���Ǵ������������Ϊ��֪����
				type2 = 2;
			} else {
				type2 = 1;// ��֪����
			}
		} else {
			type2 = 3;// ��������Ϊֵ
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
