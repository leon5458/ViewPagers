package com.hly.viewpager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class SimpleViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PageAdapter pageAdapter;
    private ArrayList<View> arrayList;

    private ImageView point1, point2, point3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_viewpager_activity_layout);

        viewPager = findViewById(R.id.viewpager);
        arrayList = new ArrayList<>();
        arrayList.add(getLayoutInflater().inflate(R.layout.view_one_layout, null, false));
        arrayList.add(getLayoutInflater().inflate(R.layout.view_two_layout, null, false));
        arrayList.add(getLayoutInflater().inflate(R.layout.view_three_layout, null, false));
        pageAdapter = new PageAdapter(arrayList, this);
        viewPager.setPageMargin(100);
        viewPager.setOffscreenPageLimit(3);// 设置缓存
        viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {

            }
        });
        viewPager.setAdapter(pageAdapter);

        pageAdapter.setOnItemClick(new PageAdapter.ItemClick() {
            @Override
            public void OnClick(int position) {
                Toast.makeText(SimpleViewPagerActivity.this, "点击了第" + position + "个", Toast.LENGTH_SHORT).show();

            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int curponsition;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                curponsition = position;
                switch (position) {
                    case 0:
                        setPointImg(true, false, false);
                        break;
                    case 1:
                        setPointImg(false, true, false);
                        break;
                    case 2:
                        setPointImg(false, false, true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // ViewPager.SCROLL_STATE_IDLE 标识的状态是当前页面完全展现，并且没有动画正在进行中，如果不
                // 是此状态下执行 setCurrentItem 方法回在首位替换的时候会出现跳动！

                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    if (curponsition == 0) {
                        viewPager.setCurrentItem(arrayList.size(), false);
                    } else if (curponsition == arrayList.size() - 1) {
                        viewPager.setCurrentItem(1, false);
                    }

                }
            }
        });

        initView();

    }

    //设置小圆点的选中效果
    private void setPointImg(boolean isCheck1, boolean isCheck2, boolean isCheck3) {
        if (isCheck1) {
            point1.setBackgroundResource(R.mipmap.point_select);
        } else {
            point1.setBackgroundResource(R.mipmap.point_unselect);
        }

        if (isCheck2) {
            point2.setBackgroundResource(R.mipmap.point_select);
        } else {
            point2.setBackgroundResource(R.mipmap.point_unselect);
        }

        if (isCheck3) {
            point3.setBackgroundResource(R.mipmap.point_select);
        } else {
            point3.setBackgroundResource(R.mipmap.point_unselect);
        }


    }


    private void initView() {
        point1 = findViewById(R.id.point_one);
        point2 = findViewById(R.id.point_two);
        point3 = findViewById(R.id.point_three);
        setPointImg(true, false, false);

    }
}
