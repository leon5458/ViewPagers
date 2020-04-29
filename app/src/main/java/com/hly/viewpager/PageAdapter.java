package com.hly.viewpager;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends PagerAdapter {

    private ArrayList<View> arrayList;
    private Context context;

    public PageAdapter() {

    }

    public PageAdapter(ArrayList<View> arrayList, Context context) {
        super();
        this.arrayList = arrayList;
        this.context = context;
    }

    // 返回视图的个数
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        // 当返回为true的时候，就将根据当前的position得到的view展示出来
        return view == object;
    }

    // 这个方法的主要作用就是根据当前的posistion来创建对应的视图，
    // 并且将这个创建好的视图添加到容器中
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = arrayList.get(position);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClick != null) {
                    itemClick.OnClick(position);
                }
            }
        });
        container.addView(view);
        return view;
    }

    // 这个方法的作用就是从容器中移除position所对应的视图，
    // 而且这个移除的动作是在finishUpdate之前完成的。
    // 这个在 instantiateItem 方法中也提到过，
    // 也就是说在finishUpdate之前至少要完成两个动作①原来视图的移除②新视图的增加
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(arrayList.get(position));
    }


    private ItemClick itemClick;

    public void setOnItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public interface ItemClick {
        void OnClick(int position);
    }

}
