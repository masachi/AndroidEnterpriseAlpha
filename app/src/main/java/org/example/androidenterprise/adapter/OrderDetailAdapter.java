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
 * Created by caishuang:订单详情
 */
public class OrderDetailAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;

    public OrderDetailAdapter(Context context) {
        this.mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        //TODO: return ___List.getData(context).size();
        return 0;
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
        ViewHolder_OrderDetail holder;
        if (convertView == null) {
            convertView = mLayoutInflate.inflate(R.layout.order_detail_lv_item, null);
            holder = new ViewHolder_OrderDetail();
            holder.img = (ImageView) convertView.findViewById(R.id.iv_img);
            holder.name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.property = (TextView) convertView.findViewById(R.id.tv_property);
            holder.price = (TextView) convertView.findViewById(R.id.tv_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder_OrderDetail) convertView.getTag();
        }
        // TODO: ___list.get(position).get___()
        holder.img.setImageResource(R.drawable.flute1);
        holder.name.setText("什么什么乐器");
        holder.property.setText("什么什么属性");
        holder.price.setText("1000");

        return convertView;
    }
}

final class ViewHolder_OrderDetail {
    ImageView img;
    TextView name, property, price;
}
