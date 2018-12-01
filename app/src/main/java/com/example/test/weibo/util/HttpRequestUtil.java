package com.example.test.weibo.util;

import java.util.Map;

/**
 * Created by 13969 on 2018/9/18.
 */

public class HttpRequestUtil {
    public static String GetHttp(final String url, final Map<String, String> paramsMap){

        return  selectHttp(url,paramsMap,"GET");

    }

    public static String PostHttp(final String url, final Map<String, String> paramsMap){
        return  selectHttp(url,paramsMap,"POST");


    }


    private static String selectHttp(final String url, final Map<String, String> paramsMap, String Http_Method){
        HttpThreadDeal getHttp = new HttpThreadDeal(url,paramsMap,Http_Method);
        getHttp.start();
        try {
            getHttp.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getHttp.getJson();
    }
}
