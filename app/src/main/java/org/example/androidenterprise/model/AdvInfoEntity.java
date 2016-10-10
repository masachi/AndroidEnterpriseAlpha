package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by sdlds on 2016/10/10.
 */
public class AdvInfoEntity implements Serializable {
    private String jump_url;
    private String image_url;
    private String title;

    public String getJump_url() {
        return jump_url;
    }

    public void setJump_url(String jump_url) {
        this.jump_url = jump_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
