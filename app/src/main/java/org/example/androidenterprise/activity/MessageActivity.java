package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.readystatesoftware.viewbadger.BadgeView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_message)

public class MessageActivity extends BaseActivity {

    @ViewInject(R.id.rl_sys_msg)
    RelativeLayout sysMsgRl;
    @ViewInject(R.id.topbar_message)
    TopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTopbar();
        BadgeView badgeView = (BadgeView) findViewById(R.id.badget_msg);
        badgeView.setText("12");
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("我的留言");
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

    @Event(value = {R.id.rl_sys_msg})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_sys_msg:
                startActivity(new Intent(this, MessageInfoActivity.class));
                break;
        }
    }
}
