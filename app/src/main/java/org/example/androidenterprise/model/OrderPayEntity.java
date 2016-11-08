package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by chenguojiao on 2016/11/7.订单支付
 */
public class OrderPayEntity implements Serializable{
    private String Result;

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }
}
