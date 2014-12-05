package org.lmars.panmap.parser;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.lmars.sparql.parser.*;
import org.lmars.panmap.geo.*;
import org.lmars.panmap.spatialcompute.SpatialCompute;
import org.antlr.v4.codegen.model.chunk.ThisRulePropertyRef_ctx;
import org.antlr.v4.parse.ANTLRParser.id_return;
import org.antlr.v4.parse.ANTLRParser.throwsSpec_return;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.owlapi.OWL;
import org.stringtemplate.v4.compiler.CodeGenerator.region_return;  
import org.lmars.panmap.exception.*;
import  org.postgresql. * ;

import  java.sql. * ;
public class SpatialSelect {
	
	/*
	 * 构造函数
	 */
	public SpatialSelect() {
		
		this.Vars = new ArrayList<Variable>();
		this.Triples = new ArrayList<Triple>();
		this.FilterVars = new ArrayList<Variable>();
		this.IndexSet =new HashSet<int[]>();
		this.instance = new OWL(owlFilePath);
		// TODO Auto-generated constructor stub
	}

	
	
	/*
	 * 根据变量名称获得变量值
	 */
	public Set<String> GetValue(String name) {
		Iterator<Variable> iterator = this.Vars.iterator();
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
		
		Iterator<Variable> iterator = this.FilterVars.iterator();
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
		Iterator<Variable> iterator = this.FilterVars.iterator();
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
		
		Iterator<Variable> iterator = this.Vars.iterator();
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
		
		Iterator<Variable> iterator = this.Vars.iterator();
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
		Iterator<Variable> iterator = Vars.iterator();
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
		Iterator iterator = this.Vars.iterator();
		while(iterator.hasNext()){
			Variable variable = (Variable) iterator.next();
			if(variable.NameString.equals(name))
				return;
		}
		this.Vars.add(var);

		
	}
	
	
	/*
	 * 添加Vars变量的函数 判断重复性
	 */
	
	public void AddFikterVars(String name,Variable var) throws VarNotDefineException{
		Iterator iterator = this.FilterVars.iterator();
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
		this.FilterVars.add(var);
	}
	
	

	
	/*
	 * 找到在计算约束时，当前循环下，名称为name的变量在第index位置的iri，index即为循环下的值
	 * 即对于函数约束，他的参数都是一个实例，那么通过此函数，来得到名称为name的变量的那一个实例
	 */
	private String find_i_iri(String name) throws NoSelectVarException{
		Iterator iterator = this.FilterVars.iterator();
		while(iterator.hasNext()){
			Variable variable = (Variable) iterator.next();
			if(variable.varMap.get(name)!=null){
				return variable.IndexIri(variable.value_filter_index);
			}
		}
		return null;
	}
	
	
	/*
	 * 总的三元组执行函数
	 */

	public void triple_excute(Map<String, String> paramMap) throws UnkownTripleTypeException,NoPropertyException,OntoNotDefineExcetion {
		// TODO Auto-generated method stub
		//调用函数判断三元组语法的规则
		
				//根据不同的语法规则
				int type = judge_triple_condition(paramMap);
			
				switch (type) {
				case 1:
					triple_execute_rule1(paramMap);
					break;
				case 2:
					triple_execute_rule2(paramMap);
					break;
				case 3:
					triple_execute_rule3(paramMap);
					break;
				case 4:
					triple_execute_rule4(paramMap);
					break;
				case 5:
					triple_execute_rule5(paramMap);
					break;
				case 6:
					throw new UnkownTripleTypeException("主语宾语均为值，未知的三元组类型");
				case 7:
					throw new UnkownTripleTypeException("主语为值，未知的三元组类型");
				case 8:
					throw new UnkownTripleTypeException("主语宾语均为待求变量，未知的三元组类型");
				case 9:
					throw new UnkownTripleTypeException("主语为值，未知的三元组类型");
				default:
					break;
				}
	}

	/*
	 * 根据传入的参数来判断三元组属于哪一种类型
	 */
	
