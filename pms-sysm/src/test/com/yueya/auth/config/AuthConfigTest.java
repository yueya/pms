package com.yueya.auth.config;

import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthConfigTest {

    @Test
    public void testMatch(){
        PatternMatcher matcher=new AntPathMatcher();
        System.out.println(((AntPathMatcher) matcher).match("http://127.0.0.1:8080/a/login","/a/login"));
    }


}