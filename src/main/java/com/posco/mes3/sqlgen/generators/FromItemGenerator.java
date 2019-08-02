package com.posco.mes3.sqlgen.generators;

import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.FromItem;
import net.sf.jsqlparser.statement.select.SubSelect;

public class FromItemGenerator {

    private FromItem fromItem;

    public FromItemGenerator(FromItem fromItem) {
        this.fromItem = fromItem;
    }

    public String generate(){

        if ( fromItem instanceof Table ){
            return new TableGenerator((Table) fromItem).generate();
        } else if ( fromItem instanceof SubSelect ){
            String generatedSQL =  new SubSelectGenerator((SubSelect) fromItem).generate();
            return "( ".concat(generatedSQL).concat(" )");
        }

        return null;
    }
}
