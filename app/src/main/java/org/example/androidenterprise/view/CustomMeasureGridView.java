package org.example.androidenterprise.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by sdlds on 2016/9/21.
 */
public class CustomMeasureGridView extends GridView {
    public CustomMeasureGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomMeasureGridView(Context context) {
        super(context);
    }

    public CustomMeasureGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}