package shmVirus.lab02P.loginPage;

import static shmVirus.lab02P.loginPage.R.id;
import static shmVirus.lab02P.loginPage.R.layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView virusTextView;
    EditText eMail;
    EditText pass;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        setTitle("Login Page");
        eMail = findViewById(id.eMail);
        pass = findViewById(id.pass);
        loginButton = findViewById(id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Logged in Successfully!",Toast.LENGTH_LONG).show();
            }
        });
    }
}