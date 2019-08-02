package com.posco.mes3.sqlgen.generators;

import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItem;

public class SelectItemGenerator {

    private SelectItem selectItem;

    public SelectItemGenerator(SelectItem selectItem) {
        this.selectItem = selectItem;
    }

    public String generate(){

        if ( selectItem instanceof SelectExpressionItem ){
            return new SelectExpressionItemGenerator((SelectExpressionItem)selectItem).generate();
        }

        return null;

    }
}
