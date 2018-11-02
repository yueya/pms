package com.yueya.auth.service;

import com.yueya.auth.model.Account;
import org.apache.shiro.authc.AuthenticationException;

import java.util.Set;

public interface AccountInfoProvider {
    /**
     * 根据用户名获取账号信息
     * @param account
     * @return
     * @throws AuthenticationException
     */
    public Account loadAccount(String account) throws AuthenticationException;
    /**
     * 检查账号是否正常
     * <br>如果返回false或抛出AuthenticationException则不予通过认证
     * @param appId 客户标识
     */
    public boolean checkAccount(String appId) throws AuthenticationException;
    /**
     * 根据客户标识加载持有角色
     * @param appId 客户标识
     * @return 角色列表
     */
    public Set<String> loadRoles(String appId);
    public Set<String> loadPermissions(String appId);
}
