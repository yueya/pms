package com.yueya.common.base;

import org.jooq.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class BaseService<T> {
    public static final String DEL_FLAG_DEL = "1";
    public static final String DEL_FLAG_NORMAL = "0";
    public final String USEABLE = "1";
    public final String DISABLE = "0";
    protected Logger logger= LoggerFactory.getLogger(getClass());
    public abstract List<Condition> getConditions(T t);

}
