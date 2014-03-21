package com.wog.intellcall.adapters;

import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wog.intellcall.R;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
	Context mContext;
	List<Fragment> mFragments;
	
	public SectionsPagerAdapter(Context context, FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		mContext = context;
		if(fragments != null && fragments.size() > 0)
			mFragments = fragments;
	}

	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);		
	}

	@Override
	public int getCount() {
		// Show 3 total pages.
		return (mFragments != null) ? mFragments.size() : 0;
	}

	@Override
	public CharSequence getPageTitle(int position) {		
		return String.valueOf(mFragments.get(position).getId());
	}
}
