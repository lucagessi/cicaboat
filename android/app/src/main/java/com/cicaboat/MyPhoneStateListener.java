package com.cicaboat;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.webkit.WebView;

public class MyPhoneStateListener extends PhoneStateListener {

    public static Boolean phoneRinging = false;
    private static final String TAG = "MyPhoneStateListener";

    public void onCallStateChanged(int state, String incomingNumber) {
        Log.i(TAG, "onCallStateChanged");
        switch (state) {
        case TelephonyManager.CALL_STATE_IDLE:
            Log.i(TAG, "IDLE");
            phoneRinging = false;
            break;
        case TelephonyManager.CALL_STATE_OFFHOOK:
            Log.i(TAG, "OFFHOOK");
            phoneRinging = false;
            break;
        case TelephonyManager.CALL_STATE_RINGING:
            Log.i(TAG, "RINGING");
            phoneRinging = true;
            break;
        }
    }

}