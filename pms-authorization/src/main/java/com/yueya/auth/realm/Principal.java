package com.yueya.auth.realm;

import java.io.Serializable;

public class Principal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id; // 用户id
    private String userName; // 登录名
    private String name; // 姓名
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Principal(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }
}
