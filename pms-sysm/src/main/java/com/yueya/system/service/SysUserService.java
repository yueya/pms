package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.tables.SysUser;
import com.yueya.system.dao.tables.daos.SysUserDao;
import com.yueya.system.dao.tables.pojos.SysUserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserService extends BaseService {
    @Autowired
    private SysUserDao dao;

    public List<SysUserDO> findAll(){
        return dao.findAll();
    }
    public SysUserDO findByUserName(String userName){
        return dao.fetchOne(SysUser.SYS_USER.LOGIN_NAME,userName);
    }
}
