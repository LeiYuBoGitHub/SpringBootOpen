package com.soft.common.result;

import com.soft.common.result.impl.ErrorMessage;
import com.soft.common.result.impl.SuccessMessage;
import com.soft.common.result.impl.SuccessResult;

/**
 * @Auther: 野性的呼唤
 * @Date: 2018/11/19 18:47
 * @Description:
 */
public class RestResultFactory {

    public static RestResult successMessage(String message) {
        SuccessMessage result = new SuccessMessage();
        result.setMessage(message);
        return result;
    }

    public static RestResult errorMessage(String message) {
        ErrorMessage result = new ErrorMessage();
        result.setMessage(message);
        return result;
    }

    public static RestResult errorMessage(ResponseCodeEnum responseCodeEnum) {
        ErrorMessage result = new ErrorMessage();
        result.setCode(responseCodeEnum.getCode());
        result.setMessage(responseCodeEnum.getMessage());
        return result;
    }

    public static RestResult errorMessage(ResponseCodeEnum responseCodeEnum, String message) {
        ErrorMessage result = new ErrorMessage();
        result.setCode(responseCodeEnum.getCode());
        result.setMessage(message);
        return result;
    }

    public static <T> RestResult successResult(T data) {
        SuccessResult<T> result = new SuccessResult<>();
        result.setData(data);
        result.setCode(ResponseCodeEnum.SUCCESS.getCode());
        result.setMessage(ResponseCodeEnum.SUCCESS.getMessage());
        return result;
    }

    public static <T> RestResult successResult(ResponseCodeEnum responseCodeEnum) {
        SuccessResult<T> result = new SuccessResult<>();
        result.setCode(responseCodeEnum.getCode());
        result.setMessage(responseCodeEnum.getMessage());
        return result;
    }

    public static <T> RestResult successResult(ResponseCodeEnum responseCodeEnum, T data) {
        SuccessResult<T> result = new SuccessResult<>();
        result.setCode(responseCodeEnum.getCode());
        result.setMessage(responseCodeEnum.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> RestResult successResult(ResponseCodeEnum responseCodeEnum, String message, T data) {
        SuccessResult<T> result = new SuccessResult<>();
        result.setCode(responseCodeEnum.getCode());
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> RestResult successResult(ResponseCodeEnum responseCodeEnum, String message) {
        SuccessResult<T> result = new SuccessResult<>();
        result.setCode(responseCodeEnum.getCode());
        result.setMessage(message);
        return result;
    }

    public static <T> RestResult successResult(T data, String message) {
        SuccessResult<T> result = new SuccessResult<>();
        result.setData(data);
        result.setMessage(message);
        return result;
    }

}
