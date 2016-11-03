package org.example.androidenterprise.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import org.example.androidenterprise.R;

/**
 * Created by yangxinghua on 2016/11/2.
 */

public class TopbarView extends FrameLayout {

    private ImageView leftIb;
    private TextView topbarTv;
    private ImageView right1Ib;
    private ImageView right2Ib;

    public TopbarView(Context context) {
        super(context);
    }

    public TopbarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.top_bar, this);
        leftIb = (ImageView) findViewById(R.id.ib_left);
        topbarTv = (TextView) findViewById(R.id.tv_top_bar);
        right1Ib = (ImageView) findViewById(R.id.ib_right1);
        right2Ib = (ImageView) findViewById(R.id.ib_right2);
    }

    public ImageView getLeftIb() {
        return leftIb;
    }

    public void setLeftIb(Drawable img) {
        leftIb.setImageDrawable(img);
    }

    public TextView getTopbarTv() {
        return topbarTv;
    }

    public void setTopbarTv(String text) {
        topbarTv.setText(text);
    }

    public ImageView getRight1Ib() {
        return right1Ib;
    }

    public void setRight1Ib(Drawable img) {
        right1Ib.setImageDrawable(img);
    }

    public ImageView getRight2Ib() {
        return right2Ib;
    }

    public void setRight2Ib(Drawable img) {
        right2Ib.setImageDrawable(img);
    }

    public void setLeftIbOnClickListener(OnClickListener leftIbOnClickListener){
        leftIb.setOnClickListener(leftIbOnClickListener);
    }

        public void setRight1IbOnClickListener(OnClickListener right1IbOnClickListener) {
        right1Ib.setOnClickListener(right1IbOnClickListener);
    }

    public void setRight2IbOnClickListener(OnClickListener right2IbOnClickListener) {
        right2Ib.setOnClickListener(right2IbOnClickListener);
    }
}