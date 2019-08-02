package com.posco.mes3.sqlgen.generators;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.ExpressionListItem;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItem;

public class SelectExpressionItemGenerator {


    private SelectExpressionItem selectItem;

    public SelectExpressionItemGenerator(SelectExpressionItem selectItem) {
        this.selectItem = selectItem;
    }

    public String generate(){

        Expression expression = selectItem.getExpression();

        return new ExpressionGenerator(expression).generate();

    }
}
