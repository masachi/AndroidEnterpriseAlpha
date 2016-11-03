package org.example.androidenterprise.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.ContactUsQQAdapter;
import org.example.androidenterprise.adapter.ContactUsServiceAdapter;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojiao : 联系我们
 */

@ContentView(R.layout.activity_contact_us)
public class ContactUsActivity extends AppCompatActivity {

    String serviceName[] = {"客服1", "客服2", "客服3", "客服4", "客服5", "客服6", "客服7"};
    List<String> listServiceName = new ArrayList<>();
    String qqName[] = {"123456", "234567", "154562", "4445112", "55151", "54545"};
    List<String> listQQName = new ArrayList<>();


    @ViewInject(R.id.tv_dial_telephone)
    TextView dailTv;
    @ViewInject(R.id.gv_service)
    GridView serviceGv;
    @ViewInject(R.id.gv_qq)
    GridView qqGv;
    @ViewInject(R.id.tv_telephone)
    TextView telephoneTv;
    @ViewInject(R.id.tv_dial_telephone)
    TextView tv_dial_telephone;
    @ViewInject(R.id.topbar_contact_us)
    TopbarView contactusTopbar;


//    TODO get data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        String title = "联系我们";
        contactusTopbar.setTopbarTv(title);
        Drawable ic_return = getResources().getDrawable(R.mipmap.ic_return);
        contactusTopbar.setLeftIb(ic_return);
        contactusTopbar.getLeftIb().setVisibility(View.VISIBLE);
        contactusTopbar.setLeftIbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        for (int i = 0; i < serviceName.length; i++) {
            listServiceName.add(serviceName[i]);
        }
        ContactUsServiceAdapter contactUsServiceAdapter = new ContactUsServiceAdapter(getApplicationContext(), listServiceName);
        serviceGv.setAdapter(contactUsServiceAdapter);

        for (int i = 0; i < qqName.length; i++) {
            listQQName.add(qqName[i]);
        }
        ContactUsQQAdapter contactUsQQAdapter = new ContactUsQQAdapter(getApplicationContext(), listQQName);
        qqGv.setAdapter(contactUsQQAdapter);
    }


    @Event(value = {R.id.tv_dial_telephone})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_dial_telephone:
//               TODO 拔打电话
                break;
        }
    }
}
