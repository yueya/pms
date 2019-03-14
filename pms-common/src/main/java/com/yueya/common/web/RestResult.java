package com.yueya.common.web;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 统一返回对象
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult {
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
    public RestResult(Code code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public static RestResult OK(String msg){
        return new RestResult(Code.OK,msg);
    }
    public static RestResult OkWithData(Object data){
        return new RestResult(Code.OK,"success",data);
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
