package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdlds on 2016/9/18.
 */

/**
 * 课程Model
 */
public class CourseEntity implements Serializable {
    private String maxtime;
    private List<CourseListEntity> list;

    public CourseEntity(){
        setMaxtime(new String());
        setList(new ArrayList<CourseListEntity>());
    }

    public String getMaxtime() {
        return maxtime;
    }

    public void setMaxtime(String maxtime) {
        this.maxtime = maxtime;
    }

    public List<CourseListEntity> getList() {
        return list;
    }

    public void setList(List<CourseListEntity> list) {
        this.list = list;
    }

    public static class CourseListEntity {
        private String class_name;
        private String class_pic_url;
        private String teacher_name;
        private String level;
        private String available;
        private String local;

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }

        public String getClass_pic_url() {
            return class_pic_url;
        }

        public void setClass_pic_url(String class_pic_url) {
            this.class_pic_url = class_pic_url;
        }

        public String getTeacher_name() {
            return teacher_name;
        }

        public void setTeacher_name(String teacher_name) {
            this.teacher_name = teacher_name;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getAvailable() {
            return available;
        }

        public void setAvailable(String available) {
            this.available = available;
        }

        public String getLocal() {
            return local;
        }

        public void setLocal(String local) {
            this.local = local;
        }

    }
}
