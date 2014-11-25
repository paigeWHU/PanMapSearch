package org.lmars.panmap.parser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.lmars.panmap.exception.NoSelectVarException;

public class Variable {
	
	  public Variable(String nameString,Map<String,Set<String>> varmap) {
		// TODO Auto-generated constructor stub
		  this.NameString = nameString;
		  this.IsSelect = false;
		  this.varMap = new HashMap<String,Set<String>>();
		  this.varMap = varmap;		  		  
	}
	  
	  public double  IriLength() throws NoSelectVarException {
		  
		  try {
			  return varMap.get(NameString).size();//�쳣����
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new NoSelectVarException("��ѯ����δ�ڲ�ѯ����г���\n��");
		}
		 
	        
//	       return 0;
	}
	
	public String VarName(){
		return this.NameString;
	}
	
	public Set<String> VarIri() {
		
			return varMap.get(NameString);
		
		
	}

	public String IndexIri(int index) throws NoSelectVarException {
		try {		
			Set<String> set = this.varMap.get(NameString);
			Iterator iterator = set.iterator();
			int temp = 0;
			String IriString = "";
			while(temp<=index&&iterator.hasNext()){
				IriString = iterator.next().toString();
				temp++;
			}
			return IriString;
		
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new NoSelectVarException("��ѯ����δ�ڲ�ѯ����г��֣�\n");
		} 
		
	}
	public void SetIndex(int index){
		this.value_filter_index = index;
	}
	public String NameString;
	public Map<String, Set<String>> varMap;//map��keyֵΪ���������ƣ�value��iri�ַ����ļ���
	public Boolean IsSelect;//˵��һ�������Ƿ�Ϊ���ղ�ѯ��Ҫ���صı���
	public int     value_filter_index;//���������ǰ��indexֵ

}
