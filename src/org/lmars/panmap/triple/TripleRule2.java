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
		// ���ȵõ���֪������Set<String>
		Set<String> objectSet = excuteVar.GetValue(objectString);

		// ��objectSetΪ�ս�objectSet��ֵΪowl����ȫ����ʵ��
		boolean isObjNull = false;
		if (objectSet == null && excuteVar.GetSelect(objectString)) {
			isObjNull = true;// Ϊ��
			objectSet = excuteVar.instance.readAllInstances();
		}

		// �õ������iri
		String subIriString = "";
		Set<String> set = excuteVar.GetValue(prifixString);
		try {
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				subIriString = it.next();

			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("ʵ��" + prifixString + "δ���壡");
		}

		// �õ���������Ĺ���ǰ��ʵ��
		if (excuteVar.GetValue(subjectString) != null) {

			tempIri = excuteVar.GetValue(subjectString);

		} else {
			tempIri = excuteVar.instance.readAllInstancesOfClass(subIriString);
		}

		// �õ����Ե�iri
		String pvIri = subIriString.split("#")[0] + "#" + propertyString + ">";
		boolean IsDataPro = excuteVar.instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = excuteVar.instance.readExistObjectProperty(pvIri);
		if (!IsObjectPro && !IsDataPro) {
			throw new NoPropertyException("ʵ��" + subjectString + "������"
					+ propertyString + "���ԣ�");
		}
		try {
			// ����tempIri�ҵ���������Ҫ���ʵ��
			Iterator<String> iterator = tempIri.iterator();

			while (objectSet.size() != 0 && iterator.hasNext()) {
				String string = (String) iterator.next();// ����ʵ��
				Set<String> setResult = excuteVar.instance
						.readPropertyValueOfInstance(pvIri, string);
				if (setResult.size() == 0) {
					continue;
					// throw new
					// NoPropertyException("ʵ��"+string+"������"+propertyString+"���ԣ�");

				}

				if (SetContains(objectSet, setResult)) {
					var1Iri.add(string);
				}

			}

		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("����" + prifixString + "�����������������"
					+ subjectString + "����");
		}

		Map<String, Set<String>> var1Map = new HashMap<String, Set<String>>();
		var1Map.put(subjectString, var1Iri);
		Variable var1 = new Variable(subjectString, var1Map);
		// ���������������������䱣��
		excuteVar.AddVars(subjectString, var1);

		excuteVar.SetValue(subjectString, var1Iri);
	}

}
