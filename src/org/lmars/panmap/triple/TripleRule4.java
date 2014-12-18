package org.lmars.panmap.triple;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.lmars.panmap.exception.NoPropertyException;
import org.lmars.panmap.exception.OntoNotDefineExcetion;

public class TripleRule4 extends TripleStrategy {

	public TripleRule4(Map<String, String> triplemap) {
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
		Set<String> var1Iri = new HashSet<String>();
		Set<String> subIri = new HashSet<String>();
		// 得到本体iri
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

		// 得到属性的iri
		String pvIri = subIriString.split("#")[0] + "#" + propertyString + ">";
		boolean IsDataPro = excuteVar.instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = excuteVar.instance.readExistObjectProperty(pvIri);
		if (!IsObjectPro && !IsDataPro) {
			throw new NoPropertyException("实例" + subjectString + "不存在"
					+ propertyString + "属性！");
		}
		// 得到已知变量的值
		subIri = excuteVar.GetValue(subjectString);
		if (subIri == null && excuteVar.GetSelect(subjectString)) {
			// 如果已知变量是select的变量且一直未被赋值则对其进行初始化
			subIri = excuteVar.instance.readAllInstancesOfClass(subIriString);

			excuteVar.SetValue(subjectString, subIri);

		}

		// 遍历subIri 看实例的property属性是否为值 是的话加入到var1Iri
		try {
			Iterator<String> iterator = subIri.iterator();
			while (iterator.hasNext()) {
				String string = iterator.next();
				// 看实例的property属性是否为值 是的话加入到var1Iri
				Set<String> setResult = excuteVar.instance
						.readPropertyValueOfInstance(pvIri, string);
				if (setResult.size() == 0) {

					setResult = null;
				}

				// 得到结果组成的字符串
				String resultString = "";
				try {

					Iterator iteratorResult = setResult.iterator();
					while (iteratorResult.hasNext()) {
						String tempString = (String) iteratorResult.next();
						resultString = resultString + tempString;
						if (iteratorResult.hasNext()) {
							resultString += ",";
						}
					}

					if (resultString.equals(objectString)) {

						var1Iri.add(string);
					}
				} catch (NullPointerException e) {
					// TODO: handle exception
					continue;
					// throw new
					// NoPropertyException("实例"+string+"不存在"+propertyString+"属性！");
				}

			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("本体" + prifixString + "定义错误或者主语变量"
					+ subjectString + "错误！");
		}

		// 更新已知变量的值
		excuteVar.SetValue(subjectString, var1Iri);
	}

}
