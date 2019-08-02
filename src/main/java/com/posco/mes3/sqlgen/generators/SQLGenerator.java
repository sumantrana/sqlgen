package com.posco.mes3.sqlgen.generators;

import java.util.Properties;

public interface SQLGenerator {

    String generate();

    String generate(Properties properties);

}
