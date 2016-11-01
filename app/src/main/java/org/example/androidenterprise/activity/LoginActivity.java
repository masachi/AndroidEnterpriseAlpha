package org.example.androidenterprise.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import cn.jpush.sms.SMSSDK;
import cn.jpush.sms.listener.SmscheckListener;
import cn.jpush.sms.listener.SmscodeListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.androidenterprise.List.UserInfoList;
import org.example.androidenterprise.R;
import org.example.androidenterprise.model.LoginResponseEntity;
import org.example.androidenterprise.model.LoginResponseErrorEntity;
import org.example.androidenterprise.model.RegisterResponseEntity;
import org.example.androidenterprise.model.UserInfoEntity;
import org.example.androidenterprise.utils.InitData;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static org.example.androidenterprise.utils.UrlAddress.LOGIN_URL;
import static org.example.androidenterprise.utils.UrlAddress.REGISTER_URL;

@ContentView(R.layout.activity_login)

public class LoginActivity extends BaseActivity implements View.OnTouchListener {

    public static boolean isLogin = false;

    @ViewInject(R.id.btn_login)
    Button loginBtn;
    @ViewInject(R.id.btn_register)
    Button s_registerBtn;
    @ViewInject(R.id.et_username)
    EditText usernameEt;
    @ViewInject(R.id.et_password)
    EditText passwordEt;
    @ViewInject(R.id.btn_vis)
    ImageButton visBtn;
    @ViewInject(R.id.edittext_verify)
    EditText verifyEt;
    @ViewInject(R.id.btn_verify)
    Button verifyBtn;
    @ViewInject(R.id.btn_register_big)
    Button l_registerBtn;

    //TODO: data sourse under this line
    private List<UserInfoEntity> ulist;

