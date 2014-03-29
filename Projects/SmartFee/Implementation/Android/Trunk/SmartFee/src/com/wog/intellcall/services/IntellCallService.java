package com.wog.intellcall.services;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class IntellCallService extends Service {

	Context mContext;
	Intent intentService;
	
	@Override
	public IBinder onBind(Intent intent) {
		intentService = intent;
		
		// Register to listen to Call State
		TelephonyManager telephonyManager = (TelephonyManager) mContext.getSystemService(TELEPHONY_SERVICE);
        telephonyManager.listen(new PhoneListener(), PhoneStateListener.LISTEN_CALL_STATE);
		
        // Register to listen to SMS state
        ContentResolver contentResolver = mContext.getContentResolver();
        contentResolver.registerContentObserver(Uri.parse("content://sms/out"),true, new SmsObserver(null));
        
		return null;
	}
	
	public IntellCallService(Context context) {
		mContext = context;
	}
	
	private class PhoneListener extends PhoneStateListener {
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:
				
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				
				break;
			case TelephonyManager.CALL_STATE_RINGING:
	
				break;
			default:
				break;
			}
		}
	}
	
	private class SmsObserver extends ContentObserver {

		public SmsObserver(Handler handler) {
			super(handler);
		}
		
		@Override
		public void onChange(boolean selfChange) {
			super.onChange(selfChange);
		}
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		startService(intentService);
	}
}
