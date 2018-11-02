package com.yueya.auth.realm;

import com.yueya.auth.config.MessageConfig;
import com.yueya.auth.model.Account;
import com.yueya.auth.service.AccountInfoProvider;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import java.util.Set;

public class AccountRealm extends AuthorizingRealm {

    private AccountInfoProvider provider;
    private MessageConfig messageConfig;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String account = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        Set<String> roles = provider.loadRoles(account);
        Set<String> permissions = provider.loadPermissions(account);
        if(null!=roles&&!roles.isEmpty())
            info.setRoles(roles);
        if(null!=permissions&&!permissions.isEmpty())
            info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if(null==token.getPrincipal()||null==token.getCredentials()){
            throw new AuthenticationException(messageConfig.getMsgAccountPasswordEmpty());
        }
        String account = (String) token.getPrincipal();
        Account accountEntity = provider.loadAccount(account);
        if (null == accountEntity) {
            throw new AuthenticationException(messageConfig.getMsgAccountNotExist());
        }
        return new SimpleAuthenticationInfo(account,accountEntity.getPassword(), getName());
    }

    public void setProvider(AccountInfoProvider provider) {
        this.provider = provider;
    }

    public MessageConfig getMessageConfig() {
        return messageConfig;
    }

    public void setMessageConfig(MessageConfig messageConfig) {
        this.messageConfig = messageConfig;
    }
}
