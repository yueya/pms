package com.yueya.common.base;
import org.jooq.*;
import org.jooq.impl.DAOImpl;
import org.jooq.impl.DSL;

import java.util.List;

public abstract class BaseDao<R extends UpdatableRecord<R>, P, T> extends DAOImpl<R, P, T> {
    protected BaseDao(Table table, Class type) {
        super(table, type);
    }


    protected BaseDao(Table<R> table, Class<P> type, Configuration configuration) {
        super(table,type,configuration);
    }
    public List<P> page(int offset, int limit,Condition... conditions){
         return DSL.using(super.configuration())
                .selectFrom(getTable())
                .where(conditions)
                .offset(offset).limit(limit).fetch().map(super.mapper());
    }

}
