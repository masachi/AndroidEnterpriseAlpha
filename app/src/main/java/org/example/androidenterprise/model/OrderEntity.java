package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdlds on 2016/10/5.
 */

/**
 * 订单
 */
public class OrderEntity implements Serializable {
    private int id;  //唯一标识符
    private String order_date;  //订单日期
    private List<OrderInfoEntity> order_info;  //订单详情

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
