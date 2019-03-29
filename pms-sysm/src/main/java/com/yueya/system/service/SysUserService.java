package com.yueya.system.service;

import com.yueya.auth.utils.CredentialsHelper;
import com.yueya.common.base.BaseService;
import com.yueya.common.util.DateUtils;
import com.yueya.system.dao.dto.UserInfo;
import com.yueya.system.dao.tables.SysUser;
import com.yueya.system.dao.tables.daos.SysMenuDao;
import com.yueya.system.dao.tables.daos.SysRoleDao;
import com.yueya.system.dao.tables.daos.SysUserDao;
import com.yueya.system.dao.tables.pojos.SysMenuDO;
import com.yueya.system.dao.tables.pojos.SysRoleDO;
import com.yueya.system.dao.tables.pojos.SysUserDO;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SysUserService extends BaseService<SysUserDO> {
    @Autowired
    private SysUserDao dao;
    @Autowired
    private SysRoleDao roleDao;
    @Autowired
    private SysMenuDao menuDao;
    public SysUserDO findById(String id){
        return dao.fetchOne(SysUser.SYS_USER.ID,Long.valueOf(id));
    }
    public UserInfo info(String loginName){
        return dao.fetchUserInfo(loginName);
    }
    public SysUserDO findByUserName(String userName){
        Condition condition = SysUser.SYS_USER.LOGIN_NAME.eq(userName)
                .and(SysUser.SYS_USER.DEL_FLAG.eq(DEL_FLAG_NORMAL));
        List<SysUserDO> list =  dao.fetchByCondition(condition);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    public List<SysRoleDO> findRoles(String userId) {
        return roleDao.fetchByUserId(Long.valueOf(userId));
    }

    public List<SysMenuDO> findPermissionsByUser(String userId) {
        return menuDao.fetchMenusByUserId(Long.valueOf(userId));
    }
    public void insert(SysUserDO userDO){
        if(userDO.getPassword() != null){
            //密码加密
            userDO.setPassword(CredentialsHelper.entryptCredentials(userDO.getPassword()));
        }
        //设置一个用户的唯一标识码，暂时没什么用
        userDO.setUserCode(UUID.randomUUID().toString().replace("-",""));
        userDO.setGmtCreate(DateUtils.getCurTimeStamp());
        userDO.setDelFlag(DEL_FLAG_NORMAL);
        dao.insert(userDO);
    }

    public void delete(String ids){
        List<Long> list= Arrays.stream(ids.split(","))
                .map(r->Long.valueOf(r)).collect(Collectors.toList());
        Condition condition = SysUser.SYS_USER.ID.in(list);
        SysUserDO userDO = new SysUserDO();
        userDO.setDelFlag(DEL_FLAG_DEL);
        dao.updateByCondition(userDO,condition);
    }
    public void update(SysUserDO userDO){
        if(userDO.getPassword() != null){
            //密码加密
            userDO.setPassword(CredentialsHelper.entryptCredentials(userDO.getPassword()));
        }
        userDO.setGmtModified(DateUtils.getCurTimeStamp());
        dao.update(userDO);
    }

    public List<SysUserDO> page(int offset,int limit,SysUserDO userDO){
        List<SysUserDO> list = dao.page(offset,limit,getConditions(userDO));
        for (SysUserDO item: list) {
            item.setPassword(null);
        }
        return list;
    }

    @Override
    public List<Condition> getConditions(SysUserDO userDO) {
        Condition condition = SysUser.SYS_USER.DEL_FLAG.eq(DEL_FLAG_NORMAL);
        return Collections.singletonList(condition);
    }

    public long countByCondition(SysUserDO userDO) {
        return dao.countByCondition(getConditions(userDO));
    }
}
