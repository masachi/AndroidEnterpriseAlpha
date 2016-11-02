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
public class PaySuccessActivity extends Activity implements View.OnClickListener{
    @ViewInject(R.id.btn_check_course)
    Button checkcourseBtn;
    @ViewInject(R.id.btn_back_course)
    Button backcourseBtn;
    @ViewInject(R.id.iv_back)
    ImageView backIv;
    @ViewInject(R.id.tv_pay_success)
    TextView paysuccessTv;
    @ViewInject(R.id.tv_remind)
    TextView remindTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        backIv.setOnClickListener(this);
        checkcourseBtn.setOnClickListener(this);
        backcourseBtn.setOnClickListener(this);
    }


    @Event(value = {R.id.iv_back, R.id.btn_check_course, R.id.btn_back_course})
    public void onClick(View view) {
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
