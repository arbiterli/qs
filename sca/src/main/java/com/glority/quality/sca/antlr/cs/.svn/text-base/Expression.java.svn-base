package com.glority.quality.sca.antlr.cs;

public class Expression {

	private boolean	expression;

	public boolean isExpression() {
		return expression;
	}

	public void setExpression(boolean expression) {
		this.expression = expression;
	}

	// custom methods used in lexer actions
	
	public void set(boolean expr) {
		this.expression = expr;
	}
	
	public void set(Expression exprParam) {
		this.expression = exprParam.expression;
	}

	public void or(Expression expr1, Expression expr2) {
		this.expression = expr1.expression || expr2.expression;
	}

	public void and(Expression expr1, Expression expr2) {
		this.expression = expr1.expression && expr2.expression;
	}

	public void equal(Expression expr1, Expression expr2) {
		this.expression = expr1.expression == expr2.expression;
	}

	public void unequal(Expression expr1, Expression expr2) {
		this.expression = expr1.expression != expr2.expression;
	}

	public void not(Expression expr) {
		this.expression = !expr.expression;
	}
	
}
