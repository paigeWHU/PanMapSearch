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
			//面试多个环的集合
			geometry = creaGeoPolygon(resultarry);
			break;
		case "MultiPoint":
			ArrayList<GeoPoint> points = new ArrayList<GeoPoint>();
			int numPoint = resultarry.size();//点元素的个数
			for (int i = 0; i < numPoint; i++) {
				JSONArray linearry = (JSONArray) resultarry.get(i);//对其中一个点元素				
				GeoPoint geoPoint = createGeoPoint(linearry);
				points.add(geoPoint);
			}
			geometry = new GeoMultiPoint(points);
			break;
		case "MultiLineString":
			//结果应当是点数组组成的线数组的数组			
			ArrayList<GeoLineString> lines = new ArrayList<GeoLineString>();
			int numLineString = resultarry.size();//线元素的个数
			for (int i = 0; i < numLineString; i++) {
				JSONArray linearry = (JSONArray) resultarry.get(i);//对其中一个线元素				
				GeoLineString lineString = createGeoLineString(linearry);
				lines.add(lineString);
			}
			geometry = new GeoMultiLineString(lines);
			break;
		case "MultiPolygon":
			ArrayList<GeoPolygon> polygons = new ArrayList<GeoPolygon>();
			int numPolygon = resultarry.size();//线元素的个数
			for (int i = 0; i < numPolygon; i++) {
				JSONArray linearry = (JSONArray) resultarry.get(i);//对其中一个线元素				
				GeoPolygon geoPolygon = creaGeoPolygon(linearry);
				polygons.add(geoPolygon);
			}
			geometry = new GeoMultiPolygon(polygons);
			break;
		case "GeometryCollection"://暂时忽略
			break;
		case "None":			
			break;
		default:
			break;
		}
		return geometry;
		
	}
	/*
	 * 创建环点的实例返回MyPoint
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
	 * 创建点的实例返回 GeoPoint
	 */
	public static GeoPoint createGeoPoint(JSONArray resultarry) {
		GeoPoint geoPoint = null;
		MyPoint myPoint = createMyPoint(resultarry);
		geoPoint = new GeoPoint(myPoint);
		return geoPoint;
		
	}
	
	
	/*
	 * 创建环线的实例返回GeoLineString
	 */
	public static GeoLineString createGeoLineString(JSONArray resultarry) {
		int numPoints = resultarry.size();//一个线元素中点的个数
		ArrayList<MyPoint> points = new ArrayList<MyPoint>();
		for (int j = 0; j < numPoints; j++) {
			JSONArray pointarry = (JSONArray) resultarry.get(j);//对于其中一个点元素
			int xyz = pointarry.size();
			MyPoint myPoint = createMyPoint(pointarry);
			points.add(myPoint);
			
		}
		GeoLineString lineString = new GeoLineString(points);
		return lineString;
	}
	/*
	 * 创建环类的实例返回LinearRing
	 */
	public static LinearRing createLinearRing(JSONArray resultarry) {
		LinearRing linearRing = null;
		int numPoints = resultarry.size();//一个线元素中点的个数
		ArrayList<MyPoint> points = new ArrayList<MyPoint>();
		for (int j = 0; j < numPoints; j++) {
			JSONArray pointarry = (JSONArray) resultarry.get(j);//对于其中一个点元素
			int xyz = pointarry.size();
			MyPoint myPoint = createMyPoint(pointarry);
			points.add(myPoint);
			
		}
		linearRing = new LinearRing(points);
		return linearRing;
		
	}
	
	/*
	 * 创建面类的实例返回 GeoPolygon
	 */
	public static GeoPolygon creaGeoPolygon(JSONArray resultarry) {
		GeoPolygon geoPolygon = null;
		ArrayList<LinearRing> lines = new ArrayList<LinearRing>();
		int numLineString = resultarry.size();//线元素的个数
		for (int i = 0; i < numLineString; i++) {
			JSONArray linearry = (JSONArray) resultarry.get(i);//对其中一个线元素				
			LinearRing linearRing = createLinearRing(linearry);
			lines.add(linearRing);
		}
		geoPolygon = new GeoPolygon(lines);
		
		return geoPolygon;
	}
}
