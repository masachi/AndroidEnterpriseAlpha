package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.ContactUsQQAdapter;
import org.example.androidenterprise.adapter.ContactUsServiceAdapter;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_contact_us)

public class ContactUsActivity extends AppCompatActivity {

    String serviceName[] = {"客服1", "客服2", "客服3", "客服4", "客服5", "客服6", "客服7"};
    List<String> listServiceName = new ArrayList<>();
    String qqName[]={"123456","234567","154562","4445112","55151","54545"};
    List<String> listQQName=new ArrayList<>();

    @ViewInject(R.id.contact_us_return_ib)
    ImageButton contact_us_return_ib;
    @ViewInject(R.id.telephone_tv)
    TextView telephone_tv;
    @ViewInject(R.id.dial_telephone_tv)
    TextView dial_telephone_tv;
    @ViewInject(R.id.service_gv)
    GridView service_gv;
    @ViewInject(R.id.qq_gv)
    GridView qq_gv;
    //TODO:通过设定service_gv和qq_gv中的radiobutton的state_checked值，改变客服和QQ客服的状态显示

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        for (int i = 0; i < 7; i++) {
            listServiceName.add(serviceName[i]);
        }
        ContactUsServiceAdapter contactUsServiceAdapter = new ContactUsServiceAdapter(getApplicationContext(), listServiceName);
        service_gv.setAdapter(contactUsServiceAdapter);

        for (int i = 0; i < 6; i++) {
            listQQName.add(qqName[i]);
        }
        ContactUsQQAdapter contactUsQQAdapter=new ContactUsQQAdapter(getApplicationContext(),listQQName);
        qq_gv.setAdapter(contactUsQQAdapter);
    }
}
