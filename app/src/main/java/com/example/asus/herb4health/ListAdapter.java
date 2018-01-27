package com.example.asus.herb4health;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Non on 9/7/2017.
 */

class ListAdapter extends BaseAdapter {

    private List<Herb> herbList = new ArrayList<>();
    private Context context;

    ListAdapter(Context context, List herbList) {
        this.context = context;
        this.herbList = herbList;
    }

    @Override
    public int getCount() {
        if(herbList==null)
            return  0;
        return herbList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item, parent, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView tvBreed = (TextView) view.findViewById(R.id.tvBreed);
        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);

        imageView.setImageResource(herbList.get(position).getResId());
        tvBreed.setText(herbList.get(position).getBreed());
        tvDescription.setText(herbList.get(position).getDrescription());

        return view;
    }
}
