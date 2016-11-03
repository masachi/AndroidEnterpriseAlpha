package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */
public class InsAndDesEntity implements Serializable {
    private List<InsDesEntity> inspicsList;

    public InsAndDesEntity(){
        inspicsList = new ArrayList<InsDesEntity>();
    }

    public List<InsDesEntity> getInspicsList() {
        return inspicsList;
    }

    public void setInspicsList(List<InsDesEntity> inspicsList) {
        this.inspicsList = inspicsList;
    }
    public static class InsDesEntity{
        private List<PicsEntity> pics;
        private String des;
        private int now_price;
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public InsDesEntity(){
            pics = new ArrayList<PicsEntity>();
        }

        public List<PicsEntity> getPics() {
            return pics;
        }

        public void setPics(List<PicsEntity> pics) {
            this.pics = pics;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public int getNow_price() {
            return now_price;
        }

        public void setNow_price(int now_price) {
            this.now_price = now_price;
        }

        public static class PicsEntity{
            private String pic_url;

            public String getPic_url() {
                return pic_url;
            }

            public void setPic_url(String pic_url) {
                this.pic_url = pic_url;
            }
        }
    }
}
