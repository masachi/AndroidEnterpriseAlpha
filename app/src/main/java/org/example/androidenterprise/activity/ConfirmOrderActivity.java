package org.example.androidenterprise.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import org.example.androidenterprise.R;

/**
 * Created by Administrator on 2016/10/13.
 */
public class ConfirmOrderActivity extends Activity {

    private TextView buyerLeaveMessageTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        buyerLeaveMessageTv=(TextView)findViewById(R.id.buyer_leave_message_tv);
        //TODO: click on this textview pop_up message board
    }
}
