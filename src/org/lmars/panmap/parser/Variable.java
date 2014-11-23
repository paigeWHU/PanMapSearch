package org.lmars.panmap.parser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Variable {
	
	  public Variable(String nameString,Map<String,Set<String>> varmap) {
		// TODO Auto-generated constructor stub
		  this.NameString = nameString;
		  this.IsSelect = false;
		  this.varMap = new HashMap<String,Set<String>>();
		  this.varMap = varmap;		  		  
	}
	  
	  public double  IriLength() {
		 
//			Set     set1     =     this.varMap.entrySet();   
//	        Iterator     iterator1     =     set1.iterator();   
//	        while     (iterator1.hasNext()  ) 
//	        {   
//	          Map.Entry     mapentry     =     (Map.Entry)     iterator1.next();   
//	          return ((Set<String>)mapentry.getValue()).size();        
//	        }   
		  
		  return varMap.get(NameString).size();//异常捕获
	        
//	       return 0;
	}
	
	public String VarName(){
//		Set     set1     =     this.varMap.entrySet();   
//        Iterator     iterator1     =     set1.iterator();   
//        while     (iterator1.hasNext()  ) 
//        {   
//          Map.Entry     mapentry     =     (Map.Entry)     iterator1.next();   
//          return mapentry.getKey().toString();        
//        }   
//        
//       return null;
		return this.NameString;
	}
	
	public Set<String> VarIri(){
//		Set     set1     =     this.varMap.entrySet();   
//        Iterator     iterator1     =     set1.iterator();   
//        while     (iterator1.hasNext()  ) 
//        {   
//          Map.Entry     mapentry     =     (Map.Entry)     iterator1.next();   
//          return (Set<String>)mapentry.getValue();        
//        }   
//        
//       return null;
		return varMap.get(NameString);
	}

	public String IndexIri(int index) {
		 
		Set<String> set = this.varMap.get(NameString);
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
	public String NameString;
	public Map<String, Set<String>> varMap;//map的key值为变量的名称，value是iri字符串的集合
	public Boolean IsSelect;//说明一个变量是否为最终查询需要返回的变量
	public int     value_filter_index;//保存变量当前的index值

}
