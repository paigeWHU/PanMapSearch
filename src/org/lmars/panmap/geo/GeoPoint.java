package org.lmars.panmap.geo;

public class GeoPoint extends Geometry{

	public GeoPoint() {
		// TODO Auto-generated constructor stub
		this.geometryType = GeometryType.Point;
		this.point = new MyPoint();
	}
	public GeoPoint(MyPoint myPoint) {
		// TODO Auto-generated constructor stub
		this.geometryType = GeometryType.Point;
		this.point = new MyPoint();
		this.point = myPoint;
	}
	
	
	public MyPoint point; 
}
