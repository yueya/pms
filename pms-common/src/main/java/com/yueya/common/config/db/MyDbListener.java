package com.yueya.common.config.db;

import org.jooq.ExecuteContext;
import org.jooq.impl.DefaultExecuteListener;

public class MyDbListener extends DefaultExecuteListener {
    @Override
    public void renderEnd(ExecuteContext ctx) {
        if(ctx.sql().matches("^(?i:(UPDATE|DELETE|INSERT))")){
        }
    }
}
