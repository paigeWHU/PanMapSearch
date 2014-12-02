package org.lmars.panmap.geo;
import java.util.ArrayList;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class GeometryFactory {

	public static Geometry createGeometryBase(JSONObject resultJson) {
		
		Geometry geometry = null;
		JSONArray resultarry = ((JSONArray)resultJson.get("coordinates"));
		String typeString = (String) resultJson.get("type");
		switch (typeString) {
		case "Point":						
			geometry = createGeoPoint(resultarry);
			break;
		case "LineString":
			geometry = createGeoLineString(resultarry);
			break;
		case "Polygon":
			//���Զ�����ļ���
			geometry = creaGeoPolygon(resultarry);
			break;
		case "MultiPoint":
			ArrayList<GeoPoint> points = new ArrayList<GeoPoint>();
			int numPoint = resultarry.size();//��Ԫ�صĸ���
			for (int i = 0; i < numPoint; i++) {
				JSONArray linearry = (JSONArray) resultarry.get(i);//������һ����Ԫ��				
				GeoPoint geoPoint = createGeoPoint(linearry);
				points.add(geoPoint);
			}
			geometry = new GeoMultiPoint(points);
			break;
		case "MultiLineString":
			//���Ӧ���ǵ�������ɵ������������			
			ArrayList<GeoLineString> lines = new ArrayList<GeoLineString>();
			int numLineString = resultarry.size();//��Ԫ�صĸ���
			for (int i = 0; i < numLineString; i++) {
				JSONArray linearry = (JSONArray) resultarry.get(i);//������һ����Ԫ��				
				GeoLineString lineString = createGeoLineString(linearry);
				lines.add(lineString);
			}
			geometry = new GeoMultiLineString(lines);
			break;
		case "MultiPolygon":
			ArrayList<GeoPolygon> polygons = new ArrayList<GeoPolygon>();
			int numPolygon = resultarry.size();//��Ԫ�صĸ���
			for (int i = 0; i < numPolygon; i++) {
				JSONArray linearry = (JSONArray) resultarry.get(i);//������һ����Ԫ��				
				GeoPolygon geoPolygon = creaGeoPolygon(linearry);
				polygons.add(geoPolygon);
			}
			geometry = new GeoMultiPolygon(polygons);
			break;
		case "GeometryCollection"://��ʱ����
			break;
		case "None":			
			break;
		default:
			break;
		}
		return geometry;
		
	}
	/*
	 * ���������ʵ������MyPoint
	 */
	public static MyPoint createMyPoint(JSONArray resultarry) {
		MyPoint myPoint = null;
		int xyz = resultarry.size();
		if (xyz==2) {
			 myPoint = new MyPoint(resultarry.getDouble(0),resultarry.getDouble(1));
		}else if (xyz==3) {
			 myPoint = new MyPoint(resultarry.getDouble(0),resultarry.getDouble(1),resultarry.getDouble(2));
		}
		return myPoint;
	}
	
	/*
	 * �������ʵ������ GeoPoint
	 */
	public static GeoPoint createGeoPoint(JSONArray resultarry) {
		GeoPoint geoPoint = null;
		MyPoint myPoint = createMyPoint(resultarry);
		geoPoint = new GeoPoint(myPoint);
		return geoPoint;
		
	}
	
	
	/*
	 * �������ߵ�ʵ������GeoLineString
	 */
	public static GeoLineString createGeoLineString(JSONArray resultarry) {
		int numPoints = resultarry.size();//һ����Ԫ���е�ĸ���
		ArrayList<MyPoint> points = new ArrayList<MyPoint>();
		for (int j = 0; j < numPoints; j++) {
			JSONArray pointarry = (JSONArray) resultarry.get(j);//��������һ����Ԫ��
			int xyz = pointarry.size();
			MyPoint myPoint = createMyPoint(pointarry);
			points.add(myPoint);
			
		}
		GeoLineString lineString = new GeoLineString(points);
		return lineString;
	}
	/*
	 * ���������ʵ������LinearRing
	 */
	public static LinearRing createLinearRing(JSONArray resultarry) {
		LinearRing linearRing = null;
		int numPoints = resultarry.size();//һ����Ԫ���е�ĸ���
		ArrayList<MyPoint> points = new ArrayList<MyPoint>();
		for (int j = 0; j < numPoints; j++) {
			JSONArray pointarry = (JSONArray) resultarry.get(j);//��������һ����Ԫ��
			int xyz = pointarry.size();
			MyPoint myPoint = createMyPoint(pointarry);
			points.add(myPoint);
			
		}
		linearRing = new LinearRing(points);
		return linearRing;
		
	}
	
	/*
	 * ���������ʵ������ GeoPolygon
	 */
	public static GeoPolygon creaGeoPolygon(JSONArray resultarry) {
		GeoPolygon geoPolygon = null;
		ArrayList<LinearRing> lines = new ArrayList<LinearRing>();
		int numLineString = resultarry.size();//��Ԫ�صĸ���
		for (int i = 0; i < numLineString; i++) {
			JSONArray linearry = (JSONArray) resultarry.get(i);//������һ����Ԫ��				
			LinearRing linearRing = createLinearRing(linearry);
			lines.add(linearRing);
		}
		geoPolygon = new GeoPolygon(lines);
		
		return geoPolygon;
	}
}
