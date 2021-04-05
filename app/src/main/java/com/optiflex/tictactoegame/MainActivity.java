package com.optiflex.tictactoegame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private TextView playerOneScore,playerTwoScore,playerStatus;
    private Button[] buttons = new Button[9];
    private Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9;
    private Button resetGame;

    private int playerOneScoreCount,playerTwoScoreCount,roundCount;
    boolean activePlayer;

    /**
     * p1=0
     * p2=1
     * empty = 2
     * if player chooses we update game state array
     */
    int [] gameState = {2,2,2,2,2,2,2,2,2};

    int[][] winningPositions = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerOneScore = findViewById(R.id.playerOneScore);
        playerTwoScore = findViewById(R.id.playerTwoScore);
        playerStatus = findViewById(R.id.playerStatus);

        resetGame = findViewById(R.id.resetGame);

        for (int x = 0; x < buttons.length; x++)
        {
            String buttonId = "btn_"+x;
            int resourceID = getResources().getIdentifier(buttonId,"id",getPackageName());
            buttons[x] = findViewById(resourceID);
            buttons[x].setOnClickListener(this);
        }

        roundCount = 0;
        playerTwoScoreCount =0;
        playerOneScoreCount =0;
        activePlayer = true; //player 1
    }

    @Override
    public void onClick(View v) {
        //IF BUTTON CLICKED SHOULD NOT BE CLICKE AGAIN
        if(!((Button)v).getText().toString().equals(""))
        {
            return;
        }
        String buttonID = v.getResources().getResourceEntryName(v.getId());
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length()-1,buttonID.length()));


        //WHICH PLAYER

        if(activePlayer)
        {
            ((Button)v).setText("X");
            ((Button)v).setTextColor(Color.parseColor("#FFC34A"));
            gameState[gameStatePointer]=0;
        }else {
            ((Button)v).setText("0");
            ((Button)v).setTextColor(Color.parseColor("#70FFAA"));
            gameState[gameStatePointer]=0;
        }

        roundCount ++;

    }

    public Boolean checkWinner()
    {
        boolean winnerResult = false;
        for(int [] winningPosition : winningPositions)
        {
            if(gameState[winningPosition[0]] == gameState[winningPosition[1]])

        }
    }
}