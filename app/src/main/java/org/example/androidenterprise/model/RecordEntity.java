package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojiao : 交易记录model
 */
//{"order_list":[{"date":"20161108",
// "price":13.0,"list":[{"pic_url":"http://imgsrc.baidu.com/baike/pic/item/7c1ed21b0ef41bd56710db2454da81cb38db3d9a.jpg",
// "now_price":10,"name":"德国进口大提琴","type":"cello"}],"situation":"已支付","freigh":0.0},

public class RecordEntity implements Serializable {
    private List<OrderListEntity> order_list;

    public List<OrderListEntity> getOrder_list() {
        return order_list;
    }

    public void setOrder_list(List<OrderListEntity> order_list) {
        this.order_list = order_list;
    }
    public RecordEntity(){
        order_list = new ArrayList<>();
    }
    public static class OrderListEntity{
        private String date;
        private double price;
        private List<ListEntity> list;
        private String situation;
        private double freigh;

        public OrderListEntity(){
            list = new ArrayList<>();
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public String getSituation() {
            return situation;
        }

        public void setSituation(String situation) {
            this.situation = situation;
        }

        public double getFreigh() {
            return freigh;
        }

        public void setFreigh(double freigh) {
            this.freigh = freigh;
        }
    }
    public static class ListEntity{
        private String pic_url;
        private int now_price;
        private String name;
        private String type;

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public int getNow_price() {
            return now_price;
        }

        public void setNow_price(int now_price) {
            this.now_price = now_price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
//private List<OrderList> order_list;
//
//    public List<OrderList> getOrder_list() {
//        return order_list;
//    }
//
//    public void setOrder_list(List<OrderList> order_list) {
//        this.order_list = order_list;
//    }
//
//    public static class OrderList {
//        private String date;
//        private Double price;
//        private List<TransList> list;
//        private String situation;
//        private int freigh;//运费
//
//        public String getDate() {
//            return date;
//        }
//
//        public void setDate(String date) {
//            this.date = date;
//        }
//
//        public Double getPrice() {
//            return price;
//        }
//
//        public void setPrice(Double price) {
//            this.price = price;
//        }
//
//        public List<TransList> getList() {
//            return list;
//        }
//
//        public void setList(List<TransList> list) {
//            this.list = list;
//        }
//
//        public String getSituation() {
//            return situation;
//        }
//
//        public void setSituation(String situation) {
//            this.situation = situation;
//        }
//
//        public int getFreigh() {
//            return freigh;
//        }
//
//        public void setFreigh(int freigh) {
//            this.freigh = freigh;
//        }
//    }
//    public static class TransList{
//        private String pic_url;
//        private int now_price;
//        private String name;
//        private String type;
//
//        public String getPic_url() {
//            return pic_url;
//        }
//
//        public void setPic_url(String pic_url) {
//            this.pic_url = pic_url;
//        }
//
//        public int getNow_price() {
//            return now_price;
//        }
//
//        public void setNow_price(int now_price) {
//            this.now_price = now_price;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getType() {
//            return type;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//    }
}
