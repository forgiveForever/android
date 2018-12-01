package com.example.test.weibo.view.system;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.test.weibo.R;
import com.example.test.weibo.util.HttpRequestUtil;
import com.example.test.weibo.util.SQLiteUtil;
import com.example.test.weibo.view.WeiBoMain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 13969 on 2018/9/28.
 */

public class WeiBoLogin extends AppCompatActivity {
    private EditText user;
    private EditText password;
    private static TextView status;
    private Button login;
    private TextView register;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.weibo_login);
        user=(EditText) findViewById(R.id.user);
         password=(EditText) findViewById(R.id.password);
        status=(TextView) findViewById(R.id.status);
        register=(TextView) findViewById(R.id.Register_btn);
        register.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(WeiBoLogin.this,WeiBoRegister.class);
                startActivity(intent);
            }
        });
        login=(Button) findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 SQLiteUtil sqLiteUtil=new SQLiteUtil(WeiBoLogin.this);
                SQLiteDatabase sdb=sqLiteUtil.getReadableDatabase();
                String sql="select * from user where phone=? and password=?";
                Cursor cursor=sdb.rawQuery(sql, new String[]{user.getText().toString().trim(),password.getText().toString().trim()});
                if(cursor.moveToFirst()==true){
                    cursor.close();
                    Intent intent =new Intent(WeiBoLogin.this,WeiBoMain.class);
                    startActivity(intent);
                }else{
                    status.setText("账号或者密码错误！");
                }
               // PostHttp();
              //WeiBoLogin.postHttp(phone_id,pass_word);
            }
        });


    }

  /*
  *http请求
  * */
    /*public void PostHttp(){
        String phone_id=  user.getText().toString();
        String pass_word=password.getText().toString();
        Map<String,String> prams= new HashMap<String, String>();
        prams.put("phone_id",phone_id);
        prams.put("pass_word",pass_word);

        String str=    HttpRequestUtil.PostHttp("http://10.0.2.2:3303/weibo/vaild/Login",prams);
        Log.i("LQ","打印响应的数据：" + str);
        if(str.equalsIgnoreCase("true")){
            Intent intent =new Intent(this,WeiBoMain.class);
            startActivity(intent);

        }else {
            status.setText("账号或者密码错误！");
        }
    }
*/

   /* public static void postHttp(String phone_id,String  pass_word){
        //JSON.parseObject(,PraseEntity.class);
        final OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("phone_id",phone_id);
        builder.add("pass_word",pass_word);

        RequestBody formBody = builder.build();
        Request request = new Request.Builder()
                .url("http://10.0.2.2:3303/weibo/vaild/Login")
                .post(formBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                //if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
             String str=   response.body().string();

                Log.i("LQ","打印GET响应的数据：" + str);

            }
        });
    }*/


}
