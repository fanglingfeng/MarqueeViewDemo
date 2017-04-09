package com.fanglingfeng.marqueeviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
 *  @项目名：  MarqueeViewDemo 
 *  @包名：    com.fanglingfeng.marqueeviewdemo
 *  @文件名:   MarqueeFactory
 *  @创建者:   lingfeng
 *  @创建时间:  2017/4/9 16:43
 *  @描述：    TODO
 */
public class MarqueeFactory {
    private static final String TAG = "MarqueeFactory";
    private Context mContext;
    private List<LinearLayout> views;
    private List<Data> mDatas ;
    private MarqueeView mMarqueeView;
    private LayoutInflater mLayoutInflater;
    public MarqueeFactory(Context context){
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public LinearLayout generatedMarqueeItemView(Data data){
        LinearLayout view = (LinearLayout) mLayoutInflater.inflate(R.layout.item_marquee_view, null);
        ((TextView)view.findViewById(R.id.tv_1)).setText(data.getTitle());
        ((TextView)view.findViewById(R.id.tv_2)).setText(data.getName());
        ((TextView)view.findViewById(R.id.tv_3)).setText(data.getTime());
        return view;
    };

    public void setAttachedToMarqueeView(MarqueeView marqueeView) {
        this.mMarqueeView = marqueeView;
    }

    public List<LinearLayout> getMarqueeView() {
        return views;
    }
    public void setDatas(List<Data> datas){
        if (datas == null || datas.size() == 0) {
            return;
        }
        views = new ArrayList<>();
        this.mDatas = datas;
        for (int i = 0; i < mDatas.size(); i++) {
            Data data = mDatas.get(i);
            LinearLayout view = generatedMarqueeItemView(data);
            view.setTag(new ViewHolder(view,data,i));
            views.add(view);
        }
        if (mMarqueeView != null) {
            mMarqueeView.setMarqueeFactory(this);
        }
    }
}
