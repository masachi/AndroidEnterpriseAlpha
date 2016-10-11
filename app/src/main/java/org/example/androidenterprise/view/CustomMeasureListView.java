package org.example.androidenterprise.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by sdlds on 2016/9/23.
 */
public class CustomMeasureListView extends ListView {
    private float mCurX,mCurY,mDownX,mDownY;

    public CustomMeasureListView(Context context) {
        super(context);
    }

    public CustomMeasureListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomMeasureListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomMeasureListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
