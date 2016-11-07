package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.model.CourseEntity;
import org.example.androidenterprise.model.OrderPayEntity;
import org.example.androidenterprise.model.OrderPayRequestEntity;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.example.androidenterprise.utils.Constant.ORDER_PAY_URL;

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

    Intent intent;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss     ");
    Date curDate = new Date(System.currentTimeMillis());//获取当前时间
    String date = formatter.format(curDate);
    OrderPayEntity response;
    String orderNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_payment);
        x.view().inject(this);
        setTopbar();
        getOrderData();
    }

//    private void getOrderDate() {
//
//    }

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

    private void getOrderData() {
        intent = getIntent();
        courseInfoTv.setText(intent.getStringExtra("courseName"));
        attnTv.setText(intent.getStringExtra("name"));
        attnphoneNumberTv.setText(intent.getStringExtra("phone"));
        sumTv.setText(intent.getStringExtra("price"));
        accoutTv.setText(intent.getStringExtra("account"));
        String phone = intent.getStringExtra("phone");
        orderNum = phone.substring(2,11);
        orderNoTv.setText(orderNum);
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
//                if (response.getResult().equals("false")) {


//                } else {
//                    Toast.makeText(OrderPaymentActivity.this, "未支付成功", Toast.LENGTH_SHORT).show();
//                }
                //设置跳转支付界面
                OrderPayRequestEntity request = new OrderPayRequestEntity();
                request.setClass_id(1);
                request.setUser_id("1");
                request.setOrdernum(Integer.parseInt(orderNum));
                request.setTelephone(intent.getStringExtra("phone"));
                request.setName(intent.getStringExtra("name"));
                request.setPrice(intent.getStringExtra("price"));
                request.setMethod(1);

                request.setDate(date);
                RequestParams params = new RequestParams(ORDER_PAY_URL);
                params.setAsJsonContent(true);
                params.setBodyContent(new Gson().toJson(request));
                x.http().post(params, new Callback.CommonCallback<String>() {

                    @Override
                    public void onSuccess(String result) {
                        Log.e("23333", result);
//                        response = new Gson().fromJson(result, new TypeToken<OrderPayEntity>() {
//                        }.getType());
                        startActivity(new Intent(OrderPaymentActivity.this, CoursePaySuccessActivity.class));
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        ex.printStackTrace();
                        Toast.makeText(OrderPaymentActivity.this,"网络错误",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
                break;
        }
    }
}
