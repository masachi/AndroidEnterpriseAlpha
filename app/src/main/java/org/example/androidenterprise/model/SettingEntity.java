package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by sdlds on 2016/9/18.
 */

/**
 * 设定
 */
public class SettingEntity implements Serializable {
    private int id;  //唯一标识符
    private String src; //图片资源
    private String text; //设定名称
    private String arrow; //箭头

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
