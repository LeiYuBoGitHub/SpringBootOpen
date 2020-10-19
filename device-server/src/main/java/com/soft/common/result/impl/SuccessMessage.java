package com.soft.common.result.impl;


import com.soft.common.result.RestResult;

/**
 * @author 野性的呼唤
 * @Date: 2019/11/22 21:00
 * @Description:
 */
public class SuccessMessage implements RestResult {

    private boolean success = true;

    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
