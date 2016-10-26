package org.example.androidenterprise.activity;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.model.RegisterResponseEntity;
import org.example.androidenterprise.view.CircleImageView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import static org.example.androidenterprise.List.CourseList.clist;

@ContentView(R.layout.activity_course_info)

public class CourseInfoActivity extends BaseActivity implements View.OnClickListener{
    LinearLayout ll,feedbackLl;
    LayoutInflater mInflater = null;

    private ImageButton returnIb;
    private TextView titleTv;
    private TextView levelTv;
    private TextView idTv;
    private TextView durationTv;
    private TextView posTv;
    private TextView otherTv;
    private TextView signTv;
    private TextView priceTv;
    private ImageButton feedbackIb;


    public final static int STUDENT_NUMBER = 10;
    public final static int MAX_STUDENT_NUMBER = 8;
    public final static int MAX_STUDENT_NUMBER_BACK = 7;

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mInflater = LayoutInflater.from(this);

        returnIb = (ImageButton) findViewById(R.id.ib_return);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        id = Integer.parseInt(bundle.getString("course_selected"));
        returnIb.setOnClickListener(this);

        InitWidget();

        ll.setOnClickListener(this);
        feedbackLl.setOnClickListener(this);

        initLinearLayoutImage();
        initLinearLayoutFeedback();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_return:
                finish();
                break;
            case R.id.ll_stu_info:
                break;
            case R.id.ll_stu_feedback:
                startActivity(new Intent(this,StudentsFeedBack.class));
                break;
            case R.id.ib_feedback:
                startActivity(new Intent(this,ReleaseFeedBack.class));
                break;
        }
    }

    private void InitWidget(){
        titleTv = (TextView) findViewById(R.id.tv_course_title);
        levelTv = (TextView) findViewById(R.id.tv_course_level);
        idTv = (TextView) findViewById(R.id.tv_course_id);
        durationTv = (TextView) findViewById(R.id.tv_course_duration);
        posTv = (TextView) findViewById(R.id.tv_course_pos);
        otherTv = (TextView) findViewById(R.id.tv_course_other);
        signTv = (TextView) findViewById(R.id.tv_price_sign);
        priceTv = (TextView) findViewById(R.id.tv_course_price);
        feedbackIb = (ImageButton) findViewById(R.id.ib_feedback);

        ll = (LinearLayout) findViewById(R.id.ll_stu_info);
        feedbackLl = (LinearLayout) findViewById(R.id.ll_stu_feedback);
    }

    private void initLinearLayoutFeedback() {
        addHeadImgToLinearLayout(STUDENT_NUMBER, MAX_STUDENT_NUMBER_BACK,
                R.layout.head_stu_feedback_img_item, feedbackLl);
    }

    public void initLinearLayoutImage() {
        addHeadImgToLinearLayout(STUDENT_NUMBER, MAX_STUDENT_NUMBER,
                R.layout.head_stu_img_item, ll);
    }

    public void addHeadImgToLinearLayout(int studentNumber, int MaxNumber, int itemlayout,
                                         LinearLayout linearLayout) {
        if (studentNumber <= MaxNumber) {
            for (int i = 0; i < studentNumber; i++) {
                View v = mInflater.inflate(itemlayout, null);
                linearLayout.addView(v);
            }
        } else {
            for (int i = 0; i < MaxNumber; i++) {
                View v = mInflater.inflate(itemlayout, null);
                if (i == MaxNumber - 1) {
                    CircleImageView civ = (CircleImageView) v.findViewById(R.id.civ_stu);
                    civ.setImageResource(R.mipmap.ic_img_more);
                }
                linearLayout.addView(v);
            }
        }
    }

}
