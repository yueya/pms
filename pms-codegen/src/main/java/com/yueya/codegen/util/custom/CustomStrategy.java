package com.yueya.codegen.util.custom;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

public class CustomStrategy extends DefaultGeneratorStrategy {

    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
        if(mode.equals(Mode.POJO)){
            return super.getJavaClassName(definition, mode)+"DO";
        }
        return super.getJavaClassName(definition, mode);
    }
}
