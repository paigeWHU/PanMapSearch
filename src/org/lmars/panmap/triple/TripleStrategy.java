package org.lmars.panmap.triple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.lmars.panmap.exception.NoPropertyException;
import org.lmars.panmap.exception.OntoNotDefineExcetion;
import org.lmars.panmap.exception.UnkownTripleTypeException;
import org.lmars.panmap.parser.ParseExcuteVar;

public abstract class TripleStrategy {
	public TripleStrategy(Map<String, String> triplemap) {
		// TODO Auto-generated constructor stub
		this.tripleMap = new HashMap<String, String>();
		this.tripleMap = triplemap;
		this.excuteVar = ParseExcuteVar.getexcuteVar();
	}

	public TripleStrategy(String sub, String pre, String pro, String obj) {
		// TODO Auto-generated constructor stub
		this.tripleMap = new HashMap<String, String>();
		this.tripleMap.put("Subject", sub);
		this.tripleMap.put("Prefix", pre);
		this.tripleMap.put("Property", pro);
		this.tripleMap.put("Object", obj);
		this.excuteVar = ParseExcuteVar.getexcuteVar();

	}

	public abstract void tripleExcute() throws OntoNotDefineExcetion,
			NoPropertyException, UnkownTripleTypeException;

	/*
	 * 判断两个set之间是否有包含关系
	 */
	public boolean SetContains(Set<String> set1, Set<String> set2) {
		Iterator<String> iterator = set2.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			if (set1.contains(string)) {
				continue;

			} else {
				return false;
			}
		}
		return true;
	}

	public Map<String, String> tripleMap;
	public ParseExcuteVar excuteVar;
}
