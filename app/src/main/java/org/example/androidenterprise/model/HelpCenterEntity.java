package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/2.
 */
public class HelpCenterEntity implements Serializable{
    private String Content;
    private String About;


    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }
}
