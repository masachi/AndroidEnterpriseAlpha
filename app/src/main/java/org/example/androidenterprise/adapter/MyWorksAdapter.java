package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import org.example.androidenterprise.R;
import org.example.androidenterprise.activity.BaseActivity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */
public class MyWorksAdapter extends BaseAdapter {
    private List<Integer> mList;
    private Context mContext;
    public MyWorksAdapter(Context context,List<Integer> list){
        this.mContext = context;
        this.mList = list;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.myworks_custom_measure_gridview_item,null);
            holder = new ViewHolder();
            holder.works_photo = (ImageView) convertView.findViewById(R.id.iv_myworks_item);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.works_photo.setImageResource(mList.get(position));
        return convertView;
    }
    class ViewHolder{
        ImageView works_photo;

    }
}
