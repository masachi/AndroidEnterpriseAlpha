package org.example.androidenterprise.model;

/**
 * Created by sdlds on 2016/9/26.
 */
public class UserInfoEntity {
    private int id;
    private String username;
    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
