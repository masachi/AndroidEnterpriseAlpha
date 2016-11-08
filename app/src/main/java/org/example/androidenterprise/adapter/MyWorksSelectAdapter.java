package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MyWorksSelectAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Map<String,String>> listData;

    public List<String> indexList = new ArrayList<String>();
    // 定义一个向量作为选中与否容器
    private Vector<Boolean> mImage_bs = new Vector<Boolean>();

    public MyWorksSelectAdapter(Context context, ArrayList<Map<String,String>> listData) {
        this.context = context;
        this.listData = listData;
        this.layoutInflater = LayoutInflater.from(context);
        for (int i = 0; i < listData.size(); i++) {
            mImage_bs.add(false);
        }
    }

    @Override
    public int getCount() {

        return listData.size();
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder_MyWorksSelect holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.myworks_custom_measure_gridview_item, null);
            holder = new ViewHolder_MyWorksSelect();
            holder.imgMyWorksItem = (ImageView) convertView.findViewById(R.id.imgMyWorksItem);
            holder.imgMyWorksSelectItem = (ImageView) convertView.findViewById(R.id.imgMyWorksSelectItem);
            holder.tvMyWorksTime = (TextView) convertView.findViewById(R.id.tv_my_works_time);
            holder.tvMyWorksDate = (TextView) convertView.findViewById(R.id.tv_my_works_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder_MyWorksSelect) convertView.getTag();
        }
        int img = Integer.valueOf(listData.get(position).get("img"));
        holder.imgMyWorksItem.setImageResource(img);
        holder.tvMyWorksTime.setText(listData.get(position).get("time"));
        holder.tvMyWorksDate.setText(listData.get(position).get("date"));

        if (mImage_bs.elementAt(position))
            holder.imgMyWorksSelectItem.setImageResource(R.mipmap.ic_mywork_check);
        else {
            holder.imgMyWorksSelectItem.setImageResource(R.mipmap.ic_mywork_nocheck);
        }

        return convertView;
    }

    /**
     * 得到选中的item的内容
     * @return
     */
    public ArrayList<String> getNameList() {
        ArrayList<String> daleteList = new ArrayList<>();
        for (int i = 0; i < indexList.size(); i++) {
            int temp = Integer.parseInt(indexList.get(i));
            daleteList.add(listData.get(temp).get("date"));
        }
        return daleteList;
    }

    // 修改选中的状态
    public void changeState(int position) {
        if (indexList.contains(position + "")) {
            indexList.remove(position + "");
        } else {
            indexList.add(position + "");
        }
        // 多选时
        mImage_bs.setElementAt(!mImage_bs.elementAt(position), position); // 直接
        notifyDataSetChanged(); // 通知适配器进行更新
    }
    public void fresh() {
        notifyDataSetChanged();
    }
}
final class ViewHolder_MyWorksSelect{
    ImageView imgMyWorksItem,imgMyWorksSelectItem;
    TextView tvMyWorksTime,tvMyWorksDate;
}