    //短信验证定时器
    private TimerTask timerTask;
    private Timer timer;
    private int timess;
    private ProgressDialog progressDialog;
    //两次获取验证码的时间间隔
    private Long TIME_INTERVAL = 60000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        //短信验证
        SMSSDK.getInstance().initSdk(this);
        SMSSDK.getInstance().setIntervalTime(TIME_INTERVAL);

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
            case R.id.btn_vis:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    passwordEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    passwordEt.setSelection(passwordEt.getText().length());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    passwordEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    passwordEt.setSelection(passwordEt.getText().length());
                }
                break;
            case R.id.btn_verify:
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
                if (String.valueOf(ulist.get(i).getUsername()).equals(username) && ulist.get(i).getPassword().equals(password)) {
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

    @Event(value = {R.id.btn_login, R.id.btn_register, R.id.btn_verify, R.id.btn_register_big})
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
            case R.id.btn_verify:
                //获取验证码
                String phoneNum = usernameEt.getText().toString();
                if(TextUtils.isEmpty(phoneNum)){
                    Toast.makeText(LoginActivity.this, "请输入手机号码", Toast.LENGTH_SHORT).show();
                    return;
                }
                verifyBtn.setClickable(false);
                //开始倒计时
                startTimer();
                SMSSDK.getInstance().getSmsCodeAsyn(phoneNum,1+"", new SmscodeListener() {
                    @Override
                    public void getCodeSuccess(final String uuid) {
                        Toast.makeText(LoginActivity.this,uuid,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void getCodeFail(int errCode, final String errmsg) {
                        //失败后停止计时
                        stopTimer();
                        Toast.makeText(LoginActivity.this,errmsg,Toast.LENGTH_SHORT).show();
                    }
                });
                Toast.makeText(this, "验证码已发送，注意查收", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_register_big:
                UserInfoEntity userInfo = new UserInfoEntity();
                userInfo.setUsername(usernameEt.getEditableText().toString());
                userInfo.setPassword(passwordEt.getEditableText().toString());
                if(((Button)view).getText().toString().equals("注册")){


                            //开始验证
                            String code = verifyEt.getText().toString();
                            String phoneN = usernameEt.getText().toString();
                            String password = passwordEt.getText().toString();
                            if(TextUtils.isEmpty(code)){
                                Toast.makeText(LoginActivity.this,"请输入验证码",Toast.LENGTH_SHORT).show();
                                return;
                            }
                            if(TextUtils.isEmpty(phoneN)){
                                Toast.makeText(LoginActivity.this,"请输入手机号码",Toast.LENGTH_SHORT).show();
                                return;
                            }
                            if (TextUtils.isEmpty(password)){
                                Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                                return;
                            }
                            progressDialog.setTitle("正在验证...");
                            progressDialog.show();
                            SMSSDK.getInstance().checkSmsCodeAsyn(phoneN, code, new SmscheckListener() {
                                @Override
                                public void checkCodeSuccess(final String code) {
                                    if(progressDialog!=null&&progressDialog.isShowing()){
                                        progressDialog.dismiss();
                                    }
                                    Toast.makeText(LoginActivity.this,code,Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void checkCodeFail(int errCode, final String errmsg) {
                                    if(progressDialog!=null&&progressDialog.isShowing()){
                                        progressDialog.dismiss();
                                    }
                                    Toast.makeText(LoginActivity.this,errmsg,Toast.LENGTH_SHORT).show();
                                }
                            });


                    RequestParams params = new RequestParams(REGISTER_URL);
                    params.setAsJsonContent(true);
                    params.setBodyContent(new Gson().toJson(userInfo));
                    //params.setBodyContent("{\"result\":\"233\",\"id\":223}");
                    Log.e("2333",new Gson().toJson(userInfo));
                    x.http().post(params, new Callback.CommonCallback<String>() {

                        @Override
                        public void onSuccess(String result) {
                            Log.e("23333",result);
                            RegisterResponseEntity response = new Gson().fromJson(result, new TypeToken<RegisterResponseEntity>(){}.getType());
                            if(response.getResult().equals("no")){
                                Toast.makeText(getBaseContext(),"该手机号已经注册\n请登录",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getBaseContext(),"注册成功\n请登录",Toast.LENGTH_SHORT).show();
                            }
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
                }
                else{
                    userInfo.setDevice_id(Settings.System.getString(getContentResolver(), Settings.System.ANDROID_ID));
                    RequestParams params = new RequestParams(LOGIN_URL);
                    params.setAsJsonContent(true);
                    params.setBodyContent(new Gson().toJson(userInfo).toString());
                    Log.e("2333",new Gson().toJson(userInfo));
                    x.http().post(params, new Callback.CommonCallback<String>() {

                        @Override
                        public void onSuccess(String result) {
                            if(result.length()<40) {
                                LoginResponseErrorEntity response = new Gson().fromJson(result, new TypeToken<LoginResponseErrorEntity>() {
                                }.getType());
                                if(response.getType() == 1){
                                    Toast.makeText(LoginActivity.this, "该用户未注册", Toast.LENGTH_SHORT).show();
                                }
                                if(response.getType() == 2){
                                    Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Log.e("23333",result);
                                LoginResponseEntity response = new Gson().fromJson(result, new TypeToken<LoginResponseEntity>() {
                                }.getType());
                                Toast.makeText(getBaseContext(),"登录成功", Toast.LENGTH_SHORT).show();
                                isLogin = true;
                                startActivity(new Intent(getBaseContext(),InsideActivity.class));
                            }
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
                }
                break;
        }
    }

    //短信验证的定时器
    private void startTimer(){
        timess = (int) (SMSSDK.getInstance().getIntervalTime()/1000);
        verifyBtn.setText(timess+"s");
        if(timerTask==null){
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            timess--;
                            if(timess<=0){
                                stopTimer();
                                return;
                            }
                            verifyBtn.setText(timess+"s");
                        }
                    });
                }
            };
        }
        if(timer==null){
            timer = new Timer();
        }
        timer.schedule(timerTask, 1000, 1000);
    }
    private void stopTimer(){
        if(timer!=null){
            timer.cancel();
            timer=null;
        }
        if(timerTask!=null){
            timerTask.cancel();
            timerTask=null;
        }
        verifyBtn.setText("重新获取");
        verifyBtn.setClickable(true);
    }
}
