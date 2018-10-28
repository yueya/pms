package com.yueya.common.config.db;

import org.jooq.ExecuteContext;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultExecuteListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PmsDbListener extends DefaultExecuteListener {
    @Autowired
    private DataSourceConnectionProvider connectionProviderMaster;
    @Autowired
    private DataSourceConnectionProvider connectionProviderSlave;
    @Override
    public void renderEnd(ExecuteContext ctx) {
        System.out.println("listen:"+ctx.sql());
        if(ctx.sql().matches("^(?i)(insert|update|delete).+")){
            System.out.println("master");
            ctx.connectionProvider(connectionProviderMaster);
        }else{
            System.out.println("slave");
            ctx.connectionProvider(connectionProviderSlave);
        }
    }
}
