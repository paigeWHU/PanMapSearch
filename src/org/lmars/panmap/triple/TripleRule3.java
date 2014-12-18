package org.lmars.panmap.triple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.lmars.panmap.exception.NoPropertyException;
import org.lmars.panmap.exception.OntoNotDefineExcetion;
import org.lmars.panmap.parser.Variable;

public class TripleRule3 extends TripleStrategy {

	public TripleRule3(Map<String, String> triplemap) {
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
		// 首先判断已知变量的Set是否为空，若为空，则进行求值，并为其赋值到Vars
		Set<String> subSet = excuteVar.GetValue(subjectString);
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

		Set<String> tempIri = new HashSet<String>();
		if (subSet == null && excuteVar.GetSelect(subjectString)) {
			tempIri = excuteVar.instance.readAllInstancesOfClass(subIriString);
			excuteVar.SetValue(subjectString, tempIri);
			subSet = excuteVar.GetValue(subjectString);

		}

		// 得到属性iri
		Set<String> var1Iri = new HashSet<String>();

		String pvIri = subIriString.split("#")[0] + "#" + propertyString + ">";
		boolean IsDataPro = excuteVar.instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = excuteVar.instance.readExistObjectProperty(pvIri);
		if (!IsObjectPro && !IsDataPro) {
			throw new NoPropertyException("实例" + subjectString + "不存在"
					+ propertyString + "属性！");
		}
		try {
			Iterator<String> it1 = subSet.iterator();
			while (it1.hasNext()) {
				String string = (String) it1.next();
				Set<String> setResult = excuteVar.instance
						.readPropertyValueOfInstance(pvIri, string);

				try {
					Iterator iterator = setResult.iterator();
					while (iterator.hasNext()) {
						var1Iri.add((String) iterator.next());
					}
				} catch (NullPointerException e) {
					// TODO: handle exception
					continue;
					// throw new
					// NoPropertyException("实例"+string+"不存在"+propertyString+"属性！");
				} finally {
					continue;
				}

			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("本体" + prifixString + "定义错误或者主语变量"
					+ subjectString + "错误！");
		}

		Map<String, Set<String>> var1Map = new HashMap<String, Set<String>>();
		var1Map.put(objectString, var1Iri);
		Variable var1 = new Variable(objectString, var1Map);
		// 最终求出待求变量，并将其保存
		excuteVar.AddVars(objectString, var1);
		excuteVar.SetValue(objectString, var1Iri);
	}

}
