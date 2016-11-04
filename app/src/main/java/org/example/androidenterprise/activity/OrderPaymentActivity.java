package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by byyoung1 2016/10/15.：订单支付界面
 */


@ContentView(R.layout.activity_order_payment)
public class OrderPaymentActivity extends BaseActivity {

    @ViewInject(R.id.tv_courseInfo)
    TextView courseInfoTv;
    @ViewInject(R.id.tv_accout)
    TextView accoutTv;
    @ViewInject(R.id.tv_Attn)
    TextView attnTv;
    @ViewInject(R.id.tv_Attn_phoneNumber)
    TextView attnphoneNumberTv;
    @ViewInject(R.id.tv_OrderNo)
    TextView orderNoTv;
    @ViewInject(R.id.tv_sum)
    TextView sumTv;
    @ViewInject(R.id.tv_alipay_title)
    TextView alipaytitleTv;
    @ViewInject(R.id.iv_selected_alipay)
    ImageView selectedalipayIv;
    @ViewInject(R.id.tv_wechatpay_title)
    TextView wechatpaytitleTv;
    @ViewInject(R.id.iv_wechatpay_selected)
    ImageView wechatpayselectedIv;
    @ViewInject(R.id.btn_payment)
    Button paymentBtn;
    @ViewInject(R.id.topbar_order_payment)
    TopbarView topbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_payment);
        x.view().inject(this);
        setTopbar();
        getOrderData();
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("订单支付");
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

    private void getOrderData(){
        Intent intent = getIntent();
        courseInfoTv.setText(intent.getStringExtra("courseName"));
        attnTv.setText(intent.getStringExtra("name"));
        attnphoneNumberTv.setText(intent.getStringExtra("phone"));
        sumTv.setText(intent.getStringExtra("price"));
    }
    @Event(value = {R.id.tv_alipay_title, R.id.tv_wechatpay_title, R.id.btn_payment})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_alipay_title:
                selectedalipayIv.setImageResource(R.mipmap.ic_payment_check_selected);
                wechatpayselectedIv.setImageResource(R.mipmap.ic_payment_check_normal);
                //设置支付宝支付
                break;
            case R.id.tv_wechatpay_title:
                selectedalipayIv.setImageResource(R.mipmap.ic_payment_check_normal);
                wechatpayselectedIv.setImageResource(R.mipmap.ic_payment_check_selected);
                //设置微信支付
                break;
            case R.id.btn_payment:
                startActivity(new Intent(this,CoursePaySuccessActivity.class));
                //设置跳转支付界面
                break;
        }
    }
}
