package com.yueya.system.security;

import com.yueya.auth.model.Account;
import com.yueya.auth.service.AccountInfoProvider;
import com.yueya.system.dao.tables.pojos.SysMenuDO;
import com.yueya.system.dao.tables.pojos.SysRoleDO;
import com.yueya.system.dao.tables.pojos.SysUserDO;
import com.yueya.system.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
            acc.setId(String.valueOf(userDO.getId()));
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
    public Set<String> loadPermissions(String userId) {
        List<SysMenuDO> list=userService.findMenuByUser(userId);
        return list.stream()
                .filter(r -> r.getPermission() != null && !r.getPermission().isEmpty())
                .flatMap(r -> Arrays.stream(r.getPermission().split(",")))
                .collect(Collectors.toSet());
    }
}
