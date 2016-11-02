package org.example.androidenterprise.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;

//Created by caishuang:学生反馈
@ContentView(R.layout.activity_students_feed_back)
public class StudentsFeedBackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_feed_back);
    }
}
