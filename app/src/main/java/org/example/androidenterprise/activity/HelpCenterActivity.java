package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.R;
import org.example.androidenterprise.model.CourseInfoEntity;
import org.example.androidenterprise.model.HelpCenterEntity;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static org.example.androidenterprise.utils.Constant.HELP_CENTER_URL;

/**
 * Created by chenguojiao : 帮助中心
 */

@ContentView(R.layout.activity_help_center)

public class HelpCenterActivity extends AppCompatActivity {


    @ViewInject(R.id.tv_use_article_context)
    TextView tv_use_article_context;
    @ViewInject(R.id.tv_about_context)
    TextView tv_about_context;
    @ViewInject(R.id.ib_reback)
    ImageButton ib_reback;

    private HelpCenterEntity response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_help_center);
        x.view().inject(this);
        ib_reback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//    TODO get use_article about

        RequestParams params = new RequestParams(HELP_CENTER_URL);
        params.setAsJsonContent(true);
        params.setBodyContent("{\"code\":\"1020\"}");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                response = new Gson().fromJson(result, new TypeToken<HelpCenterEntity>() {
                }.getType());
                getHelpCenterData();
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

    public void getHelpCenterData(){
        tv_use_article_context.setText(response.getContent());
        tv_about_context.setText(response.getAbout());
    }

}
