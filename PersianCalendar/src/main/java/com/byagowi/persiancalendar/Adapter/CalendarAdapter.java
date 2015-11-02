package com.byagowi.persiancalendar.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.byagowi.persiancalendar.view.Fragment.CalendarMainFragment;
import com.byagowi.persiancalendar.view.Fragment.MonthNewFragment;

public class CalendarAdapter extends FragmentPagerAdapter {
    private CalendarMainFragment calendarMainFragment;

    public CalendarAdapter(FragmentManager fm, CalendarMainFragment calendarMainFragment) {
        super(fm);
        this.calendarMainFragment = calendarMainFragment;
    }

    @Override
    public Fragment getItem(int position) {
        MonthNewFragment fragment = new MonthNewFragment();
        fragment.addListener(calendarMainFragment);
        Bundle args = new Bundle();
        args.putInt("offset", position - CalendarMainFragment.MONTHS_LIMIT / 2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return CalendarMainFragment.MONTHS_LIMIT;
    }
}