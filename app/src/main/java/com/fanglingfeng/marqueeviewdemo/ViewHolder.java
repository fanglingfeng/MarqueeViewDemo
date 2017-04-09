package com.fanglingfeng.marqueeviewdemo;

import android.widget.LinearLayout;

/*
 *  @项目名：  MarqueeViewDemo
 *  @包名：    com.fanglingfeng.marqueeviewdemo
 *  @文件名:   ViewHolder
 *  @创建者:   lingfeng
 *  @创建时间:  2017/4/9 20:29
 *  @描述：    TODO
 */
public class ViewHolder {
    private static final String TAG = "ViewHolder";
    public LinearLayout view;
    public Data data;
    public int i;
    public ViewHolder(LinearLayout view, Data data, int i) {
        this.view = view;
        this.data = data;
        this.i = i;
    }
}
