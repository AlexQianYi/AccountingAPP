package com.example.yiqian.accountingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddRecordActivity extends AppCompatActivity implements View.OnClickListener, CategoryRecyclerAdapter.OnCategoryClickListener{

    private static String TAG = "AddRecordActivity";

    private EditText editText;

    private String userinput = "";
    private TextView amountText;

    private RecyclerView recyclerView;
    private CategoryRecyclerAdapter adapter;




    private String category = "General";
    private RecordBean.RecordType type = RecordBean.RecordType.RECORD_TYPE_EXPENSE;
    private String remark = "General";

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

        amountText = (TextView) findViewById(R.id.textView_amount);
        editText = (EditText) findViewById(R.id.editText);
        editText.setText(remark);

        handleBackspace();
        handleTypeChange();
        handleChange();
        handleDot();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new CategoryRecyclerAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter.notifyDataSetChanged();

        adapter.setOnCategoryClickListener(this);


    }

    private void handleDot(){
        findViewById(R.id.keyboard_dot).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

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
                if(type == RecordBean.RecordType.RECORD_TYPE_EXPENSE){
                    type = RecordBean.RecordType.RECORD_TYPE_INCONE;
                }else
                    type = RecordBean.RecordType.RECORD_TYPE_EXPENSE;
            }
        });

        adapter.changeType(type);
        category = adapter.getSelected();

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

                if(!userinput.equals("")){
                double amount = Double.valueOf(userinput);

                Log.d(TAG, "change clicked" + amount);}
            else

            {
            }
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

    }

    // update textView
    private void updateAmountText(){


        if(userinput.contains(".")){

            if(userinput.split("\\.").length == 1){
                amountText.setText(userinput + "00");

            }else if(userinput.split("\\.")[1].length()==1){
                amountText.setText(userinput+"0");
            }else if(userinput.split("\\.")[1].length()==2){
                amountText.setText(userinput);
            }

        }else{
            if(userinput.equals("")){
                amountText.setText("0.00");
            }else{
                amountText.setText(userinput+".00");
            }
        }

    }

    @Override
    public void onClick(String category) {
        this.category = category;
        Log.d(TAG, "category" + category);
    }
}
