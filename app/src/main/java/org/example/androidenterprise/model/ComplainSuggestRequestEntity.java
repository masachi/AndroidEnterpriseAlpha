package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/7.
 */
public class ComplainSuggestRequestEntity implements Serializable {
    private String User_id;
    private int Type;
    private String Content;

    public String getUser_id() {
        return User_id;
    }

    public void setUser_id(String user_id) {
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
