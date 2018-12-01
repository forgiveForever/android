package com.example.test.weibo.view.system;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.test.weibo.R;
import com.example.test.weibo.praseEntity.User;
import com.example.test.weibo.util.HttpRequestUtil;
import com.example.test.weibo.util.SQLiteUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 13969 on 2018/9/29.
 */

public class WeiBoRegister extends AppCompatActivity {
    private EditText phoneId;
    private TextView login;

    private EditText password;
    private static TextView status;
    private Button register;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.weibo_register);
        phoneId=(EditText) findViewById(R.id.user);
        password=(EditText) findViewById(R.id.password);
        status=(TextView) findViewById(R.id.status);
        login =(TextView) findViewById(R.id.close_btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        register=(Button) findViewById(R.id.register_btn);
        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               boolean flag= register(phoneId.getText().toString().trim(),password.getText().toString().trim());
                if(flag){
                    status.setText("注册成功,返回登陆");
                }else{
                    status.setText("注册失败请重试");
                }
               //postHttp();
            }
        });
    }

    public boolean register(String phone,String password){
        SQLiteUtil sqLiteUtil=new SQLiteUtil(WeiBoRegister.this);
        SQLiteDatabase sdb=sqLiteUtil.getReadableDatabase();

        String sql="select * from user where phone=? and password=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{phone,password});
        if(cursor.moveToFirst()==false){
            cursor.close();
            String sql1="insert into user(phone,password) values(?,?)";
            Object obj[]={phone,password};
            sdb.execSQL(sql1, obj);
            return true;
        }
        return false;

    }
   /* public void postHttp(){
        String pass_word=password.getText().toString();
        String phone_id=phoneId.getText().toString();
        if(!pass_word.isEmpty()&&!phone_id.isEmpty()){
            Map<String,String> map=new HashMap<>();
            map.put("pass_word",pass_word);
            map.put("phone_id",phone_id);

        User user=    JSON.parseObject( HttpRequestUtil.PostHttp("http://10.0.2.2:3303/weibo/vaild/Register",map),User.class);
            status.setText(user.toString());
       }
        else {
            status.setText("账号或密码非空！");
        }
    }*/
}
