package shmVirus.lab09P.database;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ename, ecollege;
    Button binsert, bexit, bdisplay;
    String nam, coll;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Database Manipulation");

        ename = findViewById(R.id.ename);
        ecollege = findViewById(R.id.ecollege);
        binsert = findViewById(R.id.binsert);
        bdisplay = findViewById(R.id.bdisplay);
        bexit = findViewById(R.id.bexit);
        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(name VARCHAR,college VARCHAR);");

        binsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nam = ename.getText().toString();
                coll = ecollege.getText().toString();
                db.execSQL("INSERT INTO student VALUES('" + nam + "','" + coll + "');");
                Toast.makeText(getApplicationContext(), "Row Inserted", Toast.
                        LENGTH_SHORT).show();
            }
        });

        bdisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PreviewActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("DROP TABLE IF EXISTS student;");
                System.exit(0);
            }
        });
    }
}