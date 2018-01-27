package com.nsc.apk.herb4health.AdapterProduct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nsc.apk.herb4health.Model.Product;
import com.nsc.apk.herb4health.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Non on 1/9/2018.
 */

public class ProductAdapter extends BaseAdapter {


    List<Product> productList;
    Context context;
    public ProductAdapter(List<Product> productList,Context context){
        this.productList = productList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = view;
        if (rootView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            View itemView = inflater.inflate(R.layout.layout_itemproduct,null);
            TextView name = (TextView) itemView.findViewById(R.id.labelproduct);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageproduct);

            Picasso.with(context).load(productList.get(i).getImgPd()).into(imageView);
            name.setText(productList.get(i).getTitlePd());
            return  imageView;
        }
        return rootView;
    }

}
