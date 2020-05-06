package com.yubo.book.common.result.impl;

import com.yubo.book.common.result.RestResult;

/**
 * @Auther: 野性的呼唤
 * @Date: 2018/11/19 17:57
 * @Description:
 */
public class SuccessResult<T> implements RestResult {

    private boolean success = true;

    private T data;

    private String message;

    private Integer code;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
