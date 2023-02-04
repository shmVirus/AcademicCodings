package shmVirus.LR3.databaseManipulation;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
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
import java.util.Objects;

public class DatabaseManipulation extends AppCompatActivity {
    EditText ename, eemail, emobile, epass;
    Button bupdate, bhome, bback, bexit, bclear;
    String loggedUserName, name, mail, mobile, pass, rex;
    SQLiteDatabase db;
    Cursor cursor;
    BroadcastReceiver receiver;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_manipulation);
        setTitle("Data Manipulation");
        ename = findViewById(R.id.ename);
        eemail = findViewById(R.id.eemail);
        emobile = findViewById(R.id.emobile);
        epass = findViewById(R.id.epass);
        bupdate = findViewById(R.id.bupdate);
        bhome = findViewById(R.id.bhome);
        bback = findViewById(R.id.bback);
        bexit = findViewById(R.id.bexit);
        bclear = findViewById(R.id.bclear);

        Bundle Extra = getIntent().getExtras();
        loggedUserName = Extra.getString("name");
        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        bupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursor = db.rawQuery("SELECT * FROM student", null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    while (!Objects.equals(cursor.getString(cursor.getColumnIndex("name")), loggedUserName)) {
                        cursor.moveToNext();
                    }
                }
                name = ename.getText().toString();
                mail = eemail.getText().toString();
                mobile = emobile.getText().toString();
                pass = epass.getText().toString();

                boolean vName = false, vEmail = false, vMobile = false, vPass = false;
                if (name.isEmpty()) {
                    name = cursor.getString(cursor.getColumnIndex("name"));
                    vName = true;
                } else if (!name.matches("[a-zA-Z]+"))
                    ename.setError("Name can only contain letters!");
                else vName = true;
                if (mail.isEmpty()) {
                    mail = cursor.getString(cursor.getColumnIndex("email"));
                    vEmail = true;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
                    eemail.setError("Enter a Valid Email!");
                else vEmail = true;
                if (mobile.isEmpty()) {
                    mobile = cursor.getString(cursor.getColumnIndex("mobile"));
                    vMobile = true;
                } else if (!mobile.matches("01[0-9]{9}$"))
                    emobile.setError("Enter Valid Bangladeshi Mobile Number!");
                else vMobile = true;
                if (pass.isEmpty()) {
                    pass = cursor.getString(cursor.getColumnIndex("pass"));
                    vPass = true;
                } else if (!(pass.length() >= 5))
                    epass.setError("Passwords should have equal or more than 5 Characters!");
                else vPass = true;
                if (vName && vEmail && vMobile && vPass) {
                    cursor = db.rawQuery("SELECT * FROM " + "student" + " WHERE " + "name = ?", new String[]{name});
                    if (cursor.getCount() > 0) cursor.moveToFirst();
                    if ((cursor.getCount() <= 0) || (cursor.getCount() > 0 && loggedUserName.equals(cursor.getString(cursor.getColumnIndex("name"))))) {
                        ContentValues cv = new ContentValues();
                        cv.put("name", name);
                        cv.put("email", mail);
                        cv.put("mobile", mobile);
                        cv.put("pass", pass);
                        db.update("student", cv, "name = ?", new String[]{loggedUserName});
                        loggedUserName = name;
                        Toast.makeText(getApplicationContext(), "Record UPDATED!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Record EXISTS!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        bhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
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
                Intent intent = new Intent(getApplicationContext(), Preview.class);
                intent.putExtra("name", loggedUserName);
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
        receiver = new BatteryChangesReceiver();
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }
}