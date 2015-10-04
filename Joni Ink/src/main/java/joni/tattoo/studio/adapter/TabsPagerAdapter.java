package joni.tattoo.studio.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import joni.tattoo.studio.AllFragment;
import joni.tattoo.studio.PiercingFragment;
import joni.tattoo.studio.TattooFragment;

/**
 * Created by Joni on 3/13/14.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new TattooFragment();
            case 1:
                // Games fragment activity
                return new PiercingFragment();
            case 2:
                // Movies fragment activity
                return new AllFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
