package com.posco.mes3.sqlgen;

import com.posco.mes3.sqlgen.generators.PlainSelectGenerator;
import com.posco.mes3.sqlgen.generators.SelectBodyGenerator;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.select.SelectItem;

import java.util.List;

public class GenTest {

    //public static final String SQL_STRING = "SELECT MAX(AVG(SUM(a))), b FROM table1 where (a<2 and b>4) or (a>4)";
    public static final String SQL_STRING = "SELECT SUM(a), b FROM (select c, d from table1 where c<2 and d>4 ) tab where a = 2";

    public static void main(String[] args) throws Exception {

        Statement stmt = CCJSqlParserUtil.parse(SQL_STRING);

        Select selectStatement = (Select) stmt;

        SelectBody selectBody = selectStatement.getSelectBody();

        String generatedSQL = new SelectBodyGenerator(selectBody).generate();

        System.out.println("SQL: " + generatedSQL);



    }

}
