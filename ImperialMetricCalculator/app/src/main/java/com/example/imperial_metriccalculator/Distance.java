package com.example.imperial_metriccalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Distance extends Fragment {

    private boolean isMiToKilo = true;
    private double calculationValue = 0.0;
    private EditText userInput;
    private TextView inputDistUnit;
    private TextView resultDistUnit;
    private TextView resultText;
    private Button calculateButton;
    private Button switchModeButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_distance, container, false);

        //find references
        userInput = (EditText) view.findViewById(R.id.temperatureInput);
        inputDistUnit = (TextView) view.findViewById(R.id.tempConversionText);
        resultDistUnit = (TextView) view.findViewById(R.id.tempConversionResult);
        resultText = (TextView) view.findViewById(R.id.resultText);
        calculateButton = (Button) view.findViewById(R.id.calcButton);
        switchModeButton = (Button) view.findViewById(R.id.switchModeButton);

        //function for calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMiToKilo) {
                    //pull from user input
                    if (userInput.getText().toString().matches("")) { //user input is empty
                        calculationValue = 0;
                        userInput.setText("0");
                    } else {
                        calculationValue = Double.parseDouble(userInput.getText().toString());
                    }

                    //calculate new value
                    calculationValue *= 1.60934;

                    //display result
                    resultText.setText(Double.toString(calculationValue));
                } else {
                    //pull from user input
                    if (userInput.getText().toString().matches("")) { //user input is empty
                        calculationValue = 0;
                        userInput.setText("0");
                    } else {
                        calculationValue = Double.parseDouble(userInput.getText().toString());
                    }

                    //calculate new value
                    calculationValue /= 1.60934;

                    //display result
                    resultText.setText(Double.toString(calculationValue));
                }
            }//end onClick
        });//end setOnClickListener

        //function to switch between calculation modes
        switchModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMiToKilo) { //currently calculating fahrenheit to celsius
                    isMiToKilo = false;
                    inputDistUnit.setText(R.string.km);
                    resultDistUnit.setText(R.string.mi);
                    userInput.setText("");
                    resultText.setText("");
                } else {
                    isMiToKilo = true;
                    inputDistUnit.setText(R.string.mi);
                    resultDistUnit.setText(R.string.km);
                    userInput.setText("");
                    resultText.setText("");
                }
            }//end onClick
        });//end setOnClickListener

        return view;
    }
}
