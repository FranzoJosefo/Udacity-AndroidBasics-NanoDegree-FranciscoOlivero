package com.example.android.cookies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void cookieEaterHandler (View view){
        if (!flag) {
            eatCookie(view);
            flag = true;
        } else {
            getHungry(view);
            flag = false;
        }
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView cookieImageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        cookieImageView.setImageResource(R.drawable.after_cookie);

        // TODO: Find a reference to the TextView in the layout. Change the text.
        TextView statusTextView = (TextView) findViewById(R.id.status_text_view);
        statusTextView.setText("I'm so full");

        Button statusButton = (Button) findViewById(R.id.status_Button);
        statusButton.setText("GET HUNGRY");
    }

    /**
     * Called when the cookie must reappear!.
     */

    public void getHungry(View view) {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView cookieImageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        cookieImageView.setImageResource(R.drawable.before_cookie);

        // TODO: Find a reference to the TextView in the layout. Change the text.
        TextView statusTextView = (TextView) findViewById(R.id.status_text_view);
        statusTextView.setText("I'm so hungry");

        Button statusButton = (Button) findViewById(R.id.status_Button);
        statusButton.setText("EAT COOKIE");
    }
}