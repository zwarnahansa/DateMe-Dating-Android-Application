package com.example.dateme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class Login extends AppCompatActivity {

    public static final int GOOGLE_SIGN_IN_CODE = 10005;
   GoogleSignInOptions gso;
   GoogleSignInClient signInClient;
   FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView dateMetext = (TextView) findViewById(R.id.login_text);
        String text = "<font color='#FFFFFF'>Date </font><font color='#fdc653'> Me</font>";
        dateMetext.setText(Html.fromHtml(text));

        TextView signUpText = (TextView) findViewById(R.id.signUplink);
        TextView forgotPass = (TextView) findViewById(R.id.fogotPass);

//        Google sign in button
        Button signButton = (Button) findViewById(R.id.googleSinInBtn);

//        Initialze the fireBase
        firebaseAuth = FirebaseAuth.getInstance();

//        Google Sign inn Options
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("870535404318-fslg8lost93053ptcihh1anribjm3pdm.apps.googleusercontent.com")
                .requestEmail()
                .requestProfile()
                .requestId()
                .build();

        signInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null || firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(this, Main.class));
        }
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIntent = signInClient.getSignInIntent();
                startActivityForResult(signIntent, GOOGLE_SIGN_IN_CODE);
            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GOOGLE_SIGN_IN_CODE) {
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult(ApiException.class);

                AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
                firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(getApplicationContext(), "Your account is connected to the Application", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Main.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

            } catch (ApiException e){
                e.printStackTrace();
            }


        }
    }
}
