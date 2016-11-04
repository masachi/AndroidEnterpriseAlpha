package org.example.androidenterprise.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by byyoung1 on 2016/10/18.：支付成功界面
 */


@ContentView(R.layout.activity_pay_success)

public class PaySuccessActivity extends Activity implements View.OnClickListener {

    @ViewInject(R.id.btn_check_course)
    Button checkcourseBtn;
    @ViewInject(R.id.btn_back_course)
    Button backcourseBtn;
    @ViewInject(R.id.tv_pay_success)
    TextView paysuccessTv;
    @ViewInject(R.id.tv_remind)
    TextView remindTv;
    @ViewInject(R.id.topbar_pay_success)
    TopbarView topbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        checkcourseBtn.setOnClickListener(this);
        backcourseBtn.setOnClickListener(this);
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("支付成功");
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

    @Event(value = {R.id.btn_check_course, R.id.btn_back_course})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_check_course:
                //TODO 点击此按钮实现查看课程详情
                break;
            case R.id.btn_back_course:
                //TODO 点击此按钮实现返回课程中心
                break;
        }
    }
}
