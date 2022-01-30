package com.cicaboat;

import android.os.Bundle;
import android.util.Log;
import io.flutter.embedding.android.FlutterActivity;
import android.content.Context;
import android.content.Context;
import android.telephony.PhoneStateListener;
import java.util.concurrent.Executor;
import android.content.Intent;

public class MainActivity extends FlutterActivity {

    private static final String TAG = "FlutterActivity";
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState); 
        Log.w(TAG,"Activity created");
        startService(new Intent(this, com.cicaboat.ServiceReceiver.class));
    }    
}
