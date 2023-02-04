package shmVirus.labFinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {
    EditText eUserName, ePassWord;
    Button lbSignIn, lbBack;
    String sUserName, sPassWord;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        lbSignIn = findViewById(R.id.lbSignIn);
        lbBack = findViewById(R.id.lbBack);
        db = openOrCreateDatabase("MyUsers", MODE_PRIVATE, null);

        lbSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eUserName = findViewById(R.id.elUserName);
                ePassWord = findViewById(R.id.elPassWord);

                cursor = db.rawQuery("SELECT COUNT (*) FROM " + "users", null);
                cursor.moveToFirst();
                if (cursor.getInt(0) <= 0) {
                    Toast.makeText(ActivityLogin.this, "No Users!\nRegister to become First User!", Toast.LENGTH_SHORT).show();
                } else {
                    sUserName = eUserName.getText().toString();
                    sPassWord = ePassWord.getText().toString();
                    if (sUserName.isEmpty() || sPassWord.isEmpty()) {
                        Toast.makeText(ActivityLogin.this, "Provide Credentials to Login!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!Patterns.EMAIL_ADDRESS.matcher(sUserName).matches()) {
                            eUserName.setError("Enter a Valid UserName!");
                        } else if (!(sPassWord.length() >= 5)) {
                            ePassWord.setError("Password should be equal or more than 5 Characters!");
                        } else {
                            cursor = db.rawQuery("SELECT COUNT (*) FROM " + "users" + " WHERE " + "dUserName = ?", new String[]{sUserName});
                            cursor.moveToFirst();
                            if (cursor.getInt(0) > 0) {
                                cursor = db.rawQuery("SELECT  COUNT (*) FROM " + "users" + " WHERE " + "dUserName = ? AND dPassWord = ?", new String[]{sUserName, sPassWord});
                                cursor.moveToFirst();
                                if (cursor.getInt(0) > 0) {
                                    Intent intent = new Intent(ActivityLogin.this, ActivityHome.class);
                                    intent.putExtra("username", sUserName);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(ActivityLogin.this, "Incorrect Credentials!", Toast.LENGTH_SHORT).show();
                                    LinearLayout loginPageBackground = findViewById(R.id.loginPage);
                                    loginPageBackground.setBackgroundColor(Color.argb(255, 255, 0, 0));
                                }
                            } else {
                                Toast.makeText(ActivityLogin.this, "User doesn't Exists!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
        lbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivityRegistrationMain.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
}