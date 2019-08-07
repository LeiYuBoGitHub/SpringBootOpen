package com.lyb.common.result.impl;

import com.lyb.common.result.ResultData;

/**
 * @Auther: 野性的呼唤
 * @Date: 2018/11/19 18:48
 * @Description:
 */
public class ErrorResultData implements ResultData {

    private boolean success = false;

    private String msg;

    private int code;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
