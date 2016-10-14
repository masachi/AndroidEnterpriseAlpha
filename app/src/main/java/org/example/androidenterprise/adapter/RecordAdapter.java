package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.R;

/**
 * Created by xiaohua on 2016/10/13.
 */
public class RecordAdapter extends BaseExpandableListAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;

    public RecordAdapter(Context context) {
        mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        //TODO:return ___list.size();
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO:return ___list.get(groupPosition).get___().size();
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        // TODO:return ___list.get(groupPosition);
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO:return ___list.get(groupPosition).get___().get(childPosition);
        return null;
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
        ViewHolderGroup_Record holderGroup;
        if (convertView == null) {
            convertView = mLayoutInflate.inflate(R.layout.record_lv_item, parent, false);
            holderGroup = new ViewHolderGroup_Record();
            holderGroup.date = (TextView) convertView.findViewById(R.id.record_date);
            holderGroup.state = (TextView) convertView.findViewById(R.id.record_state);
            holderGroup.count = (TextView) convertView.findViewById(R.id.record_count);
            holderGroup.count_price = (TextView) convertView.findViewById(R.id.record_count_price);
            convertView.setTag(holderGroup);
        } else {
            holderGroup = (ViewHolderGroup_Record) convertView.getTag();
        }
        // TODO:___list.get(groupPosition).get___()
        holderGroup.date.setText("订单时间 " + "___list.get(groupPosition).get___()");
        holderGroup.state.setText("___list.get(groupPosition).get___()");
        holderGroup.count.setText("共" + "___list.get(groupPosition).get_商品数量_()" + "件商品（含运费" + "___list.get(groupPosition).get_运费_()" + "）实付 ");
        holderGroup.count_price.setText("¥" + "___list.get(groupPosition).get___()");
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderChild_Record holderChild;
        if (convertView == null) {
            convertView = mLayoutInflate.inflate(R.layout.record_info_lv_item, parent, false);
            holderChild = new ViewHolderChild_Record();
            holderChild.img = (ImageView) convertView.findViewById(R.id.record_info_img);
            holderChild.name = (TextView) convertView.findViewById(R.id.record_info_name);
            holderChild.property = (TextView) convertView.findViewById(R.id.record_info_property);
            holderChild.price = (TextView) convertView.findViewById(R.id.record_info_price);
            convertView.setTag(holderChild);
        } else {
            holderChild = (ViewHolderChild_Record) convertView.getTag();
        }
        // TODO: ___list.get(groupPosition).get___().get(childPosition).get___()
        holderChild.img.setImageResource(R.drawable.img_example);//将R.drawable.img_example换成___list.get(groupPosition).get___().get(childPosition).get___()
        holderChild.name.setText("___list.get(groupPosition).get___().get(childPosition).get___()");
        holderChild.property.setText("___list.get(groupPosition).get___().get(childPosition).get___()");
        holderChild.price.setText("___list.get(groupPosition).get___().get(childPosition).get___()");
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

final class ViewHolderGroup_Record {
    TextView date, state, count, count_price;
}

final class ViewHolderChild_Record {
    ImageView img;
    TextView name, property, price;
}