package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/5.
 */
public class CourseCalendarEntity implements Serializable {
    private String Date;
    private String Time;
    private String Name;
    private int Num;
    private String Location;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
