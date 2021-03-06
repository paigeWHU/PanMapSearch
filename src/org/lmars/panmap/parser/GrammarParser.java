package org.lmars.panmap.parser;

import org.lmars.panmap.filter.*;
import org.antlr.v4.parse.ANTLRParser.prequelConstruct_return;
import org.antlr.v4.parse.ANTLRParser.sync_return;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.*;
import org.antlr.runtime.tree.BaseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.tool.Rule;
import org.antlr.v4.runtime.CommonTokenStream;
import org.lmars.panmap.exception.NoPropertyException;
import org.lmars.panmap.exception.NoSelectVarException;
import org.lmars.panmap.exception.OntoNotDefineExcetion;
import org.lmars.panmap.exception.UnkownTripleTypeException;
import org.lmars.panmap.exception.VarNotDefineException;
import org.lmars.sparql.parser.SparqlParser.QueryContext;
import org.owlapi.OWL;

import java.util.*;

import org.lmars.sparql.parser.*;
import org.lmars.panmap.triple.*;

import cz.cvut.kbss.owl2query.model.Filter;

public class GrammarParser extends SparqlBaseListener implements GrammarIface {

	private SpatialSelect spatialSelect;
	private String grammerString = "NoFilter";// 标识是否进入到filter语法
	public Map<String, Set<String>> resultSet;

	public GrammarParser() {
		// TODO Auto-generated constructor stub
		resultSet = new HashMap<String, Set<String>>();
		this.spatialSelect = new SpatialSelect();// 创建一个空间查询的对象
	}

	/*
	 * 让用户设置本体文件路径的函数
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.lmars.panmap.parser.GrammarIface#SetOWLFile(java.lang.String)
	 */
	@Override
	public void SetOWLFile(String fileStr) {

		spatialSelect.SetOWLFile(fileStr);
	}

	/*
	 * 让用户设置postgis数据库地址的函数
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.lmars.panmap.parser.GrammarIface#SetPgAddress(java.lang.String)
	 */
	@Override
	public void SetPgAddress(String ipaddress) {
		spatialSelect.SetPgAddress(ipaddress);

	}

	/*
	 * 让用户设置连接postgis数据库用户名和密码的函数
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.lmars.panmap.parser.GrammarIface#SetPgUsernPass(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void SetPgUsernPass(String user, String pass) {

		spatialSelect.SetPgUsernPass(user, pass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.lmars.panmap.parser.GrammarIface#query(java.lang.String)
	 */
	@Override
	public Map<String, Set<String>> query(String expr) throws Exception {

		ANTLRInputStream in = new ANTLRInputStream(expr);
		// 词法分析器
		SparqlLexer lexer = new SparqlLexer(in);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// 语法分析器
		SparqlParser parser = new SparqlParser(tokens);
		ParseTreeWalker walker = new ParseTreeWalker();
		ParseTree treePackage = parser.query();
		// GrammarParser mygrammar = new GrammarParser();
		walker.walk(this, treePackage);
		// name();
		resultSet = spatialSelect.SelectResult();
		// System.out.print(this.aString);
		return resultSet;
	}

	@Override
	public void enterQuery(@NotNull SparqlParser.QueryContext ctx) {

		// 创建读取本体的实例

	}

	@Override
	public void exitQuery(@NotNull SparqlParser.QueryContext ctx) {

		// this.aString = "0";
		// name();
		// System.out.print("haha");
		// Map<String, Set<String>> ResulteMap = spatialSelect.SelectResult();
		resultSet = spatialSelect.SelectResult();
		// try {
		//
		// Set<String> keySet = ResulteMap.keySet();
		// Iterator iterator = keySet.iterator();
		// while (iterator.hasNext()) {
		// String keyString = (String) iterator.next();
		// System.out.print(keyString+" : "+String.valueOf(ResulteMap.get(keyString))+"\n");
		//
		// }
		// } catch (NullPointerException e) {
		// // TODO: handle exception
		// System.err.print("被查询的变量没有定义！\n");
		// }

	}

	@Override
	public void enterPrefixDecl(@NotNull SparqlParser.PrefixDeclContext ctx) {

		Set<String> set = new HashSet<String>();
		set.add(ctx.IRIREF().getText());
		Map<String, Set<String>> varmap = new HashMap<String, Set<String>>();
		varmap.put(ctx.PNAME_NS().getText().split(":")[0], set);
		Variable variable = new Variable(
				ctx.PNAME_NS().getText().split(":")[0], varmap);
		spatialSelect.excuteVar.AddVars(ctx.PNAME_NS().getText().split(":")[0],
				variable);

	}

	@Override
	public void exitPrefixDecl(@NotNull SparqlParser.PrefixDeclContext ctx) {

	}

	@Override
	public void enterSelectClause(@NotNull SparqlParser.SelectClauseContext ctx) {

		int sizeOfselectvariable = 0;// 得到查询变量的个数
		sizeOfselectvariable = ctx.selectVariables().size();
		for (int i = 0; i < sizeOfselectvariable; i++) {
			// Set<String> set = new HashSet<String>();
			Map<String, Set<String>> varmap = new HashMap<String, Set<String>>();
			varmap.put(ctx.selectVariables(i).getText(), null);
			Variable variable = new Variable(ctx.selectVariables(i).getText(),
					varmap);
			spatialSelect.excuteVar.AddVars(ctx.selectVariables(i).getText(),
					variable);
			spatialSelect.excuteVar.SetSelect(ctx.selectVariables(i).getText());

			// 将变量存储到Vars数组
		}

	}

