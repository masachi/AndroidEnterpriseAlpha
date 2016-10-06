package org.example.androidenterprise.activity;

import android.content.Intent;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import org.example.androidenterprise.List.UserInfoList;
import org.example.androidenterprise.MainActivity;
import org.example.androidenterprise.Model.UserInfoEntity;
import org.example.androidenterprise.R;
import org.example.androidenterprise.utils.Base64Encrypt;
import org.example.androidenterprise.utils.InitData;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnTouchListener,View.OnClickListener{
    private Button s_sregisterBtn;
    private Button loginBtn;
    private Button l_registerBtn;
    private Button verifyBtn;
    private ImageButton vis;
    private EditText usernameEt;
    private EditText passwordEt;
    private EditText verifyEt;
    private List<UserInfoEntity> ulist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InitData.initData(this);

        s_sregisterBtn = (Button) findViewById(R.id.btn_register);
        loginBtn = (Button) findViewById(R.id.btn_login);
        l_registerBtn = (Button) findViewById(R.id.btn_register_big);
        vis = (ImageButton) findViewById(R.id.visible_button);
        passwordEt = (EditText) findViewById(R.id.edittext_password);
        usernameEt = (EditText) findViewById(R.id.edittext_username);
        verifyEt = (EditText) findViewById(R.id.edittext_verify);
        verifyBtn = (Button) findViewById(R.id.verify_btn);

        l_registerBtn.setOnTouchListener(this);
        verifyBtn.setOnTouchListener(this);
        vis.setOnTouchListener(this);

        s_sregisterBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        l_registerBtn.setOnClickListener(this);
        verifyBtn.setOnClickListener(this);

        s_sregisterBtn.setBackgroundResource(R.drawable.btn_login);
        loginBtn.setBackgroundResource(R.drawable.btn_login_selected);
        verifyEt.setVisibility(View.INVISIBLE);
        verifyBtn.setVisibility(View.INVISIBLE);
        l_registerBtn.setText("登陆");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                s_sregisterBtn.setBackgroundResource(R.drawable.btn_login_selected);
                loginBtn.setBackgroundResource(R.drawable.btn_login);
                verifyEt.setVisibility(View.VISIBLE);
                verifyBtn.setVisibility(View.VISIBLE);
                l_registerBtn.setText("注册");
                verifyEt.setText("");
                usernameEt.setText("");
                passwordEt.setText("");
                break;
            case R.id.btn_login:
                s_sregisterBtn.setBackgroundResource(R.drawable.btn_login);
                loginBtn.setBackgroundResource(R.drawable.btn_login_selected);
                verifyEt.setVisibility(View.INVISIBLE);
                verifyBtn.setVisibility(View.INVISIBLE);
                l_registerBtn.setText("登陆");
                verifyEt.setText("");
                usernameEt.setText("");
                passwordEt.setText("");
                break;
            case R.id.btn_register_big:
                String btnText = l_registerBtn.getText().toString();
                if(btnText.equals("注册")){
                    String username = usernameEt.getText().toString();
                    String password = passwordEt.getText().toString();
                    String verifyInfo = verifyEt.getText().toString();
                    if(username.length() == 0 || password.length() == 0){
                        Toast.makeText(this,"请输入用户名及密码",Toast.LENGTH_SHORT).show();
                    }
                    if(username.length() != 0 && password.length() !=0 &&verifyUsername(username)&&verifyPassword(password)&&verifyInfo.length() == 4){
                        Toast.makeText(this,"注册成功\n请登陆",Toast.LENGTH_LONG);
                        usernameEt.setText("");
                        passwordEt.setText("");
                        verifyEt.setVisibility(View.INVISIBLE);
                        verifyBtn.setVisibility(View.INVISIBLE);
                        l_registerBtn.setText("登陆");
                        //TODO:把注册信息加入到文件或者数据库里面
                    }
                    else{
                        if(verifyInfo.length() == 0){
                            Toast.makeText(this,"请输入验证码",Toast.LENGTH_SHORT);
                        }
                        else{
                            if(verifyInfo.length() != 4){
                                Toast.makeText(this,"验证码错误",Toast.LENGTH_SHORT);
                                verifyEt.setText("");
                            }
                            else{
                                Toast.makeText(this,"密码或者手机号不符合要求，请重新填写",Toast.LENGTH_SHORT);
                                verifyEt.setText("");
                                usernameEt.setText("");
                                passwordEt.setText("");
                            }
                        }
                    }
                }
                else{
                    if(btnText.equals("登陆")){
                        if(usernameEt.getText().toString().length() == 0 || passwordEt.getText().toString().length() == 0){
                            Toast.makeText(this,"请输入用户名及密码",Toast.LENGTH_SHORT).show();
                        }
                        if(usernameEt.getText().toString().length() != 0 && passwordEt.getText().toString().length() != 0 && verifyUserInfo(usernameEt.getText().toString(),passwordEt.getText().toString())){
                            Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG).show();
                            startActivity(new Intent().setClass(this,InsideActivity.class));
                        }
                        else{
                            Toast.makeText(this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                break;
            case R.id.verify_btn:
                Toast.makeText(this,"验证码已发送，注意查收",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.btn_register_big:
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    l_registerBtn.setBackgroundResource(R.drawable.btn_register_big_selected);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    l_registerBtn.setBackgroundResource(R.drawable.btn_register_big);
                }
                break;
            case R.id.visible_button:
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    passwordEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    passwordEt.setSelection(passwordEt.getText().length());
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    passwordEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    passwordEt.setSelection(passwordEt.getText().length());
                }
                break;
            case R.id.verify_btn:
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    verifyBtn.setBackgroundResource(R.drawable.btn_register_big_selected);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    verifyBtn.setBackgroundResource(R.drawable.btn_register_big);
                }
                break;
        }
        return false;
    }

    private boolean verifyUserInfo(String username,String password){
        ulist = UserInfoList.getUserInfo(this);
        try {
            for (int i = 0; i < ulist.size(); i++) {
                //if (Base64Encrypt.decodeBase64(ulist.get(i).getUsername().toString()).equals(username) && Base64Encrypt.decodeBase64(ulist.get(i).getPassword().toString()).equals(password)){
                if(ulist.get(i).getUsername().equals(username) && ulist.get(i).getPassword().equals(password)){
                    return true;
                }
            }
            return false;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private boolean verifyUsername(String username){
        if(username.matches("^1[34578]\\d{9}$")){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean verifyPassword(String password){
        if(password.matches("^[a-zA-Z]\\w{5,12}$")){
            return true;
        }
        else {
            return false;
        }
    }

}
