package com.posco.mes3.sqlgen.generators;


import java.util.Properties;

public abstract class BaseSQLGenerator implements SQLGenerator{

    public String generate(){
        return generate(null);
    }

    public String generate(Properties properties){
        return "Not yet implemented";
    }

}
