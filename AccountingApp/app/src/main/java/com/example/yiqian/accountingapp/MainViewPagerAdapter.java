package com.example.yiqian.accountingapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.LinkedList;

/**
 * Created by yiqian on 2018/4/12.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    LinkedList<MainFragment> fragments = new LinkedList<>();
    LinkedList<String> dates = new LinkedList<>();

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    private void initFragments(){

        dates = GlobalUtil.getInstance().databaseHelper.getAvailableDate();
        if(!dates.contains(DateUtil.getFormattedDate())){
            dates.addLast(DateUtil.getFormattedDate());
        }

        for(String date: dates){
            MainFragment fragment = new MainFragment(date);
            fragments.add(fragment);
        }

    }

    public void reload(){

        for(MainFragment fragment:fragments){
            fragment.reload();
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    public int getLastIndex(){
        return fragments.size()-1;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public int getTotalCost(int index){

        return fragments.get(index).getTotalCost();
    }

    public String getDateStr(int index){
        return dates.get(index);

    }
}
