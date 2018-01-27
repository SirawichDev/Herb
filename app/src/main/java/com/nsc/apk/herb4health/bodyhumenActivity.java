package com.nsc.apk.herb4health;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


public class bodyhumenActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout1;
    private DrawerLayout mDrawerLayout2;
    private DrawerLayout mDrawerLayout3;
    private DrawerLayout mDrawerLayout4;
    private DrawerLayout mDrawerLayout5;
    private DrawerLayout mDrawerLayout6;
    private DrawerLayout mDrawerLayout7;
    private DrawerLayout mDrawerLayout8;
    private DrawerLayout mDrawerLayout9;
    private DrawerLayout mDrawerLayout10;


    private ActionBarDrawerToggle mDrawerToggle1;
    private ActionBarDrawerToggle mDrawerToggle2;
    private ActionBarDrawerToggle mDrawerToggle3;
    private ActionBarDrawerToggle mDrawerToggle4;
    private ActionBarDrawerToggle mDrawerToggle5;
    private ActionBarDrawerToggle mDrawerToggle6;
    private ActionBarDrawerToggle mDrawerToggle7;
    private ActionBarDrawerToggle mDrawerToggle8;
    private ActionBarDrawerToggle mDrawerToggle9;
    private ActionBarDrawerToggle mDrawerToggle10;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyhumen);
        mDrawerLayout1 = (DrawerLayout) findViewById(R.id.drawer1);
        mDrawerToggle1 = new ActionBarDrawerToggle(this,mDrawerLayout1,R.string.open,R.string.close);
        mDrawerLayout1.addDrawerListener(mDrawerToggle1);
        mDrawerToggle1.syncState();
        //จบ1
        mDrawerLayout2 = (DrawerLayout) findViewById(R.id.drawer2);
        mDrawerToggle2 = new ActionBarDrawerToggle(this,mDrawerLayout2,R.string.open,R.string.close);
        mDrawerLayout2.addDrawerListener(mDrawerToggle2);
        mDrawerToggle2.syncState();
        //จบ2
        mDrawerLayout3 = (DrawerLayout) findViewById(R.id.drawer3);
        mDrawerToggle3 = new ActionBarDrawerToggle(this,mDrawerLayout3,R.string.open,R.string.close);
        mDrawerLayout3.addDrawerListener(mDrawerToggle3);
        mDrawerToggle3.syncState();
        //จบ3
        mDrawerLayout4 = (DrawerLayout) findViewById(R.id.drawer4);
        mDrawerToggle4 = new ActionBarDrawerToggle(this,mDrawerLayout4,R.string.open,R.string.close);
        mDrawerLayout4.addDrawerListener(mDrawerToggle4);
        mDrawerToggle4.syncState();
        //จบ4
        mDrawerLayout5 = (DrawerLayout) findViewById(R.id.drawer5);
        mDrawerToggle5 = new ActionBarDrawerToggle(this,mDrawerLayout5,R.string.open,R.string.close);
        mDrawerLayout5.addDrawerListener(mDrawerToggle5);
        mDrawerToggle5.syncState();
        //จบ5
        mDrawerLayout6 = (DrawerLayout) findViewById(R.id.drawer6);
        mDrawerToggle6 = new ActionBarDrawerToggle(this,mDrawerLayout6,R.string.open,R.string.close);
        mDrawerLayout6.addDrawerListener(mDrawerToggle6);
        mDrawerToggle6.syncState();
        //จบ6
        mDrawerLayout7 = (DrawerLayout) findViewById(R.id.drawer7);
        mDrawerToggle7 = new ActionBarDrawerToggle(this,mDrawerLayout7,R.string.open,R.string.close);
        mDrawerLayout7.addDrawerListener(mDrawerToggle7);
        mDrawerToggle7.syncState();
        //จบ7
        mDrawerLayout8 = (DrawerLayout) findViewById(R.id.drawer8);
        mDrawerToggle8 = new ActionBarDrawerToggle(this,mDrawerLayout8,R.string.open,R.string.close);
        mDrawerLayout8.addDrawerListener(mDrawerToggle8);
        mDrawerToggle8.syncState();
        //จบ8
        mDrawerLayout9 = (DrawerLayout) findViewById(R.id.drawer9);
        mDrawerToggle9 = new ActionBarDrawerToggle(this,mDrawerLayout9,R.string.open,R.string.close);
        mDrawerLayout9.addDrawerListener(mDrawerToggle9);
        mDrawerToggle9.syncState();
        //จบ9
        mDrawerLayout10 = (DrawerLayout) findViewById(R.id.drawer10);
        mDrawerToggle10 = new ActionBarDrawerToggle(this,mDrawerLayout10,R.string.open,R.string.close);
        mDrawerLayout10.addDrawerListener(mDrawerToggle10);
        mDrawerToggle10.syncState();
        //จบ2

        getSupportActionBar();



    }
   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
       if (mDrawerToggle1.onOptionsItemSelected(item)) {
           return true;
       }
       else if (mDrawerToggle2.onOptionsItemSelected(item)){
           return  true;
       }
       else if (mDrawerToggle3.onOptionsItemSelected(item)){
           return  true;
       }
       else if (mDrawerToggle4.onOptionsItemSelected(item)){
           return  true;
       }
       else if (mDrawerToggle5.onOptionsItemSelected(item)){
           return  true;
       }
       else if (mDrawerToggle6.onOptionsItemSelected(item)){
           return  true;
       }
       else if (mDrawerToggle7.onOptionsItemSelected(item)){
           return  true;
       }
       else if (mDrawerToggle8.onOptionsItemSelected(item)){
           return  true;
       }
       else if (mDrawerToggle9.onOptionsItemSelected(item)){
           return  true;
       }
       else if (mDrawerToggle10.onOptionsItemSelected(item)){
           return  true;
       }
         return  super.onOptionsItemSelected(item);
   }




    //Detect Back Button
    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(bodyhumenActivity.this);

        alertDialog.setTitle("คุณต้องการจะออกจากร่างกาบกับอาการใช่หรือไม่");

        alertDialog.setPositiveButton("ใช่",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        //คลิกใช่ ออกจากโปรแกรม
                        finish();
                        bodyhumenActivity.super.onBackPressed();
                    }
                });

        alertDialog.setNegativeButton("ไม่",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,	int which) {
                        //คลิกไม่ cancel dialog
                        dialog.cancel();
                    }
                });

        alertDialog.show();

    }
    public void GoFirebase2(View view){
        Intent a = new Intent(this,FetchImageFirebase.class);
        startActivity(a);
    }

}
