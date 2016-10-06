package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.List.IntroductionList;
import org.example.androidenterprise.Model.IntroductionEntity;
import org.example.androidenterprise.R;

import java.util.List;

/**
 * Created by sdlds on 2016/9/23.
 */
public class IntroAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;
    private List<IntroductionEntity> introList;

    public IntroAdapter(Context context){
        this.mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return IntroductionList.getData(context).size();
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
        introList = IntroductionList.getData(context);
        ViewHolder_Intro holder;
        if(convertView == null){
            convertView = mLayoutInflate.inflate(R.layout.music_intro_lv_item,null);
            holder = new ViewHolder_Intro();
            holder.titleTv = (TextView) convertView.findViewById(R.id.mucic_intro_title);
            holder.signTv = (TextView) convertView.findViewById(R.id.music_intro_price_sign);
            holder.priceTv = (TextView) convertView.findViewById(R.id.music_intro_price);
            holder.infoTv = (TextView) convertView.findViewById(R.id.music_intro_info);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder_Intro) convertView.getTag();
        }
        holder.titleTv.setText(introList.get(position).getTitle());
        holder.signTv.setText(introList.get(position).getSign());
        holder.priceTv.setText(String.valueOf(introList.get(position).getPrice()));
        holder.infoTv.setText(introList.get(position).getInfo());
        return convertView;
    }
}
final class ViewHolder_Intro{
    TextView titleTv;
    TextView signTv;
    TextView priceTv;
    TextView infoTv;
}
