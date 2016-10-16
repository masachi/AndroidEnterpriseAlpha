package org.example.androidenterprise.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import org.example.androidenterprise.R;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_edit_add)

public class EditAddActivity extends AppCompatActivity {

    @ViewInject(R.id.edit_add_return_ib)
    ImageButton edit_add_return_ib;
    @ViewInject(R.id.edit_add_consignee_et)
    EditText edit_add_consignee_et;
    @ViewInject(R.id.edit_add_phonenum_et)
    EditText edit_add_phonenum_et;
    @ViewInject(R.id.edit_add_detailed_et)
    EditText edit_add_detailed_et;
    @ViewInject(R.id.edit_add_delete)
    TextView edit_add_delete;
    @ViewInject(R.id.edit_add_delete_img)
    ImageView edit_add_delete_img;
    @ViewInject(R.id.edit_add_rl_delete)
    RelativeLayout edit_add_rl_delete;
    @ViewInject(R.id.edit_add_conserve)
    Button edit_add_conserve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_add);
        x.view().inject(this);
    }

    @Event(value = {R.id.edit_add_return_ib, R.id.edit_add_consignee_et, R.id.edit_add_phonenum_et, R.id.edit_add_detailed_et, R.id.edit_add_delete, R.id.edit_add_delete_img, R.id.edit_add_rl_delete, R.id.edit_add_conserve})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_add_return_ib:
                finish();
                break;
            case R.id.edit_add_consignee_et:
                break;
            case R.id.edit_add_phonenum_et:
                break;
            case R.id.edit_add_detailed_et:
                break;
            case R.id.edit_add_delete:
                break;
            case R.id.edit_add_delete_img:
                break;
            case R.id.edit_add_rl_delete:
                break;
            case R.id.edit_add_conserve:
                break;
        }
    }
}
