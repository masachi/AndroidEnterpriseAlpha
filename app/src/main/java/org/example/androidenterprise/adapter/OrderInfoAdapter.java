package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import org.example.androidenterprise.Model.OrderInfoEntity;

import java.util.List;


/**
 * Created by sdlds on 2016/10/5.
 */
public class OrderInfoAdapter extends BaseAdapter{
    private LayoutInflater mLayoutInflate;
    private Context context;
    private List<OrderInfoEntity> oilist;

    public OrderInfoAdapter(Context context,List<OrderInfoEntity> oilist){
        this.context = context;
        this.mLayoutInflate = LayoutInflater.from(context);
        this.oilist = oilist;
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
        return null;
    }
}
