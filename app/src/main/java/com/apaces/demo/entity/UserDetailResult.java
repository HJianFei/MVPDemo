package com.apaces.demo.entity;

import java.io.Serializable;

/**
 * Created by HJF on 2017/7/1.
 * 描述：
 */

public class UserDetailResult implements Serializable {

    private String nickname;
    private String phone;
    private String email;
    private String avatar;

    public UserDetailResult(String nickname, String phone, String email, String avatar) {
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.avatar = avatar;
    }

    public UserDetailResult() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserDetailResult{" +
                "nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
