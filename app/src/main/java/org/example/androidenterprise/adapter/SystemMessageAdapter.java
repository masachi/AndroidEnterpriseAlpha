package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.model.SystemMessageEntity;

import java.util.List;

/**
 * Created by yangxinghua on 2016/10/13 ：我的留言=》系统消息页面适配器
 */
public class SystemMessageAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;
    private List<SystemMessageEntity.SystemMessageListEntity> list;

    public SystemMessageAdapter(Context context,List<SystemMessageEntity.SystemMessageListEntity> list) {
        this.mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        holder.title.setText(list.get(position).getTitle());
        holder.content.setText(list.get(position).getContent());
        holder.time.setText(list.get(position).getDate());
        return convertView;
    }
}

final class ViewHolder_SystemMessage {
    TextView title, content, time;
}