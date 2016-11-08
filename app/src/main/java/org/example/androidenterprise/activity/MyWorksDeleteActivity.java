package org.example.androidenterprise.activity;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.MyWorksSelectAdapter;
import org.example.androidenterprise.view.CustomMeasureGridView;
import org.example.androidenterprise.view.TopbarView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenguojiao : 删除作品
 */

@ContentView(R.layout.activity_my_works_delete)
public class MyWorksDeleteActivity extends AppCompatActivity {

    @ViewInject(R.id.gv_myworks)
    CustomMeasureGridView myworksGv;
    @ViewInject(R.id.btn_delete)
    Button deleteBtn;
    @ViewInject(R.id.topbar_my_works_delete)
    TopbarView topbar;

    private ArrayList<Map<String, String>> listData;
    private Map<String, String> mapData;
    private ArrayList<Integer> myWorksPisture;
    private ArrayList<String> myWorksTime, myWorksDate;
    ArrayList<String> deleteList;
    MyWorksSelectAdapter myWorksSelectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setTopbar();
        initDate();
        new MyOpenWork().execute();
    }

    private void setTopbar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//沉浸式状态栏
        Resources res = getResources();
        topbar.setTopbarTv("删除");
        Drawable ic_return = res.getDrawable(R.mipmap.ic_return);
        topbar.setLeftIb(ic_return);
        topbar.getLeftIb().setVisibility(View.VISIBLE);
        topbar.setLeftIbOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Event(value = {R.id.btn_delete})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_delete:
                deleteList = myWorksSelectAdapter.getNameList();
                Log.w("deleteList", deleteList.toString());
                if (deleteList.size() > 0) {
                    StringBuffer sbBuffer = new StringBuffer();
                    sbBuffer.append("您已删除： ");
                    for (int i = 0; i < deleteList.size(); i++) {
                        for (int j = 0; j < listData.size(); j++) {
                            if (listData.get(j).get("date") == deleteList.get(i)) {
                                listData.remove(j);
                            }
                        }
                    }
                    sbBuffer.append(deleteList.size() + " 个");
                    myWorksSelectAdapter.fresh();
                    Toast.makeText(MyWorksDeleteActivity.this, sbBuffer.toString(),
                            Toast.LENGTH_LONG).show();
                    new MyWorksDeleteActivity.MyOpenWork().execute();
                }
                break;
        }
    }

    void initDate() {
        listData = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mapData = new HashMap<>();
            mapData.put("img", R.drawable.ic_head_default + "");
            mapData.put("time", i + "0s");
            mapData.put("date", "2016-05-06 " + "1" + i + ":00");
            listData.add(mapData);
        }
    }

    class MyOpenWork extends AsyncTask<String, String, Boolean> {
        ProgressDialog dialog;

        @Override
        protected Boolean doInBackground(String... arg0) {
            myWorksSelectAdapter = new MyWorksSelectAdapter(MyWorksDeleteActivity.this, listData);
            return true;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MyWorksDeleteActivity.this);
            dialog.setMessage("初始化图片,请稍候...");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            dialog.dismiss();
            myHandler.sendEmptyMessage(0);
        }
    }

    Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            myworksGv.setAdapter(myWorksSelectAdapter);
            // 设置点击监听
            myworksGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1,
                                        int position, long arg3) {

                    myWorksSelectAdapter.changeState(position);
                }
            });
        }
    };
}