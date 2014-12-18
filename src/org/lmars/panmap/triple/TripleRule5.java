package org.lmars.panmap.triple;

import java.util.Map;
import java.util.Set;

import org.lmars.panmap.exception.NoPropertyException;
import org.lmars.panmap.exception.OntoNotDefineExcetion;
import org.lmars.panmap.exception.UnkownTripleTypeException;

public class TripleRule5 extends TripleStrategy {

	public TripleRule5(Map<String, String> triplemap) {
		super(triplemap);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tripleExcute() throws OntoNotDefineExcetion,
			NoPropertyException, UnkownTripleTypeException {
		// TODO Auto-generated method stub

		String subjectString = tripleMap.get("Subject");
		String prifixString = tripleMap.get("Prefix");
		String propertyString = tripleMap.get("Property");
		String objectString = tripleMap.get("Object");

		// 求出主语已知变量的值
		Set<String> subSet = excuteVar.GetValue(subjectString);
		// 求出宾语已知变量的值
		Set<String> objSet = excuteVar.GetValue(objectString);

		if (subSet == null && objSet != null) {
			TripleStrategy triple = new TripleRule1(tripleMap);
			triple.tripleExcute();
		} else if (subSet != null && objSet == null) {

			TripleStrategy triple = new TripleRule3(tripleMap);
			triple.tripleExcute();
		} else if (subSet == null && objSet == null) {
			TripleStrategy triple = new TripleRule3(tripleMap);
			triple.tripleExcute();
		} else {
			// 抛出异常
			throw new UnkownTripleTypeException("主语宾语均为已知，未知的三元组类型");

		}
	}

}
