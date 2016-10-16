package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import org.example.androidenterprise.List.SettingList;
import org.example.androidenterprise.model.SettingEntity;
import org.example.androidenterprise.R;

import java.util.List;

/**
 * Created by sdlds on 2016/9/18.
 */
public class SettingAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;
    private List<SettingEntity> slist;

    public SettingAdapter(Context context){
        this.mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return SettingList.getData(context).size();
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
        slist = SettingList.getData(context);
        ViewHolder holder;
        if(convertView == null){
            convertView = mLayoutInflate.inflate(R.layout.setting_list_item,null);
            holder = new ViewHolder();
            holder.mine_image = (ImageView) convertView.findViewById(R.id.item_setting_image);
            holder.mine_text = (TextView) convertView.findViewById(R.id.item_setting_text);
            holder.mine_imgbtn = (ImageView) convertView.findViewById(R.id.item_setting_imgbtn);
            holder.icon = (ImageView) convertView.findViewById(R.id.ic_red);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        switch (position){
            case 0:
                holder.mine_image.setImageResource(R.mipmap.ic_order);
                break;
            case 1:
                holder.mine_image.setImageResource(R.mipmap.ic_record);
                break;
            case 2:
                holder.mine_image.setImageResource(R.mipmap.ic_message);
                holder.icon.setVisibility(View.VISIBLE);
                break;
            case 3:
                holder.mine_image.setImageResource(R.mipmap.ic_works);
                break;
            case 4:
                holder.mine_image.setImageResource(R.mipmap.ic_recommand);
                break;
            case 5:
                holder.mine_image.setImageResource(R.mipmap.ic_contact);
                break;
            case 6:
                holder.mine_image.setImageResource(R.mipmap.ic_help);
                break;
        }
        holder.mine_text.setText(slist.get(position).getText());
        holder.mine_imgbtn.setImageResource(R.mipmap.ic_right_arrow);
        return convertView;
    }
}
final class ViewHolder{
    ImageView mine_image;
    TextView mine_text;
    ImageView mine_imgbtn;
    ImageView icon;
}