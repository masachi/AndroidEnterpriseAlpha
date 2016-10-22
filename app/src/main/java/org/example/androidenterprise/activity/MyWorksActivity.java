package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.MyWorksAdapter;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojiao : 我的作品
 */

@ContentView(R.layout.activity_my_works)
public class MyWorksActivity extends AppCompatActivity implements View.OnClickListener {


    @ViewInject(R.id.ib_reback)
    ImageButton ib_reback;
    @ViewInject(R.id.ib_delete)
    ImageButton ib_delete;
    @ViewInject(R.id.gv_myworks)
    GridView gv_myworks;

    private int works_data[] = {R.drawable.ic_shoot,R.drawable.ic_works,R.drawable.ic_works,R.drawable.ic_works,
            R.drawable.ic_works,R.drawable.ic_works};
    private List<Integer> list_works;
    // TODO get works_data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_works);
        x.view().inject(this);

        list_works = getWorksData();
        MyWorksAdapter myWorksAdapter = new MyWorksAdapter(getApplicationContext(),list_works);
        gv_myworks.setAdapter(myWorksAdapter);

        ib_reback.setOnClickListener(this);
        ib_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_reback:
               finish();
                break;
            case R.id.ib_delete:
                Intent intent_delete = new Intent(MyWorksActivity.this, MyWorksDeleteActivity.class);
                startActivity(intent_delete);
                break;
            default:
                break;
        }
    }
    private List<Integer> getWorksData(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i< works_data.length; i++){
            list.add(works_data[i]);
        }
        return list;
    }
}
