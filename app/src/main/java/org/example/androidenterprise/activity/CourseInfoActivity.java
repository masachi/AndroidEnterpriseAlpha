package org.example.androidenterprise.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import org.example.androidenterprise.R;

import static org.example.androidenterprise.List.CourseList.clist;

public class CourseInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton returnIb;
    private TextView titleTv;
    private TextView levelTv;
    private TextView idTv;
    private TextView durationTv;
    private TextView posTv;
    private TextView otherTv;
    private TextView signTv;
    private TextView priceTv;


    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);
        returnIb = (ImageButton) findViewById(R.id.course_info_return_ib);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        id = Integer.parseInt(bundle.getString("course_selected"));
        returnIb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.course_info_return_ib:
                finish();
                break;
        }
    }

    private void InitTv(){
        titleTv = (TextView) findViewById(R.id.course_info_title_tv);
        levelTv = (TextView) findViewById(R.id.course_info_level_tv);
        idTv = (TextView) findViewById(R.id.course_info_id);
        durationTv = (TextView) findViewById(R.id.course_info_duration);
        posTv = (TextView) findViewById(R.id.course_info_position);
        otherTv = (TextView) findViewById(R.id.course_info_other);
        signTv = (TextView) findViewById(R.id.price_sign_tv);
        priceTv = (TextView) findViewById(R.id.course_info_price_tv);


    }
}
