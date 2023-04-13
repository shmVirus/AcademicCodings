package shmVirus.LR3.databaseManipulation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

class BatteryChangesReceiver extends BroadcastReceiver {
    static int previousLevel, t = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        int currentLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) * 100 / intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        if (t++ == 0) {
            previousLevel = currentLevel;
        } else if (currentLevel > previousLevel) {
            previousLevel = currentLevel;
            Toast.makeText(context, "battery born", Toast.LENGTH_LONG).show();
        } else if (currentLevel < previousLevel) {
            previousLevel = currentLevel;
            Toast.makeText(context, "battery died", Toast.LENGTH_LONG).show();
        }
    }
}