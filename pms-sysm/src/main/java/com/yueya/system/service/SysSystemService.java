package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.tables.daos.SysSystemDao;
import com.yueya.system.dao.tables.pojos.SysSystemDO;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class SysSystemService extends BaseService<SysSystemDO> {
    @Autowired
    private SysSystemDao dao;

    public void insert(SysSystemDO systemDO){
        dao.insert(systemDO);
    }

    public void update(SysSystemDO systemDO){
        dao.update(systemDO);
    }

    public void delete(String ids){
        List<Long> list= Arrays.stream(ids.split(","))
                .map(r->Long.valueOf(r)).collect(Collectors.toList());
        dao.deleteById(list);
    }

    public List<SysSystemDO> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Condition> getConditions(SysSystemDO sysSystemDO) {
        return null;
    }


}
