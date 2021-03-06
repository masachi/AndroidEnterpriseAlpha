package org.example.androidenterprise.model;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by sdlds on 2016/9/26.
 */

/**
 * 用户登陆信息
 */
public class UserInfoEntity implements Serializable {
    private String username; //用户名
    private String password; //密码
    private String device_id; //设备码


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }
}
