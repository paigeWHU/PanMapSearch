package org.lmars.panmap.geo;

import java.util.ArrayList;

public class LinearRing {

	public LinearRing() {
		// TODO Auto-generated constructor stub
		this.numPoints = 0;
		this.ringPoints = new ArrayList<MyPoint>();
	}
	public LinearRing(ArrayList<MyPoint> points) {
		// TODO Auto-generated constructor stub
		this.numPoints = points.size();
		this.ringPoints = new ArrayList<MyPoint>(numPoints);
		this.ringPoints = points;
	}
	public int numPoints;
    public ArrayList<MyPoint> ringPoints;
}
