package org.example.androidenterprise.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/4.
 */
public class StudentHeadListAdapter extends BaseAdapter {
    private Context context;
    private List<Object> imgs;
    private int num;
    private LayoutInflater mLayoutInflater;

    public StudentHeadListAdapter(Context context,int num){
        this.mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.num = num;
    }


    @Override
    public int getCount() {
        return num;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder_Info holder;
        if (convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.item_student_head,null);
            holder = new ViewHolder_Info();
            holder.img = (ImageView)convertView.findViewById(R.id.civ_student_head_img);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder_Info)convertView.getTag();
        }
        holder.img.setImageResource(R.drawable.img_example2);
        return convertView;
    }

    final class ViewHolder_Info {
        ImageView img;
        TextView name;

    }
}
