package com.power.saas.common;

/**
 * Created by Yan on 2017/9/14.
 */
public class ApiResult<T> {

    private int errorCode;
    private String message;
    private T data;

    public ApiResult(){

    }

    public ApiResult(int errorCode, String message, T data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public ApiResult(T data) {
        this.errorCode = 0;
        this.message = "success";
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
