package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caishuang：确认订单里面选择地址model
 */
public class ConfirmOrderEntity implements Serializable {
    private int user_id;
    private String code;
    private double price;
    private String method;
    private String situation;
    private String message;
    private String date;
    private int ordernum;
    private int receiverAddressID;
    private List<OrderslistEntity> orderslist;

    public ConfirmOrderEntity() {
        orderslist = new ArrayList<OrderslistEntity>();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getOrder_num() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    public int getReceiverAddressID() {
        return receiverAddressID;
    }

    public void setReceiverAddressID(int receiverAddressID) {
        this.receiverAddressID = receiverAddressID;
    }

    public List<OrderslistEntity> getorderslist() {
        return orderslist;
    }

    public void setorderslist(List<OrderslistEntity> orderslist) {
        this.orderslist = orderslist;
    }


    public static class OrderslistEntity {
        private int ins_id;
        private String attribute;

        public int getIns_id() {
            return ins_id;
        }

        public void setIns_id(int ins_id) {
            this.ins_id = ins_id;
        }

        public String getAttribute() {
            return attribute;
        }

        public void setAttribute(String attribute) {
            this.attribute = attribute;
        }
    }
}
