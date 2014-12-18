package org.lmars.panmap.triple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.lmars.panmap.exception.NoPropertyException;
import org.lmars.panmap.exception.OntoNotDefineExcetion;
import org.lmars.panmap.parser.Variable;

public class TripleRule2 extends TripleStrategy {

	public TripleRule2(Map<String, String> triplemap) {
		super(triplemap);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tripleExcute() throws OntoNotDefineExcetion,
			NoPropertyException {
		// TODO Auto-generated method stub

		String subjectString = tripleMap.get("Subject");
		String prifixString = tripleMap.get("Prefix");
		String propertyString = tripleMap.get("Property");
		String objectString = tripleMap.get("Object");
		Set<String> tempIri = new HashSet<String>();
		Set<String> var1Iri = new HashSet<String>();
		// 首先得到已知变量的Set<String>
		Set<String> objectSet = excuteVar.GetValue(objectString);

		// 当objectSet为空将objectSet赋值为owl本体全部的实例
		boolean isObjNull = false;
		if (objectSet == null && excuteVar.GetSelect(objectString)) {
			isObjNull = true;// 为空
			objectSet = excuteVar.instance.readAllInstances();
		}

		// 得到本体的iri
		String subIriString = "";
		Set<String> set = excuteVar.GetValue(prifixString);
		try {
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				subIriString = it.next();

			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("实例" + prifixString + "未定义！");
		}

		// 得到待求变量的过滤前的实例
		if (excuteVar.GetValue(subjectString) != null) {

			tempIri = excuteVar.GetValue(subjectString);

		} else {
			tempIri = excuteVar.instance.readAllInstancesOfClass(subIriString);
		}

		// 得到属性的iri
		String pvIri = subIriString.split("#")[0] + "#" + propertyString + ">";
		boolean IsDataPro = excuteVar.instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = excuteVar.instance.readExistObjectProperty(pvIri);
		if (!IsObjectPro && !IsDataPro) {
			throw new NoPropertyException("实例" + subjectString + "不存在"
					+ propertyString + "属性！");
		}
		try {
			// 遍历tempIri找到满足属性要求的实例
			Iterator<String> iterator = tempIri.iterator();

			while (objectSet.size() != 0 && iterator.hasNext()) {
				String string = (String) iterator.next();// 遍历实例
				Set<String> setResult = excuteVar.instance
						.readPropertyValueOfInstance(pvIri, string);
				if (setResult.size() == 0) {
					continue;
					// throw new
					// NoPropertyException("实例"+string+"不存在"+propertyString+"属性！");

				}

				if (SetContains(objectSet, setResult)) {
					var1Iri.add(string);
				}

			}

		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("本体" + prifixString + "定义错误或者主语变量"
					+ subjectString + "错误！");
		}

		Map<String, Set<String>> var1Map = new HashMap<String, Set<String>>();
		var1Map.put(subjectString, var1Iri);
		Variable var1 = new Variable(subjectString, var1Map);
		// 最终求出待求变量，并将其保存
		excuteVar.AddVars(subjectString, var1);

		excuteVar.SetValue(subjectString, var1Iri);
	}

}
