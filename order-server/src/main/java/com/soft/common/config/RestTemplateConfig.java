package com.soft.common.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author 野性的呼唤
 * @Date: 2020/7/22 15:11
 * @Description:
 */
@Configuration
public class RestTemplateConfig {

    private static final Integer MAX_TOTAL = 500;

    private static final Integer DEFAULT_MAX_PER_ROUTE = 300;

    /**
     * 连接超时时间 单位毫秒
     */
    private static final Integer CONNECT_TIMEOUT = 10000;

    /**
     * 获得一个connection的超时时间 单位毫秒
     */
    private static final Integer CONNECTION_REQUEST_TIMEOUT = 500;

    /**
     * 请求获取数据的超时时间 单位毫秒 如果访问一个接口 多少时间内无法返回数据 就直接放弃此次调用
     */
    private static final Integer SOCKET_TIMEOUT = 15000;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory());
        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();

        //重新设置StringHttpMessageConverter字符集为UTF-8，解决中文乱码问题
        HttpMessageConverter<?> converterTarget = null;
        for (HttpMessageConverter<?> item : converterList) {
            if (StringHttpMessageConverter.class == item.getClass()) {
                converterTarget = item;
                break;
            }
        }
        if (null != converterTarget) {
            converterList.remove(converterTarget);
        }
        converterList.add(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory httpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory(httpClient());
    }
    @Bean
    public CloseableHttpClient httpClient() {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        connectionManager.setMaxTotal(MAX_TOTAL);
        connectionManager.setDefaultMaxPerRoute(DEFAULT_MAX_PER_ROUTE);
        connectionManager.setValidateAfterInactivity(10000);
        RequestConfig requestConfig = RequestConfig.custom()
                // 服务器返回数据(response)的时间，超过抛出read timeout
                .setSocketTimeout(SOCKET_TIMEOUT)
                // 连接上服务器(握手成功)的时间，超出抛出connect timeout
                .setConnectTimeout(CONNECT_TIMEOUT)
                // 从连接池中获取连接的超时时间，超时间未拿到可用连接，会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                .build();
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .build();
    }

}
