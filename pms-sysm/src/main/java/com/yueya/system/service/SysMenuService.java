package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.tables.daos.SysMenuDao;
import com.yueya.system.dao.tables.pojos.SysMenuDO;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysMenuService extends BaseService<SysMenuDO> {
    @Autowired
    private SysMenuDao menuDao;

    public void insert(SysMenuDO menuDO){
        menuDao.insert(menuDO);
    }

    public void update(SysMenuDO menuDO){
        menuDao.update(menuDO);
    }

    public void delete(String ids){
        List<Long> list= Arrays.stream(ids.split(","))
                .map(r->Long.valueOf(r)).collect(Collectors.toList());
        menuDao.deleteById(list);
    }

    /**
     * 根据用户角色 获取用户可以看到的菜单
     * @param userId
     * @return
     */
    public List<SysMenuDO> list(String userId){
        return menuDao.fetchMenusByUserId(Long.valueOf(userId));
    }

    @Override
    public List<Condition> getConditions(SysMenuDO menuDO) {
        return null;
    }

    public List<SysMenuDO> page(int offset, int limit, SysMenuDO menuDO) {
        return menuDao.page(offset,limit,getConditions(menuDO));
    }

    public List<SysMenuDO> findAll() {
        return menuDao.findAll();
    }
}
