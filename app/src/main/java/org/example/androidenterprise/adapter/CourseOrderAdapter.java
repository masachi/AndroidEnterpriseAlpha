package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.R;

/**
 * Created by yangxinghua on 2016/10/19 ：课程订购页面适配器
 */
public class CourseOrderAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;
    //TODO:private List<CourseInfoEntity> ___list;

    public CourseOrderAdapter(Context context) {
        this.mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
        //this.clist = course_list;
    }

    @Override
    public int getCount() {
        //TODO: return ___List.getData(context).size();
        return 0;
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
        ViewHolder_CourseOrder holder;
        if (convertView == null) {
            convertView = mLayoutInflate.inflate(R.layout.course_order_lv_item, null);
            holder = new ViewHolder_CourseOrder();
            holder.img = (ImageView) convertView.findViewById(R.id.iv_course_order);
            holder.name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.difficulty = (TextView) convertView.findViewById(R.id.tv_difficulty);
            holder.teacher = (TextView) convertView.findViewById(R.id.tv_teacher);
            holder.classroom = (TextView) convertView.findViewById(R.id.tv_classroom);
            holder.price = (TextView) convertView.findViewById(R.id.tv_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder_CourseOrder) convertView.getTag();
        }
        // TODO: ___list.get(position).get___()
        holder.img.setImageResource(R.drawable.img_example2);
        holder.name.setText("什么课什么课什么课");
        holder.difficulty.setText("难度等级："+ "ABCDE");
        holder.teacher.setText("老师：" + "XXX老师");
        holder.classroom.setText("什么楼什么教室");
        holder.price.setText("6666.66");

        return convertView;
    }
}

final class ViewHolder_CourseOrder {
    ImageView img;
    TextView name, difficulty, teacher, classroom, price;
}