package com.example.cicaboat;

import android.os.Bundle;
import android.util.Log;
import io.flutter.embedding.android.FlutterActivity;
import android.content.Context;

//import android.telephony.TelephonyManager;
//import android.telephony.TelephonyCallback;
import android.content.Context;
import android.telephony.PhoneStateListener;
import java.util.concurrent.Executor;
//import com.example.cicaboat.ServiceReceiver;
import android.content.Intent;

public class MainActivity extends FlutterActivity {

    private static final String TAG = "FlutterActivity";
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState); 
        Log.w(TAG,"Activity created");
        //phoneStateListener = new CustomPhoneStateListener();
        startService(new Intent(this, ServiceReceiver.class));
    }    
}
