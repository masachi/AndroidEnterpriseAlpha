package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

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
    }
//    TODO get use_article about
}
