package org.example.androidenterprise.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.ContactUsQQAdapter;
import org.example.androidenterprise.adapter.ContactUsServiceAdapter;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

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
    @ViewInject(R.id.ib_reback)
    ImageButton returnIb;
    @ViewInject(R.id.tv_telephone)
    TextView telephoneTv;


//    TODO get data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
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

    @Event(value = {R.id.ib_reback, R.id.tv_dial_telephone})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_reback:
                finish();
                break;
            case R.id.tv_dial_telephone:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" +telephoneTv.getText().toString());
                intent.setData(data);
                startActivity(intent);
                break;
        }
    }
}
