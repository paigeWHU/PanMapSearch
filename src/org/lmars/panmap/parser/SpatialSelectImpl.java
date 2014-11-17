package org.lmars.panmap.parser;

import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;
import org.lmars.sparql.parser.SparqlParser;

public interface SpatialSelectImpl {

	/*
	 * ���ݱ������ƻ�ñ���ֵ
	 */
	public abstract Set<String> GetValue(String name);

	/*
	 * λ����Ϊname�ı�����ֵ
	 */

	public abstract void SetValue(String name, Set<String> iris);

	public abstract Set<String> GetFilterValue(String name);

	/*
	 * λ����Ϊname�ı�����ֵ
	 */

	public abstract void SetFilterValue(String name, Set<String> iris);

	/*
	 * λ����Ϊname�ı�����ֵIsSelect���ԣ��Դ��жϴ˱����Ƿ�Ϊ���ղ�ѯ�ı���
	 */
	public abstract void SetSelect(String name);

	/*
	 * �õ�����Ϊname�ı�����IsSelect���Ե�ֵ
	 */
	public abstract boolean GetSelect(String name);

	/*
	 * ִ�е�һ���﷨�������Ԫ���ѯ����:1��	�������+����+ֵ
	 */
	public abstract void triple_execute_rule1(Map<String, String> args);

	/*
	 * ִ�е�һ���﷨�������Ԫ���ѯ����:2��	�������+����+��֪����
	 */
	public abstract void triple_execute_rule2(Map<String, String> args);

	/*
	 * �е�һ���﷨�������Ԫ���ѯ����:3��	��֪����+����+�������
	 */
	public abstract void triple_execute_rule3(Map<String, String> args);
	
	
	/*
	 * �е�һ���﷨�������Ԫ���ѯ����:4��	��֪����+����+ֵ
	 */
	public abstract void triple_execute_rule4(Map<String, String> args);
	
	/*
	 * �е�һ���﷨�������Ԫ���ѯ����:5��	��֪����+����+��֪����
	 */
	public abstract void triple_execute_rule5(Map<String, String> args);

	/*
	 * ���ڲ������﷨������߼���ѯִ�к���������Ϊ��expressionΪ���ڵ��������ѭ��Ƕ�׵Ĺ����б��������ȫ���Ĳ�ѯ����
	 */
	public abstract String filter_excute_exper(ParseTree expression);

	/*
	 * ���ݴ���Ĳ������ж���Ԫ��������һ������
	 */
	public abstract int juge_triple_condition(Map<String, String> paramMap);

	/*
	 * ��������filter����ĺ���
	 */
	public abstract void filter_excute(SparqlParser.FilterContext ctx);

	/*
	 * ���Vars�����ĺ��� �ж��ظ���
	 */
	public abstract void AddVars(String name, Variable var);

	/*
	 * ���FilterVars�����ĺ��� �ж��ظ���
	 */
	public abstract void AddFikterVars(String name, Variable var);

}