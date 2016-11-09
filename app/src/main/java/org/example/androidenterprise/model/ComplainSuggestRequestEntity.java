package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by chenguojiao on 2016/11/7.投诉建议请求
 */
public class ComplainSuggestRequestEntity implements Serializable {
    private int User_id;
    private int Type;
    private String Content;

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
