package org.example.androidenterprise.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaohua on 2016/11/8.
 */
public class SystemMessageEntity {
    private List<SystemMessageListEntity> list;

    public SystemMessageEntity() {
        setList(new ArrayList<SystemMessageListEntity>());
    }

    public List<SystemMessageListEntity> getList() {
        return list;
    }

    public void setList(List<SystemMessageListEntity> list) {
        this.list = list;
    }

    public static class SystemMessageListEntity {
        private String title;
        private String content;
        private String date;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
