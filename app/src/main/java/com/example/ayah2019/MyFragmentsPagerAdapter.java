package com.example.ayah2019;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ayah2019.ui.main.AllMedicineFragment;
import com.example.ayah2019.ui.main.HistoryFragment;
import com.example.ayah2019.ui.main.RemovedFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class MyFragmentsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{ };//3naween
    private final Context mContext;
    //1
    private AllMedicineFragment allMedicineFragment;
    private HistoryFragment historyFragment;
    private RemovedFragment removedFragment;

    public MyFragmentsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        //2
        allMedicineFragment=new AllMedicineFragment();
        historyFragment=new HistoryFragment();
        removedFragment=new RemovedFragment();

    }

    @Override
    public Fragment getItem(int position)//rakm al tap(fragment)
    {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        /*
     (  arja3 alfragment )
         */

        if (position==0)
            return allMedicineFragment;

        if (position==1)
            return historyFragment;

        if (position==2)
            return removedFragment;
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}