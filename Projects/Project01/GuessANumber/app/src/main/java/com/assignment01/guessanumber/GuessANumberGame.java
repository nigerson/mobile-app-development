package com.assignment01.guessanumber;

import java.util.Random;

/**
 * Created by robertstjacquesjr on 2/28/17.
 */

public class GuessANumberGame {

    private static GuessANumberGame INSTANCE;
    private static final Random RNG = new Random();

    private int mNumberToGuess;

    private GuessANumberGame() {
        generateRandomNumber();
    }

    public static GuessANumberGame getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new GuessANumberGame();
        }
        return INSTANCE;
    }

    public void startNewRound() {
        generateRandomNumber();
    }

    public String guessANumber(int guess) {
        if(guess == mNumberToGuess) {
            return "You got it!";
        }
        else if(guess < mNumberToGuess) {
            return "Too low!";
        }
        else {
            return "Too high!";
        }
    }

    private void generateRandomNumber() {
        mNumberToGuess = RNG.nextInt(100000000);
    }
}
