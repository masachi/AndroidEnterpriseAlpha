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
public class ContactUsServiceAdapter extends BaseAdapter {
    private List<String> listServiceName;
    private Context context;
    private LayoutInflater mLayoutInflate;

    public ContactUsServiceAdapter(Context context,List<String> listServiceName){
        this.context = context;
        this.listServiceName = listServiceName;
        this.mLayoutInflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listServiceName.size();
    }

    @Override
    public Object getItem(int position) {
        return listServiceName.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder_ContactUsService holder_contactUsService;
        if(view==null){
            view = mLayoutInflate.inflate(R.layout.activity_us_contact_service_gridview_item,null);
            holder_contactUsService=new ViewHolder_ContactUsService();
            holder_contactUsService.serviceItemRb=(RadioButton)view.findViewById(R.id.service_item_rb);
            view.setTag(holder_contactUsService);
        }else {
            holder_contactUsService = (ViewHolder_ContactUsService) view.getTag();
        }
        holder_contactUsService.serviceItemRb.setText(listServiceName.get(position));
        return view;
    }
}
final class ViewHolder_ContactUsService{
   RadioButton serviceItemRb;
}
