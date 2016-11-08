package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import org.example.androidenterprise.R;
import org.example.androidenterprise.model.ReservationOrderEntity;

import java.util.List;

/**
 * Created by yangxinghua on 2016/10/13 : 预约订单页面listview适配器
 */
public class OrderAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;
    private List<ReservationOrderEntity.ListInfoEntity> slist;
    private int checkedPosition;

    public OrderAdapter(Context context, List<ReservationOrderEntity.ListInfoEntity> list) {
        this.context = context;
        this.mLayoutInflate = LayoutInflater.from(context);
        this.slist = list;
    }

    @Override
    public int getCount() {
        return slist.size();
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
        ViewHolder_Order holder;
        if (convertView == null) {
            convertView = mLayoutInflate.inflate(R.layout.order_lv_item, null);
            holder = new ViewHolder_Order();
            holder.date = (TextView) convertView.findViewById(R.id.tv_date);
            holder.state = (TextView) convertView.findViewById(R.id.tv_state);
            holder.img = (ImageView) convertView.findViewById(R.id.iv_course);
            holder.coursename = (TextView) convertView.findViewById(R.id.tv_course_name);
            holder.classhour = (TextView) convertView.findViewById(R.id.tv_classhour);
            holder.teacher = (TextView) convertView.findViewById(R.id.tv_teacher);
            holder.price = (TextView) convertView.findViewById(R.id.tv_price);
            holder.total_price = (TextView) convertView.findViewById(R.id.tv_total_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder_Order) convertView.getTag();
        }
        holder.date.setText("订单时间 "+slist.get(position).getDate());
        holder.state.setText(String.valueOf(slist.get(position).getSituation()));
        Glide.with(context).load(slist.get(position).getClass_pic_url()).into(holder.img);
        holder.coursename.setText(slist.get(position).getClass_name());
        holder.classhour.setText(String.valueOf(slist.get(position).getClass_time())+"课时");
        holder.teacher.setText("老师:"+slist.get(position).getTeacher_name());
        holder.price.setText("￥"+String.valueOf(slist.get(position).getClass_price()));
        holder.total_price.setText("实付￥"+String.valueOf(slist.get(position).getClass_price()));
        return convertView;
    }

    public void setCheckedPosition(int position) {
        this.checkedPosition = position;
        notifyDataSetChanged();
    }
}

final class ViewHolder_Order {
    TextView date, state, coursename, classhour, teacher, price, total_price;
    ImageView img;
}