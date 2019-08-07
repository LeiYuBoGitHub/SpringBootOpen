package com.lyb.common.result;

/**
 * @Auther: 野性的呼唤
 * @Date: 2018/11/19 18:48
 * @Description:
 */
public enum ErrorEnum {

    MISSING_PARAMETER(10001, "缺少必要参数"),

    TELEPHONE_FORMAT_ERROR(10002, "手机号格式不正确");



    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
