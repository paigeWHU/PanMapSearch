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
		this.owlFilePath = "ontology/building.owl"; /* OWL文件路径 */
	    this.instance = new OWL(owlFilePath);
	}

	private static ParseExcuteVar excuteVar = new ParseExcuteVar();

	public static ParseExcuteVar getexcuteVar() {
		return excuteVar;
	}
	
	/*
	 * 根据变量名称获得变量值
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
	 * 位名称为name的变量赋值
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
				throw  new VarNotDefineException("存在未定义变量！"+"\n");
			}
			
			
		}
		return null;
		
	}
	/*
	 * 位名称为name的变量赋值
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
	 * 位名称为name的变量赋值IsSelect属性，以此判断此变量是否为最终查询的变量
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
	 * 得到名称为name的变量的IsSelect属性的值
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
	 * 根据名称返回Variable类型的变量
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
	 * 添加Vars变量的函数 判断重复性
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
	 * 添加Vars变量的函数 判断重复性
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
				throw new VarNotDefineException("变量"+name+"没有定义！");
			}
			
		}
		excuteVar.FilterVars.add(var);
	}
	
	

	
	/*
	 * 找到在计算约束时，当前循环下，名称为name的变量在第index位置的iri，index即为循环下的值
	 * 即对于函数约束，他的参数都是一个实例，那么通过此函数，来得到名称为name的变量的那一个实例
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
	 * 存储查询过程中需要的变量。包括Prefix以及一些未知和带入的变量
	 */
	public ArrayList<Variable> Vars;//在查询过程中用到的变量
	public int[] index;//保存在计算约束时此时的index
	public Set<int[]> IndexSet;//保存满足条件的index的集合
	public String owlFilePath = "ontology/building.owl"; /* OWL文件路径 */
    public OWL instance;//读取wol的实例
	public ArrayList<Variable> FilterVars;//存储约束过滤式需要的变量
	public String address = "202.114.114.34:5432/myDB";
	public String user = "postgres";
	public String pass = "admin";
}
