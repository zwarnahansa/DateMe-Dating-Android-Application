package com.example.dateme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Feed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        Button mainButton = (Button) findViewById(R.id.mainBtnIcon);
        Button profileButton = (Button) findViewById(R.id.profileBtnIcon);

        Button msgButton = (Button) findViewById(R.id.messageBtn);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Feed.this, Main.class);
                startActivity(mainIntent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(Feed.this, ProfileView.class);
                startActivity(profileIntent);
            }
        });

        msgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msgIntent = new Intent(Feed.this, Message.class);
                startActivity(msgIntent);
            }
        });
    }
}
