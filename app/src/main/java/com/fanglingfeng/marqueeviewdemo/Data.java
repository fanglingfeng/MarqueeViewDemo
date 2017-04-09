package com.fanglingfeng.marqueeviewdemo;

/*
 *  @项目名：  MarqueeViewDemo 
 *  @包名：    com.fanglingfeng.marqueeviewdemo
 *  @文件名:   Data
 *  @创建者:   lingfeng
 *  @创建时间:  2017/4/9 19:19
 *  @描述：    TODO
 */
public class Data {
    public Data(String title, String name, String time) {
        this.title = title;
        this.name = name;
        this.time = time;
    }

    private static final String TAG = "Data";
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String name;
    private String time;
}
