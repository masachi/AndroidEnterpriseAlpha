package org.example.androidenterprise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import org.example.androidenterprise.List.CatagoryList;
import org.example.androidenterprise.List.ItemList;
import org.example.androidenterprise.model.CatagoryEntity;
import org.example.androidenterprise.model.InstrumentEntity;
import org.example.androidenterprise.model.ItemEntity;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.InstrumentInfoAdapter;
import org.example.androidenterprise.model.CatagoryEntity;
import org.example.androidenterprise.model.ItemEntity;
import org.example.androidenterprise.view.PullToRefreshView;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_instrument_info)

public class InstrumentInfoActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, PullToRefreshView.OnHeaderRefreshListener, PullToRefreshView.OnFooterRefreshListener {
    @ViewInject(R.id.topbar_instrument_info)
    TopbarView topbar;
    @ViewInject(R.id.instrument_info_tab)
    TabLayout instrumentTL;
    @ViewInject(R.id.instrument_info_gv)
    GridView instrinfoGv;
    @ViewInject(R.id.instrument_pull_refresh_view)
    PullToRefreshView mPullToRefreshView;
    //private PullToRefreshGridView instrinfoGv;
    private InstrumentInfoAdapter instrumentInfoAdapter;
    private List<InstrumentEntity.InstrumentMsgEntity> cataList;
    private List<ItemEntity> adapter_list;
    private List<ItemEntity> ilist;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        //instrinfoGv = (PullToRefreshGridView) findViewById(R.id.instrument_info_gv);

        //cataList = CatagoryList.getData(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ArrayList list = bundle.getParcelableArrayList("list");
       cataList = (List<InstrumentEntity.InstrumentMsgEntity>)list.get(0);

        InitTabDatas();
        adapter_list = ItemList.getData(this);
        instrumentInfoAdapter = new InstrumentInfoAdapter(this, adapter_list);
        instrinfoGv.setAdapter(instrumentInfoAdapter);
        //提取出pos
        for (int i = 0; i < cataList.size(); i++) {
            if(cataList.get(i).getPos()!= null){
                pos = Integer.parseInt(cataList.get(i).getPos());
                break;
            }
        }
        InitSelectedGvDatas();

        instrumentTL.setSmoothScrollingEnabled(true);

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        instrumentTL.getTabAt(pos).select();
                    }
                }, 0);

        instrumentTL.setOnTabSelectedListener(this);
        mPullToRefreshView.setOnHeaderRefreshListener(this);
//        mPullToRefreshView.setOnFooterRefreshListener(this);
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("乐器");
        Drawable ic_return = res.getDrawable(R.mipmap.ic_return);
        topbar.setLeftIb(ic_return);
        topbar.getLeftIb().setVisibility(View.VISIBLE);
        topbar.setLeftIbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Drawable ic_search = res.getDrawable(R.mipmap.ic_search);
        topbar.setRight1Ib(ic_search);
        topbar.getRight1Ib().setVisibility(View.VISIBLE);
        topbar.setRight1IbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SearchActivity.class));
            }
        });
    }

    private void InitTabDatas() {
        for (int i = 0; i < cataList.size(); i++) {
            if (i == pos) {
                instrumentTL.addTab(instrumentTL.newTab().setText(cataList.get(i).getType()), true);
            } else {
                instrumentTL.addTab(instrumentTL.newTab().setText(cataList.get(i).getType()), false);
            }
        }
    }

    private void InitSelectedGvDatas() {
        adapter_list.clear();
        ilist = ItemList.getData(this);
        if (pos == 0) {
            for (int i = 0; i < ilist.size(); i++) {
                if (ilist.get(i).getFresh() == 0) {
                    adapter_list.add(ilist.get(i));
                }
            }
        } else {
            AddAdapter();
        }
        instrumentInfoAdapter.notifyDataSetChanged();
    }

    private void AddAdapter() {
        for (int i = 0; i < ilist.size(); i++) {
            if (ilist.get(i).getFresh() == 0 && ilist.get(i).getType() == pos) {
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
                for (int i = 0; i < ilist.size(); i++) {
                    if (ilist.get(i).getFresh() == 1 && ilist.get(i).getType() == pos) {
                        adapter_list.add(ilist.get(i));
                    }
                }
                instrumentInfoAdapter.notifyDataSetChanged();
                mPullToRefreshView.onHeaderRefreshComplete();
            }
        }, 1000);
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
