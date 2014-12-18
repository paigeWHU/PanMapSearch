package org.lmars.panmap.filter;

import org.antlr.v4.runtime.tree.ParseTree;
import org.lmars.panmap.exception.NoSelectVarException;
import org.lmars.panmap.parser.ParseExcuteVar;
import org.lmars.sparql.parser.SparqlParser;

public abstract class FilterStrategy {

	public FilterStrategy(SparqlParser.FilterContext ctx) {
		// TODO Auto-generated constructor stub
		excuteVar = ParseExcuteVar.getexcuteVar();
		this.ctx = ctx;
	}

	public ParseExcuteVar excuteVar;
	public SparqlParser.FilterContext ctx;

	public abstract boolean filterExcute() throws NoSelectVarException;
}
