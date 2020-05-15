package com.blogspot.priyabratanaskar.playmathgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    boolean questionOneScore, questionTwoScore, questionThreeScore, questionFourScore, questionFiveScore;
    CheckBox questionFiveCheckBoxOne, questionFiveCheckBoxTwo, questionFiveCheckBoxThree;
    RadioButton rdbQuestion1, rdbQuestion2, rdbQuestion4;
    EditText questionThreeEditText;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        rdbQuestion1 = findViewById(R.id.radio_btn_1);
        rdbQuestion2 = findViewById(R.id.radio_btn_2);
        questionThreeEditText = findViewById(R.id.question_3_edit_text);
        rdbQuestion4 = findViewById(R.id.radio_btn_4);
        questionFiveCheckBoxOne = findViewById(R.id.checkBox_1);
        questionFiveCheckBoxTwo = findViewById(R.id.checkBox_2);
        questionFiveCheckBoxThree = findViewById(R.id.checkBox_3);
    }

    public void checkBoxScoreCount(View view) {
        if (questionFiveCheckBoxOne.isChecked() && questionFiveCheckBoxTwo.isChecked() && !questionFiveCheckBoxThree.isChecked()) {
            questionFiveScore = true;
        } else
            questionFiveScore = false;
    }

    public void radioBtn1Click(View view) {
        if (rdbQuestion1.isChecked()) {
            questionOneScore = true;
        } else questionOneScore = false;
    }

    public void radioBtn2Click(View view) {
        if (rdbQuestion2.isChecked()) {
            questionTwoScore = true;
        } else questionTwoScore = false;
    }

    public void editTextScoreCount() {
        if (questionThreeEditText.getText().toString().equals("7")) questionThreeScore = true;
        else questionThreeScore = false;
    }

    public void radioBtn4Click(View view) {
        if (rdbQuestion4.isChecked()) questionFourScore = true;
        else if (rdbQuestion4.isChecked() == false) questionFourScore = false;
    }

    public void calculateScore(View view) {
        /**
         * Calling editTextScoreCount() before calculating score to check if editText contains
         * right answer
         */
        editTextScoreCount();
        score = 0;
        if (questionOneScore)
            score++;
        if (questionTwoScore)
            score++;
        if (questionThreeScore)
            score++;
        if (questionFourScore)
            score++;
        if (questionFiveScore)
            score++;
        Intent intent = new Intent();
        intent.putExtra(MainActivity.REQUEST_INTENT, score);
        setResult(RESULT_OK, intent);
        finish();
    }
}
