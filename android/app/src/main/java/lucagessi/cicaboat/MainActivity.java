package lucagessi.cicaboat;

import android.os.Bundle;
import android.util.Log;
import io.flutter.embedding.android.FlutterActivity;
import android.content.Context;
import android.content.Context;
import android.telephony.PhoneStateListener;
import java.util.concurrent.Executor;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.telephony.TelephonyManager;
import io.flutter.plugin.common.BinaryMessenger;

public class MainActivity extends FlutterActivity {

    private static final String TAG = "FlutterActivity";
    static private BinaryMessenger binaryMessager;
    static private MyPhoneStateListener phoneListener;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState); 
        binaryMessager = getFlutterEngine().getDartExecutor().getBinaryMessenger();
        phoneListener = new MyPhoneStateListener(binaryMessager);
        Log.w(TAG,"Activity created. Is Null = "+(binaryMessager == null));
        //startService(new Intent(this, ServiceReceiver.class));
    }

    public static class ServiceReceiver extends BroadcastReceiver {
        TelephonyManager telephony;
        private static final String TAG = "ServiceReceiver";

        public void onReceive(Context context, Intent intent) {
            Log.i("TAG", "ServiceReceiver: onReceive");
            telephony = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            telephony.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
        }

        public void onDestroy() {
            telephony.listen(null, PhoneStateListener.LISTEN_NONE);
        }

    }

}
