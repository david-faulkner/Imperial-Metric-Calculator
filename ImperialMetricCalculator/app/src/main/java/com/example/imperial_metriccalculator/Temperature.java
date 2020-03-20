package com.example.imperial_metriccalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Temperature extends Fragment {

    private boolean isFarToCel = true;
    private double calculationValue = 0.0;
    private EditText userInput;
    private TextView inputTempUnit;
    private TextView resultTempUnit;
    private TextView resultText;
    private Button calculateButton;
    private Button switchModeButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_temperature, container, false);

        //find references
        userInput = (EditText) view.findViewById(R.id.temperatureInput);
        inputTempUnit = (TextView) view.findViewById(R.id.tempConversionText);
        resultTempUnit = (TextView) view.findViewById(R.id.tempConversionResult);
        resultText = (TextView) view.findViewById(R.id.resultText);
        calculateButton = (Button) view.findViewById(R.id.calcButton);
        switchModeButton = (Button) view.findViewById(R.id.switchModeButton);

        //function for calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFarToCel) {
                    //pull from user input
                    if (userInput.getText().toString().matches("")) { //user input is empty
                        calculationValue = 0;
                        userInput.setText("0");
                    } else {
                        calculationValue = Double.parseDouble(userInput.getText().toString());
                    }

                    //calculate new value
                    calculationValue = (calculationValue - 32)/(1.8);

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
                    calculationValue = (calculationValue * 1.8) + 32;

                    //display result
                    resultText.setText(Double.toString(calculationValue));
                }
            }//end onClick
        });//end setOnClickListener

        //function to switch between calculation modes
        switchModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFarToCel) { //currently calculating fahrenheit to celsius
                    isFarToCel = false;
                    inputTempUnit.setText(R.string.cel);
                    resultTempUnit.setText(R.string.far);
                    userInput.setText("");
                    resultText.setText("");
                } else {
                    isFarToCel = true;
                    inputTempUnit.setText(R.string.far);
                    resultTempUnit.setText(R.string.cel);
                    userInput.setText("");
                    resultText.setText("");
                }
            }//end onClick
        });//end setOnClickListener


        return view;
    }

}
