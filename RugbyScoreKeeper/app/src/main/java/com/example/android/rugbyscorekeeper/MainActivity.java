package com.example.android.rugbyscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int scoreLocal = 0;
    private int scoreVisitor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addTwoForLocal(View view) {
        scoreLocal = scoreLocal + 2;
        displayForLocal(scoreLocal);
    }

    public void addThreeForLocal(View view) {
        scoreLocal = scoreLocal + 3;
        displayForLocal(scoreLocal);
    }

    public void addFiveForLocal(View view) {
        scoreLocal = scoreLocal + 5;
        displayForLocal(scoreLocal);
    }

    public void addSevenForLocal(View view) {
        scoreLocal = scoreLocal + 7;
        displayForLocal(scoreLocal);
    }

    public void addTwoForVisitor(View view) {
        scoreVisitor = scoreVisitor + 2;
        displayForVisitor(scoreVisitor);
    }

    public void addThreeForVisitor(View view) {
        scoreVisitor = scoreVisitor + 3;
        displayForVisitor(scoreVisitor);
    }

    public void addFiveForVisitor(View view) {
        scoreVisitor = scoreVisitor + 5;
        displayForVisitor(scoreVisitor);
    }

    public void addSevenForVisitor(View view) {
        scoreVisitor = scoreVisitor + 7;
        displayForVisitor(scoreVisitor);
    }

    public void resetScores(View view) {
        scoreLocal = 0;
        scoreVisitor = 0;
        displayForLocal(scoreLocal);
        displayForVisitor(scoreVisitor);
    }

    /**
     * Displays the given score for Local Team.
     */

    public void displayForLocal(int score) {
        TextView scoreView = (TextView) findViewById(R.id.localScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Visitor Team.
     */

    public void displayForVisitor(int score) {
        TextView scoreView = (TextView) findViewById(R.id.visitorScore);
        scoreView.setText(String.valueOf(score));
    }

}
