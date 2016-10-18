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
 * Created by Administrator on 2016/10/18.
 */
@ContentView(R.layout.activity_pay_success)
public class PaySuccessActivity extends Activity {
    @ViewInject(R.id.pay_success_check_course_btn)
    Button pay_success_check_course_btn;
    @ViewInject(R.id.pay_success_back_course_btn)
    Button pay_success_back_course_btn;
    @ViewInject(R.id.pay_success_back_iv)
    ImageView pay_success_back_iv;
    @ViewInject(R.id.pay_success_tv)
    TextView pay_success_tv;
    @ViewInject(R.id.pay_success_remind_tv)
    TextView pay_success_remind_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Event(value = {R.id.pay_success_back_iv, R.id.pay_success_check_course_btn, R.id.pay_success_back_course_btn})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.pay_success_back_iv:
                //TODO 对标题栏返回图片，返回功能的实现
                break;
            case R.id.pay_success_check_course_btn:
                //TODO 点击此按钮实现查看课程详情
                break;
            case R.id.pay_success_back_course_btn:
                //TODO 点击此按钮实现返回课程中心
                break;
        }
    }
}
