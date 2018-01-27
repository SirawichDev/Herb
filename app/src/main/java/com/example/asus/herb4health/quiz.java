package com.example.asus.herb4health;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class quiz extends AppCompatActivity {
    private QuestionBank mQuestionLibrary = new QuestionBank();
    private TextView mScoreView;   // view for current total score
    private TextView mQuestionView;  //current question to answer
    private Button mButtonChoice1; // multiple choice 1 for mQuestionView
    private Button mButtonChoice2; // multiple choice 2 for mQuestionView
    private Button mButtonChoice3; // multiple choice 3 for mQuestionView
    private Button mButtonChoice4; // multiple choice 4 for mQuestionView







    private String mAnswer;  // correct answer for question in mQuestionView
    private int mScore = 0;  // current total score
    private int mQuestionNumber = 0; // current question number
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        // setup screen for the first question with four alternative to answer
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);




        updateQuestion();
        // show current total score for the user
        updateScore(mScore);
    }
    private void updateQuestion(){
        // check if we are not outside array bounds for questions
        if(mQuestionNumber<mQuestionLibrary.getLength() ){
            // set the text for new question, and new 4 alternative to answer on four buttons
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber, 4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else {
            Toast.makeText(quiz.this, "ยินดีด้วย!!!", Toast.LENGTH_SHORT).show();
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.win);
            mp.start();
            Intent intent = new Intent(quiz.this, highest_score.class);
            intent.putExtra("score", mScore); // pass the current score to the second screen
            startActivity(intent);
        }
    }

    // show current total score for the user
    private void updateScore(int point) {
        mScoreView.setText("" + mScore+"/"+mQuestionLibrary.getLength());
    }

    public void onClick(View view) {
        Snackbar snackbar = Snackbar.make(view,"ยินดีเข้าสู่ทายคำศัพท์จากภาก",Snackbar.LENGTH_LONG);
        snackbar.show();
        //all logic for all answers buttons in one method
        Button answer = (Button) view;
        // if the answer is correct, increase the score
        if (answer.getText() == mAnswer){
            mScore = mScore + 1;
            //Toast.makeText(quiz.this, "ถูกต้องนะครับ!", Toast.LENGTH_SHORT).show();
            Snackbar.make(view, "ถูกต้องนะครับ!!", Snackbar.LENGTH_SHORT).show();

            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.true2);
            mp.start();


        }
        else {
            //Toast.makeText(quiz.this, "ผิดดดดด!", Toast.LENGTH_SHORT).show();
            Snackbar.make(view, "ผิดดด!!", Snackbar.LENGTH_SHORT).show();

            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.fail);
            mp.start();
        }
        // show current total score for the user
        updateScore(mScore);
        // once user answer the question, we move on to the next one, if any
        updateQuestion();
    }
    public void BackHome(View v) {
        Intent c = new Intent(this, MainActivity.class);
        startActivity(c);
    }

    public void  onBackPressed(){
        AlertDialog.Builder dialog = new  AlertDialog.Builder(this);
        dialog.setMessage("คุณจะออกจะแบบฝึกหัดใช่หรือไม่หรือไม่ ?");
        dialog.setPositiveButton("ตกลง",new DialogInterface.OnClickListener()
        {
            @Override
            public  void onClick(DialogInterface dialog, int which){
                quiz.this.finish();

            }
        });
        dialog.setNegativeButton("ยกเลิก",new  DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                dialog.dismiss();

            }
        });
        dialog.show();
    }

}
