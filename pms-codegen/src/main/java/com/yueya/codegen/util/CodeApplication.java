package com.yueya.codegen.util;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.Configuration;

import javax.xml.bind.JAXB;
import java.io.File;

public class CodeApplication {
    public static void main(String[] args) throws Exception {
        File xml=new File(CodeApplication.class.getClassLoader().getResource("jooq.xml").getPath());
        Configuration configuration = JAXB.unmarshal(xml, Configuration.class);
        GenerationTool.generate(configuration);
    }
}
