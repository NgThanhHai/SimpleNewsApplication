package com.example.NewsApplication.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;


public class FragmentAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragments = new ArrayList<>();
    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


    @Override
    public int getCount() {
        return fragments.size();
    }
    public void addFragment(Fragment fragment)
    {
        fragments.add(fragment);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "All";
        }
        else if (position == 1)
        {
            title = "Dev";
        }
        else if (position == 2)
        {
            title = "RECRUITMENT";
        }
        return title;
    }

}
