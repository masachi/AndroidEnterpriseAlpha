package org.example.androidenterprise.model;

/**
 * Created by sdlds on 2016/10/26.
 */
public class ListRequestEntity {
    private int code;
    private int id;
    private String role;
    private int maxtime;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

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

    public int getMaxtime() {
        return maxtime;
    }

    public void setMaxtime(int maxtime) {
        this.maxtime = maxtime;
    }
}
