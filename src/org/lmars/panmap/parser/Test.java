package org.lmars.panmap.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.lmars.panmap.exception.NoPropertyException;

public class Test {

	public static void main(String[] args) throws Exception {
		
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
		//遍历树的类
		String[] testNameStrings ={
				"查询与朱老师办公室对面的老师:\n","查询朱老师的所有学生:\n","查询朱老师的办公室:\n","查询办公室在一楼的老师:\n","查询三楼的朱老师学生所在机房:\n"
		};
	
		String[] testStr = { 
				//查询“与朱老师办公室对面的老师”
				"PREFIX Room: <http://example.org/IndoorSchema/Room#>"
				+ "PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
				+ "PREFIX InR: <http://example.org/IndoorRelation#>"
				+ "Select ?TeacherX "
				+ "Where"
				+ "{"
				+ "?Teacher_Zhu Teacher:Name \"朱欣焰\" ."
				+ "?Teacher_Zhu  Teacher:Has_Office ?Room_Zhu ."
				+ "?TeacherX   Teacher:Has_Office ?Room_X ."
				+ "FILTER (Opposite(?Room_X,?Room_Zhu)) ."
				+ "}"
				,
				//查询朱老师的所有学生
				"PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
				+ "Select ?Student_Zhu "
				+ "Where"
				+ "{"
				+ "?Teacher_Zhu Teacher:Name \"朱欣焰\" ."
				+ "?Teacher_Zhu  Teacher:Teach ?Student_Zhu ."
				
				+ "}"
				,
				//查询朱老师的办公室
				"PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
						+ "Select ?room "
						+ "Where"
						+ "{"
						+ "?Teacher Teacher:Name \"朱欣焰\" ."
						+ "?Teacher Teacher:Has_Office ?room ."											
						+ "}"
				,
				//查询办公室在一楼的老师
				"PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
						+ "Select ?Teacher "
						+ "Where"
						+ "{"
						+ "?Teacher Teacher:LevelNo ?Level ."
						+"FILTER (?Level<2) ."										
						+ "}"
				,
				//查询三楼的朱老师学生所在机房
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

}
