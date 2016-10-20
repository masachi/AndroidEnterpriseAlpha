package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.ContactUsQQAdapter;
import org.example.androidenterprise.adapter.ContactUsServiceAdapter;
import org.example.androidenterprise.adapter.MyWorksAdapter;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_contact_us)
public class ContactUsActivity extends AppCompatActivity implements View.OnClickListener{

    String serviceName[] = {"客服1", "客服2", "客服3", "客服4", "客服5", "客服6", "客服7"};
    List<String> listServiceName = new ArrayList<>();
    String qqName[] = {"123456", "234567", "154562", "4445112", "55151", "54545"};
    List<String> listQQName = new ArrayList<>();

    @ViewInject(R.id.tv_dial_telephone)
    TextView tv_dial_telephone;
    @ViewInject(R.id.gv_service)
    GridView gv_service;
    @ViewInject(R.id.gv_qq)
    GridView gv_qq;
    @ViewInject(R.id.ib_reback)
    ImageButton ib_reback;
    ;


//    TODO get data
    //TODO:通过设定service_gv和qq_gv中的radiobutton的state_checked值，改变客服和QQ客服的状态显示

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        for (int i = 0; i < serviceName.length; i++) {
            listServiceName.add(serviceName[i]);
        }
        ContactUsServiceAdapter contactUsServiceAdapter = new ContactUsServiceAdapter(getApplicationContext(), listServiceName);
        gv_service.setAdapter(contactUsServiceAdapter);

        for (int i = 0; i < qqName.length; i++) {
            listQQName.add(qqName[i]);
        }
        ContactUsQQAdapter contactUsQQAdapter = new ContactUsQQAdapter(getApplicationContext(), listQQName);
        gv_qq.setAdapter(contactUsQQAdapter);
        ib_reback.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_reback :
                finish();
                break;
            default:
                break;
        }
    }
}
