package com.example.gamestatetest;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameState firstInstance = new GameState();
        GameState firstCopy = new GameState(firstInstance);

        Button runTest = findViewById(R.id.runTestButton);
        runTest.setOnClickListener(this);

        System.out.println(firstCopy);

    }


    @Override
    public void onClick(View view) {
        GameState firstInstance = new GameState();
        GameState firstCopy = new GameState(firstInstance);
        GameState secondInstance = new GameState();
        GameState secondCopy = new GameState(secondInstance);
        int currentPlayer = firstInstance.getCurrentPlayer();

        //playing the first card in the current players hand.
        boolean endTurn = firstInstance.endTurn(currentPlayer);
        EditText line = findViewById(R.id.simple);
        line.setText(firstCopy.toString());
        boolean playCard = firstInstance.playCard(currentPlayer,
                firstInstance.getCard(currentPlayer,0));
        boolean selectCard = firstInstance.selectCard();
        boolean chooseAnte = firstInstance.chooseAnte(currentPlayer);
        boolean forfeit = firstInstance.forfeit();
        EditText forfeitText = findViewById(R.id.forfeitText);
        forfeitText.setText("Player 0 got tired of Player 1's tactics and rage quited", TextView.BufferType.SPANNABLE);
        EditText chooseAnteText = findViewById(R.id.chooseAnteText);
        chooseAnteText.setText("Player 0 chose the red dragon from the ante pile.");


    }
}