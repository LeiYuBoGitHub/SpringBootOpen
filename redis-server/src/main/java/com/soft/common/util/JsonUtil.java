package com.soft.common.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/4 14:33
 * @Description:
 */
public class JsonUtil {

    public static String getValue(String json, String keyName){
        String[] key = keyName.split(",");
        JSONObject oba = JSONObject.parseObject(json);
        for (int i = 0;i<key.length-1;i++){
            oba = JSONObject.parseObject(oba.getString(key[i]));
        }
        return oba.getString(key[(key.length)-1]);
    }
}
