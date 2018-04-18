package com.example.yiqian.accountingapp;

import android.content.Context;
import android.util.Log;

/**
 * Created by yiqian on 2018/4/17.
 */

public class GlobalUtil {

    private static final String TAG = "GlobalUtil";

    private static GlobalUtil instance;

    public RecordDatabaseHelper databaseHelper;



    public Context context;

    private static int[] costIconRes = {};
    private static int[] costIconResBlack = {};
    private static String[] costTitle = {};
    private static int[] earnIconRes = {};
    private static int[] earnIconResBlack = {};
    private static String[] earnTitle = {};




    public static GlobalUtil getInstance(){
        Log.d(TAG, "ini");
        if(instance == null){
            instance = new GlobalUtil();
        }
        return instance;
    }

    public GlobalUtil(){

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
        databaseHelper = new RecordDatabaseHelper(context, RecordDatabaseHelper.DB_NAME, null, 1);
    }

}
