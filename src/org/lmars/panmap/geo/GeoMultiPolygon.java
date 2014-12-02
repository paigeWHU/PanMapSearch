package org.lmars.panmap.geo;

import java.util.ArrayList;

public class GeoMultiPolygon extends Geometry{

	public GeoMultiPolygon() {
		// TODO Auto-generated constructor stub
		this.geometryType = GeometryType.MultiPolygon;
		this.geoPolygons = new ArrayList<GeoPolygon>();
		this.numGeoplygons = 0;
	}
	public GeoMultiPolygon(ArrayList<GeoPolygon> geolinestrings) {
		// TODO Auto-generated constructor stub
		this.numGeoplygons = geolinestrings.size();
		this.geometryType = GeometryType.MultiPolygon;
		this.geoPolygons = new ArrayList<GeoPolygon>(numGeoplygons);
		this.geoPolygons = geolinestrings;
		
	}

	public ArrayList<GeoPolygon> geoPolygons;
	public int numGeoplygons;
}
