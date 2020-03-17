package com.example.dateme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView dateMetext = (TextView) findViewById(R.id.login_text);
        String text = "<font color='#FFFFFF'>Date </font><font color='#fdc653'> Me</font>";
        dateMetext.setText(Html.fromHtml(text));

        TextView logInLink = (TextView) findViewById(R.id.logInLink);

        logInLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
