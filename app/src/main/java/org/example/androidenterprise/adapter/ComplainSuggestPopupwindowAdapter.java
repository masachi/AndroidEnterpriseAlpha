package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import org.example.androidenterprise.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 */
public class ComplainSuggestPopupwindowAdapter extends BaseAdapter {
//    private List<String> mList;
    private String[] mSuggest;
    private Context mContext;
    public ComplainSuggestPopupwindowAdapter(Context context,String[] suggest){
        this.mContext = context;
        this.mSuggest = suggest;
    }
    @Override
    public int getCount() {
        return mSuggest.length;
    }

    @Override
    public Object getItem(int i) {
        return mSuggest[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.complain_suggest_popupwindow_listview_item,null);
            holder = new ViewHolder();
            holder.suggest = (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.suggest.setText(mSuggest[position]);
        return convertView;
    }
    class ViewHolder{
        TextView suggest;
    }
}
