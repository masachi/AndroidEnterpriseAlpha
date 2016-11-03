package org.example.androidenterprise.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import org.example.androidenterprise.R;

import java.util.Vector;

import static org.example.androidenterprise.utils.Constant.lastPosition;
import static org.example.androidenterprise.utils.Constant.size;

/**
 * Created by sdlds on 2016/10/28.
 */
public class BuyPropertyAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;
    private Vector<Boolean> vector = new Vector<Boolean>();// 定义一个向量作为选中与否容器
//    private int lastPosition = -1;   //lastPosition 记录上一次选中的图片位置，-1表示未选中
    private int pos;
//    private int size = 10;
    // TODO: 2016/10/29 this size is the array's length marked as property via http protocol from server.

    public BuyPropertyAdapter(Context context){
        this.context = context;
        this.mLayoutInflate = LayoutInflater.from(context);
        for(int i=0;i<size;i++){
            vector.add(false);

        }
    }

    @Override
    public int getCount() {
        return size;
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
        ViewHolder_Pro holder;
        if(convertView == null){
            convertView = mLayoutInflate.inflate(R.layout.instant_buy_gv_item,null);
            holder = new ViewHolder_Pro();
            holder.propertyTv = (TextView) convertView.findViewById(R.id.btn_instant_buy);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder_Pro) convertView.getTag();
        }

        if(vector.elementAt(position) == true){
            holder.propertyTv.setBackground(context.getResources().getDrawable(R.drawable.activity_instant_buy_blue_bg));
            holder.propertyTv.setTextColor(context.getResources().getColor(R.color.color_97c8cd));
        }
        else{
            holder.propertyTv.setBackground(context.getResources().getDrawable(R.drawable.activity_instant_buy_grey_bg));
            holder.propertyTv.setTextColor(context.getResources().getColor(R.color.color_999999));
        }
        return convertView;
    }

    public void changeState(int position){
        if(lastPosition != -1) {
            vector.setElementAt(false, lastPosition);
        }                   //取消上一次的选中状态
        vector.setElementAt(!vector.elementAt(position), position);     //直接取反即可
        lastPosition = position;//记录本次选中的位置
        Log.e("23333",String.valueOf(lastPosition));
        notifyDataSetChanged();                                         //通知适配器进行更新
    }
}
class ViewHolder_Pro{
    TextView propertyTv;
}
