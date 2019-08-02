package com.posco.mes3.sqlgen.util;

public class ServiceHelper {

    private static ServiceHelper instance = null;

    private ServiceHelper(){

    }

    public static ServiceHelper getInstance(){

        if ( instance == null ){
            instance = new ServiceHelper();
        }

        return instance;
    }

    public String getServiceName( String tableName ) {

        if ( tableName != null ){
            return tableName;
        } else {
            return "";
        }

    }
}
