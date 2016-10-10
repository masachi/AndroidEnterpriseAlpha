package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by sdlds on 2016/10/5.
 */

/**
 * 订单详情
 */
public class OrderInfoEntity implements Serializable {
    private int id;  //唯一标识符
    private String time;  //上课时间
    private String course; //课程名字
    private String position;  //课程位置

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
