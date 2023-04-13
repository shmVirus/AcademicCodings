package shmVirus.LR1.loginPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    EditText nameEditText, emailEditText, passwordEditText;
    Button updateInfoButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        getSupportActionBar().setTitle(getString(R.string.updateInfoPageTitle));

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        updateInfoButton = findViewById(R.id.updateInfoButton);
        backButton = findViewById(R.id.backButton);

        updateInfoButton.setOnClickListener(new View.OnClickListener() {
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
                    } else {
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        intent.putExtra("name", textN);
                        intent.putExtra("email", textE);
                        intent.putExtra("password", textP);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Fields can't be Empty",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }
        });
    }
}