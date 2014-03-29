package com.wog.intellcall.fragments;

import com.wog.intellcall.HomeActivity;
import com.wog.intellcall.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ConfirmInfoFragment extends Fragment {
	Button mBtnStart;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View convertedView = inflater.inflate(R.layout.fragment_confirm_info, null);
		
		mBtnStart = (Button) convertedView.findViewById(R.id.btnStart);
		mBtnStart.setOnClickListener(startListener);
		
		return convertedView;
	}
	
	private View.OnClickListener startListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getActivity(), HomeActivity.class);
			startActivity(intent);
			
			getActivity().finish();
		}
	};
}
