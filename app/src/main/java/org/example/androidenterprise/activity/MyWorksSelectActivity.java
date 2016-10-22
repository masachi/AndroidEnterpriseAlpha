package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.CustomMeasureGridView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by chenguojiao : 选择作品
 */

@ContentView(R.layout.activity_my_works_select)
public class MyWorksSelectActivity extends AppCompatActivity {
    @ViewInject(R.id.ib_reback)
    ImageButton ib_reback;
    @ViewInject(R.id.gv_myworks)
    CustomMeasureGridView gv_myworks;
    @ViewInject(R.id.btn_confirm)
    Button btn_confirm;

// TODO get works_data and select

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_works_select);
        x.view().inject(this);
    }
}
