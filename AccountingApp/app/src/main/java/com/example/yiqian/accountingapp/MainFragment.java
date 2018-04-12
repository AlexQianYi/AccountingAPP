package com.example.yiqian.accountingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.Fragment;

/**
 * Created by yiqian on 2018/4/12.
 */

public class MainFragment extends Fragment {

    private TextView textView;
    private ListView listView;

    private String date = "";

    private View rootView;

    @SuppressLint("ValidFragment")
    public MainFragment(String date){
        this.date = date;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main,container, false);
        initView();
        return rootView;

    }

    private void initView(){
        textView = (TextView) rootView.findViewById(R.id.day_text);
        listView = (ListView) rootView.findViewById(R.id.listView);
        textView.setText(date);
    }
}
