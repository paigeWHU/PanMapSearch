package org.lmars.panmap.geo;

import java.util.ArrayList;

public class GeoPolygon extends Geometry{

	public GeoPolygon() {
		// TODO Auto-generated constructor stub
		this.geometryType = GeometryType.Polygon;
		this.polygonRings = new ArrayList<LinearRing>();
		this.numRings = 0;
	}
	
	public GeoPolygon(ArrayList<LinearRing> Points) {
		// TODO Auto-generated constructor stub
		this.numRings = Points.size();
		this.geometryType = GeometryType.Polygon;
		this.polygonRings = new ArrayList<LinearRing>(numRings);
		this.polygonRings = Points;
		
	}
	
	public ArrayList<LinearRing> polygonRings;

	public int numRings;
}
