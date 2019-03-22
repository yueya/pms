package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.common.util.DateUtils;
import com.yueya.system.dao.tables.*;
import com.yueya.system.dao.tables.daos.*;
import com.yueya.system.dao.tables.pojos.*;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SysRoleService extends BaseService<SysRoleDO> {
    @Autowired
    private SysRoleDao dao;
    @Autowired
    private SysRoleMenuDao roleMenuDao;

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysUserRoleDao userRoleDao;
    @Override
    public List<Condition> getConditions(SysRoleDO sysRoleDO) {
        Condition condition = SysRole.SYS_ROLE.DEL_FLAG.eq(DEL_FLAG_NORMAL);
        return Collections.singletonList(condition);
    }

    public void insert(SysRoleDO sysRoleDO) {
        sysRoleDO.setDelFlag(DEL_FLAG_NORMAL);
        sysRoleDO.setGmtCreate(DateUtils.getCurTimeStamp());
        dao.insert(sysRoleDO);
    }

    public void update(SysRoleDO sysRoleDO) {
        sysRoleDO.setGmtModified(DateUtils.getCurTimeStamp());
        dao.update(sysRoleDO);
    }

    public void delete(String id) {
        SysRoleDO sysRoleDO = new SysRoleDO();
        sysRoleDO.setDelFlag(DEL_FLAG_DEL);
        sysRoleDO.setId(Long.valueOf(id));
        dao.update(sysRoleDO);
    }


    public List<SysRoleDO> page(int offset, int limit, SysRoleDO roleDO) {
        return dao.page(offset, limit, getConditions(roleDO));
    }

    public long countByCondition(SysRoleDO roleDO) {
        return dao.countByCondition(getConditions(roleDO));
    }

    public List<SysRoleMenuDO> roleMenus(String id) {
        return roleMenuDao.fetchMenuByRole(id);
    }

    public void authMenus(String roleId, String menuIds) {
        Condition condition = SysRoleMenu.SYS_ROLE_MENU.ROLE_ID.eq(Long.valueOf(roleId));
        roleMenuDao.deleteByCondition(condition);
        List<SysRoleMenuDO> list = Arrays.stream(menuIds.split(",")).map(id -> {
            SysRoleMenuDO roleMenuDO = new SysRoleMenuDO();
            roleMenuDO.setMenuId(Long.valueOf(id));
            roleMenuDO.setRoleId(Long.valueOf(roleId));
            return roleMenuDO;
        }).collect(Collectors.toList());
        roleMenuDao.insert(list);
    }

    public List<SysUserDO> fetchUsers(String roleId) {
        return sysUserDao.fetchByRole(roleId);
    }

    public void assign(String addIds, String delIds,String roleId) {
       if (!delIds.isEmpty()) {
           // 删除 移除分配的用户关系
           Condition condition = SysUserRole.SYS_USER_ROLE.USER_ID
                   .in(Arrays.stream(delIds.split(",")).collect(Collectors.toSet()))
                   .and(SysUserRole.SYS_USER_ROLE.ROLE_ID.eq(Long.valueOf(roleId)));
           userRoleDao.deleteByCondition(condition);
       }
       if (!addIds.isEmpty()) {
           // 添加 分配角色的用户关系
           List<SysUserRoleDO> list = Arrays.stream(addIds.split(",")).map(id -> {
               SysUserRoleDO userRoleDO = new SysUserRoleDO();
               userRoleDO.setRoleId(Long.valueOf(roleId));
               userRoleDO.setUserId(Long.valueOf(id));
               return userRoleDO;
           }).collect(Collectors.toList());
           userRoleDao.insert(list);
       }
    }
}
