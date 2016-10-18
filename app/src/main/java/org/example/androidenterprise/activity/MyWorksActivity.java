package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_my_works)
public class MyWorksActivity extends AppCompatActivity implements View.OnClickListener{

    @ViewInject(R.id.myworks_return_ib)
    ImageButton myworks_return_ib;
    @ViewInject(R.id.myworks_delete_ib)
    ImageButton myworks_delete_ib;
    @ViewInject(R.id.myworks_gv)
    GridView myworks_gv;
// TODO get works_data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_works);
        x.view().inject(this);
        myworks_return_ib.setOnClickListener(this);
        myworks_delete_ib.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.myworks_return_ib:
                Intent intent_reback = new Intent(MyWorksActivity.this,InsideActivity.class);
                intent_reback.putExtra( "id" , 1);
                startActivity(intent_reback);
                break;
            case R.id.myworks_delete_ib:
                Intent intent_delete = new Intent(MyWorksActivity.this,MyWorksDeleteActivity.class);
                startActivity(intent_delete);
                break;
            default:
                break;
        }
    }
}
