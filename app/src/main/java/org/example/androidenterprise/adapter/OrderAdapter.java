package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import org.example.androidenterprise.Model.OrderInfoEntity;
import org.example.androidenterprise.R;

import java.util.List;

import static org.example.androidenterprise.utils.InitData.olist;

/**
 * Created by sdlds on 2016/10/5.
 */
public class OrderAdapter extends BaseExpandableListAdapter {
    private Context context;
    private LayoutInflater mLayoutInflate;

    public OrderAdapter(Context context){
        this.context = context;
        mLayoutInflate = LayoutInflater.from(context);
    }


    @Override
    public int getGroupCount() {
        return olist.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return olist.get(groupPosition).getOrder_info().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return olist.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return olist.get(groupPosition).getOrder_info().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup holderGroup;
        if(convertView == null){
            convertView  = mLayoutInflate.inflate(R.layout.search_order_lv_item,parent,false);
            holderGroup = new ViewHolderGroup();
            holderGroup.dateTv = (TextView) convertView.findViewById(R.id.search_info_order_date);
            convertView.setTag(holderGroup);
        }
        else{
            holderGroup = (ViewHolderGroup) convertView.getTag();
        }
        holderGroup.dateTv.setText(olist.get(groupPosition).getOrder_date());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderChild holderChild;
        if(convertView == null){
            convertView = mLayoutInflate.inflate(R.layout.search_order_info_lv_item,parent,false);
            holderChild = new ViewHolderChild();
            holderChild.timeTv = (TextView) convertView.findViewById(R.id.search_order_info_time);
            holderChild.courseTv = (TextView) convertView.findViewById(R.id.search_order_info_course);
            holderChild.posTv = (TextView) convertView.findViewById(R.id.search_order_info_pos);
            convertView.setTag(holderChild);
        }
        else{
            holderChild = (ViewHolderChild) convertView.getTag();
        }
        holderChild.timeTv.setText(olist.get(groupPosition).getOrder_info().get(childPosition).getTime());
        holderChild.courseTv.setText(olist.get(groupPosition).getOrder_info().get(childPosition).getCourse());
        holderChild.posTv.setText(olist.get(groupPosition).getOrder_info().get(childPosition).getPosition());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
final class ViewHolderGroup{
    TextView dateTv;
}
final class ViewHolderChild{
    TextView timeTv;
    TextView courseTv;
    TextView posTv;
}
