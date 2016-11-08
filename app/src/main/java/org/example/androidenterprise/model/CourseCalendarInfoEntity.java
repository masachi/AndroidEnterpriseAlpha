package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/5.
 */
public class CourseCalendarInfoEntity implements Serializable {
    private int User_id;
    private String code;

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
