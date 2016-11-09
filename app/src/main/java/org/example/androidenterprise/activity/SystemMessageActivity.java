package org.example.androidenterprise.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.CourseAdapter;
import org.example.androidenterprise.adapter.SystemMessageAdapter;
import org.example.androidenterprise.model.CourseEntity;
import org.example.androidenterprise.model.ListRequestEntity;
import org.example.androidenterprise.model.SystemMessageEntity;
import org.example.androidenterprise.model.SystemMessageRequestEntity;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static org.example.androidenterprise.utils.Constant.*;

@ContentView(R.layout.activity_system_message)

public class SystemMessageActivity extends BaseActivity {

    @ViewInject(R.id.lv_msg_info)
    ListView sysInfoLv;
    @ViewInject(R.id.topbar_message_info)
    TopbarView topbar;
    private SystemMessageEntity response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTopbar();
        final SystemMessageRequestEntity request=new SystemMessageRequestEntity();
        request.setCode("2000");
        request.setUse_id(USERID);
        request.setRole("student");
        RequestParams params=new RequestParams(SYSTEM_MESSAGE_URL);
        params.setAsJsonContent(true);
        params.setBodyContent(new Gson().toJson(params));
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("系统消息",result);
                response=new Gson().fromJson(result,new TypeToken<SystemMessageEntity>(){}.getType());
                SystemMessageAdapter systemMessageAdapter=new SystemMessageAdapter(getBaseContext(),response.getList());
                systemMessageNum=response.getList().size();
                Log.e("系统消息的个数",String.valueOf(systemMessageNum));
                sysInfoLv.setAdapter(systemMessageAdapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("系统消息");
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
}
