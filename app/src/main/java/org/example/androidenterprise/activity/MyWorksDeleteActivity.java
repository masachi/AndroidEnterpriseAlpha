package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.MyWorksAdapter;
import org.example.androidenterprise.view.CustomMeasureGridView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenguojiao : 删除作品
 */

@ContentView(R.layout.activity_my_works_delete)
public class MyWorksDeleteActivity extends AppCompatActivity implements View.OnClickListener {

    @ViewInject(R.id.ib_reback)
    ImageButton ib_reback;
    @ViewInject(R.id.gv_myworks)
    CustomMeasureGridView gv_myworks;
    @ViewInject(R.id.btn_delete)
    Button btn_delete;

    private int works_data[] = {R.drawable.ic_shoot,R.drawable.ic_works,R.drawable.ic_works,R.drawable.ic_works,
            R.drawable.ic_works,R.drawable.ic_works};
    private List<Integer> list_works;
    MyWorksAdapter myWorksAdapter;

    // TODO get works_data and  delete
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_works_delete);
        x.view().inject(this);

        btn_delete.setText("删除");
        ib_reback.setOnClickListener(this);
        btn_delete.setOnClickListener(this);

        list_works = getWorksData();
        myWorksAdapter = new MyWorksAdapter(getApplicationContext(),list_works);
        gv_myworks.setAdapter(myWorksAdapter);
        gv_myworks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                list_works.remove(i);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_reback:
                finish();
                break;
            case R.id.btn_delete:
                myWorksAdapter.notifyDataSetChanged();
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
