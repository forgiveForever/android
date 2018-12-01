package com.example.test.weibo.praseEntity;

/**
 * Created by 13969 on 2018/9/28.
 */

public class BaseEntity {
    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }

    private Long id ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
