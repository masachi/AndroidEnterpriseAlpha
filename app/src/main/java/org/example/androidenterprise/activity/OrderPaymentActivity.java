package org.example.androidenterprise.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by byyoung1 2016/10/15.：订单支付界面
 */


@ContentView(R.layout.activity_order_payment)
public class OrderPaymentActivity extends Activity implements View.OnClickListener {


    @ViewInject(R.id.iv_back)
    ImageView backIv;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_payment);
        x.view().inject(this);
        backIv.setOnClickListener(this);
        alipaytitleTv.setOnClickListener(this);
        wechatpaytitleTv.setOnClickListener(this);
        paymentBtn.setOnClickListener(this);

    }


    @Event(value = {R.id.iv_back, R.id.tv_alipay_title, R.id.tv_wechatpay_title, R.id.btn_payment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                //TODO 设置返回课程订购界面
                finish();
                break;
            case R.id.tv_alipay_title:
                selectedalipayIv.setImageResource(R.mipmap.ic_payment_check_selected);
                wechatpayselectedIv.setImageResource(R.mipmap.ic_payment_check_normal);
                //TODO 设置支付宝支付
                break;
            case R.id.tv_wechatpay_title:
                selectedalipayIv.setImageResource(R.mipmap.ic_payment_check_normal);
                wechatpayselectedIv.setImageResource(R.mipmap.ic_payment_check_selected);
                //TODO 设置微信支付
                break;
            case R.id.btn_payment:
                //TODO 设置跳转支付界面
                break;
        }
    }
}
