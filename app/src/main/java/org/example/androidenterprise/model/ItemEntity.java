package org.example.androidenterprise.model;

/**
 * Created by sdlds on 2016/9/21.
 */
public class ItemEntity {
    private int id;
    private int type;
    private int fresh;
    private String title;
    private String price;
    private int price_line;

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
