package shmVirus.lab03P.temperatureConverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class temperatureTransformationApplication extends AppCompatActivity {
    double result1;
    private Button cToF;
    private TextView result;
    private EditText enterTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_transformation_application);
        setTitle("Temperature Conversion");

        //referencing
        cToF = findViewById(R.id.cToF);
        result = findViewById(R.id.result);
        enterTemp = findViewById(R.id.enterTemp);

        cToF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //type converter decimal to double
                double temp = Double.parseDouble(enterTemp.getText().toString());
                //to change input from Celsius Scale to Fahrenheit Scale
                result1 = (temp * 1.8) + 32;
                //to show the result in Fahrenheit in UI
                result.setText(String.valueOf(result1));
            }
        });
    }
}