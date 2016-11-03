package org.example.androidenterprise.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import org.example.androidenterprise.R;
import org.example.androidenterprise.activity.ServiceTalkActivity;

import java.util.List;

/**
 * Created by baiqingyu : 联系我们页面中客服adapter
 */
public class ContactUsServiceAdapter extends BaseAdapter {
    private List<String> listServiceName;
    private Context context;
    private LayoutInflater mLayoutInflate;

    public ContactUsServiceAdapter(Context context, List<String> listServiceName) {
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
        final ViewHolder_ContactUsService holder_contactUsService;
        if (view == null) {
            view = mLayoutInflate.inflate(R.layout.activity_us_contact_service_gridview_item, null);
            holder_contactUsService = new ViewHolder_ContactUsService();
            holder_contactUsService.serviceItemRb = (RadioButton) view.findViewById(R.id.rb_service_item);
            view.setTag(holder_contactUsService);
        } else {
            holder_contactUsService = (ViewHolder_ContactUsService) view.getTag();
        }
        holder_contactUsService.serviceItemRb.setText(listServiceName.get(position));
        if (position == 2 || position == 5) {
            holder_contactUsService.serviceItemRb.setChecked(false);
            holder_contactUsService.serviceItemRb.setClickable(false);
        } else {
            holder_contactUsService.serviceItemRb.setChecked(true);
            holder_contactUsService.serviceItemRb.setClickable(true);
        }
        if (holder_contactUsService.serviceItemRb.isChecked() == true) {
            holder_contactUsService.serviceItemRb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ServiceTalkActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
//                Toast.makeText(context, "hhhhh", Toast.LENGTH_LONG).show();
                }
            });
        }
        return view;
    }
}

final class ViewHolder_ContactUsService {
    RadioButton serviceItemRb;
}
