package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    //Intialize textview Variables
    TextView calculationVal;
    TextView resultVal;
    String outputVal = "";


    //Intailize Buttons variables
    Button calDigitOne;
    Button calDigitTwo;
    Button calDigitThree;
    Button calDigitFour;
    Button calDigitFive;
    Button calDigitSix;
    Button calDigitSeven;
    Button calDigitEight;
    Button calDigitNine;
    Button calDigitZero;
    Button calDigitDot;
    Button equalFunc;
    Button plusFunc;
    Button minusFunc;
    Button multiplyFunc;
    Button modulusFunc;
    Button deleteFunc;
    Button allClearFunc;
    Button buttons[] = new Button[18];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializeViews();
    }
    /**
     * OnclickListner for all four buttons
     * Switch case to add functionality on buttons
     */
    private void intializeViews() {
        //Initialize the textViews from view
        calculationVal = findViewById(R.id.calculationAreaTextView);
        resultVal = findViewById(R.id.calculationResultTextView);

        //add buttons to array and initialize the buttons from view
        buttons[0] = calDigitOne = findViewById(R.id.calDigitOne);
        buttons[1] = calDigitTwo = findViewById(R.id.calDigitTwo);
        buttons[2] = calDigitThree = findViewById(R.id.calDigitThree);
        buttons[3] = calDigitFour = findViewById(R.id.calDigitFour);
        buttons[4] = calDigitFive = findViewById(R.id.calDigitFive);
        buttons[5] = calDigitSix = findViewById(R.id.calDigitSix);
        buttons[6] = calDigitSeven = findViewById(R.id.calDigitSeven);
        buttons[7] = calDigitEight = findViewById(R.id.calDigitEight);
        buttons[8] = calDigitNine = findViewById(R.id.calDigitNine);
        buttons[9] = calDigitZero = findViewById(R.id.calDigitZero);
        buttons[10] = calDigitDot = findViewById(R.id.calDigitDot);
        buttons[11] = equalFunc = findViewById(R.id.equalFunc);
        buttons[12] = plusFunc = findViewById(R.id.plusFunc);
        buttons[13] = minusFunc = findViewById(R.id.minusFunc);
        buttons[14] = multiplyFunc = findViewById(R.id.multiplyFunc);
        buttons[15] = modulusFunc = findViewById(R.id.modulusFunc);
        buttons[16] = deleteFunc = findViewById(R.id.deleteFunc);
        buttons[17] = allClearFunc = findViewById(R.id.allClearFunc);

        //add click listener to buttons
        for (Button b : buttons) {
            b.setOnClickListener(onClickListener);
        }
    }
    /**
     * setOutputVal To show the enter text
     */
    private void setOutputVal(String inputValue) {
        outputVal = outputVal + inputValue;
        calculationVal.setText(outputVal);
    }
    /**
     * allClearClick To remove all the enter text
     */
    public void allClearClick() {
        outputVal = "";
        calculationVal.setText("");
        resultVal.setText("");
    }
    /**
     * deleteClick To clear one by one  enter text
     */
    public void deleteClick() {
        if (!outputVal.isEmpty()) {
            outputVal = outputVal.substring(0,outputVal.length() - 1);
            calculationVal.setText(outputVal);
        }
    }
    /**
     * equalsClick Compute calculations and show to resultiew
     */
    public void equalsClick() {
        if (!outputVal.isEmpty()) {
                ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("rhino");
                Object result = null;
                try {
                    result = scriptEngine.eval(outputVal);
                } catch (ScriptException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
                if(result != null){
                    resultVal.setText(result.toString());
                }


        }
    }
    /**
     * OnclickListner for all four buttons
     * Switch case to add functionality on buttons
     */
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.calDigitOne:
                    setOutputVal("1");
                    break;
                case R.id.calDigitTwo:
                    setOutputVal("2");
                    break;
                case R.id.calDigitThree:
                    setOutputVal("3");
                    break;
                case R.id.calDigitFour:
                    setOutputVal("4");
                    break;
                case R.id.calDigitFive:
                    setOutputVal("5");
                    break;
                case R.id.calDigitSix:
                    setOutputVal("6");
                    break;
                case R.id.calDigitSeven:
                    setOutputVal("7");
                    break;
                case R.id.calDigitEight:
                    setOutputVal("8");
                    break;
                case R.id.calDigitNine:
                    setOutputVal("9");
                    break;
                case R.id.calDigitZero:
                    setOutputVal("0");
                    break;
                case R.id.calDigitDot:
                    setOutputVal(".");
                    break;
                case R.id.equalFunc:
                    equalsClick();
                    break;
                case R.id.plusFunc:
                    setOutputVal("+");
                    break;
                case R.id.minusFunc:
                    setOutputVal("-");
                    break;
                case R.id.multiplyFunc:
                    setOutputVal("*");
                    break;
                case R.id.modulusFunc:
                    setOutputVal("/");
                    break;
                case R.id.deleteFunc:
                    deleteClick();
                    break;
                case R.id.allClearFunc:
                    allClearClick();
                    break;


            }

        }
    };
}