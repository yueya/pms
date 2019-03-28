package com.yueya.common.web;

public enum  Code {
    OK(200),FAILER(400),ERROR(500);
    Code(int code){
        this.code=code;
    }
    public int value(){
        return this.code;
    }
    private int code;
}
