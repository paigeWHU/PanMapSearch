package org.lmars.panmap.geo;

import java.util.ArrayList;

import org.lmars.panmap.parser.Variable;

public class GeoLineString extends Geometry{

	public GeoLineString() {
		// TODO Auto-generated constructor stub
		this.geometryType = GeometryType.LineString;
		this.linePoints = new ArrayList<MyPoint>();
		this.numPoints = 0;
	}
	public GeoLineString(ArrayList<MyPoint> Points) {
		// TODO Auto-generated constructor stub
		this.numPoints = Points.size();
		this.geometryType = GeometryType.LineString;
		this.linePoints = new ArrayList<MyPoint>(numPoints);
		this.linePoints = Points;
		
	}
	public ArrayList<MyPoint> linePoints;
	public int numPoints;
}
