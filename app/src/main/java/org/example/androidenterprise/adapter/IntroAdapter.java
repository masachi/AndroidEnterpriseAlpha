package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import org.example.androidenterprise.List.IntroductionList;
import org.example.androidenterprise.model.InsAndDesEntity;
import org.example.androidenterprise.model.IntroductionEntity;
import org.example.androidenterprise.R;

import java.util.List;

/**
 * Created by sdlds on 2016/9/23.
 */
public class IntroAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;
    private InsAndDesEntity introList;

    public IntroAdapter(Context context,InsAndDesEntity introList){
        this.mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
        this.introList = introList;
    }

    @Override
    public int getCount() {
        return introList.getInspicsList().size();
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
       // introList = IntroductionList.getData(context);
        ViewHolder_Intro holder;
        if(convertView == null){
            convertView = mLayoutInflate.inflate(R.layout.music_intro_lv_item,null);
            holder = new ViewHolder_Intro();
            holder.introGv = (GridView) convertView.findViewById(R.id.music_intro_gv);
            holder.titleTv = (TextView) convertView.findViewById(R.id.mucic_intro_title);
            holder.signTv = (TextView) convertView.findViewById(R.id.music_intro_price_sign);
            holder.priceTv = (TextView) convertView.findViewById(R.id.music_intro_price);
            holder.infoTv = (TextView) convertView.findViewById(R.id.music_intro_info);
            
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder_Intro) convertView.getTag();
        }
        holder.titleTv.setText(introList.getInspicsList().get(position).getName());
        //holder.signTv.setText(introList.getInspicsList().get(position));
        holder.priceTv.setText(String.valueOf(introList.getInspicsList().get(position).getNow_price()));
        holder.infoTv.setText(introList.getInspicsList().get(position).getDes());
        return convertView;
    }
}
final class ViewHolder_Intro{
    TextView titleTv;
    TextView signTv;
    TextView priceTv;
    TextView infoTv;
    GridView introGv;
    SimpleAdapter introgvAdapter;
}
