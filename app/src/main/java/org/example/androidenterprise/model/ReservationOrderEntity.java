package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caishuang:预约订单model
 */
public class ReservationOrderEntity implements Serializable {
    private List<ListInfoEntity> list;

    public List<ListInfoEntity> getList() {
        return list;
    }

    public void setList(List<ListInfoEntity> list) {
        this.list = list;
    }

    public ReservationOrderEntity() {
        list = new ArrayList<ListInfoEntity>();
    }

    public static class ListInfoEntity {
        private String date;
        private String class_name;
        private String teacher_name;
        private int class_time;
        private int situation;
        private int class_price;
        private String class_pic_url;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }

        public String getTeacher_name() {
            return teacher_name;
        }

        public void setTeacher_name(String teacher_name) {
            this.teacher_name = teacher_name;
        }

        public int getClass_time() {
            return class_time;
        }

        public void setClass_time(int class_time) {
            this.class_time = class_time;
        }

        public int getSituation() {
            return situation;
        }

        public void setSituation(int situation) {
            this.situation = situation;
        }

        public int getClass_price() {
            return class_price;
        }

        public void setClass_price(int class_price) {
            this.class_price = class_price;
        }

        public String getClass_pic_url() {
            return class_pic_url;
        }

        public void setClass_pic_url(String class_pic_url) {
            this.class_pic_url = class_pic_url;
        }
    }
}