package com.example.yiqian.accountingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by yiqian on 2018/4/12.
 */

public class ListViewAdapter extends BaseAdapter {

    private LinkedList<RecordBean> records = new LinkedList<>();

    private LayoutInflater mInflater;
    private Context mContext;

    public ListViewAdapter(Context context){
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setData(LinkedList<RecordBean> records){
        this.records = records;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return records.size();
    }

    @Override
    public Object getItem(int position) {
        return records.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.cell_list_view, null);
            RecordBean recordBean = (RecordBean) getItem(position);
            holder = new ViewHolder(convertView, recordBean);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}

class ViewHolder{
    TextView remarkTV;
    TextView amountTV;
    TextView timeTV;
    ImageView categoryTcone;

    public ViewHolder(View itemView, RecordBean record){
        remarkTV = (TextView) itemView.findViewById(R.id.textView_remark);
        amountTV = (TextView) itemView.findViewById(R.id.textView_amount);
        timeTV = (TextView) itemView.findViewById(R.id.textView_time);
        categoryTcone = (ImageView) itemView.findViewById(R.id.imageView_category);


    }
}