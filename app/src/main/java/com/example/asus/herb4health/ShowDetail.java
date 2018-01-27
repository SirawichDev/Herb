package com.example.asus.herb4health;

import android.content.Intent;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.herb4health.Model.AndroidOS;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.r0adkll.deadskunk.adapters.BetterRecyclerAdapter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;

import butterknife.ButterKnife;

public class ShowDetail extends AppCompatActivity {

    private ImageView image;
    private TextView tvBreed, tvDescription;
    @BindView(R.id.recycler) RecyclerView mRecycler;

    private OSVersionAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        ButterKnife.bind(this);
        initRecycler();



        image = (ImageView) findViewById(R.id.image);
        tvBreed = (TextView) findViewById(R.id.tvBreed);
        tvDescription = (TextView) findViewById(R.id.tvDescription);

        //herb
        ImageView imageView = (ImageView) findViewById(R.id.herbimage);
        TextView textView = (TextView) findViewById(R.id.nameherb);
        TextView textView1 = (TextView) findViewById(R.id.herbdes_show);

        int resId = getIntent().getIntExtra("image", 0);
        String breed = getIntent().getStringExtra("breed");
        String description = getIntent().getStringExtra("description");
        int resId2 = getIntent().getIntExtra("herbimage", 0);
        String breed2 = getIntent().getStringExtra("herbname");
        String description2 = getIntent().getStringExtra("herbdetail");

        image.setImageResource(resId);
        tvBreed.setText(breed);
        tvDescription.setText(description);
        imageView.setImageResource(resId2);
        textView.setText(breed2);
        textView1.setText(description2);
        //Log.d("Herb","resID ="+resId);
        //Log.d("Herb","breed ="+breed);
        // Log.d("Herb","description ="+description);


    }
    private void initRecycler(){
        mAdapter = new OSVersionAdapter();
        mAdapter.addAll(getData());
        mRecycler.setAdapter(mAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setOnItemClickListener(new BetterRecyclerAdapter.OnItemClickListener<AndroidOS>() {
            @Override
            public void onItemClick(View view, AndroidOS androidOS, int i) {
                // Launch the slidable activity
                Intent viewer = new Intent(ShowDetail.this, ViewerActivity.class);
                viewer.putExtra(ViewerActivity.EXTRA_OS, androidOS);
                startActivity(viewer);
            }
        });
    }
    //recycler
    private List<AndroidOS> getData(){
        //Log.d("Hello","hello");
        InputStream is = getResources().openRawResource(R.raw.android_versions);
        InputStreamReader isr = new InputStreamReader(is);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<AndroidOS>>(){}.getType();
        List<AndroidOS> oss = gson.fromJson(isr, listType);
        return oss;
    }



    public void GoFirebase(View view){
        Intent a = new Intent(this,FetchImageFirebase.class);
            startActivity(a);
    }
}
