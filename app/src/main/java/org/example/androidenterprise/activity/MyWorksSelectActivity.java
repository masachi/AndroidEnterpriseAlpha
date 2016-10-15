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

@ContentView(R.layout.activity_my_works_select)
public class MyWorksSelectActivity extends AppCompatActivity {

    @ViewInject(R.id.myworks_select_reback_ib)
    ImageButton myworks_select_reback_ib;
    @ViewInject(R.id.myworks_gridview)
    CustomMeasureGridView myworks_gridview;
    @ViewInject(R.id.confirm_btn)
    Button confirm_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_works_select);
        x.view().inject(this);
    }
}
