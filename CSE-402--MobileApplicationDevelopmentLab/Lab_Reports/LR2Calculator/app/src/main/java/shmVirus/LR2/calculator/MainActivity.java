package shmVirus.LR2.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSub, buttonDiv, buttonMDiv, buttonMul, buttonPoint, buttonReset, buttonEqual, buttonLog;
    EditText eT;
    float ValueOne, ValueTwo, result;
    boolean Addition, Subtract, Multiplication, Division, ModuloDivision, Log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Calculator");

        button0 = findViewById(R.id.buttonZero);
        button1 = findViewById(R.id.buttonOne);
        button2 = findViewById(R.id.buttonTwo);
        button3 = findViewById(R.id.buttonThree);
        button4 = findViewById(R.id.buttonFour);
        button5 = findViewById(R.id.buttonFive);
        button6 = findViewById(R.id.buttonSix);
        button7 = findViewById(R.id.buttonSeven);
        button8 = findViewById(R.id.buttonEight);
        button9 = findViewById(R.id.buttonNine);
        buttonPoint = findViewById(R.id.buttonPoint);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonMDiv = findViewById(R.id.buttonMDiv);
        buttonReset = findViewById(R.id.buttonReset);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonLog = findViewById(R.id.buttonLog);
        eT = findViewById(R.id.eT);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT.setText(eT.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT.setText(eT.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT.setText(eT.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT.setText(eT.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT.setText(eT.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT.setText(eT.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT.setText(eT.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT.setText(eT.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT.setText(eT.getText() + "9");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT.setText(eT.getText() + "0");
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT.setText("");
            }
        });
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!eT.getText().toString().contains(".")) {
                    eT.setText(eT.getText() + ".");
                }
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //convert string to float and set UI Null to get next input
                if (!eT.getText().toString().isEmpty()) {
                    ValueOne = Float.parseFloat(eT.getText().toString());
                    Addition = true;
                    eT.setText(null);
                }
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!eT.getText().toString().isEmpty()) {
                    ValueOne = Float.parseFloat(eT.getText().toString());
                    Subtract = true;
                    eT.setText(null);
                }
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!eT.getText().toString().isEmpty()) {
                    ValueOne = Float.parseFloat(eT.getText().toString());
                    Multiplication = true;
                    eT.setText(null);
                }
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!eT.getText().toString().isEmpty()) {
                    ValueOne = Float.parseFloat(eT.getText().toString());
                    Division = true;
                    eT.setText(null);
                }
            }
        });
        buttonMDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!eT.getText().toString().isEmpty()) {
                    ValueOne = Float.parseFloat(eT.getText().toString());
                    ModuloDivision = true;
                    eT.setText(null);
                }
            }
        });
        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!eT.getText().toString().isEmpty()) {
                    ValueOne = Float.parseFloat(eT.getText().toString());
                    eT.setText(eT.getText() + " ");
                } else {
                    ValueOne = 1;
                }
                Log = true;
                eT.setText(eT.getText() + "log ");
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = eT.getText().toString();
                if (!string.equals(".")) {
                    if (!string.isEmpty()) {
                        //string = string.replaceAll("[^0-9]+[^.][^0-9]+", "");

                        ValueTwo = Float.parseFloat(string.substring(string.lastIndexOf("g ") + 1));
                    } else {
                        ValueTwo = 0;
                    }
                    if (ValueTwo != 0) {
                        if (Addition) {
                            result = ValueOne + ValueTwo;
                            Addition = false;
                        } else if (Subtract) {
                            result = ValueOne - ValueTwo;
                            Subtract = false;
                        } else if (Multiplication) {
                            result = ValueOne * ValueTwo;
                            Multiplication = false;
                        } else if (Division) {
                            result = ValueOne / ValueTwo;
                            Division = false;
                        }
                        eT.setText(String.valueOf(result));
                    }
                    if (ModuloDivision) {
                        if (ValueTwo == 0) ValueTwo = 1;
                        //result = ValueOne % ValueTwo;

                        result = ValueOne * ValueTwo / 100;
                        eT.setText(String.valueOf(result));
                        ModuloDivision = false;
                    } else if (Log && ValueTwo != 0) {
                        result = (float) (ValueOne * (Math.log10(ValueTwo)));
                        eT.setText(String.valueOf(result));
                        Log = false;
                    }
                }
            }
        });
    }
}