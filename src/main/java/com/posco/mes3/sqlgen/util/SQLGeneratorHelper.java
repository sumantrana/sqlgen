package com.posco.mes3.sqlgen.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SQLGeneratorHelper {

    private static SQLGeneratorHelper instance = null;

    private boolean singleTableGen;
    private String tableName;
    private List<String> tableNameList;
    private List<String> columnNameList;

    private SQLGeneratorHelper(){

    }

    public static SQLGeneratorHelper getInstance(){

        if ( instance == null ){
            instance = new SQLGeneratorHelper();
        }

        return instance;
    }


}
