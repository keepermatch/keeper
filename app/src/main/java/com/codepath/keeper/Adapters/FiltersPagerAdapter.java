package com.codepath.keeper.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.codepath.keeper.fragments.AdvancedFiltersFragment;
import com.codepath.keeper.fragments.BasicFiltersFragment;

/**
 * Created by matthewlent on 11/28/16.
 */

public class FiltersPagerAdapter extends FragmentPagerAdapter {

        private static int NUM_ITEMS = 2;

        public FiltersPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return BasicFiltersFragment.newInstance();
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return AdvancedFiltersFragment.newInstance();
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

}


