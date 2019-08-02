package com.posco.mes3.sqlgen.generators;


import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.select.FromItem;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectItem;

import java.util.List;
import java.util.stream.Collectors;

public class PlainSelectGenerator extends BaseSQLGenerator {

    PlainSelect plainSelect;

    public PlainSelectGenerator(PlainSelect plainSelect){
        this.plainSelect = plainSelect;
    }


    public String generate(){

        StringBuilder sqlBuilder = new StringBuilder(" SELECT ");

        List<SelectItem> selectItemList = plainSelect.getSelectItems();
        String selectItemString = generateSelectItemListSQL(selectItemList);
        sqlBuilder.append(selectItemString);

        sqlBuilder.append(" FROM ");
        FromItem fromItem = plainSelect.getFromItem();
        String fromItemString = generateFromItemSQL(fromItem);
        sqlBuilder.append(fromItemString);

        sqlBuilder.append(" WHERE ");
        Expression whereClause = plainSelect.getWhere();
        String expressionString = generateExpressionSQL(whereClause);
        sqlBuilder.append(expressionString);

        return sqlBuilder.toString();

    }

    private String generateExpressionSQL(Expression whereClause) {
        return new ExpressionGenerator(whereClause).generate();
    }

    private String generateFromItemSQL(FromItem fromItem) {

        return new FromItemGenerator(fromItem).generate();

    }

    private String generateSelectItemListSQL(List<SelectItem> selectItemList) {

       return selectItemList.stream().map( selectItem -> {

            return new SelectItemGenerator(selectItem).generate();

        }).collect(Collectors.joining(", "));

    }
}
