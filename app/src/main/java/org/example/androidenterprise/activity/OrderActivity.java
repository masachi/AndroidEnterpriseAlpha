package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.OrderAdapter;
import org.example.androidenterprise.view.CustomMeasureListView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_order)

public class OrderActivity extends BaseActivity {

    @ViewInject(R.id.ib_return)
    ImageButton returnIb;
    @ViewInject(R.id.lv_order)
    CustomMeasureListView orderLv;
    @ViewInject(R.id.ib_search)
    ImageButton searchIb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: 2016/10/16 Add adapter in this place after server provide the port and URL

        OrderAdapter ordAdapter = new OrderAdapter(this);

        orderLv.setAdapter(ordAdapter);
    }


    @Event(value = {R.id.ib_return, R.id.ib_search})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_return:
                finish();
                break;
            case R.id.ib_search:
                startActivity(new Intent(this,SearchActivity.class));
                break;
        }
    }
}
