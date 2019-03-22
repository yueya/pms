package com.yueya.common.base;
import org.jooq.*;
import org.jooq.impl.*;

import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.using;

public class BaseDao<R extends UpdatableRecord<R>, P, T> extends DAOImpl<R, P, T> {

    private final String TEMP_TABLE_NAME="query_temp";
    public static final String DEL_NORMAL="0";
    public static final String DEL_DELETED="1";
    public static final String ENABLE="0";
    public static final String DISABLE="1";

    protected BaseDao(Table table, Class type) {
        super(table, type);
    }


    protected BaseDao(Table<R> table, Class<P> type, Configuration configuration) {
        super(table,type,configuration);
    }

    @Override
    protected T getId(P object) {
        return null;
    }
    public List<P> fetchByCondition(Condition... conditions){
        DSLContext create=DSL.using(super.configuration());
        Table<R> table=getTable();
        List<P> result=create.select().from(table)
                .where(conditions)
                .fetchInto(getType());
        return result;
    }

    public int updateByCondition(P object,Condition... conditions){
        DSLContext create=DSL.using(super.configuration());
        Record record=create.newRecord(getTable(),object);
        Field<?>[] fields=record.fields();
        for (Field<?> field:fields) {
            if(field.getValue(record)==null){
                record.changed(field,false);
            }
        }
        return create.update(getTable())
                .set(record)
                .where(conditions)
                .execute();
    }
    public int deleteByCondition(Condition... conditions){
        DSLContext create=DSL.using(super.configuration());
        return create.delete(getTable())
                .where(conditions)
                .execute();
    }
    private /* non-final */ RecordListenerProvider[] providers(final RecordListenerProvider[] providers, final Object object) {
        RecordListenerProvider[] result = Arrays.copyOf(providers, providers.length + 1);

        result[providers.length] = new DefaultRecordListenerProvider(new DefaultRecordListener() {
            private final void end(RecordContext ctx) {
                Record record = ctx.record();

                // TODO: [#2536] Use mapper()
                if (record != null)
                    record.into(object);
            }

            @Override
            public final void storeEnd(RecordContext ctx) {
                end(ctx);
            }

            @Override
            public final void insertEnd(RecordContext ctx) {
                end(ctx);
            }

            @Override
            public final void updateEnd(RecordContext ctx) {
                end(ctx);
            }

            @Override
            public final void deleteEnd(RecordContext ctx) {
                end(ctx);
            }
        });

        return result;
    }
    private /* non-final */ Field<?>[] pk() {
        UniqueKey<?> key = getTable().getPrimaryKey();
        return key == null ? null : key.getFieldsArray();
    }
    public Field<?>[] getFields() {
        return getTable().fields();
    }
    private /* non-final */ List<R> records(Collection<P> objects, boolean forUpdate) {
        List<R> result = new ArrayList<R>(objects.size());
        Field<?>[] pk = pk();

        for (P object : objects) {

            // [#2536] Upon store(), insert(), update(), delete(), returned values in the record
            //         are copied back to the relevant POJO using the RecordListener SPI
            DSLContext ctx = using(
                    ! FALSE.equals(configuration().settings().isReturnRecordToPojo())
                            ? configuration().derive(providers(configuration().recordListenerProviders(), object))
                            : configuration()
            );

            R record = ctx.newRecord(getTable(), object);

            if (forUpdate && pk != null){
                for (Field<?> field : pk){
                    record.changed(field,false);
                }
            }
            Field<?>[] fields=record.fields();
            for (Field<?> field:fields) {
                if(field.getValue(record)==null){
                    record.changed(field,false);
                }
            }
            result.add(record);
        }

        return result;
    }
    public void update(P object){
        records(Collections.singletonList(object), true).get(0).update();
    }
    @Override
    public /* non-final */ void update(Collection<P> objects) {

        // Execute a batch UPDATE
        if (objects.size() > 1){
            // [#2536] [#3327] We cannot batch UPDATE RETURNING calls yet
            if (!FALSE.equals(configuration().settings().isReturnRecordToPojo()) &&
                    TRUE.equals(configuration().settings().isReturnAllOnUpdatableRecord())){
                for (P object : objects){
                    update(object);
                }
            } else{
                using(configuration()).batchUpdate(records(objects, true)).execute();
            }
        } else if (objects.size() == 1){
            records(objects, true).get(0).update();
        }
    }
    public void updateAll(P object){
        super.update(object);
    }
    public long countByCondition(List<Condition> conditions){
        DSLContext create=DSL.using(super.configuration());
        return create.selectCount()
                .from(getTable())
                .where(conditions)
                .fetchOne(0,Long.class);
    }
    public List<P> page(int offset,int limit,List<Condition> conditions){
        DSLContext create=DSL.using(super.configuration());
        Table<R> table=getTable();
        List<P> result;
        //如果分页offset超过1000，使用延迟关联子查询提高分页速度
        if(offset>1000 && !table.getIndexes().isEmpty()){
            String TEMP_TABLE = TEMP_TABLE_NAME+"_"+System.currentTimeMillis();
            String indexName=table.getIndexes().get(0).getFields().get(0).getName();
            Field index=field(name(getTable().getName(),indexName));
            result=create
                    .select(table.fields())
                    .from(table)
                    .join(create.select(index).from(table)
                    .where(conditions)
                    .limit(offset,limit).asTable(TEMP_TABLE))
                    .on(index.eq(field(name(TEMP_TABLE,index.getName()),String.class)))
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
