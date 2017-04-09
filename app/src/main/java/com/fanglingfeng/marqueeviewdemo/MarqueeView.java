package com.fanglingfeng.marqueeviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import java.util.List;

/*
 *  @项目名：  MarqueeViewDemo 
 *  @包名：    com.fanglingfeng.marqueeviewdemo
 *  @文件名:   MarqueeView
 *  @创建者:   lingfeng
 *  @创建时间:  2017/4/9 15:12
 *  @描述：    TODO
 */
public class MarqueeView extends ViewFlipper {
    private static final String TAG = "MarqueeView";
    private int internal = 2500;
    private int animDuration = 500;
    private Animation animIn;
    private Animation animOut;
    private int animInRes = R.anim.bottom_in;
    private int animOutRes = R.anim.top_out;
    public MarqueeView(Context context) {
        super(context);
    }

    public MarqueeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }

    private void initAttrs( AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs,
                                                                    R.styleable.MarqueeView,
                                                                    0,
                                                                    0);
        internal = typedArray.getInteger(R.styleable.MarqueeView_marqueeInterval,internal);
        animDuration = typedArray.getInteger(R.styleable.MarqueeView_marqueeAnimDuration,animDuration);
        animInRes = typedArray.getResourceId(R.styleable.MarqueeView_marqueeInAnim,animInRes);
        animOutRes = typedArray.getResourceId(R.styleable.MarqueeView_marqueeInAnim,animOutRes);
        setFlipInterval(internal);
        animIn = AnimationUtils.loadAnimation(getContext(),animInRes);
        animIn.setDuration(animDuration);
        setInAnimation(animIn);
        animOut = AnimationUtils.loadAnimation(getContext(),animOutRes);
        animOut.setDuration(animDuration);
        setOutAnimation(animOut);
    }
    public void setMarqueeFactory(MarqueeFactory marqueeFactory){
        marqueeFactory.setAttachedToMarqueeView(this);
        removeAllViews();
        List<LinearLayout> views = marqueeFactory.getMarqueeView();
        if (views != null) {
            for (int i = 0; i < views.size(); i++) {
                addView(views.get(i));
            }
        }

    }
    public void setInterval(int interval) {
        this.internal = interval;
        setFlipInterval(interval);
    }

    public void setAnimDuration(int animDuration) {
        this.animDuration = animDuration;
        animIn.setDuration(animDuration);
        setInAnimation(animIn);
        animOut.setDuration(animDuration);
        setOutAnimation(animOut);
    }

    public void setAnimInAndOut(Animation animIn, Animation animOut) {
        this.animIn = animIn;
        this.animOut = animOut;
        setInAnimation(animIn);
        setOutAnimation(animOut);
    }

    public void setAnimInAndOut(int animInId, int animOutID) {
        animIn = AnimationUtils.loadAnimation(getContext(), animInId);
        animOut = AnimationUtils.loadAnimation(getContext(), animOutID);
        animIn.setDuration(animDuration);
        animOut.setDuration(animDuration);
        setInAnimation(animIn);
        setOutAnimation(animOut);

    }

    public Animation getAnimIn() {
        return animIn;
    }

    public Animation getAnimOut() {
        return animOut;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopFlipping();
    }
}
