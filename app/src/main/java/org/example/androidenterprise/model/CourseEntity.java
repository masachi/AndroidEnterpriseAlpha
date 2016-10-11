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
    private List<AdvInfoEntity> adv;
    private List<CourseInfoEntity> course_list;

    public CourseEntity(){
        setAdv(new ArrayList<AdvInfoEntity>());
        setCourse_list(new ArrayList<CourseInfoEntity>());
    }

    public List<AdvInfoEntity> getAdv() {
        return adv;
    }

    public void setAdv(List<AdvInfoEntity> adv) {
        this.adv = adv;
    }

    public List<CourseInfoEntity> getCourse_list() {
        return course_list;
    }

    public void setCourse_list(List<CourseInfoEntity> course_list) {
        this.course_list = course_list;
    }
}
