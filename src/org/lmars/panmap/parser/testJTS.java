package org.lmars.panmap.parser;
import java.awt.List;
import java.util.ArrayList;

import org.geotools.geometry.jts.JTSFactoryFinder;  

import com.vividsolutions.jts.geom.Coordinate;  
import com.vividsolutions.jts.geom.Geometry;  
import com.vividsolutions.jts.geom.GeometryCollection;  
import com.vividsolutions.jts.geom.GeometryFactory;  
import com.vividsolutions.jts.geom.LineString;  
import com.vividsolutions.jts.geom.LinearRing;  
import com.vividsolutions.jts.geom.Point;  
import com.vividsolutions.jts.geom.Polygon;  
import com.vividsolutions.jts.geom.MultiPolygon;  
import com.vividsolutions.jts.geom.MultiLineString;  
import com.vividsolutions.jts.geom.MultiPoint;  
import com.vividsolutions.jts.io.ParseException;  
import com.vividsolutions.jts.io.WKTReader;  
public class testJTS {

	public static void main(String[] args) {
		GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory( null );  
		ArrayList<Coordinate> points1 = new ArrayList<Coordinate>();  
        points1.add(new Coordinate(0,0));  
        points1.add(new Coordinate(0,1));  
        points1.add(new Coordinate(1,1)); 
        points1.add(new Coordinate(1,0)); 
        points1.add(new Coordinate(0,0));
        Coordinate[] coords  = (Coordinate[]) points1.toArray(new Coordinate[points1.size()]);  
        LinearRing line = geometryFactory.createLinearRing(coords);
        ArrayList<LinearRing> lines = new ArrayList<LinearRing>(); 
        lines.add(line);
        LinearRing[] linearRings = (LinearRing[])lines.toArray(new LinearRing[1]);
        Polygon polygon = geometryFactory.createPolygon(line, linearRings);
        
        ArrayList<Coordinate> points11 = new ArrayList<Coordinate>();  
        points11.add(new Coordinate(0,2));  
        points11.add(new Coordinate(0,3));  
        points11.add(new Coordinate(1,3)); 
        points11.add(new Coordinate(1,2)); 
        points11.add(new Coordinate(0,2));
        Coordinate[] coords1  = (Coordinate[]) points11.toArray(new Coordinate[points11.size()]);  
        LinearRing line1 = geometryFactory.createLinearRing(coords1);
        ArrayList<LinearRing> lines1 = new ArrayList<LinearRing>(); 
        lines1.add(line1);
        LinearRing[] linearRings1 = (LinearRing[])lines1.toArray(new LinearRing[1]);
        Polygon polygon1 = geometryFactory.createPolygon(line1, linearRings1);
        
        ArrayList<Coordinate> points111 = new ArrayList<Coordinate>();  
        points111.add(new Coordinate(4,2));  
        points111.add(new Coordinate(4,3));  
        points111.add(new Coordinate(5,3)); 
        points111.add(new Coordinate(5,2)); 
        points111.add(new Coordinate(4,2));
        Coordinate[] coords11  = (Coordinate[]) points111.toArray(new Coordinate[points111.size()]);  
        LinearRing line11 = geometryFactory.createLinearRing(coords11);
        ArrayList<LinearRing> lines11 = new ArrayList<LinearRing>(); 
        lines11.add(line11);
        LinearRing[] linearRings11 = (LinearRing[])lines11.toArray(new LinearRing[1]);
        Polygon polygon11 = geometryFactory.createPolygon(line11, linearRings11);
        
        System.out.print(line.distance(line11));
	}
}
