package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.widget.ListView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.adapter.SystemMessageAdapter;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_message_info)

public class MessageInfoActivity extends BaseActivity {

    @ViewInject(R.id.lv_msg_info)
    ListView sysInfoLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SystemMessageAdapter sysMsgAdapter = new SystemMessageAdapter(this);
        sysInfoLv.setAdapter(sysMsgAdapter);
    }
}
