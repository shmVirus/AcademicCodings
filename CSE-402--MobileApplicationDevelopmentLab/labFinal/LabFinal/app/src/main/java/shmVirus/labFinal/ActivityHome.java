package shmVirus.labFinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityHome extends AppCompatActivity {
    TextView htUserName, htMobile;
    Button hbLogOut;
    String sUserName;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Home");

        htUserName = findViewById(R.id.htUserName);
        htMobile = findViewById(R.id.htMobile);
        hbLogOut = findViewById(R.id.hbLogOut);

        Bundle Extra = getIntent().getExtras();
        sUserName = Extra.getString("username");
        db = openOrCreateDatabase("MyUsers", MODE_PRIVATE, null);

        cursor = db.rawQuery("SELECT * FROM " + "users" + " WHERE " + "dUserName = ?", new String[]{sUserName});
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            @SuppressLint("Range") String sMobile = cursor.getString(cursor.getColumnIndex("dMobile"));
            htUserName.setText("Welcome X");
            htMobile.setText(sMobile);
        }
        hbLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHome.this, ActivityRegistrationMain.class);
                startActivity(intent);
                finish();
            }
        });
    }
}