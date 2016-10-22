package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.R;

/**
 * Created by yangxinghua on 2016/10/13 : 预约订单页面listview适配器
 */
public class OrderAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;
    // TODO:private List<___> ___list;

    public OrderAdapter(Context context) {
        this.context = context;
        this.mLayoutInflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        //TODO:return ___List.getData(context).size();
        return 3;
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
        //TODO:___list.get(position).get___
        holder.date.setText("___list.get(position).get___");
        holder.state.setText("___list.get(position).get___");
        holder.img.setImageResource(R.drawable.img_example2);//将R.drawable.img_example换成___list.get(position).get___
        holder.coursename.setText("___list.get(position).get___");
        holder.classhour.setText("___list.get(position).get___");
        holder.teacher.setText("___list.get(position).get___");
        holder.price.setText("___list.get(position).get___");
        holder.total_price.setText("___list.get(position).get___");
        return convertView;
    }
}

final class ViewHolder_Order {
    TextView date, state, coursename, classhour, teacher, price, total_price;
    ImageView img;
}