// Generated from F:\05Postgraduate\antlr\pro\PanMapSearch\src\org\lmars\sparql\parser/Sparql.g4 by ANTLR 4.4
package org.lmars.sparql.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SparqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, BASE=2, PREFIX=3, SELECT=4, DISTINCT=5, REDUCED=6, CONSTRUCT=7, 
		DESCRIBE=8, ASK=9, FROM=10, NAMED=11, WHERE=12, ORDER=13, BY=14, ASC=15, 
		DESC=16, LIMIT=17, OFFSET=18, VALUES=19, OPTIONAL=20, GRAPH=21, UNION=22, 
		FILTER=23, A=24, STR=25, LANG=26, LANGMATCHES=27, DATATYPE=28, BOUND=29, 
		SAMETERM=30, ISIRI=31, ISURI=32, ISBLANK=33, ISLITERAL=34, REGEX=35, SUBSTR=36, 
		TRUE=37, FALSE=38, LOAD=39, CLEAR=40, DROP=41, ADD=42, MOVE=43, COPY=44, 
		CREATE=45, DELETE=46, INSERT=47, USING=48, SILENT=49, DEFAULT=50, ALL=51, 
		DATA=52, WITH=53, INTO=54, TO=55, AS=56, GROUP=57, HAVING=58, UNDEF=59, 
		BINDINGS=60, SERVICE=61, BIND=62, MINUS=63, IRI=64, URI=65, BNODE=66, 
		RAND=67, ABS=68, CEIL=69, FLOOR=70, ROUND=71, CONCAT=72, STRLEN=73, UCASE=74, 
		LCASE=75, ENCODE_FOR_URI=76, CONTAINS=77, STRSTARTS=78, STRENDS=79, STRBEFORE=80, 
		STRAFTER=81, REPLACE=82, YEAR=83, MONTH=84, DAY=85, HOURS=86, MINUTES=87, 
		SECONDS=88, TIMEZONE=89, TZ=90, NOW=91, UUID=92, STRUUID=93, MD5=94, SHA1=95, 
		SHA256=96, SHA384=97, SHA512=98, COALESCE=99, IF=100, STRLANG=101, STRDT=102, 
		ISNUMERIC=103, COUNT=104, SUM=105, MIN=106, MAX=107, AVG=108, SAMPLE=109, 
		GROUP_CONCAT=110, NOT=111, IN=112, EXISTS=113, SEPARATOR=114, IRIREF=115, 
		PNAME_NS=116, PNAME_LN=117, BLANK_NODE_LABEL=118, VAR1=119, VAR2=120, 
		LANGTAG=121, INTEGER=122, DECIMAL=123, DOUBLE=124, INTEGER_POSITIVE=125, 
		DECIMAL_POSITIVE=126, DOUBLE_POSITIVE=127, INTEGER_NEGATIVE=128, DECIMAL_NEGATIVE=129, 
		DOUBLE_NEGATIVE=130, STRING_LITERAL1=131, STRING_LITERAL2=132, STRING_LITERAL_LONG1=133, 
		STRING_LITERAL_LONG2=134, COMMENT=135, REFERENCE=136, LESS_EQUAL=137, 
		GREATER_EQUAL=138, NOT_EQUAL=139, AND=140, OR=141, INVERSE=142, OPEN_BRACE=143, 
		CLOSE_BRACE=144, OPEN_CURLY_BRACE=145, CLOSE_CURLY_BRACE=146, OPEN_SQUARE_BRACKET=147, 
		CLOSE_SQUARE_BRACKET=148, SEMICOLON=149, DOT=150, PLUS_SIGN=151, MINUS_SIGN=152, 
		ASTERISK=153, QUESTION_MARK=154, COMMA=155, NEGATION=156, DIVIDE=157, 
		EQUAL=158, LESS=159, GREATER=160, PIPE=161, ANY=162, ID=163, OPPOSITE=164, 
		ADJACENT=165, VERTICAL=166, CONTAINED=167, CONTAIN=168, DISTANCE=169, 
		DIRECTION=170;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "BASE", "PREFIX", "SELECT", "DISTINCT", "REDUCED", 
		"CONSTRUCT", "DESCRIBE", "ASK", "FROM", "NAMED", "WHERE", "ORDER", "BY", 
		"ASC", "DESC", "LIMIT", "OFFSET", "VALUES", "OPTIONAL", "GRAPH", "UNION", 
		"FILTER", "'a'", "STR", "LANG", "LANGMATCHES", "DATATYPE", "BOUND", "SAMETERM", 
		"ISIRI", "ISURI", "ISBLANK", "ISLITERAL", "REGEX", "SUBSTR", "TRUE", "FALSE", 
		"LOAD", "CLEAR", "DROP", "ADD", "MOVE", "COPY", "CREATE", "DELETE", "INSERT", 
		"USING", "SILENT", "DEFAULT", "ALL", "DATA", "WITH", "INTO", "TO", "AS", 
		"GROUP", "HAVING", "UNDEF", "BINDINGS", "SERVICE", "BIND", "MINUS", "IRI", 
		"URI", "BNODE", "RAND", "ABS", "CEIL", "FLOOR", "ROUND", "CONCAT", "STRLEN", 
		"UCASE", "LCASE", "ENCODE_FOR_URI", "CONTAINS", "STRSTARTS", "STRENDS", 
		"STRBEFORE", "STRAFTER", "REPLACE", "YEAR", "MONTH", "DAY", "HOURS", "MINUTES", 
		"SECONDS", "TIMEZONE", "TZ", "NOW", "UUID", "STRUUID", "MD5", "SHA1", 
		"SHA256", "SHA384", "SHA512", "COALESCE", "IF", "STRLANG", "STRDT", "ISNUMERIC", 
		"COUNT", "SUM", "MIN", "MAX", "AVG", "SAMPLE", "GROUP_CONCAT", "NOT", 
		"IN", "EXISTS", "SEPARATOR", "IRIREF", "PNAME_NS", "PNAME_LN", "BLANK_NODE_LABEL", 
		"VAR1", "VAR2", "LANGTAG", "INTEGER", "DECIMAL", "DOUBLE", "INTEGER_POSITIVE", 
		"DECIMAL_POSITIVE", "DOUBLE_POSITIVE", "INTEGER_NEGATIVE", "DECIMAL_NEGATIVE", 
		"DOUBLE_NEGATIVE", "STRING_LITERAL1", "STRING_LITERAL2", "STRING_LITERAL_LONG1", 
		"STRING_LITERAL_LONG2", "COMMENT", "'^^'", "'<='", "'>='", "'!='", "'&&'", 
		"'||'", "'^'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "'.'", 
		"'+'", "'-'", "'*'", "'?'", "','", "'!'", "'/'", "'='", "'<'", "'>'", 
		"'|'", "ANY", "ID", "OPPOSITE", "ADJACENT", "VERTICAL", "CONTAINED", "CONTAIN", 
		"DISTANCE", "DIRECTION"
	};
	public static final int
		RULE_query = 0, RULE_prologue = 1, RULE_baseDecl = 2, RULE_prefixDecl = 3, 
		RULE_selectQuery = 4, RULE_subSelect = 5, RULE_selectClause = 6, RULE_selectVariables = 7, 
		RULE_constructQuery = 8, RULE_describeQuery = 9, RULE_askQuery = 10, RULE_datasetClause = 11, 
		RULE_whereClause = 12, RULE_solutionModifier = 13, RULE_groupClause = 14, 
		RULE_groupCondition = 15, RULE_havingClause = 16, RULE_havingCondition = 17, 
		RULE_orderClause = 18, RULE_orderCondition = 19, RULE_limitOffsetClauses = 20, 
		RULE_limitClause = 21, RULE_offsetClause = 22, RULE_valuesClause = 23, 
		RULE_updateCommand = 24, RULE_update = 25, RULE_load = 26, RULE_clear = 27, 
		RULE_drop = 28, RULE_create = 29, RULE_add = 30, RULE_move = 31, RULE_copy = 32, 
		RULE_insertData = 33, RULE_deleteData = 34, RULE_deleteWhere = 35, RULE_modify = 36, 
		RULE_deleteClause = 37, RULE_insertClause = 38, RULE_usingClause = 39, 
		RULE_graphOrDefault = 40, RULE_graphRef = 41, RULE_graphRefAll = 42, RULE_quadPattern = 43, 
		RULE_quadData = 44, RULE_quads = 45, RULE_quadsDetails = 46, RULE_quadsNotTriples = 47, 
		RULE_triplesTemplate = 48, RULE_groupGraphPattern = 49, RULE_groupGraphPatternSub = 50, 
		RULE_groupGraphPatternSubList = 51, RULE_triplesBlock = 52, RULE_graphPatternNotTriples = 53, 
		RULE_optionalGraphPattern = 54, RULE_graphGraphPattern = 55, RULE_serviceGraphPattern = 56, 
		RULE_bind = 57, RULE_inlineData = 58, RULE_dataBlock = 59, RULE_inlineDataOneVar = 60, 
		RULE_inlineDataFull = 61, RULE_dataBlockValues = 62, RULE_dataBlockValue = 63, 
		RULE_minusGraphPattern = 64, RULE_groupOrUnionGraphPattern = 65, RULE_filter = 66, 
		RULE_constraint = 67, RULE_functionList = 68, RULE_function = 69, RULE_paramDeclList = 70, 
		RULE_functionCall = 71, RULE_argList = 72, RULE_expressionList = 73, RULE_constructTemplate = 74, 
		RULE_constructTriples = 75, RULE_triplesSameSubject = 76, RULE_propertyList = 77, 
		RULE_propertyListNotEmpty = 78, RULE_verb = 79, RULE_objectList = 80, 
		RULE_object = 81, RULE_triplesSameSubjectPath = 82, RULE_propertyListPath = 83, 
		RULE_propertyListPathNotEmpty = 84, RULE_propertyListPathNotEmptyList = 85, 
		RULE_verbPath = 86, RULE_verbSimple = 87, RULE_objectListPath = 88, RULE_objectPath = 89, 
		RULE_path = 90, RULE_pathAlternative = 91, RULE_pathSequence = 92, RULE_pathElt = 93, 
		RULE_pathEltOrInverse = 94, RULE_pathMod = 95, RULE_pathPrimary = 96, 
		RULE_pathNegatedPropertySet = 97, RULE_pathOneInPropertySet = 98, RULE_integer = 99, 
		RULE_triplesNode = 100, RULE_blankNodePropertyList = 101, RULE_triplesNodePath = 102, 
		RULE_blankNodePropertyListPath = 103, RULE_collection = 104, RULE_collectionPath = 105, 
		RULE_graphNode = 106, RULE_graphNodePath = 107, RULE_varOrTerm = 108, 
		RULE_varOrIRI = 109, RULE_var = 110, RULE_graphTerm = 111, RULE_nil = 112, 
		RULE_expression = 113, RULE_unaryLiteralExpression = 114, RULE_unaryExpression = 115, 
		RULE_primaryExpression = 116, RULE_builtInCall = 117, RULE_regexExpression = 118, 
		RULE_subStringExpression = 119, RULE_strReplaceExpression = 120, RULE_existsFunction = 121, 
		RULE_notExistsFunction = 122, RULE_aggregate = 123, RULE_iriRefOrFunction = 124, 
		RULE_rdfLiteral = 125, RULE_numericLiteral = 126, RULE_numericLiteralUnsigned = 127, 
		RULE_numericLiteralPositive = 128, RULE_numericLiteralNegative = 129, 
		RULE_booleanLiteral = 130, RULE_string = 131, RULE_iri = 132, RULE_prefixedName = 133, 
		RULE_blankNode = 134, RULE_anon = 135;
	public static final String[] ruleNames = {
		"query", "prologue", "baseDecl", "prefixDecl", "selectQuery", "subSelect", 
		"selectClause", "selectVariables", "constructQuery", "describeQuery", 
		"askQuery", "datasetClause", "whereClause", "solutionModifier", "groupClause", 
		"groupCondition", "havingClause", "havingCondition", "orderClause", "orderCondition", 
		"limitOffsetClauses", "limitClause", "offsetClause", "valuesClause", "updateCommand", 
		"update", "load", "clear", "drop", "create", "add", "move", "copy", "insertData", 
		"deleteData", "deleteWhere", "modify", "deleteClause", "insertClause", 
		"usingClause", "graphOrDefault", "graphRef", "graphRefAll", "quadPattern", 
		"quadData", "quads", "quadsDetails", "quadsNotTriples", "triplesTemplate", 
		"groupGraphPattern", "groupGraphPatternSub", "groupGraphPatternSubList", 
		"triplesBlock", "graphPatternNotTriples", "optionalGraphPattern", "graphGraphPattern", 
		"serviceGraphPattern", "bind", "inlineData", "dataBlock", "inlineDataOneVar", 
		"inlineDataFull", "dataBlockValues", "dataBlockValue", "minusGraphPattern", 
		"groupOrUnionGraphPattern", "filter", "constraint", "functionList", "function", 
		"paramDeclList", "functionCall", "argList", "expressionList", "constructTemplate", 
		"constructTriples", "triplesSameSubject", "propertyList", "propertyListNotEmpty", 
		"verb", "objectList", "object", "triplesSameSubjectPath", "propertyListPath", 
		"propertyListPathNotEmpty", "propertyListPathNotEmptyList", "verbPath", 
		"verbSimple", "objectListPath", "objectPath", "path", "pathAlternative", 
		"pathSequence", "pathElt", "pathEltOrInverse", "pathMod", "pathPrimary", 
		"pathNegatedPropertySet", "pathOneInPropertySet", "integer", "triplesNode", 
		"blankNodePropertyList", "triplesNodePath", "blankNodePropertyListPath", 
		"collection", "collectionPath", "graphNode", "graphNodePath", "varOrTerm", 
		"varOrIRI", "var", "graphTerm", "nil", "expression", "unaryLiteralExpression", 
		"unaryExpression", "primaryExpression", "builtInCall", "regexExpression", 
		"subStringExpression", "strReplaceExpression", "existsFunction", "notExistsFunction", 
		"aggregate", "iriRefOrFunction", "rdfLiteral", "numericLiteral", "numericLiteralUnsigned", 
		"numericLiteralPositive", "numericLiteralNegative", "booleanLiteral", 
		"string", "iri", "prefixedName", "blankNode", "anon"
	};

	@Override
	public String getGrammarFileName() { return "Sparql.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SparqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public AskQueryContext askQuery() {
			return getRuleContext(AskQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SparqlParser.EOF, 0); }
		public DescribeQueryContext describeQuery() {
			return getRuleContext(DescribeQueryContext.class,0);
		}
		public PrologueContext prologue() {
			return getRuleContext(PrologueContext.class,0);
		}
		public ValuesClauseContext valuesClause() {
			return getRuleContext(ValuesClauseContext.class,0);
		}
		public UpdateCommandContext updateCommand() {
			return getRuleContext(UpdateCommandContext.class,0);
		}
		public ConstructQueryContext constructQuery() {
			return getRuleContext(ConstructQueryContext.class,0);
		}
		public SelectQueryContext selectQuery() {
			return getRuleContext(SelectQueryContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		try {
			setState(286);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(272); prologue();
				setState(277);
				switch (_input.LA(1)) {
				case SELECT:
					{
					setState(273); selectQuery();
					}
					break;
				case CONSTRUCT:
					{
					setState(274); constructQuery();
					}
					break;
				case DESCRIBE:
					{
					setState(275); describeQuery();
					}
					break;
				case ASK:
					{
					setState(276); askQuery();
					}
					break;
				case EOF:
				case VALUES:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(279); valuesClause();
				setState(280); match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(282); updateCommand();
					}
					break;
				}
				setState(285); match(EOF);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrologueContext extends ParserRuleContext {
		public List<BaseDeclContext> baseDecl() {
			return getRuleContexts(BaseDeclContext.class);
		}
		public PrefixDeclContext prefixDecl(int i) {
			return getRuleContext(PrefixDeclContext.class,i);
		}
		public BaseDeclContext baseDecl(int i) {
			return getRuleContext(BaseDeclContext.class,i);
		}
		public List<PrefixDeclContext> prefixDecl() {
			return getRuleContexts(PrefixDeclContext.class);
		}
		public PrologueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prologue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPrologue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPrologue(this);
		}
	}

	public final PrologueContext prologue() throws RecognitionException {
		PrologueContext _localctx = new PrologueContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prologue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BASE || _la==PREFIX) {
				{
				setState(290);
				switch (_input.LA(1)) {
				case BASE:
					{
					setState(288); baseDecl();
					}
					break;
				case PREFIX:
					{
					setState(289); prefixDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseDeclContext extends ParserRuleContext {
		public TerminalNode BASE() { return getToken(SparqlParser.BASE, 0); }
		public TerminalNode IRIREF() { return getToken(SparqlParser.IRIREF, 0); }
		public BaseDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterBaseDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitBaseDecl(this);
		}
	}

	public final BaseDeclContext baseDecl() throws RecognitionException {
		BaseDeclContext _localctx = new BaseDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_baseDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295); match(BASE);
			setState(296); match(IRIREF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixDeclContext extends ParserRuleContext {
		public TerminalNode PREFIX() { return getToken(SparqlParser.PREFIX, 0); }
		public TerminalNode PNAME_NS() { return getToken(SparqlParser.PNAME_NS, 0); }
		public TerminalNode IRIREF() { return getToken(SparqlParser.IRIREF, 0); }
		public PrefixDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPrefixDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPrefixDecl(this);
		}
	}

	public final PrefixDeclContext prefixDecl() throws RecognitionException {
		PrefixDeclContext _localctx = new PrefixDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_prefixDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298); match(PREFIX);
			setState(299); match(PNAME_NS);
			setState(300); match(IRIREF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectQueryContext extends ParserRuleContext {
		public DatasetClauseContext datasetClause(int i) {
			return getRuleContext(DatasetClauseContext.class,i);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public SelectClauseContext selectClause() {
			return getRuleContext(SelectClauseContext.class,0);
		}
		public List<DatasetClauseContext> datasetClause() {
			return getRuleContexts(DatasetClauseContext.class);
		}
		public SolutionModifierContext solutionModifier() {
			return getRuleContext(SolutionModifierContext.class,0);
		}
		public SelectQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterSelectQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitSelectQuery(this);
		}
	}

	public final SelectQueryContext selectQuery() throws RecognitionException {
		SelectQueryContext _localctx = new SelectQueryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_selectQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302); selectClause();
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FROM) {
				{
				{
				setState(303); datasetClause();
				}
				}
				setState(308);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(309); whereClause();
			setState(310); solutionModifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubSelectContext extends ParserRuleContext {
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public SelectClauseContext selectClause() {
			return getRuleContext(SelectClauseContext.class,0);
		}
		public SolutionModifierContext solutionModifier() {
			return getRuleContext(SolutionModifierContext.class,0);
		}
		public ValuesClauseContext valuesClause() {
			return getRuleContext(ValuesClauseContext.class,0);
		}
		public SubSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subSelect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterSubSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitSubSelect(this);
		}
	}

	public final SubSelectContext subSelect() throws RecognitionException {
		SubSelectContext _localctx = new SubSelectContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_subSelect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312); selectClause();
			setState(313); whereClause();
			setState(314); solutionModifier();
			setState(315); valuesClause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectClauseContext extends ParserRuleContext {
		public List<SelectVariablesContext> selectVariables() {
			return getRuleContexts(SelectVariablesContext.class);
		}
		public TerminalNode DISTINCT() { return getToken(SparqlParser.DISTINCT, 0); }
		public TerminalNode REDUCED() { return getToken(SparqlParser.REDUCED, 0); }
		public TerminalNode SELECT() { return getToken(SparqlParser.SELECT, 0); }
		public SelectVariablesContext selectVariables(int i) {
			return getRuleContext(SelectVariablesContext.class,i);
		}
		public SelectClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterSelectClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitSelectClause(this);
		}
	}

	public final SelectClauseContext selectClause() throws RecognitionException {
		SelectClauseContext _localctx = new SelectClauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selectClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317); match(SELECT);
			setState(319);
			_la = _input.LA(1);
			if (_la==DISTINCT || _la==REDUCED) {
				{
				setState(318);
				_la = _input.LA(1);
				if ( !(_la==DISTINCT || _la==REDUCED) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(327);
			switch (_input.LA(1)) {
			case VAR1:
			case VAR2:
			case OPEN_BRACE:
				{
				setState(322); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(321); selectVariables();
					}
					}
					setState(324); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 119)) & ~0x3f) == 0 && ((1L << (_la - 119)) & ((1L << (VAR1 - 119)) | (1L << (VAR2 - 119)) | (1L << (OPEN_BRACE - 119)))) != 0) );
				}
				break;
			case ASTERISK:
				{
				setState(326); match(ASTERISK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectVariablesContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(SparqlParser.AS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public SelectVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectVariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterSelectVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitSelectVariables(this);
		}
	}

	public final SelectVariablesContext selectVariables() throws RecognitionException {
		SelectVariablesContext _localctx = new SelectVariablesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_selectVariables);
		try {
			setState(336);
			switch (_input.LA(1)) {
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 1);
				{
				setState(329); var();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(330); match(OPEN_BRACE);
				setState(331); expression(0);
				setState(332); match(AS);
				setState(333); var();
				setState(334); match(CLOSE_BRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructQueryContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SparqlParser.WHERE, 0); }
		public DatasetClauseContext datasetClause(int i) {
			return getRuleContext(DatasetClauseContext.class,i);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public List<DatasetClauseContext> datasetClause() {
			return getRuleContexts(DatasetClauseContext.class);
		}
		public ConstructTemplateContext constructTemplate() {
			return getRuleContext(ConstructTemplateContext.class,0);
		}
		public SolutionModifierContext solutionModifier() {
			return getRuleContext(SolutionModifierContext.class,0);
		}
		public TerminalNode CONSTRUCT() { return getToken(SparqlParser.CONSTRUCT, 0); }
		public TriplesTemplateContext triplesTemplate() {
			return getRuleContext(TriplesTemplateContext.class,0);
		}
		public ConstructQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterConstructQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitConstructQuery(this);
		}
	}

	public final ConstructQueryContext constructQuery() throws RecognitionException {
		ConstructQueryContext _localctx = new ConstructQueryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constructQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338); match(CONSTRUCT);
			setState(362);
			switch (_input.LA(1)) {
			case OPEN_CURLY_BRACE:
				{
				setState(339); constructTemplate();
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FROM) {
					{
					{
					setState(340); datasetClause();
					}
					}
					setState(345);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(346); whereClause();
				setState(347); solutionModifier();
				}
				break;
			case FROM:
			case WHERE:
				{
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FROM) {
					{
					{
					setState(349); datasetClause();
					}
					}
					setState(354);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(355); match(WHERE);
				setState(356); match(OPEN_CURLY_BRACE);
				setState(358);
				_la = _input.LA(1);
				if (_la==TRUE || _la==FALSE || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (BLANK_NODE_LABEL - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (OPEN_SQUARE_BRACKET - 115)))) != 0)) {
					{
					setState(357); triplesTemplate();
					}
				}

				setState(360); match(CLOSE_CURLY_BRACE);
				setState(361); solutionModifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescribeQueryContext extends ParserRuleContext {
		public DatasetClauseContext datasetClause(int i) {
			return getRuleContext(DatasetClauseContext.class,i);
		}
		public List<VarOrIRIContext> varOrIRI() {
			return getRuleContexts(VarOrIRIContext.class);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public VarOrIRIContext varOrIRI(int i) {
			return getRuleContext(VarOrIRIContext.class,i);
		}
		public List<DatasetClauseContext> datasetClause() {
			return getRuleContexts(DatasetClauseContext.class);
		}
		public SolutionModifierContext solutionModifier() {
			return getRuleContext(SolutionModifierContext.class,0);
		}
		public TerminalNode DESCRIBE() { return getToken(SparqlParser.DESCRIBE, 0); }
		public DescribeQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_describeQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterDescribeQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitDescribeQuery(this);
		}
	}

	public final DescribeQueryContext describeQuery() throws RecognitionException {
		DescribeQueryContext _localctx = new DescribeQueryContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_describeQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364); match(DESCRIBE);
			setState(371);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case VAR1:
			case VAR2:
				{
				setState(366); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(365); varOrIRI();
					}
					}
					setState(368); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)))) != 0) );
				}
				break;
			case ASTERISK:
				{
				setState(370); match(ASTERISK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FROM) {
				{
				{
				setState(373); datasetClause();
				}
				}
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(380);
			_la = _input.LA(1);
			if (_la==WHERE || _la==OPEN_CURLY_BRACE) {
				{
				setState(379); whereClause();
				}
			}

			setState(382); solutionModifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AskQueryContext extends ParserRuleContext {
		public DatasetClauseContext datasetClause(int i) {
			return getRuleContext(DatasetClauseContext.class,i);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public List<DatasetClauseContext> datasetClause() {
			return getRuleContexts(DatasetClauseContext.class);
		}
		public TerminalNode ASK() { return getToken(SparqlParser.ASK, 0); }
		public SolutionModifierContext solutionModifier() {
			return getRuleContext(SolutionModifierContext.class,0);
		}
		public AskQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_askQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterAskQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitAskQuery(this);
		}
	}

	public final AskQueryContext askQuery() throws RecognitionException {
		AskQueryContext _localctx = new AskQueryContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_askQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384); match(ASK);
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FROM) {
				{
				{
				setState(385); datasetClause();
				}
				}
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(391); whereClause();
			setState(392); solutionModifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatasetClauseContext extends ParserRuleContext {
		public TerminalNode NAMED() { return getToken(SparqlParser.NAMED, 0); }
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SparqlParser.FROM, 0); }
		public DatasetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datasetClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterDatasetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitDatasetClause(this);
		}
	}

	public final DatasetClauseContext datasetClause() throws RecognitionException {
		DatasetClauseContext _localctx = new DatasetClauseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_datasetClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394); match(FROM);
			setState(396);
			_la = _input.LA(1);
			if (_la==NAMED) {
				{
				setState(395); match(NAMED);
				}
			}

			setState(398); iri();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SparqlParser.WHERE, 0); }
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whereClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(400); match(WHERE);
				}
			}

			setState(403); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SolutionModifierContext extends ParserRuleContext {
		public LimitOffsetClausesContext limitOffsetClauses() {
			return getRuleContext(LimitOffsetClausesContext.class,0);
		}
		public OrderClauseContext orderClause() {
			return getRuleContext(OrderClauseContext.class,0);
		}
		public GroupClauseContext groupClause() {
			return getRuleContext(GroupClauseContext.class,0);
		}
		public HavingClauseContext havingClause() {
			return getRuleContext(HavingClauseContext.class,0);
		}
		public SolutionModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_solutionModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterSolutionModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitSolutionModifier(this);
		}
	}

	public final SolutionModifierContext solutionModifier() throws RecognitionException {
		SolutionModifierContext _localctx = new SolutionModifierContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_solutionModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(405); groupClause();
				}
			}

			setState(409);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(408); havingClause();
				}
			}

			setState(412);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(411); orderClause();
				}
			}

			setState(415);
			_la = _input.LA(1);
			if (_la==LIMIT || _la==OFFSET) {
				{
				setState(414); limitOffsetClauses();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupClauseContext extends ParserRuleContext {
		public TerminalNode BY() { return getToken(SparqlParser.BY, 0); }
		public GroupConditionContext groupCondition(int i) {
			return getRuleContext(GroupConditionContext.class,i);
		}
		public List<GroupConditionContext> groupCondition() {
			return getRuleContexts(GroupConditionContext.class);
		}
		public TerminalNode GROUP() { return getToken(SparqlParser.GROUP, 0); }
		public GroupClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGroupClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGroupClause(this);
		}
	}

	public final GroupClauseContext groupClause() throws RecognitionException {
		GroupClauseContext _localctx = new GroupClauseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_groupClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417); match(GROUP);
			setState(418); match(BY);
			setState(420); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(419); groupCondition();
				}
				}
				setState(422); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (STR - 25)) | (1L << (LANG - 25)) | (1L << (LANGMATCHES - 25)) | (1L << (DATATYPE - 25)) | (1L << (BOUND - 25)) | (1L << (SAMETERM - 25)) | (1L << (ISIRI - 25)) | (1L << (ISURI - 25)) | (1L << (ISBLANK - 25)) | (1L << (ISLITERAL - 25)) | (1L << (REGEX - 25)) | (1L << (SUBSTR - 25)) | (1L << (IRI - 25)) | (1L << (URI - 25)) | (1L << (BNODE - 25)) | (1L << (RAND - 25)) | (1L << (ABS - 25)) | (1L << (CEIL - 25)) | (1L << (FLOOR - 25)) | (1L << (ROUND - 25)) | (1L << (CONCAT - 25)) | (1L << (STRLEN - 25)) | (1L << (UCASE - 25)) | (1L << (LCASE - 25)) | (1L << (ENCODE_FOR_URI - 25)) | (1L << (CONTAINS - 25)) | (1L << (STRSTARTS - 25)) | (1L << (STRENDS - 25)) | (1L << (STRBEFORE - 25)) | (1L << (STRAFTER - 25)) | (1L << (REPLACE - 25)) | (1L << (YEAR - 25)) | (1L << (MONTH - 25)) | (1L << (DAY - 25)) | (1L << (HOURS - 25)) | (1L << (MINUTES - 25)) | (1L << (SECONDS - 25)))) != 0) || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (TIMEZONE - 89)) | (1L << (TZ - 89)) | (1L << (NOW - 89)) | (1L << (UUID - 89)) | (1L << (STRUUID - 89)) | (1L << (MD5 - 89)) | (1L << (SHA1 - 89)) | (1L << (SHA256 - 89)) | (1L << (SHA384 - 89)) | (1L << (SHA512 - 89)) | (1L << (COALESCE - 89)) | (1L << (IF - 89)) | (1L << (STRLANG - 89)) | (1L << (STRDT - 89)) | (1L << (ISNUMERIC - 89)) | (1L << (COUNT - 89)) | (1L << (SUM - 89)) | (1L << (MIN - 89)) | (1L << (MAX - 89)) | (1L << (AVG - 89)) | (1L << (SAMPLE - 89)) | (1L << (GROUP_CONCAT - 89)) | (1L << (NOT - 89)) | (1L << (EXISTS - 89)) | (1L << (IRIREF - 89)) | (1L << (PNAME_NS - 89)) | (1L << (PNAME_LN - 89)) | (1L << (VAR1 - 89)) | (1L << (VAR2 - 89)) | (1L << (OPEN_BRACE - 89)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupConditionContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(SparqlParser.AS, 0); }
		public BuiltInCallContext builtInCall() {
			return getRuleContext(BuiltInCallContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public GroupConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGroupCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGroupCondition(this);
		}
	}

	public final GroupConditionContext groupCondition() throws RecognitionException {
		GroupConditionContext _localctx = new GroupConditionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_groupCondition);
		int _la;
		try {
			setState(435);
			switch (_input.LA(1)) {
			case STR:
			case LANG:
			case LANGMATCHES:
			case DATATYPE:
			case BOUND:
			case SAMETERM:
			case ISIRI:
			case ISURI:
			case ISBLANK:
			case ISLITERAL:
			case REGEX:
			case SUBSTR:
			case IRI:
			case URI:
			case BNODE:
			case RAND:
			case ABS:
			case CEIL:
			case FLOOR:
			case ROUND:
			case CONCAT:
			case STRLEN:
			case UCASE:
			case LCASE:
			case ENCODE_FOR_URI:
			case CONTAINS:
			case STRSTARTS:
			case STRENDS:
			case STRBEFORE:
			case STRAFTER:
			case REPLACE:
			case YEAR:
			case MONTH:
			case DAY:
			case HOURS:
			case MINUTES:
			case SECONDS:
			case TIMEZONE:
			case TZ:
			case NOW:
			case UUID:
			case STRUUID:
			case MD5:
			case SHA1:
			case SHA256:
			case SHA384:
			case SHA512:
			case COALESCE:
			case IF:
			case STRLANG:
			case STRDT:
			case ISNUMERIC:
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
			case SAMPLE:
			case GROUP_CONCAT:
			case NOT:
			case EXISTS:
				enterOuterAlt(_localctx, 1);
				{
				setState(424); builtInCall();
				}
				break;
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 2);
				{
				setState(425); functionCall();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(426); match(OPEN_BRACE);
				setState(427); expression(0);
				setState(430);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(428); match(AS);
					setState(429); var();
					}
				}

				setState(432); match(CLOSE_BRACE);
				}
				break;
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 4);
				{
				setState(434); var();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HavingClauseContext extends ParserRuleContext {
		public HavingConditionContext havingCondition(int i) {
			return getRuleContext(HavingConditionContext.class,i);
		}
		public TerminalNode HAVING() { return getToken(SparqlParser.HAVING, 0); }
		public List<HavingConditionContext> havingCondition() {
			return getRuleContexts(HavingConditionContext.class);
		}
		public HavingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterHavingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitHavingClause(this);
		}
	}

	public final HavingClauseContext havingClause() throws RecognitionException {
		HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_havingClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437); match(HAVING);
			setState(439); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(438); havingCondition();
				}
				}
				setState(441); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (IRI - 64)) | (1L << (URI - 64)) | (1L << (BNODE - 64)) | (1L << (RAND - 64)) | (1L << (ABS - 64)) | (1L << (CEIL - 64)) | (1L << (FLOOR - 64)) | (1L << (ROUND - 64)) | (1L << (CONCAT - 64)) | (1L << (STRLEN - 64)) | (1L << (UCASE - 64)) | (1L << (LCASE - 64)) | (1L << (ENCODE_FOR_URI - 64)) | (1L << (CONTAINS - 64)) | (1L << (STRSTARTS - 64)) | (1L << (STRENDS - 64)) | (1L << (STRBEFORE - 64)) | (1L << (STRAFTER - 64)) | (1L << (REPLACE - 64)) | (1L << (YEAR - 64)) | (1L << (MONTH - 64)) | (1L << (DAY - 64)) | (1L << (HOURS - 64)) | (1L << (MINUTES - 64)) | (1L << (SECONDS - 64)) | (1L << (TIMEZONE - 64)) | (1L << (TZ - 64)) | (1L << (NOW - 64)) | (1L << (UUID - 64)) | (1L << (STRUUID - 64)) | (1L << (MD5 - 64)) | (1L << (SHA1 - 64)) | (1L << (SHA256 - 64)) | (1L << (SHA384 - 64)) | (1L << (SHA512 - 64)) | (1L << (COALESCE - 64)) | (1L << (IF - 64)) | (1L << (STRLANG - 64)) | (1L << (STRDT - 64)) | (1L << (ISNUMERIC - 64)) | (1L << (COUNT - 64)) | (1L << (SUM - 64)) | (1L << (MIN - 64)) | (1L << (MAX - 64)) | (1L << (AVG - 64)) | (1L << (SAMPLE - 64)) | (1L << (GROUP_CONCAT - 64)) | (1L << (NOT - 64)) | (1L << (EXISTS - 64)) | (1L << (IRIREF - 64)) | (1L << (PNAME_NS - 64)) | (1L << (PNAME_LN - 64)))) != 0) || _la==OPEN_BRACE || _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HavingConditionContext extends ParserRuleContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public HavingConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havingCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterHavingCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitHavingCondition(this);
		}
	}

	public final HavingConditionContext havingCondition() throws RecognitionException {
		HavingConditionContext _localctx = new HavingConditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_havingCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443); constraint();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderClauseContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(SparqlParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SparqlParser.BY, 0); }
		public OrderConditionContext orderCondition(int i) {
			return getRuleContext(OrderConditionContext.class,i);
		}
		public List<OrderConditionContext> orderCondition() {
			return getRuleContexts(OrderConditionContext.class);
		}
		public OrderClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterOrderClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitOrderClause(this);
		}
	}

	public final OrderClauseContext orderClause() throws RecognitionException {
		OrderClauseContext _localctx = new OrderClauseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_orderClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445); match(ORDER);
			setState(446); match(BY);
			setState(448); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(447); orderCondition();
				}
				}
				setState(450); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASC) | (1L << DESC) | (1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (IRI - 64)) | (1L << (URI - 64)) | (1L << (BNODE - 64)) | (1L << (RAND - 64)) | (1L << (ABS - 64)) | (1L << (CEIL - 64)) | (1L << (FLOOR - 64)) | (1L << (ROUND - 64)) | (1L << (CONCAT - 64)) | (1L << (STRLEN - 64)) | (1L << (UCASE - 64)) | (1L << (LCASE - 64)) | (1L << (ENCODE_FOR_URI - 64)) | (1L << (CONTAINS - 64)) | (1L << (STRSTARTS - 64)) | (1L << (STRENDS - 64)) | (1L << (STRBEFORE - 64)) | (1L << (STRAFTER - 64)) | (1L << (REPLACE - 64)) | (1L << (YEAR - 64)) | (1L << (MONTH - 64)) | (1L << (DAY - 64)) | (1L << (HOURS - 64)) | (1L << (MINUTES - 64)) | (1L << (SECONDS - 64)) | (1L << (TIMEZONE - 64)) | (1L << (TZ - 64)) | (1L << (NOW - 64)) | (1L << (UUID - 64)) | (1L << (STRUUID - 64)) | (1L << (MD5 - 64)) | (1L << (SHA1 - 64)) | (1L << (SHA256 - 64)) | (1L << (SHA384 - 64)) | (1L << (SHA512 - 64)) | (1L << (COALESCE - 64)) | (1L << (IF - 64)) | (1L << (STRLANG - 64)) | (1L << (STRDT - 64)) | (1L << (ISNUMERIC - 64)) | (1L << (COUNT - 64)) | (1L << (SUM - 64)) | (1L << (MIN - 64)) | (1L << (MAX - 64)) | (1L << (AVG - 64)) | (1L << (SAMPLE - 64)) | (1L << (GROUP_CONCAT - 64)) | (1L << (NOT - 64)) | (1L << (EXISTS - 64)) | (1L << (IRIREF - 64)) | (1L << (PNAME_NS - 64)) | (1L << (PNAME_LN - 64)) | (1L << (VAR1 - 64)) | (1L << (VAR2 - 64)))) != 0) || _la==OPEN_BRACE || _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderConditionContext extends ParserRuleContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public TerminalNode DESC() { return getToken(SparqlParser.DESC, 0); }
		public TerminalNode ASC() { return getToken(SparqlParser.ASC, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public OrderConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterOrderCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitOrderCondition(this);
		}
	}

	public final OrderConditionContext orderCondition() throws RecognitionException {
		OrderConditionContext _localctx = new OrderConditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_orderCondition);
		int _la;
		try {
			setState(459);
			switch (_input.LA(1)) {
			case ASC:
			case DESC:
				enterOuterAlt(_localctx, 1);
				{
				setState(452);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(453); match(OPEN_BRACE);
				setState(454); expression(0);
				setState(455); match(CLOSE_BRACE);
				}
				break;
			case STR:
			case LANG:
			case LANGMATCHES:
			case DATATYPE:
			case BOUND:
			case SAMETERM:
			case ISIRI:
			case ISURI:
			case ISBLANK:
			case ISLITERAL:
			case REGEX:
			case SUBSTR:
			case IRI:
			case URI:
			case BNODE:
			case RAND:
			case ABS:
			case CEIL:
			case FLOOR:
			case ROUND:
			case CONCAT:
			case STRLEN:
			case UCASE:
			case LCASE:
			case ENCODE_FOR_URI:
			case CONTAINS:
			case STRSTARTS:
			case STRENDS:
			case STRBEFORE:
			case STRAFTER:
			case REPLACE:
			case YEAR:
			case MONTH:
			case DAY:
			case HOURS:
			case MINUTES:
			case SECONDS:
			case TIMEZONE:
			case TZ:
			case NOW:
			case UUID:
			case STRUUID:
			case MD5:
			case SHA1:
			case SHA256:
			case SHA384:
			case SHA512:
			case COALESCE:
			case IF:
			case STRLANG:
			case STRDT:
			case ISNUMERIC:
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
			case SAMPLE:
			case GROUP_CONCAT:
			case NOT:
			case EXISTS:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case OPEN_BRACE:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(457); constraint();
				}
				break;
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 3);
				{
				setState(458); var();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitOffsetClausesContext extends ParserRuleContext {
		public OffsetClauseContext offsetClause() {
			return getRuleContext(OffsetClauseContext.class,0);
		}
		public LimitClauseContext limitClause() {
			return getRuleContext(LimitClauseContext.class,0);
		}
		public LimitOffsetClausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitOffsetClauses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterLimitOffsetClauses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitLimitOffsetClauses(this);
		}
	}

	public final LimitOffsetClausesContext limitOffsetClauses() throws RecognitionException {
		LimitOffsetClausesContext _localctx = new LimitOffsetClausesContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_limitOffsetClauses);
		int _la;
		try {
			setState(469);
			switch (_input.LA(1)) {
			case LIMIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(461); limitClause();
				setState(463);
				_la = _input.LA(1);
				if (_la==OFFSET) {
					{
					setState(462); offsetClause();
					}
				}

				}
				break;
			case OFFSET:
				enterOuterAlt(_localctx, 2);
				{
				setState(465); offsetClause();
				setState(467);
				_la = _input.LA(1);
				if (_la==LIMIT) {
					{
					setState(466); limitClause();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitClauseContext extends ParserRuleContext {
		public TerminalNode LIMIT() { return getToken(SparqlParser.LIMIT, 0); }
		public TerminalNode INTEGER() { return getToken(SparqlParser.INTEGER, 0); }
		public LimitClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterLimitClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitLimitClause(this);
		}
	}

	public final LimitClauseContext limitClause() throws RecognitionException {
		LimitClauseContext _localctx = new LimitClauseContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_limitClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471); match(LIMIT);
			setState(472); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OffsetClauseContext extends ParserRuleContext {
		public TerminalNode OFFSET() { return getToken(SparqlParser.OFFSET, 0); }
		public TerminalNode INTEGER() { return getToken(SparqlParser.INTEGER, 0); }
		public OffsetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offsetClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterOffsetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitOffsetClause(this);
		}
	}

	public final OffsetClauseContext offsetClause() throws RecognitionException {
		OffsetClauseContext _localctx = new OffsetClauseContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_offsetClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474); match(OFFSET);
			setState(475); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValuesClauseContext extends ParserRuleContext {
		public DataBlockContext dataBlock() {
			return getRuleContext(DataBlockContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(SparqlParser.VALUES, 0); }
		public ValuesClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuesClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterValuesClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitValuesClause(this);
		}
	}

	public final ValuesClauseContext valuesClause() throws RecognitionException {
		ValuesClauseContext _localctx = new ValuesClauseContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_valuesClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			_la = _input.LA(1);
			if (_la==VALUES) {
				{
				setState(477); match(VALUES);
				setState(478); dataBlock();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateCommandContext extends ParserRuleContext {
		public PrologueContext prologue(int i) {
			return getRuleContext(PrologueContext.class,i);
		}
		public List<PrologueContext> prologue() {
			return getRuleContexts(PrologueContext.class);
		}
		public List<UpdateContext> update() {
			return getRuleContexts(UpdateContext.class);
		}
		public UpdateContext update(int i) {
			return getRuleContext(UpdateContext.class,i);
		}
		public UpdateCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterUpdateCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitUpdateCommand(this);
		}
	}

	public final UpdateCommandContext updateCommand() throws RecognitionException {
		UpdateCommandContext _localctx = new UpdateCommandContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_updateCommand);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(481); prologue();
			setState(496);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOAD) | (1L << CLEAR) | (1L << DROP) | (1L << ADD) | (1L << MOVE) | (1L << COPY) | (1L << CREATE) | (1L << DELETE) | (1L << INSERT) | (1L << WITH))) != 0)) {
				{
				setState(482); update();
				setState(489);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(483); match(SEMICOLON);
						setState(484); prologue();
						setState(485); update();
						}
						} 
					}
					setState(491);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				setState(494);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(492); match(SEMICOLON);
					setState(493); prologue();
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateContext extends ParserRuleContext {
		public ModifyContext modify() {
			return getRuleContext(ModifyContext.class,0);
		}
		public DeleteDataContext deleteData() {
			return getRuleContext(DeleteDataContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public DropContext drop() {
			return getRuleContext(DropContext.class,0);
		}
		public ClearContext clear() {
			return getRuleContext(ClearContext.class,0);
		}
		public InsertDataContext insertData() {
			return getRuleContext(InsertDataContext.class,0);
		}
		public DeleteWhereContext deleteWhere() {
			return getRuleContext(DeleteWhereContext.class,0);
		}
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
		}
		public MoveContext move() {
			return getRuleContext(MoveContext.class,0);
		}
		public LoadContext load() {
			return getRuleContext(LoadContext.class,0);
		}
		public CopyContext copy() {
			return getRuleContext(CopyContext.class,0);
		}
		public UpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitUpdate(this);
		}
	}

	public final UpdateContext update() throws RecognitionException {
		UpdateContext _localctx = new UpdateContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_update);
		try {
			setState(509);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(498); load();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(499); clear();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(500); drop();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(501); add();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(502); move();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(503); copy();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(504); create();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(505); insertData();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(506); deleteData();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(507); deleteWhere();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(508); modify();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoadContext extends ParserRuleContext {
		public TerminalNode SILENT() { return getToken(SparqlParser.SILENT, 0); }
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode INTO() { return getToken(SparqlParser.INTO, 0); }
		public GraphRefContext graphRef() {
			return getRuleContext(GraphRefContext.class,0);
		}
		public TerminalNode LOAD() { return getToken(SparqlParser.LOAD, 0); }
		public LoadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_load; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitLoad(this);
		}
	}

	public final LoadContext load() throws RecognitionException {
		LoadContext _localctx = new LoadContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_load);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511); match(LOAD);
			setState(513);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(512); match(SILENT);
				}
			}

			setState(515); iri();
			setState(518);
			_la = _input.LA(1);
			if (_la==INTO) {
				{
				setState(516); match(INTO);
				setState(517); graphRef();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClearContext extends ParserRuleContext {
		public TerminalNode SILENT() { return getToken(SparqlParser.SILENT, 0); }
		public GraphRefAllContext graphRefAll() {
			return getRuleContext(GraphRefAllContext.class,0);
		}
		public TerminalNode CLEAR() { return getToken(SparqlParser.CLEAR, 0); }
		public ClearContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clear; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterClear(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitClear(this);
		}
	}

	public final ClearContext clear() throws RecognitionException {
		ClearContext _localctx = new ClearContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_clear);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520); match(CLEAR);
			setState(522);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(521); match(SILENT);
				}
			}

			setState(524); graphRefAll();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropContext extends ParserRuleContext {
		public TerminalNode SILENT() { return getToken(SparqlParser.SILENT, 0); }
		public GraphRefAllContext graphRefAll() {
			return getRuleContext(GraphRefAllContext.class,0);
		}
		public TerminalNode DROP() { return getToken(SparqlParser.DROP, 0); }
		public DropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterDrop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitDrop(this);
		}
	}

	public final DropContext drop() throws RecognitionException {
		DropContext _localctx = new DropContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_drop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526); match(DROP);
			setState(528);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(527); match(SILENT);
				}
			}

			setState(530); graphRefAll();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SparqlParser.CREATE, 0); }
		public TerminalNode SILENT() { return getToken(SparqlParser.SILENT, 0); }
		public GraphRefContext graphRef() {
			return getRuleContext(GraphRefContext.class,0);
		}
		public CreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitCreate(this);
		}
	}

	public final CreateContext create() throws RecognitionException {
		CreateContext _localctx = new CreateContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_create);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532); match(CREATE);
			setState(534);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(533); match(SILENT);
				}
			}

			setState(536); graphRef();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddContext extends ParserRuleContext {
		public GraphOrDefaultContext graphOrDefault(int i) {
			return getRuleContext(GraphOrDefaultContext.class,i);
		}
		public TerminalNode SILENT() { return getToken(SparqlParser.SILENT, 0); }
		public List<GraphOrDefaultContext> graphOrDefault() {
			return getRuleContexts(GraphOrDefaultContext.class);
		}
		public TerminalNode TO() { return getToken(SparqlParser.TO, 0); }
		public TerminalNode ADD() { return getToken(SparqlParser.ADD, 0); }
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitAdd(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538); match(ADD);
			setState(540);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(539); match(SILENT);
				}
			}

			setState(542); graphOrDefault();
			setState(543); match(TO);
			setState(544); graphOrDefault();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MoveContext extends ParserRuleContext {
		public TerminalNode MOVE() { return getToken(SparqlParser.MOVE, 0); }
		public GraphOrDefaultContext graphOrDefault(int i) {
			return getRuleContext(GraphOrDefaultContext.class,i);
		}
		public TerminalNode SILENT() { return getToken(SparqlParser.SILENT, 0); }
		public List<GraphOrDefaultContext> graphOrDefault() {
			return getRuleContexts(GraphOrDefaultContext.class);
		}
		public TerminalNode TO() { return getToken(SparqlParser.TO, 0); }
		public MoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_move; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterMove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitMove(this);
		}
	}

	public final MoveContext move() throws RecognitionException {
		MoveContext _localctx = new MoveContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_move);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546); match(MOVE);
			setState(548);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(547); match(SILENT);
				}
			}

			setState(550); graphOrDefault();
			setState(551); match(TO);
			setState(552); graphOrDefault();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CopyContext extends ParserRuleContext {
		public TerminalNode COPY() { return getToken(SparqlParser.COPY, 0); }
		public GraphOrDefaultContext graphOrDefault(int i) {
			return getRuleContext(GraphOrDefaultContext.class,i);
		}
		public TerminalNode SILENT() { return getToken(SparqlParser.SILENT, 0); }
		public List<GraphOrDefaultContext> graphOrDefault() {
			return getRuleContexts(GraphOrDefaultContext.class);
		}
		public TerminalNode TO() { return getToken(SparqlParser.TO, 0); }
		public CopyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_copy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterCopy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitCopy(this);
		}
	}

	public final CopyContext copy() throws RecognitionException {
		CopyContext _localctx = new CopyContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_copy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554); match(COPY);
			setState(556);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(555); match(SILENT);
				}
			}

			setState(558); graphOrDefault();
			setState(559); match(TO);
			setState(560); graphOrDefault();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertDataContext extends ParserRuleContext {
		public TerminalNode DATA() { return getToken(SparqlParser.DATA, 0); }
		public QuadDataContext quadData() {
			return getRuleContext(QuadDataContext.class,0);
		}
		public TerminalNode INSERT() { return getToken(SparqlParser.INSERT, 0); }
		public InsertDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterInsertData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitInsertData(this);
		}
	}

	public final InsertDataContext insertData() throws RecognitionException {
		InsertDataContext _localctx = new InsertDataContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_insertData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562); match(INSERT);
			setState(563); match(DATA);
			setState(564); quadData();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteDataContext extends ParserRuleContext {
		public TerminalNode DATA() { return getToken(SparqlParser.DATA, 0); }
		public QuadDataContext quadData() {
			return getRuleContext(QuadDataContext.class,0);
		}
		public TerminalNode DELETE() { return getToken(SparqlParser.DELETE, 0); }
		public DeleteDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterDeleteData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitDeleteData(this);
		}
	}

	public final DeleteDataContext deleteData() throws RecognitionException {
		DeleteDataContext _localctx = new DeleteDataContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_deleteData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566); match(DELETE);
			setState(567); match(DATA);
			setState(568); quadData();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteWhereContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SparqlParser.WHERE, 0); }
		public TerminalNode DELETE() { return getToken(SparqlParser.DELETE, 0); }
		public QuadPatternContext quadPattern() {
			return getRuleContext(QuadPatternContext.class,0);
		}
		public DeleteWhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteWhere; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterDeleteWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitDeleteWhere(this);
		}
	}

	public final DeleteWhereContext deleteWhere() throws RecognitionException {
		DeleteWhereContext _localctx = new DeleteWhereContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_deleteWhere);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570); match(DELETE);
			setState(571); match(WHERE);
			setState(572); quadPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifyContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SparqlParser.WHERE, 0); }
		public List<UsingClauseContext> usingClause() {
			return getRuleContexts(UsingClauseContext.class);
		}
		public DeleteClauseContext deleteClause() {
			return getRuleContext(DeleteClauseContext.class,0);
		}
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SparqlParser.WITH, 0); }
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public UsingClauseContext usingClause(int i) {
			return getRuleContext(UsingClauseContext.class,i);
		}
		public InsertClauseContext insertClause() {
			return getRuleContext(InsertClauseContext.class,0);
		}
		public ModifyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modify; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterModify(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitModify(this);
		}
	}

	public final ModifyContext modify() throws RecognitionException {
		ModifyContext _localctx = new ModifyContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_modify);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(574); match(WITH);
				setState(575); iri();
				}
			}

			setState(583);
			switch (_input.LA(1)) {
			case DELETE:
				{
				setState(578); deleteClause();
				setState(580);
				_la = _input.LA(1);
				if (_la==INSERT) {
					{
					setState(579); insertClause();
					}
				}

				}
				break;
			case INSERT:
				{
				setState(582); insertClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(588);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USING) {
				{
				{
				setState(585); usingClause();
				}
				}
				setState(590);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(591); match(WHERE);
			setState(592); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteClauseContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(SparqlParser.DELETE, 0); }
		public QuadPatternContext quadPattern() {
			return getRuleContext(QuadPatternContext.class,0);
		}
		public DeleteClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterDeleteClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitDeleteClause(this);
		}
	}

	public final DeleteClauseContext deleteClause() throws RecognitionException {
		DeleteClauseContext _localctx = new DeleteClauseContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_deleteClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594); match(DELETE);
			setState(595); quadPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertClauseContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(SparqlParser.INSERT, 0); }
		public QuadPatternContext quadPattern() {
			return getRuleContext(QuadPatternContext.class,0);
		}
		public InsertClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterInsertClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitInsertClause(this);
		}
	}

	public final InsertClauseContext insertClause() throws RecognitionException {
		InsertClauseContext _localctx = new InsertClauseContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_insertClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597); match(INSERT);
			setState(598); quadPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsingClauseContext extends ParserRuleContext {
		public TerminalNode NAMED() { return getToken(SparqlParser.NAMED, 0); }
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode USING() { return getToken(SparqlParser.USING, 0); }
		public UsingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterUsingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitUsingClause(this);
		}
	}

	public final UsingClauseContext usingClause() throws RecognitionException {
		UsingClauseContext _localctx = new UsingClauseContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_usingClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600); match(USING);
			setState(602);
			_la = _input.LA(1);
			if (_la==NAMED) {
				{
				setState(601); match(NAMED);
				}
			}

			setState(604); iri();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphOrDefaultContext extends ParserRuleContext {
		public TerminalNode GRAPH() { return getToken(SparqlParser.GRAPH, 0); }
		public TerminalNode DEFAULT() { return getToken(SparqlParser.DEFAULT, 0); }
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public GraphOrDefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphOrDefault; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGraphOrDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGraphOrDefault(this);
		}
	}

	public final GraphOrDefaultContext graphOrDefault() throws RecognitionException {
		GraphOrDefaultContext _localctx = new GraphOrDefaultContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_graphOrDefault);
		int _la;
		try {
			setState(611);
			switch (_input.LA(1)) {
			case DEFAULT:
				enterOuterAlt(_localctx, 1);
				{
				setState(606); match(DEFAULT);
				}
				break;
			case GRAPH:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 2);
				{
				setState(608);
				_la = _input.LA(1);
				if (_la==GRAPH) {
					{
					setState(607); match(GRAPH);
					}
				}

				setState(610); iri();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphRefContext extends ParserRuleContext {
		public TerminalNode GRAPH() { return getToken(SparqlParser.GRAPH, 0); }
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public GraphRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGraphRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGraphRef(this);
		}
	}

	public final GraphRefContext graphRef() throws RecognitionException {
		GraphRefContext _localctx = new GraphRefContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_graphRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613); match(GRAPH);
			setState(614); iri();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphRefAllContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(SparqlParser.ALL, 0); }
		public TerminalNode NAMED() { return getToken(SparqlParser.NAMED, 0); }
		public TerminalNode DEFAULT() { return getToken(SparqlParser.DEFAULT, 0); }
		public GraphRefContext graphRef() {
			return getRuleContext(GraphRefContext.class,0);
		}
		public GraphRefAllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphRefAll; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGraphRefAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGraphRefAll(this);
		}
	}

	public final GraphRefAllContext graphRefAll() throws RecognitionException {
		GraphRefAllContext _localctx = new GraphRefAllContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_graphRefAll);
		try {
			setState(620);
			switch (_input.LA(1)) {
			case GRAPH:
				enterOuterAlt(_localctx, 1);
				{
				setState(616); graphRef();
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(617); match(DEFAULT);
				}
				break;
			case NAMED:
				enterOuterAlt(_localctx, 3);
				{
				setState(618); match(NAMED);
				}
				break;
			case ALL:
				enterOuterAlt(_localctx, 4);
				{
				setState(619); match(ALL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuadPatternContext extends ParserRuleContext {
		public QuadsContext quads() {
			return getRuleContext(QuadsContext.class,0);
		}
		public QuadPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quadPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterQuadPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitQuadPattern(this);
		}
	}

	public final QuadPatternContext quadPattern() throws RecognitionException {
		QuadPatternContext _localctx = new QuadPatternContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_quadPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622); match(OPEN_CURLY_BRACE);
			setState(623); quads();
			setState(624); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuadDataContext extends ParserRuleContext {
		public QuadsContext quads() {
			return getRuleContext(QuadsContext.class,0);
		}
		public QuadDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quadData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterQuadData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitQuadData(this);
		}
	}

	public final QuadDataContext quadData() throws RecognitionException {
		QuadDataContext _localctx = new QuadDataContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_quadData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626); match(OPEN_CURLY_BRACE);
			setState(627); quads();
			setState(628); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuadsContext extends ParserRuleContext {
		public QuadsDetailsContext quadsDetails(int i) {
			return getRuleContext(QuadsDetailsContext.class,i);
		}
		public List<QuadsDetailsContext> quadsDetails() {
			return getRuleContexts(QuadsDetailsContext.class);
		}
		public TriplesTemplateContext triplesTemplate() {
			return getRuleContext(TriplesTemplateContext.class,0);
		}
		public QuadsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quads; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterQuads(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitQuads(this);
		}
	}

	public final QuadsContext quads() throws RecognitionException {
		QuadsContext _localctx = new QuadsContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_quads);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (BLANK_NODE_LABEL - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (OPEN_SQUARE_BRACKET - 115)))) != 0)) {
				{
				setState(630); triplesTemplate();
				}
			}

			setState(636);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GRAPH) {
				{
				{
				setState(633); quadsDetails();
				}
				}
				setState(638);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuadsDetailsContext extends ParserRuleContext {
		public TriplesTemplateContext triplesTemplate() {
			return getRuleContext(TriplesTemplateContext.class,0);
		}
		public QuadsNotTriplesContext quadsNotTriples() {
			return getRuleContext(QuadsNotTriplesContext.class,0);
		}
		public QuadsDetailsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quadsDetails; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterQuadsDetails(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitQuadsDetails(this);
		}
	}

	public final QuadsDetailsContext quadsDetails() throws RecognitionException {
		QuadsDetailsContext _localctx = new QuadsDetailsContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_quadsDetails);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639); quadsNotTriples();
			setState(641);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(640); match(DOT);
				}
			}

			setState(644);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (BLANK_NODE_LABEL - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (OPEN_SQUARE_BRACKET - 115)))) != 0)) {
				{
				setState(643); triplesTemplate();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuadsNotTriplesContext extends ParserRuleContext {
		public TerminalNode GRAPH() { return getToken(SparqlParser.GRAPH, 0); }
		public VarOrIRIContext varOrIRI() {
			return getRuleContext(VarOrIRIContext.class,0);
		}
		public TriplesTemplateContext triplesTemplate() {
			return getRuleContext(TriplesTemplateContext.class,0);
		}
		public QuadsNotTriplesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quadsNotTriples; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterQuadsNotTriples(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitQuadsNotTriples(this);
		}
	}

	public final QuadsNotTriplesContext quadsNotTriples() throws RecognitionException {
		QuadsNotTriplesContext _localctx = new QuadsNotTriplesContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_quadsNotTriples);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646); match(GRAPH);
			setState(647); varOrIRI();
			setState(648); match(OPEN_CURLY_BRACE);
			setState(650);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (BLANK_NODE_LABEL - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (OPEN_SQUARE_BRACKET - 115)))) != 0)) {
				{
				setState(649); triplesTemplate();
				}
			}

			setState(652); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplesTemplateContext extends ParserRuleContext {
		public TriplesSameSubjectContext triplesSameSubject(int i) {
			return getRuleContext(TriplesSameSubjectContext.class,i);
		}
		public List<TriplesSameSubjectContext> triplesSameSubject() {
			return getRuleContexts(TriplesSameSubjectContext.class);
		}
		public TriplesTemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplesTemplate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterTriplesTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitTriplesTemplate(this);
		}
	}

	public final TriplesTemplateContext triplesTemplate() throws RecognitionException {
		TriplesTemplateContext _localctx = new TriplesTemplateContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_triplesTemplate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(654); triplesSameSubject();
			setState(661);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(655); match(DOT);
				setState(657);
				_la = _input.LA(1);
				if (_la==TRUE || _la==FALSE || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (BLANK_NODE_LABEL - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (OPEN_SQUARE_BRACKET - 115)))) != 0)) {
					{
					setState(656); triplesSameSubject();
					}
				}

				}
				}
				setState(663);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupGraphPatternContext extends ParserRuleContext {
		public SubSelectContext subSelect() {
			return getRuleContext(SubSelectContext.class,0);
		}
		public GroupGraphPatternSubContext groupGraphPatternSub() {
			return getRuleContext(GroupGraphPatternSubContext.class,0);
		}
		public GroupGraphPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupGraphPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGroupGraphPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGroupGraphPattern(this);
		}
	}

	public final GroupGraphPatternContext groupGraphPattern() throws RecognitionException {
		GroupGraphPatternContext _localctx = new GroupGraphPatternContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_groupGraphPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(664); match(OPEN_CURLY_BRACE);
			setState(667);
			switch (_input.LA(1)) {
			case SELECT:
				{
				setState(665); subSelect();
				}
				break;
			case VALUES:
			case OPTIONAL:
			case GRAPH:
			case FILTER:
			case TRUE:
			case FALSE:
			case SERVICE:
			case BIND:
			case MINUS:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case BLANK_NODE_LABEL:
			case VAR1:
			case VAR2:
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
			case OPEN_BRACE:
			case OPEN_CURLY_BRACE:
			case CLOSE_CURLY_BRACE:
			case OPEN_SQUARE_BRACKET:
				{
				setState(666); groupGraphPatternSub();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(669); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupGraphPatternSubContext extends ParserRuleContext {
		public List<GroupGraphPatternSubListContext> groupGraphPatternSubList() {
			return getRuleContexts(GroupGraphPatternSubListContext.class);
		}
		public GroupGraphPatternSubListContext groupGraphPatternSubList(int i) {
			return getRuleContext(GroupGraphPatternSubListContext.class,i);
		}
		public TriplesBlockContext triplesBlock() {
			return getRuleContext(TriplesBlockContext.class,0);
		}
		public GroupGraphPatternSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupGraphPatternSub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGroupGraphPatternSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGroupGraphPatternSub(this);
		}
	}

	public final GroupGraphPatternSubContext groupGraphPatternSub() throws RecognitionException {
		GroupGraphPatternSubContext _localctx = new GroupGraphPatternSubContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_groupGraphPatternSub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (BLANK_NODE_LABEL - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (OPEN_SQUARE_BRACKET - 115)))) != 0)) {
				{
				setState(671); triplesBlock();
				}
			}

			setState(677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VALUES) | (1L << OPTIONAL) | (1L << GRAPH) | (1L << FILTER) | (1L << SERVICE) | (1L << BIND) | (1L << MINUS))) != 0) || _la==OPEN_CURLY_BRACE) {
				{
				{
				setState(674); groupGraphPatternSubList();
				}
				}
				setState(679);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupGraphPatternSubListContext extends ParserRuleContext {
		public GraphPatternNotTriplesContext graphPatternNotTriples() {
			return getRuleContext(GraphPatternNotTriplesContext.class,0);
		}
		public TriplesBlockContext triplesBlock() {
			return getRuleContext(TriplesBlockContext.class,0);
		}
		public GroupGraphPatternSubListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupGraphPatternSubList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGroupGraphPatternSubList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGroupGraphPatternSubList(this);
		}
	}

	public final GroupGraphPatternSubListContext groupGraphPatternSubList() throws RecognitionException {
		GroupGraphPatternSubListContext _localctx = new GroupGraphPatternSubListContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_groupGraphPatternSubList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680); graphPatternNotTriples();
			setState(682);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(681); match(DOT);
				}
			}

			setState(685);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (BLANK_NODE_LABEL - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (OPEN_SQUARE_BRACKET - 115)))) != 0)) {
				{
				setState(684); triplesBlock();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplesBlockContext extends ParserRuleContext {
		public TriplesSameSubjectPathContext triplesSameSubjectPath(int i) {
			return getRuleContext(TriplesSameSubjectPathContext.class,i);
		}
		public List<TriplesSameSubjectPathContext> triplesSameSubjectPath() {
			return getRuleContexts(TriplesSameSubjectPathContext.class);
		}
		public TriplesBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplesBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterTriplesBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitTriplesBlock(this);
		}
	}

	public final TriplesBlockContext triplesBlock() throws RecognitionException {
		TriplesBlockContext _localctx = new TriplesBlockContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_triplesBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(687); triplesSameSubjectPath();
			setState(694);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(688); match(DOT);
				setState(690);
				_la = _input.LA(1);
				if (_la==TRUE || _la==FALSE || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (BLANK_NODE_LABEL - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (OPEN_SQUARE_BRACKET - 115)))) != 0)) {
					{
					setState(689); triplesSameSubjectPath();
					}
				}

				}
				}
				setState(696);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphPatternNotTriplesContext extends ParserRuleContext {
		public InlineDataContext inlineData() {
			return getRuleContext(InlineDataContext.class,0);
		}
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public GraphGraphPatternContext graphGraphPattern() {
			return getRuleContext(GraphGraphPatternContext.class,0);
		}
		public BindContext bind() {
			return getRuleContext(BindContext.class,0);
		}
		public ServiceGraphPatternContext serviceGraphPattern() {
			return getRuleContext(ServiceGraphPatternContext.class,0);
		}
		public OptionalGraphPatternContext optionalGraphPattern() {
			return getRuleContext(OptionalGraphPatternContext.class,0);
		}
		public MinusGraphPatternContext minusGraphPattern() {
			return getRuleContext(MinusGraphPatternContext.class,0);
		}
		public GroupOrUnionGraphPatternContext groupOrUnionGraphPattern() {
			return getRuleContext(GroupOrUnionGraphPatternContext.class,0);
		}
		public GraphPatternNotTriplesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphPatternNotTriples; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGraphPatternNotTriples(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGraphPatternNotTriples(this);
		}
	}

	public final GraphPatternNotTriplesContext graphPatternNotTriples() throws RecognitionException {
		GraphPatternNotTriplesContext _localctx = new GraphPatternNotTriplesContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_graphPatternNotTriples);
		try {
			setState(705);
			switch (_input.LA(1)) {
			case OPEN_CURLY_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(697); groupOrUnionGraphPattern();
				}
				break;
			case OPTIONAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(698); optionalGraphPattern();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(699); minusGraphPattern();
				}
				break;
			case GRAPH:
				enterOuterAlt(_localctx, 4);
				{
				setState(700); graphGraphPattern();
				}
				break;
			case SERVICE:
				enterOuterAlt(_localctx, 5);
				{
				setState(701); serviceGraphPattern();
				}
				break;
			case FILTER:
				enterOuterAlt(_localctx, 6);
				{
				setState(702); filter();
				}
				break;
			case BIND:
				enterOuterAlt(_localctx, 7);
				{
				setState(703); bind();
				}
				break;
			case VALUES:
				enterOuterAlt(_localctx, 8);
				{
				setState(704); inlineData();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionalGraphPatternContext extends ParserRuleContext {
		public TerminalNode OPTIONAL() { return getToken(SparqlParser.OPTIONAL, 0); }
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public OptionalGraphPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionalGraphPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterOptionalGraphPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitOptionalGraphPattern(this);
		}
	}

	public final OptionalGraphPatternContext optionalGraphPattern() throws RecognitionException {
		OptionalGraphPatternContext _localctx = new OptionalGraphPatternContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_optionalGraphPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707); match(OPTIONAL);
			setState(708); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphGraphPatternContext extends ParserRuleContext {
		public TerminalNode GRAPH() { return getToken(SparqlParser.GRAPH, 0); }
		public VarOrIRIContext varOrIRI() {
			return getRuleContext(VarOrIRIContext.class,0);
		}
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public GraphGraphPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphGraphPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGraphGraphPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGraphGraphPattern(this);
		}
	}

	public final GraphGraphPatternContext graphGraphPattern() throws RecognitionException {
		GraphGraphPatternContext _localctx = new GraphGraphPatternContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_graphGraphPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(710); match(GRAPH);
			setState(711); varOrIRI();
			setState(712); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ServiceGraphPatternContext extends ParserRuleContext {
		public TerminalNode SILENT() { return getToken(SparqlParser.SILENT, 0); }
		public VarOrIRIContext varOrIRI() {
			return getRuleContext(VarOrIRIContext.class,0);
		}
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public TerminalNode SERVICE() { return getToken(SparqlParser.SERVICE, 0); }
		public ServiceGraphPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceGraphPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterServiceGraphPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitServiceGraphPattern(this);
		}
	}

	public final ServiceGraphPatternContext serviceGraphPattern() throws RecognitionException {
		ServiceGraphPatternContext _localctx = new ServiceGraphPatternContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_serviceGraphPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714); match(SERVICE);
			setState(716);
			_la = _input.LA(1);
			if (_la==SILENT) {
				{
				setState(715); match(SILENT);
				}
			}

			setState(718); varOrIRI();
			setState(719); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BindContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(SparqlParser.AS, 0); }
		public TerminalNode BIND() { return getToken(SparqlParser.BIND, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public BindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterBind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitBind(this);
		}
	}

	public final BindContext bind() throws RecognitionException {
		BindContext _localctx = new BindContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_bind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721); match(BIND);
			setState(722); match(OPEN_BRACE);
			setState(723); expression(0);
			setState(724); match(AS);
			setState(725); var();
			setState(726); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineDataContext extends ParserRuleContext {
		public DataBlockContext dataBlock() {
			return getRuleContext(DataBlockContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(SparqlParser.VALUES, 0); }
		public InlineDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterInlineData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitInlineData(this);
		}
	}

	public final InlineDataContext inlineData() throws RecognitionException {
		InlineDataContext _localctx = new InlineDataContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_inlineData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(728); match(VALUES);
			setState(729); dataBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataBlockContext extends ParserRuleContext {
		public InlineDataOneVarContext inlineDataOneVar() {
			return getRuleContext(InlineDataOneVarContext.class,0);
		}
		public InlineDataFullContext inlineDataFull() {
			return getRuleContext(InlineDataFullContext.class,0);
		}
		public DataBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterDataBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitDataBlock(this);
		}
	}

	public final DataBlockContext dataBlock() throws RecognitionException {
		DataBlockContext _localctx = new DataBlockContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_dataBlock);
		try {
			setState(733);
			switch (_input.LA(1)) {
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 1);
				{
				setState(731); inlineDataOneVar();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(732); inlineDataFull();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineDataOneVarContext extends ParserRuleContext {
		public List<DataBlockValueContext> dataBlockValue() {
			return getRuleContexts(DataBlockValueContext.class);
		}
		public DataBlockValueContext dataBlockValue(int i) {
			return getRuleContext(DataBlockValueContext.class,i);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public InlineDataOneVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineDataOneVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterInlineDataOneVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitInlineDataOneVar(this);
		}
	}

	public final InlineDataOneVarContext inlineDataOneVar() throws RecognitionException {
		InlineDataOneVarContext _localctx = new InlineDataOneVarContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_inlineDataOneVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735); var();
			setState(736); match(OPEN_CURLY_BRACE);
			setState(740);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << UNDEF))) != 0) || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)))) != 0)) {
				{
				{
				setState(737); dataBlockValue();
				}
				}
				setState(742);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(743); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineDataFullContext extends ParserRuleContext {
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<DataBlockValuesContext> dataBlockValues() {
			return getRuleContexts(DataBlockValuesContext.class);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public DataBlockValuesContext dataBlockValues(int i) {
			return getRuleContext(DataBlockValuesContext.class,i);
		}
		public InlineDataFullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineDataFull; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterInlineDataFull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitInlineDataFull(this);
		}
	}

	public final InlineDataFullContext inlineDataFull() throws RecognitionException {
		InlineDataFullContext _localctx = new InlineDataFullContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_inlineDataFull);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745); match(OPEN_BRACE);
			setState(749);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR1 || _la==VAR2) {
				{
				{
				setState(746); var();
				}
				}
				setState(751);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(752); match(CLOSE_BRACE);
			setState(753); match(OPEN_CURLY_BRACE);
			setState(757);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPEN_BRACE) {
				{
				{
				setState(754); dataBlockValues();
				}
				}
				setState(759);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(760); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataBlockValuesContext extends ParserRuleContext {
		public List<DataBlockValueContext> dataBlockValue() {
			return getRuleContexts(DataBlockValueContext.class);
		}
		public DataBlockValueContext dataBlockValue(int i) {
			return getRuleContext(DataBlockValueContext.class,i);
		}
		public DataBlockValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataBlockValues; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterDataBlockValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitDataBlockValues(this);
		}
	}

	public final DataBlockValuesContext dataBlockValues() throws RecognitionException {
		DataBlockValuesContext _localctx = new DataBlockValuesContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_dataBlockValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(762); match(OPEN_BRACE);
			setState(766);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << UNDEF))) != 0) || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)))) != 0)) {
				{
				{
				setState(763); dataBlockValue();
				}
				}
				setState(768);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(769); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataBlockValueContext extends ParserRuleContext {
		public RdfLiteralContext rdfLiteral() {
			return getRuleContext(RdfLiteralContext.class,0);
		}
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode UNDEF() { return getToken(SparqlParser.UNDEF, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public NumericLiteralContext numericLiteral() {
			return getRuleContext(NumericLiteralContext.class,0);
		}
		public DataBlockValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataBlockValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterDataBlockValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitDataBlockValue(this);
		}
	}

	public final DataBlockValueContext dataBlockValue() throws RecognitionException {
		DataBlockValueContext _localctx = new DataBlockValueContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_dataBlockValue);
		try {
			setState(776);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 1);
				{
				setState(771); iri();
				}
				break;
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
				enterOuterAlt(_localctx, 2);
				{
				setState(772); rdfLiteral();
				}
				break;
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(773); numericLiteral();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(774); booleanLiteral();
				}
				break;
			case UNDEF:
				enterOuterAlt(_localctx, 5);
				{
				setState(775); match(UNDEF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MinusGraphPatternContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(SparqlParser.MINUS, 0); }
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public MinusGraphPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minusGraphPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterMinusGraphPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitMinusGraphPattern(this);
		}
	}

	public final MinusGraphPatternContext minusGraphPattern() throws RecognitionException {
		MinusGraphPatternContext _localctx = new MinusGraphPatternContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_minusGraphPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778); match(MINUS);
			setState(779); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupOrUnionGraphPatternContext extends ParserRuleContext {
		public List<TerminalNode> UNION() { return getTokens(SparqlParser.UNION); }
		public List<GroupGraphPatternContext> groupGraphPattern() {
			return getRuleContexts(GroupGraphPatternContext.class);
		}
		public TerminalNode UNION(int i) {
			return getToken(SparqlParser.UNION, i);
		}
		public GroupGraphPatternContext groupGraphPattern(int i) {
			return getRuleContext(GroupGraphPatternContext.class,i);
		}
		public GroupOrUnionGraphPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupOrUnionGraphPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGroupOrUnionGraphPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGroupOrUnionGraphPattern(this);
		}
	}

	public final GroupOrUnionGraphPatternContext groupOrUnionGraphPattern() throws RecognitionException {
		GroupOrUnionGraphPatternContext _localctx = new GroupOrUnionGraphPatternContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_groupOrUnionGraphPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(781); groupGraphPattern();
			setState(786);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UNION) {
				{
				{
				setState(782); match(UNION);
				setState(783); groupGraphPattern();
				}
				}
				setState(788);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterContext extends ParserRuleContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public TerminalNode FILTER() { return getToken(SparqlParser.FILTER, 0); }
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitFilter(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		FilterContext _localctx = new FilterContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_filter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(789); match(FILTER);
			setState(790); constraint();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintContext extends ParserRuleContext {
		public BuiltInCallContext builtInCall() {
			return getRuleContext(BuiltInCallContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionListContext functionList() {
			return getRuleContext(FunctionListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitConstraint(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_constraint);
		int _la;
		try {
			setState(805);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(793);
				_la = _input.LA(1);
				if (_la==OPEN_BRACE) {
					{
					setState(792); match(OPEN_BRACE);
					}
				}

				setState(795); functionList();
				setState(797);
				_la = _input.LA(1);
				if (_la==CLOSE_BRACE) {
					{
					setState(796); match(CLOSE_BRACE);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(799); match(OPEN_BRACE);
				setState(800); expression(0);
				setState(801); match(CLOSE_BRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(803); builtInCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(804); functionCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionListContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public List<TerminalNode> AND() { return getTokens(SparqlParser.AND); }
		public List<TerminalNode> OR() { return getTokens(SparqlParser.OR); }
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public TerminalNode AND(int i) {
			return getToken(SparqlParser.AND, i);
		}
		public TerminalNode OR(int i) {
			return getToken(SparqlParser.OR, i);
		}
		public FunctionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterFunctionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitFunctionList(this);
		}
	}

	public final FunctionListContext functionList() throws RecognitionException {
		FunctionListContext _localctx = new FunctionListContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_functionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(807); function();
			setState(813);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				setState(811);
				switch (_input.LA(1)) {
				case AND:
					{
					setState(808); match(AND);
					}
					break;
				case OR:
					{
					setState(809); match(OR);
					setState(810); function();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(815);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SparqlParser.ID, 0); }
		public ParamDeclListContext paramDeclList() {
			return getRuleContext(ParamDeclListContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(SparqlParser.CLOSE_BRACE, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(SparqlParser.OPEN_BRACE, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(816); match(ID);
			setState(817); match(OPEN_BRACE);
			setState(818); paramDeclList();
			setState(819); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamDeclListContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SparqlParser.COMMA); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SparqlParser.COMMA, i);
		}
		public ParamDeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramDeclList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterParamDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitParamDeclList(this);
		}
	}

	public final ParamDeclListContext paramDeclList() throws RecognitionException {
		ParamDeclListContext _localctx = new ParamDeclListContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_paramDeclList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(829);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (IRI - 64)) | (1L << (URI - 64)) | (1L << (BNODE - 64)) | (1L << (RAND - 64)) | (1L << (ABS - 64)) | (1L << (CEIL - 64)) | (1L << (FLOOR - 64)) | (1L << (ROUND - 64)) | (1L << (CONCAT - 64)) | (1L << (STRLEN - 64)) | (1L << (UCASE - 64)) | (1L << (LCASE - 64)) | (1L << (ENCODE_FOR_URI - 64)) | (1L << (CONTAINS - 64)) | (1L << (STRSTARTS - 64)) | (1L << (STRENDS - 64)) | (1L << (STRBEFORE - 64)) | (1L << (STRAFTER - 64)) | (1L << (REPLACE - 64)) | (1L << (YEAR - 64)) | (1L << (MONTH - 64)) | (1L << (DAY - 64)) | (1L << (HOURS - 64)) | (1L << (MINUTES - 64)) | (1L << (SECONDS - 64)) | (1L << (TIMEZONE - 64)) | (1L << (TZ - 64)) | (1L << (NOW - 64)) | (1L << (UUID - 64)) | (1L << (STRUUID - 64)) | (1L << (MD5 - 64)) | (1L << (SHA1 - 64)) | (1L << (SHA256 - 64)) | (1L << (SHA384 - 64)) | (1L << (SHA512 - 64)) | (1L << (COALESCE - 64)) | (1L << (IF - 64)) | (1L << (STRLANG - 64)) | (1L << (STRDT - 64)) | (1L << (ISNUMERIC - 64)) | (1L << (COUNT - 64)) | (1L << (SUM - 64)) | (1L << (MIN - 64)) | (1L << (MAX - 64)) | (1L << (AVG - 64)) | (1L << (SAMPLE - 64)) | (1L << (GROUP_CONCAT - 64)) | (1L << (NOT - 64)) | (1L << (EXISTS - 64)) | (1L << (IRIREF - 64)) | (1L << (PNAME_NS - 64)) | (1L << (PNAME_LN - 64)) | (1L << (VAR1 - 64)) | (1L << (VAR2 - 64)) | (1L << (INTEGER - 64)) | (1L << (DECIMAL - 64)) | (1L << (DOUBLE - 64)) | (1L << (INTEGER_POSITIVE - 64)) | (1L << (DECIMAL_POSITIVE - 64)) | (1L << (DOUBLE_POSITIVE - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (INTEGER_NEGATIVE - 128)) | (1L << (DECIMAL_NEGATIVE - 128)) | (1L << (DOUBLE_NEGATIVE - 128)) | (1L << (STRING_LITERAL1 - 128)) | (1L << (STRING_LITERAL2 - 128)) | (1L << (STRING_LITERAL_LONG1 - 128)) | (1L << (STRING_LITERAL_LONG2 - 128)) | (1L << (OPEN_BRACE - 128)) | (1L << (PLUS_SIGN - 128)) | (1L << (MINUS_SIGN - 128)) | (1L << (ASTERISK - 128)) | (1L << (NEGATION - 128)) | (1L << (DIVIDE - 128)) | (1L << (ID - 128)))) != 0)) {
				{
				setState(821); expression(0);
				setState(826);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(822); match(COMMA);
					setState(823); expression(0);
					}
					}
					setState(828);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(831); iri();
			setState(832); argList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(SparqlParser.DISTINCT, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitArgList(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(834); match(OPEN_BRACE);
			setState(840);
			switch (_input.LA(1)) {
			case DISTINCT:
			case STR:
			case LANG:
			case LANGMATCHES:
			case DATATYPE:
			case BOUND:
			case SAMETERM:
			case ISIRI:
			case ISURI:
			case ISBLANK:
			case ISLITERAL:
			case REGEX:
			case SUBSTR:
			case TRUE:
			case FALSE:
			case IRI:
			case URI:
			case BNODE:
			case RAND:
			case ABS:
			case CEIL:
			case FLOOR:
			case ROUND:
			case CONCAT:
			case STRLEN:
			case UCASE:
			case LCASE:
			case ENCODE_FOR_URI:
			case CONTAINS:
			case STRSTARTS:
			case STRENDS:
			case STRBEFORE:
			case STRAFTER:
			case REPLACE:
			case YEAR:
			case MONTH:
			case DAY:
			case HOURS:
			case MINUTES:
			case SECONDS:
			case TIMEZONE:
			case TZ:
			case NOW:
			case UUID:
			case STRUUID:
			case MD5:
			case SHA1:
			case SHA256:
			case SHA384:
			case SHA512:
			case COALESCE:
			case IF:
			case STRLANG:
			case STRDT:
			case ISNUMERIC:
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
			case SAMPLE:
			case GROUP_CONCAT:
			case NOT:
			case EXISTS:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case VAR1:
			case VAR2:
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
			case OPEN_BRACE:
			case PLUS_SIGN:
			case MINUS_SIGN:
			case ASTERISK:
			case NEGATION:
			case DIVIDE:
			case ID:
				{
				setState(836);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(835); match(DISTINCT);
					}
				}

				setState(838); expressionList();
				}
				break;
			case CLOSE_BRACE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(842); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitExpressionList(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(844); expression(0);
			setState(849);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(845); match(COMMA);
				setState(846); expression(0);
				}
				}
				setState(851);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructTemplateContext extends ParserRuleContext {
		public ConstructTriplesContext constructTriples() {
			return getRuleContext(ConstructTriplesContext.class,0);
		}
		public ConstructTemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructTemplate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterConstructTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitConstructTemplate(this);
		}
	}

	public final ConstructTemplateContext constructTemplate() throws RecognitionException {
		ConstructTemplateContext _localctx = new ConstructTemplateContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_constructTemplate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(852); match(OPEN_CURLY_BRACE);
			setState(854);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (BLANK_NODE_LABEL - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (OPEN_SQUARE_BRACKET - 115)))) != 0)) {
				{
				setState(853); constructTriples();
				}
			}

			setState(856); match(CLOSE_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructTriplesContext extends ParserRuleContext {
		public ConstructTriplesContext constructTriples(int i) {
			return getRuleContext(ConstructTriplesContext.class,i);
		}
		public List<ConstructTriplesContext> constructTriples() {
			return getRuleContexts(ConstructTriplesContext.class);
		}
		public TriplesSameSubjectContext triplesSameSubject() {
			return getRuleContext(TriplesSameSubjectContext.class,0);
		}
		public ConstructTriplesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructTriples; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterConstructTriples(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitConstructTriples(this);
		}
	}

	public final ConstructTriplesContext constructTriples() throws RecognitionException {
		ConstructTriplesContext _localctx = new ConstructTriplesContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_constructTriples);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(858); triplesSameSubject();
			setState(865);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(859); match(DOT);
					setState(861);
					_la = _input.LA(1);
					if (_la==TRUE || _la==FALSE || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (BLANK_NODE_LABEL - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (OPEN_SQUARE_BRACKET - 115)))) != 0)) {
						{
						setState(860); constructTriples();
						}
					}

					}
					} 
				}
				setState(867);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplesSameSubjectContext extends ParserRuleContext {
		public TriplesNodeContext triplesNode() {
			return getRuleContext(TriplesNodeContext.class,0);
		}
		public PropertyListContext propertyList() {
			return getRuleContext(PropertyListContext.class,0);
		}
		public PropertyListNotEmptyContext propertyListNotEmpty() {
			return getRuleContext(PropertyListNotEmptyContext.class,0);
		}
		public VarOrTermContext varOrTerm() {
			return getRuleContext(VarOrTermContext.class,0);
		}
		public TriplesSameSubjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplesSameSubject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterTriplesSameSubject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitTriplesSameSubject(this);
		}
	}

	public final TriplesSameSubjectContext triplesSameSubject() throws RecognitionException {
		TriplesSameSubjectContext _localctx = new TriplesSameSubjectContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_triplesSameSubject);
		try {
			setState(874);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(868); varOrTerm();
				setState(869); propertyListNotEmpty();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(871); triplesNode();
				setState(872); propertyList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyListContext extends ParserRuleContext {
		public PropertyListNotEmptyContext propertyListNotEmpty() {
			return getRuleContext(PropertyListNotEmptyContext.class,0);
		}
		public PropertyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPropertyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPropertyList(this);
		}
	}

	public final PropertyListContext propertyList() throws RecognitionException {
		PropertyListContext _localctx = new PropertyListContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_propertyList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(877);
			_la = _input.LA(1);
			if (_la==A || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)))) != 0)) {
				{
				setState(876); propertyListNotEmpty();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyListNotEmptyContext extends ParserRuleContext {
		public List<VerbContext> verb() {
			return getRuleContexts(VerbContext.class);
		}
		public VerbContext verb(int i) {
			return getRuleContext(VerbContext.class,i);
		}
		public ObjectListContext objectList(int i) {
			return getRuleContext(ObjectListContext.class,i);
		}
		public List<ObjectListContext> objectList() {
			return getRuleContexts(ObjectListContext.class);
		}
		public PropertyListNotEmptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyListNotEmpty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPropertyListNotEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPropertyListNotEmpty(this);
		}
	}

	public final PropertyListNotEmptyContext propertyListNotEmpty() throws RecognitionException {
		PropertyListNotEmptyContext _localctx = new PropertyListNotEmptyContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_propertyListNotEmpty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(879); verb();
			setState(880); objectList();
			setState(889);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(881); match(SEMICOLON);
				setState(885);
				_la = _input.LA(1);
				if (_la==A || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)))) != 0)) {
					{
					setState(882); verb();
					setState(883); objectList();
					}
				}

				}
				}
				setState(891);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VerbContext extends ParserRuleContext {
		public VarOrIRIContext varOrIRI() {
			return getRuleContext(VarOrIRIContext.class,0);
		}
		public TerminalNode A() { return getToken(SparqlParser.A, 0); }
		public VerbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterVerb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitVerb(this);
		}
	}

	public final VerbContext verb() throws RecognitionException {
		VerbContext _localctx = new VerbContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_verb);
		try {
			setState(894);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 1);
				{
				setState(892); varOrIRI();
				}
				break;
			case A:
				enterOuterAlt(_localctx, 2);
				{
				setState(893); match(A);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectListContext extends ParserRuleContext {
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterObjectList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitObjectList(this);
		}
	}

	public final ObjectListContext objectList() throws RecognitionException {
		ObjectListContext _localctx = new ObjectListContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_objectList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(896); object();
			setState(901);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(897); match(COMMA);
				setState(898); object();
				}
				}
				setState(903);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectContext extends ParserRuleContext {
		public GraphNodeContext graphNode() {
			return getRuleContext(GraphNodeContext.class,0);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitObject(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(904); graphNode();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplesSameSubjectPathContext extends ParserRuleContext {
		public PropertyListPathContext propertyListPath() {
			return getRuleContext(PropertyListPathContext.class,0);
		}
		public PropertyListPathNotEmptyContext propertyListPathNotEmpty() {
			return getRuleContext(PropertyListPathNotEmptyContext.class,0);
		}
		public VarOrTermContext varOrTerm() {
			return getRuleContext(VarOrTermContext.class,0);
		}
		public TriplesNodePathContext triplesNodePath() {
			return getRuleContext(TriplesNodePathContext.class,0);
		}
		public TriplesSameSubjectPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplesSameSubjectPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterTriplesSameSubjectPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitTriplesSameSubjectPath(this);
		}
	}

	public final TriplesSameSubjectPathContext triplesSameSubjectPath() throws RecognitionException {
		TriplesSameSubjectPathContext _localctx = new TriplesSameSubjectPathContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_triplesSameSubjectPath);
		try {
			setState(912);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(906); varOrTerm();
				setState(907); propertyListPathNotEmpty();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(909); triplesNodePath();
				setState(910); propertyListPath();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyListPathContext extends ParserRuleContext {
		public PropertyListPathNotEmptyContext propertyListPathNotEmpty() {
			return getRuleContext(PropertyListPathNotEmptyContext.class,0);
		}
		public PropertyListPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyListPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPropertyListPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPropertyListPath(this);
		}
	}

	public final PropertyListPathContext propertyListPath() throws RecognitionException {
		PropertyListPathContext _localctx = new PropertyListPathContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_propertyListPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(915);
			_la = _input.LA(1);
			if (_la==A || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INVERSE - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (NEGATION - 115)))) != 0)) {
				{
				setState(914); propertyListPathNotEmpty();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyListPathNotEmptyContext extends ParserRuleContext {
		public VerbSimpleContext verbSimple() {
			return getRuleContext(VerbSimpleContext.class,0);
		}
		public List<PropertyListPathNotEmptyListContext> propertyListPathNotEmptyList() {
			return getRuleContexts(PropertyListPathNotEmptyListContext.class);
		}
		public VerbPathContext verbPath() {
			return getRuleContext(VerbPathContext.class,0);
		}
		public ObjectListPathContext objectListPath() {
			return getRuleContext(ObjectListPathContext.class,0);
		}
		public PropertyListPathNotEmptyListContext propertyListPathNotEmptyList(int i) {
			return getRuleContext(PropertyListPathNotEmptyListContext.class,i);
		}
		public PropertyListPathNotEmptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyListPathNotEmpty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPropertyListPathNotEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPropertyListPathNotEmpty(this);
		}
	}

	public final PropertyListPathNotEmptyContext propertyListPathNotEmpty() throws RecognitionException {
		PropertyListPathNotEmptyContext _localctx = new PropertyListPathNotEmptyContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_propertyListPathNotEmpty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(919);
			switch (_input.LA(1)) {
			case A:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case INVERSE:
			case OPEN_BRACE:
			case NEGATION:
				{
				setState(917); verbPath();
				}
				break;
			case VAR1:
			case VAR2:
				{
				setState(918); verbSimple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(921); objectListPath();
			setState(928);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(922); match(SEMICOLON);
				setState(924);
				_la = _input.LA(1);
				if (_la==A || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INVERSE - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (NEGATION - 115)))) != 0)) {
					{
					setState(923); propertyListPathNotEmptyList();
					}
				}

				}
				}
				setState(930);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyListPathNotEmptyListContext extends ParserRuleContext {
		public VerbSimpleContext verbSimple() {
			return getRuleContext(VerbSimpleContext.class,0);
		}
		public VerbPathContext verbPath() {
			return getRuleContext(VerbPathContext.class,0);
		}
		public ObjectListContext objectList() {
			return getRuleContext(ObjectListContext.class,0);
		}
		public PropertyListPathNotEmptyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyListPathNotEmptyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPropertyListPathNotEmptyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPropertyListPathNotEmptyList(this);
		}
	}

	public final PropertyListPathNotEmptyListContext propertyListPathNotEmptyList() throws RecognitionException {
		PropertyListPathNotEmptyListContext _localctx = new PropertyListPathNotEmptyListContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_propertyListPathNotEmptyList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(933);
			switch (_input.LA(1)) {
			case A:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case INVERSE:
			case OPEN_BRACE:
			case NEGATION:
				{
				setState(931); verbPath();
				}
				break;
			case VAR1:
			case VAR2:
				{
				setState(932); verbSimple();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(935); objectList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VerbPathContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public VerbPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterVerbPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitVerbPath(this);
		}
	}

	public final VerbPathContext verbPath() throws RecognitionException {
		VerbPathContext _localctx = new VerbPathContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_verbPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(937); path();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VerbSimpleContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VerbSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbSimple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterVerbSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitVerbSimple(this);
		}
	}

	public final VerbSimpleContext verbSimple() throws RecognitionException {
		VerbSimpleContext _localctx = new VerbSimpleContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_verbSimple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(939); var();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectListPathContext extends ParserRuleContext {
		public ObjectPathContext objectPath(int i) {
			return getRuleContext(ObjectPathContext.class,i);
		}
		public List<ObjectPathContext> objectPath() {
			return getRuleContexts(ObjectPathContext.class);
		}
		public ObjectListPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectListPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterObjectListPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitObjectListPath(this);
		}
	}

	public final ObjectListPathContext objectListPath() throws RecognitionException {
		ObjectListPathContext _localctx = new ObjectListPathContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_objectListPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(941); objectPath();
			setState(946);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(942); match(COMMA);
				setState(943); objectPath();
				}
				}
				setState(948);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectPathContext extends ParserRuleContext {
		public GraphNodePathContext graphNodePath() {
			return getRuleContext(GraphNodePathContext.class,0);
		}
		public ObjectPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterObjectPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitObjectPath(this);
		}
	}

	public final ObjectPathContext objectPath() throws RecognitionException {
		ObjectPathContext _localctx = new ObjectPathContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_objectPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(949); graphNodePath();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathContext extends ParserRuleContext {
		public PathAlternativeContext pathAlternative() {
			return getRuleContext(PathAlternativeContext.class,0);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPath(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(951); pathAlternative();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathAlternativeContext extends ParserRuleContext {
		public PathSequenceContext pathSequence(int i) {
			return getRuleContext(PathSequenceContext.class,i);
		}
		public List<PathSequenceContext> pathSequence() {
			return getRuleContexts(PathSequenceContext.class);
		}
		public PathAlternativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathAlternative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPathAlternative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPathAlternative(this);
		}
	}

	public final PathAlternativeContext pathAlternative() throws RecognitionException {
		PathAlternativeContext _localctx = new PathAlternativeContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_pathAlternative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(953); pathSequence();
			setState(958);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				setState(954); match(PIPE);
				setState(955); pathSequence();
				}
				}
				setState(960);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathSequenceContext extends ParserRuleContext {
		public PathEltOrInverseContext pathEltOrInverse(int i) {
			return getRuleContext(PathEltOrInverseContext.class,i);
		}
		public List<PathEltOrInverseContext> pathEltOrInverse() {
			return getRuleContexts(PathEltOrInverseContext.class);
		}
		public PathSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPathSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPathSequence(this);
		}
	}

	public final PathSequenceContext pathSequence() throws RecognitionException {
		PathSequenceContext _localctx = new PathSequenceContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_pathSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(961); pathEltOrInverse();
			setState(966);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIVIDE) {
				{
				{
				setState(962); match(DIVIDE);
				setState(963); pathEltOrInverse();
				}
				}
				setState(968);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathEltContext extends ParserRuleContext {
		public PathModContext pathMod() {
			return getRuleContext(PathModContext.class,0);
		}
		public PathPrimaryContext pathPrimary() {
			return getRuleContext(PathPrimaryContext.class,0);
		}
		public PathEltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathElt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPathElt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPathElt(this);
		}
	}

	public final PathEltContext pathElt() throws RecognitionException {
		PathEltContext _localctx = new PathEltContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_pathElt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(969); pathPrimary();
			setState(971);
			_la = _input.LA(1);
			if (((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (PLUS_SIGN - 151)) | (1L << (ASTERISK - 151)) | (1L << (QUESTION_MARK - 151)))) != 0)) {
				{
				setState(970); pathMod();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathEltOrInverseContext extends ParserRuleContext {
		public TerminalNode INVERSE() { return getToken(SparqlParser.INVERSE, 0); }
		public PathEltContext pathElt() {
			return getRuleContext(PathEltContext.class,0);
		}
		public PathEltOrInverseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathEltOrInverse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPathEltOrInverse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPathEltOrInverse(this);
		}
	}

	public final PathEltOrInverseContext pathEltOrInverse() throws RecognitionException {
		PathEltOrInverseContext _localctx = new PathEltOrInverseContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_pathEltOrInverse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(974);
			_la = _input.LA(1);
			if (_la==INVERSE) {
				{
				setState(973); match(INVERSE);
				}
			}

			setState(976); pathElt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathModContext extends ParserRuleContext {
		public Token op;
		public PathModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathMod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPathMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPathMod(this);
		}
	}

	public final PathModContext pathMod() throws RecognitionException {
		PathModContext _localctx = new PathModContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_pathMod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(978);
			((PathModContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (PLUS_SIGN - 151)) | (1L << (ASTERISK - 151)) | (1L << (QUESTION_MARK - 151)))) != 0)) ) {
				((PathModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathPrimaryContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public PathNegatedPropertySetContext pathNegatedPropertySet() {
			return getRuleContext(PathNegatedPropertySetContext.class,0);
		}
		public TerminalNode A() { return getToken(SparqlParser.A, 0); }
		public PathPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathPrimary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPathPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPathPrimary(this);
		}
	}

	public final PathPrimaryContext pathPrimary() throws RecognitionException {
		PathPrimaryContext _localctx = new PathPrimaryContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_pathPrimary);
		try {
			setState(988);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 1);
				{
				setState(980); iri();
				}
				break;
			case A:
				enterOuterAlt(_localctx, 2);
				{
				setState(981); match(A);
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 3);
				{
				setState(982); match(NEGATION);
				setState(983); pathNegatedPropertySet();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 4);
				{
				setState(984); match(OPEN_BRACE);
				setState(985); path();
				setState(986); match(CLOSE_BRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathNegatedPropertySetContext extends ParserRuleContext {
		public List<PathOneInPropertySetContext> pathOneInPropertySet() {
			return getRuleContexts(PathOneInPropertySetContext.class);
		}
		public PathOneInPropertySetContext pathOneInPropertySet(int i) {
			return getRuleContext(PathOneInPropertySetContext.class,i);
		}
		public PathNegatedPropertySetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathNegatedPropertySet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPathNegatedPropertySet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPathNegatedPropertySet(this);
		}
	}

	public final PathNegatedPropertySetContext pathNegatedPropertySet() throws RecognitionException {
		PathNegatedPropertySetContext _localctx = new PathNegatedPropertySetContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_pathNegatedPropertySet);
		int _la;
		try {
			setState(1003);
			switch (_input.LA(1)) {
			case A:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case INVERSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(990); pathOneInPropertySet();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(991); match(OPEN_BRACE);
				setState(1000);
				_la = _input.LA(1);
				if (_la==A || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (INVERSE - 115)))) != 0)) {
					{
					setState(992); pathOneInPropertySet();
					setState(997);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PIPE) {
						{
						{
						setState(993); match(PIPE);
						setState(994); pathOneInPropertySet();
						}
						}
						setState(999);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1002); match(CLOSE_BRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathOneInPropertySetContext extends ParserRuleContext {
		public TerminalNode INVERSE() { return getToken(SparqlParser.INVERSE, 0); }
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode A() { return getToken(SparqlParser.A, 0); }
		public PathOneInPropertySetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathOneInPropertySet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPathOneInPropertySet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPathOneInPropertySet(this);
		}
	}

	public final PathOneInPropertySetContext pathOneInPropertySet() throws RecognitionException {
		PathOneInPropertySetContext _localctx = new PathOneInPropertySetContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_pathOneInPropertySet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1006);
			_la = _input.LA(1);
			if (_la==INVERSE) {
				{
				setState(1005); match(INVERSE);
				}
			}

			setState(1010);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				{
				setState(1008); iri();
				}
				break;
			case A:
				{
				setState(1009); match(A);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(SparqlParser.INTEGER, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1012); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplesNodeContext extends ParserRuleContext {
		public BlankNodePropertyListContext blankNodePropertyList() {
			return getRuleContext(BlankNodePropertyListContext.class,0);
		}
		public CollectionContext collection() {
			return getRuleContext(CollectionContext.class,0);
		}
		public TriplesNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplesNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterTriplesNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitTriplesNode(this);
		}
	}

	public final TriplesNodeContext triplesNode() throws RecognitionException {
		TriplesNodeContext _localctx = new TriplesNodeContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_triplesNode);
		try {
			setState(1016);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1014); collection();
				}
				break;
			case OPEN_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1015); blankNodePropertyList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlankNodePropertyListContext extends ParserRuleContext {
		public PropertyListNotEmptyContext propertyListNotEmpty() {
			return getRuleContext(PropertyListNotEmptyContext.class,0);
		}
		public BlankNodePropertyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blankNodePropertyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterBlankNodePropertyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitBlankNodePropertyList(this);
		}
	}

	public final BlankNodePropertyListContext blankNodePropertyList() throws RecognitionException {
		BlankNodePropertyListContext _localctx = new BlankNodePropertyListContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_blankNodePropertyList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1018); match(OPEN_SQUARE_BRACKET);
			setState(1019); propertyListNotEmpty();
			setState(1020); match(CLOSE_SQUARE_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplesNodePathContext extends ParserRuleContext {
		public CollectionPathContext collectionPath() {
			return getRuleContext(CollectionPathContext.class,0);
		}
		public BlankNodePropertyListPathContext blankNodePropertyListPath() {
			return getRuleContext(BlankNodePropertyListPathContext.class,0);
		}
		public TriplesNodePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplesNodePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterTriplesNodePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitTriplesNodePath(this);
		}
	}

	public final TriplesNodePathContext triplesNodePath() throws RecognitionException {
		TriplesNodePathContext _localctx = new TriplesNodePathContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_triplesNodePath);
		try {
			setState(1024);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1022); collectionPath();
				}
				break;
			case OPEN_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1023); blankNodePropertyListPath();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlankNodePropertyListPathContext extends ParserRuleContext {
		public PropertyListPathNotEmptyContext propertyListPathNotEmpty() {
			return getRuleContext(PropertyListPathNotEmptyContext.class,0);
		}
		public BlankNodePropertyListPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blankNodePropertyListPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterBlankNodePropertyListPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitBlankNodePropertyListPath(this);
		}
	}

	public final BlankNodePropertyListPathContext blankNodePropertyListPath() throws RecognitionException {
		BlankNodePropertyListPathContext _localctx = new BlankNodePropertyListPathContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_blankNodePropertyListPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1026); match(OPEN_SQUARE_BRACKET);
			setState(1027); propertyListPathNotEmpty();
			setState(1028); match(CLOSE_SQUARE_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CollectionContext extends ParserRuleContext {
		public List<GraphNodeContext> graphNode() {
			return getRuleContexts(GraphNodeContext.class);
		}
		public GraphNodeContext graphNode(int i) {
			return getRuleContext(GraphNodeContext.class,i);
		}
		public CollectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterCollection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitCollection(this);
		}
	}

	public final CollectionContext collection() throws RecognitionException {
		CollectionContext _localctx = new CollectionContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_collection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1030); match(OPEN_BRACE);
			setState(1032); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1031); graphNode();
				}
				}
				setState(1034); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TRUE || _la==FALSE || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (BLANK_NODE_LABEL - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (OPEN_SQUARE_BRACKET - 115)))) != 0) );
			setState(1036); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CollectionPathContext extends ParserRuleContext {
		public List<GraphNodePathContext> graphNodePath() {
			return getRuleContexts(GraphNodePathContext.class);
		}
		public GraphNodePathContext graphNodePath(int i) {
			return getRuleContext(GraphNodePathContext.class,i);
		}
		public CollectionPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collectionPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterCollectionPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitCollectionPath(this);
		}
	}

	public final CollectionPathContext collectionPath() throws RecognitionException {
		CollectionPathContext _localctx = new CollectionPathContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_collectionPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1038); match(OPEN_BRACE);
			setState(1040); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1039); graphNodePath();
				}
				}
				setState(1042); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TRUE || _la==FALSE || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & ((1L << (IRIREF - 115)) | (1L << (PNAME_NS - 115)) | (1L << (PNAME_LN - 115)) | (1L << (BLANK_NODE_LABEL - 115)) | (1L << (VAR1 - 115)) | (1L << (VAR2 - 115)) | (1L << (INTEGER - 115)) | (1L << (DECIMAL - 115)) | (1L << (DOUBLE - 115)) | (1L << (INTEGER_POSITIVE - 115)) | (1L << (DECIMAL_POSITIVE - 115)) | (1L << (DOUBLE_POSITIVE - 115)) | (1L << (INTEGER_NEGATIVE - 115)) | (1L << (DECIMAL_NEGATIVE - 115)) | (1L << (DOUBLE_NEGATIVE - 115)) | (1L << (STRING_LITERAL1 - 115)) | (1L << (STRING_LITERAL2 - 115)) | (1L << (STRING_LITERAL_LONG1 - 115)) | (1L << (STRING_LITERAL_LONG2 - 115)) | (1L << (OPEN_BRACE - 115)) | (1L << (OPEN_SQUARE_BRACKET - 115)))) != 0) );
			setState(1044); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphNodeContext extends ParserRuleContext {
		public TriplesNodeContext triplesNode() {
			return getRuleContext(TriplesNodeContext.class,0);
		}
		public VarOrTermContext varOrTerm() {
			return getRuleContext(VarOrTermContext.class,0);
		}
		public GraphNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGraphNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGraphNode(this);
		}
	}

	public final GraphNodeContext graphNode() throws RecognitionException {
		GraphNodeContext _localctx = new GraphNodeContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_graphNode);
		try {
			setState(1048);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1046); varOrTerm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1047); triplesNode();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphNodePathContext extends ParserRuleContext {
		public VarOrTermContext varOrTerm() {
			return getRuleContext(VarOrTermContext.class,0);
		}
		public TriplesNodePathContext triplesNodePath() {
			return getRuleContext(TriplesNodePathContext.class,0);
		}
		public GraphNodePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphNodePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGraphNodePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGraphNodePath(this);
		}
	}

	public final GraphNodePathContext graphNodePath() throws RecognitionException {
		GraphNodePathContext _localctx = new GraphNodePathContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_graphNodePath);
		try {
			setState(1052);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1050); varOrTerm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1051); triplesNodePath();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarOrTermContext extends ParserRuleContext {
		public GraphTermContext graphTerm() {
			return getRuleContext(GraphTermContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarOrTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varOrTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterVarOrTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitVarOrTerm(this);
		}
	}

	public final VarOrTermContext varOrTerm() throws RecognitionException {
		VarOrTermContext _localctx = new VarOrTermContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_varOrTerm);
		try {
			setState(1056);
			switch (_input.LA(1)) {
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 1);
				{
				setState(1054); var();
				}
				break;
			case TRUE:
			case FALSE:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case BLANK_NODE_LABEL:
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
			case OPEN_BRACE:
			case OPEN_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1055); graphTerm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarOrIRIContext extends ParserRuleContext {
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarOrIRIContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varOrIRI; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterVarOrIRI(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitVarOrIRI(this);
		}
	}

	public final VarOrIRIContext varOrIRI() throws RecognitionException {
		VarOrIRIContext _localctx = new VarOrIRIContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_varOrIRI);
		try {
			setState(1060);
			switch (_input.LA(1)) {
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 1);
				{
				setState(1058); var();
				}
				break;
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1059); iri();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR2() { return getToken(SparqlParser.VAR2, 0); }
		public TerminalNode VAR1() { return getToken(SparqlParser.VAR1, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1062);
			_la = _input.LA(1);
			if ( !(_la==VAR1 || _la==VAR2) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphTermContext extends ParserRuleContext {
		public RdfLiteralContext rdfLiteral() {
			return getRuleContext(RdfLiteralContext.class,0);
		}
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public NilContext nil() {
			return getRuleContext(NilContext.class,0);
		}
		public BlankNodeContext blankNode() {
			return getRuleContext(BlankNodeContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public NumericLiteralContext numericLiteral() {
			return getRuleContext(NumericLiteralContext.class,0);
		}
		public GraphTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGraphTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGraphTerm(this);
		}
	}

	public final GraphTermContext graphTerm() throws RecognitionException {
		GraphTermContext _localctx = new GraphTermContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_graphTerm);
		try {
			setState(1070);
			switch (_input.LA(1)) {
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1064); iri();
				}
				break;
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1065); rdfLiteral();
				}
				break;
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1066); numericLiteral();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1067); booleanLiteral();
				}
				break;
			case BLANK_NODE_LABEL:
			case OPEN_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 5);
				{
				setState(1068); blankNode();
				}
				break;
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 6);
				{
				setState(1069); nil();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NilContext extends ParserRuleContext {
		public NilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nil; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterNil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitNil(this);
		}
	}

	public final NilContext nil() throws RecognitionException {
		NilContext _localctx = new NilContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_nil);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1072); match(OPEN_BRACE);
			setState(1073); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryMultiplicativeExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryMultiplicativeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterUnaryMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitUnaryMultiplicativeExpression(this);
		}
	}
	public static class RelationalSetExpressionContext extends ExpressionContext {
		public TerminalNode IN() { return getToken(SparqlParser.IN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SparqlParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RelationalSetExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterRelationalSetExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitRelationalSetExpression(this);
		}
	}
	public static class UnaryAdditiveExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryAdditiveExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterUnaryAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitUnaryAdditiveExpression(this);
		}
	}
	public static class ConditionalAndExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ConditionalAndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterConditionalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitConditionalAndExpression(this);
		}
	}
	public static class RelationalExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public RelationalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitRelationalExpression(this);
		}
	}
	public static class BaseExpressionContext extends ExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public BaseExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterBaseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitBaseExpression(this);
		}
	}
	public static class ConditionalOrExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ConditionalOrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterConditionalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitConditionalOrExpression(this);
		}
	}
	public static class AdditiveExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AdditiveExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitAdditiveExpression(this);
		}
	}
	public static class UnaryNegationExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryNegationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterUnaryNegationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitUnaryNegationExpression(this);
		}
	}
	public static class UnarySignedLiteralExpressionContext extends ExpressionContext {
		public UnaryLiteralExpressionContext unaryLiteralExpression() {
			return getRuleContext(UnaryLiteralExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnarySignedLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterUnarySignedLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitUnarySignedLiteralExpression(this);
		}
	}
	public static class MultiplicativeExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public MultiplicativeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitMultiplicativeExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 226;
		enterRecursionRule(_localctx, 226, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1083);
			switch (_input.LA(1)) {
			case ASTERISK:
			case DIVIDE:
				{
				_localctx = new UnaryMultiplicativeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1076);
				((UnaryMultiplicativeExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASTERISK || _la==DIVIDE) ) {
					((UnaryMultiplicativeExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(1077); expression(10);
				}
				break;
			case PLUS_SIGN:
			case MINUS_SIGN:
				{
				_localctx = new UnaryAdditiveExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1078);
				((UnaryAdditiveExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS_SIGN || _la==MINUS_SIGN) ) {
					((UnaryAdditiveExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(1079); expression(9);
				}
				break;
			case NEGATION:
				{
				_localctx = new UnaryNegationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1080); match(NEGATION);
				setState(1081); expression(8);
				}
				break;
			case STR:
			case LANG:
			case LANGMATCHES:
			case DATATYPE:
			case BOUND:
			case SAMETERM:
			case ISIRI:
			case ISURI:
			case ISBLANK:
			case ISLITERAL:
			case REGEX:
			case SUBSTR:
			case TRUE:
			case FALSE:
			case IRI:
			case URI:
			case BNODE:
			case RAND:
			case ABS:
			case CEIL:
			case FLOOR:
			case ROUND:
			case CONCAT:
			case STRLEN:
			case UCASE:
			case LCASE:
			case ENCODE_FOR_URI:
			case CONTAINS:
			case STRSTARTS:
			case STRENDS:
			case STRBEFORE:
			case STRAFTER:
			case REPLACE:
			case YEAR:
			case MONTH:
			case DAY:
			case HOURS:
			case MINUTES:
			case SECONDS:
			case TIMEZONE:
			case TZ:
			case NOW:
			case UUID:
			case STRUUID:
			case MD5:
			case SHA1:
			case SHA256:
			case SHA384:
			case SHA512:
			case COALESCE:
			case IF:
			case STRLANG:
			case STRDT:
			case ISNUMERIC:
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
			case SAMPLE:
			case GROUP_CONCAT:
			case NOT:
			case EXISTS:
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
			case VAR1:
			case VAR2:
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
			case OPEN_BRACE:
			case ID:
				{
				_localctx = new BaseExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1082); primaryExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1112);
					switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1085);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1086);
						((MultiplicativeExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ASTERISK || _la==DIVIDE) ) {
							((MultiplicativeExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(1087); expression(8);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1088);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1089);
						((AdditiveExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS_SIGN || _la==MINUS_SIGN) ) {
							((AdditiveExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(1090); expression(7);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1091);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1092);
						((RelationalExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & ((1L << (LESS_EQUAL - 137)) | (1L << (GREATER_EQUAL - 137)) | (1L << (NOT_EQUAL - 137)) | (1L << (EQUAL - 137)) | (1L << (LESS - 137)) | (1L << (GREATER - 137)))) != 0)) ) {
							((RelationalExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(1093); expression(4);
						}
						break;
					case 4:
						{
						_localctx = new UnarySignedLiteralExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1094);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1095); unaryLiteralExpression();
						}
						break;
					case 5:
						{
						_localctx = new RelationalSetExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1096);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1098);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(1097); match(NOT);
							}
						}

						setState(1100); match(IN);
						setState(1101); match(OPEN_BRACE);
						setState(1103);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (IRI - 64)) | (1L << (URI - 64)) | (1L << (BNODE - 64)) | (1L << (RAND - 64)) | (1L << (ABS - 64)) | (1L << (CEIL - 64)) | (1L << (FLOOR - 64)) | (1L << (ROUND - 64)) | (1L << (CONCAT - 64)) | (1L << (STRLEN - 64)) | (1L << (UCASE - 64)) | (1L << (LCASE - 64)) | (1L << (ENCODE_FOR_URI - 64)) | (1L << (CONTAINS - 64)) | (1L << (STRSTARTS - 64)) | (1L << (STRENDS - 64)) | (1L << (STRBEFORE - 64)) | (1L << (STRAFTER - 64)) | (1L << (REPLACE - 64)) | (1L << (YEAR - 64)) | (1L << (MONTH - 64)) | (1L << (DAY - 64)) | (1L << (HOURS - 64)) | (1L << (MINUTES - 64)) | (1L << (SECONDS - 64)) | (1L << (TIMEZONE - 64)) | (1L << (TZ - 64)) | (1L << (NOW - 64)) | (1L << (UUID - 64)) | (1L << (STRUUID - 64)) | (1L << (MD5 - 64)) | (1L << (SHA1 - 64)) | (1L << (SHA256 - 64)) | (1L << (SHA384 - 64)) | (1L << (SHA512 - 64)) | (1L << (COALESCE - 64)) | (1L << (IF - 64)) | (1L << (STRLANG - 64)) | (1L << (STRDT - 64)) | (1L << (ISNUMERIC - 64)) | (1L << (COUNT - 64)) | (1L << (SUM - 64)) | (1L << (MIN - 64)) | (1L << (MAX - 64)) | (1L << (AVG - 64)) | (1L << (SAMPLE - 64)) | (1L << (GROUP_CONCAT - 64)) | (1L << (NOT - 64)) | (1L << (EXISTS - 64)) | (1L << (IRIREF - 64)) | (1L << (PNAME_NS - 64)) | (1L << (PNAME_LN - 64)) | (1L << (VAR1 - 64)) | (1L << (VAR2 - 64)) | (1L << (INTEGER - 64)) | (1L << (DECIMAL - 64)) | (1L << (DOUBLE - 64)) | (1L << (INTEGER_POSITIVE - 64)) | (1L << (DECIMAL_POSITIVE - 64)) | (1L << (DOUBLE_POSITIVE - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (INTEGER_NEGATIVE - 128)) | (1L << (DECIMAL_NEGATIVE - 128)) | (1L << (DOUBLE_NEGATIVE - 128)) | (1L << (STRING_LITERAL1 - 128)) | (1L << (STRING_LITERAL2 - 128)) | (1L << (STRING_LITERAL_LONG1 - 128)) | (1L << (STRING_LITERAL_LONG2 - 128)) | (1L << (OPEN_BRACE - 128)) | (1L << (PLUS_SIGN - 128)) | (1L << (MINUS_SIGN - 128)) | (1L << (ASTERISK - 128)) | (1L << (NEGATION - 128)) | (1L << (DIVIDE - 128)) | (1L << (ID - 128)))) != 0)) {
							{
							setState(1102); expressionList();
							}
						}

						setState(1105); match(CLOSE_BRACE);
						}
						break;
					case 6:
						{
						_localctx = new ConditionalAndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1106);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(1107); match(AND);
						setState(1108); expression(0);
						}
						}
						break;
					case 7:
						{
						_localctx = new ConditionalOrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1109);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						{
						setState(1110); match(OR);
						setState(1111); expression(0);
						}
						}
						break;
					}
					} 
				}
				setState(1116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryLiteralExpressionContext extends ParserRuleContext {
		public Token op;
		public NumericLiteralPositiveContext numericLiteralPositive() {
			return getRuleContext(NumericLiteralPositiveContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public NumericLiteralNegativeContext numericLiteralNegative() {
			return getRuleContext(NumericLiteralNegativeContext.class,0);
		}
		public UnaryLiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryLiteralExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterUnaryLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitUnaryLiteralExpression(this);
		}
	}

	public final UnaryLiteralExpressionContext unaryLiteralExpression() throws RecognitionException {
		UnaryLiteralExpressionContext _localctx = new UnaryLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_unaryLiteralExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1119);
			switch (_input.LA(1)) {
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
				{
				setState(1117); numericLiteralPositive();
				}
				break;
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
				{
				setState(1118); numericLiteralNegative();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1123);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				{
				setState(1121);
				((UnaryLiteralExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASTERISK || _la==DIVIDE) ) {
					((UnaryLiteralExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(1122); unaryExpression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public Token op;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_unaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1126);
			_la = _input.LA(1);
			if (((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (PLUS_SIGN - 151)) | (1L << (MINUS_SIGN - 151)) | (1L << (NEGATION - 151)))) != 0)) {
				{
				setState(1125);
				((UnaryExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (PLUS_SIGN - 151)) | (1L << (MINUS_SIGN - 151)) | (1L << (NEGATION - 151)))) != 0)) ) {
					((UnaryExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(1128); primaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public BuiltInCallContext builtInCall() {
			return getRuleContext(BuiltInCallContext.class,0);
		}
		public RdfLiteralContext rdfLiteral() {
			return getRuleContext(RdfLiteralContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public IriRefOrFunctionContext iriRefOrFunction() {
			return getRuleContext(IriRefOrFunctionContext.class,0);
		}
		public NumericLiteralContext numericLiteral() {
			return getRuleContext(NumericLiteralContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPrimaryExpression(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_primaryExpression);
		try {
			setState(1141);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1130); match(OPEN_BRACE);
				setState(1131); expression(0);
				setState(1132); match(CLOSE_BRACE);
				}
				break;
			case STR:
			case LANG:
			case LANGMATCHES:
			case DATATYPE:
			case BOUND:
			case SAMETERM:
			case ISIRI:
			case ISURI:
			case ISBLANK:
			case ISLITERAL:
			case REGEX:
			case SUBSTR:
			case IRI:
			case URI:
			case BNODE:
			case RAND:
			case ABS:
			case CEIL:
			case FLOOR:
			case ROUND:
			case CONCAT:
			case STRLEN:
			case UCASE:
			case LCASE:
			case ENCODE_FOR_URI:
			case CONTAINS:
			case STRSTARTS:
			case STRENDS:
			case STRBEFORE:
			case STRAFTER:
			case REPLACE:
			case YEAR:
			case MONTH:
			case DAY:
			case HOURS:
			case MINUTES:
			case SECONDS:
			case TIMEZONE:
			case TZ:
			case NOW:
			case UUID:
			case STRUUID:
			case MD5:
			case SHA1:
			case SHA256:
			case SHA384:
			case SHA512:
			case COALESCE:
			case IF:
			case STRLANG:
			case STRDT:
			case ISNUMERIC:
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
			case SAMPLE:
			case GROUP_CONCAT:
			case NOT:
			case EXISTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(1134); builtInCall();
				}
				break;
			case IRIREF:
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 3);
				{
				setState(1135); iriRefOrFunction();
				}
				break;
			case STRING_LITERAL1:
			case STRING_LITERAL2:
			case STRING_LITERAL_LONG1:
			case STRING_LITERAL_LONG2:
				enterOuterAlt(_localctx, 4);
				{
				setState(1136); rdfLiteral();
				}
				break;
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
				enterOuterAlt(_localctx, 5);
				{
				setState(1137); numericLiteral();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(1138); booleanLiteral();
				}
				break;
			case VAR1:
			case VAR2:
				enterOuterAlt(_localctx, 7);
				{
				setState(1139); var();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 8);
				{
				setState(1140); function();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuiltInCallContext extends ParserRuleContext {
		public TerminalNode SHA256() { return getToken(SparqlParser.SHA256, 0); }
		public TerminalNode COALESCE() { return getToken(SparqlParser.COALESCE, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RAND() { return getToken(SparqlParser.RAND, 0); }
		public TerminalNode ABS() { return getToken(SparqlParser.ABS, 0); }
		public TerminalNode SAMETERM() { return getToken(SparqlParser.SAMETERM, 0); }
		public TerminalNode CONTAINS() { return getToken(SparqlParser.CONTAINS, 0); }
		public TerminalNode YEAR() { return getToken(SparqlParser.YEAR, 0); }
		public TerminalNode SHA512() { return getToken(SparqlParser.SHA512, 0); }
		public TerminalNode IF() { return getToken(SparqlParser.IF, 0); }
		public TerminalNode STR() { return getToken(SparqlParser.STR, 0); }
		public TerminalNode SHA384() { return getToken(SparqlParser.SHA384, 0); }
		public TerminalNode TZ() { return getToken(SparqlParser.TZ, 0); }
		public TerminalNode STRBEFORE() { return getToken(SparqlParser.STRBEFORE, 0); }
		public TerminalNode LANG() { return getToken(SparqlParser.LANG, 0); }
		public TerminalNode ISBLANK() { return getToken(SparqlParser.ISBLANK, 0); }
		public TerminalNode UUID() { return getToken(SparqlParser.UUID, 0); }
		public TerminalNode URI() { return getToken(SparqlParser.URI, 0); }
		public ExistsFunctionContext existsFunction() {
			return getRuleContext(ExistsFunctionContext.class,0);
		}
		public TerminalNode ISIRI() { return getToken(SparqlParser.ISIRI, 0); }
		public TerminalNode STRLEN() { return getToken(SparqlParser.STRLEN, 0); }
		public TerminalNode ROUND() { return getToken(SparqlParser.ROUND, 0); }
		public RegexExpressionContext regexExpression() {
			return getRuleContext(RegexExpressionContext.class,0);
		}
		public TerminalNode STRLANG() { return getToken(SparqlParser.STRLANG, 0); }
		public TerminalNode CEIL() { return getToken(SparqlParser.CEIL, 0); }
		public TerminalNode NOW() { return getToken(SparqlParser.NOW, 0); }
		public TerminalNode STRDT() { return getToken(SparqlParser.STRDT, 0); }
		public TerminalNode LCASE() { return getToken(SparqlParser.LCASE, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode ISLITERAL() { return getToken(SparqlParser.ISLITERAL, 0); }
		public TerminalNode IRI() { return getToken(SparqlParser.IRI, 0); }
		public TerminalNode MONTH() { return getToken(SparqlParser.MONTH, 0); }
		public TerminalNode MINUTES() { return getToken(SparqlParser.MINUTES, 0); }
		public TerminalNode DATATYPE() { return getToken(SparqlParser.DATATYPE, 0); }
		public TerminalNode TIMEZONE() { return getToken(SparqlParser.TIMEZONE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode UCASE() { return getToken(SparqlParser.UCASE, 0); }
		public TerminalNode HOURS() { return getToken(SparqlParser.HOURS, 0); }
		public TerminalNode ISNUMERIC() { return getToken(SparqlParser.ISNUMERIC, 0); }
		public AggregateContext aggregate() {
			return getRuleContext(AggregateContext.class,0);
		}
		public TerminalNode ENCODE_FOR_URI() { return getToken(SparqlParser.ENCODE_FOR_URI, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode STRAFTER() { return getToken(SparqlParser.STRAFTER, 0); }
		public TerminalNode MD5() { return getToken(SparqlParser.MD5, 0); }
		public TerminalNode BNODE() { return getToken(SparqlParser.BNODE, 0); }
		public TerminalNode DAY() { return getToken(SparqlParser.DAY, 0); }
		public TerminalNode LANGMATCHES() { return getToken(SparqlParser.LANGMATCHES, 0); }
		public TerminalNode STRSTARTS() { return getToken(SparqlParser.STRSTARTS, 0); }
		public TerminalNode SECONDS() { return getToken(SparqlParser.SECONDS, 0); }
		public TerminalNode BOUND() { return getToken(SparqlParser.BOUND, 0); }
		public TerminalNode STRUUID() { return getToken(SparqlParser.STRUUID, 0); }
		public NotExistsFunctionContext notExistsFunction() {
			return getRuleContext(NotExistsFunctionContext.class,0);
		}
		public TerminalNode ISURI() { return getToken(SparqlParser.ISURI, 0); }
		public SubStringExpressionContext subStringExpression() {
			return getRuleContext(SubStringExpressionContext.class,0);
		}
		public TerminalNode CONCAT() { return getToken(SparqlParser.CONCAT, 0); }
		public TerminalNode SHA1() { return getToken(SparqlParser.SHA1, 0); }
		public TerminalNode STRENDS() { return getToken(SparqlParser.STRENDS, 0); }
		public StrReplaceExpressionContext strReplaceExpression() {
			return getRuleContext(StrReplaceExpressionContext.class,0);
		}
		public TerminalNode FLOOR() { return getToken(SparqlParser.FLOOR, 0); }
		public BuiltInCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtInCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterBuiltInCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitBuiltInCall(this);
		}
	}

	public final BuiltInCallContext builtInCall() throws RecognitionException {
		BuiltInCallContext _localctx = new BuiltInCallContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_builtInCall);
		int _la;
		try {
			setState(1411);
			switch (_input.LA(1)) {
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
			case SAMPLE:
			case GROUP_CONCAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1143); aggregate();
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1144); match(STR);
				setState(1145); match(OPEN_BRACE);
				setState(1146); expression(0);
				setState(1147); match(CLOSE_BRACE);
				}
				break;
			case LANG:
				enterOuterAlt(_localctx, 3);
				{
				setState(1149); match(LANG);
				setState(1150); match(OPEN_BRACE);
				setState(1151); expression(0);
				setState(1152); match(CLOSE_BRACE);
				}
				break;
			case LANGMATCHES:
				enterOuterAlt(_localctx, 4);
				{
				setState(1154); match(LANGMATCHES);
				setState(1155); match(OPEN_BRACE);
				setState(1156); expression(0);
				setState(1157); match(COMMA);
				setState(1158); expression(0);
				setState(1159); match(CLOSE_BRACE);
				}
				break;
			case DATATYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(1161); match(DATATYPE);
				setState(1162); match(OPEN_BRACE);
				setState(1163); expression(0);
				setState(1164); match(CLOSE_BRACE);
				}
				break;
			case BOUND:
				enterOuterAlt(_localctx, 6);
				{
				setState(1166); match(BOUND);
				setState(1167); match(OPEN_BRACE);
				setState(1168); var();
				setState(1169); match(CLOSE_BRACE);
				}
				break;
			case IRI:
				enterOuterAlt(_localctx, 7);
				{
				setState(1171); match(IRI);
				setState(1172); match(OPEN_BRACE);
				setState(1173); expression(0);
				setState(1174); match(CLOSE_BRACE);
				}
				break;
			case URI:
				enterOuterAlt(_localctx, 8);
				{
				setState(1176); match(URI);
				setState(1177); match(OPEN_BRACE);
				setState(1178); expression(0);
				setState(1179); match(CLOSE_BRACE);
				}
				break;
			case BNODE:
				enterOuterAlt(_localctx, 9);
				{
				setState(1181); match(BNODE);
				setState(1182); match(OPEN_BRACE);
				setState(1184);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (IRI - 64)) | (1L << (URI - 64)) | (1L << (BNODE - 64)) | (1L << (RAND - 64)) | (1L << (ABS - 64)) | (1L << (CEIL - 64)) | (1L << (FLOOR - 64)) | (1L << (ROUND - 64)) | (1L << (CONCAT - 64)) | (1L << (STRLEN - 64)) | (1L << (UCASE - 64)) | (1L << (LCASE - 64)) | (1L << (ENCODE_FOR_URI - 64)) | (1L << (CONTAINS - 64)) | (1L << (STRSTARTS - 64)) | (1L << (STRENDS - 64)) | (1L << (STRBEFORE - 64)) | (1L << (STRAFTER - 64)) | (1L << (REPLACE - 64)) | (1L << (YEAR - 64)) | (1L << (MONTH - 64)) | (1L << (DAY - 64)) | (1L << (HOURS - 64)) | (1L << (MINUTES - 64)) | (1L << (SECONDS - 64)) | (1L << (TIMEZONE - 64)) | (1L << (TZ - 64)) | (1L << (NOW - 64)) | (1L << (UUID - 64)) | (1L << (STRUUID - 64)) | (1L << (MD5 - 64)) | (1L << (SHA1 - 64)) | (1L << (SHA256 - 64)) | (1L << (SHA384 - 64)) | (1L << (SHA512 - 64)) | (1L << (COALESCE - 64)) | (1L << (IF - 64)) | (1L << (STRLANG - 64)) | (1L << (STRDT - 64)) | (1L << (ISNUMERIC - 64)) | (1L << (COUNT - 64)) | (1L << (SUM - 64)) | (1L << (MIN - 64)) | (1L << (MAX - 64)) | (1L << (AVG - 64)) | (1L << (SAMPLE - 64)) | (1L << (GROUP_CONCAT - 64)) | (1L << (NOT - 64)) | (1L << (EXISTS - 64)) | (1L << (IRIREF - 64)) | (1L << (PNAME_NS - 64)) | (1L << (PNAME_LN - 64)) | (1L << (VAR1 - 64)) | (1L << (VAR2 - 64)) | (1L << (INTEGER - 64)) | (1L << (DECIMAL - 64)) | (1L << (DOUBLE - 64)) | (1L << (INTEGER_POSITIVE - 64)) | (1L << (DECIMAL_POSITIVE - 64)) | (1L << (DOUBLE_POSITIVE - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (INTEGER_NEGATIVE - 128)) | (1L << (DECIMAL_NEGATIVE - 128)) | (1L << (DOUBLE_NEGATIVE - 128)) | (1L << (STRING_LITERAL1 - 128)) | (1L << (STRING_LITERAL2 - 128)) | (1L << (STRING_LITERAL_LONG1 - 128)) | (1L << (STRING_LITERAL_LONG2 - 128)) | (1L << (OPEN_BRACE - 128)) | (1L << (PLUS_SIGN - 128)) | (1L << (MINUS_SIGN - 128)) | (1L << (ASTERISK - 128)) | (1L << (NEGATION - 128)) | (1L << (DIVIDE - 128)) | (1L << (ID - 128)))) != 0)) {
					{
					setState(1183); expression(0);
					}
				}

				setState(1186); match(CLOSE_BRACE);
				}
				break;
			case RAND:
				enterOuterAlt(_localctx, 10);
				{
				setState(1187); match(RAND);
				setState(1188); match(OPEN_BRACE);
				setState(1189); match(CLOSE_BRACE);
				}
				break;
			case ABS:
				enterOuterAlt(_localctx, 11);
				{
				setState(1190); match(ABS);
				setState(1191); match(OPEN_BRACE);
				setState(1192); expression(0);
				setState(1193); match(CLOSE_BRACE);
				}
				break;
			case CEIL:
				enterOuterAlt(_localctx, 12);
				{
				setState(1195); match(CEIL);
				setState(1196); match(OPEN_BRACE);
				setState(1197); expression(0);
				setState(1198); match(CLOSE_BRACE);
				}
				break;
			case FLOOR:
				enterOuterAlt(_localctx, 13);
				{
				setState(1200); match(FLOOR);
				setState(1201); match(OPEN_BRACE);
				setState(1202); expression(0);
				setState(1203); match(CLOSE_BRACE);
				}
				break;
			case ROUND:
				enterOuterAlt(_localctx, 14);
				{
				setState(1205); match(ROUND);
				setState(1206); match(OPEN_BRACE);
				setState(1207); expression(0);
				setState(1208); match(CLOSE_BRACE);
				}
				break;
			case CONCAT:
				enterOuterAlt(_localctx, 15);
				{
				setState(1210); match(CONCAT);
				setState(1211); match(OPEN_BRACE);
				setState(1213);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (IRI - 64)) | (1L << (URI - 64)) | (1L << (BNODE - 64)) | (1L << (RAND - 64)) | (1L << (ABS - 64)) | (1L << (CEIL - 64)) | (1L << (FLOOR - 64)) | (1L << (ROUND - 64)) | (1L << (CONCAT - 64)) | (1L << (STRLEN - 64)) | (1L << (UCASE - 64)) | (1L << (LCASE - 64)) | (1L << (ENCODE_FOR_URI - 64)) | (1L << (CONTAINS - 64)) | (1L << (STRSTARTS - 64)) | (1L << (STRENDS - 64)) | (1L << (STRBEFORE - 64)) | (1L << (STRAFTER - 64)) | (1L << (REPLACE - 64)) | (1L << (YEAR - 64)) | (1L << (MONTH - 64)) | (1L << (DAY - 64)) | (1L << (HOURS - 64)) | (1L << (MINUTES - 64)) | (1L << (SECONDS - 64)) | (1L << (TIMEZONE - 64)) | (1L << (TZ - 64)) | (1L << (NOW - 64)) | (1L << (UUID - 64)) | (1L << (STRUUID - 64)) | (1L << (MD5 - 64)) | (1L << (SHA1 - 64)) | (1L << (SHA256 - 64)) | (1L << (SHA384 - 64)) | (1L << (SHA512 - 64)) | (1L << (COALESCE - 64)) | (1L << (IF - 64)) | (1L << (STRLANG - 64)) | (1L << (STRDT - 64)) | (1L << (ISNUMERIC - 64)) | (1L << (COUNT - 64)) | (1L << (SUM - 64)) | (1L << (MIN - 64)) | (1L << (MAX - 64)) | (1L << (AVG - 64)) | (1L << (SAMPLE - 64)) | (1L << (GROUP_CONCAT - 64)) | (1L << (NOT - 64)) | (1L << (EXISTS - 64)) | (1L << (IRIREF - 64)) | (1L << (PNAME_NS - 64)) | (1L << (PNAME_LN - 64)) | (1L << (VAR1 - 64)) | (1L << (VAR2 - 64)) | (1L << (INTEGER - 64)) | (1L << (DECIMAL - 64)) | (1L << (DOUBLE - 64)) | (1L << (INTEGER_POSITIVE - 64)) | (1L << (DECIMAL_POSITIVE - 64)) | (1L << (DOUBLE_POSITIVE - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (INTEGER_NEGATIVE - 128)) | (1L << (DECIMAL_NEGATIVE - 128)) | (1L << (DOUBLE_NEGATIVE - 128)) | (1L << (STRING_LITERAL1 - 128)) | (1L << (STRING_LITERAL2 - 128)) | (1L << (STRING_LITERAL_LONG1 - 128)) | (1L << (STRING_LITERAL_LONG2 - 128)) | (1L << (OPEN_BRACE - 128)) | (1L << (PLUS_SIGN - 128)) | (1L << (MINUS_SIGN - 128)) | (1L << (ASTERISK - 128)) | (1L << (NEGATION - 128)) | (1L << (DIVIDE - 128)) | (1L << (ID - 128)))) != 0)) {
					{
					setState(1212); expressionList();
					}
				}

				setState(1215); match(CLOSE_BRACE);
				}
				break;
			case SUBSTR:
				enterOuterAlt(_localctx, 16);
				{
				setState(1216); subStringExpression();
				}
				break;
			case STRLEN:
				enterOuterAlt(_localctx, 17);
				{
				setState(1217); match(STRLEN);
				setState(1218); match(OPEN_BRACE);
				setState(1219); expression(0);
				setState(1220); match(CLOSE_BRACE);
				}
				break;
			case REPLACE:
				enterOuterAlt(_localctx, 18);
				{
				setState(1222); strReplaceExpression();
				}
				break;
			case UCASE:
				enterOuterAlt(_localctx, 19);
				{
				setState(1223); match(UCASE);
				setState(1224); match(OPEN_BRACE);
				setState(1225); expression(0);
				setState(1226); match(CLOSE_BRACE);
				}
				break;
			case LCASE:
				enterOuterAlt(_localctx, 20);
				{
				setState(1228); match(LCASE);
				setState(1229); match(OPEN_BRACE);
				setState(1230); expression(0);
				setState(1231); match(CLOSE_BRACE);
				}
				break;
			case ENCODE_FOR_URI:
				enterOuterAlt(_localctx, 21);
				{
				setState(1233); match(ENCODE_FOR_URI);
				setState(1234); match(OPEN_BRACE);
				setState(1235); expression(0);
				setState(1236); match(CLOSE_BRACE);
				}
				break;
			case CONTAINS:
				enterOuterAlt(_localctx, 22);
				{
				setState(1238); match(CONTAINS);
				setState(1239); match(OPEN_BRACE);
				setState(1240); expression(0);
				setState(1241); match(COMMA);
				setState(1242); expression(0);
				setState(1243); match(CLOSE_BRACE);
				}
				break;
			case STRSTARTS:
				enterOuterAlt(_localctx, 23);
				{
				setState(1245); match(STRSTARTS);
				setState(1246); match(OPEN_BRACE);
				setState(1247); expression(0);
				setState(1248); match(COMMA);
				setState(1249); expression(0);
				setState(1250); match(CLOSE_BRACE);
				}
				break;
			case STRENDS:
				enterOuterAlt(_localctx, 24);
				{
				setState(1252); match(STRENDS);
				setState(1253); match(OPEN_BRACE);
				setState(1254); expression(0);
				setState(1255); match(COMMA);
				setState(1256); expression(0);
				setState(1257); match(CLOSE_BRACE);
				}
				break;
			case STRBEFORE:
				enterOuterAlt(_localctx, 25);
				{
				setState(1259); match(STRBEFORE);
				setState(1260); match(OPEN_BRACE);
				setState(1261); expression(0);
				setState(1262); match(COMMA);
				setState(1263); expression(0);
				setState(1264); match(CLOSE_BRACE);
				}
				break;
			case STRAFTER:
				enterOuterAlt(_localctx, 26);
				{
				setState(1266); match(STRAFTER);
				setState(1267); match(OPEN_BRACE);
				setState(1268); expression(0);
				setState(1269); match(COMMA);
				setState(1270); expression(0);
				setState(1271); match(CLOSE_BRACE);
				}
				break;
			case YEAR:
				enterOuterAlt(_localctx, 27);
				{
				setState(1273); match(YEAR);
				setState(1274); match(OPEN_BRACE);
				setState(1275); expression(0);
				setState(1276); match(CLOSE_BRACE);
				}
				break;
			case MONTH:
				enterOuterAlt(_localctx, 28);
				{
				setState(1278); match(MONTH);
				setState(1279); match(OPEN_BRACE);
				setState(1280); expression(0);
				setState(1281); match(CLOSE_BRACE);
				}
				break;
			case DAY:
				enterOuterAlt(_localctx, 29);
				{
				setState(1283); match(DAY);
				setState(1284); match(OPEN_BRACE);
				setState(1285); expression(0);
				setState(1286); match(CLOSE_BRACE);
				}
				break;
			case HOURS:
				enterOuterAlt(_localctx, 30);
				{
				setState(1288); match(HOURS);
				setState(1289); match(OPEN_BRACE);
				setState(1290); expression(0);
				setState(1291); match(CLOSE_BRACE);
				}
				break;
			case MINUTES:
				enterOuterAlt(_localctx, 31);
				{
				setState(1293); match(MINUTES);
				setState(1294); match(OPEN_BRACE);
				setState(1295); expression(0);
				setState(1296); match(CLOSE_BRACE);
				}
				break;
			case SECONDS:
				enterOuterAlt(_localctx, 32);
				{
				setState(1298); match(SECONDS);
				setState(1299); match(OPEN_BRACE);
				setState(1300); expression(0);
				setState(1301); match(CLOSE_BRACE);
				}
				break;
			case TIMEZONE:
				enterOuterAlt(_localctx, 33);
				{
				setState(1303); match(TIMEZONE);
				setState(1304); match(OPEN_BRACE);
				setState(1305); expression(0);
				setState(1306); match(CLOSE_BRACE);
				}
				break;
			case TZ:
				enterOuterAlt(_localctx, 34);
				{
				setState(1308); match(TZ);
				setState(1309); match(OPEN_BRACE);
				setState(1310); expression(0);
				setState(1311); match(CLOSE_BRACE);
				}
				break;
			case NOW:
				enterOuterAlt(_localctx, 35);
				{
				setState(1313); match(NOW);
				setState(1314); match(OPEN_BRACE);
				setState(1315); match(CLOSE_BRACE);
				}
				break;
			case UUID:
				enterOuterAlt(_localctx, 36);
				{
				setState(1316); match(UUID);
				setState(1317); match(OPEN_BRACE);
				setState(1318); match(CLOSE_BRACE);
				}
				break;
			case STRUUID:
				enterOuterAlt(_localctx, 37);
				{
				setState(1319); match(STRUUID);
				setState(1320); match(OPEN_BRACE);
				setState(1321); match(CLOSE_BRACE);
				}
				break;
			case MD5:
				enterOuterAlt(_localctx, 38);
				{
				setState(1322); match(MD5);
				setState(1323); match(OPEN_BRACE);
				setState(1324); expression(0);
				setState(1325); match(CLOSE_BRACE);
				}
				break;
			case SHA1:
				enterOuterAlt(_localctx, 39);
				{
				setState(1327); match(SHA1);
				setState(1328); match(OPEN_BRACE);
				setState(1329); expression(0);
				setState(1330); match(CLOSE_BRACE);
				}
				break;
			case SHA256:
				enterOuterAlt(_localctx, 40);
				{
				setState(1332); match(SHA256);
				setState(1333); match(OPEN_BRACE);
				setState(1334); expression(0);
				setState(1335); match(CLOSE_BRACE);
				}
				break;
			case SHA384:
				enterOuterAlt(_localctx, 41);
				{
				setState(1337); match(SHA384);
				setState(1338); match(OPEN_BRACE);
				setState(1339); expression(0);
				setState(1340); match(CLOSE_BRACE);
				}
				break;
			case SHA512:
				enterOuterAlt(_localctx, 42);
				{
				setState(1342); match(SHA512);
				setState(1343); match(OPEN_BRACE);
				setState(1344); expression(0);
				setState(1345); match(CLOSE_BRACE);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 43);
				{
				setState(1347); match(COALESCE);
				setState(1348); match(OPEN_BRACE);
				setState(1350);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR) | (1L << LANG) | (1L << LANGMATCHES) | (1L << DATATYPE) | (1L << BOUND) | (1L << SAMETERM) | (1L << ISIRI) | (1L << ISURI) | (1L << ISBLANK) | (1L << ISLITERAL) | (1L << REGEX) | (1L << SUBSTR) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (IRI - 64)) | (1L << (URI - 64)) | (1L << (BNODE - 64)) | (1L << (RAND - 64)) | (1L << (ABS - 64)) | (1L << (CEIL - 64)) | (1L << (FLOOR - 64)) | (1L << (ROUND - 64)) | (1L << (CONCAT - 64)) | (1L << (STRLEN - 64)) | (1L << (UCASE - 64)) | (1L << (LCASE - 64)) | (1L << (ENCODE_FOR_URI - 64)) | (1L << (CONTAINS - 64)) | (1L << (STRSTARTS - 64)) | (1L << (STRENDS - 64)) | (1L << (STRBEFORE - 64)) | (1L << (STRAFTER - 64)) | (1L << (REPLACE - 64)) | (1L << (YEAR - 64)) | (1L << (MONTH - 64)) | (1L << (DAY - 64)) | (1L << (HOURS - 64)) | (1L << (MINUTES - 64)) | (1L << (SECONDS - 64)) | (1L << (TIMEZONE - 64)) | (1L << (TZ - 64)) | (1L << (NOW - 64)) | (1L << (UUID - 64)) | (1L << (STRUUID - 64)) | (1L << (MD5 - 64)) | (1L << (SHA1 - 64)) | (1L << (SHA256 - 64)) | (1L << (SHA384 - 64)) | (1L << (SHA512 - 64)) | (1L << (COALESCE - 64)) | (1L << (IF - 64)) | (1L << (STRLANG - 64)) | (1L << (STRDT - 64)) | (1L << (ISNUMERIC - 64)) | (1L << (COUNT - 64)) | (1L << (SUM - 64)) | (1L << (MIN - 64)) | (1L << (MAX - 64)) | (1L << (AVG - 64)) | (1L << (SAMPLE - 64)) | (1L << (GROUP_CONCAT - 64)) | (1L << (NOT - 64)) | (1L << (EXISTS - 64)) | (1L << (IRIREF - 64)) | (1L << (PNAME_NS - 64)) | (1L << (PNAME_LN - 64)) | (1L << (VAR1 - 64)) | (1L << (VAR2 - 64)) | (1L << (INTEGER - 64)) | (1L << (DECIMAL - 64)) | (1L << (DOUBLE - 64)) | (1L << (INTEGER_POSITIVE - 64)) | (1L << (DECIMAL_POSITIVE - 64)) | (1L << (DOUBLE_POSITIVE - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (INTEGER_NEGATIVE - 128)) | (1L << (DECIMAL_NEGATIVE - 128)) | (1L << (DOUBLE_NEGATIVE - 128)) | (1L << (STRING_LITERAL1 - 128)) | (1L << (STRING_LITERAL2 - 128)) | (1L << (STRING_LITERAL_LONG1 - 128)) | (1L << (STRING_LITERAL_LONG2 - 128)) | (1L << (OPEN_BRACE - 128)) | (1L << (PLUS_SIGN - 128)) | (1L << (MINUS_SIGN - 128)) | (1L << (ASTERISK - 128)) | (1L << (NEGATION - 128)) | (1L << (DIVIDE - 128)) | (1L << (ID - 128)))) != 0)) {
					{
					setState(1349); expressionList();
					}
				}

				setState(1352); match(CLOSE_BRACE);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 44);
				{
				setState(1353); match(IF);
				setState(1354); match(OPEN_BRACE);
				setState(1355); expression(0);
				setState(1356); match(COMMA);
				setState(1357); expression(0);
				setState(1358); match(COMMA);
				setState(1359); expression(0);
				setState(1360); match(CLOSE_BRACE);
				}
				break;
			case STRLANG:
				enterOuterAlt(_localctx, 45);
				{
				setState(1362); match(STRLANG);
				setState(1363); match(OPEN_BRACE);
				setState(1364); expression(0);
				setState(1365); match(COMMA);
				setState(1366); expression(0);
				setState(1367); match(CLOSE_BRACE);
				}
				break;
			case STRDT:
				enterOuterAlt(_localctx, 46);
				{
				setState(1369); match(STRDT);
				setState(1370); match(OPEN_BRACE);
				setState(1371); expression(0);
				setState(1372); match(COMMA);
				setState(1373); expression(0);
				setState(1374); match(CLOSE_BRACE);
				}
				break;
			case SAMETERM:
				enterOuterAlt(_localctx, 47);
				{
				setState(1376); match(SAMETERM);
				setState(1377); match(OPEN_BRACE);
				setState(1378); expression(0);
				setState(1379); match(COMMA);
				setState(1380); expression(0);
				setState(1381); match(CLOSE_BRACE);
				}
				break;
			case ISIRI:
				enterOuterAlt(_localctx, 48);
				{
				setState(1383); match(ISIRI);
				setState(1384); match(OPEN_BRACE);
				setState(1385); expression(0);
				setState(1386); match(CLOSE_BRACE);
				}
				break;
			case ISURI:
				enterOuterAlt(_localctx, 49);
				{
				setState(1388); match(ISURI);
				setState(1389); match(OPEN_BRACE);
				setState(1390); expression(0);
				setState(1391); match(CLOSE_BRACE);
				}
				break;
			case ISBLANK:
				enterOuterAlt(_localctx, 50);
				{
				setState(1393); match(ISBLANK);
				setState(1394); match(OPEN_BRACE);
				setState(1395); expression(0);
				setState(1396); match(CLOSE_BRACE);
				}
				break;
			case ISLITERAL:
				enterOuterAlt(_localctx, 51);
				{
				setState(1398); match(ISLITERAL);
				setState(1399); match(OPEN_BRACE);
				setState(1400); expression(0);
				setState(1401); match(CLOSE_BRACE);
				}
				break;
			case ISNUMERIC:
				enterOuterAlt(_localctx, 52);
				{
				setState(1403); match(ISNUMERIC);
				setState(1404); match(OPEN_BRACE);
				setState(1405); expression(0);
				setState(1406); match(CLOSE_BRACE);
				}
				break;
			case REGEX:
				enterOuterAlt(_localctx, 53);
				{
				setState(1408); regexExpression();
				}
				break;
			case EXISTS:
				enterOuterAlt(_localctx, 54);
				{
				setState(1409); existsFunction();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 55);
				{
				setState(1410); notExistsFunction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegexExpressionContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode REGEX() { return getToken(SparqlParser.REGEX, 0); }
		public RegexExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regexExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterRegexExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitRegexExpression(this);
		}
	}

	public final RegexExpressionContext regexExpression() throws RecognitionException {
		RegexExpressionContext _localctx = new RegexExpressionContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_regexExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1413); match(REGEX);
			setState(1414); match(OPEN_BRACE);
			setState(1415); expression(0);
			setState(1416); match(COMMA);
			setState(1417); expression(0);
			setState(1420);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1418); match(COMMA);
				setState(1419); expression(0);
				}
			}

			setState(1422); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubStringExpressionContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode SUBSTR() { return getToken(SparqlParser.SUBSTR, 0); }
		public SubStringExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subStringExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterSubStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitSubStringExpression(this);
		}
	}

	public final SubStringExpressionContext subStringExpression() throws RecognitionException {
		SubStringExpressionContext _localctx = new SubStringExpressionContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_subStringExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1424); match(SUBSTR);
			setState(1425); match(OPEN_BRACE);
			setState(1426); expression(0);
			setState(1427); match(COMMA);
			setState(1428); expression(0);
			setState(1431);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1429); match(COMMA);
				setState(1430); expression(0);
				}
			}

			setState(1433); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrReplaceExpressionContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode REPLACE() { return getToken(SparqlParser.REPLACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public StrReplaceExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strReplaceExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterStrReplaceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitStrReplaceExpression(this);
		}
	}

	public final StrReplaceExpressionContext strReplaceExpression() throws RecognitionException {
		StrReplaceExpressionContext _localctx = new StrReplaceExpressionContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_strReplaceExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1435); match(REPLACE);
			setState(1436); match(OPEN_BRACE);
			setState(1437); expression(0);
			setState(1438); match(COMMA);
			setState(1439); expression(0);
			setState(1440); match(COMMA);
			setState(1441); expression(0);
			setState(1444);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1442); match(COMMA);
				setState(1443); expression(0);
				}
			}

			setState(1446); match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExistsFunctionContext extends ParserRuleContext {
		public TerminalNode EXISTS() { return getToken(SparqlParser.EXISTS, 0); }
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public ExistsFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_existsFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterExistsFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitExistsFunction(this);
		}
	}

	public final ExistsFunctionContext existsFunction() throws RecognitionException {
		ExistsFunctionContext _localctx = new ExistsFunctionContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_existsFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1448); match(EXISTS);
			setState(1449); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotExistsFunctionContext extends ParserRuleContext {
		public TerminalNode EXISTS() { return getToken(SparqlParser.EXISTS, 0); }
		public GroupGraphPatternContext groupGraphPattern() {
			return getRuleContext(GroupGraphPatternContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SparqlParser.NOT, 0); }
		public NotExistsFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notExistsFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterNotExistsFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitNotExistsFunction(this);
		}
	}

	public final NotExistsFunctionContext notExistsFunction() throws RecognitionException {
		NotExistsFunctionContext _localctx = new NotExistsFunctionContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_notExistsFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1451); match(NOT);
			setState(1452); match(EXISTS);
			setState(1453); groupGraphPattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregateContext extends ParserRuleContext {
		public TerminalNode COUNT() { return getToken(SparqlParser.COUNT, 0); }
		public TerminalNode ASTERISK() { return getToken(SparqlParser.ASTERISK, 0); }
		public TerminalNode SUM() { return getToken(SparqlParser.SUM, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode DISTINCT() { return getToken(SparqlParser.DISTINCT, 0); }
		public TerminalNode GROUP_CONCAT() { return getToken(SparqlParser.GROUP_CONCAT, 0); }
		public TerminalNode SEPARATOR() { return getToken(SparqlParser.SEPARATOR, 0); }
		public TerminalNode AVG() { return getToken(SparqlParser.AVG, 0); }
		public TerminalNode MIN() { return getToken(SparqlParser.MIN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MAX() { return getToken(SparqlParser.MAX, 0); }
		public TerminalNode SAMPLE() { return getToken(SparqlParser.SAMPLE, 0); }
		public AggregateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterAggregate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitAggregate(this);
		}
	}

	public final AggregateContext aggregate() throws RecognitionException {
		AggregateContext _localctx = new AggregateContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_aggregate);
		int _la;
		try {
			setState(1519);
			switch (_input.LA(1)) {
			case COUNT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1455); match(COUNT);
				setState(1456); match(OPEN_BRACE);
				setState(1458);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1457); match(DISTINCT);
					}
				}

				setState(1462);
				switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
				case 1:
					{
					setState(1460); match(ASTERISK);
					}
					break;
				case 2:
					{
					setState(1461); expression(0);
					}
					break;
				}
				setState(1464); match(CLOSE_BRACE);
				}
				break;
			case SUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(1465); match(SUM);
				setState(1466); match(OPEN_BRACE);
				setState(1468);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1467); match(DISTINCT);
					}
				}

				setState(1470); expression(0);
				setState(1471); match(CLOSE_BRACE);
				}
				break;
			case MIN:
				enterOuterAlt(_localctx, 3);
				{
				setState(1473); match(MIN);
				setState(1474); match(OPEN_BRACE);
				setState(1476);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1475); match(DISTINCT);
					}
				}

				setState(1478); expression(0);
				setState(1479); match(CLOSE_BRACE);
				}
				break;
			case MAX:
				enterOuterAlt(_localctx, 4);
				{
				setState(1481); match(MAX);
				setState(1482); match(OPEN_BRACE);
				setState(1484);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1483); match(DISTINCT);
					}
				}

				setState(1486); expression(0);
				setState(1487); match(CLOSE_BRACE);
				}
				break;
			case AVG:
				enterOuterAlt(_localctx, 5);
				{
				setState(1489); match(AVG);
				setState(1490); match(OPEN_BRACE);
				setState(1492);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1491); match(DISTINCT);
					}
				}

				setState(1494); expression(0);
				setState(1495); match(CLOSE_BRACE);
				}
				break;
			case SAMPLE:
				enterOuterAlt(_localctx, 6);
				{
				setState(1497); match(SAMPLE);
				setState(1498); match(OPEN_BRACE);
				setState(1500);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1499); match(DISTINCT);
					}
				}

				setState(1502); expression(0);
				setState(1503); match(CLOSE_BRACE);
				}
				break;
			case GROUP_CONCAT:
				enterOuterAlt(_localctx, 7);
				{
				setState(1505); match(GROUP_CONCAT);
				setState(1506); match(OPEN_BRACE);
				setState(1508);
				_la = _input.LA(1);
				if (_la==DISTINCT) {
					{
					setState(1507); match(DISTINCT);
					}
				}

				setState(1510); expression(0);
				setState(1515);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(1511); match(SEMICOLON);
					setState(1512); match(SEPARATOR);
					setState(1513); match(EQUAL);
					setState(1514); string();
					}
				}

				setState(1517); match(CLOSE_BRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IriRefOrFunctionContext extends ParserRuleContext {
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public IriRefOrFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iriRefOrFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterIriRefOrFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitIriRefOrFunction(this);
		}
	}

	public final IriRefOrFunctionContext iriRefOrFunction() throws RecognitionException {
		IriRefOrFunctionContext _localctx = new IriRefOrFunctionContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_iriRefOrFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1521); iri();
			setState(1523);
			switch ( getInterpreter().adaptivePredict(_input,149,_ctx) ) {
			case 1:
				{
				setState(1522); argList();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RdfLiteralContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public IriContext iri() {
			return getRuleContext(IriContext.class,0);
		}
		public TerminalNode LANGTAG() { return getToken(SparqlParser.LANGTAG, 0); }
		public RdfLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rdfLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterRdfLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitRdfLiteral(this);
		}
	}

	public final RdfLiteralContext rdfLiteral() throws RecognitionException {
		RdfLiteralContext _localctx = new RdfLiteralContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_rdfLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1525); string();
			setState(1529);
			switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
			case 1:
				{
				setState(1526); match(LANGTAG);
				}
				break;
			case 2:
				{
				{
				setState(1527); match(REFERENCE);
				setState(1528); iri();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericLiteralContext extends ParserRuleContext {
		public NumericLiteralPositiveContext numericLiteralPositive() {
			return getRuleContext(NumericLiteralPositiveContext.class,0);
		}
		public NumericLiteralNegativeContext numericLiteralNegative() {
			return getRuleContext(NumericLiteralNegativeContext.class,0);
		}
		public NumericLiteralUnsignedContext numericLiteralUnsigned() {
			return getRuleContext(NumericLiteralUnsignedContext.class,0);
		}
		public NumericLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitNumericLiteral(this);
		}
	}

	public final NumericLiteralContext numericLiteral() throws RecognitionException {
		NumericLiteralContext _localctx = new NumericLiteralContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_numericLiteral);
		try {
			setState(1534);
			switch (_input.LA(1)) {
			case INTEGER:
			case DECIMAL:
			case DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1531); numericLiteralUnsigned();
				}
				break;
			case INTEGER_POSITIVE:
			case DECIMAL_POSITIVE:
			case DOUBLE_POSITIVE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1532); numericLiteralPositive();
				}
				break;
			case INTEGER_NEGATIVE:
			case DECIMAL_NEGATIVE:
			case DOUBLE_NEGATIVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1533); numericLiteralNegative();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericLiteralUnsignedContext extends ParserRuleContext {
		public TerminalNode DOUBLE() { return getToken(SparqlParser.DOUBLE, 0); }
		public TerminalNode INTEGER() { return getToken(SparqlParser.INTEGER, 0); }
		public TerminalNode DECIMAL() { return getToken(SparqlParser.DECIMAL, 0); }
		public NumericLiteralUnsignedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericLiteralUnsigned; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterNumericLiteralUnsigned(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitNumericLiteralUnsigned(this);
		}
	}

	public final NumericLiteralUnsignedContext numericLiteralUnsigned() throws RecognitionException {
		NumericLiteralUnsignedContext _localctx = new NumericLiteralUnsignedContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_numericLiteralUnsigned);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1536);
			_la = _input.LA(1);
			if ( !(((((_la - 122)) & ~0x3f) == 0 && ((1L << (_la - 122)) & ((1L << (INTEGER - 122)) | (1L << (DECIMAL - 122)) | (1L << (DOUBLE - 122)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericLiteralPositiveContext extends ParserRuleContext {
		public TerminalNode DOUBLE_POSITIVE() { return getToken(SparqlParser.DOUBLE_POSITIVE, 0); }
		public TerminalNode DECIMAL_POSITIVE() { return getToken(SparqlParser.DECIMAL_POSITIVE, 0); }
		public TerminalNode INTEGER_POSITIVE() { return getToken(SparqlParser.INTEGER_POSITIVE, 0); }
		public NumericLiteralPositiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericLiteralPositive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterNumericLiteralPositive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitNumericLiteralPositive(this);
		}
	}

	public final NumericLiteralPositiveContext numericLiteralPositive() throws RecognitionException {
		NumericLiteralPositiveContext _localctx = new NumericLiteralPositiveContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_numericLiteralPositive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1538);
			_la = _input.LA(1);
			if ( !(((((_la - 125)) & ~0x3f) == 0 && ((1L << (_la - 125)) & ((1L << (INTEGER_POSITIVE - 125)) | (1L << (DECIMAL_POSITIVE - 125)) | (1L << (DOUBLE_POSITIVE - 125)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericLiteralNegativeContext extends ParserRuleContext {
		public TerminalNode DOUBLE_NEGATIVE() { return getToken(SparqlParser.DOUBLE_NEGATIVE, 0); }
		public TerminalNode INTEGER_NEGATIVE() { return getToken(SparqlParser.INTEGER_NEGATIVE, 0); }
		public TerminalNode DECIMAL_NEGATIVE() { return getToken(SparqlParser.DECIMAL_NEGATIVE, 0); }
		public NumericLiteralNegativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericLiteralNegative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterNumericLiteralNegative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitNumericLiteralNegative(this);
		}
	}

	public final NumericLiteralNegativeContext numericLiteralNegative() throws RecognitionException {
		NumericLiteralNegativeContext _localctx = new NumericLiteralNegativeContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_numericLiteralNegative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1540);
			_la = _input.LA(1);
			if ( !(((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (INTEGER_NEGATIVE - 128)) | (1L << (DECIMAL_NEGATIVE - 128)) | (1L << (DOUBLE_NEGATIVE - 128)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SparqlParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SparqlParser.FALSE, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitBooleanLiteral(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1542);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL1() { return getToken(SparqlParser.STRING_LITERAL1, 0); }
		public TerminalNode STRING_LITERAL_LONG2() { return getToken(SparqlParser.STRING_LITERAL_LONG2, 0); }
		public TerminalNode STRING_LITERAL_LONG1() { return getToken(SparqlParser.STRING_LITERAL_LONG1, 0); }
		public TerminalNode STRING_LITERAL2() { return getToken(SparqlParser.STRING_LITERAL2, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1544);
			_la = _input.LA(1);
			if ( !(((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (STRING_LITERAL1 - 131)) | (1L << (STRING_LITERAL2 - 131)) | (1L << (STRING_LITERAL_LONG1 - 131)) | (1L << (STRING_LITERAL_LONG2 - 131)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IriContext extends ParserRuleContext {
		public PrefixedNameContext prefixedName() {
			return getRuleContext(PrefixedNameContext.class,0);
		}
		public TerminalNode IRIREF() { return getToken(SparqlParser.IRIREF, 0); }
		public IriContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iri; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterIri(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitIri(this);
		}
	}

	public final IriContext iri() throws RecognitionException {
		IriContext _localctx = new IriContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_iri);
		try {
			setState(1548);
			switch (_input.LA(1)) {
			case IRIREF:
				enterOuterAlt(_localctx, 1);
				{
				setState(1546); match(IRIREF);
				}
				break;
			case PNAME_NS:
			case PNAME_LN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1547); prefixedName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixedNameContext extends ParserRuleContext {
		public TerminalNode PNAME_NS() { return getToken(SparqlParser.PNAME_NS, 0); }
		public TerminalNode PNAME_LN() { return getToken(SparqlParser.PNAME_LN, 0); }
		public PrefixedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPrefixedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPrefixedName(this);
		}
	}

	public final PrefixedNameContext prefixedName() throws RecognitionException {
		PrefixedNameContext _localctx = new PrefixedNameContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_prefixedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1550);
			_la = _input.LA(1);
			if ( !(_la==PNAME_NS || _la==PNAME_LN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlankNodeContext extends ParserRuleContext {
		public AnonContext anon() {
			return getRuleContext(AnonContext.class,0);
		}
		public TerminalNode BLANK_NODE_LABEL() { return getToken(SparqlParser.BLANK_NODE_LABEL, 0); }
		public BlankNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blankNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterBlankNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitBlankNode(this);
		}
	}

	public final BlankNodeContext blankNode() throws RecognitionException {
		BlankNodeContext _localctx = new BlankNodeContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_blankNode);
		try {
			setState(1554);
			switch (_input.LA(1)) {
			case BLANK_NODE_LABEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1552); match(BLANK_NODE_LABEL);
				}
				break;
			case OPEN_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(1553); anon();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnonContext extends ParserRuleContext {
		public AnonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterAnon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitAnon(this);
		}
	}

	public final AnonContext anon() throws RecognitionException {
		AnonContext _localctx = new AnonContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_anon);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1556); match(OPEN_SQUARE_BRACKET);
			setState(1557); match(CLOSE_SQUARE_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 113: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 7);
		case 1: return precpred(_ctx, 6);
		case 2: return precpred(_ctx, 3);
		case 3: return precpred(_ctx, 5);
		case 4: return precpred(_ctx, 4);
		case 5: return precpred(_ctx, 2);
		case 6: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00ac\u061a\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\3\2\3\2\3\2\3\2\3\2\5\2\u0118\n\2\3\2\3\2\3\2\3\2\5\2\u011e\n\2\3\2\5"+
		"\2\u0121\n\2\3\3\3\3\7\3\u0125\n\3\f\3\16\3\u0128\13\3\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\7\6\u0133\n\6\f\6\16\6\u0136\13\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\5\b\u0142\n\b\3\b\6\b\u0145\n\b\r\b\16\b\u0146"+
		"\3\b\5\b\u014a\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0153\n\t\3\n\3\n\3"+
		"\n\7\n\u0158\n\n\f\n\16\n\u015b\13\n\3\n\3\n\3\n\3\n\7\n\u0161\n\n\f\n"+
		"\16\n\u0164\13\n\3\n\3\n\3\n\5\n\u0169\n\n\3\n\3\n\5\n\u016d\n\n\3\13"+
		"\3\13\6\13\u0171\n\13\r\13\16\13\u0172\3\13\5\13\u0176\n\13\3\13\7\13"+
		"\u0179\n\13\f\13\16\13\u017c\13\13\3\13\5\13\u017f\n\13\3\13\3\13\3\f"+
		"\3\f\7\f\u0185\n\f\f\f\16\f\u0188\13\f\3\f\3\f\3\f\3\r\3\r\5\r\u018f\n"+
		"\r\3\r\3\r\3\16\5\16\u0194\n\16\3\16\3\16\3\17\5\17\u0199\n\17\3\17\5"+
		"\17\u019c\n\17\3\17\5\17\u019f\n\17\3\17\5\17\u01a2\n\17\3\20\3\20\3\20"+
		"\6\20\u01a7\n\20\r\20\16\20\u01a8\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u01b1"+
		"\n\21\3\21\3\21\3\21\5\21\u01b6\n\21\3\22\3\22\6\22\u01ba\n\22\r\22\16"+
		"\22\u01bb\3\23\3\23\3\24\3\24\3\24\6\24\u01c3\n\24\r\24\16\24\u01c4\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u01ce\n\25\3\26\3\26\5\26\u01d2"+
		"\n\26\3\26\3\26\5\26\u01d6\n\26\5\26\u01d8\n\26\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\31\3\31\5\31\u01e2\n\31\3\32\3\32\3\32\3\32\3\32\3\32\7\32"+
		"\u01ea\n\32\f\32\16\32\u01ed\13\32\3\32\3\32\5\32\u01f1\n\32\5\32\u01f3"+
		"\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0200"+
		"\n\33\3\34\3\34\5\34\u0204\n\34\3\34\3\34\3\34\5\34\u0209\n\34\3\35\3"+
		"\35\5\35\u020d\n\35\3\35\3\35\3\36\3\36\5\36\u0213\n\36\3\36\3\36\3\37"+
		"\3\37\5\37\u0219\n\37\3\37\3\37\3 \3 \5 \u021f\n \3 \3 \3 \3 \3!\3!\5"+
		"!\u0227\n!\3!\3!\3!\3!\3\"\3\"\5\"\u022f\n\"\3\"\3\"\3\"\3\"\3#\3#\3#"+
		"\3#\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\5&\u0243\n&\3&\3&\5&\u0247\n&\3&\5&"+
		"\u024a\n&\3&\7&\u024d\n&\f&\16&\u0250\13&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3"+
		"(\3)\3)\5)\u025d\n)\3)\3)\3*\3*\5*\u0263\n*\3*\5*\u0266\n*\3+\3+\3+\3"+
		",\3,\3,\3,\5,\u026f\n,\3-\3-\3-\3-\3.\3.\3.\3.\3/\5/\u027a\n/\3/\7/\u027d"+
		"\n/\f/\16/\u0280\13/\3\60\3\60\5\60\u0284\n\60\3\60\5\60\u0287\n\60\3"+
		"\61\3\61\3\61\3\61\5\61\u028d\n\61\3\61\3\61\3\62\3\62\3\62\5\62\u0294"+
		"\n\62\7\62\u0296\n\62\f\62\16\62\u0299\13\62\3\63\3\63\3\63\5\63\u029e"+
		"\n\63\3\63\3\63\3\64\5\64\u02a3\n\64\3\64\7\64\u02a6\n\64\f\64\16\64\u02a9"+
		"\13\64\3\65\3\65\5\65\u02ad\n\65\3\65\5\65\u02b0\n\65\3\66\3\66\3\66\5"+
		"\66\u02b5\n\66\7\66\u02b7\n\66\f\66\16\66\u02ba\13\66\3\67\3\67\3\67\3"+
		"\67\3\67\3\67\3\67\3\67\5\67\u02c4\n\67\38\38\38\39\39\39\39\3:\3:\5:"+
		"\u02cf\n:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3;\3<\3<\3<\3=\3=\5=\u02e0\n=\3>"+
		"\3>\3>\7>\u02e5\n>\f>\16>\u02e8\13>\3>\3>\3?\3?\7?\u02ee\n?\f?\16?\u02f1"+
		"\13?\3?\3?\3?\7?\u02f6\n?\f?\16?\u02f9\13?\3?\3?\3@\3@\7@\u02ff\n@\f@"+
		"\16@\u0302\13@\3@\3@\3A\3A\3A\3A\3A\5A\u030b\nA\3B\3B\3B\3C\3C\3C\7C\u0313"+
		"\nC\fC\16C\u0316\13C\3D\3D\3D\3E\5E\u031c\nE\3E\3E\5E\u0320\nE\3E\3E\3"+
		"E\3E\3E\3E\5E\u0328\nE\3F\3F\3F\3F\7F\u032e\nF\fF\16F\u0331\13F\3G\3G"+
		"\3G\3G\3G\3H\3H\3H\7H\u033b\nH\fH\16H\u033e\13H\5H\u0340\nH\3I\3I\3I\3"+
		"J\3J\5J\u0347\nJ\3J\3J\5J\u034b\nJ\3J\3J\3K\3K\3K\7K\u0352\nK\fK\16K\u0355"+
		"\13K\3L\3L\5L\u0359\nL\3L\3L\3M\3M\3M\5M\u0360\nM\7M\u0362\nM\fM\16M\u0365"+
		"\13M\3N\3N\3N\3N\3N\3N\5N\u036d\nN\3O\5O\u0370\nO\3P\3P\3P\3P\3P\3P\5"+
		"P\u0378\nP\7P\u037a\nP\fP\16P\u037d\13P\3Q\3Q\5Q\u0381\nQ\3R\3R\3R\7R"+
		"\u0386\nR\fR\16R\u0389\13R\3S\3S\3T\3T\3T\3T\3T\3T\5T\u0393\nT\3U\5U\u0396"+
		"\nU\3V\3V\5V\u039a\nV\3V\3V\3V\5V\u039f\nV\7V\u03a1\nV\fV\16V\u03a4\13"+
		"V\3W\3W\5W\u03a8\nW\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3Z\7Z\u03b3\nZ\fZ\16Z\u03b6"+
		"\13Z\3[\3[\3\\\3\\\3]\3]\3]\7]\u03bf\n]\f]\16]\u03c2\13]\3^\3^\3^\7^\u03c7"+
		"\n^\f^\16^\u03ca\13^\3_\3_\5_\u03ce\n_\3`\5`\u03d1\n`\3`\3`\3a\3a\3b\3"+
		"b\3b\3b\3b\3b\3b\3b\5b\u03df\nb\3c\3c\3c\3c\3c\7c\u03e6\nc\fc\16c\u03e9"+
		"\13c\5c\u03eb\nc\3c\5c\u03ee\nc\3d\5d\u03f1\nd\3d\3d\5d\u03f5\nd\3e\3"+
		"e\3f\3f\5f\u03fb\nf\3g\3g\3g\3g\3h\3h\5h\u0403\nh\3i\3i\3i\3i\3j\3j\6"+
		"j\u040b\nj\rj\16j\u040c\3j\3j\3k\3k\6k\u0413\nk\rk\16k\u0414\3k\3k\3l"+
		"\3l\5l\u041b\nl\3m\3m\5m\u041f\nm\3n\3n\5n\u0423\nn\3o\3o\5o\u0427\no"+
		"\3p\3p\3q\3q\3q\3q\3q\3q\5q\u0431\nq\3r\3r\3r\3s\3s\3s\3s\3s\3s\3s\3s"+
		"\5s\u043e\ns\3s\3s\3s\3s\3s\3s\3s\3s\3s\3s\3s\3s\3s\5s\u044d\ns\3s\3s"+
		"\3s\5s\u0452\ns\3s\3s\3s\3s\3s\3s\3s\7s\u045b\ns\fs\16s\u045e\13s\3t\3"+
		"t\5t\u0462\nt\3t\3t\5t\u0466\nt\3u\5u\u0469\nu\3u\3u\3v\3v\3v\3v\3v\3"+
		"v\3v\3v\3v\3v\3v\5v\u0478\nv\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3"+
		"w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3"+
		"w\3w\3w\3w\3w\5w\u04a3\nw\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3"+
		"w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\5w\u04c0\nw\3w\3w\3w\3w\3w\3w\3"+
		"w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3"+
		"w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3"+
		"w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3"+
		"w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3"+
		"w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3"+
		"w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\5w\u0549\nw\3w\3w\3w\3w\3w\3"+
		"w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3"+
		"w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\3"+
		"w\3w\3w\3w\3w\3w\3w\3w\5w\u0586\nw\3x\3x\3x\3x\3x\3x\3x\5x\u058f\nx\3"+
		"x\3x\3y\3y\3y\3y\3y\3y\3y\5y\u059a\ny\3y\3y\3z\3z\3z\3z\3z\3z\3z\3z\3"+
		"z\5z\u05a7\nz\3z\3z\3{\3{\3{\3|\3|\3|\3|\3}\3}\3}\5}\u05b5\n}\3}\3}\5"+
		"}\u05b9\n}\3}\3}\3}\3}\5}\u05bf\n}\3}\3}\3}\3}\3}\3}\5}\u05c7\n}\3}\3"+
		"}\3}\3}\3}\3}\5}\u05cf\n}\3}\3}\3}\3}\3}\3}\5}\u05d7\n}\3}\3}\3}\3}\3"+
		"}\3}\5}\u05df\n}\3}\3}\3}\3}\3}\3}\5}\u05e7\n}\3}\3}\3}\3}\3}\5}\u05ee"+
		"\n}\3}\3}\5}\u05f2\n}\3~\3~\5~\u05f6\n~\3\177\3\177\3\177\3\177\5\177"+
		"\u05fc\n\177\3\u0080\3\u0080\3\u0080\5\u0080\u0601\n\u0080\3\u0081\3\u0081"+
		"\3\u0082\3\u0082\3\u0083\3\u0083\3\u0084\3\u0084\3\u0085\3\u0085\3\u0086"+
		"\3\u0086\5\u0086\u060f\n\u0086\3\u0087\3\u0087\3\u0088\3\u0088\5\u0088"+
		"\u0615\n\u0088\3\u0089\3\u0089\3\u0089\3\u0089\2\3\u00e4\u008a\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX"+
		"Z\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090"+
		"\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8"+
		"\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0"+
		"\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8"+
		"\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0"+
		"\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108"+
		"\u010a\u010c\u010e\u0110\2\20\3\2\7\b\3\2\21\22\4\2\u0099\u0099\u009b"+
		"\u009c\3\2yz\4\2\u009b\u009b\u009f\u009f\3\2\u0099\u009a\4\2\u008b\u008d"+
		"\u00a0\u00a2\4\2\u0099\u009a\u009e\u009e\3\2|~\3\2\177\u0081\3\2\u0082"+
		"\u0084\3\2\'(\3\2\u0085\u0088\3\2vw\u0696\2\u0120\3\2\2\2\4\u0126\3\2"+
		"\2\2\6\u0129\3\2\2\2\b\u012c\3\2\2\2\n\u0130\3\2\2\2\f\u013a\3\2\2\2\16"+
		"\u013f\3\2\2\2\20\u0152\3\2\2\2\22\u0154\3\2\2\2\24\u016e\3\2\2\2\26\u0182"+
		"\3\2\2\2\30\u018c\3\2\2\2\32\u0193\3\2\2\2\34\u0198\3\2\2\2\36\u01a3\3"+
		"\2\2\2 \u01b5\3\2\2\2\"\u01b7\3\2\2\2$\u01bd\3\2\2\2&\u01bf\3\2\2\2(\u01cd"+
		"\3\2\2\2*\u01d7\3\2\2\2,\u01d9\3\2\2\2.\u01dc\3\2\2\2\60\u01e1\3\2\2\2"+
		"\62\u01e3\3\2\2\2\64\u01ff\3\2\2\2\66\u0201\3\2\2\28\u020a\3\2\2\2:\u0210"+
		"\3\2\2\2<\u0216\3\2\2\2>\u021c\3\2\2\2@\u0224\3\2\2\2B\u022c\3\2\2\2D"+
		"\u0234\3\2\2\2F\u0238\3\2\2\2H\u023c\3\2\2\2J\u0242\3\2\2\2L\u0254\3\2"+
		"\2\2N\u0257\3\2\2\2P\u025a\3\2\2\2R\u0265\3\2\2\2T\u0267\3\2\2\2V\u026e"+
		"\3\2\2\2X\u0270\3\2\2\2Z\u0274\3\2\2\2\\\u0279\3\2\2\2^\u0281\3\2\2\2"+
		"`\u0288\3\2\2\2b\u0290\3\2\2\2d\u029a\3\2\2\2f\u02a2\3\2\2\2h\u02aa\3"+
		"\2\2\2j\u02b1\3\2\2\2l\u02c3\3\2\2\2n\u02c5\3\2\2\2p\u02c8\3\2\2\2r\u02cc"+
		"\3\2\2\2t\u02d3\3\2\2\2v\u02da\3\2\2\2x\u02df\3\2\2\2z\u02e1\3\2\2\2|"+
		"\u02eb\3\2\2\2~\u02fc\3\2\2\2\u0080\u030a\3\2\2\2\u0082\u030c\3\2\2\2"+
		"\u0084\u030f\3\2\2\2\u0086\u0317\3\2\2\2\u0088\u0327\3\2\2\2\u008a\u0329"+
		"\3\2\2\2\u008c\u0332\3\2\2\2\u008e\u033f\3\2\2\2\u0090\u0341\3\2\2\2\u0092"+
		"\u0344\3\2\2\2\u0094\u034e\3\2\2\2\u0096\u0356\3\2\2\2\u0098\u035c\3\2"+
		"\2\2\u009a\u036c\3\2\2\2\u009c\u036f\3\2\2\2\u009e\u0371\3\2\2\2\u00a0"+
		"\u0380\3\2\2\2\u00a2\u0382\3\2\2\2\u00a4\u038a\3\2\2\2\u00a6\u0392\3\2"+
		"\2\2\u00a8\u0395\3\2\2\2\u00aa\u0399\3\2\2\2\u00ac\u03a7\3\2\2\2\u00ae"+
		"\u03ab\3\2\2\2\u00b0\u03ad\3\2\2\2\u00b2\u03af\3\2\2\2\u00b4\u03b7\3\2"+
		"\2\2\u00b6\u03b9\3\2\2\2\u00b8\u03bb\3\2\2\2\u00ba\u03c3\3\2\2\2\u00bc"+
		"\u03cb\3\2\2\2\u00be\u03d0\3\2\2\2\u00c0\u03d4\3\2\2\2\u00c2\u03de\3\2"+
		"\2\2\u00c4\u03ed\3\2\2\2\u00c6\u03f0\3\2\2\2\u00c8\u03f6\3\2\2\2\u00ca"+
		"\u03fa\3\2\2\2\u00cc\u03fc\3\2\2\2\u00ce\u0402\3\2\2\2\u00d0\u0404\3\2"+
		"\2\2\u00d2\u0408\3\2\2\2\u00d4\u0410\3\2\2\2\u00d6\u041a\3\2\2\2\u00d8"+
		"\u041e\3\2\2\2\u00da\u0422\3\2\2\2\u00dc\u0426\3\2\2\2\u00de\u0428\3\2"+
		"\2\2\u00e0\u0430\3\2\2\2\u00e2\u0432\3\2\2\2\u00e4\u043d\3\2\2\2\u00e6"+
		"\u0461\3\2\2\2\u00e8\u0468\3\2\2\2\u00ea\u0477\3\2\2\2\u00ec\u0585\3\2"+
		"\2\2\u00ee\u0587\3\2\2\2\u00f0\u0592\3\2\2\2\u00f2\u059d\3\2\2\2\u00f4"+
		"\u05aa\3\2\2\2\u00f6\u05ad\3\2\2\2\u00f8\u05f1\3\2\2\2\u00fa\u05f3\3\2"+
		"\2\2\u00fc\u05f7\3\2\2\2\u00fe\u0600\3\2\2\2\u0100\u0602\3\2\2\2\u0102"+
		"\u0604\3\2\2\2\u0104\u0606\3\2\2\2\u0106\u0608\3\2\2\2\u0108\u060a\3\2"+
		"\2\2\u010a\u060e\3\2\2\2\u010c\u0610\3\2\2\2\u010e\u0614\3\2\2\2\u0110"+
		"\u0616\3\2\2\2\u0112\u0117\5\4\3\2\u0113\u0118\5\n\6\2\u0114\u0118\5\22"+
		"\n\2\u0115\u0118\5\24\13\2\u0116\u0118\5\26\f\2\u0117\u0113\3\2\2\2\u0117"+
		"\u0114\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0116\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\u011a\5\60\31\2\u011a\u011b\7\2\2\3\u011b"+
		"\u0121\3\2\2\2\u011c\u011e\5\62\32\2\u011d\u011c\3\2\2\2\u011d\u011e\3"+
		"\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121\7\2\2\3\u0120\u0112\3\2\2\2\u0120"+
		"\u011d\3\2\2\2\u0121\3\3\2\2\2\u0122\u0125\5\6\4\2\u0123\u0125\5\b\5\2"+
		"\u0124\u0122\3\2\2\2\u0124\u0123\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124"+
		"\3\2\2\2\u0126\u0127\3\2\2\2\u0127\5\3\2\2\2\u0128\u0126\3\2\2\2\u0129"+
		"\u012a\7\4\2\2\u012a\u012b\7u\2\2\u012b\7\3\2\2\2\u012c\u012d\7\5\2\2"+
		"\u012d\u012e\7v\2\2\u012e\u012f\7u\2\2\u012f\t\3\2\2\2\u0130\u0134\5\16"+
		"\b\2\u0131\u0133\5\30\r\2\u0132\u0131\3\2\2\2\u0133\u0136\3\2\2\2\u0134"+
		"\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0137\3\2\2\2\u0136\u0134\3\2"+
		"\2\2\u0137\u0138\5\32\16\2\u0138\u0139\5\34\17\2\u0139\13\3\2\2\2\u013a"+
		"\u013b\5\16\b\2\u013b\u013c\5\32\16\2\u013c\u013d\5\34\17\2\u013d\u013e"+
		"\5\60\31\2\u013e\r\3\2\2\2\u013f\u0141\7\6\2\2\u0140\u0142\t\2\2\2\u0141"+
		"\u0140\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0149\3\2\2\2\u0143\u0145\5\20"+
		"\t\2\u0144\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0144\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u014a\7\u009b\2\2\u0149\u0144"+
		"\3\2\2\2\u0149\u0148\3\2\2\2\u014a\17\3\2\2\2\u014b\u0153\5\u00dep\2\u014c"+
		"\u014d\7\u0091\2\2\u014d\u014e\5\u00e4s\2\u014e\u014f\7:\2\2\u014f\u0150"+
		"\5\u00dep\2\u0150\u0151\7\u0092\2\2\u0151\u0153\3\2\2\2\u0152\u014b\3"+
		"\2\2\2\u0152\u014c\3\2\2\2\u0153\21\3\2\2\2\u0154\u016c\7\t\2\2\u0155"+
		"\u0159\5\u0096L\2\u0156\u0158\5\30\r\2\u0157\u0156\3\2\2\2\u0158\u015b"+
		"\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015c\3\2\2\2\u015b"+
		"\u0159\3\2\2\2\u015c\u015d\5\32\16\2\u015d\u015e\5\34\17\2\u015e\u016d"+
		"\3\2\2\2\u015f\u0161\5\30\r\2\u0160\u015f\3\2\2\2\u0161\u0164\3\2\2\2"+
		"\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0165\3\2\2\2\u0164\u0162"+
		"\3\2\2\2\u0165\u0166\7\16\2\2\u0166\u0168\7\u0093\2\2\u0167\u0169\5b\62"+
		"\2\u0168\u0167\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b"+
		"\7\u0094\2\2\u016b\u016d\5\34\17\2\u016c\u0155\3\2\2\2\u016c\u0162\3\2"+
		"\2\2\u016d\23\3\2\2\2\u016e\u0175\7\n\2\2\u016f\u0171\5\u00dco\2\u0170"+
		"\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2"+
		"\2\2\u0173\u0176\3\2\2\2\u0174\u0176\7\u009b\2\2\u0175\u0170\3\2\2\2\u0175"+
		"\u0174\3\2\2\2\u0176\u017a\3\2\2\2\u0177\u0179\5\30\r\2\u0178\u0177\3"+
		"\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b"+
		"\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017f\5\32\16\2\u017e\u017d\3"+
		"\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\5\34\17\2\u0181"+
		"\25\3\2\2\2\u0182\u0186\7\13\2\2\u0183\u0185\5\30\r\2\u0184\u0183\3\2"+
		"\2\2\u0185\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187"+
		"\u0189\3\2\2\2\u0188\u0186\3\2\2\2\u0189\u018a\5\32\16\2\u018a\u018b\5"+
		"\34\17\2\u018b\27\3\2\2\2\u018c\u018e\7\f\2\2\u018d\u018f\7\r\2\2\u018e"+
		"\u018d\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\5\u010a"+
		"\u0086\2\u0191\31\3\2\2\2\u0192\u0194\7\16\2\2\u0193\u0192\3\2\2\2\u0193"+
		"\u0194\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0196\5d\63\2\u0196\33\3\2\2"+
		"\2\u0197\u0199\5\36\20\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199"+
		"\u019b\3\2\2\2\u019a\u019c\5\"\22\2\u019b\u019a\3\2\2\2\u019b\u019c\3"+
		"\2\2\2\u019c\u019e\3\2\2\2\u019d\u019f\5&\24\2\u019e\u019d\3\2\2\2\u019e"+
		"\u019f\3\2\2\2\u019f\u01a1\3\2\2\2\u01a0\u01a2\5*\26\2\u01a1\u01a0\3\2"+
		"\2\2\u01a1\u01a2\3\2\2\2\u01a2\35\3\2\2\2\u01a3\u01a4\7;\2\2\u01a4\u01a6"+
		"\7\20\2\2\u01a5\u01a7\5 \21\2\u01a6\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2"+
		"\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\37\3\2\2\2\u01aa\u01b6"+
		"\5\u00ecw\2\u01ab\u01b6\5\u0090I\2\u01ac\u01ad\7\u0091\2\2\u01ad\u01b0"+
		"\5\u00e4s\2\u01ae\u01af\7:\2\2\u01af\u01b1\5\u00dep\2\u01b0\u01ae\3\2"+
		"\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\7\u0092\2\2\u01b3"+
		"\u01b6\3\2\2\2\u01b4\u01b6\5\u00dep\2\u01b5\u01aa\3\2\2\2\u01b5\u01ab"+
		"\3\2\2\2\u01b5\u01ac\3\2\2\2\u01b5\u01b4\3\2\2\2\u01b6!\3\2\2\2\u01b7"+
		"\u01b9\7<\2\2\u01b8\u01ba\5$\23\2\u01b9\u01b8\3\2\2\2\u01ba\u01bb\3\2"+
		"\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc#\3\2\2\2\u01bd\u01be"+
		"\5\u0088E\2\u01be%\3\2\2\2\u01bf\u01c0\7\17\2\2\u01c0\u01c2\7\20\2\2\u01c1"+
		"\u01c3\5(\25\2\u01c2\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c2\3\2"+
		"\2\2\u01c4\u01c5\3\2\2\2\u01c5\'\3\2\2\2\u01c6\u01c7\t\3\2\2\u01c7\u01c8"+
		"\7\u0091\2\2\u01c8\u01c9\5\u00e4s\2\u01c9\u01ca\7\u0092\2\2\u01ca\u01ce"+
		"\3\2\2\2\u01cb\u01ce\5\u0088E\2\u01cc\u01ce\5\u00dep\2\u01cd\u01c6\3\2"+
		"\2\2\u01cd\u01cb\3\2\2\2\u01cd\u01cc\3\2\2\2\u01ce)\3\2\2\2\u01cf\u01d1"+
		"\5,\27\2\u01d0\u01d2\5.\30\2\u01d1\u01d0\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2"+
		"\u01d8\3\2\2\2\u01d3\u01d5\5.\30\2\u01d4\u01d6\5,\27\2\u01d5\u01d4\3\2"+
		"\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d8\3\2\2\2\u01d7\u01cf\3\2\2\2\u01d7"+
		"\u01d3\3\2\2\2\u01d8+\3\2\2\2\u01d9\u01da\7\23\2\2\u01da\u01db\7|\2\2"+
		"\u01db-\3\2\2\2\u01dc\u01dd\7\24\2\2\u01dd\u01de\7|\2\2\u01de/\3\2\2\2"+
		"\u01df\u01e0\7\25\2\2\u01e0\u01e2\5x=\2\u01e1\u01df\3\2\2\2\u01e1\u01e2"+
		"\3\2\2\2\u01e2\61\3\2\2\2\u01e3\u01f2\5\4\3\2\u01e4\u01eb\5\64\33\2\u01e5"+
		"\u01e6\7\u0097\2\2\u01e6\u01e7\5\4\3\2\u01e7\u01e8\5\64\33\2\u01e8\u01ea"+
		"\3\2\2\2\u01e9\u01e5\3\2\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb"+
		"\u01ec\3\2\2\2\u01ec\u01f0\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01ef\7\u0097"+
		"\2\2\u01ef\u01f1\5\4\3\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1"+
		"\u01f3\3\2\2\2\u01f2\u01e4\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\63\3\2\2"+
		"\2\u01f4\u0200\5\66\34\2\u01f5\u0200\58\35\2\u01f6\u0200\5:\36\2\u01f7"+
		"\u0200\5> \2\u01f8\u0200\5@!\2\u01f9\u0200\5B\"\2\u01fa\u0200\5<\37\2"+
		"\u01fb\u0200\5D#\2\u01fc\u0200\5F$\2\u01fd\u0200\5H%\2\u01fe\u0200\5J"+
		"&\2\u01ff\u01f4\3\2\2\2\u01ff\u01f5\3\2\2\2\u01ff\u01f6\3\2\2\2\u01ff"+
		"\u01f7\3\2\2\2\u01ff\u01f8\3\2\2\2\u01ff\u01f9\3\2\2\2\u01ff\u01fa\3\2"+
		"\2\2\u01ff\u01fb\3\2\2\2\u01ff\u01fc\3\2\2\2\u01ff\u01fd\3\2\2\2\u01ff"+
		"\u01fe\3\2\2\2\u0200\65\3\2\2\2\u0201\u0203\7)\2\2\u0202\u0204\7\63\2"+
		"\2\u0203\u0202\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0208"+
		"\5\u010a\u0086\2\u0206\u0207\78\2\2\u0207\u0209\5T+\2\u0208\u0206\3\2"+
		"\2\2\u0208\u0209\3\2\2\2\u0209\67\3\2\2\2\u020a\u020c\7*\2\2\u020b\u020d"+
		"\7\63\2\2\u020c\u020b\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020e\3\2\2\2"+
		"\u020e\u020f\5V,\2\u020f9\3\2\2\2\u0210\u0212\7+\2\2\u0211\u0213\7\63"+
		"\2\2\u0212\u0211\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\3\2\2\2\u0214"+
		"\u0215\5V,\2\u0215;\3\2\2\2\u0216\u0218\7/\2\2\u0217\u0219\7\63\2\2\u0218"+
		"\u0217\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021b\5T"+
		"+\2\u021b=\3\2\2\2\u021c\u021e\7,\2\2\u021d\u021f\7\63\2\2\u021e\u021d"+
		"\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0221\5R*\2\u0221"+
		"\u0222\79\2\2\u0222\u0223\5R*\2\u0223?\3\2\2\2\u0224\u0226\7-\2\2\u0225"+
		"\u0227\7\63\2\2\u0226\u0225\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0228\3"+
		"\2\2\2\u0228\u0229\5R*\2\u0229\u022a\79\2\2\u022a\u022b\5R*\2\u022bA\3"+
		"\2\2\2\u022c\u022e\7.\2\2\u022d\u022f\7\63\2\2\u022e\u022d\3\2\2\2\u022e"+
		"\u022f\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0231\5R*\2\u0231\u0232\79\2"+
		"\2\u0232\u0233\5R*\2\u0233C\3\2\2\2\u0234\u0235\7\61\2\2\u0235\u0236\7"+
		"\66\2\2\u0236\u0237\5Z.\2\u0237E\3\2\2\2\u0238\u0239\7\60\2\2\u0239\u023a"+
		"\7\66\2\2\u023a\u023b\5Z.\2\u023bG\3\2\2\2\u023c\u023d\7\60\2\2\u023d"+
		"\u023e\7\16\2\2\u023e\u023f\5X-\2\u023fI\3\2\2\2\u0240\u0241\7\67\2\2"+
		"\u0241\u0243\5\u010a\u0086\2\u0242\u0240\3\2\2\2\u0242\u0243\3\2\2\2\u0243"+
		"\u0249\3\2\2\2\u0244\u0246\5L\'\2\u0245\u0247\5N(\2\u0246\u0245\3\2\2"+
		"\2\u0246\u0247\3\2\2\2\u0247\u024a\3\2\2\2\u0248\u024a\5N(\2\u0249\u0244"+
		"\3\2\2\2\u0249\u0248\3\2\2\2\u024a\u024e\3\2\2\2\u024b\u024d\5P)\2\u024c"+
		"\u024b\3\2\2\2\u024d\u0250\3\2\2\2\u024e\u024c\3\2\2\2\u024e\u024f\3\2"+
		"\2\2\u024f\u0251\3\2\2\2\u0250\u024e\3\2\2\2\u0251\u0252\7\16\2\2\u0252"+
		"\u0253\5d\63\2\u0253K\3\2\2\2\u0254\u0255\7\60\2\2\u0255\u0256\5X-\2\u0256"+
		"M\3\2\2\2\u0257\u0258\7\61\2\2\u0258\u0259\5X-\2\u0259O\3\2\2\2\u025a"+
		"\u025c\7\62\2\2\u025b\u025d\7\r\2\2\u025c\u025b\3\2\2\2\u025c\u025d\3"+
		"\2\2\2\u025d\u025e\3\2\2\2\u025e\u025f\5\u010a\u0086\2\u025fQ\3\2\2\2"+
		"\u0260\u0266\7\64\2\2\u0261\u0263\7\27\2\2\u0262\u0261\3\2\2\2\u0262\u0263"+
		"\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u0266\5\u010a\u0086\2\u0265\u0260\3"+
		"\2\2\2\u0265\u0262\3\2\2\2\u0266S\3\2\2\2\u0267\u0268\7\27\2\2\u0268\u0269"+
		"\5\u010a\u0086\2\u0269U\3\2\2\2\u026a\u026f\5T+\2\u026b\u026f\7\64\2\2"+
		"\u026c\u026f\7\r\2\2\u026d\u026f\7\65\2\2\u026e\u026a\3\2\2\2\u026e\u026b"+
		"\3\2\2\2\u026e\u026c\3\2\2\2\u026e\u026d\3\2\2\2\u026fW\3\2\2\2\u0270"+
		"\u0271\7\u0093\2\2\u0271\u0272\5\\/\2\u0272\u0273\7\u0094\2\2\u0273Y\3"+
		"\2\2\2\u0274\u0275\7\u0093\2\2\u0275\u0276\5\\/\2\u0276\u0277\7\u0094"+
		"\2\2\u0277[\3\2\2\2\u0278\u027a\5b\62\2\u0279\u0278\3\2\2\2\u0279\u027a"+
		"\3\2\2\2\u027a\u027e\3\2\2\2\u027b\u027d\5^\60\2\u027c\u027b\3\2\2\2\u027d"+
		"\u0280\3\2\2\2\u027e\u027c\3\2\2\2\u027e\u027f\3\2\2\2\u027f]\3\2\2\2"+
		"\u0280\u027e\3\2\2\2\u0281\u0283\5`\61\2\u0282\u0284\7\u0098\2\2\u0283"+
		"\u0282\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0286\3\2\2\2\u0285\u0287\5b"+
		"\62\2\u0286\u0285\3\2\2\2\u0286\u0287\3\2\2\2\u0287_\3\2\2\2\u0288\u0289"+
		"\7\27\2\2\u0289\u028a\5\u00dco\2\u028a\u028c\7\u0093\2\2\u028b\u028d\5"+
		"b\62\2\u028c\u028b\3\2\2\2\u028c\u028d\3\2\2\2\u028d\u028e\3\2\2\2\u028e"+
		"\u028f\7\u0094\2\2\u028fa\3\2\2\2\u0290\u0297\5\u009aN\2\u0291\u0293\7"+
		"\u0098\2\2\u0292\u0294\5\u009aN\2\u0293\u0292\3\2\2\2\u0293\u0294\3\2"+
		"\2\2\u0294\u0296\3\2\2\2\u0295\u0291\3\2\2\2\u0296\u0299\3\2\2\2\u0297"+
		"\u0295\3\2\2\2\u0297\u0298\3\2\2\2\u0298c\3\2\2\2\u0299\u0297\3\2\2\2"+
		"\u029a\u029d\7\u0093\2\2\u029b\u029e\5\f\7\2\u029c\u029e\5f\64\2\u029d"+
		"\u029b\3\2\2\2\u029d\u029c\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u02a0\7\u0094"+
		"\2\2\u02a0e\3\2\2\2\u02a1\u02a3\5j\66\2\u02a2\u02a1\3\2\2\2\u02a2\u02a3"+
		"\3\2\2\2\u02a3\u02a7\3\2\2\2\u02a4\u02a6\5h\65\2\u02a5\u02a4\3\2\2\2\u02a6"+
		"\u02a9\3\2\2\2\u02a7\u02a5\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8g\3\2\2\2"+
		"\u02a9\u02a7\3\2\2\2\u02aa\u02ac\5l\67\2\u02ab\u02ad\7\u0098\2\2\u02ac"+
		"\u02ab\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02af\3\2\2\2\u02ae\u02b0\5j"+
		"\66\2\u02af\u02ae\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0i\3\2\2\2\u02b1\u02b8"+
		"\5\u00a6T\2\u02b2\u02b4\7\u0098\2\2\u02b3\u02b5\5\u00a6T\2\u02b4\u02b3"+
		"\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b7\3\2\2\2\u02b6\u02b2\3\2\2\2\u02b7"+
		"\u02ba\3\2\2\2\u02b8\u02b6\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9k\3\2\2\2"+
		"\u02ba\u02b8\3\2\2\2\u02bb\u02c4\5\u0084C\2\u02bc\u02c4\5n8\2\u02bd\u02c4"+
		"\5\u0082B\2\u02be\u02c4\5p9\2\u02bf\u02c4\5r:\2\u02c0\u02c4\5\u0086D\2"+
		"\u02c1\u02c4\5t;\2\u02c2\u02c4\5v<\2\u02c3\u02bb\3\2\2\2\u02c3\u02bc\3"+
		"\2\2\2\u02c3\u02bd\3\2\2\2\u02c3\u02be\3\2\2\2\u02c3\u02bf\3\2\2\2\u02c3"+
		"\u02c0\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c3\u02c2\3\2\2\2\u02c4m\3\2\2\2"+
		"\u02c5\u02c6\7\26\2\2\u02c6\u02c7\5d\63\2\u02c7o\3\2\2\2\u02c8\u02c9\7"+
		"\27\2\2\u02c9\u02ca\5\u00dco\2\u02ca\u02cb\5d\63\2\u02cbq\3\2\2\2\u02cc"+
		"\u02ce\7?\2\2\u02cd\u02cf\7\63\2\2\u02ce\u02cd\3\2\2\2\u02ce\u02cf\3\2"+
		"\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02d1\5\u00dco\2\u02d1\u02d2\5d\63\2\u02d2"+
		"s\3\2\2\2\u02d3\u02d4\7@\2\2\u02d4\u02d5\7\u0091\2\2\u02d5\u02d6\5\u00e4"+
		"s\2\u02d6\u02d7\7:\2\2\u02d7\u02d8\5\u00dep\2\u02d8\u02d9\7\u0092\2\2"+
		"\u02d9u\3\2\2\2\u02da\u02db\7\25\2\2\u02db\u02dc\5x=\2\u02dcw\3\2\2\2"+
		"\u02dd\u02e0\5z>\2\u02de\u02e0\5|?\2\u02df\u02dd\3\2\2\2\u02df\u02de\3"+
		"\2\2\2\u02e0y\3\2\2\2\u02e1\u02e2\5\u00dep\2\u02e2\u02e6\7\u0093\2\2\u02e3"+
		"\u02e5\5\u0080A\2\u02e4\u02e3\3\2\2\2\u02e5\u02e8\3\2\2\2\u02e6\u02e4"+
		"\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e9\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e9"+
		"\u02ea\7\u0094\2\2\u02ea{\3\2\2\2\u02eb\u02ef\7\u0091\2\2\u02ec\u02ee"+
		"\5\u00dep\2\u02ed\u02ec\3\2\2\2\u02ee\u02f1\3\2\2\2\u02ef\u02ed\3\2\2"+
		"\2\u02ef\u02f0\3\2\2\2\u02f0\u02f2\3\2\2\2\u02f1\u02ef\3\2\2\2\u02f2\u02f3"+
		"\7\u0092\2\2\u02f3\u02f7\7\u0093\2\2\u02f4\u02f6\5~@\2\u02f5\u02f4\3\2"+
		"\2\2\u02f6\u02f9\3\2\2\2\u02f7\u02f5\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8"+
		"\u02fa\3\2\2\2\u02f9\u02f7\3\2\2\2\u02fa\u02fb\7\u0094\2\2\u02fb}\3\2"+
		"\2\2\u02fc\u0300\7\u0091\2\2\u02fd\u02ff\5\u0080A\2\u02fe\u02fd\3\2\2"+
		"\2\u02ff\u0302\3\2\2\2\u0300\u02fe\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u0303"+
		"\3\2\2\2\u0302\u0300\3\2\2\2\u0303\u0304\7\u0092\2\2\u0304\177\3\2\2\2"+
		"\u0305\u030b\5\u010a\u0086\2\u0306\u030b\5\u00fc\177\2\u0307\u030b\5\u00fe"+
		"\u0080\2\u0308\u030b\5\u0106\u0084\2\u0309\u030b\7=\2\2\u030a\u0305\3"+
		"\2\2\2\u030a\u0306\3\2\2\2\u030a\u0307\3\2\2\2\u030a\u0308\3\2\2\2\u030a"+
		"\u0309\3\2\2\2\u030b\u0081\3\2\2\2\u030c\u030d\7A\2\2\u030d\u030e\5d\63"+
		"\2\u030e\u0083\3\2\2\2\u030f\u0314\5d\63\2\u0310\u0311\7\30\2\2\u0311"+
		"\u0313\5d\63\2\u0312\u0310\3\2\2\2\u0313\u0316\3\2\2\2\u0314\u0312\3\2"+
		"\2\2\u0314\u0315\3\2\2\2\u0315\u0085\3\2\2\2\u0316\u0314\3\2\2\2\u0317"+
		"\u0318\7\31\2\2\u0318\u0319\5\u0088E\2\u0319\u0087\3\2\2\2\u031a\u031c"+
		"\7\u0091\2\2\u031b\u031a\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u031d\3\2\2"+
		"\2\u031d\u031f\5\u008aF\2\u031e\u0320\7\u0092\2\2\u031f\u031e\3\2\2\2"+
		"\u031f\u0320\3\2\2\2\u0320\u0328\3\2\2\2\u0321\u0322\7\u0091\2\2\u0322"+
		"\u0323\5\u00e4s\2\u0323\u0324\7\u0092\2\2\u0324\u0328\3\2\2\2\u0325\u0328"+
		"\5\u00ecw\2\u0326\u0328\5\u0090I\2\u0327\u031b\3\2\2\2\u0327\u0321\3\2"+
		"\2\2\u0327\u0325\3\2\2\2\u0327\u0326\3\2\2\2\u0328\u0089\3\2\2\2\u0329"+
		"\u032f\5\u008cG\2\u032a\u032e\7\u008e\2\2\u032b\u032c\7\u008f\2\2\u032c"+
		"\u032e\5\u008cG\2\u032d\u032a\3\2\2\2\u032d\u032b\3\2\2\2\u032e\u0331"+
		"\3\2\2\2\u032f\u032d\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u008b\3\2\2\2\u0331"+
		"\u032f\3\2\2\2\u0332\u0333\7\u00a5\2\2\u0333\u0334\7\u0091\2\2\u0334\u0335"+
		"\5\u008eH\2\u0335\u0336\7\u0092\2\2\u0336\u008d\3\2\2\2\u0337\u033c\5"+
		"\u00e4s\2\u0338\u0339\7\u009d\2\2\u0339\u033b\5\u00e4s\2\u033a\u0338\3"+
		"\2\2\2\u033b\u033e\3\2\2\2\u033c\u033a\3\2\2\2\u033c\u033d\3\2\2\2\u033d"+
		"\u0340\3\2\2\2\u033e\u033c\3\2\2\2\u033f\u0337\3\2\2\2\u033f\u0340\3\2"+
		"\2\2\u0340\u008f\3\2\2\2\u0341\u0342\5\u010a\u0086\2\u0342\u0343\5\u0092"+
		"J\2\u0343\u0091\3\2\2\2\u0344\u034a\7\u0091\2\2\u0345\u0347\7\7\2\2\u0346"+
		"\u0345\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u0348\3\2\2\2\u0348\u034b\5\u0094"+
		"K\2\u0349\u034b\3\2\2\2\u034a\u0346\3\2\2\2\u034a\u0349\3\2\2\2\u034b"+
		"\u034c\3\2\2\2\u034c\u034d\7\u0092\2\2\u034d\u0093\3\2\2\2\u034e\u0353"+
		"\5\u00e4s\2\u034f\u0350\7\u009d\2\2\u0350\u0352\5\u00e4s\2\u0351\u034f"+
		"\3\2\2\2\u0352\u0355\3\2\2\2\u0353\u0351\3\2\2\2\u0353\u0354\3\2\2\2\u0354"+
		"\u0095\3\2\2\2\u0355\u0353\3\2\2\2\u0356\u0358\7\u0093\2\2\u0357\u0359"+
		"\5\u0098M\2\u0358\u0357\3\2\2\2\u0358\u0359\3\2\2\2\u0359\u035a\3\2\2"+
		"\2\u035a\u035b\7\u0094\2\2\u035b\u0097\3\2\2\2\u035c\u0363\5\u009aN\2"+
		"\u035d\u035f\7\u0098\2\2\u035e\u0360\5\u0098M\2\u035f\u035e\3\2\2\2\u035f"+
		"\u0360\3\2\2\2\u0360\u0362\3\2\2\2\u0361\u035d\3\2\2\2\u0362\u0365\3\2"+
		"\2\2\u0363\u0361\3\2\2\2\u0363\u0364\3\2\2\2\u0364\u0099\3\2\2\2\u0365"+
		"\u0363\3\2\2\2\u0366\u0367\5\u00dan\2\u0367\u0368\5\u009eP\2\u0368\u036d"+
		"\3\2\2\2\u0369\u036a\5\u00caf\2\u036a\u036b\5\u009cO\2\u036b\u036d\3\2"+
		"\2\2\u036c\u0366\3\2\2\2\u036c\u0369\3\2\2\2\u036d\u009b\3\2\2\2\u036e"+
		"\u0370\5\u009eP\2\u036f\u036e\3\2\2\2\u036f\u0370\3\2\2\2\u0370\u009d"+
		"\3\2\2\2\u0371\u0372\5\u00a0Q\2\u0372\u037b\5\u00a2R\2\u0373\u0377\7\u0097"+
		"\2\2\u0374\u0375\5\u00a0Q\2\u0375\u0376\5\u00a2R\2\u0376\u0378\3\2\2\2"+
		"\u0377\u0374\3\2\2\2\u0377\u0378\3\2\2\2\u0378\u037a\3\2\2\2\u0379\u0373"+
		"\3\2\2\2\u037a\u037d\3\2\2\2\u037b\u0379\3\2\2\2\u037b\u037c\3\2\2\2\u037c"+
		"\u009f\3\2\2\2\u037d\u037b\3\2\2\2\u037e\u0381\5\u00dco\2\u037f\u0381"+
		"\7\32\2\2\u0380\u037e\3\2\2\2\u0380\u037f\3\2\2\2\u0381\u00a1\3\2\2\2"+
		"\u0382\u0387\5\u00a4S\2\u0383\u0384\7\u009d\2\2\u0384\u0386\5\u00a4S\2"+
		"\u0385\u0383\3\2\2\2\u0386\u0389\3\2\2\2\u0387\u0385\3\2\2\2\u0387\u0388"+
		"\3\2\2\2\u0388\u00a3\3\2\2\2\u0389\u0387\3\2\2\2\u038a\u038b\5\u00d6l"+
		"\2\u038b\u00a5\3\2\2\2\u038c\u038d\5\u00dan\2\u038d\u038e\5\u00aaV\2\u038e"+
		"\u0393\3\2\2\2\u038f\u0390\5\u00ceh\2\u0390\u0391\5\u00a8U\2\u0391\u0393"+
		"\3\2\2\2\u0392\u038c\3\2\2\2\u0392\u038f\3\2\2\2\u0393\u00a7\3\2\2\2\u0394"+
		"\u0396\5\u00aaV\2\u0395\u0394\3\2\2\2\u0395\u0396\3\2\2\2\u0396\u00a9"+
		"\3\2\2\2\u0397\u039a\5\u00aeX\2\u0398\u039a\5\u00b0Y\2\u0399\u0397\3\2"+
		"\2\2\u0399\u0398\3\2\2\2\u039a\u039b\3\2\2\2\u039b\u03a2\5\u00b2Z\2\u039c"+
		"\u039e\7\u0097\2\2\u039d\u039f\5\u00acW\2\u039e\u039d\3\2\2\2\u039e\u039f"+
		"\3\2\2\2\u039f\u03a1\3\2\2\2\u03a0\u039c\3\2\2\2\u03a1\u03a4\3\2\2\2\u03a2"+
		"\u03a0\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u00ab\3\2\2\2\u03a4\u03a2\3\2"+
		"\2\2\u03a5\u03a8\5\u00aeX\2\u03a6\u03a8\5\u00b0Y\2\u03a7\u03a5\3\2\2\2"+
		"\u03a7\u03a6\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03aa\5\u00a2R\2\u03aa"+
		"\u00ad\3\2\2\2\u03ab\u03ac\5\u00b6\\\2\u03ac\u00af\3\2\2\2\u03ad\u03ae"+
		"\5\u00dep\2\u03ae\u00b1\3\2\2\2\u03af\u03b4\5\u00b4[\2\u03b0\u03b1\7\u009d"+
		"\2\2\u03b1\u03b3\5\u00b4[\2\u03b2\u03b0\3\2\2\2\u03b3\u03b6\3\2\2\2\u03b4"+
		"\u03b2\3\2\2\2\u03b4\u03b5\3\2\2\2\u03b5\u00b3\3\2\2\2\u03b6\u03b4\3\2"+
		"\2\2\u03b7\u03b8\5\u00d8m\2\u03b8\u00b5\3\2\2\2\u03b9\u03ba\5\u00b8]\2"+
		"\u03ba\u00b7\3\2\2\2\u03bb\u03c0\5\u00ba^\2\u03bc\u03bd\7\u00a3\2\2\u03bd"+
		"\u03bf\5\u00ba^\2\u03be\u03bc\3\2\2\2\u03bf\u03c2\3\2\2\2\u03c0\u03be"+
		"\3\2\2\2\u03c0\u03c1\3\2\2\2\u03c1\u00b9\3\2\2\2\u03c2\u03c0\3\2\2\2\u03c3"+
		"\u03c8\5\u00be`\2\u03c4\u03c5\7\u009f\2\2\u03c5\u03c7\5\u00be`\2\u03c6"+
		"\u03c4\3\2\2\2\u03c7\u03ca\3\2\2\2\u03c8\u03c6\3\2\2\2\u03c8\u03c9\3\2"+
		"\2\2\u03c9\u00bb\3\2\2\2\u03ca\u03c8\3\2\2\2\u03cb\u03cd\5\u00c2b\2\u03cc"+
		"\u03ce\5\u00c0a\2\u03cd\u03cc\3\2\2\2\u03cd\u03ce\3\2\2\2\u03ce\u00bd"+
		"\3\2\2\2\u03cf\u03d1\7\u0090\2\2\u03d0\u03cf\3\2\2\2\u03d0\u03d1\3\2\2"+
		"\2\u03d1\u03d2\3\2\2\2\u03d2\u03d3\5\u00bc_\2\u03d3\u00bf\3\2\2\2\u03d4"+
		"\u03d5\t\4\2\2\u03d5\u00c1\3\2\2\2\u03d6\u03df\5\u010a\u0086\2\u03d7\u03df"+
		"\7\32\2\2\u03d8\u03d9\7\u009e\2\2\u03d9\u03df\5\u00c4c\2\u03da\u03db\7"+
		"\u0091\2\2\u03db\u03dc\5\u00b6\\\2\u03dc\u03dd\7\u0092\2\2\u03dd\u03df"+
		"\3\2\2\2\u03de\u03d6\3\2\2\2\u03de\u03d7\3\2\2\2\u03de\u03d8\3\2\2\2\u03de"+
		"\u03da\3\2\2\2\u03df\u00c3\3\2\2\2\u03e0\u03ee\5\u00c6d\2\u03e1\u03ea"+
		"\7\u0091\2\2\u03e2\u03e7\5\u00c6d\2\u03e3\u03e4\7\u00a3\2\2\u03e4\u03e6"+
		"\5\u00c6d\2\u03e5\u03e3\3\2\2\2\u03e6\u03e9\3\2\2\2\u03e7\u03e5\3\2\2"+
		"\2\u03e7\u03e8\3\2\2\2\u03e8\u03eb\3\2\2\2\u03e9\u03e7\3\2\2\2\u03ea\u03e2"+
		"\3\2\2\2\u03ea\u03eb\3\2\2\2\u03eb\u03ec\3\2\2\2\u03ec\u03ee\7\u0092\2"+
		"\2\u03ed\u03e0\3\2\2\2\u03ed\u03e1\3\2\2\2\u03ee\u00c5\3\2\2\2\u03ef\u03f1"+
		"\7\u0090\2\2\u03f0\u03ef\3\2\2\2\u03f0\u03f1\3\2\2\2\u03f1\u03f4\3\2\2"+
		"\2\u03f2\u03f5\5\u010a\u0086\2\u03f3\u03f5\7\32\2\2\u03f4\u03f2\3\2\2"+
		"\2\u03f4\u03f3\3\2\2\2\u03f5\u00c7\3\2\2\2\u03f6\u03f7\7|\2\2\u03f7\u00c9"+
		"\3\2\2\2\u03f8\u03fb\5\u00d2j\2\u03f9\u03fb\5\u00ccg\2\u03fa\u03f8\3\2"+
		"\2\2\u03fa\u03f9\3\2\2\2\u03fb\u00cb\3\2\2\2\u03fc\u03fd\7\u0095\2\2\u03fd"+
		"\u03fe\5\u009eP\2\u03fe\u03ff\7\u0096\2\2\u03ff\u00cd\3\2\2\2\u0400\u0403"+
		"\5\u00d4k\2\u0401\u0403\5\u00d0i\2\u0402\u0400\3\2\2\2\u0402\u0401\3\2"+
		"\2\2\u0403\u00cf\3\2\2\2\u0404\u0405\7\u0095\2\2\u0405\u0406\5\u00aaV"+
		"\2\u0406\u0407\7\u0096\2\2\u0407\u00d1\3\2\2\2\u0408\u040a\7\u0091\2\2"+
		"\u0409\u040b\5\u00d6l\2\u040a\u0409\3\2\2\2\u040b\u040c\3\2\2\2\u040c"+
		"\u040a\3\2\2\2\u040c\u040d\3\2\2\2\u040d\u040e\3\2\2\2\u040e\u040f\7\u0092"+
		"\2\2\u040f\u00d3\3\2\2\2\u0410\u0412\7\u0091\2\2\u0411\u0413\5\u00d8m"+
		"\2\u0412\u0411\3\2\2\2\u0413\u0414\3\2\2\2\u0414\u0412\3\2\2\2\u0414\u0415"+
		"\3\2\2\2\u0415\u0416\3\2\2\2\u0416\u0417\7\u0092\2\2\u0417\u00d5\3\2\2"+
		"\2\u0418\u041b\5\u00dan\2\u0419\u041b\5\u00caf\2\u041a\u0418\3\2\2\2\u041a"+
		"\u0419\3\2\2\2\u041b\u00d7\3\2\2\2\u041c\u041f\5\u00dan\2\u041d\u041f"+
		"\5\u00ceh\2\u041e\u041c\3\2\2\2\u041e\u041d\3\2\2\2\u041f\u00d9\3\2\2"+
		"\2\u0420\u0423\5\u00dep\2\u0421\u0423\5\u00e0q\2\u0422\u0420\3\2\2\2\u0422"+
		"\u0421\3\2\2\2\u0423\u00db\3\2\2\2\u0424\u0427\5\u00dep\2\u0425\u0427"+
		"\5\u010a\u0086\2\u0426\u0424\3\2\2\2\u0426\u0425\3\2\2\2\u0427\u00dd\3"+
		"\2\2\2\u0428\u0429\t\5\2\2\u0429\u00df\3\2\2\2\u042a\u0431\5\u010a\u0086"+
		"\2\u042b\u0431\5\u00fc\177\2\u042c\u0431\5\u00fe\u0080\2\u042d\u0431\5"+
		"\u0106\u0084\2\u042e\u0431\5\u010e\u0088\2\u042f\u0431\5\u00e2r\2\u0430"+
		"\u042a\3\2\2\2\u0430\u042b\3\2\2\2\u0430\u042c\3\2\2\2\u0430\u042d\3\2"+
		"\2\2\u0430\u042e\3\2\2\2\u0430\u042f\3\2\2\2\u0431\u00e1\3\2\2\2\u0432"+
		"\u0433\7\u0091\2\2\u0433\u0434\7\u0092\2\2\u0434\u00e3\3\2\2\2\u0435\u0436"+
		"\bs\1\2\u0436\u0437\t\6\2\2\u0437\u043e\5\u00e4s\f\u0438\u0439\t\7\2\2"+
		"\u0439\u043e\5\u00e4s\13\u043a\u043b\7\u009e\2\2\u043b\u043e\5\u00e4s"+
		"\n\u043c\u043e\5\u00eav\2\u043d\u0435\3\2\2\2\u043d\u0438\3\2\2\2\u043d"+
		"\u043a\3\2\2\2\u043d\u043c\3\2\2\2\u043e\u045c\3\2\2\2\u043f\u0440\f\t"+
		"\2\2\u0440\u0441\t\6\2\2\u0441\u045b\5\u00e4s\n\u0442\u0443\f\b\2\2\u0443"+
		"\u0444\t\7\2\2\u0444\u045b\5\u00e4s\t\u0445\u0446\f\5\2\2\u0446\u0447"+
		"\t\b\2\2\u0447\u045b\5\u00e4s\6\u0448\u0449\f\7\2\2\u0449\u045b\5\u00e6"+
		"t\2\u044a\u044c\f\6\2\2\u044b\u044d\7q\2\2\u044c\u044b\3\2\2\2\u044c\u044d"+
		"\3\2\2\2\u044d\u044e\3\2\2\2\u044e\u044f\7r\2\2\u044f\u0451\7\u0091\2"+
		"\2\u0450\u0452\5\u0094K\2\u0451\u0450\3\2\2\2\u0451\u0452\3\2\2\2\u0452"+
		"\u0453\3\2\2\2\u0453\u045b\7\u0092\2\2\u0454\u0455\f\4\2\2\u0455\u0456"+
		"\7\u008e\2\2\u0456\u045b\5\u00e4s\2\u0457\u0458\f\3\2\2\u0458\u0459\7"+
		"\u008f\2\2\u0459\u045b\5\u00e4s\2\u045a\u043f\3\2\2\2\u045a\u0442\3\2"+
		"\2\2\u045a\u0445\3\2\2\2\u045a\u0448\3\2\2\2\u045a\u044a\3\2\2\2\u045a"+
		"\u0454\3\2\2\2\u045a\u0457\3\2\2\2\u045b\u045e\3\2\2\2\u045c\u045a\3\2"+
		"\2\2\u045c\u045d\3\2\2\2\u045d\u00e5\3\2\2\2\u045e\u045c\3\2\2\2\u045f"+
		"\u0462\5\u0102\u0082\2\u0460\u0462\5\u0104\u0083\2\u0461\u045f\3\2\2\2"+
		"\u0461\u0460\3\2\2\2\u0462\u0465\3\2\2\2\u0463\u0464\t\6\2\2\u0464\u0466"+
		"\5\u00e8u\2\u0465\u0463\3\2\2\2\u0465\u0466\3\2\2\2\u0466\u00e7\3\2\2"+
		"\2\u0467\u0469\t\t\2\2\u0468\u0467\3\2\2\2\u0468\u0469\3\2\2\2\u0469\u046a"+
		"\3\2\2\2\u046a\u046b\5\u00eav\2\u046b\u00e9\3\2\2\2\u046c\u046d\7\u0091"+
		"\2\2\u046d\u046e\5\u00e4s\2\u046e\u046f\7\u0092\2\2\u046f\u0478\3\2\2"+
		"\2\u0470\u0478\5\u00ecw\2\u0471\u0478\5\u00fa~\2\u0472\u0478\5\u00fc\177"+
		"\2\u0473\u0478\5\u00fe\u0080\2\u0474\u0478\5\u0106\u0084\2\u0475\u0478"+
		"\5\u00dep\2\u0476\u0478\5\u008cG\2\u0477\u046c\3\2\2\2\u0477\u0470\3\2"+
		"\2\2\u0477\u0471\3\2\2\2\u0477\u0472\3\2\2\2\u0477\u0473\3\2\2\2\u0477"+
		"\u0474\3\2\2\2\u0477\u0475\3\2\2\2\u0477\u0476\3\2\2\2\u0478\u00eb\3\2"+
		"\2\2\u0479\u0586\5\u00f8}\2\u047a\u047b\7\33\2\2\u047b\u047c\7\u0091\2"+
		"\2\u047c\u047d\5\u00e4s\2\u047d\u047e\7\u0092\2\2\u047e\u0586\3\2\2\2"+
		"\u047f\u0480\7\34\2\2\u0480\u0481\7\u0091\2\2\u0481\u0482\5\u00e4s\2\u0482"+
		"\u0483\7\u0092\2\2\u0483\u0586\3\2\2\2\u0484\u0485\7\35\2\2\u0485\u0486"+
		"\7\u0091\2\2\u0486\u0487\5\u00e4s\2\u0487\u0488\7\u009d\2\2\u0488\u0489"+
		"\5\u00e4s\2\u0489\u048a\7\u0092\2\2\u048a\u0586\3\2\2\2\u048b\u048c\7"+
		"\36\2\2\u048c\u048d\7\u0091\2\2\u048d\u048e\5\u00e4s\2\u048e\u048f\7\u0092"+
		"\2\2\u048f\u0586\3\2\2\2\u0490\u0491\7\37\2\2\u0491\u0492\7\u0091\2\2"+
		"\u0492\u0493\5\u00dep\2\u0493\u0494\7\u0092\2\2\u0494\u0586\3\2\2\2\u0495"+
		"\u0496\7B\2\2\u0496\u0497\7\u0091\2\2\u0497\u0498\5\u00e4s\2\u0498\u0499"+
		"\7\u0092\2\2\u0499\u0586\3\2\2\2\u049a\u049b\7C\2\2\u049b\u049c\7\u0091"+
		"\2\2\u049c\u049d\5\u00e4s\2\u049d\u049e\7\u0092\2\2\u049e\u0586\3\2\2"+
		"\2\u049f\u04a0\7D\2\2\u04a0\u04a2\7\u0091\2\2\u04a1\u04a3\5\u00e4s\2\u04a2"+
		"\u04a1\3\2\2\2\u04a2\u04a3\3\2\2\2\u04a3\u04a4\3\2\2\2\u04a4\u0586\7\u0092"+
		"\2\2\u04a5\u04a6\7E\2\2\u04a6\u04a7\7\u0091\2\2\u04a7\u0586\7\u0092\2"+
		"\2\u04a8\u04a9\7F\2\2\u04a9\u04aa\7\u0091\2\2\u04aa\u04ab\5\u00e4s\2\u04ab"+
		"\u04ac\7\u0092\2\2\u04ac\u0586\3\2\2\2\u04ad\u04ae\7G\2\2\u04ae\u04af"+
		"\7\u0091\2\2\u04af\u04b0\5\u00e4s\2\u04b0\u04b1\7\u0092\2\2\u04b1\u0586"+
		"\3\2\2\2\u04b2\u04b3\7H\2\2\u04b3\u04b4\7\u0091\2\2\u04b4\u04b5\5\u00e4"+
		"s\2\u04b5\u04b6\7\u0092\2\2\u04b6\u0586\3\2\2\2\u04b7\u04b8\7I\2\2\u04b8"+
		"\u04b9\7\u0091\2\2\u04b9\u04ba\5\u00e4s\2\u04ba\u04bb\7\u0092\2\2\u04bb"+
		"\u0586\3\2\2\2\u04bc\u04bd\7J\2\2\u04bd\u04bf\7\u0091\2\2\u04be\u04c0"+
		"\5\u0094K\2\u04bf\u04be\3\2\2\2\u04bf\u04c0\3\2\2\2\u04c0\u04c1\3\2\2"+
		"\2\u04c1\u0586\7\u0092\2\2\u04c2\u0586\5\u00f0y\2\u04c3\u04c4\7K\2\2\u04c4"+
		"\u04c5\7\u0091\2\2\u04c5\u04c6\5\u00e4s\2\u04c6\u04c7\7\u0092\2\2\u04c7"+
		"\u0586\3\2\2\2\u04c8\u0586\5\u00f2z\2\u04c9\u04ca\7L\2\2\u04ca\u04cb\7"+
		"\u0091\2\2\u04cb\u04cc\5\u00e4s\2\u04cc\u04cd\7\u0092\2\2\u04cd\u0586"+
		"\3\2\2\2\u04ce\u04cf\7M\2\2\u04cf\u04d0\7\u0091\2\2\u04d0\u04d1\5\u00e4"+
		"s\2\u04d1\u04d2\7\u0092\2\2\u04d2\u0586\3\2\2\2\u04d3\u04d4\7N\2\2\u04d4"+
		"\u04d5\7\u0091\2\2\u04d5\u04d6\5\u00e4s\2\u04d6\u04d7\7\u0092\2\2\u04d7"+
		"\u0586\3\2\2\2\u04d8\u04d9\7O\2\2\u04d9\u04da\7\u0091\2\2\u04da\u04db"+
		"\5\u00e4s\2\u04db\u04dc\7\u009d\2\2\u04dc\u04dd\5\u00e4s\2\u04dd\u04de"+
		"\7\u0092\2\2\u04de\u0586\3\2\2\2\u04df\u04e0\7P\2\2\u04e0\u04e1\7\u0091"+
		"\2\2\u04e1\u04e2\5\u00e4s\2\u04e2\u04e3\7\u009d\2\2\u04e3\u04e4\5\u00e4"+
		"s\2\u04e4\u04e5\7\u0092\2\2\u04e5\u0586\3\2\2\2\u04e6\u04e7\7Q\2\2\u04e7"+
		"\u04e8\7\u0091\2\2\u04e8\u04e9\5\u00e4s\2\u04e9\u04ea\7\u009d\2\2\u04ea"+
		"\u04eb\5\u00e4s\2\u04eb\u04ec\7\u0092\2\2\u04ec\u0586\3\2\2\2\u04ed\u04ee"+
		"\7R\2\2\u04ee\u04ef\7\u0091\2\2\u04ef\u04f0\5\u00e4s\2\u04f0\u04f1\7\u009d"+
		"\2\2\u04f1\u04f2\5\u00e4s\2\u04f2\u04f3\7\u0092\2\2\u04f3\u0586\3\2\2"+
		"\2\u04f4\u04f5\7S\2\2\u04f5\u04f6\7\u0091\2\2\u04f6\u04f7\5\u00e4s\2\u04f7"+
		"\u04f8\7\u009d\2\2\u04f8\u04f9\5\u00e4s\2\u04f9\u04fa\7\u0092\2\2\u04fa"+
		"\u0586\3\2\2\2\u04fb\u04fc\7U\2\2\u04fc\u04fd\7\u0091\2\2\u04fd\u04fe"+
		"\5\u00e4s\2\u04fe\u04ff\7\u0092\2\2\u04ff\u0586\3\2\2\2\u0500\u0501\7"+
		"V\2\2\u0501\u0502\7\u0091\2\2\u0502\u0503\5\u00e4s\2\u0503\u0504\7\u0092"+
		"\2\2\u0504\u0586\3\2\2\2\u0505\u0506\7W\2\2\u0506\u0507\7\u0091\2\2\u0507"+
		"\u0508\5\u00e4s\2\u0508\u0509\7\u0092\2\2\u0509\u0586\3\2\2\2\u050a\u050b"+
		"\7X\2\2\u050b\u050c\7\u0091\2\2\u050c\u050d\5\u00e4s\2\u050d\u050e\7\u0092"+
		"\2\2\u050e\u0586\3\2\2\2\u050f\u0510\7Y\2\2\u0510\u0511\7\u0091\2\2\u0511"+
		"\u0512\5\u00e4s\2\u0512\u0513\7\u0092\2\2\u0513\u0586\3\2\2\2\u0514\u0515"+
		"\7Z\2\2\u0515\u0516\7\u0091\2\2\u0516\u0517\5\u00e4s\2\u0517\u0518\7\u0092"+
		"\2\2\u0518\u0586\3\2\2\2\u0519\u051a\7[\2\2\u051a\u051b\7\u0091\2\2\u051b"+
		"\u051c\5\u00e4s\2\u051c\u051d\7\u0092\2\2\u051d\u0586\3\2\2\2\u051e\u051f"+
		"\7\\\2\2\u051f\u0520\7\u0091\2\2\u0520\u0521\5\u00e4s\2\u0521\u0522\7"+
		"\u0092\2\2\u0522\u0586\3\2\2\2\u0523\u0524\7]\2\2\u0524\u0525\7\u0091"+
		"\2\2\u0525\u0586\7\u0092\2\2\u0526\u0527\7^\2\2\u0527\u0528\7\u0091\2"+
		"\2\u0528\u0586\7\u0092\2\2\u0529\u052a\7_\2\2\u052a\u052b\7\u0091\2\2"+
		"\u052b\u0586\7\u0092\2\2\u052c\u052d\7`\2\2\u052d\u052e\7\u0091\2\2\u052e"+
		"\u052f\5\u00e4s\2\u052f\u0530\7\u0092\2\2\u0530\u0586\3\2\2\2\u0531\u0532"+
		"\7a\2\2\u0532\u0533\7\u0091\2\2\u0533\u0534\5\u00e4s\2\u0534\u0535\7\u0092"+
		"\2\2\u0535\u0586\3\2\2\2\u0536\u0537\7b\2\2\u0537\u0538\7\u0091\2\2\u0538"+
		"\u0539\5\u00e4s\2\u0539\u053a\7\u0092\2\2\u053a\u0586\3\2\2\2\u053b\u053c"+
		"\7c\2\2\u053c\u053d\7\u0091\2\2\u053d\u053e\5\u00e4s\2\u053e\u053f\7\u0092"+
		"\2\2\u053f\u0586\3\2\2\2\u0540\u0541\7d\2\2\u0541\u0542\7\u0091\2\2\u0542"+
		"\u0543\5\u00e4s\2\u0543\u0544\7\u0092\2\2\u0544\u0586\3\2\2\2\u0545\u0546"+
		"\7e\2\2\u0546\u0548\7\u0091\2\2\u0547\u0549\5\u0094K\2\u0548\u0547\3\2"+
		"\2\2\u0548\u0549\3\2\2\2\u0549\u054a\3\2\2\2\u054a\u0586\7\u0092\2\2\u054b"+
		"\u054c\7f\2\2\u054c\u054d\7\u0091\2\2\u054d\u054e\5\u00e4s\2\u054e\u054f"+
		"\7\u009d\2\2\u054f\u0550\5\u00e4s\2\u0550\u0551\7\u009d\2\2\u0551\u0552"+
		"\5\u00e4s\2\u0552\u0553\7\u0092\2\2\u0553\u0586\3\2\2\2\u0554\u0555\7"+
		"g\2\2\u0555\u0556\7\u0091\2\2\u0556\u0557\5\u00e4s\2\u0557\u0558\7\u009d"+
		"\2\2\u0558\u0559\5\u00e4s\2\u0559\u055a\7\u0092\2\2\u055a\u0586\3\2\2"+
		"\2\u055b\u055c\7h\2\2\u055c\u055d\7\u0091\2\2\u055d\u055e\5\u00e4s\2\u055e"+
		"\u055f\7\u009d\2\2\u055f\u0560\5\u00e4s\2\u0560\u0561\7\u0092\2\2\u0561"+
		"\u0586\3\2\2\2\u0562\u0563\7 \2\2\u0563\u0564\7\u0091\2\2\u0564\u0565"+
		"\5\u00e4s\2\u0565\u0566\7\u009d\2\2\u0566\u0567\5\u00e4s\2\u0567\u0568"+
		"\7\u0092\2\2\u0568\u0586\3\2\2\2\u0569\u056a\7!\2\2\u056a\u056b\7\u0091"+
		"\2\2\u056b\u056c\5\u00e4s\2\u056c\u056d\7\u0092\2\2\u056d\u0586\3\2\2"+
		"\2\u056e\u056f\7\"\2\2\u056f\u0570\7\u0091\2\2\u0570\u0571\5\u00e4s\2"+
		"\u0571\u0572\7\u0092\2\2\u0572\u0586\3\2\2\2\u0573\u0574\7#\2\2\u0574"+
		"\u0575\7\u0091\2\2\u0575\u0576\5\u00e4s\2\u0576\u0577\7\u0092\2\2\u0577"+
		"\u0586\3\2\2\2\u0578\u0579\7$\2\2\u0579\u057a\7\u0091\2\2\u057a\u057b"+
		"\5\u00e4s\2\u057b\u057c\7\u0092\2\2\u057c\u0586\3\2\2\2\u057d\u057e\7"+
		"i\2\2\u057e\u057f\7\u0091\2\2\u057f\u0580\5\u00e4s\2\u0580\u0581\7\u0092"+
		"\2\2\u0581\u0586\3\2\2\2\u0582\u0586\5\u00eex\2\u0583\u0586\5\u00f4{\2"+
		"\u0584\u0586\5\u00f6|\2\u0585\u0479\3\2\2\2\u0585\u047a\3\2\2\2\u0585"+
		"\u047f\3\2\2\2\u0585\u0484\3\2\2\2\u0585\u048b\3\2\2\2\u0585\u0490\3\2"+
		"\2\2\u0585\u0495\3\2\2\2\u0585\u049a\3\2\2\2\u0585\u049f\3\2\2\2\u0585"+
		"\u04a5\3\2\2\2\u0585\u04a8\3\2\2\2\u0585\u04ad\3\2\2\2\u0585\u04b2\3\2"+
		"\2\2\u0585\u04b7\3\2\2\2\u0585\u04bc\3\2\2\2\u0585\u04c2\3\2\2\2\u0585"+
		"\u04c3\3\2\2\2\u0585\u04c8\3\2\2\2\u0585\u04c9\3\2\2\2\u0585\u04ce\3\2"+
		"\2\2\u0585\u04d3\3\2\2\2\u0585\u04d8\3\2\2\2\u0585\u04df\3\2\2\2\u0585"+
		"\u04e6\3\2\2\2\u0585\u04ed\3\2\2\2\u0585\u04f4\3\2\2\2\u0585\u04fb\3\2"+
		"\2\2\u0585\u0500\3\2\2\2\u0585\u0505\3\2\2\2\u0585\u050a\3\2\2\2\u0585"+
		"\u050f\3\2\2\2\u0585\u0514\3\2\2\2\u0585\u0519\3\2\2\2\u0585\u051e\3\2"+
		"\2\2\u0585\u0523\3\2\2\2\u0585\u0526\3\2\2\2\u0585\u0529\3\2\2\2\u0585"+
		"\u052c\3\2\2\2\u0585\u0531\3\2\2\2\u0585\u0536\3\2\2\2\u0585\u053b\3\2"+
		"\2\2\u0585\u0540\3\2\2\2\u0585\u0545\3\2\2\2\u0585\u054b\3\2\2\2\u0585"+
		"\u0554\3\2\2\2\u0585\u055b\3\2\2\2\u0585\u0562\3\2\2\2\u0585\u0569\3\2"+
		"\2\2\u0585\u056e\3\2\2\2\u0585\u0573\3\2\2\2\u0585\u0578\3\2\2\2\u0585"+
		"\u057d\3\2\2\2\u0585\u0582\3\2\2\2\u0585\u0583\3\2\2\2\u0585\u0584\3\2"+
		"\2\2\u0586\u00ed\3\2\2\2\u0587\u0588\7%\2\2\u0588\u0589\7\u0091\2\2\u0589"+
		"\u058a\5\u00e4s\2\u058a\u058b\7\u009d\2\2\u058b\u058e\5\u00e4s\2\u058c"+
		"\u058d\7\u009d\2\2\u058d\u058f\5\u00e4s\2\u058e\u058c\3\2\2\2\u058e\u058f"+
		"\3\2\2\2\u058f\u0590\3\2\2\2\u0590\u0591\7\u0092\2\2\u0591\u00ef\3\2\2"+
		"\2\u0592\u0593\7&\2\2\u0593\u0594\7\u0091\2\2\u0594\u0595\5\u00e4s\2\u0595"+
		"\u0596\7\u009d\2\2\u0596\u0599\5\u00e4s\2\u0597\u0598\7\u009d\2\2\u0598"+
		"\u059a\5\u00e4s\2\u0599\u0597\3\2\2\2\u0599\u059a\3\2\2\2\u059a\u059b"+
		"\3\2\2\2\u059b\u059c\7\u0092\2\2\u059c\u00f1\3\2\2\2\u059d\u059e\7T\2"+
		"\2\u059e\u059f\7\u0091\2\2\u059f\u05a0\5\u00e4s\2\u05a0\u05a1\7\u009d"+
		"\2\2\u05a1\u05a2\5\u00e4s\2\u05a2\u05a3\7\u009d\2\2\u05a3\u05a6\5\u00e4"+
		"s\2\u05a4\u05a5\7\u009d\2\2\u05a5\u05a7\5\u00e4s\2\u05a6\u05a4\3\2\2\2"+
		"\u05a6\u05a7\3\2\2\2\u05a7\u05a8\3\2\2\2\u05a8\u05a9\7\u0092\2\2\u05a9"+
		"\u00f3\3\2\2\2\u05aa\u05ab\7s\2\2\u05ab\u05ac\5d\63\2\u05ac\u00f5\3\2"+
		"\2\2\u05ad\u05ae\7q\2\2\u05ae\u05af\7s\2\2\u05af\u05b0\5d\63\2\u05b0\u00f7"+
		"\3\2\2\2\u05b1\u05b2\7j\2\2\u05b2\u05b4\7\u0091\2\2\u05b3\u05b5\7\7\2"+
		"\2\u05b4\u05b3\3\2\2\2\u05b4\u05b5\3\2\2\2\u05b5\u05b8\3\2\2\2\u05b6\u05b9"+
		"\7\u009b\2\2\u05b7\u05b9\5\u00e4s\2\u05b8\u05b6\3\2\2\2\u05b8\u05b7\3"+
		"\2\2\2\u05b9\u05ba\3\2\2\2\u05ba\u05f2\7\u0092\2\2\u05bb\u05bc\7k\2\2"+
		"\u05bc\u05be\7\u0091\2\2\u05bd\u05bf\7\7\2\2\u05be\u05bd\3\2\2\2\u05be"+
		"\u05bf\3\2\2\2\u05bf\u05c0\3\2\2\2\u05c0\u05c1\5\u00e4s\2\u05c1\u05c2"+
		"\7\u0092\2\2\u05c2\u05f2\3\2\2\2\u05c3\u05c4\7l\2\2\u05c4\u05c6\7\u0091"+
		"\2\2\u05c5\u05c7\7\7\2\2\u05c6\u05c5\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7"+
		"\u05c8\3\2\2\2\u05c8\u05c9\5\u00e4s\2\u05c9\u05ca\7\u0092\2\2\u05ca\u05f2"+
		"\3\2\2\2\u05cb\u05cc\7m\2\2\u05cc\u05ce\7\u0091\2\2\u05cd\u05cf\7\7\2"+
		"\2\u05ce\u05cd\3\2\2\2\u05ce\u05cf\3\2\2\2\u05cf\u05d0\3\2\2\2\u05d0\u05d1"+
		"\5\u00e4s\2\u05d1\u05d2\7\u0092\2\2\u05d2\u05f2\3\2\2\2\u05d3\u05d4\7"+
		"n\2\2\u05d4\u05d6\7\u0091\2\2\u05d5\u05d7\7\7\2\2\u05d6\u05d5\3\2\2\2"+
		"\u05d6\u05d7\3\2\2\2\u05d7\u05d8\3\2\2\2\u05d8\u05d9\5\u00e4s\2\u05d9"+
		"\u05da\7\u0092\2\2\u05da\u05f2\3\2\2\2\u05db\u05dc\7o\2\2\u05dc\u05de"+
		"\7\u0091\2\2\u05dd\u05df\7\7\2\2\u05de\u05dd\3\2\2\2\u05de\u05df\3\2\2"+
		"\2\u05df\u05e0\3\2\2\2\u05e0\u05e1\5\u00e4s\2\u05e1\u05e2\7\u0092\2\2"+
		"\u05e2\u05f2\3\2\2\2\u05e3\u05e4\7p\2\2\u05e4\u05e6\7\u0091\2\2\u05e5"+
		"\u05e7\7\7\2\2\u05e6\u05e5\3\2\2\2\u05e6\u05e7\3\2\2\2\u05e7\u05e8\3\2"+
		"\2\2\u05e8\u05ed\5\u00e4s\2\u05e9\u05ea\7\u0097\2\2\u05ea\u05eb\7t\2\2"+
		"\u05eb\u05ec\7\u00a0\2\2\u05ec\u05ee\5\u0108\u0085\2\u05ed\u05e9\3\2\2"+
		"\2\u05ed\u05ee\3\2\2\2\u05ee\u05ef\3\2\2\2\u05ef\u05f0\7\u0092\2\2\u05f0"+
		"\u05f2\3\2\2\2\u05f1\u05b1\3\2\2\2\u05f1\u05bb\3\2\2\2\u05f1\u05c3\3\2"+
		"\2\2\u05f1\u05cb\3\2\2\2\u05f1\u05d3\3\2\2\2\u05f1\u05db\3\2\2\2\u05f1"+
		"\u05e3\3\2\2\2\u05f2\u00f9\3\2\2\2\u05f3\u05f5\5\u010a\u0086\2\u05f4\u05f6"+
		"\5\u0092J\2\u05f5\u05f4\3\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u00fb\3\2\2"+
		"\2\u05f7\u05fb\5\u0108\u0085\2\u05f8\u05fc\7{\2\2\u05f9\u05fa\7\u008a"+
		"\2\2\u05fa\u05fc\5\u010a\u0086\2\u05fb\u05f8\3\2\2\2\u05fb\u05f9\3\2\2"+
		"\2\u05fb\u05fc\3\2\2\2\u05fc\u00fd\3\2\2\2\u05fd\u0601\5\u0100\u0081\2"+
		"\u05fe\u0601\5\u0102\u0082\2\u05ff\u0601\5\u0104\u0083\2\u0600\u05fd\3"+
		"\2\2\2\u0600\u05fe\3\2\2\2\u0600\u05ff\3\2\2\2\u0601\u00ff\3\2\2\2\u0602"+
		"\u0603\t\n\2\2\u0603\u0101\3\2\2\2\u0604\u0605\t\13\2\2\u0605\u0103\3"+
		"\2\2\2\u0606\u0607\t\f\2\2\u0607\u0105\3\2\2\2\u0608\u0609\t\r\2\2\u0609"+
		"\u0107\3\2\2\2\u060a\u060b\t\16\2\2\u060b\u0109\3\2\2\2\u060c\u060f\7"+
		"u\2\2\u060d\u060f\5\u010c\u0087\2\u060e\u060c\3\2\2\2\u060e\u060d\3\2"+
		"\2\2\u060f\u010b\3\2\2\2\u0610\u0611\t\17\2\2\u0611\u010d\3\2\2\2\u0612"+
		"\u0615\7x\2\2\u0613\u0615\5\u0110\u0089\2\u0614\u0612\3\2\2\2\u0614\u0613"+
		"\3\2\2\2\u0615\u010f\3\2\2\2\u0616\u0617\7\u0095\2\2\u0617\u0618\7\u0096"+
		"\2\2\u0618\u0111\3\2\2\2\u009c\u0117\u011d\u0120\u0124\u0126\u0134\u0141"+
		"\u0146\u0149\u0152\u0159\u0162\u0168\u016c\u0172\u0175\u017a\u017e\u0186"+
		"\u018e\u0193\u0198\u019b\u019e\u01a1\u01a8\u01b0\u01b5\u01bb\u01c4\u01cd"+
		"\u01d1\u01d5\u01d7\u01e1\u01eb\u01f0\u01f2\u01ff\u0203\u0208\u020c\u0212"+
		"\u0218\u021e\u0226\u022e\u0242\u0246\u0249\u024e\u025c\u0262\u0265\u026e"+
		"\u0279\u027e\u0283\u0286\u028c\u0293\u0297\u029d\u02a2\u02a7\u02ac\u02af"+
		"\u02b4\u02b8\u02c3\u02ce\u02df\u02e6\u02ef\u02f7\u0300\u030a\u0314\u031b"+
		"\u031f\u0327\u032d\u032f\u033c\u033f\u0346\u034a\u0353\u0358\u035f\u0363"+
		"\u036c\u036f\u0377\u037b\u0380\u0387\u0392\u0395\u0399\u039e\u03a2\u03a7"+
		"\u03b4\u03c0\u03c8\u03cd\u03d0\u03de\u03e7\u03ea\u03ed\u03f0\u03f4\u03fa"+
		"\u0402\u040c\u0414\u041a\u041e\u0422\u0426\u0430\u043d\u044c\u0451\u045a"+
		"\u045c\u0461\u0465\u0468\u0477\u04a2\u04bf\u0548\u0585\u058e\u0599\u05a6"+
		"\u05b4\u05b8\u05be\u05c6\u05ce\u05d6\u05de\u05e6\u05ed\u05f1\u05f5\u05fb"+
		"\u0600\u060e\u0614";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}