package shmVirus.lab09W.databaseManipulation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Preview extends AppCompatActivity {
    TextView tname, temail, tmobile;
    Button bprev, bnext, bback;
    SQLiteDatabase db;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        setTitle("Database Preview");


        tname = findViewById(R.id.tname);
        temail = findViewById(R.id.temail);
        tmobile = findViewById(R.id.tmobile);
        bprev = findViewById(R.id.bprev);
        bnext = findViewById(R.id.bnext);
        bback = findViewById(R.id.bback);

        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        final Cursor c = db.rawQuery("select * from student", null);
        c.moveToFirst();
        tname.setText(c.getString(c.getColumnIndex("name")));
        temail.setText(c.getString(c.getColumnIndex("email")));
        tmobile.setText(c.getString(c.getColumnIndex("mobile")));

        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    c.moveToNext();
                    tname.setText(c.getString(c.getColumnIndex("name")));
                    temail.setText(c.getString(c.getColumnIndex("email")));
                    tmobile.setText(c.getString(c.getColumnIndex("mobile")));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Nothing Next!", Toast
                            .LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
        bprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    c.moveToPrevious();
                    tname.setText(c.getString(c.getColumnIndex("name")));
                    temail.setText(c.getString(c.getColumnIndex("email")));
                    tmobile.setText(c.getString(c.getColumnIndex("mobile")));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Nothing Previous!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}