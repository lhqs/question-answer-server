package cn.lhqs.middle.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * author : lhqs
 * description : 通用返回数据格式
 * createTime : 2018-05-24 14:09
 * version : 1.0
 */
public class ReturnResult implements Serializable{
    private static final long serialVersionUID = -3100630958373978641L;
    private int code = 20000;
    private String message;
    private Object data;
    public static final ReturnResult ok = new ReturnResult(20000,"success");
    public static final ReturnResult fail = new ReturnResult(-1,"failure");

    public ReturnResult() {
    }

    public ReturnResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ReturnResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
