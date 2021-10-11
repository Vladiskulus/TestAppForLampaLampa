package com.testingappforlampalampa.view.adapter;

import static com.testingappforlampalampa.Constants.*;

import androidx.annotation.*;
import androidx.fragment.app.*;

import com.testingappforlampalampa.view.fragment.*;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return PagerFragment.newInstance(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return FAVORITE;
            case 1:
                return STORY;
            case 2:
                return VIDEO;
            default:
                return getPageTitle(position);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
