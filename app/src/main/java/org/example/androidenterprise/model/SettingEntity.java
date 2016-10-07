package org.example.androidenterprise.model;

/**
 * Created by sdlds on 2016/9/18.
 */
public class SettingEntity {
    private int id;
    private String src;
    private String text;
    private String arrow;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setArrow(String arrow) {
        this.arrow = arrow;
    }

    public String getArrow() {
        return arrow;
    }
}
