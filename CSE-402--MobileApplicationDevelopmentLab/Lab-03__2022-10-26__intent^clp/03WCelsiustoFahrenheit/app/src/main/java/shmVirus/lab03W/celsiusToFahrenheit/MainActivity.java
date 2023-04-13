package shmVirus.lab03W.celsiusToFahrenheit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, email, password, passwordConfirm;
    Button loginButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Login Page");

        //Referencing
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        passwordConfirm = (EditText) findViewById(R.id.passwordConfirm);
        loginButton = (Button) findViewById(R.id.loginButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Login Button Selected",
                        Toast.LENGTH_LONG).show();
                String textN = name.getText().toString();
                String textP = password.getText().toString();
                //if((textN.equals("shmVirus")) && (textP.equals("coolSabbir"))){
                Intent intent = new Intent(getApplicationContext(), CelsiusToFahrenheit.class);
                startActivity(intent);
                //}
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Under Construction",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}