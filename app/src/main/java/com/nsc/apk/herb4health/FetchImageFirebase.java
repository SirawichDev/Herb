package com.nsc.apk.herb4health;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import com.nsc.apk.herb4health.Adapter.MyAdapterHerb;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FetchImageFirebase extends AppCompatActivity {

     public SearchView sv;

    private DatabaseReference mDatabaseRef;
    private ArrayList<ImageUploadConfig> imgList;
    private RecyclerView  rv;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_image_firebase);
        imgList = new ArrayList<>();

        //ส่วนที่1 เพิ่มเติม
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sv = (SearchView) findViewById(R.id.mSearch);
        rv = (RecyclerView) findViewById(R.id.myRecycler1);

        //SET ITS PROPETRIES
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("กำลังทำการโหลดข้อมูล ...");
        progressDialog.show();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(Uploadimage.STORAGE_URL);
        mDatabaseRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                progressDialog.dismiss();

                //Fetch Img from database
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //ImageUploadConfig class require default constructor
                    ImageUploadConfig img = snapshot.getValue(ImageUploadConfig.class);
                    imgList.add(img);

                }
                //Init adapter
                final MyAdapterHerb adapter = new MyAdapterHerb(FetchImageFirebase.this, imgList);
                //Set adapter for listView
                rv.setAdapter(adapter);
                //SEARCH
                sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String query) {
                        //FILTER AS YOU TYPE
                        adapter.getFilter().filter(query);
                        return false;
                    }
                });



            }









            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });
    }

    //ADD Herbs TO ARRAYLIST


}
