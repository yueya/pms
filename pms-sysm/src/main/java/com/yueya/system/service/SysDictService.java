package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.tables.daos.SysDictDao;
import com.yueya.system.dao.tables.pojos.SysDictDO;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SysDictService extends BaseService {

    @Autowired
    private SysDictDao dictDao;

    public void insert(SysDictDO dictDO){
        dictDao.insert(dictDO);
    }

    public void update(SysDictDO dictDO){
        dictDao.update(dictDO);
    }
    public List<SysDictDO> page(int offset, int limit, Condition... conditions){
        return dictDao.page(offset,limit,conditions);
    }

    public void delete(long id){
        dictDao.deleteById(id);
    }
}
