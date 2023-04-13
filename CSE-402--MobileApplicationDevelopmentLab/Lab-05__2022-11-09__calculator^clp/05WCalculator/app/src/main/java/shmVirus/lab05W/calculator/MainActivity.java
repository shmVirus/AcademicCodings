package shmVirus.lab05W.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDiv, buttonMDiv,
            buttonMul, buttonPoint, buttonReset, buttonEqual;
    EditText eT;
    float ValueOne, ValueTwo, result;
    boolean Addition, Subtract, Multiplication, Division, ModuloDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Calculator");

        //Referencing
        button0 = (Button) findViewById(R.id.buttonZero);
        button1 = (Button) findViewById(R.id.buttonOne);
        button2 = (Button) findViewById(R.id.buttonTwo);
        button3 = (Button) findViewById(R.id.buttonThree);
        button4 = (Button) findViewById(R.id.buttonFour);
        button5 = (Button) findViewById(R.id.buttonFive);
        button6 = (Button) findViewById(R.id.buttonSix);
        button7 = (Button) findViewById(R.id.buttonSeven);
        button8 = (Button) findViewById(R.id.buttonEight);
        button9 = (Button) findViewById(R.id.buttonNine);
        buttonPoint = (Button) findViewById(R.id.buttonPoint);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonMDiv = (Button) findViewById(R.id.buttonMDiv);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        eT = (EditText) findViewById(R.id.eT);


        //Event Listeners
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to set the editText with the button value 1
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
                if (!eT.getText().toString().contentEquals(".")) {
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
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = eT.getText().toString();
                if (!string.equals(".")) {
                    //to get the second input and convert that into float
                    if (!string.isEmpty()) {
                        ValueTwo = Float.parseFloat(string);
                    } else {
                        ValueTwo = 0;
                    }
                    if (ValueTwo != 0) {
                        if (Addition) {
                            result = ValueOne + ValueTwo;
                            eT.setText(String.valueOf(result));
                            Addition = false;
                        } else if (Subtract) {
                            result = ValueOne - ValueTwo;
                            eT.setText(String.valueOf(result));
                            Subtract = false;
                        } else if (Multiplication) {
                            result = ValueOne * ValueTwo;
                            eT.setText(String.valueOf(result));
                            Multiplication = false;
                        } else if (Division) {
                            result = ValueOne / ValueTwo;
                            eT.setText(String.valueOf(result));
                            Division = false;
                        }
                    }
                    if (ModuloDivision) {
                        ValueOne = (int) ValueOne;
                        ValueTwo = (int) ValueTwo;
                        if (ValueTwo == 0) {
                            result = (float) ValueOne / 100;
                            eT.setText(String.valueOf(result));
                        } else {
                            //result = ValueOne % ValueTwo;
                            result = ValueOne * ValueTwo / 100;
                            eT.setText(String.valueOf((int) result));
                        }
                        ModuloDivision = false;
                    }
                }
            }
        });
    }
}