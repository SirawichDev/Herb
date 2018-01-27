package com.nsc.apk.herb4health;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.nsc.apk.herb4health.Commonflow.CommonProduct;
import com.nsc.apk.herb4health.Model.Product;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

public class ProductDetail extends AppCompatActivity {
    KenBurnsView product_image;
    TextView product_title,product_summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        product_image = (KenBurnsView)findViewById(R.id.product_image);
        product_title = (TextView)findViewById(R.id.product_title);
        product_summary = (TextView)findViewById(R.id.product_summary);

        if ( getIntent() != null){

            int product_index = getIntent().getIntExtra("product_index",-1);
            if(product_index != -1)
                loadProductDetail(product_index);
        }
    }

    private void loadProductDetail(int index){
        Product product = CommonProduct.productList.get(index);
        //Load image
        Picasso.with(getBaseContext()).load(product.getImgPd())
                .into(product_image);
        product_title.setText(product.getTitlePd());
        product_summary.setText(product.getSummaryPd());
    }
}
