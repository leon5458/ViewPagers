package com.hly.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapdter extends PagerAdapter {

    private ArrayList<View> mList;
    private Context context;
    private ArrayList<DataBean> mData;
    private TextView title;
    private TextView content;
    private TextView label;
    private TextView time;
    private ImageView img;

    public ViewPagerAdapdter() {
    }

    public ViewPagerAdapdter(ArrayList<View> mList, Context context, ArrayList<DataBean> mData) {
        this.mList = mList;
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return this.mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(this.mList.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = mList.get(position);
        title = view.findViewById(R.id.title);
        content = view.findViewById(R.id.content);
        label = view.findViewById(R.id.label);
        time = view.findViewById(R.id.time);
        img = view.findViewById(R.id.img);

        setData(position);
        container.addView(view);

        return view;
    }

    private void setData(int position) {
        title.setText(mData.get(position).getTitle());
        content.setText(mData.get(position).getContent());
        label.setText(mData.get(position).getLabel());
        time.setText(mData.get(position).getTime());
        img.setImageResource(mData.get(position).getImg());
    }


}
