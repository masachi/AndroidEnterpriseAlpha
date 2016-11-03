package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/1.
 */
public class InstrumentInfoEntity implements Serializable {
    private int id; //学生的id
    private String role; //用户的身份
    private String code;//api的code
    private int maxtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMaxtime() {
        return maxtime;
    }

    public void setMaxtime(int maxtime) {
        this.maxtime = maxtime;
    }
}
