package org.lmars.panmap.filter;

import java.util.HashMap;
import java.util.Map;

import org.lmars.panmap.exception.NoSelectVarException;
import org.lmars.sparql.parser.SparqlParser;

public class Filters {

	public Filters(SparqlParser.FilterContext ctx) {
		// TODO Auto-generated constructor stub
		int type = judge_filter_condition(ctx);
		switch (type) {
		case 0:// 表达式约束
			filter = new FilterRuleExper(ctx);
			break;

		default:
			break;
		}
	}

	/*
	 * 判断约束语句的类型
	 */
	private int judge_filter_condition(SparqlParser.FilterContext ctx) {
		int type = 0;

		return type;
	}

	/*
	 * 根据约束语句的类型 调用相应的执行函数
	 */
	public boolean filterExcute() throws NoSelectVarException {

		return filter.filterExcute();
	}

	private FilterStrategy filter;
}
