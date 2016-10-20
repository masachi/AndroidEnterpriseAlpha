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

    @ViewInject(R.id.ib_reback)
    ImageButton ib_reback;
    @ViewInject(R.id.gv_myworks)
    CustomMeasureGridView gv_myworks;
    @ViewInject(R.id.btn_delete)
    Button btn_delete;

    // TODO get works_data and  delete
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_works_delete);
        x.view().inject(this);
        ib_reback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_reback:
                Intent intent = new Intent(MyWorksDeleteActivity.this, MyWorksActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
