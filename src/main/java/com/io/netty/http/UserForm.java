package com.io.netty.http;

import java.io.Serializable;

/**
 * @version 1.0
 * @description: TODO
 * @author: sw
 * @date 2022-03-16
 */

public class UserForm implements Serializable {
    private static final long serialVersionUID = 7991520022243352291L;
    private Long userId;
    private String userName;
    private Integer age;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
