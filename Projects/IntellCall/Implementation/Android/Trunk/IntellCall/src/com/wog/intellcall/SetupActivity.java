package com.wog.intellcall;

import java.util.ArrayList;
import java.util.List;

import com.wog.intellcall.adapters.SectionsPagerAdapter;
import com.wog.intellcall.fragments.PackageSelectionFragment;
import com.wog.intellcall.fragments.WelcomeFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SetupActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	
	/**
	 * The Parent Fragment to manage all children
	 */
	List<Fragment> mFragments;

	LinearLayout mLayoutPagingIndex;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setOnPageChangeListener(pageChangeListener);
		
		mLayoutPagingIndex = (LinearLayout) findViewById(R.id.layoutIndexPage);
		
		mFragments = new ArrayList<Fragment>();
		
		initFragments();
		
		initPagingIndex(mFragments.size());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	/**
	 * Initialize all child fragments
	 */
	private void initFragments() {
		WelcomeFragment welcomeFragment = new WelcomeFragment();
		PackageSelectionFragment packageSelectionFragment = new PackageSelectionFragment();
		
		mFragments.add(welcomeFragment);
		mFragments.add(packageSelectionFragment);
		
		mSectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), mFragments);
		mViewPager.setAdapter(mSectionsPagerAdapter);
	}
	
	private void initPagingIndex(int size) {
		for (int i = 0; i < size; i++) {
			ImageView imgView = new ImageView(this);
			if(i == 0)
				imgView.setImageDrawable(getResources().getDrawable(R.drawable.ic_index_dot_selected));
			else
				imgView.setImageDrawable(getResources().getDrawable(R.drawable.ic_index_dot));
			
			imgView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			imgView.setPadding(20, 0, 20, 0);
			imgView.setTag(i); // mark position
			
			imgView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					int position = (Integer) v.getTag();
					mViewPager.setCurrentItem(position, true);					
					updateIndex(position);
				}
			});
			
			mLayoutPagingIndex.addView(imgView);
		}
	}
	
	/**
	 * Update the paging index dot
	 * @param position: fragment position
	 */
	private void updateIndex(int position) {
		for (int i = 0; i < mLayoutPagingIndex.getChildCount(); i++) {
			ImageView imgView = (ImageView) mLayoutPagingIndex.getChildAt(position);
			imgView.setImageDrawable(null);
			if(i == position) {					
				imgView.setImageDrawable(getResources().getDrawable(R.drawable.ic_index_dot_selected));					
			} else {
				imgView.setImageDrawable(getResources().getDrawable(R.drawable.ic_index_dot));
			}				
		}					
	}
	
	private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int position) {
			updateIndex(position);
		}
		
		@Override
		public void onPageScrolled(int prePosition, float arg1, int nextPosition) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int state) {
			// TODO Auto-generated method stub
			
		}
	};
}
