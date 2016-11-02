package org.example.androidenterprise.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.CircleImageView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by byyoung1 on 2016/10/23.:个人资料
 */
@ContentView(R.layout.activity_personal_data)
public class PersonalDataActivity extends Activity {
    @ViewInject(R.id.ib_return)
    ImageButton returnIbtn;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);
        //TODO 从服务器端获取信息设置到相应的TextView中

    }

    @Event(value = {R.id.ib_return, R.id.civ_head})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_return:
                //TODO 返回按钮
                break;
            case R.id.civ_head:
                //TODO 点击查看头像
                break;
        }
    }
}
