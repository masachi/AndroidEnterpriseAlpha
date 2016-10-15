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
 * Created by Administrator on 2016/10/15.
 */
@ContentView(R.layout.activity_order_payment)
public class OrderPaymentActivity extends Activity implements View.OnClickListener {


    @ViewInject(R.id.orderpayment_back_iv)
    ImageView orderpayment_back_iv;
    @ViewInject(R.id.orderpayment_courseInfo_tv)
    TextView orderpayment_courseInfo_tv;
    @ViewInject(R.id.orderpayment_accout_tv)
    TextView orderpayment_accout_tv;
    @ViewInject(R.id.orderpayment_Attn_tv)
    TextView orderpayment_Attn_tv;
    @ViewInject(R.id.orderpayment_Attn_phoneNumber_tv)
    TextView orderpayment_Attn_phoneNumber_tv;
    @ViewInject(R.id.orderpayment_OrderNo_tv)
    TextView orderpayment_OrderNo_tv;
    @ViewInject(R.id.orderpayment_sum_tv)
    TextView orderpayment_sum_tv;
    @ViewInject(R.id.orderpayment_alipay_title_tv)
    TextView orderpayment_alipay_title_tv;
    @ViewInject(R.id.orderpayment_selected_alipay_iv)
    ImageView orderpayment_selected_alipay_iv;
    @ViewInject(R.id.orderpayment_wechatpay_title_tv)
    TextView orderpayment_wechatpay_title_tv;
    @ViewInject(R.id.orderpayment_wechatpay_selected_iv)
    ImageView orderpayment_wechatpay_selected_iv;
    @ViewInject(R.id.orderpayment_payment_btn)
    Button orderpayment_payment_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_payment);
        x.view().inject(this);


    }


    @Event(value = {R.id.orderpayment_back_iv, R.id.orderpayment_alipay_title_tv, R.id.orderpayment_wechatpay_title_tv, R.id.orderpayment_payment_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.orderpayment_back_iv:
                //TODO 设置返回课程订购界面
                break;
            case R.id.orderpayment_alipay_title_tv:
                orderpayment_selected_alipay_iv.setImageResource(R.mipmap.ic_payment_check_selected);
                orderpayment_wechatpay_selected_iv.setImageResource(R.mipmap.ic_payment_check_normal);
                //TODO 设置支付宝支付
                break;
            case R.id.orderpayment_wechatpay_title_tv:
                orderpayment_selected_alipay_iv.setImageResource(R.mipmap.ic_payment_check_normal);
                orderpayment_wechatpay_selected_iv.setImageResource(R.mipmap.ic_payment_check_selected);
                //TODO 设置微信支付
                break;
            case R.id.orderpayment_payment_btn:
                //TODO 设置跳转支付界面
                break;
        }
    }
}
