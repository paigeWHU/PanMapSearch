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
		// �õ�����iri
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

		// �õ����Ե�iri
		String pvIri = subIriString.split("#")[0] + "#" + propertyString + ">";
		boolean IsDataPro = excuteVar.instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = excuteVar.instance.readExistObjectProperty(pvIri);
		if (!IsObjectPro && !IsDataPro) {
			throw new NoPropertyException("ʵ��" + subjectString + "������"
					+ propertyString + "���ԣ�");
		}
		// �õ���֪������ֵ
		subIri = excuteVar.GetValue(subjectString);
		if (subIri == null && excuteVar.GetSelect(subjectString)) {
			// �����֪������select�ı�����һֱδ����ֵ�������г�ʼ��
			subIri = excuteVar.instance.readAllInstancesOfClass(subIriString);

			excuteVar.SetValue(subjectString, subIri);

		}

		// ����subIri ��ʵ����property�����Ƿ�Ϊֵ �ǵĻ����뵽var1Iri
		try {
			Iterator<String> iterator = subIri.iterator();
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
					// TODO: handle exception
					continue;
					// throw new
					// NoPropertyException("ʵ��"+string+"������"+propertyString+"���ԣ�");
				}

			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("����" + prifixString + "�����������������"
					+ subjectString + "����");
		}

		// ������֪������ֵ
		excuteVar.SetValue(subjectString, var1Iri);
	}

}
