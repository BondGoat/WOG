package com.wog.intellcall;

import com.wog.intellcall.utilities.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		init();
	}
	
	private void init() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(Constants.SPLASH_TIME);
					
					mSplashScreenHandler.sendEmptyMessage(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	private Handler mSplashScreenHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			Intent intent = new Intent(getApplicationContext(), SetupActivity.class);
			startActivity(intent);
			
			overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
			
			SplashActivity.this.finish();
		};
	};
}
