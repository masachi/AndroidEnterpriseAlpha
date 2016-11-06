package org.example.androidenterprise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.CSCustomServiceInfo;
import org.example.androidenterprise.MyApplication;
import org.example.androidenterprise.R;

import static io.rong.imkit.utils.SystemUtils.getCurProcessName;


/**
 * Created by Administrator on 2016/10/29.
 */
public class ServiceTalkActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_talk);
//        connect("3xheWPjjmiPztJ8LTpVtMkxCmntzjCygMK8AxneEUJtzNiszBisNBbFuXv1ri4Vj1squkKQfjQ884vtuk8OuFg==");
    }
//    /**
//     * 建立与融云服务器的连接
//     *
//     * @param token
//     */
//    private void connect(String token) {
//
//        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext()))) {
//
//            /**
//             * IMKit SDK调用第二步,建立与服务器的连接
//             */
//            RongIM.connect(token, new RongIMClient.ConnectCallback() {
//
//                /**
//                 * Token 错误，在线上环境下主要是因为 Token 已经过期，您需要向 App Server 重新请求一个新的 Token
//                 */
//                @Override
//                public void onTokenIncorrect() {
//
//                    Log.d("LoginActivity", "--onTokenIncorrect");
//                }
//
//                /**
//                 * 连接融云成功
//                 * @param userid 当前 token
//                 */
//                @Override
//                public void onSuccess(String userid) {
//
//                    Log.d("LoginActivity", "--onSuccess" + userid);
//                    CSCustomServiceInfo.Builder csBuilder = new CSCustomServiceInfo.Builder();
//                    CSCustomServiceInfo csInfo = csBuilder.nickName("融云").build();
//
////*//**
//// * 启动客户服聊天界面。
//// *
//// * @param context           应用上下文。
//// * @param customerServiceId 要与之聊天的客服 Id。
//// * @param title             聊天的标题，如果传入空值，则默认显示与之聊天的客服名称。
//// * @param customServiceInfo 当前使用客服者的用户信息。{@link io.rong.imlib.model.CSCustomServiceInfo}
//// *//*
//                    RongIM.getInstance().startCustomerServiceChat(ServiceTalkActivity.this, "KEFU147774053111627", "在线客服", csInfo);
////                   startActivity(new Intent(MainActivity.this, TalkActivity.class));
////                    finish();
//                }
//
//                /**
//                 * 连接融云失败
//                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
//                 */
//                @Override
//                public void onError(RongIMClient.ErrorCode errorCode) {
//
//                    Log.d("LoginActivity", "--onError" + errorCode);
//                }
//            });
//        }
//    }
//
    @Override
    public void onBackPressed() {
        ConversationFragment fragment = (ConversationFragment) getSupportFragmentManager().findFragmentById(R.id.conversation);
        if (!fragment.onBackPressed()) {
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        return super.onKeyDown(keyCode, event);
    }
}
