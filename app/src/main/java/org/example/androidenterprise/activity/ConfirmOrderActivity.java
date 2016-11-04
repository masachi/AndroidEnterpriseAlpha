package org.example.androidenterprise.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.*;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_confirm_order)

/**
 * Created by baiqingyu : 确认订单
 */
public class ConfirmOrderActivity extends Activity {
    @ViewInject(R.id.tv_buyer_leave_message)
    TextView tv_buyer_leave_message;
    @ViewInject(R.id.topbar_confirm_order)
    TopbarView topbar;
    @ViewInject(R.id.ib_right_arrow)
    ImageButton ib_right_arrow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        tv_buyer_leave_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
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
                    tv_buyer_leave_message.setText("点击留言");
                } else {
                    tv_buyer_leave_message.setText(input);
                }
            }
        });
        AlertDialog dialog = builder.create();
        Window mWindow=dialog.getWindow();
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

    @Event(value = {R.id.tv_buyer_leave_message, R.id.ib_right_arrow})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_buyer_leave_message:
                break;
            case R.id.ib_right_arrow:
                startActivity(new Intent(this, SelectAddActivity.class));
                break;
        }
    }
}