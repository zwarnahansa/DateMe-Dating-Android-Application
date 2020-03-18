package com.example.dateme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        Button mainButton = (Button) findViewById(R.id.mainBtnIcon);
        Button msgButton = (Button) findViewById(R.id.msgBtnIcon);
        Button editProfileBtn = (Button) findViewById(R.id.editBtnIcon);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ProfileView.this, Main.class);
                startActivity(mainIntent);
            }
        });

        msgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msgIntent = new Intent(ProfileView.this, Message.class);
                startActivity(msgIntent);
            }
        });

        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editProfileIntent = new Intent(ProfileView.this, EditProfile.class);
                startActivity(editProfileIntent);
            }
        });
    }
}
