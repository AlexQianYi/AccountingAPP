package com.example.yiqian.accountingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

public class MainActivity extends AppCompatActivity {

    private TickerView tickerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecordBean bean = new RecordBean();


        tickerView = (TickerView) findViewById(R.id.ticker_view);
        tickerView.setCharacterList(TickerUtils.getDefaultNumberList());
        tickerView.setText("9000");

        tickerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tickerView.setText("1234");
            }
        });
    }
}
