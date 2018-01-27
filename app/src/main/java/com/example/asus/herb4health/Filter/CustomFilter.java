package com.example.asus.herb4health.Filter;

import android.widget.Filter;

import com.example.asus.herb4health.Adapter.MyAdapterHerb;
import com.example.asus.herb4health.ImageUploadConfig;

import java.util.ArrayList;

/**
 * Created by Hp on 3/17/2016.
 */
public class CustomFilter extends Filter {

    MyAdapterHerb adapter;
    ArrayList<ImageUploadConfig> filterList;


    public CustomFilter(ArrayList<ImageUploadConfig> filterList, MyAdapterHerb adapter)
    {
        this.adapter=adapter;
        this.filterList=filterList;

    }

    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();

        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<ImageUploadConfig> filteredPlayers = new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getname().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredPlayers.add(filterList.get(i));
                }
            }

            results.count=filteredPlayers.size();
            results.values=filteredPlayers;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;

        }


        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

       adapter.herbs= (ArrayList<ImageUploadConfig>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();
    }
}
