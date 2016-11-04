package org.example.androidenterprise.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.CircleImageView;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by byyoung1 on 2016/10/23.:个人资料
 */
@ContentView(R.layout.activity_personal_data)
public class PersonalDataActivity extends Activity {
    @ViewInject(R.id.civ_head)
    CircleImageView headCiv;
    @ViewInject(R.id.tv_account_mes)
    TextView accountmesTv;
    @ViewInject(R.id.tv_area_mes)
    TextView areamesTv;
    @ViewInject(R.id.tv_other_mes)
    TextView othermesTv;
    @ViewInject(R.id.tv_self_mes)
    TextView selfmesTv;
    @ViewInject(R.id.topbar_personal_data)
    TopbarView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        //TODO 从服务器端获取信息设置到相应的TextView中

    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("个人资料");
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

    @Event(value = {R.id.civ_head})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.civ_head:
                //TODO 点击查看头像
                break;
        }
    }
}
