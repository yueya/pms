package com.yueya.common.base;
import org.jooq.*;
import org.jooq.impl.DAOImpl;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.name;

public abstract class BaseDao<R extends UpdatableRecord<R>, P, T> extends DAOImpl<R, P, T> {

    private final String TEMP_TABLE_NAME="query_temp";
    protected BaseDao(Table table, Class type) {
        super(table, type);
    }


    protected BaseDao(Table<R> table, Class<P> type, Configuration configuration) {
        super(table,type,configuration);
    }
    public List<P> page(int offset,int limit,Condition... conditions){
        DSLContext create=DSL.using(super.configuration());
        Table<R> table=getTable();
        List<P> result;
        //如果分页offet超过1000，使用延迟关联子查询提高分页速度
        if(offset>1000 && !table.getIndexes().isEmpty()){
            String indexName=table.getIndexes().get(0).getFields().get(0).getName();
            Field index=field(name(getTable().getName(),indexName));
            result=create
                    .select()
                    .from(table)
                    .join(create.select(index).from(table).where(conditions)
                            .limit(offset,limit).asTable(TEMP_TABLE_NAME))
                    .on(index.eq(field(name(TEMP_TABLE_NAME,index.getName()),String.class)))
                    .fetchInto(getType());
        }else{
            result=create.select().from(table)
            .where(conditions)
            .limit(offset,limit)
            .fetchInto(getType());
        }
        return result;
    }

}
