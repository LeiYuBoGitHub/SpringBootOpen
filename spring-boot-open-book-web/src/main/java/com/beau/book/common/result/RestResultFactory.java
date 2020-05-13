package com.beau.book.common.result;

import com.beau.book.common.result.impl.SuccessMessage;
import com.beau.book.common.result.impl.SuccessResult;

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

    public static <T> RestResult successResult(T data) {
        SuccessResult<T> result = new SuccessResult<>();
        result.setData(data);
        return result;
    }

    public static <T> RestResult successResult(T data, String message) {
        SuccessResult<T> result = new SuccessResult<>();
        result.setData(data);
        result.setMessage(message);
        return result;
    }

}
