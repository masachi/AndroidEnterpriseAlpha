package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static org.example.androidenterprise.utils.Constant.JUMP;

/*
Create by chenguojio : 乐器支付成功
 */

@ContentView(R.layout.activity_instrument_pay_success)
public class InstrumentPaySuccessActivity extends BaseActivity {

    @ViewInject(R.id.topbar_pay_success)
    TopbarView topbar;
    @ViewInject(R.id.btn_check)
    Button checkBtn;
    @ViewInject(R.id.btn_back)
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument_pay_success);
        x.view().inject(this);
        setTopbar();

//        checkBtn.setOnClickListener(this);
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

    @Event(value = {R.id.btn_check, R.id.btn_back})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_check:
                Intent intent1 = new Intent();
                intent1.putExtra("instrument_selected","1");
                intent1.setClass(this,InstrumentDetailActivity.class);
                startActivity(intent1);
                //点击此按钮实现查看乐器详情
                break;
            case R.id.btn_back:
                Intent intent = new Intent();
                intent.setClass(this,InsideActivity.class);
                JUMP = 2;
                startActivity(intent);
                //点击此按钮实现返回乐器中心
                break;
        }
    }
}
