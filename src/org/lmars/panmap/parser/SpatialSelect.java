package org.lmars.panmap.parser;
import org.lmars.sparql.parser.*;
import org.antlr.v4.codegen.model.chunk.ThisRulePropertyRef_ctx;
import org.antlr.v4.parse.ANTLRParser.id_return;
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
public class SpatialSelect implements SpatialSelectImpl{
	
	/*
	 * ���캯��
	 */
	public SpatialSelect() {
		this.Vars = new ArrayList<Variable>();
		this.FilterVars = new ArrayList<Variable>();
		this.IndexSet =new HashSet<int[]>();
		this.instance = new OWL(owlFilePath);
		// TODO Auto-generated constructor stub
	}

	/*
	 * �洢��ѯ��������Ҫ�ı���������Prefix�Լ�һЩδ֪�ʹ���ı���
	 */
	public ArrayList<Variable> Vars;//�ڲ�ѯ�������õ��ı���
	private int[] index;//�����ڼ���Լ��ʱ��ʱ��index
	private Set<int[]> IndexSet;//��������������index�ļ���
	String owlFilePath = "ontology/building.owl"; /* OWL�ļ�·�� */
    OWL instance;//��ȡwol��ʵ��
	
	/*
	 * �洢Լ������ʽ��Ҫ�ı���
	 */
	public ArrayList<Variable> FilterVars;
	
	
	/*
	 * ���ݱ������ƻ�ñ���ֵ
	 */
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#GetValue(java.lang.String)
	 */
	@Override
	public Set<String> GetValue(String name) {
	
//		String[] str = new String[0];
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
		
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#SetValue(java.lang.String, java.util.Set)
	 */
	@Override
	public void SetValue(String name,Set<String> iris) {
		String[] str = new String[0];
		Iterator<Variable> iterator = this.Vars.iterator();
		while (iterator.hasNext()) {
			Variable variable = iterator.next();
			if(variable.varMap.get(name) != null){
				variable.varMap.put(name, iris);
				}
			}
			
		
	}
	
	
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#GetFilterValue(java.lang.String)
	 */
	@Override
	public Set<String> GetFilterValue(String name) {
		
//		String[] str = new String[0];
		Iterator<Variable> iterator = this.FilterVars.iterator();
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
	
	
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#SetFilterValue(java.lang.String, java.util.Set)
	 */
	@Override
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
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#SetSelect(java.lang.String)
	 */
	@Override
	public void SetSelect(String name) {
		
		Iterator<Variable> iterator = this.Vars.iterator();
		while (iterator.hasNext()) {
			Variable variable = iterator.next();
			if(variable.varMap.get(name) != null){
				variable.IsSelect = true;
			}
			
		}
	}
	
	
	/*
	 * �õ�����Ϊname�ı�����IsSelect���Ե�ֵ
	 */
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#GetSelect(java.lang.String)
	 */
	@Override
	public boolean GetSelect(String name) {
		
		Iterator<Variable> iterator = this.Vars.iterator();
		while (iterator.hasNext()) {
			Variable variable = iterator.next();
			if(variable.varMap.get(name) != null){
				return variable.IsSelect;
			}
			
		}
		return false;
	}
	

	
	/*
	 * ���ݱ�����IsSelect���Եõ�����Ҫ��ѯ�ı������
	 */
	public Set<String> SelectResult(){
		Iterator<Variable> iterator = this.Vars.iterator();
		while (iterator.hasNext()) {
			Variable variable = iterator.next();
			if(variable.IsSelect){
		       return variable.VarIri();								
			}			
		}
		return null;
	}
	
	/*
	 * ִ�е�һ���﷨�������Ԫ���ѯ����:1��	�������+����+ֵ
	 */
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#triple_execute_rule1(java.util.Map)
	 */
	@Override
	public void triple_execute_rule1 (Map<String ,String>args){

		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
		Set<String> var1Iri = new HashSet<String>();
		Set<String> tempIri = new HashSet<String>();
		//�õ������iri
		String subIriString = "";
		Set<String> set =  this.GetValue(prifixString);
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			subIriString = it.next();
			
		}
		//�õ����Ե�iri
		String pvIri = subIriString.split("#")[0]+"#"+propertyString+">";
		//���鱾�������ʵ����ֵ��tempIri		
		tempIri = instance.readAllInstancesOfClass(subIriString);
		
		//����tempIri ��ʵ����property�����Ƿ�Ϊֵ �ǵĻ����뵽var1Iri
		Iterator<String> iterator = tempIri.iterator();
		while(iterator.hasNext()){
			
			String string = iterator.next();
			
			//��ʵ����property�����Ƿ�Ϊֵ �ǵĻ����뵽var1Iri
			 Set<String> setResult = instance.readPropertyValueOfInstance(pvIri, string);
			 //�õ������ɵ��ַ���
			 String resultString = "";
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
		}
		//��ӱ�����Vars						
		Map<String, Set<String>> var1Map = new HashMap<String,Set<String>>();
		var1Map.put(subjectString, var1Iri);
		Variable var1 = new Variable(var1Map);
		//���������������������䱣��
		this.AddVars(subjectString, var1);
	}
	
	
	/*
	 * ִ�е�һ���﷨�������Ԫ���ѯ����:2��	�������+����+��֪����
	 */
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#triple_execute_rule2(java.util.Map)
	 */
	@Override
	public void triple_execute_rule2 (Map<String ,String>args){
		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
		Set<String> tempIri = new HashSet<String>();
		Set<String> var1Iri = new HashSet<String>();
		//���ȵõ���֪������Set<String>
		Set<String> objectSet = this.GetValue(objectString);
		//��objectSetΪ�ս�objectSet��ֵΪowl����ȫ����ʵ��
		boolean isObjNull = true;
		if (objectSet.size()==0) {
			isObjNull = true;//Ϊ��
			objectSet = instance.readAllInstances();
		}
		//�õ������iri
		String subIriString = "";
		Set<String> set =  this.GetValue(prifixString);
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			subIriString = it.next();
			
		}
		//�õ���������Ĺ���ǰ��ʵ��
		tempIri = instance.readAllInstancesOfClass(subIriString);
		
		//�õ����Ե�iri
		String pvIri = subIriString.split("#")[0]+"#"+propertyString+">";
		//����tempIri�ҵ���������Ҫ���ʵ��
		Iterator<String> iterator = tempIri.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();//����ʵ��
			Set<String> setResult = instance.readPropertyValueOfInstance(pvIri, string);
			
			if(!isObjNull){
				if(objectSet.equals(setResult)){
					System.out.print("yes2");
					var1Iri.add(string);
			}
			
			}else {
				if(objectSet.contains(setResult)){
					var1Iri.add(string);
					System.out.print("yes2");
				}
			}
			
		}
		
