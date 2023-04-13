package shmVirus.lab08P.alarmClock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eTime;
    Button bClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Broadcasts");
        eTime = findViewById(R.id.eTime);
        bClick = findViewById(R.id.bClick);

        bClick.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.S)
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(eTime.getText().toString());
                Intent intent = new Intent(getApplicationContext(), Alarm.class);
                // changed last parameter "0" to "PendingIntent.FLAG_MUTABLE", to avoid crash on API 31+
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                        800000, intent, PendingIntent.FLAG_IMMUTABLE);
                //800000, intent, PendingIntent.FLAG_IMMUTABLE);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis() + (i * 1000L), pendingIntent);
                Toast.makeText(getApplicationContext(), "Alarm set after " + i + " seconds.",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}