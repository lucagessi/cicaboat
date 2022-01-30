package com.cicaboat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class ServiceReceiver extends BroadcastReceiver {
    TelephonyManager telephony;
    private static final String TAG = "ServiceReceiver";

    public void onReceive(Context context, Intent intent) {
        Log.i("TAG", "ServiceReceiver: onReceive");
        MyPhoneStateListener phoneListener = new com.cicaboat.MyPhoneStateListener();
        telephony = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        telephony.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
    }

    public void onDestroy() {
        telephony.listen(null, PhoneStateListener.LISTEN_NONE);
    }

}