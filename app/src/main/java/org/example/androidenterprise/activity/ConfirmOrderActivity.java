package org.example.androidenterprise.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import org.example.androidenterprise.R;
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
    //TODO: click on this textview pop_up message board

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

    }

    @Event(R.id.tv_buyer_leave_message)
    private void onClick(View view) {
    }
}
