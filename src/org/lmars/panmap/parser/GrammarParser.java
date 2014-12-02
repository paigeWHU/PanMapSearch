package org.lmars.panmap.parser;
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

public class GrammarParser extends SparqlBaseListener{
	
 
	private SpatialSelect spatialSelect;
	private String grammerString = "NoFilter";//��ʶ�Ƿ���뵽filter�﷨
	public  void run(String expr) throws Exception {
		
		ANTLRInputStream in = new ANTLRInputStream(expr);
        //�ʷ�������
		SparqlLexer lexer = new SparqlLexer(in);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
        //�﷨������ 
		SparqlParser parser = new SparqlParser(tokens);	
		ParseTreeWalker walker = new ParseTreeWalker();			
		ParseTree treePackage = parser.query();
		GrammarParser mygrammar = new GrammarParser();
		walker.walk(mygrammar, treePackage);
		 
	}

	
	@Override public void enterQuery(@NotNull SparqlParser.QueryContext ctx) 
	{

		this.spatialSelect = new SpatialSelect();//����һ���ռ��ѯ�Ķ���
		//������ȡ�����ʵ��
		
	}
	
	@Override public void exitQuery(@NotNull SparqlParser.QueryContext ctx) 
	{

	


		Map<String, Set<String>> ResulteMap =  spatialSelect.SelectResult();
		try {
//			Iterator iterator = ((Set<String>) ResulteMap).iterator();
//			while (iterator.hasNext()) {
//				
//				System.out.println(iterator.next());
//			}
			Set<String> keySet = ResulteMap.keySet();
			Iterator iterator = keySet.iterator();
			while (iterator.hasNext()) {
				String keyString = (String) iterator.next();
				System.out.print(keyString+" : "+String.valueOf(ResulteMap.get(keyString))+"\n");
				
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.err.print("����ѯ�ı���û�ж��壡\n");
		}
		

	}
	
	
	
	@Override public void enterPrefixDecl(@NotNull SparqlParser.PrefixDeclContext ctx) 
	{

		Set<String> set = new HashSet<String>();
		set.add(ctx.IRIREF().getText());
		Map<String,Set<String>> varmap = new HashMap<String,Set<String>>();
		varmap.put(ctx.PNAME_NS().getText().split(":")[0], set);
		Variable variable = new Variable(ctx.PNAME_NS().getText().split(":")[0],varmap);
		spatialSelect.AddVars(ctx.PNAME_NS().getText().split(":")[0], variable);
		
		
	}
	
	@Override public void exitPrefixDecl(@NotNull SparqlParser.PrefixDeclContext ctx)
	{
		
	}
	
	
	@Override public void enterSelectClause(@NotNull SparqlParser.SelectClauseContext ctx) 
	{

		int sizeOfselectvariable = 0;//�õ���ѯ�����ĸ���
		sizeOfselectvariable = ctx.selectVariables().size();
		for(int i = 0;i<sizeOfselectvariable;i++)
		{
//			Set<String> set = new HashSet<String>();		
			Map<String,Set<String>> varmap = new HashMap<String,Set<String>>();
			varmap.put(ctx.selectVariables(i).getText(), null);
			Variable variable = new Variable(ctx.selectVariables(i).getText(),varmap);
			spatialSelect.AddVars(ctx.selectVariables(i).getText(), variable);
			spatialSelect.SetSelect(ctx.selectVariables(i).getText());

			//�������洢��Vars����
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
		//�õ���һ������������
		String subjectString = ctx.varOrTerm().getText();
		//�õ�����ĺ궨������
		String temp =  ctx.propertyListPathNotEmpty().verbPath().getText();
		
		String prefixString =  temp.split(":")[0];
		//�õ����Ե�����
		String propertyString = temp.split(":")[1];
		//�õ��ڶ�������������
		String objectString = ctx.propertyListPathNotEmpty().objectListPath().objectPath().get(0).graphNodePath().varOrTerm().getText();
		//��������
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("Subject",subjectString);
		paramMap.put("Prefix",prefixString);
		paramMap.put("Property", propertyString);
		paramMap.put("Object", objectString);
		
		//��ӽ���Ԫ������
		Triple triple = new Triple(paramMap);
		spatialSelect.Triples.add(triple);
		//�����ܵ���Ԫ��ִ�к���
		try {
			spatialSelect.triple_excute(paramMap);	//Ӧ�������ﲶ׽�쳣
		} catch (UnkownTripleTypeException e) {
			// TODO: handle exception
			System.err.print(e.getClass().getName()+":"+"["+ctx.getText()+"]"+" : "+e.getMessage()+"\n");
		} catch (OntoNotDefineExcetion e) {
			System.err.print(e.getClass().getName()+":"+"["+ctx.getText()+"]"+" : "+e.getMessage()+"\n");
			// TODO: handle exception
		} catch (NoPropertyException e) {
			System.err.print(e.getClass().getName()+":"+"["+ctx.getText()+"]"+" : "+e.getMessage()+"\n");
			// TODO: handle exception
		}
		
		
	
	}
	
	@Override public void enterFilter(@NotNull SparqlParser.FilterContext ctx) 
	{

		grammerString = "Filter";//���뵽filter���﷨
		spatialSelect.FilterVars.clear();//�����µ�filter  Ҫ��մ˱��� 
	}
	
	@Override public void exitFilter(@NotNull SparqlParser.FilterContext ctx) 
	{
		grammerString = "NoFilter";//��filter���﷨��ȥ		
		try {
			
			spatialSelect.filter_excute(ctx);//����ҲҪ��׽�쳣
			
			spatialSelect.tirple_excute_racall();
		
		} catch (VarNotDefineException e) {
			// TODO: handle exception
			System.err.print(e.getClass().getName()+":"+"["+ctx.getText()+"]"+" : "+e.getMessage());
		} catch (NoSelectVarException e) {
			// TODO: handle exception
			System.err.print(e.getClass().getName()+":"+e.getMessage());
		}				
	}
	
	
	@Override public void enterVar(@NotNull SparqlParser.VarContext ctx)  
	{

		
		if(grammerString=="Filter"){
			//�洢������FilterVars��
			String nameString = ctx.getText();
			Variable variable = spatialSelect.GetVarsVar(nameString);
			try {
				spatialSelect.AddFikterVars(nameString, variable);
			} catch (VarNotDefineException e) {
				// TODO: handle exception
				System.err.print(e.getClass().getName()+":"+e.getMessage()+"\n");
			}
			
		}
	}

	@Override public void exitVar(@NotNull SparqlParser.VarContext ctx) { }
	
	
	

	
	
}