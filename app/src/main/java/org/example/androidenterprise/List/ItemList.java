package org.example.androidenterprise.List;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.example.androidenterprise.model.ItemEntity;

import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by sdlds on 2016/9/21.
 */
public class ItemList {
    private static List<ItemEntity> ilist;

    public static List<ItemEntity> getData(Context context){
        try{
            ilist = new Gson().fromJson(new JsonReader(new InputStreamReader(context.getAssets().open("AllItem.json"))),new TypeToken<List<ItemEntity>>(){}.getType());
            Log.e("233333","23333333");
        }
        catch (Exception e){
            Log.e("FK","FUCK");
            e.printStackTrace();
        }
        return ilist;
    }
}
