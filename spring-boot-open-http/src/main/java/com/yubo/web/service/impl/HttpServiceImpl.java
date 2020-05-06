package com.yubo.web.service.impl;

import com.yubo.web.common.util.HttpConnectionPoolServer;
import com.yubo.web.common.util.HttpUtil;
import com.yubo.web.service.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/11/22 22:08
 * @Description:
 */

@Service
public class HttpServiceImpl implements HttpService {

    @Resource
    HttpConnectionPoolServer httpConnectionPoolServer;

    public String post(String url, String json) {
        return httpConnectionPoolServer.post(url, json);
    }

    public String get(String url) {
        return httpConnectionPoolServer.get(url);
    }

    public String defaultGet(String url) {
        return HttpUtil.getHttpString(url);
    }

    public String defaultGetPlus(String url) {
        return HttpUtil.getHttpStringPlus(url);
    }
}
