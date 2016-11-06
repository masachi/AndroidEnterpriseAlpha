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
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import com.bumptech.glide.load.engine.Resource;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.CSCustomServiceInfo;
import org.example.androidenterprise.MyApplication;
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

import static io.rong.imkit.utils.SystemUtils.getCurProcessName;
import static org.example.androidenterprise.utils.Constant.serviceName;

/**
 * Created by chenguojiao : 联系我们
 */

@ContentView(R.layout.activity_contact_us)
public class ContactUsActivity extends BaseActivity {

    @ViewInject(R.id.tv_dial_telephone)
    TextView dailTv;
    @ViewInject(R.id.gv_service)
    GridView serviceGv;
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

        serviceGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    connect("3xheWPjjmiPztJ8LTpVtMkxCmntzjCygMK8AxneEUJtzNiszBisNBbFuXv1ri4Vj1squkKQfjQ884vtuk8OuFg==");
                }else {
                    Toast.makeText(ContactUsActivity.this, "小二休息了。。。", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
//              拔打电话
                String data = "tel:10010";
                Uri uri = Uri.parse(data);
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(uri);
                startActivity(intent);
                break;
        }
    }

    /**
     * 建立与融云服务器的连接
     *
     * @param token
     */
    private void connect(String token) {

        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext()))) {

            /**
             * IMKit SDK调用第二步,建立与服务器的连接
             */
            RongIM.connect(token, new RongIMClient.ConnectCallback() {

                /**
                 * Token 错误，在线上环境下主要是因为 Token 已经过期，您需要向 App Server 重新请求一个新的 Token
                 */
                @Override
                public void onTokenIncorrect() {

                    Log.d("LoginActivity", "--onTokenIncorrect");
                }

                /**
                 * 连接融云成功
                 * @param userid 当前 token
                 */
                @Override
                public void onSuccess(String userid) {

                    Log.d("LoginActivity", "--onSuccess" + userid);
                    CSCustomServiceInfo.Builder csBuilder = new CSCustomServiceInfo.Builder();
                    CSCustomServiceInfo csInfo = csBuilder.nickName("融云").build();

//*//**
// * 启动客户服聊天界面。
// *
// * @param context           应用上下文。
// * @param customerServiceId 要与之聊天的客服 Id。
// * @param title             聊天的标题，如果传入空值，则默认显示与之聊天的客服名称。
// * @param customServiceInfo 当前使用客服者的用户信息。{@link io.rong.imlib.model.CSCustomServiceInfo}
// *//*
                    RongIM.getInstance().startCustomerServiceChat(ContactUsActivity.this, "KEFU147774053111627", "在线客服", csInfo);
//                   startActivity(new Intent(MainActivity.this, TalkActivity.class));
//                    finish();
                }

                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 */
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {

                    Log.d("LoginActivity", "--onError" + errorCode);
                }
            });
        }
    }
}
