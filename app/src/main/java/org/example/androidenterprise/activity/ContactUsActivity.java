package org.example.androidenterprise.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.load.engine.Resource;
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

import static org.example.androidenterprise.utils.Constant.serviceName;

/**
 * Created by chenguojiao : 联系我们
 */

@ContentView(R.layout.activity_contact_us)
public class ContactUsActivity extends AppCompatActivity {

//    String serviceName[] = {"客服1", "客服2", "客服3", "客服4", "客服5", "客服6", "客服7"};

//    String qqName[] = {"123456", "234567", "154562", "4445112", "55151", "54545"};
//    List<String> listQQName = new ArrayList<>();

    @ViewInject(R.id.tv_dial_telephone)
    TextView dailTv;
    @ViewInject(R.id.gv_service)
    GridView serviceGv;
    //    @ViewInject(R.id.gv_qq)
//    GridView qqGv;
    @ViewInject(R.id.tv_telephone)
    TextView telephoneTv;
    @ViewInject(R.id.tv_dial_telephone)
    TextView dialTelephoneTv;
    @ViewInject(R.id.topbar_contact_us)
    TopbarView topbar;

    List<String> listServiceName = new ArrayList<>();

//    TODO get data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        for (int i = 0; i < serviceName.length; i++) {
            listServiceName.add(serviceName[i]);
        }
        ContactUsServiceAdapter contactUsServiceAdapter = new ContactUsServiceAdapter(getApplicationContext(), listServiceName);
        serviceGv.setAdapter(contactUsServiceAdapter);

//        dialTelephoneTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10010"));
//                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    // TODO: Consider calling
//                    //    ActivityCompat#requestPermissions
//                    // here to request the missing permissions, and then overriding
//                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                    //                                          int[] grantResults)
//                    // to handle the case where the user grants the permission. See the documentation
//                    // for ActivityCompat#requestPermissions for more details.
//                    return;
//                }
//                startActivity(intent);
//                Toast.makeText(ContactUsActivity.this, "hhhhhh", Toast.LENGTH_SHORT).show();
//            }
//        });
//        for (int i = 0; i < qqName.length; i++) {
//            listQQName.add(qqName[i]);
//        }
//        ContactUsQQAdapter contactUsQQAdapter = new ContactUsQQAdapter(getApplicationContext(), listQQName);
//        qqGv.setAdapter(contactUsQQAdapter);
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("联系我们");
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

    @Event(value = {R.id.tv_dial_telephone})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_dial_telephone:
//               TODO 拔打电话
                break;
        }
    }
}
