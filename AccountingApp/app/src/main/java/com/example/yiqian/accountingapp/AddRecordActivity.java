package com.example.yiqian.accountingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddRecordActivity extends AppCompatActivity implements View.OnClickListener{

    private static String TAG = "AddRecordActivity";

    private String userinput = "";
    private TextView amountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        findViewById(R.id.keyboard_one).setOnClickListener(this);
        findViewById(R.id.keyboard_two).setOnClickListener(this);
        findViewById(R.id.keyboard_three).setOnClickListener(this);
        findViewById(R.id.keyboard_four).setOnClickListener(this);
        findViewById(R.id.keyboard_five).setOnClickListener(this);
        findViewById(R.id.keyboard_six).setOnClickListener(this);
        findViewById(R.id.keyboard_seven).setOnClickListener(this);
        findViewById(R.id.keyboard_eight).setOnClickListener(this);
        findViewById(R.id.keyboard_nine).setOnClickListener(this);
        findViewById(R.id.keyboard_zero).setOnClickListener(this);

        //amountText = (TextView) findViewById(R.id.textView_amount);

        handleBackspace();
        handleTypeChange();
        handleChange();
        handleDot();

    }

    private void handleDot(){
        findViewById(R.id.keyboard_dot).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, ". clicked");

                if(!userinput.contains(".")) {
                    userinput += ".";
                }
            }
        });
    }

    private void handleTypeChange(){
        findViewById(R.id.keyboard_category).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "category clicked");
            }
        });
    }

    private void handleBackspace(){
        findViewById(R.id.keyboard_backspace).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(userinput.length()>0){
                    userinput = userinput.substring(0, userinput.length()-1);
                }

                if(userinput.length()>0 && userinput.charAt(userinput.length()-1)=='.'){
                    userinput = userinput.substring(0, userinput.length()-1);
                }

                updateAmountText();
            }
        });
    }

    private void handleChange(){
        findViewById(R.id.keyboard_change).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "change clicked");
            }
        });
    }


    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String input = button.getText().toString();


        if(userinput.contains(".")) {

            if(userinput.split("\\.").length == 1 || userinput.split("\\.")[1].length() < 2){
                userinput += input;
            }

        }else {

            userinput += input;
        }

        updateAmountText();
        Log.d(TAG, "onClick: "+userinput);

    }

    // update textView
    private void updateAmountText(){

        Log.d(TAG, "updateAmountText: "+ userinput);

        if(userinput.contains(".")){

            if(userinput.split("\\.").length == 1){
                amountText.setText(userinput + "00");

            }else if(userinput.split("\\.")[1].length()==1){
                amountText.setText(userinput+"0");
            }else if(userinput.split("\\.")[1].length()==2){
                amountText.setText(userinput);
            }else{
                if(userinput.equals("")){
                    amountText.setText("0.00");
                }else{
                    amountText.setText(userinput+".00");
                }
            }
        }

    }
}
