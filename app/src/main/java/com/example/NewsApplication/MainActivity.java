package com.example.NewsApplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.NewsApplication.Adapters.FragmentAdapter;
import com.example.NewsApplication.Views.Fragments.AllFragment;
import com.example.NewsApplication.Views.Fragments.DevFragment;
import com.example.NewsApplication.Views.Fragments.RecruitmentFragment;
import com.example.NewsApplication.Views.R;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    TabLayout tabLayout ;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tab_Layout);
        createViewPager();
    }

    public void createViewPager()
    {
        final FragmentAdapter adapter = new FragmentAdapter(this.getSupportFragmentManager());
        adapter.addFragment(new AllFragment());
        adapter.addFragment(new DevFragment());
        adapter.addFragment(new RecruitmentFragment());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}