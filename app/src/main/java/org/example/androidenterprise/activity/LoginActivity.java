package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.List.UserInfoList;
import org.example.androidenterprise.R;
import org.example.androidenterprise.model.LoginResponseEntity;
import org.example.androidenterprise.model.UserInfoEntity;
import org.example.androidenterprise.utils.InitData;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

@ContentView(R.layout.activity_login)

public class LoginActivity extends AppCompatActivity implements View.OnTouchListener {
    private String LOGIN_URL = "http://112.124.38.1:12345/login";

    @ViewInject(R.id.btn_login)
    Button loginBtn;
    @ViewInject(R.id.btn_register)
    Button s_registerBtn;
    @ViewInject(R.id.edittext_username)
    EditText usernameEt;
    @ViewInject(R.id.edittext_password)
    EditText passwordEt;
    @ViewInject(R.id.visible_button)
    ImageButton visBtn;
    @ViewInject(R.id.edittext_verify)
    EditText verifyEt;
    @ViewInject(R.id.verify_btn)
    Button verifyBtn;
    @ViewInject(R.id.btn_register_big)
    Button l_registerBtn;

    private List<UserInfoEntity> ulist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        x.view().inject(this);

        InitData.initData(this);


        l_registerBtn.setOnTouchListener(this);
        verifyBtn.setOnTouchListener(this);
        visBtn.setOnTouchListener(this);


        s_registerBtn.setBackgroundResource(R.drawable.btn_login);
        loginBtn.setBackgroundResource(R.drawable.btn_login_selected);
        verifyEt.setVisibility(View.INVISIBLE);
        verifyBtn.setVisibility(View.INVISIBLE);
        l_registerBtn.setText("登陆");
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.btn_register_big:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    l_registerBtn.setBackgroundResource(R.drawable.btn_register_big_selected);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    l_registerBtn.setBackgroundResource(R.drawable.btn_register_big);
                }
                break;
            case R.id.visible_button:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    passwordEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    passwordEt.setSelection(passwordEt.getText().length());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    passwordEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    passwordEt.setSelection(passwordEt.getText().length());
                }
                break;
            case R.id.verify_btn:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    verifyBtn.setBackgroundResource(R.drawable.btn_register_big_selected);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    verifyBtn.setBackgroundResource(R.drawable.btn_register_big);
                }
                break;
        }
        return false;
    }

    private boolean verifyUserInfo(String username, String password) {
        ulist = UserInfoList.getUserInfo(this);
        try {
            for (int i = 0; i < ulist.size(); i++) {
                //if (Base64Encrypt.decodeBase64(ulist.get(i).getUsername().toString()).equals(username) && Base64Encrypt.decodeBase64(ulist.get(i).getPassword().toString()).equals(password)){
                if (String.valueOf(ulist.get(i).getPhone()).equals(username) && ulist.get(i).getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean verifyUsername(String username) {
        if (username.matches("^1[34578]\\d{9}$")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verifyPassword(String password) {
        if (password.matches("^[a-zA-Z]\\w{5,12}$")) {
            return true;
        } else {
            return false;
        }
    }

    @Event(value = {R.id.btn_login, R.id.btn_register, R.id.verify_btn, R.id.btn_register_big})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                s_registerBtn.setBackgroundResource(R.drawable.btn_login);
                loginBtn.setBackgroundResource(R.drawable.btn_login_selected);
                verifyEt.setVisibility(View.INVISIBLE);
                verifyBtn.setVisibility(View.INVISIBLE);
                l_registerBtn.setText("登陆");
                verifyEt.setText("");
                usernameEt.setText("");
                passwordEt.setText("");
                break;
            case R.id.btn_register:
                s_registerBtn.setBackgroundResource(R.drawable.btn_login_selected);
                loginBtn.setBackgroundResource(R.drawable.btn_login);
                verifyEt.setVisibility(View.VISIBLE);
                verifyBtn.setVisibility(View.VISIBLE);
                l_registerBtn.setText("注册");
                verifyEt.setText("");
                usernameEt.setText("");
                passwordEt.setText("");
                break;
            case R.id.verify_btn:
                Toast.makeText(this, "验证码已发送，注意查收", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_register_big:
                UserInfoEntity userInfo = new UserInfoEntity();
                userInfo.setPhone(Integer.parseInt(usernameEt.getEditableText().toString()));
                userInfo.setPassword(passwordEt.getEditableText().toString());
                userInfo.setDevice_id(Settings.System.getString(getContentResolver(), Settings.System.ANDROID_ID));
                RequestParams params = new RequestParams(LOGIN_URL);
                params.setAsJsonContent(true);
                params.setBodyContent(new Gson().toJson(userInfo).toString());
                Log.e("2333",new Gson().toJson(userInfo));
                x.http().post(params, new Callback.CommonCallback<String>() {

                    @Override
                    public void onSuccess(String result) {
                        LoginResponseEntity respose = new Gson().fromJson(result, new TypeToken<LoginResponseEntity>(){}.getType());
                        Toast.makeText(getBaseContext(),respose.getMessage(),Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getBaseContext(),InsideActivity.class));
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        ex.printStackTrace();
                        Toast.makeText(getBaseContext(),"FK",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
                break;
        }
    }
}
