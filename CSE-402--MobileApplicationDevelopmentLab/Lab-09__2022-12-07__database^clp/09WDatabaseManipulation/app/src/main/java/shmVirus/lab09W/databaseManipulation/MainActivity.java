package shmVirus.lab09W.databaseManipulation;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ename, eemail, emobile;
    Button binsert, bexit, bdisplay, bupdate, bdelete;
    String name, mail, mobile;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Database Manipulation");

        ename = findViewById(R.id.ename);
        eemail = findViewById(R.id.eemail);
        emobile = findViewById(R.id.emobile);
        binsert = findViewById(R.id.binsert);
        bdisplay = findViewById(R.id.bdisplay);
        bupdate = findViewById(R.id.bupdate);
        bdelete = findViewById(R.id.bdelete);
        bexit = findViewById(R.id.bexit);

        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(name VARCHAR unique, email VARCHAR, mobile VARCHAR);");

        binsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ename.getText().toString();
                mail = eemail.getText().toString();
                mobile = emobile.getText().toString();

                if (name.isEmpty() || mail.isEmpty() || mobile.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "TELL ME, how to INSERT Empty Values!", Toast.LENGTH_SHORT).show();
                } else {
                    Cursor cursor = db.rawQuery("SELECT COUNT (*) FROM " + "student" + " WHERE " + "name = ?", new String[]{name});
                    cursor.moveToFirst();
                    int count = cursor.getInt(0);
                    if (count <= 0) {
                        db.execSQL("INSERT INTO student VALUES('" + name + "','" + mail + "', '" + mobile + "');");
                        Toast.makeText(getApplicationContext(), "Record Inserted!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Record Exists!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        bupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ename.getText().toString();
                mail = eemail.getText().toString();
                mobile = emobile.getText().toString();

                if (name.isEmpty() || mail.isEmpty() || mobile.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "TELL ME, how to UPDATE Empty Values!", Toast.LENGTH_SHORT).show();
                } else {
                    Cursor cursor = db.rawQuery("SELECT COUNT (*) FROM " + "student" + " WHERE " + "name = ?", new String[]{name});
                    cursor.moveToFirst();
                    int count = cursor.getInt(0);
                    if (count <= 0) {
                        Toast.makeText(getApplicationContext(), "Record Not Found!", Toast.LENGTH_SHORT).show();
                    } else {
                        ContentValues cv = new ContentValues();
                        cv.put("email", mail);
                        cv.put("mobile", mobile);
                        db.update("student", cv, "name = ?", new String[]{name});
                        Toast.makeText(getApplicationContext(), "Record Updated!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ename.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "TELL ME, how to DELETE Empty Values!", Toast.LENGTH_SHORT).show();
                } else {
                    Cursor cursor = db.rawQuery("SELECT COUNT (*) FROM " + "student" + " WHERE " + "name = ?", new String[]{name});
                    cursor.moveToFirst();
                    int count = cursor.getInt(0);
                    if (count <= 0) {
                        Toast.makeText(getApplicationContext(), "Record Not Found!", Toast.LENGTH_SHORT).show();
                    } else {
                        db.delete("student", "name = ?", new String[]{name});
                        Toast.makeText(getApplicationContext(), "Record Deleted!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        bdisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.rawQuery("SELECT COUNT (*) FROM " + "student", null);
                cursor.moveToFirst();
                int count = cursor.getInt(0);
                if (count <= 0) {
                    Toast.makeText(getApplicationContext(), "Nothing to Display!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), Preview.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        bexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("DROP TABLE IF EXISTS student");
                System.exit(0);
            }
        });
    }
}