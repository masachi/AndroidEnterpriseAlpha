package org.example.androidenterprise.List;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.example.androidenterprise.model.IntroductionEntity;

import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by sdlds on 2016/9/21.
 */
public class IntroductionList {
    private static List<IntroductionEntity> alist;

    public static List<IntroductionEntity> getData(Context context){
        try{
            alist = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("introduction.json"))),new TypeToken<List<IntroductionEntity>>(){}.getType());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return alist;
    }
}
