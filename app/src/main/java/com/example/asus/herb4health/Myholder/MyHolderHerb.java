package com.example.asus.herb4health.Myholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.herb4health.ItemClickListener;
import com.example.asus.herb4health.R;

/**
 * Created by Non on 10/22/2017.
 */

public class MyHolderHerb extends RecyclerView.ViewHolder implements View.OnClickListener {


    //OUR VIEWS
    public ImageView imgH;
    public TextView nameHerbTxt,nameHerbTxt2,optTxt,howTxt,effectTxt;

    ItemClickListener itemClickListener;

    public MyHolderHerb(View itemView) {
        super(itemView);

        this.imgH= (ImageView) itemView.findViewById(R.id.playerImage);
        this.nameHerbTxt= (TextView) itemView.findViewById(R.id.nameHerbTxt);
        this.nameHerbTxt2 =(TextView) itemView.findViewById(R.id.nameHerbTxt2);
        this.optTxt= (TextView) itemView.findViewById(R.id.optionTxt);
        this.howTxt= (TextView) itemView.findViewById(R.id.howtoTxt);
        this.effectTxt= (TextView) itemView.findViewById(R.id.effectTxt);




        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());

    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }

}


