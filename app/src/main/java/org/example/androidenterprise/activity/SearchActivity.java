package org.example.androidenterprise.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.CourseAdapter;
import org.example.androidenterprise.adapter.ItemAdapter;
import org.example.androidenterprise.adapter.SearchOrderAdapter;
import org.example.androidenterprise.fragment.CourseFragment;
import org.example.androidenterprise.utils.InitData;
import org.xutils.x;

import static org.example.androidenterprise.utils.InitData.course;
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
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        CourseAdapter courseAdapter = new CourseAdapter(this, InitData.course.getList());
       // ItemAdapter itemAdapter = new ItemAdapter(this);
        SearchOrderAdapter searchOrderAdapter = new SearchOrderAdapter(this);


        returnIb = (ImageButton) findViewById(R.id.ib_return);
        mainWordEt = (EditText) findViewById(R.id.et_search);
        searchTv = (TextView) findViewById(R.id.ib_search);
        searchRg = (RadioGroup) findViewById(R.id.search_radioGp);
        courseLv = (ListView) findViewById(R.id.lv_course_info);
        orderLv = (ExpandableListView) findViewById(R.id.explv_order);
        recordLv = (ListView) findViewById(R.id.lv_record_info);
        instruGv = (GridView) findViewById(R.id.gv_instrument_info);

        returnIb.setOnClickListener(this);
        searchTv.setOnClickListener(this);
        orderLv.setOnGroupClickListener(this);

        courseLv.setAdapter(courseAdapter);
      //  instruGv.setAdapter(itemAdapter);
        orderLv.setAdapter(searchOrderAdapter);

        for(int i=0;i<olist.size();i++){
            orderLv.expandGroup(i);
        }

        courseLv.setVisibility(View.INVISIBLE);
        orderLv.setVisibility(View.INVISIBLE);
        recordLv.setVisibility(View.INVISIBLE);
        instruGv.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_return:
                finish();
                break;
            case R.id.ib_search:
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
