package org.lmars.panmap.parser;
import org.antlr.v4.parse.ANTLRParser.prequelConstruct_return;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.*;
import org.antlr.runtime.tree.BaseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.tool.Rule;
import org.antlr.v4.runtime.CommonTokenStream;
import org.lmars.sparql.parser.SparqlParser.QueryContext;
import org.owlapi.OWL;
import java.util.*;
import org.lmars.sparql.parser.*;

public class GrammarParser extends SparqlBaseListener{
	
 
	private SpatialSelect spatialSelect;
	private String grammerString = "NoFilter";//标识是否进入到filter语法
	public  void run(String expr) throws Exception {
		
		ANTLRInputStream in = new ANTLRInputStream(expr);
        //词法分析器
		SparqlLexer lexer = new SparqlLexer(in);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
        //语法分析器 
		SparqlParser parser = new SparqlParser(tokens);	
		ParseTreeWalker walker = new ParseTreeWalker();			
		ParseTree treePackage = parser.query();
		GrammarParser mygrammar = new GrammarParser();
		walker.walk(mygrammar, treePackage);
		 
	}

	
	@Override public void enterQuery(@NotNull SparqlParser.QueryContext ctx) 
	{

		this.spatialSelect = new SpatialSelect();//创建一个空间查询的对象
		//创建读取本体的实例
		
	}
	
	@Override public void exitQuery(@NotNull SparqlParser.QueryContext ctx) 
	{
//		System.out.println("coming out of Query()");
		//输出空间查询对象所存储的全部内容
		Iterator<Variable> iterator = this.spatialSelect.Vars.iterator();
		while (iterator.hasNext()) {
			Variable variable = iterator.next();
			String nameString =  variable.VarName();
			Set<String> set = spatialSelect.GetValue(nameString);
			System.out.println(nameString+":"+String.valueOf(set));
		}

	}
	
	
	
	@Override public void enterPrefixDecl(@NotNull SparqlParser.PrefixDeclContext ctx) 
	{

		Set<String> set = new HashSet<String>();
		set.add(ctx.IRIREF().getText());
		Map<String,Set<String>> varmap = new HashMap<String,Set<String>>();
		varmap.put(ctx.PNAME_NS().getText().split(":")[0], set);
		Variable variable = new Variable(varmap);
		spatialSelect.AddVars(ctx.PNAME_NS().getText().split(":")[0], variable);
		
		
	}
	
	@Override public void exitPrefixDecl(@NotNull SparqlParser.PrefixDeclContext ctx)
	{
		
	}
	
	
	@Override public void enterSelectClause(@NotNull SparqlParser.SelectClauseContext ctx) 
	{

		int sizeOfselectvariable = 0;//得到查询变量的个数
		sizeOfselectvariable = ctx.selectVariables().size();
		for(int i = 0;i<sizeOfselectvariable;i++)
		{
			Set<String> set = new HashSet<String>();		
			Map<String,Set<String>> varmap = new HashMap<String,Set<String>>();
			varmap.put(ctx.selectVariables(i).getText(), set);
			Variable variable = new Variable(varmap);
			spatialSelect.AddVars(ctx.selectVariables(i).getText(), variable);
			spatialSelect.SetSelect(ctx.selectVariables(i).getText());
//			System.out.println("@#@#@#"+ctx.selectVariables(i).getText());//宏定义的值
			//将变量存储到Vars数组
		}
		
	}
	
	@Override public void exitSelectClause(@NotNull SparqlParser.SelectClauseContext ctx) 
	{
//		System.out.println("coming out from SelectClause()");
	}
	
	
	@Override public void enterWhereClause(@NotNull SparqlParser.WhereClauseContext ctx)
	{
//		System.out.println("coming into WhereClause()");
		
	}
	
	@Override public void exitWhereClause(@NotNull SparqlParser.WhereClauseContext ctx)
	{
//		System.out.println("coming out from WhereClause()");
	}
	
	
	@Override public void enterGroupGraphPattern(@NotNull SparqlParser.GroupGraphPatternContext ctx) 
	{
//		System.out.println("coming into GroupGraphPattern()");
	}
	
	@Override public void exitGroupGraphPattern(@NotNull SparqlParser.GroupGraphPatternContext ctx)
	{
//		System.out.println("coming out from GroupGraphPattern()");
	}
	
	
	@Override public void enterGroupGraphPatternSub(@NotNull SparqlParser.GroupGraphPatternSubContext ctx) 
	{
//		System.out.println("coming into GroupGraphPatternSub()");
	}
		
