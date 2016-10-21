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
 * Created by cs on 2016/10/19.
 */
public class LogisticsAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;

    public LogisticsAdapter(Context context) {
        this.mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
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
        ViewHolder_logistics holder;
        if (convertView == null) {
            convertView = mLayoutInflate.inflate(R.layout.logistics_lv_item, null);
            holder = new ViewHolder_logistics();
            holder.img = (ImageView) convertView.findViewById(R.id.iv_logistics);
            holder.line = (TextView) convertView.findViewById(R.id.tv_line);
            holder.info = (TextView) convertView.findViewById(R.id.tv_logistics_info);
            holder.date = (TextView) convertView.findViewById(R.id.tv_logistics_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder_logistics) convertView.getTag();
        }
        // TODO: ___list.get(position).get___()
        holder.img.setImageResource(R.mipmap.ic_log_selected);
        holder.line.setText("");
        holder.info.setText("已签收XXXXXXXXXXXXX");
        holder.date.setText("2016-05-09 10:15");

        return convertView;
    }
}

final class ViewHolder_logistics {
    ImageView img;
    TextView line, info, date;
}
