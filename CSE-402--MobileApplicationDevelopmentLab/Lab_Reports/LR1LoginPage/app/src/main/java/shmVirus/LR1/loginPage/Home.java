package shmVirus.LR1.loginPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    Button logoutButton, updateButton;
    private TextView nameProfile, emailProfile, passwordProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle(getString(R.string.homePageTitle));
        nameProfile = findViewById(R.id.nameProfile);
        emailProfile = findViewById(R.id.emailProfile);
        passwordProfile = findViewById(R.id.passwordProfile);
        logoutButton = findViewById(R.id.logoutButton);
        updateButton = findViewById(R.id.updateButton);
        logoutButton.setAllCaps(false);
        updateButton.setAllCaps(false);

        Bundle Extra = getIntent().getExtras();
        String textN = Extra.getString("name");
        String textE = Extra.getString("email");
        String textP = Extra.getString("password");
        nameProfile.setText(getString(R.string.nameTextView) + textN);
        emailProfile.setText(getString(R.string.emailTextView) + textE);
        passwordProfile.setText(getString(R.string.passwordTextView) + textP);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainLogin.class);
                startActivity(intent);
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Update.class);
                startActivity(intent);
            }
        });
    }
}