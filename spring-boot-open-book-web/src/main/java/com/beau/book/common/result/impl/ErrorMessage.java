package com.beau.book.common.result.impl;

import com.beau.book.common.result.RestResult;

/**
 * @Auther: 野性的呼唤
 * @Date: 2020/5/14 17:31
 * @Description:
 */
public class ErrorMessage implements RestResult {

    private boolean success = false;

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
