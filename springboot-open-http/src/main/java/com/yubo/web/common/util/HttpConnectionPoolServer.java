package com.yubo.web.common.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/11/22 21:37
 * @Description: Http 连接池
 */
@Component
public class HttpConnectionPoolServer {

    @Resource
    private CloseableHttpClient httpClient;

    @Resource
    private RequestConfig requestConfig;

    /**

     * 发送httpGet请求

     * @param url

     * @return

     */

    public String get(String url){

        String result =null;

        HttpGet httpGet = new HttpGet(url);

        httpGet.setConfig(requestConfig);

        CloseableHttpResponse response = null;

        try{
            response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() == 200){
                result = EntityUtils.toString(response.getEntity(),"UTF-8");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
