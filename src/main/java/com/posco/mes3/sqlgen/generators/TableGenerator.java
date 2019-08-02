package com.posco.mes3.sqlgen.generators;

import com.posco.mes3.sqlgen.util.ServiceHelper;
import net.sf.jsqlparser.schema.Table;

public class TableGenerator {

    private Table table;

    public TableGenerator(Table table) {
        this.table = table;
    }

    public String generate(){

        return ServiceHelper.getInstance().getServiceName(table.getName());

    }
}
