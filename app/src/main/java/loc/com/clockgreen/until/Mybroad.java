package loc.com.clockgreen.until;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import loc.com.clockgreen.MainActivity;

/**
 * Created by loc on 22/08/2015.
 */

public class Mybroad extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//         khởi tạo một chuooit string action
        String action = intent.getAction();
        // có thể là goi sự kiên screen clock
        //sự kienj screen tắt hoajcwr sư kienj   khởi động lài mại mấy  chuueen intent thựu đâu đến main activity
        
        if (action.equals(Intent.ACTION_SCREEN_OFF) || action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
