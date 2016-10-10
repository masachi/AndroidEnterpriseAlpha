package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by sdlds on 2016/10/10.
 */
public class CourseInfoEntity implements Serializable{
    private int course_level;
    private String course_address;
    private String teacher_name;
    private int state;
    private String title;

    public int getCourse_level() {
        return course_level;
    }

    public void setCourse_level(int course_level) {
        this.course_level = course_level;
    }

    public String getCourse_address() {
        return course_address;
    }

    public void setCourse_address(String course_address) {
        this.course_address = course_address;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
