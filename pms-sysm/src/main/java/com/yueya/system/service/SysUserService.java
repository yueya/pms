package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.model.UserInfo;
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
public class SysUserService extends BaseService<SysUserDO> {
    @Autowired
    private SysUserDao dao;
    @Autowired
    private SysRoleDao roleDao;
    @Autowired
    private SysPermissionDao permissionDao;
    public SysUserDO findById(String id){
        return dao.fetchOne(SysUser.SYS_USER.ID,Long.valueOf(id));
    }
    public UserInfo info(String id){
        return dao.fetchUserInfo(Long.valueOf(id));
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
    public void insert(SysUserDO userDO){
        dao.insert(userDO);
    }

    public void delete(long id){
        dao.deleteById(id);
    }
    public void update(SysUserDO userDO){
        dao.update(userDO);
    }

    public List<SysUserDO> page(int offset,int limit,List<Condition> conditions){
        return dao.page(offset,limit,conditions);
    }

    @Override
    public List<Condition> getConditions(SysUserDO userDO) {
        return null;
    }
}
