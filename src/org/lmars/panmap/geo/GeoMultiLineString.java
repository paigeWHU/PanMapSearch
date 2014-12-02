package org.lmars.panmap.geo;

import java.util.ArrayList;

public class GeoMultiLineString extends Geometry{

	public GeoMultiLineString() {
		// TODO Auto-generated constructor stub
		this.geometryType = GeometryType.MultiLineString;
		this.geoLineStrings = new ArrayList<GeoLineString>();
		this.numGeolinestrings = 0;
	}
	public GeoMultiLineString(ArrayList<GeoLineString> geolinestrings) {
		// TODO Auto-generated constructor stub
		this.numGeolinestrings = geolinestrings.size();
		this.geometryType = GeometryType.MultiLineString;
		this.geoLineStrings = new ArrayList<GeoLineString>(numGeolinestrings);
		this.geoLineStrings = geolinestrings;
		
	}

	public ArrayList<GeoLineString> geoLineStrings;
	public int numGeolinestrings;
}
