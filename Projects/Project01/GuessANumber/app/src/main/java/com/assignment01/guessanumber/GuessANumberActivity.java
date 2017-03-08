package com.assignment01.guessanumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GuessANumberActivity extends AppCompatActivity {

    private EditText etGuess;
    private TextView tvFeedback;
    private GuessANumberGame mGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGame = GuessANumberGame.getInstance();

        setContentView(R.layout.activity_guess_anumber);

        etGuess = (EditText)findViewById(R.id.et_guess);
        tvFeedback = (TextView)findViewById(R.id.tv_feedback);

        Button button = (Button)findViewById(R.id.butt_guess);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guess = etGuess.getText().toString();
                int guessNumber = Integer.parseInt(guess);

                String feedback = mGame.guessANumber(guessNumber);

                tvFeedback.setText(feedback);
            }
        });
    }
}
