package com.posco.mes3.sqlgen.generators;

import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.select.SubSelect;

public class SubSelectGenerator {

    private SubSelect subSelect;

    public SubSelectGenerator(SubSelect subSelect) {
        this.subSelect = subSelect;
    }

    public String generate(){

        SelectBody selectBody = subSelect.getSelectBody();

        return new SelectBodyGenerator(selectBody).generate();

    }
}