		Map<String, Set<String>> var1Map = new HashMap<String,Set<String>>();
		var1Map.put(subjectString, var1Iri);
		Variable var1 = new Variable(var1Map);
		//���������������������䱣��
		this.AddVars(subjectString, var1);
	}
	
		
	/*
	 * �е�һ���﷨�������Ԫ���ѯ����:3��	��֪����+����+�������
	 */
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#triple_execute_rule3(java.util.Map)
	 */
	@Override
	public void triple_execute_rule3 (Map<String ,String>args){

		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
		//�����ж���֪������Set�Ƿ�Ϊ�գ���Ϊ�գ��������ֵ����Ϊ�丳ֵ��Vars
		Set<String> subSet = this.GetValue(subjectString);
		//�õ������iri
		String subIriString = "";
		Set<String> set =  this.GetValue(prifixString);
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			subIriString = it.next();
			
		}
		Set<String> tempIri = new HashSet<String>();
		if (subSet.size()==0) {
			tempIri = instance.readAllInstancesOfClass(subIriString);
			this.SetValue(subjectString, tempIri);
			subSet = this.GetValue(subjectString);
			
		}
		
		
		//�õ�����iri
		Set<String> var1Iri = new HashSet<String>();
		String pvIri = subIriString.split("#")[0]+"#"+propertyString+">";
		Iterator<String> it1 = subSet.iterator();
		while (it1.hasNext()) {
			String string = (String) it1.next();
			Set<String> setResult = instance.readPropertyValueOfInstance(pvIri, string);
			//��setResult���ϳ��Զ��ŷָ����ַ���
		    String resultString = "";
		    Iterator iterator = setResult.iterator();
		    while (iterator.hasNext()) {
				String tempString = (String) iterator.next();
				resultString = resultString + tempString;
				if (iterator.hasNext()) {
					resultString += ",";
				}
			}
			if(setResult.size()!=0)
			var1Iri.add(resultString);
		}
		
		
		
		Map<String, Set<String>> var1Map = new HashMap<String,Set<String>>();
		var1Map.put(objectString, var1Iri);
		
		Variable var1 = new Variable(var1Map);
		//���������������������䱣��
		this.AddVars(objectString, var1);
		this.SetValue(objectString, var1Iri);
		
	}
	
	
	/*
	 * �е�һ���﷨�������Ԫ���ѯ����:4��	��֪����+����+ֵ
	 */
	@Override
	public void triple_execute_rule4(Map<String, String> args) {
		// TODO Auto-generated method stub
		

		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
		Set<String> var1Iri = new HashSet<String>();
		Set<String> subIri = new HashSet<String>();
		//�õ������iri
		String subIriString = "";
		Set<String> set =  this.GetValue(prifixString);
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			subIriString = it.next();
			
		}
		//�õ����Ե�iri
		String pvIri = subIriString.split("#")[0]+"#"+propertyString+">";
		//�õ���֪������ֵ	
		subIri = this.GetValue(subjectString);
		
		//����subIri ��ʵ����property�����Ƿ�Ϊֵ �ǵĻ����뵽var1Iri
		Iterator<String> iterator = subIri.iterator();
		while(iterator.hasNext()){
			
			String string = iterator.next();			
			//��ʵ����property�����Ƿ�Ϊֵ �ǵĻ����뵽var1Iri
			 Set<String> setResult = instance.readPropertyValueOfInstance(pvIri, string);
			 //�õ������ɵ��ַ���
			 String resultString = "";
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
		}
		
		//������֪������ֵ
		this.SetValue(subjectString, var1Iri);
		
		
	}

	/*
	 * �е�һ���﷨�������Ԫ���ѯ����:5��	��֪����+����+��֪����
	 */
	@Override
	public void triple_execute_rule5(Map<String, String> args) {
		// TODO Auto-generated method stub
		
		String subjectString = args.get("Subject");
		String prifixString = args.get("Prefix");
		String propertyString = args.get("Property");
		String objectString = args.get("Object");
	
		//���������֪������ֵ
		Set<String> subSet = this.GetValue(subjectString);
		//���������֪������ֵ
		Set<String> objSet = this.GetValue(objectString);
		if(subSet.size()==0&&objSet.size()!=0){
			triple_execute_rule2(args);
		}else if(subSet.size()!=0&&objSet.size()==0){
		
			triple_execute_rule3(args);
		}else {
			//�׳��쳣
			System.out.print("both the subject and the object are unknown");
		}
		
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
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#filter_excute_exper(org.antlr.v4.runtime.tree.ParseTree)
	 */
	@Override
	public String filter_excute_exper(ParseTree  expression){

		//�õ���ǰ���������Ĳ�����
		String operation;
		//��ʾ������������ֵ�����ַ�����ʾ�����ֻ��boolean��double���������������string��������ʾ
		String str_result_left,str_result_right;
		
		if(expression.getChildCount()==3){
			operation = expression.getChild(1).getText();
			str_result_left = filter_excute_exper(expression.getChild(0));//��õ�һ����������ֵ
			str_result_right = filter_excute_exper(expression.getChild(2));//��õڶ�����������ֵ
			
			switch (operation) {
			case "+":
				double temp = Double.parseDouble(str_result_left) + Double.parseDouble(str_result_right);
				return Double.toString(temp);
			case ">":
				boolean temp1 = (Double.parseDouble(str_result_left)>Double.parseDouble(str_result_right));
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
				
				return expression.getChild(0).getText();
			}
		}
		
		return "";
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
		return true;
	}
	
	
	/*
	 * ����õ����������ı���ʵ���ж����ϵ�ı���ʵ���ļ��ϣ���iri��ʾ
	 */
	private Set<String> Opposite(String iri1){
		Set<String> oppositeSet = new HashSet<String>();
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
	 * ���ݴ���Ĳ������ж���Ԫ��������һ������
	 */
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#juge_triple_condition(java.util.Map)
	 */
	@Override
	public int juge_triple_condition(Map<String, String> paramMap){
		
		//1:������� 2����֪���� 3��ֵ
		String var1 = paramMap.get("Subject");
		String var2 = paramMap.get("Object");
		
		int type1 = 0,type2 = 0;//�ֱ�����һ���͵ڶ���Ԫ�ص�����
		int resultType = 0;//������Ԫ�������
		
		//�õ���һ��Ԫ�ص�����
		if(var1.charAt(0)=='?'){//˵��һ���Ǳ������������������֪����
			
			if(GetValue(var1)!=null){
				//��Vars��Ѱ�ң���û���ҵ�˵��һ���Ǵ������������Ϊ��֪����
				type1 = 2;
			}else{
				type1 = 1;
			}
		}else{
			type1 = 3;//��������Ϊֵ
		}
		
		//�õ���һ��Ԫ�ص�����
		if(var2.charAt(0)=='?'){//˵��һ���Ǳ������������������֪����
			if(GetValue(var2)!=null){
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
	 * ��������filter����ĺ���
	 */
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#filter_excute(org.lmars.sparql.parser.SparqlParser.FilterContext)
	 */
	@Override
	public void filter_excute(SparqlParser.FilterContext ctx) {

		index = new int[this.FilterVars.size()];
		//����FilterVar����Լ����Ҫ�ı�������ô����������ж���Ҫ���ٳ�forѭ��
		filter_loop(this.FilterVars.size()-1,ctx);
		//���ո���IndexSet��Vars�еı�������Լ��
		//���ȶ�FilterVars�ı���Լ����֮������FilterVars��Vars���и���
		for (int i = 0; i < FilterVars.size(); i++) {
			String nameString = FilterVars.get(i).VarName();
//			Map<String, Set<String>> varmap = new HashMap<String,Set<String>>();
			Set<String> set = new HashSet<String>();//������˺��iri
			Iterator iterator = this.IndexSet.iterator();//������������index����
			while(iterator.hasNext()){
				int[] temp = (int[]) iterator.next();
				set.add(FilterVars.get(i).IndexIri(temp[i])); 
			}
			SetValue(nameString, set);
		}
		
	}
	
	/*
	 * ����FilterVar����Լ����Ҫ�ı�������ô����������ж���Ҫ���ٳ�forѭ��
	 */
	private void filter_loop(int count,SparqlParser.FilterContext ctx){
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
					IndexSet.add(index);
				}
			}

				

				
			
		}
		return;

	}
	
	
	/*
	 * ���Vars�����ĺ��� �ж��ظ���
	 */
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#AddVars(java.lang.String, org.lmars.panmap.parser.Variable)
	 */
	@Override
	public void AddVars(String name,Variable var){
		Iterator iterator = this.Vars.iterator();
		while(iterator.hasNext()){
			Variable variable = (Variable) iterator.next();
			if(variable.varMap.get(name)!=null)
				return;
		}
		this.Vars.add(var);
		
	}
	
	
	/*
	 * ���Vars�����ĺ��� �ж��ظ���
	 */
	/* (non-Javadoc)
	 * @see org.lmars.panmap.parser.SpatialSelectImpl#AddFikterVars(java.lang.String, org.lmars.panmap.parser.Variable)
	 */
	@Override
	public void AddFikterVars(String name,Variable var){
		Iterator iterator = this.FilterVars.iterator();
		while(iterator.hasNext()){
			Variable variable = (Variable) iterator.next();
			if(variable.varMap.get(name)!=null)
				return;
		}
		this.FilterVars.add(var);
	}
	
	
	/*
	 * �ҵ��ڼ���Լ��ʱ����ǰѭ���£�����Ϊname�ı����ڵ�indexλ�õ�iri��index��Ϊѭ���µ�ֵ
	 * �����ں���Լ�������Ĳ�������һ��ʵ������ôͨ���˺��������õ�����Ϊname�ı�������һ��ʵ��
	 */
	private String find_i_iri(String name){
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
	 * �ܵĺ���Լ����ִ�к�������������Ҫ�жϺ���Լ�������ͣ��ٵ�����Ӧ�ĺ���
	 */
	private String filter_excute_func(Map<String ,String>args){
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


}
