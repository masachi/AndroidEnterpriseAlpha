package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.List.CourseList;
import org.example.androidenterprise.Model.CourseEntity;
import org.example.androidenterprise.R;

import java.util.List;

/**
 * Created by sdlds on 2016/9/17.
 */
public class CourseAdapter extends BaseAdapter implements View.OnClickListener{
    private LayoutInflater mLayoutInflate;
    private Context context;
    private List<CourseEntity> clist;

    public CourseAdapter(Context context){
        this.mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return CourseList.getData(context).size();
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
        clist = CourseList.getData(context);
        ViewHolder_C holder;
        if(convertView == null){
            convertView = mLayoutInflate.inflate(R.layout.course_list_item,null);
            holder = new ViewHolder_C();
            holder.img = (ImageView) convertView.findViewById(R.id.item_image);
            holder.course = (TextView) convertView.findViewById(R.id.item_course);
            holder.level = (TextView) convertView.findViewById(R.id.item_level);
            holder.teacher = (TextView) convertView.findViewById(R.id.item_teacher);
            holder.pos = (TextView) convertView.findViewById(R.id.item_pos);
            holder.state = (Button) convertView.findViewById(R.id.btn_state);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder_C)convertView.getTag();
        }
        holder.img.setImageResource(R.drawable.img_example);
        holder.course.setText(clist.get(position).getCourse());
        holder.level.setText("难度等级："+ clist.get(position).getLevel());
        holder.teacher.setText("老师：" + clist.get(position).getTeacher());
        holder.pos.setText(clist.get(position).getPos());
        holder.state.setText(clist.get(position).getState());
        holder.state.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        if(((Button)v).getText().toString().equals("已开通")){
            ((Button)v).setText("未开通");
        }
        else {
            if (((Button) v).getText().toString().equals("未开通")) {
                ((Button) v).setText("已开通");
            }
        }
    }
}
final class ViewHolder_C{
    ImageView img;
    TextView course;
    TextView level;
    TextView teacher;
    TextView pos;
    Button state;
}
