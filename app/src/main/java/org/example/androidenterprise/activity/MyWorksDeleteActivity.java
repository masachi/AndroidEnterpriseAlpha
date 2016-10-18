package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.CustomMeasureGridView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_my_works_delete)
public class MyWorksDeleteActivity extends AppCompatActivity implements View.OnClickListener {

    @ViewInject(R.id.myworks_gridview)
    CustomMeasureGridView myworks_gridview;
    @ViewInject(R.id.delete_btn)
    Button delete_btn;
    @ViewInject(R.id.myworks_reback_ib)
    ImageButton myworks_reback_ib;
// TODO get works_data and  delete
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_works_delete);
        x.view().inject(this);
        myworks_reback_ib.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.myworks_reback_ib:
                Intent intent = new Intent(MyWorksDeleteActivity.this,MyWorksActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