	@Override
	public void exitSelectClause(@NotNull SparqlParser.SelectClauseContext ctx) {
		// System.out.println("coming out from SelectClause()");
	}

	@Override
	public void enterWhereClause(@NotNull SparqlParser.WhereClauseContext ctx) {
		// System.out.println("coming into WhereClause()");

	}

	@Override
	public void exitWhereClause(@NotNull SparqlParser.WhereClauseContext ctx) {
		// System.out.println("coming out from WhereClause()");
	}

	@Override
	public void enterGroupGraphPattern(
			@NotNull SparqlParser.GroupGraphPatternContext ctx) {
		// System.out.println("coming into GroupGraphPattern()");
	}

	@Override
	public void exitGroupGraphPattern(
			@NotNull SparqlParser.GroupGraphPatternContext ctx) {
		// System.out.println("coming out from GroupGraphPattern()");
	}

	@Override
	public void enterGroupGraphPatternSub(
			@NotNull SparqlParser.GroupGraphPatternSubContext ctx) {
		// System.out.println("coming into GroupGraphPatternSub()");
	}

	@Override
	public void exitGroupGraphPatternSub(
			@NotNull SparqlParser.GroupGraphPatternSubContext ctx) {
		// System.out.println("coming out from GroupGraphPatternSub()");
	}

	@Override
	public void enterTriplesBlock(@NotNull SparqlParser.TriplesBlockContext ctx) {
		// System.out.println("coming into TriplesBlock()");
	}

	@Override
	public void exitTriplesBlock(@NotNull SparqlParser.TriplesBlockContext ctx) {
		// System.out.println("coming out from TriplesBlock()");
	}

	@Override
	public void enterTriplesSameSubjectPath(
			@NotNull SparqlParser.TriplesSameSubjectPathContext ctx) {
		// 得到第一个参数的名字
		String subjectString = ctx.varOrTerm().getText();
		// 得到本体的宏定义名称
		String temp = ctx.propertyListPathNotEmpty().verbPath().getText();

		String prefixString = temp.split(":")[0];
		// 得到属性的名称
		String propertyString = temp.split(":")[1];
		// 得到第二个参数的名字
		String objectString = ctx.propertyListPathNotEmpty().objectListPath()
				.objectPath().get(0).graphNodePath().varOrTerm().getText();
		// 创建参数
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("Subject", subjectString);
		paramMap.put("Prefix", prefixString);
		paramMap.put("Property", propertyString);
		paramMap.put("Object", objectString);

		// 调用总的三元组执行函数
		try {
			spatialSelect.triple_excute(paramMap); // 应当在这里捕捉异常
		} catch (UnkownTripleTypeException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.print(e.getClass().getName() + ":" + "[" + ctx.getText()
					+ "]" + " : " + e.getMessage() + "\n");
		} catch (OntoNotDefineExcetion e) {
			e.printStackTrace();
			System.err.print(e.getClass().getName() + ":" + "[" + ctx.getText()
					+ "]" + " : " + e.getMessage() + "\n");
			// TODO: handle exception
		} catch (NoPropertyException e) {
			e.printStackTrace();
			System.err.print(e.getClass().getName() + ":" + "[" + ctx.getText()
					+ "]" + " : " + e.getMessage() + "\n");
			// TODO: handle exception
		}

	}

	@Override
	public void enterFilter(@NotNull SparqlParser.FilterContext ctx) {

		
		grammerString = "Filter";// 进入到filter的语法
		spatialSelect.excuteVar.FilterVars.clear();// 进入新的filter 要清空此变量
	}

	@Override
	public void exitFilter(@NotNull SparqlParser.FilterContext ctx) {
		grammerString = "NoFilter";// 从filter的语法出去
		try {

			spatialSelect.filter_excute(ctx);// 这里也要捕捉异常
			spatialSelect.tirple_excute_racall();

		} catch (VarNotDefineException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.print(e.getClass().getName() + ":" + "[" + ctx.getText()
					+ "]" + " : " + e.getMessage());
		} catch (NoSelectVarException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.print(e.getClass().getName() + ":" + e.getMessage());
		} catch (UnkownTripleTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.print(e.getClass().getName() + ":" + "[" + ctx.getText()
					+ "]" + " : " + e.getMessage());
		}
	}

	@Override
	public void enterVar(@NotNull SparqlParser.VarContext ctx) {

		if (grammerString == "Filter") {
			// 存储到变量FilterVars中
			String nameString = ctx.getText();
			Variable variable = spatialSelect.excuteVar.GetVarsVar(nameString);
			try {
				spatialSelect.excuteVar.AddFikterVars(nameString, variable);
			} catch (VarNotDefineException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.err.print(e.getClass().getName() + ":" + e.getMessage()
						+ "\n");
				e.printStackTrace();
			}

		}
	}

	@Override
	public void exitVar(@NotNull SparqlParser.VarContext ctx) {
	}

}