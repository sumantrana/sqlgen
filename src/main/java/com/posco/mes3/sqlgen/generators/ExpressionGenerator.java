package com.posco.mes3.sqlgen.generators;

import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.relational.ComparisonOperator;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.schema.Column;

public class ExpressionGenerator {

    private Expression expression;

    public ExpressionGenerator(Expression whereClause) {
        this.expression = whereClause;
    }

    public String generate(){

        if (expression instanceof Column){

            return new ColumnGenerator((Column)expression).generate();

        } else if (expression instanceof ComparisonOperator){

            return expression.toString();

        } else if (expression instanceof BinaryExpression){

            return expression.toString();

        } else if (expression instanceof Function){

            return new FunctionGenerator((Function) expression).generate();

        } else if (expression instanceof LongValue){

            return expression.toString();

        } else if (expression instanceof StringValue){

            return expression.toString();

        }

        return null;
    }
}
