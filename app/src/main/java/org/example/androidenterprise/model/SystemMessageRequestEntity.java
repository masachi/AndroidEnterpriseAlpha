package org.example.androidenterprise.model;

/**
 * Created by xiaohua on 2016/11/8.
 */
public class SystemMessageRequestEntity {
    private String code;
    private int use_id;
    private String role;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getUse_id() {
        return use_id;
    }

    public void setUse_id(int use_id) {
        this.use_id = use_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
