package com.example.dateme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView dateMetext = (TextView) findViewById(R.id.login_text);
        String text = "<font color='#FFFFFF'>Date </font><font color='#fdc653'> Me</font>";
        dateMetext.setText(Html.fromHtml(text));

        TextView signUpText = (TextView) findViewById(R.id.signUplink);
        TextView forgotPass = (TextView) findViewById(R.id.fogotPass);

        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, ForgotPassword.class);
                startActivity(intent);
            }
        });


    }
}
