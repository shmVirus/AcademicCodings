// Code for Intent to switch from login activity to a new activity
package shmVirus.lab03P.temperatureConverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ET1, ET2;
    Button B1, B2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login Page");

        //Referencing
        ET1 = findViewById(R.id.etName);
        ET2 = findViewById(R.id.etPass);
        B1 = findViewById(R.id.btnOk);
        B2 = findViewById(R.id.btnReset);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Login Button Selected.",
                        Toast.LENGTH_LONG).show();
                String textN = ET1.getText().toString();
                String textP = ET2.getText().toString();
                if ((textN.equals("shmVirus")) && (textP.equals("coolSabbir"))) {
                    Intent intent = new Intent(getApplicationContext(),
                            temperatureTransformationApplication.class);
                    startActivity(intent);
                }
            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Reset Button Selected.",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}