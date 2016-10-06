package org.example.androidenterprise.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.List.ItemList;
import org.example.androidenterprise.Model.ItemEntity;
import org.example.androidenterprise.R;

import java.util.List;

/**
 * Created by sdlds on 2016/9/21.
 */
public class ItemAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;
    private List<ItemEntity> ilist;

    public ItemAdapter(Context context){
        this.mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
    }
    @Override
    public int getCount() {
        return ItemList.getData(context).size();
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
        ilist = ItemList.getData(context);
        ViewHolder_I holder;
        if(convertView == null){
            convertView = mLayoutInflate.inflate(R.layout.music_grid_item,null);
            holder = new ViewHolder_I();
            holder.img =(ImageView) convertView.findViewById(R.id.item_img);
            holder.title = (TextView) convertView.findViewById(R.id.item_title);
            holder.price = (TextView) convertView.findViewById(R.id.item_price);
            holder.price_line = (TextView) convertView.findViewById(R.id.item_price_with_line);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder_I) convertView.getTag();
        }
        holder.img.setImageResource(R.drawable.img_example2);
        holder.title.setText(ilist.get(position).getTitle());
        holder.price.setText(ilist.get(position).getPrice());
        holder.price_line.setText(String.valueOf(ilist.get(position).getPrice_line()));
        holder.price_line.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        return convertView;
    }
}
final class ViewHolder_I{
    ImageView img;
    TextView title;
    TextView price;
    TextView price_line;
}
