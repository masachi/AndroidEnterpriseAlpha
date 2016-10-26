package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojiao : 课程详情页面从服务器端获取数据实体类.
 */
public class CourseInfoEntity implements Serializable{
    private int Class_id;
    private String Class_name;
    private int Class_level;
    private int Class_price;
    private int Class_number;
    private int Class_time;
    private String Class_location;
    private String Class_remark;
    private List<TeacherInfoEntity> Teacher;
    private List<ClassDetailInfoEntity> Class_detail;
    private int Feedback_num;
    private String Feedback_pic_url;

    public CourseInfoEntity(){
        Teacher = new ArrayList<TeacherInfoEntity>();
        Class_detail = new ArrayList<ClassDetailInfoEntity>();
    }

    public int getClass_id() {
        return Class_id;
    }

    public void setClass_id(int class_id) {
        Class_id = class_id;
    }

    public String getClass_name() {
        return Class_name;
    }

    public void setClass_name(String class_name) {
        Class_name = class_name;
    }

    public int getClass_level() {
        return Class_level;
    }

    public void setClass_level(int class_level) {
        Class_level = class_level;
    }

    public int getClass_price() {
        return Class_price;
    }

    public void setClass_price(int class_price) {
        Class_price = class_price;
    }

    public int getClass_number() {
        return Class_number;
    }

    public void setClass_number(int class_number) {
        Class_number = class_number;
    }

    public int getClass_time() {
        return Class_time;
    }

    public void setClass_time(int class_time) {
        Class_time = class_time;
    }

    public String getClass_location() {
        return Class_location;
    }

    public void setClass_location(String class_location) {
        Class_location = class_location;
    }

    public String getClass_remark() {
        return Class_remark;
    }

    public void setClass_remark(String class_remark) {
        Class_remark = class_remark;
    }

    public List<TeacherInfoEntity> getTeacher() {
        return Teacher;
    }

    public void setTeacher(List<TeacherInfoEntity> teacher) {
        Teacher = teacher;
    }


    public List<ClassDetailInfoEntity> getClass_detail() {
        return Class_detail;
    }

    public void setClass_detail(List<ClassDetailInfoEntity> class_detail) {
        Class_detail = class_detail;
    }

    public int getFeedback_num() {
        return Feedback_num;
    }

    public void setFeedback_num(int feedback_num) {
        Feedback_num = feedback_num;
    }

    public String getFeedback_pic_url() {
        return Feedback_pic_url;
    }

    public void setFeedback_pic_url(String feedback_pic_url) {
        Feedback_pic_url = feedback_pic_url;
    }

    public static class TeacherInfoEntity{
        private String Teacher_pic_URL;
        private String Teacher_name;
        private String Teacher_telephone;
        private int Student_number;
        private List<StudentInfoEntity> Student;

        public String getTeacher_pic_URL() {
            return Teacher_pic_URL;
        }

        public void setTeacher_pic_URL(String teacher_pic_URL) {
            Teacher_pic_URL = teacher_pic_URL;
        }

        public String getTeacher_name() {
            return Teacher_name;
        }

        public void setTeacher_name(String teacher_name) {
            Teacher_name = teacher_name;
        }

        public String getTeacher_telephone() {
            return Teacher_telephone;
        }

        public void setTeacher_telephone(String teacher_telephone) {
            Teacher_telephone = teacher_telephone;
        }

        public int getStudent_number() {
            return Student_number;
        }

        public void setStudent_number(int student_number) {
            Student_number = student_number;
        }

        public List<StudentInfoEntity> getStudent() {
            return Student;
        }

        public void setStudent(List<StudentInfoEntity> student) {
            Student = student;
        }
    }

    public static class StudentInfoEntity{
        private String Student_pic_url;

        public String getStudent_pic_url() {
            return Student_pic_url;
        }

        public void setStudent_pic_url(String student_pic_url) {
            Student_pic_url = student_pic_url;
        }
    }

    public static class ClassDetailInfoEntity{
        private int Num;
        private boolean Type;
        private String Time;
        private String Content;

        public int getNum() {
            return Num;
        }

        public void setNum(int num) {
            Num = num;
        }

        public boolean isType() {
            return Type;
        }

        public void setType(boolean type) {
            Type = type;
        }

        public String getTime() {
            return Time;
        }

        public void setTime(String time) {
            Time = time;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String content) {
            Content = content;
        }
    }
}
