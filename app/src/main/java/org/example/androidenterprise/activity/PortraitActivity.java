package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_portrait)

public class PortraitActivity extends BaseActivity {

    @ViewInject(R.id.iv_return)
    ImageView returnIb;
    @ViewInject(R.id.tv_accept)
    TextView acceptBtn;
    @ViewInject(R.id.btn_change_portrait)
    Button changeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Event(value = {R.id.iv_return, R.id.tv_accept, R.id.btn_change_portrait})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_return:
                finish();
                break;
            case R.id.tv_accept:
                finish();
                break;
            case R.id.btn_change_portrait:
                
                break;
        }
    }
}
