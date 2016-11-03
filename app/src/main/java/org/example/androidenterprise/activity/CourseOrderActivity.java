package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by yangxinghua ：课程订购
 */
@ContentView(R.layout.activity_course_order)

public class CourseOrderActivity extends AppCompatActivity {

    @ViewInject(R.id.tv_account_name)
    TextView accountTv;
    @ViewInject(R.id.lv_course_order)
    ListView courseorderLv;
    @ViewInject(R.id.et_real_name)
    EditText realnameEt;
    @ViewInject(R.id.et_phonenum)
    EditText phonenumEt;
    @ViewInject(R.id.tv_price)
    TextView priceTv;
    @ViewInject(R.id.btn_confirm)
    Button confirmBtn;
    @ViewInject(R.id.topbar_course_order)
    TopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
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
                //TODO: 上传订购信息
                startActivity(new Intent(this, OrderPaymentActivity.class));
                break;
        }
    }
}