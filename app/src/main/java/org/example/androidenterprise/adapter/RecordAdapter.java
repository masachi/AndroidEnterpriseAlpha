package org.example.androidenterprise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import org.example.androidenterprise.R;
import org.example.androidenterprise.model.RecordEntity;

import java.util.List;

/**
 * Created by yangxinghua on 2016/10/13 ：交易记录页面适配器
 */
public class RecordAdapter extends BaseExpandableListAdapter {
    private LayoutInflater mLayoutInflate;
    private Context context;
    private List<RecordEntity.OrderListEntity> mList;

    public RecordAdapter(Context context,List<RecordEntity.OrderListEntity> list) {
        mLayoutInflate = LayoutInflater.from(context);
        this.context = context;
        this.mList = list;
    }

    @Override
    public int getGroupCount() {
        //TODO:return ___list.size();
        //return 0;

        return mList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO:return ___list.get(groupPosition).get___().size();
        //return 0;

        return  mList.get(groupPosition).getList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        // TODO:return ___list.get(groupPosition);

        return mList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO:return ___list.get(groupPosition).get___().get(childPosition);

        return mList.get(groupPosition).getList().get(childPosition);
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
            holderGroup.date = (TextView) convertView.findViewById(R.id.tv_date);
            holderGroup.state = (TextView) convertView.findViewById(R.id.tv_state);
            holderGroup.count = (TextView) convertView.findViewById(R.id.tv_count);
            holderGroup.count_price = (TextView) convertView.findViewById(R.id.tv_price);
            convertView.setTag(holderGroup);
        } else {
            holderGroup = (ViewHolderGroup_Record) convertView.getTag();
        }
        // TODO:___list.get(groupPosition).get___()
        holderGroup.date.setText("订单时间 :" +  mList.get(groupPosition).getDate());
        holderGroup.state.setText(mList.get(groupPosition).getSituation());
        holderGroup.count.setText("共" + mList.get(groupPosition).getList().size() + "件商品（含运费" + mList.get(groupPosition).getFreigh() + "）实付 ");
        double price = (double) mList.get(groupPosition).getFreigh() + mList.get(groupPosition).getPrice();
        holderGroup.count_price.setText("¥" + price);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderChild_Record holderChild;
        if (convertView == null) {
            convertView = mLayoutInflate.inflate(R.layout.record_info_lv_item, parent, false);
            holderChild = new ViewHolderChild_Record();
            holderChild.img = (ImageView) convertView.findViewById(R.id.iv_record);
            holderChild.name = (TextView) convertView.findViewById(R.id.tv_name);
            holderChild.property = (TextView) convertView.findViewById(R.id.tv_property);
            holderChild.price = (TextView) convertView.findViewById(R.id.tv_price);
            convertView.setTag(holderChild);
        } else {
            holderChild = (ViewHolderChild_Record) convertView.getTag();
        }
        // TODO: ___list.get(groupPosition).get___().get(childPosition).get___()
//        holderChild.img.setImageResource(R.drawable.img_example);//将R.drawable.img_example换成___list.get(groupPosition).get___().get(childPosition).get___()
        Glide.with(context).load(mList.get(groupPosition).getList().get(childPosition).getPic_url()).into(holderChild.img);
        holderChild.name.setText( mList.get(groupPosition).getList().get(childPosition).getName());
        holderChild.property.setText(mList.get(groupPosition).getList().get(childPosition).getType());
        holderChild.price.setText(mList.get(groupPosition).getList().get(childPosition).getNow_price());
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