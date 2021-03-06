package com.example.yiqian.accountingapp;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by yiqian on 2018/4/11.
 */

public class RecordBean implements Serializable{

    private static String TAG = "RecordBean";

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
        timeStamp = System.currentTimeMillis();
        date = DateUtil.getFormattedDate();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getType() {

        if(this.type == RecordType.RECORD_TYPE_EXPENSE){
            return 1;
        } else {
            return 2;
        }
    }

    public void setType(int type) {

        if(type==1){
            this.type = RecordType.RECORD_TYPE_EXPENSE;
        }else{
            this.type = RecordType.RECORD_TYPE_INCONE;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}

