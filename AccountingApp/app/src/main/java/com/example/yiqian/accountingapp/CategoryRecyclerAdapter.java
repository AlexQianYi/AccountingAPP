package com.example.yiqian.accountingapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by yiqian on 2018/4/18.
 */

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryViewHolder>{


    private LayoutInflater mInflater;
    public Context mContext;

    private LinkedList<CategoryResBean> cellList = GlobalUtil.getInstance().costRes;

    private String selected = "";

    public CategoryRecyclerAdapter(Context context){
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        selected = cellList.get(0).title;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.cell_category, parent, false);
        CategoryViewHolder myViewHolder = new CategoryViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

        final  CategoryResBean res = cellList.get(position);

        holder.imageView.setImageResource(res.resBlack);
        holder.textView.setText(res.title);

        if(holder.textView.getText().toString().equals(selected)){
            holder.background.setBackgroundResource(R.drawable.bg_edit_text);
        }else{
            holder.background.setBackgroundResource(R.color.colorPrimary);
        }

    }

    @Override
    public int getItemCount() {
        return cellList.size();
    }
}


class CategoryViewHolder extends RecyclerView.ViewHolder{

    RelativeLayout background;
    ImageView imageView;
    TextView textView;

    public CategoryViewHoler(View itemView) {
        super(itemView);

        background = (RelativeLayout)itemView.findViewById(R.id.cell_background);
        imageView = (ImageView) itemView.findViewById(R.id.imageView_category);
        textView = (TextView) itemView.findViewById(R.id.textView_category);
    }
}