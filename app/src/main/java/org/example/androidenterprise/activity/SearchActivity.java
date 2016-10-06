package org.example.androidenterprise.activity;

import android.opengl.ETC1;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.CourseAdapter;
import org.example.androidenterprise.adapter.ItemAdapter;
import org.example.androidenterprise.adapter.OrderAdapter;

import static org.example.androidenterprise.utils.InitData.olist;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener,ExpandableListView.OnGroupClickListener{
    private ImageButton returnIb;
    private EditText mainWordEt;
    private TextView searchTv;
    private RadioGroup searchRg;
    private ListView courseLv;
    // TODO: 2016/10/5 listview或者expandablelistview实现order以及record
    //private ListView orderLv;
    private ExpandableListView orderLv;
    private ListView recordLv;
    private GridView instruGv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        CourseAdapter courseAdapter = new CourseAdapter(this);
        ItemAdapter itemAdapter = new ItemAdapter(this);
        OrderAdapter orderAdapter = new OrderAdapter(this);


        returnIb = (ImageButton) findViewById(R.id.search_return_ib);
        mainWordEt = (EditText) findViewById(R.id.search_et);
        searchTv = (TextView) findViewById(R.id.search_ib);
        searchRg = (RadioGroup) findViewById(R.id.search_radioGp);
        courseLv = (ListView) findViewById(R.id.search_info_course_lv);
        orderLv = (ExpandableListView) findViewById(R.id.search_info_order_time_lv);
        recordLv = (ListView) findViewById(R.id.search_info_record_lv);
        instruGv = (GridView) findViewById(R.id.search_gv);

        returnIb.setOnClickListener(this);
        searchTv.setOnClickListener(this);
        orderLv.setOnGroupClickListener(this);

        courseLv.setAdapter(courseAdapter);
        instruGv.setAdapter(itemAdapter);
        orderLv.setAdapter(orderAdapter);

        for(int i=0;i<olist.size();i++){
            orderLv.expandGroup(i);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_return_ib:
                finish();
                break;
            case R.id.search_ib:
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        return true;
    }
}
