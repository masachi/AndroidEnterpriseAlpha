package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.model.CourseEntity;
import org.example.androidenterprise.R;

import java.util.List;

/**
 * Created by sdlds on 2016/9/17.
 */
public class CourseAdapter extends BaseAdapter{
    private LayoutInflater mLayoutInflate;
    private Context context;
    private List<CourseEntity.CourseListEntity> clist;

    public CourseAdapter(Context context, List<CourseEntity.CourseListEntity> course_list){
        this.mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
        this.clist = course_list;
    }

    @Override
    public int getCount() {
        //return CourseList.getData(context).size();
        return clist.size();
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
        ViewHolder_C holder;
        if(convertView == null){
            convertView = mLayoutInflate.inflate(R.layout.course_list_item,null);
            holder = new ViewHolder_C();
            holder.img = (ImageView) convertView.findViewById(R.id.iv_course);
            holder.course = (TextView) convertView.findViewById(R.id.tv_course_name);
            holder.level = (TextView) convertView.findViewById(R.id.tv_course_level);
            holder.teacher = (TextView) convertView.findViewById(R.id.tv_course_teacher);
            holder.local = (TextView) convertView.findViewById(R.id.tv_course_pos);
            holder.state = (Button) convertView.findViewById(R.id.btn_state);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder_C)convertView.getTag();
        }
        holder.img.setImageResource(R.drawable.img_example);
        holder.course.setText(clist.get(position).getClass_name());
        holder.level.setText("难度等级："+ clist.get(position).getLevel());
        holder.teacher.setText("老师：" + clist.get(position).getTeacher_name());
        holder.local.setText(clist.get(position).getLocal());
        if(clist.get(position).getAvailable().equals("false")){
            holder.state.setText("未开通");
        }
        else{
            holder.state.setText("已开通");
        }
        return convertView;
    }
}
final class ViewHolder_C{
    ImageView img;
    TextView course;
    TextView level;
    TextView teacher;
    TextView local;
    Button state;
}
