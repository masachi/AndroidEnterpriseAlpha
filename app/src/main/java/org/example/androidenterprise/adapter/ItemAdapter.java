package org.example.androidenterprise.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import org.example.androidenterprise.List.ItemList;
import org.example.androidenterprise.model.InstrumentEntity;
import org.example.androidenterprise.model.ItemEntity;
import org.example.androidenterprise.R;

import java.util.List;

/**
 * Created by sdlds on 2016/9/21.
 */
public class ItemAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;
    private InstrumentEntity ilist;

    public ItemAdapter(Context context,InstrumentEntity ilist){
        this.mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
        this.ilist = ilist;
    }
    @Override
    public int getCount() {
        return ilist.getInsArr().size();
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
//        ilist = ItemList.getData(context);
        ViewHolder_I holder;
        if(convertView == null){
            convertView = mLayoutInflate.inflate(R.layout.music_grid_item,null);
            holder = new ViewHolder_I();
            holder.img =(ImageView) convertView.findViewById(R.id.iv_instrument);
            holder.title = (TextView) convertView.findViewById(R.id.tv_instrument_title);
            holder.price = (TextView) convertView.findViewById(R.id.tv_instrument_price);
            holder.price_line = (TextView) convertView.findViewById(R.id.item_price_with_line);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder_I) convertView.getTag();
        }
        holder.img.setImageResource(R.drawable.img_example2);
        //TODO 服务器没给出正确的图片URL地址
       // Glide.with(context).load(ilist.getInsArr().get(position).getPic_url()).into(holder.img);
        holder.title.setText(ilist.getInsArr().get(position).getName());
        holder.price.setText(String.valueOf(ilist.getInsArr().get(position).getNow_price()));
        holder.price_line.setText(String.valueOf(ilist.getInsArr().get(position).getPre_price()));
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
