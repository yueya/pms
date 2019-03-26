package com.yueya.auth.realm;

import com.yueya.auth.config.AuthProperties;
import com.yueya.auth.config.MessageConfig;
import com.yueya.auth.model.Account;
import com.yueya.auth.service.AccountInfoProvider;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

import static com.yueya.auth.utils.CredentialsHelper.HASH_ALGORITHM;
import static com.yueya.auth.utils.CredentialsHelper.HASH_INTERATIONS;

public class AccountRealm extends AuthorizingRealm {
    private AccountInfoProvider provider;
    private MessageConfig messageConfig;
    private AuthProperties properties;
    public AccountRealm(){
        initCredentialsMatcher();
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Principal principal = (Principal) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        Set<String> roles = provider.loadRoles(principal.getId());
        Set<String> permissions = provider.loadPermissions(principal.getId());
        if(null != roles && !roles.isEmpty()){
            info.setRoles(roles);
        }
        if(null != permissions && !permissions.isEmpty()){
            permissions.stream().forEach(r -> info.addStringPermission(r));
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if(null==token.getPrincipal() || null==token.getCredentials()){
            throw new AuthenticationException(messageConfig.getMsgAccountPasswordEmpty());
        }
        String account = (String) token.getPrincipal();
        Account accountEntity = provider.loadAccount(account);
        if (null == accountEntity) {
            throw new AuthenticationException(messageConfig.getMsgAccountNotExist());
        }
        //盐就是密码的前16位
        byte[] salt = Hex.decode(accountEntity.getPassword().substring(0,16));
        return new SimpleAuthenticationInfo(new Principal(accountEntity.getId(),accountEntity.getAccount()),
                accountEntity.getPassword().substring(16),
                new ShiroByteSource(ByteSource.Util.bytes(salt)),
                getName());
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
    /**
     * 设定密码校验的Hash算法与迭代次数
     */
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(HASH_ALGORITHM);
        matcher.setHashIterations(HASH_INTERATIONS);
        setCredentialsMatcher(matcher);
    }

    public void setProperties(AuthProperties properties) {
        this.properties = properties;
    }


}
