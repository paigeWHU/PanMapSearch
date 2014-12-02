package org.lmars.panmap.geo;

import java.util.ArrayList;

public class GeometryCollection extends Geometry{

	public GeometryCollection() {
		// TODO Auto-generated constructor stub
		this.geometryType = GeometryType.GeometryCollection;
	}
	public int  numGeometries;
    public ArrayList<Geometry>  geometries;
}
