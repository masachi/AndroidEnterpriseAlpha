package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import org.example.androidenterprise.R;
import org.example.androidenterprise.activity.BaseActivity;
import org.example.androidenterprise.model.StudentsFeedBackEntity;
import org.example.androidenterprise.view.CircleImageView;

import java.util.List;

/**
 * Created by chenguojiao : 学员反馈适配器.
 */
public class StudentsFeedbackAdapter extends BaseAdapter{
    private List<StudentsFeedBackEntity.StudentsFeedBackListEntity> mList;
    private Context mContext;

    public StudentsFeedbackAdapter(Context context, List<StudentsFeedBackEntity.StudentsFeedBackListEntity> list){
        this.mList = list;
        this.mContext = context;
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
        ViewHolder_StudentsFeedBack holder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.students_feed_back_lv_item,null);
            holder = new ViewHolder_StudentsFeedBack();
            holder.student_civ = (CircleImageView) convertView.findViewById(R.id.grey_image);
            holder.student_name = (TextView) convertView.findViewById(R.id.item_students);
            holder.feedback_time = (TextView) convertView.findViewById(R.id.minutes_ago);
            holder.feedback_context = (TextView) convertView.findViewById(R.id.item_contact);
            holder.feedback_video = (ImageView) convertView.findViewById(R.id.iv_video);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder_StudentsFeedBack) convertView.getTag();
        }
        holder.feedback_context.setText(mList.get(position).getContent());
        holder.feedback_time.setText(mList.get(position).getDate());
        holder.student_name.setText(mList.get(position).getName());
        return convertView;

    }
}
final class ViewHolder_StudentsFeedBack{
    CircleImageView student_civ;
    TextView student_name;
    TextView feedback_time;
    TextView feedback_context;
    ImageView feedback_video;
}
