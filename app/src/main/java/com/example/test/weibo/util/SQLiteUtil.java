package com.example.test.weibo.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.test.weibo.praseEntity.User;

/**
 * Created by 13969 on 2018/10/16.
 */

public class SQLiteUtil extends SQLiteOpenHelper {

    SQLiteDatabase sqlDatabase ;
    private static   String db_name = "weibo.db";//自定义的数据库名；
    private static  int db_version =1;//版本号
    private static  String create_db_sql;
    private static   String create_table_sql;

    public SQLiteUtil(Context context) {
        super(context, db_name, null, db_version);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
      String  sql ="create table user(" +
                "phone varchar(30) primary key," +
                "password varchar(30)" +
                 ")";
        db.execSQL(sql);
        String inset = "insert into user(phone,password) values('89255','8955')";
        String inset1 = "insert into user(phone,password) values('123','8955')";
        String inset2 = "insert into user(phone,password) values('88','8955')";
        db.execSQL(inset);
        db.execSQL(inset1);
        db.execSQL(inset2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public User display(){
        sqlDatabase =  this.getReadableDatabase();
        Cursor c=sqlDatabase.query("user", null, null, null, null, null, null);
        Log.i("LQ",c.getCount()+"");
        int n=c.getCount();
        if(c.moveToFirst()){

            //通过getCount()来决定循环的次数getCount()是游标的总数量。
            for (int i = 0; i<n;i++) {
                c.move(i);
                //将游标移动到下一条数据
                Log.i("LQ", c.getCount()+"账号：" +c.getString(c.getColumnIndex("phone")) + " 密码：" + c.getString(c.getColumnIndex("password")));
            }
            }
            return null;
    }

    public void setDBName(String DBName){
        db_name=DBName;
    }
    public  void setVersion(int version){
        db_version=version;
    }
}