	@Override public void exitGroupGraphPatternSub(@NotNull SparqlParser.GroupGraphPatternSubContext ctx) 
	{
//		System.out.println("coming out from GroupGraphPatternSub()");
	}
	
	
	@Override public void enterTriplesBlock(@NotNull SparqlParser.TriplesBlockContext ctx) 
	{
//		System.out.println("coming into TriplesBlock()");
	}
	
	@Override public void exitTriplesBlock(@NotNull SparqlParser.TriplesBlockContext ctx) 
	{
//		System.out.println("coming out from TriplesBlock()");
	}
	
	
	@Override public void enterTriplesSameSubjectPath(@NotNull SparqlParser.TriplesSameSubjectPathContext ctx) 
	{
//		System.out.println("coming into TriplesSameSubjectPath()");

		//得到第一个参数的名字
		String subjectString = ctx.varOrTerm().getText();
		//得到本体的宏定义名称
		String temp =  ctx.propertyListPathNotEmpty().verbPath().getText();
		
		String prefixString =  temp.split(":")[0];
		//得到属性的名称
		String propertyString = temp.split(":")[1];
		//得到第二个参数的名字  ！！！！！！！！！！！！！！！再看一下这里的语法规则
		String objectString = ctx.propertyListPathNotEmpty().objectListPath().objectPath().get(0).graphNodePath().varOrTerm().getText();
		//创建参数
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("Subject",subjectString);
		paramMap.put("Prefix",prefixString);
		paramMap.put("Property", propertyString);
		paramMap.put("Object", objectString);
		//调用函数判断三元组语法的规则
		
		//根据不同的语法规则
		int type = spatialSelect.juge_triple_condition(paramMap);
		
		switch (type) {
		case 1:
			spatialSelect.triple_execute_rule1(paramMap);
			break;
		case 2:
			spatialSelect.triple_execute_rule2(paramMap);
			break;
		case 3:
			spatialSelect.triple_execute_rule3(paramMap);
			break;
		default:
			break;
		}
//		System.out.println(ctx.varOrTerm().getText());
		
	}
	
	@Override public void exitTriplesSameSubjectPath(@NotNull SparqlParser.TriplesSameSubjectPathContext ctx) 
	{
//		System.out.println("coming out from TriplesSameSubjectPath()");
	}
	
	
	@Override public void enterPathPrimary(@NotNull SparqlParser.PathPrimaryContext ctx) 
	{
//		System.out.println("coming into PathPrimary()");
		if(ctx.iri() != null)
		{
			String string = ctx.iri().prefixedName().PNAME_LN().getText();
			int i = string.indexOf(":");
			
//			System.out.print(string.substring(0, i-1)+","+string.substring(i+1));
		}
	}
	
	 
	@Override public void exitPathPrimary(@NotNull SparqlParser.PathPrimaryContext ctx) 
	{
//		System.out.println("coming out from PathPrimary()");
	}
	
	
	
	@Override public void enterGroupGraphPatternSubList(@NotNull SparqlParser.GroupGraphPatternSubListContext ctx) 
	{
//		System.out.println("coming into GroupGraphPatternSubList()");
	}
	
	@Override public void exitGroupGraphPatternSubList(@NotNull SparqlParser.GroupGraphPatternSubListContext ctx) 
	{
//		System.out.println("coming out from GroupGraphPatternSubList()");
	}
	
	
	@Override public void enterFilter(@NotNull SparqlParser.FilterContext ctx) 
	{

		grammerString = "Filter";//进入到filter的语法
		spatialSelect.FilterVars.clear();//进入新的filter  要清空此变量 
	}
	
	@Override public void exitFilter(@NotNull SparqlParser.FilterContext ctx) 
	{
		grammerString = "NoFilter";//从filter的语法出去
		spatialSelect.filter_excute(ctx);
	}
	
	
	@Override public void enterVar(@NotNull SparqlParser.VarContext ctx) 
	{

		if(grammerString=="Filter"){
			//存储到变量FilterVars中
			String nameString = ctx.getText();
			Iterator<Variable> iterator = spatialSelect.Vars.iterator();
			while(iterator.hasNext()){
				Variable variable = iterator.next();
				if(variable.varMap.get(nameString)!=null){
					spatialSelect.AddFikterVars(nameString, variable);
				}
			}
		}
	}

	@Override public void exitVar(@NotNull SparqlParser.VarContext ctx) { }
	
	
	@Override public void enterFunction(@NotNull SparqlParser.FunctionContext ctx)
	{

		int sizeOfparam = ctx.paramDeclList().expression().size();

		for(int i = 0;i<sizeOfparam;i++){
//			System.out.println(ctx.paramDeclList().expression(i).getText());
		}
	}
	
	@Override public void exitFunction(@NotNull SparqlParser.FunctionContext ctx) 
	{
		
	}
	
	

	
	
}