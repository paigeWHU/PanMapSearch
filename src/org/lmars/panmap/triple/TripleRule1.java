package org.lmars.panmap.triple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.lmars.panmap.exception.*;
import org.lmars.panmap.exception.NoPropertyException;
import org.lmars.panmap.exception.OntoNotDefineExcetion;
import org.lmars.panmap.parser.ParseExcuteVar;
import org.lmars.panmap.parser.Variable;

public class TripleRule1 extends TripleStrategy {

	public TripleRule1(Map<String, String> triplemap) {
		super(triplemap);
		// TODO Auto-generated constructor stub
	}

	public TripleRule1(String sub, String pre, String pro, String obj) {
		// TODO Auto-generated constructor stub
		super(sub, pre, pro, obj);

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
		Set<String> tempIri = new HashSet<String>();
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
			throw new OntoNotDefineExcetion("����" + prifixString + "δ���壡");
		}

		// �õ����Ե�iri
		String pvIri = subIriString.split("#")[0] + "#" + propertyString + ">";
		boolean IsDataPro = excuteVar.instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = excuteVar.instance.readExistObjectProperty(pvIri);

		if (!IsObjectPro && !IsDataPro) {

			throw new NoPropertyException("ʵ��" + subjectString + "������"
					+ propertyString + "���ԣ�");
		}

		// �������������ʵ����ֵ��tempIri
		if (excuteVar.GetValue(subjectString) != null) {

			tempIri = excuteVar.GetValue(subjectString);
		} else {
			tempIri = excuteVar.instance.readAllInstancesOfClass(subIriString);
		}

		try {
			// ����tempIri ��ʵ����property�����Ƿ�Ϊֵ �ǵĻ����뵽var1Iri
			Iterator<String> iterator = tempIri.iterator();
			while (iterator.hasNext()) {

				String string = iterator.next();

				// ��ʵ����property�����Ƿ�Ϊֵ �ǵĻ����뵽var1Iri
				Set<String> setResult = excuteVar.instance
						.readPropertyValueOfInstance(pvIri, string);
				if (setResult.size() == 0) {
					setResult = null;
				}
				// �õ������ɵ��ַ���
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
					continue;
					// TODO: handle exception
					// throw new
					// NoPropertyException("ʵ��"+string+"������"+propertyString+"���ԣ�");
				}

			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("����" + prifixString + "�����������������"
					+ subjectString + "����");
		}

		// ��ӱ�����Vars
		Map<String, Set<String>> var1Map = new HashMap<String, Set<String>>();
		var1Map.put(subjectString, var1Iri);
		Variable var1 = new Variable(subjectString, var1Map);
		// ���������������������䱣��
		excuteVar.AddVars(subjectString, var1);
		excuteVar.SetValue(subjectString, var1Iri);
	}

}
