package org.example.androidenterprise.model;

/**
 * Created by chenguojiao : 交易记录请求model.
 */
public class RecordRequestEntity {
    private int User_id;
    private String code;
    private String role;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
