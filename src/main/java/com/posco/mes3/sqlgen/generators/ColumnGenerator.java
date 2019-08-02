package com.posco.mes3.sqlgen.generators;

import com.posco.mes3.sqlgen.util.ServiceHelper;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;

import javax.xml.ws.Service;

public class ColumnGenerator {

    private Column column;

    public ColumnGenerator(Column column) {
        this.column = column;
    }

    public String generate(){

        StringBuilder sqlBuilder = new StringBuilder();

        Table table = column.getTable();

        if ( table != null ){
            sqlBuilder.append(ServiceHelper.getInstance().getServiceName( table.getName()));
            sqlBuilder.append(".");
        }

        sqlBuilder.append(column.getColumnName());

        return sqlBuilder.toString();
    }
}
