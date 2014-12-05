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
	 * ���캯��
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
	 * ���ݱ������ƻ�ñ���ֵ
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
	 * λ����Ϊname�ı�����ֵ
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
		Iterator<Variable> iterator = this.FilterVars.iterator();
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
	 * �õ�����Ϊname�ı�����IsSelect���Ե�ֵ
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
	 * �������Ʒ���Variable���͵ı���
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
	 * ���Vars�����ĺ��� �ж��ظ���
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
	 * ���Vars�����ĺ��� �ж��ظ���
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
				throw new VarNotDefineException("����"+name+"û�ж��壡");
			}
			
		}
		this.FilterVars.add(var);
	}
	
	

	
	/*
	 * �ҵ��ڼ���Լ��ʱ����ǰѭ���£�����Ϊname�ı����ڵ�indexλ�õ�iri��index��Ϊѭ���µ�ֵ
	 * �����ں���Լ�������Ĳ�������һ��ʵ������ôͨ���˺��������õ�����Ϊname�ı�������һ��ʵ��
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
	 * �ܵ���Ԫ��ִ�к���
	 */

	public void triple_excute(Map<String, String> paramMap) throws UnkownTripleTypeException,NoPropertyException,OntoNotDefineExcetion {
		// TODO Auto-generated method stub
		//���ú����ж���Ԫ���﷨�Ĺ���
		
				//���ݲ�ͬ���﷨����
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
					throw new UnkownTripleTypeException("��������Ϊֵ��δ֪����Ԫ������");
				case 7:
					throw new UnkownTripleTypeException("����Ϊֵ��δ֪����Ԫ������");
				case 8:
					throw new UnkownTripleTypeException("��������Ϊ���������δ֪����Ԫ������");
				case 9:
					throw new UnkownTripleTypeException("����Ϊֵ��δ֪����Ԫ������");
				default:
					break;
				}
	}

	/*
	 * ���ݴ���Ĳ������ж���Ԫ��������һ������
	 */
	
	private int judge_triple_condition(Map<String, String> paramMap){
		
		//1:������� 2����֪���� 3��ֵ
		String var1 = paramMap.get("Subject");
		String var2 = paramMap.get("Object");
		
		int type1 = 0,type2 = 0;//�ֱ�����һ���͵ڶ���Ԫ�ص�����
		int resultType = 0;//������Ԫ�������
		
		//�õ���һ��Ԫ�ص�����
		if(var1.charAt(0)=='?'){//˵��һ���Ǳ������������������֪����
			if(GetValue(var1)!=null||GetSelect(var1)){
				
				//��Vars��Ѱ�ң���û���ҵ�˵��һ���Ǵ������������Ϊ��֪����
				type1 = 2;
			}else {
				type1 = 1;
			}
		}else{
			type1 = 3;//��������Ϊֵ
		}
		
		//�õ���һ��Ԫ�ص�����
		if(var2.charAt(0)=='?'){//˵��һ���Ǳ������������������֪����
			if(GetValue(var2)!=null||GetSelect(var2)){
				//��Vars��Ѱ�ң���û���ҵ�˵��һ���Ǵ������������Ϊ��֪����
				type2 = 2;
			}
			else {
				type2 = 1;//��֪����
			}
		}else{
			type2 = 3;//��������Ϊֵ
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
	 * ִ�е�һ���﷨�������Ԫ���ѯ����:1��	�������+����+ֵ
	 */	
	private void triple_execute_rule1 (Map<String ,String>args) throws OntoNotDefineExcetion,NoPropertyException{
		
		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
		Set<String> var1Iri = new HashSet<String>();
		Set<String> tempIri = new HashSet<String>();
		//�õ������iri
		String subIriString = "";
		Set<String> set =  this.GetValue(prifixString);
		try {
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				subIriString = it.next();
				
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("����"+prifixString+"δ���壡");
		}
		
		//�õ����Ե�iri
		String pvIri = subIriString.split("#")[0]+"#"+propertyString+">";
		boolean IsDataPro = instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = instance.readExistObjectProperty(pvIri);
		
		if(!IsObjectPro&&!IsDataPro){
			
			throw new NoPropertyException("ʵ��"+subjectString+"������"+propertyString+"���ԣ�");
		}
		
		//�������������ʵ����ֵ��tempIri		
		if(GetValue(subjectString)!=null){
			
			tempIri = GetValue(subjectString);
		}else {
			tempIri = instance.readAllInstancesOfClass(subIriString);
		}
		
		try {
			//����tempIri ��ʵ����property�����Ƿ�Ϊֵ �ǵĻ����뵽var1Iri
			Iterator<String> iterator = tempIri.iterator();
			while(iterator.hasNext()){
				
				String string = iterator.next();
				
				//��ʵ����property�����Ƿ�Ϊֵ �ǵĻ����뵽var1Iri
				 Set<String> setResult = instance.readPropertyValueOfInstance(pvIri, string);
				 if (setResult.size()==0) {
					 setResult = null;
				}
				 //�õ������ɵ��ַ���
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
//					throw new NoPropertyException("ʵ��"+string+"������"+propertyString+"���ԣ�");
				}
				   
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("����"+prifixString+"�����������������"+subjectString+"����");
		}
		
		
		//��ӱ�����Vars						
		Map<String, Set<String>> var1Map = new HashMap<String,Set<String>>();
		var1Map.put(subjectString, var1Iri);
		Variable var1 = new Variable(subjectString,var1Map);
		//���������������������䱣��
		this.AddVars(subjectString, var1);
		this.SetValue(subjectString, var1Iri);
	}
	
	
	/*
	 * ִ�е�һ���﷨�������Ԫ���ѯ����:2��	�������+����+��֪����
	 */
	
	private void triple_execute_rule2 (Map<String ,String>args) throws OntoNotDefineExcetion,NoPropertyException{
		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
		Set<String> tempIri = new HashSet<String>();
		Set<String> var1Iri = new HashSet<String>();
		//���ȵõ���֪������Set<String>
		Set<String> objectSet = this.GetValue(objectString);
		
		//��objectSetΪ�ս�objectSet��ֵΪowl����ȫ����ʵ��
		boolean isObjNull = false;
		if (objectSet==null&&GetSelect(objectString)) {
			isObjNull = true;//Ϊ��
			objectSet = instance.readAllInstances();
		}
		
		//�õ������iri
		String subIriString = "";
		Set<String> set =  this.GetValue(prifixString);
		try {
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				subIriString = it.next();
				
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("ʵ��"+prifixString+"δ���壡");
		}
		
		//�õ���������Ĺ���ǰ��ʵ��
		if(GetValue(subjectString)!=null){
			
			tempIri = GetValue(subjectString);
			
		}else {
			tempIri = instance.readAllInstancesOfClass(subIriString);
		}
		
		
		//�õ����Ե�iri
		String pvIri = subIriString.split("#")[0]+"#"+propertyString+">";
		boolean IsDataPro = instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = instance.readExistObjectProperty(pvIri);
		if(!IsObjectPro&&!IsDataPro){
			throw new NoPropertyException("ʵ��"+subjectString+"������"+propertyString+"���ԣ�");
		}
		try {
			//����tempIri�ҵ���������Ҫ���ʵ��
			Iterator<String> iterator = tempIri.iterator();

			while (objectSet.size()!=0&&iterator.hasNext()) {
				String string = (String) iterator.next();//����ʵ��
				Set<String> setResult = instance.readPropertyValueOfInstance(pvIri, string);
				if (setResult.size()==0) {
					continue;
//					throw new NoPropertyException("ʵ��"+string+"������"+propertyString+"���ԣ�");
				
				}

					if(SetContains(objectSet, setResult)){
						var1Iri.add(string);
					}
				
				
			}
			
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("����"+prifixString+"�����������������"+subjectString+"����");
		}
		
		Map<String, Set<String>> var1Map = new HashMap<String,Set<String>>();
		var1Map.put(subjectString, var1Iri);
		Variable var1 = new Variable(subjectString,var1Map);
		//���������������������䱣��
		this.AddVars(subjectString, var1);
	
		this.SetValue(subjectString, var1Iri);
		
	}
	
		
	/*
	 * �е�һ���﷨�������Ԫ���ѯ����:3��	��֪����+����+�������
	 */

	private void triple_execute_rule3 (Map<String ,String>args) throws OntoNotDefineExcetion,NoPropertyException{

		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
		//�����ж���֪������Set�Ƿ�Ϊ�գ���Ϊ�գ��������ֵ����Ϊ�丳ֵ��Vars
		Set<String> subSet = this.GetValue(subjectString);
		//�õ������iri
		String subIriString = "";
		Set<String> set =  this.GetValue(prifixString);
		try {
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				subIriString = it.next();
				
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("ʵ��"+prifixString+"δ���壡");
		}
		
		Set<String> tempIri = new HashSet<String>();
		if (subSet==null&&GetSelect(subjectString)) {
			tempIri = instance.readAllInstancesOfClass(subIriString);
			this.SetValue(subjectString, tempIri);
			subSet = this.GetValue(subjectString);
			
			
		}
		
		
		//�õ�����iri
		Set<String> var1Iri = new HashSet<String>();
		
		String pvIri = subIriString.split("#")[0]+"#"+propertyString+">";
		boolean IsDataPro = instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = instance.readExistObjectProperty(pvIri);
		if(!IsObjectPro&&!IsDataPro){
			throw new NoPropertyException("ʵ��"+subjectString+"������"+propertyString+"���ԣ�");
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
//					throw new NoPropertyException("ʵ��"+string+"������"+propertyString+"���ԣ�");
				}finally{
					continue;
				}
			   

			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("����"+prifixString+"�����������������"+subjectString+"����");
		}
		
		
	
		
		
		Map<String, Set<String>> var1Map = new HashMap<String,Set<String>>();
		var1Map.put(objectString, var1Iri);		
		Variable var1 = new Variable(objectString,var1Map);				
		//���������������������䱣��
		this.AddVars(objectString, var1);
		this.SetValue(objectString, var1Iri);
									
	}
	
	
	/*
	 * �е�һ���﷨�������Ԫ���ѯ����:4��	��֪����+����+ֵ
	 */
	
	private void triple_execute_rule4(Map<String, String> args) throws OntoNotDefineExcetion,NoPropertyException{
		// TODO Auto-generated method stub
		

		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
		Set<String> var1Iri = new HashSet<String>();
		Set<String> subIri = new HashSet<String>();
		//�õ�����iri
		String subIriString = "";
		Set<String> set =  this.GetValue(prifixString);
		try {
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				subIriString = it.next();
				
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("ʵ��"+prifixString+"δ���壡");
		}
		
		//�õ����Ե�iri
		String pvIri = subIriString.split("#")[0]+"#"+propertyString+">";
		boolean IsDataPro = instance.readExistDataProperty(pvIri);
		boolean IsObjectPro = instance.readExistObjectProperty(pvIri);
		if(!IsObjectPro&&!IsDataPro){
			throw new NoPropertyException("ʵ��"+subjectString+"������"+propertyString+"���ԣ�");
		}
		//�õ���֪������ֵ	
		subIri = this.GetValue(subjectString);
		if(subIri==null&&GetSelect(subjectString)){
			//�����֪������select�ı�����һֱδ����ֵ�������г�ʼ��
			subIri = instance.readAllInstancesOfClass(subIriString);
			
			SetValue(subjectString, subIri);
			
		}
		
		//����subIri ��ʵ����property�����Ƿ�Ϊֵ �ǵĻ����뵽var1Iri
		try {
			Iterator<String> iterator = subIri.iterator();
			while(iterator.hasNext()){				
				String string = iterator.next();	
				//��ʵ����property�����Ƿ�Ϊֵ �ǵĻ����뵽var1Iri
				 Set<String> setResult = instance.readPropertyValueOfInstance(pvIri, string);
				 if (setResult.size()==0) {
					
					 setResult = null;
				}
				 
				 //�õ������ɵ��ַ���
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
//					throw new NoPropertyException("ʵ��"+string+"������"+propertyString+"���ԣ�");
				}
				  
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new OntoNotDefineExcetion("����"+prifixString+"�����������������"+subjectString+"����");
		}
		
		//������֪������ֵ
		this.SetValue(subjectString, var1Iri);
		
		
	}

	/*
	 * �е�һ���﷨�������Ԫ���ѯ����:5��	��֪����+����+��֪����
	 */
	
	private void triple_execute_rule5(Map<String, String> args) throws OntoNotDefineExcetion,NoPropertyException, UnkownTripleTypeException{
		// TODO Auto-generated method stub
		
		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
	
		//���������֪������ֵ
		Set<String> subSet = this.GetValue(subjectString);
		//���������֪������ֵ
		Set<String> objSet = this.GetValue(objectString);
	
		if(subSet==null&&objSet!=null){
			triple_execute_rule2(args);
		}else if(subSet!=null&&objSet==null){
		
			triple_execute_rule3(args);
		}else {
			//�׳��쳣
			throw new UnkownTripleTypeException("��������Ϊ��֪��δ֪����Ԫ������");
		
		}
		
	}
	
	/*
	 * ִ����һ��filter����ִ�д˺���������Ԫ����л��ݲ�ѯִ��
	 */

	public void tirple_excute_racall() throws VarNotDefineException{
		// TODO Auto-generated method stub
		int size = this.Triples.size();
		for (int i = size-1; i>=0; i--) {
			try {
				if(Triples.get(i).tripleMap.get("Subject").startsWith("?")&&Triples.get(i).tripleMap.get("Object").startsWith("?")){
					//�ж���������FilterVars�г��ֹ��ұ���û����Filter�г���,���������3
					if(GetFilterValue(Triples.get(i).tripleMap.get("Subject"))!=null&&GetFilterValue(Triples.get(i).tripleMap.get("Object"))==null){
						
						triple_execute_rule3(Triples.get(i).tripleMap);
						//�����ﵱ����֪�����ﵱ������
						//���Ҫ��������ı�������FilterVars
						AddFikterVars(Triples.get(i).tripleMap.get("Object"), GetVarsVar(Triples.get(i).tripleMap.get("Object")));
						
					}else if(GetFilterValue(Triples.get(i).tripleMap.get("Subject"))==null&&GetFilterValue(Triples.get(i).tripleMap.get("Object"))!=null){//�ж�������û����FilterVars�г��ֹ��ұ�����Filter�г���,���������2
						triple_execute_rule2(Triples.get(i).tripleMap);
						//�����ﵱ�����󣬱��ﵱ����֪
						//���Ҫ��������ı�������FilterVars
						AddFikterVars(Triples.get(i).tripleMap.get("Subject"), GetVarsVar(Triples.get(i).tripleMap.get("Subject")));
						
					}else{
						
						continue;//���������һ��ѭ��
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
	 * ��������filter����ĺ���
	 */
	
	public void filter_excute(SparqlParser.FilterContext ctx) throws VarNotDefineException, NoSelectVarException{

		index = new int[this.FilterVars.size()];
		//����FilterVar����Լ����Ҫ�ı�������ô����������ж���Ҫ���ٳ�forѭ��

			filter_loop(this.FilterVars.size()-1,ctx);
			filter_excute_update();		
	}
	
	
	/*
	 * ����FilterVar����Լ����Ҫ�ı�������ô����������ж���Ҫ���ٳ�forѭ��
	 */
	private void filter_loop(int count,SparqlParser.FilterContext ctx) throws VarNotDefineException, NoSelectVarException{
		try {
			for(int i = 0; i<this.FilterVars.get(count).IriLength();i++)
			{
				index[count] = i;
				//Ӧ��index�����Ա�����FilterVars��
				this.FilterVars.get(count).SetIndex(i);
				if(count != 0)
				{
					int temp = count-1;
					filter_loop(temp,ctx);
				}
				
				if(count==0)//����ײ�ѭ�� ���Ե��ò�ѯ������  �õ���ǰFilter
				{
					
					
					//�ڵ��ò�ѯ����ʱ����index��ÿ����������ȡֵ
					boolean filterResult = false;
					//�ж��Ǻ���Լ�����ǲ�����Լ��
					//��Ϊ����Լ������õ���������������ֵ��ͨ��index�õ���Ӧ��ֻ��һ��ʵ���������ú���Լ��ִ�к���filter_execute_funcRule1�õ�true����false���жϵ�ǰ��index�Ƿ�����Ҫ��
					//��Ϊ������Լ������ֱ�ӵ���excute_tree_exper�����õ�true����false���жϵ�ǰ��index�Ƿ�����Ҫ��
					if(ctx.constraint().expression()!=null){
						//������Լ��������excute_tree_exper
						filterResult = Boolean.parseBoolean(filter_excute_exper(ctx.constraint().expression()));
					}else if(ctx.constraint().functionList() != null){
			
						//����Լ��
						//�õ����������ƣ��õ������ĸ������õ����������ƣ�Ȼ�������Ӧ�ĺ������в�ѯ
						Map<String,String> funcMap = new HashMap<String, String>();
						//�õ��������� ֻ����һ����������
						String funcnameString = ctx.constraint().functionList().function().get(0).ID().getText();
						//�õ���������
						String paramscountString =Integer.toString(ctx.constraint().functionList().function().get(0).paramDeclList().expression().size());
						//�õ����������ַ���
						String paramsString = ctx.constraint().functionList().function().get(0).paramDeclList().getText();
						funcMap.put("FuncName", funcnameString);
						funcMap.put("ParamsCount", paramscountString);
						funcMap.put("Params", paramsString);
						filterResult = Boolean.parseBoolean(filter_excute_func(funcMap));
						
					}
					//if������Լ�����������浱ǰ��index IndexSet.add(index);
					if(filterResult){
						int[] temp = new int[index.length];
						for(int j = 0;j<temp.length;j++){
							temp[j] = index[j];
						}
						IndexSet.add(temp);					
					}
					Iterator iterator1 = this.IndexSet.iterator();//������������index����

				}
														
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw  new VarNotDefineException("����δ���������"+"\n");
		}
		
		
		return;

	}
	
	/*
	 * �ܵĺ���Լ����ִ�к�������������Ҫ�жϺ���Լ�������ͣ��ٵ�����Ӧ�ĺ���
	 */
	private String filter_excute_func(Map<String ,String>args) throws NoSelectVarException{
		//�����жϺ���������
		String funcNameString = args.get("FuncName");//����������
		String paramString = args.get("Params");		
		String[] paramsString = paramString.split(",");//�洢�������Ƶ��ַ�������
		
		int paramsCount = paramsString.length;
		//ȡ��ÿһ��������iri
		String var1iriString = "";
		String var2iriString = "";

		var1iriString = find_i_iri(paramsString[0]);//��ʱ�Ľ����һ��set<String>�γɵ��ַ���
		var2iriString = find_i_iri(paramsString[1]);
		 if(Pattern.compile("opposite",Pattern.CASE_INSENSITIVE).matcher(funcNameString).find()){
			 //���õ�opposite����
			 if(paramsCount==2){
				return String.valueOf(Opposite(var1iriString, var2iriString));
				 //�������������ж� ����true false �ж�����ʵ���Ƿ��ж���Ĺ�ϵ
			 }
		 }else  if(Pattern.compile("Adjacent",Pattern.CASE_INSENSITIVE).matcher(funcNameString).find()){
			//���õ�Adjacent����
			 if(paramsCount==2){
				//�������������ж� ����true false �ж�����ʵ���Ƿ������ڵĹ�ϵ
			 }
		 }else  if(Pattern.compile("Contained",Pattern.CASE_INSENSITIVE).matcher(funcNameString).find()){
			//���õ�Contained����
			 
					//�������������ж� ����true false �ж�����ʵ���Ƿ��а����Ĺ�ϵ ��һ�����������ڶ�������
				
		 }else  if(Pattern.compile("Contain",Pattern.CASE_INSENSITIVE).matcher(funcNameString).find()){
			//���õ�Contain����
		 }else if(Pattern.compile("Distance",Pattern.CASE_INSENSITIVE).matcher(funcNameString).find()){
			//���õ�Distance����
			 //һ������������
			 return "5";
		 }else if(Pattern.compile("Direction",Pattern.CASE_INSENSITIVE).matcher(funcNameString).find()){
			//���õ�Direction����
			 //һ������������
		 }
				
		return null;
	}
	
	/*
	 * ִ�е�һ��filterԼ���﷨����Ĳ�ѯ�߼�������true false�ĺ����﷨����
	 */
	private boolean filter_execute_funcRule1 (Map<String ,String>args){
		return true;
	}
	
	
	/*
	 * ִ�еڶ���filterԼ���﷨����Ĳ�ѯ�߼���������ֵ�ĺ����﷨����
	 */
	private double filter_execute_funcRule2 (Map<String ,String>args){
		return 50;
	}
	
	
	/*
	 * ִ�е�����filterԼ���﷨����Ĳ�ѯ�߼�������iri�ַ����������﷨����
	 */
	private Set<String> filter_execute_funcRule3 (Map<String ,String>args){
		Set<String> set = new HashSet<String>();
		return set;
	}
	
	
	/*
	 * ���ڲ������﷨������߼���ѯִ�к���������Ϊ��expressionΪ���ڵ��������ѭ��Ƕ�׵Ĺ����б��������ȫ���Ĳ�ѯ����
	 */
	
	private String filter_excute_exper(ParseTree  expression) throws NoSelectVarException{

		//�õ���ǰ���������Ĳ�����
		String operation;
		//��ʾ������������ֵ�����ַ�����ʾ�����ֻ��boolean��double���������������string��������ʾ
		String str_result_left,str_result_right;
		
		if(expression.getChildCount()==3){
			operation = expression.getChild(1).getText();
			str_result_left = filter_excute_exper(expression.getChild(0));//��õ�һ����������ֵ
			str_result_right = filter_excute_exper(expression.getChild(2));//��õڶ�����������ֵ
			
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
			str_result_left = filter_excute_exper(expression.getChild(1));//��ò�������ֵ
			switch (operation) {
			case "!":
				boolean temp = !Boolean.parseBoolean(str_result_left);
				return String.valueOf(temp);
				

			default:
				break;
			}
		}
		if(expression.getChildCount()==1){
			
			//��ʱ��expression��������� ��һ�����exprassion��һ��ֵ���ڶ������expression��һ������
			//��ȡprimaryExpression�ڵ㣬�ж��������ͣ�function numericLiteral rdfLiteral boolean
			if (expression.getChild(0).getChild(0).getChildCount()>1) {//����Ϊ����
				//���ú�����ѯ����
				
				//�õ����������ƣ��õ������ĸ������õ����������ƣ�Ȼ�������Ӧ�ĺ������в�ѯ
				Map<String,String> funcMap = new HashMap<String, String>();
				//�õ��������� ֻ����һ����������
				String funcnameString = expression.getChild(0).getChild(0).getChild(0).getText();
				String paramsString = "";
				if (expression.getChild(0).getChild(0).getChildCount()>2)
				{
				//�õ����������ַ���
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
				//����Ϊ��ֵ���ַ���,�������ַ�������
				//����Ҳ�п�����iri�ı���
				//�����index����ȡֵ�����ض�ȡ���Ľ��
				if(expression.getChild(0).getText().startsWith("?")){

					return find_i_iri(expression.getChild(0).getText());
				}
				return expression.getChild(0).getText();
			}
		}
		
		return "";
	}
	
	
	/*
	 * ִ����һ��filterԼ�������Լ���ı������и��µ�Vars������
	 */
	private void filter_excute_update() throws VarNotDefineException, NoSelectVarException{

		//���ո���IndexSet��Vars�еı�������Լ��
		//���ȶ�FilterVars�ı���Լ����֮������FilterVars��Vars���и���

		try {
			for (int i = 0; i < FilterVars.size(); i++) {
				String nameString = FilterVars.get(i).VarName();
				Set<String> set = new HashSet<String>();//������˺��iri
				Iterator iterator = this.IndexSet.iterator();//������������index����
				while(iterator.hasNext()){
					int[] temp = (int[]) iterator.next();
					set.add(FilterVars.get(i).IndexIri(temp[i])); 
				}
				SetValue(nameString, set);
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw  new VarNotDefineException("����δ���������"+"\n");
		}

	}
	
	
	/*
	 * ������������ʵ��֮��ľ���
	 */
	private double Distance(String iri1,String iri2){
		return 5;
	}
	
	
	/*
	 * ������������ʵ��֮��ĽǶ�
	 */
	private double Direction(String iri1,String iri2){
		return 360;
	}
	
	/*
	 * �ж���������ʵ��֮���Ƿ���ڶ���Ĺ�ϵ
	 */
	private boolean Opposite(String iri1, String iri2){
		//����Ҫ�õ�iri1��iri2�����ʵ�������ݿ��д洢��id
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
	 * ����õ����������ı���ʵ���ж����ϵ�ı���ʵ���ļ��ϣ���iri��ʾ
	 */
	private Set<String> Opposite(String iri1){
		Set<String> oppositeSet = new HashSet<String>();
		//���ص��������ݿ��д洢��id����ô���iri
		return oppositeSet;
	}
	
	/*
	 * �ж���������ʵ��֮���Ƿ�������ڵĹ�ϵ
	 */
	private boolean Adjacent(String iri1, String iri2){
		return true;
	}
	
	
	/*
	 * ����õ����������ı���ʵ�������ڹ�ϵ�ı���ʵ���ļ��ϣ���iri��ʾ
	 */
	private Set<String> Adjacent(String iri1){
		Set<String> oppositeSet = new HashSet<String>();
		return oppositeSet;
	}
	
	
	/*
	 * �ж���������ʵ��֮���Ƿ���ڰ����Ĺ�ϵ��iri1�����ʵ������iri2�����ʵ����
	 */
	private boolean Contained(String iri1, String iri2){
		return true;
	}
	
	
	/*
	 * ����õ�����iri1�����ʵ���ı���ʵ���ļ��ϣ���iri��ʾ
	 */
	private Set<String> Contain(String iri1){
		Set<String> oppositeSet = new HashSet<String>();
		return oppositeSet;
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 * �ж�����set֮���Ƿ��а�����ϵ
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
	 * ���ݱ�����IsSelect���Եõ�����Ҫ��ѯ�ı������
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
	 * ����ID��postgis���ݿ��н����������Ϣ��ȡ����
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
	 * ���ݷ���iri�õ������ݿ��б����idֵ
	 */
	private String IriToID(String IRI) {
		String idString = "";
		 String owlFilePath = "ontology/building.owl"; /* OWL�ļ�·�� */
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
	 * �洢��ѯ��������Ҫ�ı���������Prefix�Լ�һЩδ֪�ʹ���ı���
	 */
	public ArrayList<Variable> Vars;//�ڲ�ѯ�������õ��ı���
	public ArrayList<Triple> Triples;
	private int[] index;//�����ڼ���Լ��ʱ��ʱ��index
	private Set<int[]> IndexSet;//��������������index�ļ���
	String owlFilePath = "ontology/building.owl"; /* OWL�ļ�·�� */
    OWL instance;//��ȡwol��ʵ��
	public ArrayList<Variable> FilterVars;//�洢Լ������ʽ��Ҫ�ı���
}
