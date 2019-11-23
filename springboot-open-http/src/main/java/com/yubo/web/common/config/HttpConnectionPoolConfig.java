package com.yubo.web.common.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/11/22 21:39
 * @Description: Http连接池配置类
 */

@Configuration
public class HttpConnectionPoolConfig {

    //最大连接数
    @Value("${http.maxTotal}")
    private Integer maxTotal;

    //支持并发数
    @Value("${http.defaultMaxPerRoute}")
    private Integer defaultMaxPerRoute;

    //连接的超时时间
    @Value("${http.connectTimeout}")
    private Integer connectTimeout;

    //从连接池获取连接的超时时间
    @Value("${http.connectionRequestTimeout}")
    private Integer connectionRequestTimeout;

    //数据传输超时时间
    @Value("${http.socketTimeout}")
    private Integer socketTimeout;

    //提交请求前测试连接是否可用
    @Value("${http.staleConnectionCheckEnabled}")
    private boolean staleConnectionCheckEnabled;

    private static SSLContext sslContext = null;

    static{
        try {
            //信任所有
            sslContext = new SSLContextBuilder().loadTrustMaterial(null, (xcs, string) -> true).build();
        } catch (KeyStoreException | NoSuchAlgorithmException | KeyManagementException ex) {
            ex.printStackTrace();
        }
    }

    @Bean(name = "httpClientConnectionManager")
    public PoolingHttpClientConnectionManager getHttpClientConnectionManager() {
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", new PlainConnectionSocketFactory())
                .register("https", new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.getDefaultHostnameVerifier()))
                .build();

        PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);

        httpClientConnectionManager.setMaxTotal(maxTotal);

        httpClientConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);

        return httpClientConnectionManager;
    }

    /**
     * 实例化连接池,设置连接池管理器
     * 这里需要以参数形式注入上面实例化的连接池管理器
     */
    @Bean(name = "httpClientBuilder")
    public HttpClientBuilder getHttpClientBuilder(@Qualifier("httpClientConnectionManager")PoolingHttpClientConnectionManager httpClientConnectionManager){

        HttpClientBuilder builder = HttpClientBuilder.create();

        builder.setConnectionManager(httpClientConnectionManager);

        return builder;

    }

    /**
     * 注入连接池,用于获取httpClient
     */
    @Bean
    public CloseableHttpClient getCloseableHttpClient(@Qualifier("httpClientBuilder") HttpClientBuilder httpClientBuilder){

        CloseableHttpClient httpClient = httpClientBuilder.build();

        return httpClient;

    }

    /**
     * Builder是RequestConfig的一个内部类
     * 过RequestConfig的custom方法来获取到一个Builder对象
     * 设置builder的连接信息
     * 这里还可以设置proxy,cookieSpec等属性。有需要的话可以在此设置
     */
    @Bean(name = "builder")
    public RequestConfig.Builder getBuilder(){

        RequestConfig.Builder builder = RequestConfig.custom();

        return builder.setConnectTimeout(connectTimeout).

                setConnectionRequestTimeout(connectionRequestTimeout).

                setSocketTimeout(socketTimeout);

    }

    /**
     * 使用builder创建一个RequestConfig对象
     * @param builder
     * @return
     */
    @Bean
    public RequestConfig getRequestConfig(@Qualifier("builder")RequestConfig.Builder builder){

        RequestConfig requestConfig = builder.build();

        return requestConfig;

    }
}
