package lucagessi.cicaboat;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.webkit.WebView;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.BinaryMessenger;

public class MyPhoneStateListener extends PhoneStateListener {

    public static Boolean phoneRinging = false;
    private static final String TAG = "MyPhoneStateListener";
    private EventChannel channel;
    private EventChannel.EventSink emitter;

    public MyPhoneStateListener(BinaryMessenger binaryMessager){
        super();
        // Prepare channel. Assume only one listener!
        channel = new EventChannel(binaryMessager, "events");
        channel.setStreamHandler(new EventChannel.StreamHandler() {
            @Override
            public void onListen(Object listener, EventChannel.EventSink eventSink) {
                emitter = eventSink;
                Log.i(TAG, "New listener!");
            }
            @Override
            public void onCancel(Object listener) {
                emitter = null;
                Log.i(TAG, "listener has gone!");
            }
        }); 
    }

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
        if(emitter != null){
            emitter.success(phoneRinging);
            Log.i(TAG, "emitter is NOT null!");
        }else{
            Log.i(TAG, "emitter is null!");
        }
    }
}