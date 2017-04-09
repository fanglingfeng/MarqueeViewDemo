package com.fanglingfeng.marqueeviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity
        extends AppCompatActivity
{
    private final List<String> datas = Arrays.asList("《赋得古原草送别》", "离离原上草，一岁一枯荣。", "野火烧不尽，春风吹又生。", "远芳侵古道，晴翠接荒城。", "又送王孙去，萋萋满别情。");
    @BindView(R.id.marquee_view)
    MarqueeView    mMarqueeView;
    @BindView(R.id.activity_main)
    RelativeLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MarqueeFactory factory = new MarqueeFactory(this);
        List<Data> complexDatas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            complexDatas.add(new Data("标题 " + i, "副标题 " + i, "时间 " + i));
        }
        factory.setDatas(complexDatas);
        mMarqueeView.setMarqueeFactory(factory);
        mMarqueeView.startFlipping();
    }
}
