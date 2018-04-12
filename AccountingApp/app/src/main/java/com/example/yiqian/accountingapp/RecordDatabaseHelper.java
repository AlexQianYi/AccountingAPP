package com.example.yiqian.accountingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;

/**
 * Created by yiqian on 2018/4/11.
 */

public class RecordDatabaseHelper extends SQLiteOpenHelper{

    private static String TAG = "SQLiteOpenHelper";

    public static final String DB_NAME = "Record";

    private static final String CREATE_RECORD_DB = "create table Record (" +
            "id integer primary key autoincrement, " +
            "uuid text, " +
            "type integer, " +
            "category text, " +
            "remark text, " +
            "amount double, " +
            "time integer, " +
            "date date )";


    public RecordDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RECORD_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public void addRecord(RecordBean bean){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("uuid", bean.getUuid());
        values.put("type", bean.getType());
        values.put("category", bean.getCategory());
        values.put("remark", bean.getRemark());
        values.put("amount", bean.getAmount());
        values.put("date", bean.getDate());
        values.put("time", bean.getTimeStamp());
        db.insert(DB_NAME, null, values);
    }

    public void removeRecord(String uuid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_NAME, "uuid = ?", new String[]{uuid});

    }

    public void editRecord(String uuid, RecordBean bean){
        removeRecord(uuid);
        bean.setUuid(uuid);
        addRecord(bean);
    }

    public LinkedList<RecordBean> readRecords(String dateStr){
        SQLiteDatabase db = this.getWritableDatabase();

        LinkedList<RecordBean> records = new LinkedList<>();

        Cursor cursor = db.rawQuery("select DISTINCE * from Record where date = ? order by time asc", new String[]{dateStr});
        if (cursor.moveToFirst()){
            do{
                String uuid = cursor.getString(cursor.getColumnIndex("uuid"));
                int type = cursor.getInt(cursor.getColumnIndex("type"));
                String category = cursor.getString(cursor.getColumnIndex("category"));
                String remark = cursor.getString(cursor.getColumnIndex("remark"));
                double amount = cursor.getDouble(cursor.getColumnIndex("amount"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                long timeStamp = cursor.getLong(cursor.getColumnIndex("time"));

                RecordBean record = new RecordBean();
                record.setUuid(uuid);
                record.setType(type);
                record.setCategory(category);
                record.setAmount(amount);
                record.setDate(date);
                record.setRemark(remark);
                record.setTimeStamp(timeStamp);

                records.add(record);

            }while(cursor.moveToNext());
        }
        cursor.close();

        return records;
    }

    public LinkedList<String> getAvailableDate(){
        LinkedList<String> dates = new LinkedList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select DISTINCT * from Record order by date asc", new String[]);

        if(cursor.moveToFirst()){
            do{
                String date = cursor.getString(cursor.getColumnIndex("date"));
                if(!dates.contains(date)){
                    dates.add(date);
                }
            }while(cursor.moveToNext());
        }
        cursor.close();

        return dates;
    }
}
