package com.lyb.common.result;

import com.lyb.common.result.impl.ErrorResultData;
import com.lyb.common.result.impl.SuccessResultData;

/**
 * @Auther: 野性的呼唤
 * @Date: 2018/11/19 18:47
 * @Description:
 */
public class ResultDataFactory {

    public static <T> ResultData createErrorData(int code, String msg) {
        ErrorResultData result = new ErrorResultData();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> ResultData createErrorData(String msg) {
        ErrorResultData result = new ErrorResultData();
        result.setMsg(msg);
        return result;
    }

    public static <T> ResultData createSuccessData(T data) {
        SuccessResultData<T> result = new SuccessResultData<>();
        result.setData(data);
        return result;
    }

    public static <T> ResultData createSuccess(String msg) {
        SuccessResultData<T> result = new SuccessResultData<>();
        result.setMsg(msg);
        return result;
    }

    public static <T> ResultData createSuccess(String msg, boolean success) {
        SuccessResultData<T> result = new SuccessResultData<>();
        result.setMsg(msg);
        result.setSuccess(success);
        return result;
    }

    public static <T> ResultData createMessage(String msg, boolean success) {
        SuccessResultData<T> result = new SuccessResultData<>();
        result.setMsg(msg);
        result.setSuccess(success);
        return result;
    }

    public static <T> ResultData createSuccessData(T data, String msg) {
        SuccessResultData<T> result = new SuccessResultData<>();
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static <T> ResultData createSuccessData(T data, String msg, int code) {
        SuccessResultData<T> result = new SuccessResultData<>();
        result.setData(data);
        result.setMsg(msg);
        result.setCode(code);
        return result;
    }

}
