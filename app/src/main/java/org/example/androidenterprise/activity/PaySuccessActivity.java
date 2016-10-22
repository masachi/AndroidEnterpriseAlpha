package org.example.androidenterprise.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by byyoung1 on 2016/10/18.：支付成功界面
 */


@ContentView(R.layout.activity_pay_success)
public class PaySuccessActivity extends Activity {
    @ViewInject(R.id.btn_check_course)
    Button btn_check_course;
    @ViewInject(R.id.btn_back_course)
    Button btn_back_course;
    @ViewInject(R.id.iv_back)
    ImageView iv_back;
    @ViewInject(R.id.tv_pay_success)
    TextView tv_pay_success;
    @ViewInject(R.id.tv_remind)
    TextView tv_remind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Event(value = {R.id.iv_back, R.id.btn_check_course, R.id.btn_back_course})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                //TODO 对标题栏返回图片，返回功能的实现
                break;
            case R.id.btn_check_course:
                //TODO 点击此按钮实现查看课程详情
                break;
            case R.id.btn_back_course:
                //TODO 点击此按钮实现返回课程中心
                break;
        }
    }
}
