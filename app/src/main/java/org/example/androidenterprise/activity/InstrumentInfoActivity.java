package org.example.androidenterprise.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import org.example.androidenterprise.List.CatagoryList;
import org.example.androidenterprise.List.ItemList;
import org.example.androidenterprise.model.CatagoryEntity;
import org.example.androidenterprise.model.ItemEntity;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.InstrumentInfoAdapter;
import org.example.androidenterprise.view.PullToRefreshView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

public class InstrumentInfoActivity extends AppCompatActivity implements View.OnClickListener,TabLayout.OnTabSelectedListener,PullToRefreshView.OnHeaderRefreshListener, PullToRefreshView.OnFooterRefreshListener {
    private TabLayout instrumentTL;
    //private PullToRefreshGridView instrinfoGv;
    private PullToRefreshView mPullToRefreshView;
    private GridView instrinfoGv;
    private ImageButton returnIb;
    private InstrumentInfoAdapter instrumentInfoAdapter;
    private List<CatagoryEntity> cataList;
    private List<ItemEntity> adapter_list;
    private List<ItemEntity> ilist;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument_info);
        instrumentTL = (TabLayout) findViewById(R.id.instrument_info_tab);
        //instrinfoGv = (PullToRefreshGridView) findViewById(R.id.instrument_info_gv);
        instrinfoGv = (GridView) findViewById(R.id.instrument_info_gv);
        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.instrument_pull_refresh_view);
        returnIb = (ImageButton) findViewById(R.id.instrument_return_ib);

        cataList = CatagoryList.getData(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        pos = Integer.parseInt(bundle.getString("tab_selected"));

        InitTabDatas();
        adapter_list = ItemList.getData(this);
        instrumentInfoAdapter = new InstrumentInfoAdapter(this,adapter_list);
        instrinfoGv.setAdapter(instrumentInfoAdapter);
        InitSelectedGvDatas();

        instrumentTL.setSmoothScrollingEnabled(true);
        instrumentTL.setScrollPosition(pos,0f,true);
        instrumentTL.scrollTo(calculateScrollXForTab(pos,0f),0);

        instrumentTL.setOnTabSelectedListener(this);
        mPullToRefreshView.setOnHeaderRefreshListener(this);
        mPullToRefreshView.setOnFooterRefreshListener(this);
        returnIb.setOnClickListener(this);
    }

    private void InitTabDatas(){
        for(int i=0;i<cataList.size();i++){
            if(i == pos){
                instrumentTL.addTab(instrumentTL.newTab().setText(cataList.get(i).getType()),true);
            }
            else {
                instrumentTL.addTab(instrumentTL.newTab().setText(cataList.get(i).getType()), false);
            }
        }
    }

    private void InitSelectedGvDatas(){
        adapter_list.clear();
        ilist = ItemList.getData(this);
        if(pos == 0){
            for(int i=0;i<ilist.size();i++){
                if(ilist.get(i).getFresh() == 0){
                    adapter_list.add(ilist.get(i));
                }
            }
        }
        else{
            AddAdapter();
        }
        instrumentInfoAdapter.notifyDataSetChanged();
    }

    private void AddAdapter(){
        for(int i=0;i<ilist.size();i++){
            if(ilist.get(i).getFresh() == 0 && ilist.get(i).getType() == pos){
                adapter_list.add(ilist.get(i));
            }
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        pos = tab.getPosition();
        InitSelectedGvDatas();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onFooterRefresh(PullToRefreshView view) {
//        mPullToRefreshView.postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("上拉加载");
//                listDrawable.add(R.drawable.pic1);
//                adapter.notifyDataSetChanged();
//                mPullToRefreshView.onFooterRefreshComplete();
//            }
//        }, 1000);
    }

    @Override
    public void onHeaderRefresh(PullToRefreshView view) {
        mPullToRefreshView.postDelayed(new Runnable() {

            @Override
            public void run() {
                // 设置更新时间
                // mPullToRefreshView.onHeaderRefreshComplete("最近更新:01-23 12:01");
                for(int i=0;i<ilist.size();i++){
                    if(ilist.get(i).getFresh() == 1 && ilist.get(i).getType() == pos){
                        adapter_list.add(ilist.get(i));
                    }
                }
                instrumentInfoAdapter.notifyDataSetChanged();
                mPullToRefreshView.onHeaderRefreshComplete();
            }
        }, 1000);
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    private int calculateScrollXForTab(int position, float positionOffset) {
        if (instrumentTL.getTabMode() == TabLayout.MODE_SCROLLABLE) {
            View selectedChild = instrumentTL.getChildAt(position);
            View nextChild = position + 1 >= instrumentTL.getChildCount() ? null : instrumentTL.getChildAt(position + 1);
            int selectedWidth = selectedChild == null ? 0 : selectedChild.getWidth();
            int nextWidth = nextChild == null ? 0 : nextChild.getWidth();
            return (int) (((float) selectedChild.getLeft() + (float) (selectedWidth + nextWidth) * positionOffset * 0.5F + (float) selectedChild.getWidth() * 0.5F) - (float) selectedChild.getWidth() * 0.5F);
        } else {
            return 0;
        }
    }
}
