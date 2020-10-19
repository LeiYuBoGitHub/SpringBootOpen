package com.soft.common.result.restful;

/**
 * @author 野性的呼唤
 * @Date: 2020/5/27 15:44
 * @Description:
 */
public enum ResponseCodeEnum {

    /**
     * 成功返回
     */
    SUCCESS(1000, "success"),

    /**
     * 失败
     */
    FAIL(2000, "fail"),

    /**
     * 请求失败
     */
    REQUEST_FAIL(2001, "请求失败"),

    /**
     * 缺少参数
     */
    LACK_PARAMETER(1001, "缺少参数"),

    /**
     * 获取资源不存在
     */
    RESOURCES_NOT_EXIST(1002, "获取信息失败"),

    /**
     * 设备不存在
     */
    MACHINE_NOT_EXIST(1003, "设备不存在"),

    /**
     * 所有无法识别的异常默认的返回状态码
     */
    SERVICE_ERROR(5000, "服务器异常");

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回信息
     */
    private String message;

    ResponseCodeEnum(int code, String message) {
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
}
