package shmVirus.LR3.databaseManipulation;

import static java.lang.Thread.sleep;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Objects;

public class Preview extends AppCompatActivity {
    TextView tname, temail, tmobile, tpass;
    Button bprev, bnext, bback, bexit, bupdate, bdelete;
    SQLiteDatabase db;
    String name, mail, mobile, pass;
    Cursor cursor;
    BroadcastReceiver receiver;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        setTitle("Data Preview");
        tname = findViewById(R.id.tname);
        temail = findViewById(R.id.temail);
        tmobile = findViewById(R.id.tmobile);
        tpass = findViewById(R.id.tpass);
        bprev = findViewById(R.id.bprev);
        bnext = findViewById(R.id.bnext);
        bback = findViewById(R.id.bback);
        bexit = findViewById(R.id.bexit);
        bupdate = findViewById(R.id.bupdate);
        bdelete = findViewById(R.id.bdelete);

        Bundle Extra = getIntent().getExtras();
        String loggedUserName = Extra.getString("name");
        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        cursor = db.rawQuery("SELECT * FROM student", null);
        cursor.moveToFirst();
        if (cursor != null && cursor.getCount() > 0 && loggedUserName != null) {
            cursor.moveToFirst();
            while (!Objects.equals(cursor.getString(cursor.getColumnIndex("name")), loggedUserName)) {
                cursor.moveToNext();
            }
            name = cursor.getString(cursor.getColumnIndex("name"));
            mail = cursor.getString(cursor.getColumnIndex("email"));
            mobile = cursor.getString(cursor.getColumnIndex("mobile"));
            pass = cursor.getString(cursor.getColumnIndex("pass"));
            tname.setText(name);
            temail.setText(mail);
            tmobile.setText(mobile);
            tpass.setText(pass);
        }

        bupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Lending to YOUR INFO UPDATE Page!", Toast.LENGTH_SHORT).show();
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(getApplicationContext(), DatabaseManipulation.class);
                intent.putExtra("name", name);
                startActivity(intent);
                finish();
            }
        });
        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete("student", "name = ?", new String[]{name});
                Toast.makeText(getApplicationContext(), "Record DELETED!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cursor.moveToNext();
                    tname.setText(cursor.getString(cursor.getColumnIndex("name")));
                    temail.setText(cursor.getString(cursor.getColumnIndex("email")));
                    tmobile.setText(cursor.getString(cursor.getColumnIndex("mobile")));
                    if (cursor.getString(cursor.getColumnIndex("name")).equals(loggedUserName)) {
                        tpass.setText(cursor.getString(cursor.getColumnIndex("pass")));
                    } else {
                        tpass.setText("Not Allowed to See Someone Else's Password!");
                    }
                } catch (Exception e) {
                    cursor.moveToPrevious();
                    Toast.makeText(getApplicationContext(), "Nothing Next!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
        bprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cursor.moveToPrevious();
                    tname.setText(cursor.getString(cursor.getColumnIndex("name")));
                    temail.setText(cursor.getString(cursor.getColumnIndex("email")));
                    tmobile.setText(cursor.getString(cursor.getColumnIndex("mobile")));
                    if (cursor.getString(cursor.getColumnIndex("name")).equals(loggedUserName)) {
                        tpass.setText(cursor.getString(cursor.getColumnIndex("pass")));
                    } else {
                        tpass.setText("Not Allowed to See Someone Else's Password!");
                    }
                } catch (Exception e) {
                    cursor.moveToNext();
                    Toast.makeText(getApplicationContext(), "Nothing Previous!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
        receiver = new BatteryChangesReceiver();
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }
}