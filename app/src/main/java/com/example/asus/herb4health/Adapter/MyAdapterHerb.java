package com.example.asus.herb4health.Adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.bumptech.glide.Glide;
import com.example.asus.herb4health.Filter.CustomFilter;
import com.example.asus.herb4health.ImageUploadConfig;
import com.example.asus.herb4health.ItemClickListener;
import com.example.asus.herb4health.Myholder.MyHolderHerb;
import com.example.asus.herb4health.R;

import java.util.ArrayList;

/**
 * Created by Non on 10/22/2017.
 */

public class MyAdapterHerb extends RecyclerView.Adapter<MyHolderHerb> implements Filterable {

    Context c;
    public ArrayList<ImageUploadConfig>herbs,filterList;
    CustomFilter filter;
    public MyAdapterHerb(Context ctx, ArrayList<ImageUploadConfig> herbs)
    {
        this.c=ctx;
        this.herbs=herbs;
        this.filterList=herbs;
    }
    @Override
    public MyHolderHerb onCreateViewHolder(ViewGroup parent, int viewType) {
        //CONVERT XML TO VIEW ONBJ
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.modelherb,null);

        //HOLDER
        MyHolderHerb holder= new MyHolderHerb(v);

        return holder;
    }
    //DATA BOUND TO VIEWS
    @Override
    public void onBindViewHolder(MyHolderHerb holder, int position) {

        //BIND DATA
        holder.nameHerbTxt.setText(herbs.get(position).getname());
        holder.nameHerbTxt2.setText("ชื่ออื่นๆ:"+herbs.get(position).getName2());
        holder.optTxt.setText("สรรพคุณ:"+herbs.get(position).getOption());
        holder.howTxt.setText("วิธีใช้:"+herbs.get(position).getOption1());
        holder.effectTxt.setText("ผลข้างเคียง:"+herbs.get(position).getOption2());



        Glide.with(c).load(herbs.get(position).geturl()).into(holder.imgH);


        //IMPLEMENT CLICK LISTENET
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v,herbs.get(pos).getname(), Snackbar.LENGTH_SHORT).show();
            }
        });

    }
    //GET TOTAL NUM OF PLAYERS
    @Override
    public int getItemCount() {
        return herbs.size();
    }

    //RETURN FILTER OBJ
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }

        return filter;
    }



}

