package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.tables.SysUser;
import com.yueya.system.dao.tables.daos.SysPermissionDao;
import com.yueya.system.dao.tables.daos.SysRoleDao;
import com.yueya.system.dao.tables.daos.SysUserDao;
import com.yueya.system.dao.tables.pojos.SysPermissionDO;
import com.yueya.system.dao.tables.pojos.SysRoleDO;
import com.yueya.system.dao.tables.pojos.SysUserDO;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserService extends BaseService {
    @Autowired
    private SysUserDao dao;
    @Autowired
    private SysRoleDao roleDao;
    @Autowired
    private SysPermissionDao permissionDao;
    public List<SysUserDO> findAll(){
        return dao.findAll();
    }
    public SysUserDO findByUserName(String userName){
        return dao.fetchOne(SysUser.SYS_USER.LOGIN_NAME,userName);
    }

    public List<SysRoleDO> findRoles(String userId) {
        return roleDao.fetchByUserId(Long.valueOf(userId));
    }

    public List<SysPermissionDO> findPermissionsByUser(String userId, String appId) {
        return permissionDao.fetchByUser(Long.valueOf(userId),appId);
    }
}
