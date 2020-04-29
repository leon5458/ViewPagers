package com.hly.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class DataViewActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<View> mList = new ArrayList<>();
    private ArrayList<DataBean> mData;
    private ViewPagerAdapdter adapdter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_view_activity_layout);

        viewPager = findViewById(R.id.viewpager);
        mData = new ArrayList<>();
        mData.add(new DataBean("昨天心情很不好", "难得的聚会时刻,既然有人突然离开了", "心情", "2018/10/20", R.mipmap.one));
        mData.add(new DataBean("今天心情很特别好", "难得的聚会时刻，大家一起开怀畅饮", "活跃", "2018/10/21", R.mipmap.two));
        mData.add(new DataBean("明天心情预计好的不得了", "晓天机预测明天大家将会有好运", "预测", "2018.20/22", R.mipmap.three));

        for (int i = 0; i < mData.size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.view_pager_layout, null);
            mList.add(view);
        }
        adapdter = new ViewPagerAdapdter(mList, this, mData);
        viewPager.setAdapter(adapdter);
        viewPager.setCurrentItem(0);


    }
}
