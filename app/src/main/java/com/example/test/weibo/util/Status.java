package com.example.test.weibo.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.test.weibo.praseEntity.User;

/**
 * Created by 13969 on 2018/10/23.
 */

public class Status {
    public  static  void setStatus(Context context,String phone,String password){
        SharedPreferences sharedPreferences = context.getSharedPreferences("userConfig", Context.MODE_PRIVATE);
        //获取editor对象
        SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
        //存储键值对
        editor.putString("phone",phone);
        editor.putString("password",password);
        //提交
        editor.commit();//提交修改

    }


    public  static User getStatus(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("userConfig", Context.MODE_PRIVATE);
          User user =new User();
          user.setPass_word(sharedPreferences.getString("password",null));
          user.setPhone_id(sharedPreferences.getString("phone",null));
         return  user;
    }
}
