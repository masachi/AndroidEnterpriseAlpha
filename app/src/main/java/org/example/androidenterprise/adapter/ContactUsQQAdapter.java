package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import org.example.androidenterprise.R;

import java.util.List;

/**
 * Created by Administrator on 2016/10/16.
 */
public class ContactUsQQAdapter extends BaseAdapter {
    private List<String> listQQName;
    private Context context;
    private LayoutInflater mLayoutInflate;

    public ContactUsQQAdapter(Context context,List<String> listQQName){
        this.context = context;
        this.listQQName = listQQName;
        this.mLayoutInflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listQQName.size();
    }

    @Override
    public Object getItem(int position) {
        return listQQName.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder_ContactUsQQ holder_contactUsQQ;
        if(view==null){
            view = mLayoutInflate.inflate(R.layout.activity_us_contact_qq_gv_item,null);
            holder_contactUsQQ=new ViewHolder_ContactUsQQ();
            holder_contactUsQQ.qqRb=(RadioButton)view.findViewById(R.id.rb_qq);
            view.setTag(holder_contactUsQQ);
        }else {
            holder_contactUsQQ = (ViewHolder_ContactUsQQ) view.getTag();
        }
        holder_contactUsQQ.qqRb.setText(listQQName.get(position));
        return view;
    }
}
final class ViewHolder_ContactUsQQ{
    RadioButton qqRb;
}
