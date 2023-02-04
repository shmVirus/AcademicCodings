package shmVirus.labFinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegistrationMain extends AppCompatActivity {
    EditText eUserName, ePassWord, eMobile;
    Button rbRegister, rbLogin;
    String sUserName, sPassWord, sMobile;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_main);
        setTitle("Registration");

        eUserName = findViewById(R.id.eUserName);
        ePassWord = findViewById(R.id.ePassWord);
        eMobile = findViewById(R.id.eMobile);
        rbRegister = findViewById(R.id.rbRegister);
        rbLogin = findViewById(R.id.rbLogin);

        db = openOrCreateDatabase("MyUsers", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users(dUserName VARCHAR unique, dPassWord VARCHAR,  dMobile VARCHAR);");

        rbRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sUserName = eUserName.getText().toString();
                sPassWord = ePassWord.getText().toString();
                sMobile = eMobile.getText().toString();

                if (sUserName.isEmpty() || sPassWord.isEmpty() || sMobile.isEmpty()) {
                    Toast.makeText(ActivityRegistrationMain.this, "Can't REGISTER with Empty Values!", Toast.LENGTH_SHORT).show();
                } else {
                    if (!Patterns.EMAIL_ADDRESS.matcher(sUserName).matches()) {
                        eUserName.setError("Enter a Valid UserName!");
                    } else if (!(sPassWord.length() >= 5)) {
                        ePassWord.setError("Password should be equal or more than 5 Characters!");
                    } else if (!sMobile.matches("01[0-9]{9}$")) {
                        eMobile.setError("Enter Valid Bangladeshi Mobile Number!");
                    } else {
                        cursor = db.rawQuery("SELECT COUNT (*) FROM " + "users" + " WHERE " + "dUserName = ?", new String[]{sUserName});
                        cursor.moveToFirst();
                        if (cursor.getInt(0) <= 0) {
                            db.execSQL("INSERT INTO users VALUES('" + sUserName + "','" + sPassWord + "', '" + sMobile + "');");
                            Toast.makeText(ActivityRegistrationMain.this, "Registered!\nclick Log In button for Login!", Toast.LENGTH_SHORT).show();
                            eUserName.getText().clear();
                            ePassWord.getText().clear();
                            eMobile.getText().clear();
                        } else {
                            Toast.makeText(ActivityRegistrationMain.this, "Can't Register, User Exists!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        rbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityRegistrationMain.this, ActivityLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }
}