	private int judge_triple_condition(Map<String, String> paramMap){
		
		//1:待求变量 2：已知变量 3：值
		String var1 = paramMap.get("Subject");
		String var2 = paramMap.get("Object");
		
		int type1 = 0,type2 = 0;//分别代表第一个和第二个元素的类型
		int resultType = 0;//代表三元组的类型
		
		//得到第一个元素的类型
		if(var1.charAt(0)=='?'){//说明一定是变量，待求变量或者已知变量
			if(GetValue(var1)!=null||GetSelect(var1)){
				
				//从Vars中寻找，若没有找到说明一定是待求变量，否则为已知变量
				type1 = 2;
			}else {
				type1 = 1;
			}
		}else{
			type1 = 3;//变量类型为值
		}
		
		//得到第一个元素的类型
		if(var2.charAt(0)=='?'){//说明一定是变量，待求变量或者已知变量
			if(GetValue(var2)!=null||GetSelect(var2)){
				//从Vars中寻找，若没有找到说明一定是待求变量，否则为已知变量
				type2 = 2;
			}
			else {
				type2 = 1;//已知变量
			}
		}else{
			type2 = 3;//变量类型为值
		}		
		if(type1==1&&type2==3){
			resultType = 1;
		}else if(type1==1&&type2==2){
			resultType = 2;
		}else if (type1==2&&type2==1) {
			resultType = 3;
		}else if (type1==2&&type2==3) {
			resultType = 4;
		}else if (type1==2&&type2==2) {
			resultType = 5;
		}else if (type1==3&&type2==3) {
			resultType = 6;
		}else if (type1==3&&type2==2) {
			resultType = 7;
		}else if (type1==1&&type2==1) {
			resultType = 8;
		}else if (type1==3&&type2==1) {
			resultType = 9;
		}
		
		
		return resultType;//
	}
	
	
	
