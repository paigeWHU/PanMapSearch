package org.lmars.panmap.parser;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.lmars.panmap.parser.GrammarParser;
import org.owlapi.OWL;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import org.lmars.panmap.spatialcompute.*;

public class Test2 {

	public static void main(String[] args) throws Exception {

		GrammarParser grammarParser = new GrammarParser();
		// 遍历树的类

		String[] testStr = {
				// 查询“与朱老师办公室对面的老师,以及他的办公室”
				"PREFIX Room: <http://example.org/IndoorSchema/Room#>"
						+ "PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
						+ "PREFIX InR: <http://example.org/IndoorRelation#>"
						+ "Select ?TeacherX ?Room_X " + "Where" + "{"
						+ "?Teacher_Zhu Teacher:Name \"朱欣焰\" ."
						+ "?Teacher_Zhu  Teacher:Has_Office ?Ro" + "om_Zhu ."
						+ "?TeacherX   Teacher:Has_Office ?Room_X ."
						+ "FILTER (Opposite(?Room_X,?Room_Zhu)) ." + "}",
				// 查询朱老师的所有学生
				"PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
						+ "Select ?Student_Zhu "
						+ "Where"
						+ "{"
						+ "?Teacher_Zhu Teacher:Name \"朱欣焰\" ."
						+ "?Teacher_Zhu  Teacher:Teach ?Student_Zhu ."

						+ "}",
				// 查询朱老师的办公室
				"PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
						+ "Select ?room "
						+ "Where"
						+ "{"
						+ "?Teacher Teacher:Name \"朱欣焰\" ."
						+ "?Teacher Teacher:Has_Office ?room ." + "}",
				// 查询办公室在一楼的老师
				"PREFIX Teacher: <http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#Teacher>"
						+ "Select ?Teacher "
						+ "Where"
						+ "{"
						+ "?Teacher Teacher:LevelNo ?Level ."
						+ "FILTER (?Level<2) ." + "}",
				// 查询三楼的朱老师学生所在机房,以及在三楼的学生
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
						+ "FILTER (?Level_X=3) ." + "}"

		};

		for (int i = 0; i < 1; i++) {
			// System.out.print(testNameStrings[i]);

			Map<String, Set<String>> ResulteMap = grammarParser
					.query(testStr[i]);
			ResulteMap = grammarParser.resultSet;
			Set<String> keySet = ResulteMap.keySet();
			Iterator iterator = keySet.iterator();
			while (iterator.hasNext()) {
				String keyString = (String) iterator.next();
				System.out.print(keyString + " : "
						+ String.valueOf(ResulteMap.get(keyString)) + "\n");
			}
		}
	}

}
