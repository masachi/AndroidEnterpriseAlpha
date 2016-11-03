package org.example.androidenterprise.model;

/**
 * Created by chenguojiao : 学员反馈请求model.
 */
public class StudentsFeedbackRequestEntity {
    private int Class_id;
    private int Time_id;

    public int getClass_id() {
        return Class_id;
    }

    public void setClass_id(int class_id) {
        Class_id = class_id;
    }

    public int getTime_id() {
        return Time_id;
    }

    public void setTime_id(int time_id) {
        Time_id = time_id;
    }
}
