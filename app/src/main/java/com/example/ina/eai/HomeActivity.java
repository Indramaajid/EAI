package com.example.ina.eai;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ShopAdapter adapter;
    private List<Shop> shopList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SliderAdapter sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        shopList = new ArrayList<>();
        adapter = new ShopAdapter(this, shopList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareMenu();
    }

    private void prepareMenu() {
        int[] covers = new int[]{
                R.drawable.pic1,
                R.drawable.pic2,
                R.drawable.pic3,
                R.drawable.pic4,};

        Shop m = new Shop("Couple Goals Package", "Rp 300,000", covers[0]);
        shopList.add(m);

        m = new Shop("Shimmery Gold Package", "Rp 350,000", covers[1]);
        shopList.add(m);

        m = new Shop("Summer Vibes Packages", "Rp 350,000", covers[2]);
        shopList.add(m);

        m = new Shop("Sweet Dreams Package", "Rp 350,000", covers[3]);
        shopList.add(m);

        adapter.notifyDataSetChanged();
    }

}
