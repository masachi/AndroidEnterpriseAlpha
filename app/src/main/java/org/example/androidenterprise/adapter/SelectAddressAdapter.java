package org.example.androidenterprise.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import org.example.androidenterprise.R;
import org.example.androidenterprise.activity.EditAddActivity;
import org.example.androidenterprise.activity.SelectAddActivity;

/**
 * Created by sdlds on 2016/11/4.
 */
public class SelectAddressAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;
    private int checkedPosition;

    // TODO: 2016/11/4 add list received from server

    public SelectAddressAdapter(Context context) {
        this.context = context;
        mLayoutInflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
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
        ViewHolder_SelectAddress holder;
        if (convertView == null) {
            holder = new ViewHolder_SelectAddress();
            convertView = mLayoutInflate.inflate(R.layout.select_add_lv_item, null);
            holder.radioBtn = (RadioButton) convertView.findViewById(R.id.rb_select);
            holder.consigneeTv = (TextView) convertView.findViewById(R.id.tv_consignee);
            holder.phonenumTv = (TextView) convertView.findViewById(R.id.tv_phonenum);
            holder.addressTv = (TextView) convertView.findViewById(R.id.tv_address);
            holder.editRl = (RelativeLayout) convertView.findViewById(R.id.rl_edit);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder_SelectAddress) convertView.getTag();
        }
        //// TODO: 数据.....2333333
        holder.consigneeTv.setText("收货人：" + "某某某");
        holder.phonenumTv.setText("13366668888");
        holder.addressTv.setText("地址：" + "山东省威海市山东省威海市山东省威海市山东省威海市山东省威海市");
        holder.editRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent().setClass(context,EditAddActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("add_addr","1");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        if (position == checkedPosition) {
            holder.radioBtn.setChecked(true);
        } else {
            holder.radioBtn.setChecked(false);
        }
        return convertView;
    }

    public void setCheckedPosition(int position) {
        this.checkedPosition = position;
        notifyDataSetChanged();
    }
}

final class ViewHolder_SelectAddress {
    RadioButton radioBtn;
    TextView consigneeTv;
    TextView phonenumTv;
    TextView addressTv;
    RelativeLayout editRl;
}
