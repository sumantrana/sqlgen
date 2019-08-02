package com.posco.mes3.sqlgen.generators;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionGenerator {

    private Function function;

    public FunctionGenerator(Function function) {
        this.function = function;
    }

    public String generate(){

        String functionName = function.getName();

        //TODO: Get the template and fill in the params based on the function
        ExpressionList expressionList = function.getParameters();
        List<Expression> expressions = expressionList.getExpressions();

        List<String> parameterList = expressions.stream().map( expression -> {
                                        return new ExpressionGenerator(expression).generate();
                                    }).collect(Collectors.toList());

        StringBuilder functionBuilder = new StringBuilder();
        functionBuilder.append(functionName).append("(");
        functionBuilder.append(String.join(", ", parameterList));
        functionBuilder.append(")");

        return functionBuilder.toString();
    }
}
