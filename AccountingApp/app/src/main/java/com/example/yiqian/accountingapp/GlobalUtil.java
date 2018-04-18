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

    private static int[] costIconRes = {R.drawable.ic_local_atm_white_24dp, R.drawable.ic_local_dining_white_24dp,
            R.drawable.ic_local_bar_white_24dp, R.drawable.ic_shopping_basket_white_24dp, R.drawable.ic_shopping_cart_white_24dp,
            R.drawable.ic_person_white_24dp,R.drawable.ic_videogame_asset_white_24dp, R.drawable.ic_movie_white_24dp,
            R.drawable.ic_supervisor_account_white_24dp, R.drawable.ic_directions_bus_white_24dp, R.drawable.ic_domain_white_24dp,
            R.drawable.ic_stay_current_portrait_white_24dp, R.drawable.ic_desktop_mac_white_24dp, R.drawable.ic_card_giftcard_white_24dp,
            R.drawable.ic_home_white_24dp, R.drawable.ic_flight_takeoff_white_24dp, R.drawable.ic_receipt_white_24dp,
            R.drawable.ic_book_white_24dp, R.drawable.ic_local_hospital_white_24dp, R.drawable.ic_autorenew_white_24dp };

    private static int[] costIconResBlack = {R.drawable.ic_local_atm_black_24dp, R.drawable.ic_local_dining_black_24dp,
            R.drawable.ic_local_bar_black_24dp, R.drawable.ic_shopping_basket_black_24dp, R.drawable.ic_shopping_cart_black_24dp,
            R.drawable.ic_person_black_24dp, R.drawable.ic_videogame_asset_black_24dp, R.drawable.ic_movie_black_24dp,
            R.drawable.ic_supervisor_account_black_24dp, R.drawable.ic_directions_bus_black_24dp, R.drawable.ic_domain_black_24dp,
            R.drawable.ic_stay_current_portrait_black_24dp, R.drawable.ic_desktop_mac_black_24dp, R.drawable.ic_card_giftcard_black_24dp,
            R.drawable.ic_home_black_24dp, R.drawable.ic_flight_takeoff_black_24dp, R.drawable.ic_receipt_black_24dp,
            R.drawable.ic_book_black_24dp, R.drawable.ic_local_hospital_black_24dp, R.drawable.ic_autorenew_black_24dp };

    private static String[] costTitle = {"General", "Food",
            "Drinks", "Groceries", "Shopping",
            "Personal", "Entertain", "Movies",
            "Social", "Transport", "Store",
            "Phone", "Computer", "Gifts",
            "Hosing", "Travel", "Tickets",
            "Books", "Medical", "Transfer"};

    private static int[] earnIconRes = {R.drawable.ic_local_atm_white_24dp, R.drawable.ic_local_activity_white_24dp,
            R.drawable.ic_credit_card_white_24dp, R.drawable.ic_redeem_white_24dp, R.drawable.ic_person_add_white_24dp,
            R.drawable.ic_add_shopping_cart_white_24dp, R.drawable.ic_trending_up_white_24dp};

    private static int[] earnIconResBlack = {R.drawable.ic_local_atm_black_24dp, R.drawable.ic_local_activity_black_24dp,
            R.drawable.ic_credit_card_black_24dp, R.drawable.ic_redeem_black_24dp, R.drawable.ic_person_add_black_24dp,
            R.drawable.ic_add_shopping_cart_black_24dp, R.drawable.ic_trending_up_black_24dp};

    private static String[] earnTitle = {"General", "Reimburse",
            "Salary", "RedPocket", "Part-time",
            "Bonus", "Investment"};




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
