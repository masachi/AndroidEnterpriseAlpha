package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageButton;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_my_works)
public class MyWorksActivity extends AppCompatActivity {

    @ViewInject(R.id.myworks_return_ib)
    ImageButton myworks_return_ib;
    @ViewInject(R.id.myworks_delete_ib)
    ImageButton myworks_delete_ib;
    @ViewInject(R.id.myworks_gv)
    GridView myworks_gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_works);
        x.view().inject(this);
    }
}
