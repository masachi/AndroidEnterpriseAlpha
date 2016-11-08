package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import org.example.androidenterprise.R;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by chenguojiao : 我的作品 .
 */
public class MyWorksAdapter extends BaseAdapter {
    private ArrayList<Map<String,String>> listdata;
    private Context context;
    public MyWorksAdapter(Context context, ArrayList<Map<String,String>> listdata){
        this.context = context;
        this.listdata = listdata;
    }
    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int i) {
        return listdata.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder_MyWorks holder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.myworks_custom_measure_gridview_item,null);
            holder = new ViewHolder_MyWorks();
            holder.imgMyWorksItem = (ImageView) convertView.findViewById(R.id.imgMyWorksItem);
            holder.imgMyWorksVideoBg = (ImageView) convertView.findViewById(R.id.img_my_works_video_bg);
            holder.rlMyWorksVideoTime = (RelativeLayout) convertView.findViewById(R.id.rl_my_works_video_time);
            holder.tvMyWorksTime = (TextView) convertView.findViewById(R.id.tv_my_works_time);
            holder.tvMyWorksDate = (TextView) convertView.findViewById(R.id.tv_my_works_date);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder_MyWorks) convertView.getTag();
        }
        if (position == 0) {
            holder.imgMyWorksVideoBg.setVisibility(View.GONE);
            holder.rlMyWorksVideoTime.setVisibility(View.GONE);
            holder.imgMyWorksItem.setImageResource(R.drawable.ic_shoot);

        }else {
            int img = Integer.valueOf(listdata.get(position).get("img"));
            holder.imgMyWorksItem.setImageResource(img);
            holder.tvMyWorksTime.setText(listdata.get(position).get("time"));
            holder.tvMyWorksDate.setText(listdata.get(position).get("date"));
        }
        return convertView;
    }
}
class ViewHolder_MyWorks{
    ImageView imgMyWorksItem,imgMyWorksVideoBg;
    TextView tvMyWorksTime,tvMyWorksDate;
    RelativeLayout rlMyWorksVideoTime;
}