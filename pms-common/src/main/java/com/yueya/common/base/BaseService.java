package com.yueya.common.base;

import org.jooq.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class BaseService<T> {
    protected Logger logger= LoggerFactory.getLogger(getClass());
    public abstract List<Condition> getConditions(T t);
}
