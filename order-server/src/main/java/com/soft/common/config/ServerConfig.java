package com.soft.common.config;

/**
 * @author 野性的呼唤
 * @Date: 2020/7/27 15:31
 * @Description:
 */
public class ServerConfig {

    /**
     * 开启饮水器地址
     */
    public static final String ALI_PAY_OPEN_HOT_URL = "http://47.97.82.151:8491/dc/api/aliPayOpen";

    //public static final String ALI_PAY_OPEN_HOT_URL = "http://127.0.0.1:8492/dc/api/aliPayOpen";

    /**
     * 开启饮水器地址
     */
    public static final String OPEN_HOT_URL = "https://cloud.zjbaitu.cn/hot-server/";

    /**
     * 开启吹风机地址
     */
    public static final String OPEN_BLOW_URL = "http://127.0.0.1:/hot-server/";

    /**
     * 开启壁挂机地址
     */
    public static final String OPEN_WALL_URL = "http://127.0.0.1:/wall-server/";


    /**
     * 多彩服务器Token地址 开发环境
     */
    public static final String TOKEN_URL_DEV = "http://ex-test-open-device-app.168cad.top/dcxy/hd/api/v1/accessToken";

    /**
     * 多彩服务器Token地址 测试环境
     */
    public static final String TOKEN_URL_PROD = "http://open-device-app.dcrym.com/dcxy/hd/api/v1/accessToken";



}
