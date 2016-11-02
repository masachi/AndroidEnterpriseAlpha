package org.example.androidenterprise.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import org.example.androidenterprise.MainActivity;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_confirm_order)

/**
 * Created by baiqingyu : 确认订单
 */
public class ConfirmOrderActivity extends Activity implements MainActivity.InitTopBar {
    @ViewInject(R.id.tv_buyer_leave_message)
    TextView tv_buyer_leave_message;
    @ViewInject(R.id.ib_left)
    ImageButton leftIb;
    @ViewInject(R.id.tv_top_bar)
    TextView topTv;
    @ViewInject(R.id.ib_search)
    ImageButton searchIb;
    //TODO: click on this textview pop_up message board

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initTopBar();
    }

    @Event(value = {R.id.tv_buyer_leave_message, R.id.ib_left})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_buyer_leave_message:
                break;
            case R.id.ib_left:
                finish();
                break;
        }
    }

    @Override
    public void initTopBar() {
        leftIb.setImageResource(R.mipmap.ic_return);
        topTv.setText(R.string.activity_confirm_order_title_str);
        searchIb.setVisibility(View.INVISIBLE);
    }
}
