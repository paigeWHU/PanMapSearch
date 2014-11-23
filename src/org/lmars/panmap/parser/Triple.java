package org.lmars.panmap.parser;

import java.util.HashMap;
import java.util.Map;

public class Triple {
	public Triple(Map<String,String> triplemap) {
		// TODO Auto-generated constructor stub
		this.tripleMap = new HashMap<String, String>();
		this.tripleMap = triplemap;
	}
	public Triple(String sub,String pre,String pro,String obj) {
		// TODO Auto-generated constructor stub
		this.tripleMap = new HashMap<String, String>();
		this.tripleMap.put("Subject", sub);
		this.tripleMap.put("Prefix", pre);
		this.tripleMap.put("Property", pro);
		this.tripleMap.put("Object", obj);
		
	}
	public Map<String,String> tripleMap;
}
