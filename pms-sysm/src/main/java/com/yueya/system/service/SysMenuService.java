package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.tables.daos.SysMenuDao;
import com.yueya.system.dao.tables.pojos.SysMenuDO;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void delete(String id){
        menuDao.deleteById(Long.valueOf(id));
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
}
