package org.lmars.panmap.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.lmars.panmap.exception.NoSelectVarException;
import org.lmars.panmap.exception.VarNotDefineException;
import org.owlapi.OWL;

public class ParseExcuteVar {

	private ParseExcuteVar() {
		// TODO Auto-generated constructor stub
		this.Vars = new ArrayList<Variable>();
		this.FilterVars = new ArrayList<Variable>();
		this.IndexSet =new HashSet<int[]>();
		this.instance = new OWL(owlFilePath);
		this.owlFilePath = "ontology/building.owl"; /* OWL�ļ�·�� */
	    this.instance = new OWL(owlFilePath);
	}

	private static ParseExcuteVar excuteVar = new ParseExcuteVar();

	public static ParseExcuteVar getexcuteVar() {
		return excuteVar;
	}
	
	/*
	 * ���ݱ������ƻ�ñ���ֵ
	 */
	public Set<String> GetValue(String name) {
		Iterator<Variable> iterator = excuteVar.Vars.iterator();
		while (iterator.hasNext()) {
			Variable variable = iterator.next();
			
			if(variable.varMap.get(name) != null){
				return variable.varMap.get(name);
			}
			
		}
		return null;
		
	}
	/*
	 * λ����Ϊname�ı�����ֵ
	 */
	public void SetValue(String name,Set<String> iris) {
		
		GetVarsVar(name).varMap.put(name, iris);		
	}
	
	
	public Set<String> GetFilterValue(String name) throws VarNotDefineException{
		
		Iterator<Variable> iterator = excuteVar.FilterVars.iterator();
		while (iterator.hasNext()) {
			Variable variable = iterator.next();
			try {
				if(variable.varMap.get(name) != null){
					return variable.varMap.get(name);
				}
			} catch (NullPointerException e) {
				// TODO: handle exception
				throw  new VarNotDefineException("����δ���������"+"\n");
			}
			
			
		}
		return null;
		
	}
	/*
	 * λ����Ϊname�ı�����ֵ
	 */
	

	public void SetFilterValue(String name,Set<String> iris) {
		String[] str = new String[0];
		Iterator<Variable> iterator = excuteVar.FilterVars.iterator();
		while (iterator.hasNext()) {
			Variable variable = iterator.next();
			if(variable.varMap.get(name) != null){
				variable.varMap.put(name, iris);
				}
			}
			
		
	}
	
	
	/*
	 * λ����Ϊname�ı�����ֵIsSelect���ԣ��Դ��жϴ˱����Ƿ�Ϊ���ղ�ѯ�ı���
	 */

	public void SetSelect(String name) {
		
		Iterator<Variable> iterator = excuteVar.Vars.iterator();
		while (iterator.hasNext()) {
			Variable variable = iterator.next();
//			
			if(variable.NameString.equals(name)){
//			
				variable.IsSelect = true;
			}
			
		}
	}
	
	
	/*
	 * �õ�����Ϊname�ı�����IsSelect���Ե�ֵ
	 */
	public boolean GetSelect(String name) {
		
		Iterator<Variable> iterator = excuteVar.Vars.iterator();
		while (iterator.hasNext()) {
			Variable variable = iterator.next();
			if(variable.NameString.equals(name)){
				return variable.IsSelect;
			}
			
		}
		return false;
	}
	

	/*
	 * �������Ʒ���Variable���͵ı���
	 */
	public Variable GetVarsVar(String name){
		Iterator<Variable> iterator = excuteVar.Vars.iterator();
		while(iterator.hasNext()){
			Variable variable = iterator.next();
			if(variable.NameString.equals(name)){
				return variable;
			}
		}
		return null;
	}
	
	/*
	 * ���Vars�����ĺ��� �ж��ظ���
	 */
	
	public void AddVars(String name,Variable var){
		Iterator iterator = excuteVar.Vars.iterator();
		while(iterator.hasNext()){
			Variable variable = (Variable) iterator.next();
			if(variable.NameString.equals(name))
				return;
		}
		excuteVar.Vars.add(var);

		
	}
	
	
	/*
	 * ���Vars�����ĺ��� �ж��ظ���
	 */
	
	public void AddFikterVars(String name,Variable var) throws VarNotDefineException{
		Iterator iterator = excuteVar.FilterVars.iterator();
		while(iterator.hasNext()){
			Variable variable = (Variable) iterator.next();
			try {
				if(variable.NameString.equals(name))
					return;
			} catch (NullPointerException e) {
				// TODO: handle exception
				throw new VarNotDefineException("����"+name+"û�ж��壡");
			}
			
		}
		excuteVar.FilterVars.add(var);
	}
	
	

	
	/*
	 * �ҵ��ڼ���Լ��ʱ����ǰѭ���£�����Ϊname�ı����ڵ�indexλ�õ�iri��index��Ϊѭ���µ�ֵ
	 * �����ں���Լ�������Ĳ�������һ��ʵ������ôͨ���˺��������õ�����Ϊname�ı�������һ��ʵ��
	 */
	public String find_i_iri(String name) throws NoSelectVarException{
		Iterator iterator = excuteVar.FilterVars.iterator();
		while(iterator.hasNext()){
			Variable variable = (Variable) iterator.next();
			if(variable.varMap.get(name)!=null){
				return variable.IndexIri(variable.value_filter_index);
			}
		}
		return null;
	}
	
	
	/*
	 * �洢��ѯ��������Ҫ�ı���������Prefix�Լ�һЩδ֪�ʹ���ı���
	 */
	public ArrayList<Variable> Vars;//�ڲ�ѯ�������õ��ı���
	public int[] index;//�����ڼ���Լ��ʱ��ʱ��index
	public Set<int[]> IndexSet;//��������������index�ļ���
	public String owlFilePath = "ontology/building.owl"; /* OWL�ļ�·�� */
    public OWL instance;//��ȡwol��ʵ��
	public ArrayList<Variable> FilterVars;//�洢Լ������ʽ��Ҫ�ı���
	public String address = "202.114.114.34:5432/myDB";
	public String user = "postgres";
	public String pass = "admin";
}
