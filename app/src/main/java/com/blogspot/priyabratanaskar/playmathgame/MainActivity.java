package com.blogspot.priyabratanaskar.playmathgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String REQUEST_INTENT = "score";
    public static final int TEXT_REQUEST = 1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startQuiz(View view) {
        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
        intent.putExtra(REQUEST_INTENT, true);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(REQUEST_INTENT, -1);
                button = findViewById(R.id.play_btn);
                button.setText("Play Again");
                Toast.makeText(getApplicationContext(), "Your score is: " + score + " Out of 5", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
