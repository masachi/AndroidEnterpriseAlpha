package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by sdlds on 2016/9/21.
 */

/**
 * 乐器上的TabLayout数据
 */
public class CatagoryEntity implements Serializable{
    private int id;  //唯一标识符
    private String type;  //乐器的种类
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
