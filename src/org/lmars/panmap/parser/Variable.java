package org.lmars.panmap.parser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Variable {
	
	  public Variable(Map<String,Set<String>> varmap) {
		// TODO Auto-generated constructor stub
		  this.IsSelect = false;
		  this.varMap = new HashMap<String,Set<String>>();
		  this.varMap = varmap;		  		  
	}
	  
	  public double  IriLength() {
		 
			Set     set1     =     this.varMap.entrySet();   
	        Iterator     iterator1     =     set1.iterator();   
	        while     (iterator1.hasNext()  ) 
	        {   
	          Map.Entry     mapentry     =     (Map.Entry)     iterator1.next();   
	          return ((Set<String>)mapentry.getValue()).size();        
	        }   
	        
	       return 0;
	}
	
	public String VarName(){
		Set     set1     =     this.varMap.entrySet();   
        Iterator     iterator1     =     set1.iterator();   
        while     (iterator1.hasNext()  ) 
        {   
          Map.Entry     mapentry     =     (Map.Entry)     iterator1.next();   
          return mapentry.getKey().toString();        
        }   
        
       return null;
	}
	
	public Set<String> VarIri(){
		Set     set1     =     this.varMap.entrySet();   
        Iterator     iterator1     =     set1.iterator();   
        while     (iterator1.hasNext()  ) 
        {   
          Map.Entry     mapentry     =     (Map.Entry)     iterator1.next();   
          return (Set<String>)mapentry.getValue();        
        }   
        
       return null;
	}

	public String IndexIri(int index) {
		 
		Set<String> set = this.VarIri();
		Iterator iterator = set.iterator();
		int temp = 0;
		String IriString = "";
		while(temp<=index&&iterator.hasNext()){
			IriString = iterator.next().toString();
			temp++;
		}
		return IriString;
		
	}
	public void SetIndex(int index){
		this.value_filter_index = index;
	}
	public Map<String, Set<String>> varMap;//map��keyֵΪ���������ƣ�value��iri�ַ����ļ���
	public Boolean IsSelect;//˵��һ�������Ƿ�Ϊ���ղ�ѯ��Ҫ���صı���
	public int     value_filter_index;//���������ǰ��indexֵ

}
