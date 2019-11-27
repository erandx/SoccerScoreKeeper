package com.example.android.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    /**
     * Tracks score for Team A and Team B
     */
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int yellowTeamA = 0;
    int yellowTeamB = 0;
    int redTeamA = 0;
    int redTeamB = 0;
    int cornerTeamA = 0;
    int cornerTeamB = 0;

    /**
     * Time Watch with Start and Pause the Game. Displays the time when Starting the Game.
     * Press Pause and Reset to start over the Time Watch.
     */
    TextView timer;
    Button start, pause;
    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L;
    Handler handler;
    int Seconds, Minutes, MilliSeconds;
    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (UpdateTime % 100);

            timer.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%2d", MilliSeconds));

            handler.postDelayed(this, 0);
        }

    };

    /**
     * Reset button - Make reset button visible
     */
    Button rp,
    //    Reset button - Make reset button invisible when reset button have been pressed
      rpyes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rp = findViewById(R.id.resetbutton);
        rpyes = findViewById(R.id.resetbutton);

        timer = (TextView) findViewById(R.id.timer);
        start = (Button) findViewById(R.id.start);
        pause = (Button) findViewById(R.id.pause);

        handler = new Handler();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeBuff += MillisecondTime;

                handler.removeCallbacks(runnable);

            }
        });

    }

    /**
     * When clicked will make the Reset button visible.
     */
    public void yes(View view) {
        rp.setVisibility(View.VISIBLE);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Adds a Yellow Card for Team A.
     */
    public void addYellowTeamA(View view) {
        yellowTeamA = yellowTeamA + 1;
        displayYellowTeamA(yellowTeamA);
    }

    /**
     * Adds a Red Card for Team A.
     */
    public void addRedTeamA(View view) {
        redTeamA = redTeamA + 1;
        displayRedTeamA(redTeamA);
    }

    /**
     * Adds a Corner for Team A.
     */
    public void addCornerTeamA(View view) {
        cornerTeamA = cornerTeamA + 1;
        displayCornerTeamA(cornerTeamA);
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Adds a Yellow Card for Team B.
     */
    public void addYellowTeamB(View view) {
        yellowTeamB = yellowTeamB + 1;
        displayYellowTeamB(yellowTeamB);
    }

    /**
     * Adds a Red Card for Team B.
     */
    public void addRedTeamB(View view) {
        redTeamB = redTeamB + 1;
        displayRedTeamB(redTeamB);
    }

    /**
     * Adds a Corner for Team B.
     */
    public void addCornerTeamB(View view) {
        cornerTeamB = cornerTeamB + 1;
        displayCornerTeamB(cornerTeamB);
    }

    /**
     * It will ask and Resets the results to 0.
     */

    public void resetScore(View view) {
        rpyes.setVisibility(View.INVISIBLE);

        MillisecondTime = 0L;
        StartTime = 0L;
        TimeBuff = 0L;
        UpdateTime = 0L;
        Seconds = 0;
        Minutes = 0;
        MilliSeconds = 0;
        timer.setText("00:00:00");

        scoreTeamA = 0;
        scoreTeamB = 0;
        yellowTeamA = 0;
        redTeamA = 0;
        yellowTeamB = 0;
        redTeamB = 0;
        cornerTeamA = 0;
        cornerTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayYellowTeamA(yellowTeamA);
        displayYellowTeamB(yellowTeamB);
        displayRedTeamA(redTeamA);
        displayRedTeamB(redTeamB);
        displayCornerTeamA(cornerTeamA);
        displayCornerTeamB(cornerTeamB);
    }


    /**
     * Displays the given results for Team B.
     */

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayYellowTeamA(int yellowCards) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_yellowCards);
        scoreView.setText(String.valueOf(yellowCards));
    }

    public void displayRedTeamA(int redCards) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_redCards);
        scoreView.setText(String.valueOf(redCards));
    }

    public void displayCornerTeamA(int redCards) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_corners);
        scoreView.setText(String.valueOf(redCards));
    }

    /**
     * Displays the given results for Team B.
     */

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayYellowTeamB(int yellowCards) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_yellowCards);
        scoreView.setText(String.valueOf(yellowCards));
    }

    public void displayRedTeamB(int redCards) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_redCards);
        scoreView.setText(String.valueOf(redCards));
    }

    public void displayCornerTeamB(int redCards) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_corners);
        scoreView.setText(String.valueOf(redCards));
    }

}
