package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import org.example.androidenterprise.R;

/**
 * Created by cs:发布反馈Adapter
 */
public class ReleaseFeedBackPopupWindowAdapter extends BaseAdapter {
    private String[] mLesson;
    private Context mContext;

    public ReleaseFeedBackPopupWindowAdapter(Context context, String[] lesson) {
        this.mLesson = lesson;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mLesson.length;
    }

    @Override
    public Object getItem(int i) {
        return mLesson[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder_ReleaseFeedBackPopupWindow holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.release_feed_back_popupwindow_listview_item, null);
            holder = new ViewHolder_ReleaseFeedBackPopupWindow();
            holder.lesson = (TextView) convertView.findViewById(R.id.tv_course_time_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder_ReleaseFeedBackPopupWindow) convertView.getTag();
        }
        holder.lesson.setText(mLesson[position]);
        return convertView;
    }
}

final class ViewHolder_ReleaseFeedBackPopupWindow {
    TextView lesson;
}