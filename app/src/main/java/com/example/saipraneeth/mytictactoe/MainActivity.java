package com.example.saipraneeth.mytictactoe;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 1 = pokeball and 0 = dragonball
    int activePlayer = 0;
    boolean gameIsActive = true;
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    int [][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    public void dropin(View view) {


        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2 && gameIsActive) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.dragonball1);

                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.pokeball1);

                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    gameIsActive = false;
                    String winner = "pokeball";

                    if (gameState[winningPosition[0]] == 0) {
                        winner = "dragonball";
                    }
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                    winnerMessage.setText(winner+" has won!!");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.PlayAgainLayout);
                    layout.setVisibility(View.VISIBLE);


                } else {
                    boolean gameIsOver = true;
                    for (int counterState : gameState) {

                        if (counterState == 2) {
                            gameIsOver = false;
                        }

                    }

                    if (gameIsOver == true) {

                        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                        winnerMessage.setText("It's a draw");
                        LinearLayout layout = (LinearLayout) findViewById(R.id.PlayAgainLayout);
                        layout.setVisibility(View.VISIBLE);


                        }

                    }
                }

            }

        }
    
 /*   public void playAgain(View view){

        gameIsActive = true;
        LinearLayout layout = (LinearLayout) findViewById(R.id.PlayAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        activePlayer = 0;
        for(int i=0;i<gameState.length;i++) {

            gameState[i] = 2;
        }
        for(int i=0;i<gameState.length;i++) {
            System.out.print(gameState[i]);
        }
        ImageView again = (ImageView) view;
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for(int i=0;i<gridLayout.getChildCount();i++){
            again = (ImageView) gridLayout.getChildAt(i);
            again.setImageDrawable(null);
        }
    }
*/

    public void bringText (View view) {


        LinearLayout layout = (LinearLayout) findViewById(R.id.PlayAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        gameIsActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {

            gameState[i] = 2;
        }
        GridLayout grid = (GridLayout) findViewById(R.id.gridLayout);
        ImageView img = (ImageView) findViewById(R.id.imageView0);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView1);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView2);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView3);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView4);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView5);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView6);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView7);
        img.setImageResource(0);
        img = (ImageView) findViewById(R.id.imageView8);
        img.setImageResource(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
