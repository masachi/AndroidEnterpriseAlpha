package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by sdlds on 2016/10/8.
 */

/**
 * 服务器返回数据
 */
public class LoginResponseEntity implements Serializable {
    private int status_code;  //返回码
    private String message;  //返回信息

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
