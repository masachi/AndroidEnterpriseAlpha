package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.RecordAdapter;
import org.example.androidenterprise.view.RecordExpandableListView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_record)

public class RecordActivity extends BaseActivity {

    @ViewInject(R.id.ib_return)
    ImageButton returnIb;
    @ViewInject(R.id.ib_search)
    ImageButton searchIb;
    @ViewInject(R.id.explv_record)
    RecordExpandableListView recordExpLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecordAdapter recAdapter = new RecordAdapter(this);
        recordExpLv.setAdapter(recAdapter);
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
