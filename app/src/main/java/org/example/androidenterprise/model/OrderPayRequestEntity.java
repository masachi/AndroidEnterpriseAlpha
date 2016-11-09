package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by chenguojiao on 2016/11/7.订单支付请求
 */
public class OrderPayRequestEntity {
    private int User_id;
    private int Class_id;
    private int Ordernum;
    private String Telephone;
    private String Name;
    private String Price;
    private int Method;
    private String Date;

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public int getClass_id() {
        return Class_id;
    }

    public void setClass_id(int class_id) {
        Class_id = class_id;
    }

    public int getOrdernum() {
        return Ordernum;
    }

    public void setOrdernum(int ordernum) {
        Ordernum = ordernum;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getName(String name) {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getMethod() {
        return Method;
    }

    public void setMethod(int method) {
        Method = method;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

}
