package com.yubo.web.common.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/11/22 21:37
 * @Description: Http连接池
 */
@Component
public class HttpConnectionPoolServer {

    @Resource
    private CloseableHttpClient httpClient;

    @Resource
    private RequestConfig requestConfig;

    /**
     * 发送HttpGet请求
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

    /**
     * 发送HttpPost请求
     */
    public String post(String url, Map<String, Object> param){

        String result = null;

        HttpPost httpPost = new HttpPost(url);
        //4、设置请求消息头，为表单方式提交
        httpPost.setHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        List<NameValuePair> paramList = new ArrayList<>();

        Set<String> keySet = param.keySet();

        NameValuePair pair;

        for(String key : keySet){
            pair = new BasicNameValuePair(key, param.get(key).toString());
            paramList.add(pair);
        }

        UrlEncodedFormEntity entity;
        CloseableHttpResponse response;

        try {

            entity = new UrlEncodedFormEntity(paramList);
            httpPost.setEntity(entity);
            response = httpClient.execute(httpPost);
            if(response.getStatusLine().getStatusCode() == 200){
                result = EntityUtils.toString(response.getEntity(),"UTF-8");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    public String post(String url, String param) {

        String result = null;

        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(param,"UTF-8");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(entity);

        CloseableHttpResponse response;
        try {
            response = httpClient.execute(httpPost);
            if(response.getStatusLine().getStatusCode() == 200){
                result = EntityUtils.toString(response.getEntity(),"UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
