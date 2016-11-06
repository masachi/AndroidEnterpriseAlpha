package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.R;
import org.example.androidenterprise.activity.BaseActivity;
import org.example.androidenterprise.model.CourseInfoEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/4.
 */
public class CourseInfoAdapter extends BaseAdapter {
    private Context mContext;
    private List<CourseInfoEntity.ClassDetailInfoEntity> mList;
    public CourseInfoAdapter(Context context,List<CourseInfoEntity.ClassDetailInfoEntity> courseInfoList){
        this.mContext = context;
        this.mList = courseInfoList;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderCourseInfo holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_course_info_listview_item, null);
            holder = new ViewHolderCourseInfo();
            holder.courseNum = (TextView) convertView.findViewById(R.id.tv_course_info_schedule_title);
            holder.courseType = (TextView) convertView.findViewById(R.id.tv_type);
            holder.courseDate = (TextView) convertView.findViewById(R.id.tv_date);
            holder.courseContent = (TextView) convertView.findViewById(R.id.tv_schedule_info);
            holder.courseTime = (TextView) convertView.findViewById(R.id.tv_time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolderCourseInfo) convertView.getTag();
        }
        holder.courseNum.setText("课时" + mList.get(position).getNum());
        holder.courseContent.setText(mList.get(position).getContent());
        holder.courseDate.setText(mList.get(position).getDate());
        holder.courseTime.setText(mList.get(position).getTime());
        if (mList.get(position).getType().equals("true")){
            holder.courseType.setText("（已完成）");
        }else {
            holder.courseType.setText("（未完成）");
        }
        return convertView;
    }
}
final class ViewHolderCourseInfo{
    TextView courseNum;
    TextView courseType;
    TextView courseContent;
    TextView courseDate;
    TextView courseTime;
}
