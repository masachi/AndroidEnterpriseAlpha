package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import org.example.androidenterprise.R;

/**
 * Created by yangxinghua on 2016/10/13 ：我的留言=》系统消息页面适配器
 */
public class SystemMessageAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;
    //TODO:private List<___> ___list;

    public SystemMessageAdapter(Context context) {
        this.mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        //TODO:return ___List.getData(context).size();
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
        ViewHolder_SystemMessage holder;
        if (convertView == null) {
            convertView = mLayoutInflate.inflate(R.layout.system_message_lv_item, null);
            holder = new ViewHolder_SystemMessage();
            holder.title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.content = (TextView) convertView.findViewById(R.id.tv_content);
            holder.time = (TextView) convertView.findViewById(R.id.tv_time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder_SystemMessage) convertView.getTag();
        }
        //TODO:___list.get(position).get___
        holder.title.setText("___list.get(position).getTitle()");
        holder.content.setText("___list.get(position).getContent()");
        holder.time.setText("___list.get(position).getTime()");
        return convertView;
    }
}

final class ViewHolder_SystemMessage {
    TextView title, content, time;
}