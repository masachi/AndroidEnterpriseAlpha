package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sdlds on 2016/9/21.
 */

/**
 * 所有乐器
 */
public class ItemEntity implements Serializable {
    private int id; //唯一标识符
    private int type;  //乐器种类
    private String imageUrl;  //乐器缩略图
    private int fresh;  //是否为刷新项
    private String title;  //乐器名称
    private String price;  //乐器价格
    private int price_line;  //乐器之前价格

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setFresh(int fresh) {
        this.fresh = fresh;
    }

    public int getFresh() {
        return fresh;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice_line(int price_line) {
        this.price_line = price_line;
    }

    public int getPrice_line() {
        return price_line;
    }
}
