package shmVirus.lab09W.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,
                "Broadcast Received Successfully!", Toast.LENGTH_LONG).show();
    }
}