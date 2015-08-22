package loc.com.clockgreen.until;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by loc on 22/08/2015.
 */
public class Sevicer extends Service {
    // gọi broadcast
    BroadcastReceiver receiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onCreate() {

        // hay csi mày liên quang đến sưj kienje khóa màng hình
        KeyguardManager.KeyguardLock key;
        KeyguardManager km = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
        // vô hieeuuj hóa màng hình khóa trong bản
        key = km.newKeyguardLock("IN");
        key.disableKeyguard();

        //Start listening for the Screen On, Screen Off, and Boot completed actions
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_BOOT_COMPLETED);

        //Set up a receiver to listen for the Intents in this Service
        receiver = new Mybroad();
        registerReceiver(receiver, filter);
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }
}
