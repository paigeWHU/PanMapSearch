package org.lmars.panmap.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) throws Exception {
		
		
		
		//�����쳣��
		int[] test = null;
		try {
			for (int i = 0; i < test.length; i++) {
				
			}
		}catch(NullPointerException e){
			System.out.print("��ָ��");
			return;
			//test = new int[10];
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.print("ahaha");
		
		
		
		
		
		
		
		
		GrammarParser grammarParser = new GrammarParser();
		//����������
		String[] testNameStrings ={
				"��ѯ������ʦ�칫�Ҷ������ʦ:\n","��ѯ����ʦ������ѧ��:\n","��ѯ����ʦ�İ칫��:\n","��ѯ�칫����һ¥����ʦ:\n","��ѯһ¥������ʦѧ�����ڻ���:\n"
		};
	
		String[] testStr = { 
				//��ѯ��������ʦ�칫�Ҷ������ʦ��
				"PREFIX Room: <http://example.org/IndoorSchema/Room#>"
				+ "PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
				+ "PREFIX InR: <http://example.org/IndoorRelation#>"
				+ "Select ?TeacherX "
				+ "Where"
				+ "{"
				+ "?Teacher_Zhu Teacher:Name \"������\" ."
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
				+ "?Teacher_Zhu Teacher:Name \"������\" ."
				+ "?Teacher_Zhu  Teacher:Teach ?Student_Zhu ."
				
				+ "}"
				,
				//��ѯ����ʦ�İ칫��
				"PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
						+ "Select ?room "
						+ "Where"
						+ "{"
						+ "?Teacher Teacher:Name \"������\" ."
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
				//��ѯһ¥������ʦѧ�����ڻ���
				"PREFIX Student: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Student>"
						+ "PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
						+ "PREFIX ComputerRoom: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#ComputerRoom>"
						+ "Select ?Room_X "
						+ "Where"
						+ "{"
						+ "?Teacher_Zhu Teacher:LevelNo \"2\" ."
						+ "?Teacher_Zhu  Teacher:Teach ?Student_Zhu ."
						+ "?Student_Zhu  Student:Locate_ComputerRoom ?Room_X ."
						+ "?Room_X  ComputerRoom:LevelNo ?Level_X ."
						+ "FILTER (?Level_X=1) ."
						+ "}"
//										     	
		};

		for (int i = 0; i < testStr.length; i++) {
		//	System.out.print(testNameStrings[i]);
		//	grammarParser.run(testStr[i]);
		}

	}
}
