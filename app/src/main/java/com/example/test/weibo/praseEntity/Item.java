package com.example.test.weibo.praseEntity;

import java.util.ArrayList;

/**
 * Created by 13969 on 2018/10/9.
 */

public class Item {
    private String user_name;
    private String Status;
    private String text;
    private ArrayList<String> img;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getImg() {
        return img;
    }

    public void setImg(ArrayList<String> img) {
        this.img = img;
    }
}
