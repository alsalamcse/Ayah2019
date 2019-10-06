package com.example.ayah2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signinActivity extends AppCompatActivity {
    private EditText etEmail,etPassword;
    private Button btnsignin,btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        etEmail=findViewById(R.id.etEmail2);
        etPassword=findViewById(R.id.etPassword1);
        btnsignin=findViewById(R.id.btnsignin);
        btnsignup=findViewById(R.id.btnsignup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),signupActivity.class);
                startActivity(i);
            }
        });
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHndler();
            }

            private void dataHndler() {
                String email = etEmail.getText().toString();
                String passw = etPassword.getText().toString();
                boolean isOk = true;
                if (email.length() < 4) {
                    etEmail.setError("Email length error");
                    isOk = false;
                }
                if (email.indexOf("@") < 0 || email.indexOf(".") < 0) {
                    etEmail.setError("Email wrong format");
                    isOk = false;
                }

                if (isOk) {
                    signIn(email, passw);

                }
            }
            private void signIn(String email, String passw) {
                FirebaseAuth auth=FirebaseAuth.getInstance();
                auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(signinActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                    }
                });




            }





        });





    }


        }
