package org.example.androidenterprise.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.google.gson.Gson;
import org.example.androidenterprise.R;
import org.example.androidenterprise.model.ConfirmOrderEntity;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.example.androidenterprise.utils.Constant.CONFIRM_ORDER_URL;


@ContentView(R.layout.activity_confirm_order)

/**
 * Created by baiqingyu : 确认订单
 */
public class ConfirmOrderActivity extends Activity {
    @ViewInject(R.id.tv_buyer_leave_message)
    TextView buyerLeaveMessageTv;
    @ViewInject(R.id.topbar_confirm_order)
    TopbarView topbar;
    @ViewInject(R.id.btn_submit_order)
    Button submitOrderBtn;
    @ViewInject(R.id.tv_real_pay_money)
    TextView realPayMoneyTv;
    @ViewInject(R.id.tv_amount_money)
    TextView amountMoneyTv;
    @ViewInject(R.id.rl_ship_address)
    RelativeLayout shipAddressRl;
    @ViewInject(R.id.tv_receiver_name)
    TextView receiverNameTv;
    @ViewInject(R.id.tv_receiver_tele_number)
    TextView receiverTeleNumberTv;
    @ViewInject(R.id.tv_details_address)
    TextView detailsAddressTv;
    Intent intent;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss     ");
    Date curDate = new Date(System.currentTimeMillis());//获取当前时间
    String date = formatter.format(curDate);
    ConfirmOrderEntity response;
    String orderNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        getInstrumentPrice();
    }

    private void getInstrumentPrice() {
        Intent intent = getIntent();

    private void getInstrumentPrice() {
        intent = getIntent();
        realPayMoneyTv.setText(intent.getStringExtra("price"));
        amountMoneyTv.setText(intent.getStringExtra("price"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        receiverNameTv.setText(data.getStringExtra("name"));
        receiverTeleNumberTv.setText(data.getStringExtra("phone"));
        detailsAddressTv.setText(data.getStringExtra("address"));
        Log.e("hhhhhh",data.getStringExtra("name") + data.getStringExtra("phone") + data.getStringExtra("address"));
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == RESULT_CODE && REQUEST_CODE == requestCode) {
//            data = getIntent();
//            receiverNameTv.setText(data.getStringExtra("name"));
//            receiverTeleNumberTv.setText(data.getStringExtra("phone"));
//            detailsAddressTv.setText(data.getStringExtra("address"));
//        }
////        super.onActivityResult(requestCode, resultCode, data);
//    }

    private void getReceiverData() {
        intent = getIntent();
        receiverNameTv.setText(intent.getStringExtra("name"));
        receiverTeleNumberTv.setText(intent.getStringExtra("phone"));
        detailsAddressTv.setText(intent.getStringExtra("address"));
        buyerLeaveMessageTv.setText(intent.getStringExtra("message"));
    }


    public void showDialog() {
        LayoutInflater factory = LayoutInflater.from(ConfirmOrderActivity.this);
        final View view = factory.inflate(R.layout.confirm_order_buyer_leave_message_dialog, null);
        final EditText edit = (EditText) view.findViewById(R.id.et_message_board_buyer);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("留言");
        builder.setView(view);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String input = edit.getText().toString();
                if (input.equals("")) {
                    buyerLeaveMessageTv.setText("点击留言");
                } else {
                    buyerLeaveMessageTv.setText(input);
                }
            }
        });
        AlertDialog dialog = builder.create();
        Window mWindow = dialog.getWindow();
        mWindow.setGravity(Gravity.BOTTOM);
        dialog.show();
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("确认订单");
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

    @Event(value = {R.id.tv_buyer_leave_message, R.id.rl_ship_address, R.id.btn_submit_order})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_buyer_leave_message:
                showDialog();
                break;
            case R.id.rl_ship_address:
                Intent intent = new Intent();
                intent.setClass(this, SelectAddActivity.class);
                startActivityForResult(intent,0);
                break;
            case R.id.btn_submit_order:
//                Intent intent = new Intent(this, InstrumentPaySuccessActivity.class);
//                startActivityForResult(intent, REQUEST_CODE);
                startActivity(new Intent(this, InstrumentPaySuccessActivity.class));
                break;
//                Intent intent = new Intent(this, InstrumentPaySuccessActivity.class);
//                startActivityForResult(intent, REQUEST_CODE);
//                startActivity(new Intent(this, InstrumentPaySuccessActivity.class));
//                break;
                final ConfirmOrderEntity request = new ConfirmOrderEntity();
                request.setUser_id(1);
                request.setCode("2071");
                request.setPrice(30);
                request.setMethod("alipay");
                request.setSituation("已支付");
                request.setMessage("货物收到很满意");
                request.setDate(date);
                request.setOrdernum(1231231);
                request.setReceiverAddressId(1);
//                ArrayList<ConfirmOrderEntity.orderslistEntity> orderslist = new ArrayList<ConfirmOrderEntity.orderslistEntity>();
//                request.setIns_id();
//                request.setAttribute();

                RequestParams params = new RequestParams(CONFIRM_ORDER_URL);
                params.setAsJsonContent(true);
                params.setBodyContent(new Gson().toJson(request));
                x.http().post(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("确认订单", result);
                        startActivity(new Intent(getBaseContext(), InstrumentPaySuccessActivity.class));
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
        }
    }
}