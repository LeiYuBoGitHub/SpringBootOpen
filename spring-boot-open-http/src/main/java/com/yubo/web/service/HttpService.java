package com.yubo.web.service;

/**
 * @Authour: 野性的呼唤
 * @Create: 2019/11/22 22:11
 * @Description:
 */
public interface HttpService {

    String post(String url, String json);

    String get(String url);

    String defaultGet(String url);

    String defaultGetPlus(String url);
}
