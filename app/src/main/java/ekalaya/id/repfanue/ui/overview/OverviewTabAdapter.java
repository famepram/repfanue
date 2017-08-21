package ekalaya.id.repfanue.ui.overview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ekalaya.id.repfanue.ui.overview.fragments.FragmentMain;
import ekalaya.id.repfanue.ui.overview.fragments.FragmentRevenue;
import ekalaya.id.repfanue.ui.overview.fragments.FragmentRequest;

/**
 * Created by WebDev on 18/08/2017.
 */

public class OverviewTabAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public OverviewTabAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentMain tab1 = new FragmentMain();
                return tab1;
            case 1:
                FragmentRevenue tab2 = new FragmentRevenue();
                return tab2;
            case 2:
                FragmentRequest tab3 = new FragmentRequest();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
