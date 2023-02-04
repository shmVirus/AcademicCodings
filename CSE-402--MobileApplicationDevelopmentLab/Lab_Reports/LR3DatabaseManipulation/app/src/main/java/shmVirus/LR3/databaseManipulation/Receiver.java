package shmVirus.LR3.databaseManipulation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
    static int i = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "hurry up, " + ++i + " minutes passed!", Toast.LENGTH_LONG).show();
    }
}