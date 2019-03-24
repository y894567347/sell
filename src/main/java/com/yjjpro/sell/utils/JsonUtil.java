package com.yjjpro.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.GsonBuildConfig;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/9 17:06
 * @Description:
 */
public class JsonUtil {

    public static String toJson(Object object){

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
