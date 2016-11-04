package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */
public class InstrumentEntity implements Serializable {
    private int maxtime;
    private List<InstrumentMsgEntity> insArr;

    public InstrumentEntity(){
        insArr = new ArrayList<InstrumentMsgEntity>();
    }
    public int getMaxtime() {
        return maxtime;
    }

    public void setMaxtime(int maxtime) {
        this.maxtime = maxtime;
    }

    public List<InstrumentMsgEntity> getInsArr() {
        return insArr;
    }

    public void setInsArr(List<InstrumentMsgEntity> insArr) {
        this.insArr = insArr;
    }
    public static class InstrumentMsgEntity implements Serializable{
        private String name;
        private int pre_price;
        private int now_price;
        private String type;
        private String pic_url;
        private int id;
        //用于记录点击的位置
        private String pos;

        public String getPos() {
            return pos;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPre_price() {
            return pre_price;
        }

        public void setPre_price(int pre_price) {
            this.pre_price = pre_price;
        }

        public int getNow_price() {
            return now_price;
        }

        public void setNow_price(int now_price) {
            this.now_price = now_price;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
