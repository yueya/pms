package com.yueya.auth.realm;

import com.yueya.auth.token.JwtToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Map;
import java.util.Set;

public class JwtRealm extends AuthorizingRealm {

    public Class<?> getAuthenticationTokenClass() {
        //此Realm只支持JwtToken
        return JwtToken.class;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String payload = (String) principals.getPrimaryPrincipal();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if(!(token instanceof JwtToken)) return null;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return null;
    }
}
