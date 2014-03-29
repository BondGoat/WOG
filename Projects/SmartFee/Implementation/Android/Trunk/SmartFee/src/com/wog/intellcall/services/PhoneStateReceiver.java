package com.wog.intellcall.services;

import com.wog.intellcall.utilities.Constants;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneStateReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Service.TELEPHONY_SERVICE);
		switch (telephonyManager.getCallState()) {
		case TelephonyManager.CALL_STATE_IDLE:
			
			break;
		case TelephonyManager.CALL_STATE_OFFHOOK:
			Log.v(Constants.APP_TAG, "AAAAAAAAA");
			break;
		case TelephonyManager.CALL_STATE_RINGING:
			Log.v(Constants.APP_TAG, telephonyManager.getLine1Number());
			break;
		default:
			break;
		}
	}

}
