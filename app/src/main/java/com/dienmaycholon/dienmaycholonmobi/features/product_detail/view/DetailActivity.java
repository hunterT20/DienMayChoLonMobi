package com.dienmaycholon.dienmaycholonmobi.features.product_detail.view;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.features.index.adapter.SliderMainAdapter;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

public class DetailActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private SliderMainAdapter sliderMainAdapter;

    int[] img;
    private static int currentPage = 0;
    private static int numberPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ButterKnife.bind(this);

        addViews();
    }

    private void addViews() {
        viewPager = findViewById(R.id.vp_product);
        circleIndicator = findViewById(R.id.indicator_product);
        img = new int[]{R.drawable.slide_1, R.drawable.slide_2, R.drawable.slide_3, R.drawable.slide_4};
        sliderMainAdapter = new SliderMainAdapter(img, this);

        viewPager.setAdapter(sliderMainAdapter);
        circleIndicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    int pageCount = img.length;
                    if (currentPage == 0) {
                        viewPager.setCurrentItem(pageCount - 1, false);
                    } else if (currentPage == pageCount - 1) {
                        viewPager.setCurrentItem(0, false);
                    }
                }
            }
        });

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == numberPage) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipe = new Timer();
        swipe.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 3000, 1000);
    }

}
