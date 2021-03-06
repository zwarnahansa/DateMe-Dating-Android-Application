package com.example.dateme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Button mainButton = (Button) findViewById(R.id.mainBtnIcon);
        Button profileButton = (Button) findViewById(R.id.profileBtnIcon);

        Button feedButton = (Button) findViewById(R.id.feedBtn);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Message.this, Main.class);
                startActivity(mainIntent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(Message.this, ProfileView.class);
                startActivity(profileIntent);
            }
        });

        feedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedIntent = new Intent(Message.this, Feed.class);
                startActivity(feedIntent);
            }
        });
    }
}
