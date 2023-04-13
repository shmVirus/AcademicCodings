package shmVirus.lab03W.celsiusToFahrenheit;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CelsiusToFahrenheit extends AppCompatActivity {
    double fahrenheit;
    private Button resultsButton, logoutButton;
    private TextView resultInFahrenheit;
    private EditText celsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celsius_to_fahrenheit);
        setTitle("Temperature Conversion");

        //referencing
        resultsButton = findViewById(R.id.resultsButton);
        resultInFahrenheit = findViewById(R.id.resultInFahrenheit);
        celsius = findViewById(R.id.celsius);
        logoutButton = findViewById(R.id.logoutButton);

        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //type converter decimal to double
                double temp = Double.parseDouble(celsius.getText().toString());
                if (!celsius.getText().toString().isEmpty()) {
                    //to change input from Celsius Scale to Fahrenheit Scale
                    fahrenheit = (temp * 1.8) + 32;
                    //to show the result in Fahrenheit in UI
                    resultInFahrenheit.setText(String.valueOf(fahrenheit));
                }
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Under Construction",
                        Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}