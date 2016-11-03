package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojiao : 学员反馈model
 */
//{"Topic":[{"Topic_id":1,"Content":"aaa","Date":"2016-11-3 9:00","Name":"233"},{"Topic_id":2,"Content":"ddd","Name":"233"}]}
public class StudentsFeedBackEntity implements Serializable {
    private List<StudentsFeedBackListEntity> Topic;

    public StudentsFeedBackEntity(){
        setTopic(new ArrayList<StudentsFeedBackListEntity>());
    }


    public List<StudentsFeedBackListEntity> getTopic() {
        return Topic;
    }

    public void setTopic(List<StudentsFeedBackListEntity> topic) {
        Topic = topic;
    }

    public static class StudentsFeedBackListEntity{
        private int Topic_id;
        private String Content;
        private String Date;
        private String Name;

        public int getTopic_id() {
            return Topic_id;
        }

        public void setTopic_id(int topic_id) {
            Topic_id = topic_id;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String content) {
            Content = content;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String date) {
            Date = date;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }
    }
}
