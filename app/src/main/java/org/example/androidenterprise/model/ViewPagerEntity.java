package org.example.androidenterprise.model;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdlds on 2016/10/25.
 */
public class ViewPagerEntity implements Serializable {
    private List<ViewPagerInfoEntity> top;

    public ViewPagerEntity(){
        top = new ArrayList<ViewPagerInfoEntity>();
    }

    public List<ViewPagerInfoEntity> getTop() {
        return top;
    }

    public void setTop(List<ViewPagerInfoEntity> top) {
        this.top = top;
    }

    public static class ViewPagerInfoEntity{
        private String top_image;
        private String class_name;

        public String getTop_image() {
            return top_image;
        }

        public void setTop_image(String top_image) {
            this.top_image = top_image;
        }

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }
    }
}
