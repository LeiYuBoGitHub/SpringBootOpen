package com.yubo.web.common.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/11/22 21:35
 * @Description:
 */
public class HttpUtil {

    public static CloseableHttpClient httpClient =  HttpClients.createDefault();

    private static final String UTF_8 = "UTF-8";

    public static String getHttpString(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response != null) {
                return EntityUtils.toString(response.getEntity(),HttpUtil.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getHttpStringPlus(String url) {
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response != null) {
                return EntityUtils.toString(response.getEntity(),HttpUtil.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
