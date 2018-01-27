package com.nsc.apk.herb4health;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.ftinc.kit.util.SizeUtils;
//import com.r0adkll.deadskunk.utils.Utils;
//import com.r0adkll.deadskunk.views.AspectRatioImageView;
import com.r0adkll.slidr.Slidr;


import com.ftinc.kit.util.Utils;
import com.ftinc.kit.widget.AspectRatioImageView;


import com.nsc.apk.herb4health.Model.AndroidOS;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrPosition;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ViewerActivity extends AppCompatActivity {

    public static final String EXTRA_OS = "extra_os_version";

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.cover1) AspectRatioImageView mCover;
    @BindView(R.id.title) TextView mTitle;
    @BindView(R.id.description) TextView mDescription;
    @BindView(R.id.version) TextView mVersion;


    private AndroidOS mOS;
    private SlidrConfig mConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
        ButterKnife.bind(this);

        // Get the status bar colors to interpolate between
        int primary = getResources().getColor(R.color.primarydark);
        int secondary = getResources().getColor(R.color.red_500);

        // Build the slidr config
        int numPositions = SlidrPosition.values().length;
        SlidrPosition position = SlidrPosition.values()[Utils.getRandom().nextInt(numPositions)];

        mConfig = new SlidrConfig.Builder()
                .primaryColor(primary)
                .secondaryColor(secondary)
                .position(SlidrPosition.VERTICAL)
                .velocityThreshold(2400)
//                .distanceThreshold(.25f)
//                .edge(true)
                .touchSize(SizeUtils.dpToPx(this, 32))
                .build();


        // Attach the Slidr Mechanism to this activity
        Slidr.attach(this, mConfig);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mOS = getIntent().getParcelableExtra(EXTRA_OS);
        if(savedInstanceState != null) mOS = savedInstanceState.getParcelable(EXTRA_OS);

        // Set layout contents
        mTitle.setText(mOS.name);
        mDescription.setText(mOS.description);
        mVersion.setText(mOS.version);


        // Load header image
        Glide.with(this)
                .load(mOS.image_url)
                .crossFade()
                .into(mCover);
    }

    @OnClick({R.id.color1, R.id.color2, R.id.color3, R.id.color4, R.id.color5})
    void onColorClicked(View v){
        int color = ((ColorDrawable)v.getBackground()).getColor();
        getWindow().setStatusBarColor(color);
        mConfig.setColorSecondary(color);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(EXTRA_OS, mOS);
    }
}
