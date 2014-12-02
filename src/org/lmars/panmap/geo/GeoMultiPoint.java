package org.lmars.panmap.geo;

import java.util.ArrayList;

public class GeoMultiPoint extends Geometry{

	public GeoMultiPoint() {
		// TODO Auto-generated constructor stub
		this.geometryType = GeometryType.MultiPoint;
		this.geoPoints = new ArrayList<GeoPoint>();
		this.numGeopoints = 0;
	}
	public GeoMultiPoint(ArrayList<GeoPoint> geopoints) {
		// TODO Auto-generated constructor stub
		this.numGeopoints = geopoints.size();
		this.geometryType = GeometryType.MultiPoint;
		this.geoPoints = new ArrayList<GeoPoint>(numGeopoints);
		this.geoPoints = geopoints;
		
	}

	public ArrayList<GeoPoint> geoPoints;
	public int numGeopoints;
}
