package org.lmars.panmap.geo;

public class MyPoint {

	public MyPoint() {
		// TODO Auto-generated constructor stub
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public MyPoint(double x,double y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.z = 0;
	}
	
	public MyPoint(double x,double y,double z) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double x;
	public double y;
	public double z;
}
