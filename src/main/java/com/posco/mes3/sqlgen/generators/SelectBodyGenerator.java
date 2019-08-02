package com.posco.mes3.sqlgen.generators;

import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectBody;

public class SelectBodyGenerator {

    private SelectBody selectBody;

    public SelectBodyGenerator(SelectBody selectBody) {
        this.selectBody = selectBody;
    }

    public String generate(){

        if (selectBody instanceof PlainSelect ){
            return new PlainSelectGenerator((PlainSelect)selectBody).generate();
        }

        return null;
    }
}
