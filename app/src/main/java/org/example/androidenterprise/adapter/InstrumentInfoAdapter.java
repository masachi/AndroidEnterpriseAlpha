package org.example.androidenterprise.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.Model.ItemEntity;
import org.example.androidenterprise.R;

import java.util.List;

/**
 * Created by sdlds on 2016/9/26.
 */
public class InstrumentInfoAdapter extends BaseAdapter {
    private List<ItemEntity> ilist;
    private Context context;
    private LayoutInflater mLayoutInflate;

    public InstrumentInfoAdapter(Context context,List<ItemEntity> list){
        this.mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
        this.ilist = list;
    }

    @Override
    public int getCount() {
        return ilist.size();
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
        if(convertView == null){
            convertView = mLayoutInflate.inflate(R.layout.instrument_info_grid_item,null);
            holder = new ViewHolder_Info();
            holder.img =(ImageView) convertView.findViewById(R.id.item_img);
            holder.title = (TextView) convertView.findViewById(R.id.item_title);
            holder.price = (TextView) convertView.findViewById(R.id.item_price);
            holder.price_line = (TextView) convertView.findViewById(R.id.item_price_with_line);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder_Info) convertView.getTag();
        }
        holder.img.setImageResource(R.drawable.img_example2);
        holder.title.setText(ilist.get(position).getTitle());
        holder.price.setText(String.valueOf(ilist.get(position).getPrice()));
        holder.price_line.setText(String.valueOf(ilist.get(position).getPrice_line()));
        holder.price_line.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        return convertView;
    }
}
final class ViewHolder_Info{
    ImageView img;
    TextView title;
    TextView price;
    TextView price_line;
}
