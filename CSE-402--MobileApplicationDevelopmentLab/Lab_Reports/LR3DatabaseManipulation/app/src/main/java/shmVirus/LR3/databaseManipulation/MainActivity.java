package shmVirus.LR3.databaseManipulation;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ename, eemail, emobile, epass;
    Button binsert, bback, bexit, bdisplay, bclear;
    String name, mail, mobile, pass;
    SQLiteDatabase db;
    Cursor cursor;
    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Data Insertion");

        ename = findViewById(R.id.ename);
        eemail = findViewById(R.id.eemail);
        emobile = findViewById(R.id.emobile);
        epass = findViewById(R.id.epass);
        binsert = findViewById(R.id.binsert);
        bdisplay = findViewById(R.id.bdisplay);
        bback = findViewById(R.id.bback);
        bexit = findViewById(R.id.bexit);
        bclear = findViewById(R.id.bclear);

        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(name VARCHAR unique, email VARCHAR, mobile VARCHAR, pass VARCHAR);");
        binsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ename.getText().toString();
                mail = eemail.getText().toString();
                mobile = emobile.getText().toString();
                pass = epass.getText().toString();
                if (name.isEmpty() || mail.isEmpty() || mobile.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Can't INSERT Empty Records!", Toast.LENGTH_SHORT).show();
                } else {
                    if (!name.matches("[a-zA-Z]+")) {
                        ename.setError("Name can only contain letters!");
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                        eemail.setError("Enter a Valid Email!");
                    } else if (!mobile.matches("01[0-9]{9}$")) {
                        emobile.setError("Enter Valid Bangladeshi Mobile Number!");
                    } else if (!(pass.length() >= 5)) {
                        epass.setError("Passwords should have equal or more than 5 Characters!");
                    } else {
                        cursor = db.rawQuery("SELECT COUNT (*) FROM " + "student" + " WHERE " + "name = ?", new String[]{name});
                        cursor.moveToFirst();
                        if (cursor.getInt(0) <= 0) {
                            db.execSQL("INSERT INTO student VALUES('" + name + "','" + mail + "', '" + mobile + "', '" + pass + "');");
                            Toast.makeText(getApplicationContext(), "Record INSERTED!", Toast.LENGTH_SHORT).show();
                            ename.getText().clear();
                            eemail.getText().clear();
                            emobile.getText().clear();
                            epass.getText().clear();
                        } else {
                            Toast.makeText(getApplicationContext(), "Record EXISTS!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        bdisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursor = db.rawQuery("SELECT COUNT (*) FROM " + "student", null);
                cursor.moveToFirst();
                if (cursor.getInt(0) <= 0) {
                    Toast.makeText(getApplicationContext(), "Nothing to DISPLAY!", Toast.LENGTH_SHORT).show();
                } else {
                    name = ename.getText().toString();
                    pass = epass.getText().toString();
                    if (name.isEmpty() || pass.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Login Correctly to DISPLAY Records!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!name.matches("[a-zA-Z]+")) {
                            ename.setError("Name can only contain letters!");
                        } else if (!(pass.length() >= 5)) {
                            epass.setError("Passwords should have equal or more than 5 Characters!");
                        } else {
                            cursor = db.rawQuery("SELECT COUNT (*) FROM " + "student" + " WHERE " + "name = ?", new String[]{name});
                            cursor.moveToFirst();
                            if (cursor.getInt(0) > 0) {
                                cursor = db.rawQuery("SELECT COUNT (*) FROM " + "student" + " WHERE " + "name = ? AND pass = ?", new String[]{name, pass});
                                cursor.moveToFirst();
                                if (cursor.getInt(0) > 0) {
                                    Intent intent = new Intent(getApplicationContext(), Preview.class);
                                    intent.putExtra("name", name);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Incorrect Credentials!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Record Not Exists!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ename.getText().clear();
                eemail.getText().clear();
                emobile.getText().clear();
                epass.getText().clear();
                Toast.makeText(getApplicationContext(), "Cleared Fields!", Toast.LENGTH_LONG).show();
            }
        });
        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        bexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("DROP TABLE student");
                Toast.makeText(getApplicationContext(), "DROPPED DATA!", Toast.LENGTH_SHORT).show();
                System.exit(0);
            }
        });
        receiver = new BatteryChangesReceiver();
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        Intent intent = new Intent(getApplicationContext(), Receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 800000, intent, PendingIntent.FLAG_IMMUTABLE);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 60 * 1000L, pendingIntent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }
}