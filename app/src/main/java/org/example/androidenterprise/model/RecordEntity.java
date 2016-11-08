package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenguojiao : 交易记录model
 */
public class RecordEntity implements Serializable {
    private List<OrderListEntity> order_list;

    public List<OrderListEntity> getOrder_list() {
        return order_list;
    }

    public void setOrder_list(List<OrderListEntity> order_list) {
        this.order_list = order_list;
    }
    public static class OrderListEntity{
        private String date;
        private double price;
        private List<ListEntity> list;
        private String situation;
        private double freigh;
//        public OrderListEntity(){
//
//        }

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
}
