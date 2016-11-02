package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

//Created by caishuang:发布反馈
@ContentView(R.layout.activity_release_feed_back)
public class ReleaseFeedBackActivity extends AppCompatActivity implements View.OnClickListener {

    @ViewInject(R.id.ib_back1)
    ImageButton backIb;
    @ViewInject(R.id.tv_release)
    TextView releaseTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release_feed_back);
        x.view().inject(this);

        backIb.setOnClickListener(this);
        releaseTv.setOnClickListener(this);

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_back1:
                finish();
                break;
            case R.id.tv_release:
                //TODO 上传到服务器
                break;
        }
    }
}
