package com.testingappforlampalampa.view.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.testingappforlampalampa.view.fragment.FavoriteFragment;
import com.testingappforlampalampa.view.fragment.StoryFragment;
import com.testingappforlampalampa.view.fragment.VideoFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FavoriteFragment.newInstance();
            case 1:
                return StoryFragment.newInstance();
            case 2:
                return VideoFragment.newInstance();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "FAVORITE";
            case 1:
                return "STORY";
            case 2:
                return "VIDEO";
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
