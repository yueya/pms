package com.yueya.auth.utils;

import com.yueya.auth.realm.Principal;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInfoUtil{
    private static Logger logger = LoggerFactory.getLogger(UserInfoUtil.class);
    /**
     * 获取当前登录者对象
     */
    public static Principal getPrincipal(){
        try{
            Subject subject = SecurityUtils.getSubject();
            Principal principal = (Principal)subject.getPrincipal();
            if (principal != null){
                return principal;
            }
        }catch (InvalidSessionException | UnavailableSecurityManagerException e) {
            logger.error("获取信息异常",e);
        }
        return null;
    }
}
