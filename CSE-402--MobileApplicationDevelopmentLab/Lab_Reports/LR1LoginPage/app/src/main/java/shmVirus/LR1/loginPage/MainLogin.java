package shmVirus.LR1.loginPage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MainLogin extends AppCompatActivity {
    EditText nameEditText, emailEditText, passwordEditText;
    Button loginButton, resetButton;
    ImageButton cancelButton;
    LinearLayout loginPageBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        getSupportActionBar().setTitle(getString(R.string.loginPageTitle));
        //Referencing
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        cancelButton = findViewById(R.id.cancelButton);
        resetButton = findViewById(R.id.resetButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textN = nameEditText.getText().toString();
                String textE = emailEditText.getText().toString();
                String textP = passwordEditText.getText().toString();
                if (!textN.isEmpty() && !textE.isEmpty() && !textP.isEmpty()) {
                    if (!textN.matches("[a-zA-Z]+")) {
                        nameEditText.setError("Name can only contain letters!");
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(textE).matches()) {
                        emailEditText.setError("Please enter a Valid Email!");
                    } else if ((textN.equals("a")) && (textP.equals("a"))) {
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        intent.putExtra("name", textN);
                        intent.putExtra("email", textE);
                        intent.putExtra("password", textP);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please Fill all Fields", Toast.LENGTH_LONG).show();
                }
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
                nameEditText.getText().clear();
                emailEditText.getText().clear();
                passwordEditText.getText().clear();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Background Reset", Toast.LENGTH_LONG).show();
                Random color = new Random();
                int r = color.nextInt(255);
                int g = color.nextInt(255);
                int b = color.nextInt(255);
                //int randomColor = Color.argb(255, r, g, b);
                loginPageBackground = findViewById(R.id.loginPage);
                //loginPageBackground.setBackgroundResource(randomColor);
                loginPageBackground.setBackgroundColor(Color.argb(255, r, g, b));
            }
        });
    }
}