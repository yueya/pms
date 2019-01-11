package com.yueya.system.security;

import com.yueya.auth.model.Account;
import com.yueya.auth.service.AccountInfoProvider;
import com.yueya.system.dao.tables.pojos.SysPermissionDO;
import com.yueya.system.dao.tables.pojos.SysRoleDO;
import com.yueya.system.dao.tables.pojos.SysUserDO;
import com.yueya.system.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class LoginService implements AccountInfoProvider {

    @Autowired
    private SysUserService userService;
    @Override
    public Account loadAccount(String account) throws AuthenticationException {
        SysUserDO userDO=userService.findByUserName(account);
        if(userDO!=null){
            Account acc=new Account();
            acc.setAccount(userDO.getLoginName());
            acc.setPassword(userDO.getPassword());
            acc.setId(userDO.getUserCode());
            return acc;
        }
        return null;
    }

    @Override
    public boolean checkAccount(String appId) throws AuthenticationException {
        return true;
    }

    @Override
    public Set<String> loadRoles(String userId) {
        List<SysRoleDO> list= userService.findRoles(userId);
        return list.stream().map(r->r.getEnName()).collect(Collectors.toSet());
    }

    @Override
    public Set<String> loadPermissions(String userId,String appCode) {
        List<SysPermissionDO> list=userService.findPermissionsByUser(userId,appCode);
        return list.stream().map(r->r.getIdentification()).collect(Collectors.toSet());
    }
}
