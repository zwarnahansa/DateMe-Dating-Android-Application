package com.example.dateme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        TextView dateMetext = (TextView) findViewById(R.id.login_text);
        String text = "<font color='#FFFFFF'>Date </font><font color='#fdc653'> Me</font>";
        dateMetext.setText(Html.fromHtml(text));
    }
}
