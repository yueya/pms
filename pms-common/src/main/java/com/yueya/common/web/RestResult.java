package com.yueya.common.web;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 统一返回对象
 */
public class RestResult {
    public static final String SUCCESS = "success";
    public static final String FAILER = "failer";
    public static final String ERROR = "error";
    private Code code;
    private String msg;
    private Object data;

    public RestResult(){

    }
    public RestResult(Code code,String msg,Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }
    private RestResult(Code code,String... msg){
        this.code=code;
        switch (code) {
            case OK: this.msg = msg.length == 0 ? SUCCESS : msg[0];
            break;
            case FAILER: this.msg = msg.length == 0 ? FAILER : msg[0];
            break;
            case ERROR: this.msg = msg.length == 0 ? ERROR : msg[0];
            break;
        }
    }
    public static RestResult OK(String... msg){
        return new RestResult(Code.OK,msg);
    }
    public static RestResult OkWithData(Object data){
        return new RestResult(Code.OK,SUCCESS,data);
    }
    public static RestResult ERROR(String msg){
        return new RestResult(Code.ERROR,msg);
    }
    public static RestResult FAILER(String msg){
        return new RestResult(Code.FAILER,msg);
    }

    public static RestResult OKWithPage(Object list, long count) {
        return OkWithData(new RestPage(list,count));
    }

    @JsonGetter("code")
    public int getCode() {
        return code.value();
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
