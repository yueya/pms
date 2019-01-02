package com.yueya.auth.model;

import org.apache.shiro.session.Session;

import java.util.List;

public class SessionPage {
    private List<Session> list;
    private int count;

    public List<Session> getList() {
        return list;
    }

    public void setList(List<Session> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
