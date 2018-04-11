package com.example.yiqian.accountingapp;

import android.util.Log;

import java.util.UUID;

/**
 * Created by yiqian on 2018/4/11.
 */

public class RecordBean {

    public enum RecordType{
        RECORD_TYPE_EXPENSE,
        RECORD_TYPE_INCONE
    }

    private String uuid;

    private double amount;
    private RecordType type;
    private String category;
    private String remark;
    private String date;
    private long timeStamp;

    public RecordBean(){
        uuid = UUID.randomUUID().toString();
        Log.d("RecordBead", uuid);
    }

}
