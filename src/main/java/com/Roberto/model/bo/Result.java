package com.Roberto.model.bo;

/**
 * @Classname Result
 * @Description
 * @auther by jano
 * @created 2020-07-06 18:49
 **/
public class Result {
    private Integer code;

    private String message;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