	/*
	 * 执行第一种语法规则的三元组查询函数:1、	待求变量+属性+值
	 */	
	private void triple_execute_rule1 (Map<String ,String>args) throws OntoNotDefineExcetion,NoPropertyException{
		
		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
		Set<String> var1Iri = new HashSet<String>();
		Set<String> tempIri = new HashSet<String>();
		//得到主体的iri
		String subIriString = "";
		Set<String> set =  this.GetValue(prifixString);
		try {
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				subIriString = it.next();
				
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("本体"+prifixString+"未定义！");
		}
		
		//得到属性的iri
		String pvIri = subIriString.split("#")[0]+"#"+propertyString+">";
		boolean IsDataPro = instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = instance.readExistObjectProperty(pvIri);
		
		if(!IsObjectPro&&!IsDataPro){
			
			throw new NoPropertyException("实例"+subjectString+"不存在"+propertyString+"属性！");
		}
		
		//读出本体的所有实例赋值给tempIri		
		if(GetValue(subjectString)!=null){
			
			tempIri = GetValue(subjectString);
		}else {
			tempIri = instance.readAllInstancesOfClass(subIriString);
		}
		
		try {
			//遍历tempIri 看实例的property属性是否为值 是的话加入到var1Iri
			Iterator<String> iterator = tempIri.iterator();
			while(iterator.hasNext()){
				
				String string = iterator.next();
				
				//看实例的property属性是否为值 是的话加入到var1Iri
				 Set<String> setResult = instance.readPropertyValueOfInstance(pvIri, string);
				 if (setResult.size()==0) {
					 setResult = null;
				}
				 //得到结果组成的字符串
				 String resultString = "";
				 try {
					 Iterator iteratorResult = setResult.iterator();
					    while (iteratorResult.hasNext()) {
							String tempString = (String) iteratorResult.next();
							resultString = resultString + tempString;
							if (iteratorResult.hasNext()) {
								resultString += ",";
							}
					    }
					
						if(resultString.equals(objectString)){
							var1Iri.add(string);
						}
				} catch (NullPointerException e) {
					continue;
					// TODO: handle exception
//					throw new NoPropertyException("实例"+string+"不存在"+propertyString+"属性！");
				}
				   
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("本体"+prifixString+"定义错误或者主语变量"+subjectString+"错误！");
		}
		
		
		//添加变量到Vars						
		Map<String, Set<String>> var1Map = new HashMap<String,Set<String>>();
		var1Map.put(subjectString, var1Iri);
		Variable var1 = new Variable(subjectString,var1Map);
		//最终求出待求变量，并将其保存
		this.AddVars(subjectString, var1);
		this.SetValue(subjectString, var1Iri);
	}
	
	
	/*
	 * 执行第一种语法规则的三元组查询函数:2、	待求变量+属性+已知变量
	 */
	
	private void triple_execute_rule2 (Map<String ,String>args) throws OntoNotDefineExcetion,NoPropertyException{
		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
		Set<String> tempIri = new HashSet<String>();
		Set<String> var1Iri = new HashSet<String>();
		//首先得到已知变量的Set<String>
		Set<String> objectSet = this.GetValue(objectString);
		
		//当objectSet为空将objectSet赋值为owl本体全部的实例
		boolean isObjNull = false;
		if (objectSet==null&&GetSelect(objectString)) {
			isObjNull = true;//为空
			objectSet = instance.readAllInstances();
		}
		
		//得到本体的iri
		String subIriString = "";
		Set<String> set =  this.GetValue(prifixString);
		try {
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				subIriString = it.next();
				
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("实例"+prifixString+"未定义！");
		}
		
		//得到待求变量的过滤前的实例
		if(GetValue(subjectString)!=null){
			
			tempIri = GetValue(subjectString);
			
		}else {
			tempIri = instance.readAllInstancesOfClass(subIriString);
		}
		
		
		//得到属性的iri
		String pvIri = subIriString.split("#")[0]+"#"+propertyString+">";
		boolean IsDataPro = instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = instance.readExistObjectProperty(pvIri);
		if(!IsObjectPro&&!IsDataPro){
			throw new NoPropertyException("实例"+subjectString+"不存在"+propertyString+"属性！");
		}
		try {
			//遍历tempIri找到满足属性要求的实例
			Iterator<String> iterator = tempIri.iterator();

			while (objectSet.size()!=0&&iterator.hasNext()) {
				String string = (String) iterator.next();//遍历实例
				Set<String> setResult = instance.readPropertyValueOfInstance(pvIri, string);
				if (setResult.size()==0) {
					continue;
//					throw new NoPropertyException("实例"+string+"不存在"+propertyString+"属性！");
				
				}

					if(SetContains(objectSet, setResult)){
						var1Iri.add(string);
					}
				
				
			}
			
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("本体"+prifixString+"定义错误或者主语变量"+subjectString+"错误！");
		}
		
		Map<String, Set<String>> var1Map = new HashMap<String,Set<String>>();
		var1Map.put(subjectString, var1Iri);
		Variable var1 = new Variable(subjectString,var1Map);
		//最终求出待求变量，并将其保存
		this.AddVars(subjectString, var1);
	
		this.SetValue(subjectString, var1Iri);
		
	}
	
		
	/*
	 * 行第一种语法规则的三元组查询函数:3、	已知变量+属性+待求变量
	 */

	private void triple_execute_rule3 (Map<String ,String>args) throws OntoNotDefineExcetion,NoPropertyException{

		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
		//首先判断已知变量的Set是否为空，若为空，则进行求值，并为其赋值到Vars
		Set<String> subSet = this.GetValue(subjectString);
		//得到本体的iri
		String subIriString = "";
		Set<String> set =  this.GetValue(prifixString);
		try {
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				subIriString = it.next();
				
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("实例"+prifixString+"未定义！");
		}
		
		Set<String> tempIri = new HashSet<String>();
		if (subSet==null&&GetSelect(subjectString)) {
			tempIri = instance.readAllInstancesOfClass(subIriString);
			this.SetValue(subjectString, tempIri);
			subSet = this.GetValue(subjectString);
			
			
		}
		
		
		//得到属性iri
		Set<String> var1Iri = new HashSet<String>();
		
		String pvIri = subIriString.split("#")[0]+"#"+propertyString+">";
		boolean IsDataPro = instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = instance.readExistObjectProperty(pvIri);
		if(!IsObjectPro&&!IsDataPro){
			throw new NoPropertyException("实例"+subjectString+"不存在"+propertyString+"属性！");
		}
		try {
			Iterator<String> it1 = subSet.iterator();
			while (it1.hasNext()) {
				String string = (String) it1.next();
				Set<String> setResult = instance.readPropertyValueOfInstance(pvIri, string);

				try {
					 Iterator iterator = setResult.iterator();
					    while (iterator.hasNext()) {
					    	var1Iri.add((String)iterator.next());
						}
				} catch (NullPointerException e) {
					// TODO: handle exception
					continue;
//					throw new NoPropertyException("实例"+string+"不存在"+propertyString+"属性！");
				}finally{
					continue;
				}
			   

			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("本体"+prifixString+"定义错误或者主语变量"+subjectString+"错误！");
		}
		
		
	
		
		
		Map<String, Set<String>> var1Map = new HashMap<String,Set<String>>();
		var1Map.put(objectString, var1Iri);		
		Variable var1 = new Variable(objectString,var1Map);				
		//最终求出待求变量，并将其保存
		this.AddVars(objectString, var1);
		this.SetValue(objectString, var1Iri);
									
	}
	
	
	/*
	 * 行第一种语法规则的三元组查询函数:4、	已知变量+属性+值
	 */
	
	private void triple_execute_rule4(Map<String, String> args) throws OntoNotDefineExcetion,NoPropertyException{
		// TODO Auto-generated method stub
		

		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
		Set<String> var1Iri = new HashSet<String>();
		Set<String> subIri = new HashSet<String>();
		//得到本体iri
		String subIriString = "";
		Set<String> set =  this.GetValue(prifixString);
		try {
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				subIriString = it.next();
				
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("实例"+prifixString+"未定义！");
		}
		
		//得到属性的iri
		String pvIri = subIriString.split("#")[0]+"#"+propertyString+">";
		boolean IsDataPro = instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = instance.readExistObjectProperty(pvIri);
		if(!IsObjectPro&&!IsDataPro){
			throw new NoPropertyException("实例"+subjectString+"不存在"+propertyString+"属性！");
		}
		//得到已知变量的值	
		subIri = this.GetValue(subjectString);
		if(subIri==null&&GetSelect(subjectString)){
			//如果已知变量是select的变量且一直未被赋值则对其进行初始化
			subIri = instance.readAllInstancesOfClass(subIriString);
			
			SetValue(subjectString, subIri);
			
		}
		
		//遍历subIri 看实例的property属性是否为值 是的话加入到var1Iri
		try {
			Iterator<String> iterator = subIri.iterator();
			while(iterator.hasNext()){				
				String string = iterator.next();	
				//看实例的property属性是否为值 是的话加入到var1Iri
				 Set<String> setResult = instance.readPropertyValueOfInstance(pvIri, string);
				 if (setResult.size()==0) {
					
					 setResult = null;
				}
				 
				 //得到结果组成的字符串
				 String resultString = "";
				 try {
					
					  Iterator iteratorResult = setResult.iterator();
					    while (iteratorResult.hasNext()) {
							String tempString = (String) iteratorResult.next();
							resultString = resultString + tempString;
							if (iteratorResult.hasNext()) {
								resultString += ",";
							}
					    }
					   
						if(resultString.equals(objectString)){
							
							var1Iri.add(string);
						}
				} catch (NullPointerException e) {
					// TODO: handle exception
					continue;
//					throw new NoPropertyException("实例"+string+"不存在"+propertyString+"属性！");
				}
				  
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("本体"+prifixString+"定义错误或者主语变量"+subjectString+"错误！");
		}
		
		//更新已知变量的值
		this.SetValue(subjectString, var1Iri);
		
		
	}

	/*
	 * 行第一种语法规则的三元组查询函数:5、	已知变量+属性+已知变量
	 */
	
	private void triple_execute_rule5(Map<String, String> args) throws OntoNotDefineExcetion,NoPropertyException, UnkownTripleTypeException{
		// TODO Auto-generated method stub
		
		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
	
		//求出主语已知变量的值
		Set<String> subSet = this.GetValue(subjectString);
		//求出宾语已知变量的值
		Set<String> objSet = this.GetValue(objectString);
	
		if(subSet==null&&objSet!=null){
			triple_execute_rule2(args);
		}else if(subSet!=null&&objSet==null){
		
			triple_execute_rule3(args);
		}else {
			//抛出异常
			throw new UnkownTripleTypeException("主语宾语均为已知，未知的三元组类型");
		
		}
		
	}
	
	/*
	 * 执行完一条filter语句后执行此函数，对三元组进行回溯查询执行
	 */

	public void tirple_excute_racall() throws VarNotDefineException{
		// TODO Auto-generated method stub
		int size = this.Triples.size();
		for (int i = size-1; i>=0; i--) {
			try {
				if(Triples.get(i).tripleMap.get("Subject").startsWith("?")&&Triples.get(i).tripleMap.get("Object").startsWith("?")){
					//判断若主语在FilterVars中出现过且宾语没有在Filter中出现,则调用类型3
					if(GetFilterValue(Triples.get(i).tripleMap.get("Subject"))!=null&&GetFilterValue(Triples.get(i).tripleMap.get("Object"))==null){
						
						triple_execute_rule3(Triples.get(i).tripleMap);
						//将主语当做已知，宾语当做待求
						//最后还要把求出来的变量放入FilterVars
						AddFikterVars(Triples.get(i).tripleMap.get("Object"), GetVarsVar(Triples.get(i).tripleMap.get("Object")));
						
					}else if(GetFilterValue(Triples.get(i).tripleMap.get("Subject"))==null&&GetFilterValue(Triples.get(i).tripleMap.get("Object"))!=null){//判断若主语没有在FilterVars中出现过且宾语在Filter中出现,则调用类型2
						triple_execute_rule2(Triples.get(i).tripleMap);
						//将主语当做待求，宾语当做已知
						//最后还要把求出来的变量放入FilterVars
						AddFikterVars(Triples.get(i).tripleMap.get("Subject"), GetVarsVar(Triples.get(i).tripleMap.get("Subject")));
						
					}else{
						
						continue;//否则继续下一个循环
					}
				}
			} catch (OntoNotDefineExcetion e) {

				// TODO: handle exception
			} catch (NoPropertyException e) {

				// TODO: handle exception
			}
			
			
			
			
		}
		
	}
	
	/*
	 * 进行整个filter解算的函数
	 */
	
	public void filter_excute(SparqlParser.FilterContext ctx) throws VarNotDefineException, NoSelectVarException{

		index = new int[this.FilterVars.size()];
		//现在FilterVar储存约束需要的变量，那么根据其个数判断需要多少成for循环

			filter_loop(this.FilterVars.size()-1,ctx);
			filter_excute_update();		
	}
	
	
	/*
	 * 现在FilterVar储存约束需要的变量，那么根据其个数判断需要多少成for循环
	 */
	private void filter_loop(int count,SparqlParser.FilterContext ctx) throws VarNotDefineException, NoSelectVarException{
		try {
			for(int i = 0; i<this.FilterVars.get(count).IriLength();i++)
			{
				index[count] = i;
				//应将index的属性保存造FilterVars中
				this.FilterVars.get(count).SetIndex(i);
				if(count != 0)
				{
					int temp = count-1;
					filter_loop(temp,ctx);
				}
				
				if(count==0)//到最底层循环 可以调用查询函数了  得到当前Filter
				{
					
					
					//在调用查询函数时根据index对每个变量进行取值
					boolean filterResult = false;
					//判断是函数约束还是操作符约束
					//若为函数约束，则得到函数名，参数的值（通过index得到，应当只有一个实例），调用函数约束执行函数filter_execute_funcRule1得到true或者false来判断当前的index是否满足要求
					//若为操作符约束，则直接调用excute_tree_exper函数得到true或者false来判断当前的index是否满足要求
					if(ctx.constraint().expression()!=null){
						//操作符约束，调用excute_tree_exper
						filterResult = Boolean.parseBoolean(filter_excute_exper(ctx.constraint().expression()));
					}else if(ctx.constraint().functionList() != null){
			
						//函数约束
						//得到函数的名称，得到参数的个数，得到参数的名称，然后调用相应的函数进行查询
						Map<String,String> funcMap = new HashMap<String, String>();
						//得到函数名称 只考虑一个函数名称
						String funcnameString = ctx.constraint().functionList().function().get(0).ID().getText();
						//得到参数个数
						String paramscountString =Integer.toString(ctx.constraint().functionList().function().get(0).paramDeclList().expression().size());
						//得到参数名称字符串
						String paramsString = ctx.constraint().functionList().function().get(0).paramDeclList().getText();
						funcMap.put("FuncName", funcnameString);
						funcMap.put("ParamsCount", paramscountString);
						funcMap.put("Params", paramsString);
						filterResult = Boolean.parseBoolean(filter_excute_func(funcMap));
						
					}
					//if（满足约束条件）保存当前的index IndexSet.add(index);
					if(filterResult){
						int[] temp = new int[index.length];
						for(int j = 0;j<temp.length;j++){
							temp[j] = index[j];
						}
						IndexSet.add(temp);					
					}
					Iterator iterator1 = this.IndexSet.iterator();//对满足条件的index遍历

				}
														
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw  new VarNotDefineException("存在未定义变量！"+"\n");
		}
		
		
		return;

	}
	
	/*
	 * 总的函数约束的执行函数，包括首先要判断函数约束的类型，再调用相应的函数
	 */
	private String filter_excute_func(Map<String ,String>args) throws NoSelectVarException{
		//首先判断函数的名称
		String funcNameString = args.get("FuncName");//函数的名称
		String paramString = args.get("Params");		
		String[] paramsString = paramString.split(",");//存储参数名称的字符串数组
		
		int paramsCount = paramsString.length;
		//取出每一个参数的iri
		String var1iriString = "";
		String var2iriString = "";

		var1iriString = find_i_iri(paramsString[0]);//此时的结果是一个set<String>形成的字符串
		var2iriString = find_i_iri(paramsString[1]);
		 if(Pattern.compile("opposite",Pattern.CASE_INSENSITIVE).matcher(funcNameString).find()){
			 //调用的opposite函数
			 if(paramsCount==2){
				return String.valueOf(Opposite(var1iriString, var2iriString));
				 //两个参数用来判断 返回true false 判断两个实例是否有对面的关系
			 }
		 }else  if(Pattern.compile("Adjacent",Pattern.CASE_INSENSITIVE).matcher(funcNameString).find()){
			//调用的Adjacent函数
			 if(paramsCount==2){
				//两个参数用来判断 返回true false 判断两个实例是否有相邻的关系
			 }
		 }else  if(Pattern.compile("Contained",Pattern.CASE_INSENSITIVE).matcher(funcNameString).find()){
			//调用的Contained函数
			 
					//两个参数用来判断 返回true false 判断两个实例是否有包含的关系 第一个参数包含第二个参数
				
		 }else  if(Pattern.compile("Contain",Pattern.CASE_INSENSITIVE).matcher(funcNameString).find()){
			//调用的Contain函数
		 }else if(Pattern.compile("Distance",Pattern.CASE_INSENSITIVE).matcher(funcNameString).find()){
			//调用的Distance函数
			 //一定是两个参数
			 return "5";
		 }else if(Pattern.compile("Direction",Pattern.CASE_INSENSITIVE).matcher(funcNameString).find()){
			//调用的Direction函数
			 //一定是两个参数
		 }
				
		return null;
	}
	
	/*
	 * 执行第一种filter约束语法规则的查询逻辑：返回true false的函数语法规则
	 */
	private boolean filter_execute_funcRule1 (Map<String ,String>args){
		return true;
	}
	
	
	/*
	 * 执行第二种filter约束语法规则的查询逻辑：返回数值的函数语法规则
	 */
	private double filter_execute_funcRule2 (Map<String ,String>args){
		return 50;
	}
	
	
	/*
	 * 执行第三种filter约束语法规则的查询逻辑：返回iri字符串集函数语法规则
	 */
	private Set<String> filter_execute_funcRule3 (Map<String ,String>args){
		Set<String> set = new HashSet<String>();
		return set;
	}
	
	
	/*
	 * 对于操作符语法规则的逻辑查询执行函数，参数为以expression为根节点的树，在循环嵌套的过程中遍历树完成全部的查询工作
	 */
	
	private String filter_excute_exper(ParseTree  expression) throws NoSelectVarException{

		//得到当前操作符语句的操作符
		String operation;
		//表示两个操作符的值，用字符串表示，结果只有boolean好double两种情况，但都用string类型来表示
		String str_result_left,str_result_right;
		
		if(expression.getChildCount()==3){
			operation = expression.getChild(1).getText();
			str_result_left = filter_excute_exper(expression.getChild(0));//求得第一个操作数的值
			str_result_right = filter_excute_exper(expression.getChild(2));//求得第二个操作数的值
			
			if(str_result_left.startsWith("\"")){
				str_result_left = str_result_left.split("\"")[1];
			}
			if(str_result_right.startsWith("\"")){
				str_result_right = str_result_right.split("\"")[1];
			}
			double temp;
			boolean temp1;
			switch (operation) {
			case "+":
				temp = Double.parseDouble(str_result_left) + Double.parseDouble(str_result_right);
				return Double.toString(temp);
			case "-":
				temp = Double.parseDouble(str_result_left) - Double.parseDouble(str_result_right);
				return Double.toString(temp);
			case ">":
				temp1 = (Double.parseDouble(str_result_left)>Double.parseDouble(str_result_right));
				return String.valueOf(temp1);
			case "=":
				temp1 = (Double.parseDouble(str_result_left)==Double.parseDouble(str_result_right));
				return String.valueOf(temp1);
			case "<":
				temp1 = (Double.parseDouble(str_result_left)<Double.parseDouble(str_result_right));
				return String.valueOf(temp1);

			default:
				break;
			}
		}
		if(expression.getChildCount()==2){
			operation = expression.getChild(0).getText();
			str_result_left = filter_excute_exper(expression.getChild(1));//求得操作数的值
			switch (operation) {
			case "!":
				boolean temp = !Boolean.parseBoolean(str_result_left);
				return String.valueOf(temp);
				

			default:
				break;
			}
		}
		if(expression.getChildCount()==1){
			
			//此时的expression有两种情况 第一种情况exprassion是一个值，第二种情况expression是一个函数
			//获取primaryExpression节点，判断他的类型：function numericLiteral rdfLiteral boolean
			if (expression.getChild(0).getChild(0).getChildCount()>1) {//类型为函数
				//调用函数查询函数
				
				//得到函数的名称，得到参数的个数，得到参数的名称，然后调用相应的函数进行查询
				Map<String,String> funcMap = new HashMap<String, String>();
				//得到函数名称 只考虑一个函数名称
				String funcnameString = expression.getChild(0).getChild(0).getChild(0).getText();
				String paramsString = "";
				if (expression.getChild(0).getChild(0).getChildCount()>2)
				{
				//得到参数名称字符串
					paramsString = expression.getChild(0).getChild(0).getChild(2).getText();
				}
				else {
					paramsString = expression.getChild(0).getChild(0).getChild(1).getText();
				}
				
				
				funcMap.put("FuncName", funcnameString);
				funcMap.put("Params", paramsString);
				String funcResult = filter_excute_func(funcMap);
//				return Double.toString(Distance("iri1","iri2"));
				return funcResult;
				
			}else {
				//类型为数值、字符串,均返回字符串类型
				//类型也有可能是iri的变量
				//则根据index进行取值，返回读取到的结果
				if(expression.getChild(0).getText().startsWith("?")){

					return find_i_iri(expression.getChild(0).getText());
				}
				return expression.getChild(0).getText();
			}
		}
		
		return "";
	}
	
	
	/*
	 * 执行完一个filter约束语句后对约束的变量进行更新到Vars变量中
	 */
	private void filter_excute_update() throws VarNotDefineException, NoSelectVarException{

		//最终根据IndexSet对Vars中的变量进行约束
		//首先对FilterVars的变量约束，之后再用FilterVars对Vars进行覆盖

		try {
			for (int i = 0; i < FilterVars.size(); i++) {
				String nameString = FilterVars.get(i).VarName();
				Set<String> set = new HashSet<String>();//保存过滤后的iri
				Iterator iterator = this.IndexSet.iterator();//对满足条件的index遍历
				while(iterator.hasNext()){
					int[] temp = (int[]) iterator.next();
					set.add(FilterVars.get(i).IndexIri(temp[i])); 
				}
				SetValue(nameString, set);
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw  new VarNotDefineException("存在未定义变量！"+"\n");
		}

	}
	
	
	/*
	 * 计算两个本体实例之间的距离
	 */
	private double Distance(String iri1,String iri2){
		return 5;
	}
	
	
	/*
	 * 计算两个本体实例之间的角度
	 */
	private double Direction(String iri1,String iri2){
		return 360;
	}
	
	/*
	 * 判断两个本体实例之间是否存在对面的关系
	 */
	private boolean Opposite(String iri1, String iri2){
		//首先要得到iri1、iri2代表的实例在数据库中存储的id
		String ID1 = IriToID(iri1);
		String ID2 = IriToID(iri2);
//		System.out.print(ID1+","+ID2);
		SpatialCompute spatialCompute = new SpatialCompute("Opposite");
		boolean result = false;
		try {
			result = spatialCompute.judge(ID1, ID2);
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
		return result;
	}
	
	
	/*
	 * 计算得到与参数代表的本体实例有对面关系的本体实例的集合，由iri表示
	 */
	private Set<String> Opposite(String iri1){
		Set<String> oppositeSet = new HashSet<String>();
		//返回的是在数据库中存储的id，怎么变成iri
		return oppositeSet;
	}
	
	/*
	 * 判断两个本体实例之间是否存在相邻的关系
	 */
	private boolean Adjacent(String iri1, String iri2){
		return true;
	}
	
	
	/*
	 * 计算得到与参数代表的本体实例有相邻关系的本体实例的集合，由iri表示
	 */
	private Set<String> Adjacent(String iri1){
		Set<String> oppositeSet = new HashSet<String>();
		return oppositeSet;
	}
	
	
	/*
	 * 判断两个本体实例之间是否存在包含的关系（iri1代表的实例包含iri2代表的实例）
	 */
	private boolean Contained(String iri1, String iri2){
		return true;
	}
	
	
	/*
	 * 计算得到包含iri1代表的实例的本体实例的集合，由iri表示
	 */
	private Set<String> Contain(String iri1){
		Set<String> oppositeSet = new HashSet<String>();
		return oppositeSet;
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 * 判断两个set之间是否有包含关系
	 */
	private boolean SetContains(Set<String>set1,Set<String>set2) {
		Iterator<String> iterator = set2.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			if (set1.contains(string)) {
				continue;
				
			}else {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * 根据变量类IsSelect属性得到最终要查询的变量结果
	 */
	public Map<String,Set<String>> SelectResult(){
		
	
		Map<String, Set<String>> selecetMap = new HashMap<String,Set<String>>();
		Iterator<Variable> iterator = this.Vars.iterator();
		while (iterator.hasNext()) {
			Variable variable = iterator.next();
			
			if(variable.IsSelect){
				selecetMap.put(variable.NameString, GetValue(variable.NameString));							
			}			
		}
		return selecetMap;
	}
	
	
	/*
	 * 根据ID从postgis数据库中将点线面的信息读取出来
	 */
	public Geometry GetGeometry(String ID) throws SQLException{

         Connection conn = null;
		 java.sql.Statement st=null;
		 ResultSet rs=null;
		 String url = "jdbc:postgresql://localhost:5432/postgis_21_sample";
		 String user = "postgres";
		 String password = "admin";
		 JSONObject resultJson = null;
		 try{
			 Class.forName("org.postgresql.Driver");
			 conn = DriverManager.getConnection(url,user,password);
			 st = conn.createStatement();
			 String sql="select ST_AsGeoJSON(geom) from polygon_r_21 where gid="+ID;
			 rs = ((java.sql.Statement) st).executeQuery(sql);
			
			 while(rs.next())
			 {
				 resultJson = JSONObject.fromObject(rs.getObject(1).toString());			
			 }
			 
	     }catch(Exception e){
			 e.printStackTrace();
	     }finally{
	    	  rs.close();
	          st.close();
	          conn.close();
	     }
		Geometry geometry = GeometryFactory.createGeometryBase(resultJson );
		return geometry;
	}
	
	
	/*
	 * 根据房间iri得到在数据库中保存的id值
	 */
	private String IriToID(String IRI) {
		String idString = "";
		 String owlFilePath = "ontology/building.owl"; /* OWL文件路径 */
	        OWL instance = new OWL(owlFilePath);
	        String pvIri = "<http://www.semanticweb.org/dell327/ontologies/2014/10/Ontology1415628375607.owl#ObjID_2D>";	     
	        Set<String> result = instance.readPropertyValueOfInstance(pvIri, IRI);
	        Iterator iterator = result.iterator();
	        if (iterator.hasNext()) {
	        	idString = (String) iterator.next();
			}
	    if (idString.startsWith("\"")) {
			idString = idString.split("\"")[1];
		}
		return idString;
	}
	
	/*
	 * 存储查询过程中需要的变量。包括Prefix以及一些未知和带入的变量
	 */
	public ArrayList<Variable> Vars;//在查询过程中用到的变量
	public ArrayList<Triple> Triples;
	private int[] index;//保存在计算约束时此时的index
	private Set<int[]> IndexSet;//保存满足条件的index的集合
	String owlFilePath = "ontology/building.owl"; /* OWL文件路径 */
    OWL instance;//读取wol的实例
	public ArrayList<Variable> FilterVars;//存储约束过滤式需要的变量
}
