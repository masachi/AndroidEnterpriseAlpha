package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.model.RecordEntity;
import org.example.androidenterprise.model.RecordRequestEntity;
import org.example.androidenterprise.view.RecordExpandableListView;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static org.example.androidenterprise.utils.Constant.RECORD_URL;

@ContentView(R.layout.activity_record)

public class RecordActivity extends BaseActivity {

    @ViewInject(R.id.topbar_record)
    TopbarView topbar;
    @ViewInject(R.id.explv_record)
    RecordExpandableListView recordExpLv;

    RecordEntity response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        RecordRequestEntity request = new RecordRequestEntity();
        request.setCode("2009");
        request.setRole("student");
        request.setUser_id(1);
        RequestParams params = new RequestParams(RECORD_URL);
        params.setAsJsonContent(true);
        params.setBodyContent(new Gson().toJson(request));
        x.http().post(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.e("23333", result);
                response = new Gson().fromJson(result, new TypeToken<RecordEntity>() {
                }.getType());
//                RecordAdapter recAdapter = new RecordAdapter(this);
//                recordExpLv.setAdapter(recAdapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("233", "crrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
                ex.printStackTrace();

                Toast.makeText(RecordActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
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
        topbar.setTopbarTv("交易记录");
        Drawable ic_return = res.getDrawable(R.mipmap.ic_return);
        topbar.setLeftIb(ic_return);
        topbar.getLeftIb().setVisibility(View.VISIBLE);
        topbar.setLeftIbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Drawable ic_search = res.getDrawable(R.mipmap.ic_search);
        topbar.setRight1Ib(ic_search);
        topbar.getRight1Ib().setVisibility(View.VISIBLE);
        topbar.setRight1IbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SearchActivity.class));
            }
        });
    }
}
