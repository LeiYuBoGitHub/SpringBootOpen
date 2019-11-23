package com.yubo.web.service;

import java.util.stream.Stream;

/**
 * @Authour: 野性的呼唤
 * @Create: 2019/11/22 22:11
 * @Description:
 */
public interface HttpService {

    String get(String url);

    String defaultGet(String url);

    String defaultGetPlus(String url);
}
