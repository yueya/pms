package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.tables.SysDict;
import com.yueya.system.dao.tables.daos.SysDictDao;
import com.yueya.system.dao.tables.pojos.SysDictDO;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class SysDictService extends BaseService<SysDictDO> {

    @Autowired
    private SysDictDao dictDao;

    public void insert(SysDictDO dictDO){
        dictDao.insert(dictDO);
    }

    public void update(SysDictDO dictDO){
        dictDao.update(dictDO);
    }
    public List<Condition> getConditions(SysDictDO dictDO){
        List<Condition> conditions=new ArrayList<>(3);
        if(dictDO.getCode()!=null){
            conditions.add(SysDict.SYS_DICT.CODE.eq(dictDO.getCode()));
        }
        if(dictDO.getName()!=null){
            conditions.add(SysDict.SYS_DICT.NAME.like("%"+dictDO.getName()+"%"));
        }
        if(dictDO.getType()!=null){
            conditions.add(SysDict.SYS_DICT.TYPE.eq(dictDO.getType()));
        }
        return conditions;
    }
    public List<SysDictDO> page(int offset, int limit, SysDictDO dictDO){
        return dictDao.page(offset,limit, getConditions(dictDO));
    }

    public void delete(long id){
        dictDao.deleteById(id);
    }

    public void delete(String ids) {
        List<Long> list= Arrays.stream(ids.split(","))
                .map(r->Long.valueOf(r)).collect(Collectors.toList());
        dictDao.deleteById(list);
    }

    public long count(SysDictDO dictDO) {
        return dictDao.countByCondition( getConditions(dictDO));
    }
}
