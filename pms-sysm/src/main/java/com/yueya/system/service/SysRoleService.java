package com.yueya.system.service;

import com.yueya.common.base.BaseService;
import com.yueya.system.dao.tables.daos.SysRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService extends BaseService {
    @Autowired
    private SysRoleDao sysRoleDao;
}
