package org.example.androidenterprise.model;

/**
 * Created by sdlds on 2016/10/22.
 */

import java.io.Serializable;

/**
 * 注册之后服务器返回的数据model
 */
public class RegisterResponseEntity implements Serializable{
    private String result; //是否有效
    private int id; //唯一编码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
