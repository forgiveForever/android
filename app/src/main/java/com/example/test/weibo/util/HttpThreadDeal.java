package com.example.test.weibo.util;


import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by 13969 on 2018/9/20.
 */

public class HttpThreadDeal extends Thread {
    private  final OkHttpClient client = new OkHttpClient();
    private Map<String,String> paramsMap;
    private String url;
    private String json;
    private String Http_Method;



    @Override
    public void run() {
 if("GET".equalsIgnoreCase(Http_Method)){
     GET();
 }
        if("POST".equalsIgnoreCase(Http_Method)){
            POST();
        }
    }
    public String getJson() {
        return this.json;
    }



    public HttpThreadDeal(String url, Map<String, String> paramsMap, String Http_Method) {
        this.paramsMap = paramsMap;
        this.url = url;
        this.Http_Method=Http_Method;
    }

    public Map<String, String> getParamsMap() {
        return paramsMap;
    }

    public void setParamsMap(Map<String, String> paramsMap) {
        this.paramsMap = paramsMap;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }




    public void POST(){
        StringBuilder tempParams = new StringBuilder();
        RequestBody formBody = null;

        try {
            if(!paramsMap.isEmpty()){
                //处理参数

                //创建一个请求实体对象 RequestBody
                FormBody.Builder builder = dealPostPrams();


            formBody = builder.build();
                //补全请求地址
            }

            //创建一个请求
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();


            //创建一个Call
            final Call call = client.newCall(request);
            //执行请求
            final Response response = call.execute();
            if (response.isSuccessful())
                json = response.body().string();


        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }




    public void GET(){

        StringBuilder tempParams;
        String requestUrl;
        try {
            if(!paramsMap.isEmpty()){
                //处理参数
                tempParams = dealGetPrams();
                //补全请求地址
                requestUrl = String.format("%s?%s",url, tempParams.toString());
            }else{
                requestUrl=url;
            }

            //创建一个请求
            Request request = new Request.Builder()
                    .url(requestUrl)
                    .build();

            //创建一个Call
            final Call call = client.newCall(request);
            //执行请求
            final Response response = call.execute();
            if (response.isSuccessful())
                json = response.body().string();


        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }


    private StringBuilder dealGetPrams() {
        StringBuilder tempParams = new StringBuilder();
        int pos = 0;
        for (String key : paramsMap.keySet()) {
            if (pos > 0) {
                tempParams.append("&");
            }
            //对参数进行URLEncoder
            try {
                tempParams.append(String.format("%s=%s", key, URLEncoder.encode(paramsMap.get(key), "utf-8")));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            pos++;
        }
        return tempParams;
    }


    private FormBody.Builder  dealPostPrams() {
        FormBody.Builder builder = new FormBody.Builder();

        for (String key : paramsMap.keySet()) {

            builder.add(key,paramsMap.get(key));
        }
        return builder;
    }
}
