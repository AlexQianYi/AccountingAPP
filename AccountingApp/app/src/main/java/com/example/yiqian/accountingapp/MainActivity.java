package com.example.yiqian.accountingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.robinhood.ticker.TickerView;

public class MainActivity extends AppCompatActivity {

    private TickerView tickerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecordBean bean = new RecordBean();

        getSupportActionBar().setElevation(0);

    }
}
