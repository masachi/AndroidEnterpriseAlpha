package org.example.androidenterprise.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdlds on 2016/10/5.
 */
public class OrderEntity {
    private int id;
    private String order_date;
    private List<OrderInfoEntity> order_info;

    public OrderEntity(){
        order_info = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public List<OrderInfoEntity> getOrder_info() {
        return order_info;
    }

    public void setOrder_info(List<OrderInfoEntity> order_info) {
        this.order_info = order_info;
    }
}
