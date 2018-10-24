package com.yueya.codegen.util;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.Configuration;

import javax.xml.bind.JAXB;
import java.io.File;

public class Application {
    public static void main(String[] args) throws Exception {
        File xml=new File(Application.class.getClassLoader().getResource("jooq.xml").getPath());
        Configuration configuration = JAXB.unmarshal(xml, Configuration.class);
        configuration.getJdbc()
                .withUser("root")
                .withPassword("123456");
        GenerationTool.generate(configuration);
    }
}
