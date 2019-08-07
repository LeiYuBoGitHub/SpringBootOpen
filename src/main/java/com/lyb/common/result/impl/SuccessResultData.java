package com.lyb.common.result.impl;

import com.lyb.common.result.ResultData;

/**
 * @Auther: 野性的呼唤
 * @Date: 2018/11/19 17:57
 * @Description:
 */
public class SuccessResultData <T> implements ResultData {

    private boolean success = true;

    private T data;

    private String msg;

    private Integer code;

    public SuccessResultData () {}

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
