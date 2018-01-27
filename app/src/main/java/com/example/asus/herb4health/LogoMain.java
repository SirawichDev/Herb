package com.example.asus.herb4health;

import android.media.MediaPlayer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.herb4health.Common.Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.example.asus.herb4health.Adapter.GridViewAnswerAdapter;
import com.example.asus.herb4health.Adapter.GridViewSuggestAdapter;


public class LogoMain extends AppCompatActivity {

    public List<String> suggestSource = new ArrayList<>();

    public GridViewAnswerAdapter answerAdapter;
    public GridViewSuggestAdapter suggestAdapter;
    private TextView Score; //view for current total score
    private int mScore = 0;  // current total score


    public Button btnSubmit;

    public GridView gridViewAnswer,gridViewSuggest;

    public ImageView imgViewQuestion;


    int[] image_list={
            R.drawable.aloevera,
            R.drawable.asiaticpennywort,
            R.drawable.bananablossom,
            R.drawable.blackgalingale,
            R.drawable.chinesechive,
            R.drawable.garlic,
            R.drawable.ginkgobiloba,
            R.drawable.grosmichel,
            R.drawable.holybasif,
            R.drawable.lapine,
            R.drawable.lemon,
            R.drawable.marigold,
            R.drawable.nightblooming_jasmine,
            R.drawable.orange,
            R.drawable.orchidtree,
            R.drawable.pumpkin,
            R.drawable.punica,
            R.drawable.santol,
            R.drawable.soybean,
            R.drawable.tea,
            R.drawable.tomato,
            R.drawable.turmeric,
            R.drawable.whitecraneflower,
            R.drawable.whitepopinac


    };

    public char[] answer;

    String correct_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_main);
        //Init View
        initView();
        //score
        Score = (TextView)findViewById(R.id.scorelogo);
        // show current total score for the user
        updateScore(mScore);

    }
    // show current total score for the user
    private void updateScore(int point) {
        Score.setText("" + mScore + "/" + "25" );
    }



    private void initView() {
        gridViewAnswer = (GridView)findViewById(R.id.gridViewAnswer);
        gridViewSuggest = (GridView)findViewById(R.id.gridViewSuggest);

        imgViewQuestion = (ImageView)findViewById(R.id.imgLogo);

        //Add SetupList Here
        setupList();

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result="";

                for(int i=0;i< Common.user_submit_answer.length;i++)
                    result+=String.valueOf(Common.user_submit_answer[i]);

                if(result.equals(correct_answer))
                {
                    mScore = mScore+1;
                    Toast.makeText(getApplicationContext(),"ถูกต้องนะครับ ! นี้คือ "+result,Toast.LENGTH_SHORT).show();
                    //Reset
                    Common.count = 0;
                    Common.user_submit_answer = new char[correct_answer.length()];

                    //Set Adapter
                    GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(setupNullList(),getApplicationContext());
                    gridViewAnswer.setAdapter(answerAdapter);
                    answerAdapter.notifyDataSetChanged();

                    GridViewSuggestAdapter suggestAdapter = new GridViewSuggestAdapter(suggestSource,getApplicationContext(),LogoMain.this);
                    gridViewSuggest.setAdapter(suggestAdapter);
                    suggestAdapter.notifyDataSetChanged();

                    setupList();
                }
                else
                {
                    Toast.makeText(LogoMain.this, "ผิดนะครับ!!!", Toast.LENGTH_SHORT).show();

                    setupList();


                }
                // show current total score for the user
                updateScore(mScore);
            }
        });
    }

    private void setupList() {
        //Random logo
        Random random = new Random();
        int imageSelected = image_list[random.nextInt(image_list.length)];
        imgViewQuestion.setImageResource(imageSelected);

        correct_answer = getResources().getResourceName(imageSelected);
        correct_answer = correct_answer.substring(correct_answer.lastIndexOf("/")+1);

        answer = correct_answer.toCharArray();

        Common.user_submit_answer = new char[answer.length];

        //Add Answer character to List
        suggestSource.clear();
        for(char item:answer)
        {
            //Add logo name to list
            suggestSource.add(String.valueOf(item));
        }

        //Random add some character to list
        for(int i = answer.length;i<answer.length*2;i++)
            suggestSource.add(Common.alphabet_character[random.nextInt(Common.alphabet_character.length)]);

        //Sort random
        Collections.shuffle(suggestSource);

        //Set for GridView
        answerAdapter = new GridViewAnswerAdapter(setupNullList(),this);
        suggestAdapter = new GridViewSuggestAdapter(suggestSource,this,this);

        answerAdapter.notifyDataSetChanged();
        suggestAdapter.notifyDataSetChanged();

        gridViewSuggest.setAdapter(suggestAdapter);
        gridViewAnswer.setAdapter(answerAdapter);


    }

    private char[] setupNullList() {
        char result[] = new char[answer.length];
        for(int i=0;i<answer.length;i++)
            result[i]=' ';
        return result;
    }

}
