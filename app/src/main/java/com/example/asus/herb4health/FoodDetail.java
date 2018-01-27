package com.example.asus.herb4health;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.asus.herb4health.Commonflow.Commonflow;
import com.example.asus.herb4health.Model.Food;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

public class FoodDetail extends AppCompatActivity {

    KenBurnsView food_image;
    TextView food_title,food_summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        food_image = (KenBurnsView)findViewById(R.id.food_image);
        food_title = (TextView)findViewById(R.id.food_title);
        food_summary =(TextView)findViewById(R.id.food_summary);

        if (getIntent() != null)
        {
            int food_index = getIntent().getIntExtra("food_index",-1);
            if(food_index != -1)
                loadFoodDetail(food_index);
        }
    }

    private void loadFoodDetail(int index) {
        Food food = Commonflow.foodList.get(index);
        //Load image
        Picasso.with(getBaseContext()).load(food.getImgF())
                .into(food_image);
        food_title.setText(food.getTitle());
        food_summary.setText(food.getSummary());

    }
}
