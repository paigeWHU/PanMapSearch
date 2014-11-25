package org.lmars.panmap.parser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.lmars.panmap.exception.NoPropertyException;

public class Test {

	public static void main(String[] args) throws Exception {
		Set<String> set = new HashSet<String>();
		set.add("<http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#205>");
		set.add("<http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#101>");
		
		Set<String> set2 = new HashSet<String>();
		set2.add("<http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#205>");
		set2.add("<http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#101>");
		Test test = new Test();
//	
//		if (test.SetContains(set2, set)) {
//			System.out.print("hahah");
//		}
//		
//		try {
//			Test test = new Test();
//			test.teset1();
//		} catch (MyException myExceptione) {
//			// TODO: handle exception
//			myExceptione.printStackTrace();
//		}

//		try {
//			Test test = new Test();
//			test.test();
//		} catch (NoPropertyException e) {
//			// TODO: handle exception
//			System.err.print(e.getMessage()+"\n");
//		
//		}



		
		
		
				
		
		
		GrammarParser grammarParser = new GrammarParser();
		//����������
		String[] testNameStrings ={
				"��ѯ������ʦ�칫�Ҷ������ʦ:\n","��ѯ����ʦ������ѧ��:\n","��ѯ����ʦ�İ칫��:\n","��ѯ�칫����һ¥����ʦ:\n","��ѯ��¥������ʦѧ�����ڻ���:\n"
		};
	
		String[] testStr = { 
				//��ѯ��������ʦ�칫�Ҷ������ʦ��
				"PREFIX Room: <http://example.org/IndoorSchema/Room#>"
				+ "PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
				+ "PREFIX InR: <http://example.org/IndoorRelation#>"
				+ "Select ?TeacherX "
				+ "Where"
				+ "{"
				+ "?Teacher_Zhu Teacher:Name \"��ά\" ."
				+ "?Teacher_Zhu  Teacher:Has_Office ?Room_Zhu ."
				+ "?TeacherX   Teacher:Has_Office ?Room_X ."
				+ "FILTER (Opposite(?Room_X,?Room_Zhu)) ."
				+ "}"
				,
				//��ѯ����ʦ������ѧ��
				"PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
				+ "Select ?Student_Zhu "
				+ "Where"
				+ "{"
				+ "?Teacher_Zhu Teacher:Name \"��ά\" ."
				+ "?Teacher_Zhu  Teacher:Teach ?Student_Zhu ."
				
				+ "}"
				,
				//��ѯ����ʦ�İ칫��
				"PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
						+ "Select ?room "
						+ "Where"
						+ "{"
						+ "?Teacher Teacher:Name \"��ά\" ."
						+ "?Teacher Teacher:Has_Office ?room ."											
						+ "}"
				,
				//��ѯ�칫����һ¥����ʦ
				"PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
						+ "Select ?Teacher "
						+ "Where"
						+ "{"
						+ "?Teacher Teacher:LevelNo ?Level ."
						+"FILTER (?Level<2) ."										
						+ "}"
				,
				//��ѯ��¥������ʦѧ�����ڻ���,�Լ�����¥��ѧ��
				"PREFIX Student: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Student>"
						+ "PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
						+ "PREFIX ComputerRoom: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#ComputerRoom>"
						+ "Select ?Room_X ?Student_Zhu "
						+ "Where"
						+ "{"
						+ "?Teacher_Zhu Teacher:LevelNo \"2\" ."
						+ "?Teacher_Zhu  Teacher:Teach ?Student_Zhu ."
						+ "?Student_Zhu  Student:Locate_ComputerRoom ?Room_X ."
						+ "?Room_X  ComputerRoom:LevelNo ?Level_X ."
						+ "FILTER (?Level_X=3) ."
						+ "}"
										     	
		};

		for (int i = 4; i < 5; i++) {
//			System.out.print(testNameStrings[i]);
			grammarParser.run(testStr[i]);
		}

	}
	
	private void test() throws NoPropertyException {
		for (int i = 0; i < 3; i++) {
			System.out.print("hahahah");
			try {
				String[] s = null;
				System.out.print(s.length);
			} catch (NullPointerException e) {
				// TODO: handle exception
				throw new NoPropertyException(String.valueOf(i));
			}finally{
				
				continue;
				
			}
		}
	}
	private boolean SetContains(Set<String>set1,Set<String>set2) {
		Iterator<String> iterator = set2.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			if (set1.contains(string)) {
				continue;
				
			}else {
				return false;
			}
		}
		return true;
	}

}
