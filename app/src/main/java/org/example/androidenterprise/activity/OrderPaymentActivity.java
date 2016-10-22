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
    ImageView iv_back;
    @ViewInject(R.id.tv_courseInfo)
    TextView tv_courseInfo;
    @ViewInject(R.id.tv_accout)
    TextView tv_accout;
    @ViewInject(R.id.tv_Attn)
    TextView tv_Attn;
    @ViewInject(R.id.tv_Attn_phoneNumber)
    TextView tv_Attn_phoneNumber;
    @ViewInject(R.id.tv_OrderNo)
    TextView tv_OrderNo;
    @ViewInject(R.id.tv_sum)
    TextView tv_sum;
    @ViewInject(R.id.tv_alipay_title)
    TextView tv_alipay_title;
    @ViewInject(R.id.iv_selected_alipay)
    ImageView iv_selected_alipay;
    @ViewInject(R.id.tv_wechatpay_title)
    TextView tv_wechatpay_title;
    @ViewInject(R.id.iv_wechatpay_selected)
    ImageView iv_wechatpay_selected;
    @ViewInject(R.id.btn_payment)
    Button btn_payment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_payment);
        x.view().inject(this);


    }


    @Event(value = {R.id.iv_back, R.id.tv_alipay_title, R.id.tv_wechatpay_title, R.id.btn_payment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                //TODO 设置返回课程订购界面
                break;
            case R.id.tv_alipay_title:
                iv_selected_alipay.setImageResource(R.mipmap.ic_payment_check_selected);
                iv_wechatpay_selected.setImageResource(R.mipmap.ic_payment_check_normal);
                //TODO 设置支付宝支付
                break;
            case R.id.tv_wechatpay_title:
                iv_selected_alipay.setImageResource(R.mipmap.ic_payment_check_normal);
                iv_wechatpay_selected.setImageResource(R.mipmap.ic_payment_check_selected);
                //TODO 设置微信支付
                break;
            case R.id.btn_payment:
                //TODO 设置跳转支付界面
                break;
        }
    }
}
