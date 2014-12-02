package org.lmars.panmap.parser;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.lmars.panmap.exception.NoPropertyException;
import org.lmars.panmap.geo.GeoLineString;
import org.lmars.panmap.geo.GeoMultiLineString;
import org.lmars.panmap.geo.GeoMultiPolygon;
import org.lmars.panmap.geo.GeoPoint;
import org.lmars.panmap.geo.GeoPolygon;
import org.lmars.panmap.geo.Geometry;
import org.lmars.panmap.geo.GeometryFactory;
import org.lmars.panmap.geo.MyPoint;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

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



//		SpatialSelect spatialSelect = new SpatialSelect();
//		
//		
//				
//		Geometry geometry =  spatialSelect.GetGeometry("1");
//		String typeString = geometry.geometryType.toString();
//		System.out.print(typeString);
//		switch (typeString) {
//		case "MultiLineString":
//			System.out.print(String.valueOf(((GeoMultiLineString)geometry).geoLineStrings.get(0).linePoints.get(0).x)+"\n");
//			break;
//		case "Point":
//			System.out.print(String.valueOf(((GeoPoint)geometry).point.x));
//			break;
//		case "LineString":
//			System.out.print(String.valueOf(((GeoLineString)geometry).linePoints.get(0).x));
//			break;
//		case "Polygon":
//			System.out.print(String.valueOf(((GeoPolygon)geometry).polygonRings.get(0).ringPoints.get(0).x));
//			break;
//		case "MultiPolygon":
//			GeoMultiPolygon geoPolygons = (GeoMultiPolygon)geometry;
//			System.out.print(String.valueOf(geoPolygons.geoPolygons.get(0).polygonRings.get(0).ringPoints.get(0).x));	
//		default:
//			break;
//		}
//		
	
		
		
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

		for (int i = 0; i < 1; i++) {
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
