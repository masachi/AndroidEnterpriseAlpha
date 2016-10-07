package org.example.androidenterprise.List;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.example.androidenterprise.model.UserInfoEntity;

import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by sdlds on 2016/9/26.
 */
public class UserInfoList {
    private static List<UserInfoEntity> ulist;

    public static List<UserInfoEntity> getUserInfo(Context context){
        try{
            ulist = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("UserInfo.json"))),new TypeToken<List<UserInfoEntity>>(){}.getType());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ulist;
    }
}
