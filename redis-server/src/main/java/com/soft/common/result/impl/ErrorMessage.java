package com.soft.common.result.impl;

import com.soft.common.result.RestResult;

/**
 * @Auther: 野性的呼唤
 * @Date: 2018/11/19 18:48
 * @Description:
 */
public class ErrorMessage implements RestResult {

    private boolean success = false;

    /**
     * 返回状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

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
}
