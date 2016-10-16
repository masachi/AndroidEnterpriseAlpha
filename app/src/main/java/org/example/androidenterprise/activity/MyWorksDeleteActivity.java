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

@ContentView(R.layout.activity_my_works_delete)
public class MyWorksDeleteActivity extends AppCompatActivity {

    @ViewInject(R.id.myworks_delete_ib)
    ImageButton myworks_delete_ib;
    @ViewInject(R.id.myworks_gridview)
    CustomMeasureGridView myworks_gridview;
    @ViewInject(R.id.delete_btn)
    Button delete_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_works_delete);
        x.view().inject(this);
    }
}
