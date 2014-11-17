package org.lmars.panmap.parser;

import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;
import org.lmars.sparql.parser.SparqlParser;

public interface SpatialSelectImpl {

	/*
	 * 根据变量名称获得变量值
	 */
	public abstract Set<String> GetValue(String name);

	/*
	 * 位名称为name的变量赋值
	 */

	public abstract void SetValue(String name, Set<String> iris);

	public abstract Set<String> GetFilterValue(String name);

	/*
	 * 位名称为name的变量赋值
	 */

	public abstract void SetFilterValue(String name, Set<String> iris);

	/*
	 * 位名称为name的变量赋值IsSelect属性，以此判断此变量是否为最终查询的变量
	 */
	public abstract void SetSelect(String name);

	/*
	 * 得到名称为name的变量的IsSelect属性的值
	 */
	public abstract boolean GetSelect(String name);

	/*
	 * 执行第一种语法规则的三元组查询函数:1、	待求变量+属性+值
	 */
	public abstract void triple_execute_rule1(Map<String, String> args);

	/*
	 * 执行第一种语法规则的三元组查询函数:2、	待求变量+属性+已知变量
	 */
	public abstract void triple_execute_rule2(Map<String, String> args);

	/*
	 * 行第一种语法规则的三元组查询函数:3、	已知变量+属性+待求变量
	 */
	public abstract void triple_execute_rule3(Map<String, String> args);
	
	
	/*
	 * 行第一种语法规则的三元组查询函数:4、	已知变量+属性+值
	 */
	public abstract void triple_execute_rule4(Map<String, String> args);
	
	/*
	 * 行第一种语法规则的三元组查询函数:5、	已知变量+属性+已知变量
	 */
	public abstract void triple_execute_rule5(Map<String, String> args);

	/*
	 * 对于操作符语法规则的逻辑查询执行函数，参数为以expression为根节点的树，在循环嵌套的过程中遍历树完成全部的查询工作
	 */
	public abstract String filter_excute_exper(ParseTree expression);

	/*
	 * 根据传入的参数来判断三元组属于哪一种类型
	 */
	public abstract int juge_triple_condition(Map<String, String> paramMap);

	/*
	 * 进行整个filter解算的函数
	 */
	public abstract void filter_excute(SparqlParser.FilterContext ctx);

	/*
	 * 添加Vars变量的函数 判断重复性
	 */
	public abstract void AddVars(String name, Variable var);

	/*
	 * 添加FilterVars变量的函数 判断重复性
	 */
	public abstract void AddFikterVars(String name, Variable var);

}