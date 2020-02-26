package com.example.ayah2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        etEmail = findViewById(R.id.etEmail2);
        etPassword = findViewById(R.id.etPassword1);
        btnsignin = findViewById(R.id.btnsignin);
        btnsignup = findViewById(R.id.btnsignup);



        btnsignin.setOnClickListener(  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplication(),AddMedicine.class);
                startActivity(in);
                dataHndler();
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), signupActivity.class);
                startActivity(i);
            }
        });
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
                if (passw.length() < 8)
                {
                    etPassword.setError("password length error");
                    isOk=false;
                }

               // if (isOk) {
                   // signIn(email, passw);

              //  }
            }

            public boolean isValidEmailAddress(String email) {
                String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
                java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
                java.util.regex.Matcher m = p.matcher(email);
                return m.matches();
            }


            private void signIn(String email, String passw)
            {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> medicine) {
                        if (medicine.isSuccessful()) {
                            Intent i = new Intent(getApplication(), AddMedicine.class);
                            startActivity(i);
                        }
                        else
                            {
                            etEmail.setError("email or password is worng");
                        }

                    }
                });
            }






 }















