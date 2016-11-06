package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static org.example.androidenterprise.activity.LoginActivity.isLogin;

/**
 * Created by yangxinghua ：课程订购
 */
@ContentView(R.layout.activity_course_order)

public class CourseOrderActivity extends AppCompatActivity {

    @ViewInject(R.id.tv_account_name)
    TextView accountTv;
    @ViewInject(R.id.tv_price)
    TextView priceTv;
    @ViewInject(R.id.btn_confirm)
    Button confirmBtn;
    @ViewInject(R.id.topbar_course_order)
    TopbarView topbar;
    @ViewInject(R.id.tv_name)
    TextView courseTv;
    @ViewInject(R.id.tv_difficulty)
    TextView difficultyTv;
    @ViewInject(R.id.tv_teacher)
    TextView teacherTv;
    @ViewInject(R.id.tv_classroom)
    TextView classroomTv;
    @ViewInject(R.id.tv_price_sign)
    TextView priceSignTv;
    @ViewInject(R.id.et_real_name)
    EditText realNameEt;
    @ViewInject(R.id.tv_money)
    TextView moneyTv;
    @ViewInject(R.id.tv_price_bottom)
    TextView priceBottomTv;
    @ViewInject(R.id.et_phonenum)
    EditText phoneNumberEt;

    String courseName;
    String coursePrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        getCourseData();
    }

    private void getCourseData() {
        Intent intent = getIntent();
        courseName = intent.getStringExtra("courseName");
        courseTv.setText(courseName);
        String courseLevel = intent.getStringExtra("courseLevel");
        difficultyTv.setText("难度等级:" + courseLevel);
        String teacherName = intent.getStringExtra("teacherName");
        teacherTv.setText("老师：" + teacherName);
        String courseLocation = intent.getStringExtra("courseLocation");
        classroomTv.setText(courseLocation);
        coursePrice = intent.getStringExtra("coursePrice");
        priceTv.setText(coursePrice);
        priceBottomTv.setText(coursePrice);
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("课程订购");
        Drawable ic_return = res.getDrawable(R.mipmap.ic_return);
        topbar.setLeftIb(ic_return);
        topbar.getLeftIb().setVisibility(View.VISIBLE);
        topbar.setLeftIbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Event(value = {R.id.btn_confirm})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                //上传订购信息
                String realName = realNameEt.getText().toString();
                String phoneNumber = phoneNumberEt.getText().toString();
                if (TextUtils.isEmpty(realName) || phoneNumber.length() != 11) {
                    Toast.makeText(this, "请输入信息", Toast.LENGTH_LONG).show();
                } else if (!isLogin){
                    Toast.makeText(CourseOrderActivity.this, "请登录", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this,LoginActivity.class));
                } else {
                    Intent intent = new Intent();
                    intent.setClass(this, OrderPaymentActivity.class);
                    intent.putExtra("courseName", courseName);
                    intent.putExtra("name", realNameEt.getText().toString());
                    intent.putExtra("phone",phoneNumberEt.getText().toString());
                    intent.putExtra("price",coursePrice);
                    startActivity(intent);
                }
                break;
        }
    }
}