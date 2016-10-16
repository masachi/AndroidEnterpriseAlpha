package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import org.example.androidenterprise.R;
import org.example.androidenterprise.view.CustomMeasureListView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_order)

public class OrderActivity extends BaseActivity {

    @ViewInject(R.id.order_return_ib)
    ImageButton returnIb;
    @ViewInject(R.id.order_lv)
    CustomMeasureListView orderLv;
    @ViewInject(R.id.order_search_ib)
    ImageButton searchIb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: 2016/10/16 Add adapter in this place after server provide the port and URL
    }


    @Event(value = {R.id.order_return_ib, R.id.order_search_ib})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.order_return_ib:
                finish();
                break;
            case R.id.order_search_ib:
                startActivity(new Intent(this,SearchActivity.class));
                break;
        }
    }
}
