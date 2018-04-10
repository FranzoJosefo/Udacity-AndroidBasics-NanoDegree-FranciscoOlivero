package com.example.android.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView firstItem = (TextView) findViewById(R.id.menu_item_1);
        // Find second menu item TextView and print the text to the logs
        TextView secondItem = (TextView) findViewById(R.id.menu_item_2);
        // Find third menu item TextView and print the text to the logs
        TextView thirdItem = (TextView) findViewById(R.id.menu_item_3);
        Log.i("MainActivity.java",(String) firstItem.getText());
        Log.i("MainActivity.java",(String) secondItem.getText());
        Log.i("MainActivity.java",(String) thirdItem.getText());
    }
}