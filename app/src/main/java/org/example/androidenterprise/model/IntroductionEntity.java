package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdlds on 2016/9/21.
 */

/**
 * 乐器简介
 */
public class IntroductionEntity implements Serializable {
    private int id;  //唯一标识符
    private String title;  //简介标题
    private String sign;  //乐器价格单位
    private int price;  //乐器价格
    private String info;  //乐器简介
    private List<String> imageUrl;  //乐器缩略图

    public IntroductionEntity(){
        imageUrl = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }
}
