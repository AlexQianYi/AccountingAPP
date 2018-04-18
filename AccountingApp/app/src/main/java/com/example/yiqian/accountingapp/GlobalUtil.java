package com.example.yiqian.accountingapp;

import android.content.Context;
import android.util.Log;

import java.util.LinkedList;

/**
 * Created by yiqian on 2018/4/17.
 */

public class GlobalUtil {

    private static final String TAG = "GlobalUtil";

    private static GlobalUtil instance;

    public RecordDatabaseHelper databaseHelper;



    public Context context;

    public LinkedList<CategoryResBean> costRes = new LinkedList<>();
    public LinkedList<CategoryResBean> earnRes = new LinkedList<>();

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

        for(int i=0; i<costTitle.length; i++){
            CategoryResBean res = new CategoryResBean();
            res.title = costTitle[i];
            res.resBlack = costIconResBlack[i];
            res.resWhite = costIconRes[i];
            costRes.add(res);
        }

        for(int i=0; i<earnTitle.length; i++){
            CategoryResBean res = new CategoryResBean();
            res.title = earnTitle[i];
            res.resBlack = earnIconResBlack[i];
            res.resWhite = earnIconRes[i];
            earnRes.add(res);
        }
    }

}
