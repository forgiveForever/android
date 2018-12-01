package com.example.test.weibo.praseEntity;

public class DynamicInfo {

    private Long id;
    private String dynamic_info;
    private int power;
    private String user_id;
    private String img_path;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDynamic_info() {
        return dynamic_info;
    }

    public void setDynamic_info(String dynamic_info) {
        this.dynamic_info = dynamic_info;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }
}
