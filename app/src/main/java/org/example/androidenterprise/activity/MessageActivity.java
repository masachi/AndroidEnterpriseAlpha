package org.example.androidenterprise.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.readystatesoftware.viewbadger.BadgeView;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_message)

public class MessageActivity extends BaseActivity {

    @ViewInject(R.id.ib_return)
    ImageButton returnIb;
    @ViewInject(R.id.rl_sys_msg)
    RelativeLayout sysMsgRl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BadgeView badgeView = (BadgeView) findViewById(R.id.badget_msg);
        badgeView.setText("12");
    }


    @Event(value = {R.id.ib_return, R.id.rl_sys_msg})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_return:
                finish();
                break;
            case R.id.rl_sys_msg:
                startActivity(new Intent(this,MessageInfoActivity.class));
                break;
        }
    }
}
