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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Ayah2019.data.MyMedicine;

public class AddMedicine extends AppCompatActivity {
    private Button btnSave;
    private EditText etMname,etTitle,etMprice, etAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        btnSave = findViewById(R.id.btnSave);
        etMname = findViewById(R.id.etMname);
        etMprice = findViewById(R.id.etMprice);
        etTitle= findViewById(R.id.etTitle);
        etAmount=findViewById(R.id.etAmount);




        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();

            }
        });
    }

            private void dataHandler() {
                String MedicineName=etMname.getText().toString();
                String MedicinePrice=etMprice.getText().toString();
                String title=etTitle.getText().toString();
                String amount=etAmount.getText().toString();

                boolean isok=true;
                if(MedicineName.length()<1)
                {
                    etMname.setError("you have to write  MedicineName");
                    isok=false;


                }
                if(isok)
                {
                    MyMedicine m=new MyMedicine();
                    m.setName(MedicineName);
                    creatMyMedicine(m);


                }
                if(MedicinePrice.length()<0)
              {
                    etMprice.setError("you have to write  MedicinePrice");
                    isok=false;

                }
                if(isok)
                {
                    MyMedicine m=new MyMedicine();
                    m.setPrice(MedicinePrice);

                }
                if (title.length()<1)
                {
                    etTitle.setError("you have to write title");
                   isok=false;
                }
                if (isok)
                {
                    MyMedicine m=new MyMedicine();
                    m.setTitle(title);
               }

                if (amount.length()<1)
                {
                    etAmount.setError("you have to write title");
                    isok=false;
                }
                if (isok)
                {
                    MyMedicine m=new MyMedicine();
                    m.setAmount(amount);
                    creatMyMedicine(m);
                }

                }



            private void  creatMyMedicine (MyMedicine m)
            {
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference();
                FirebaseAuth auth = FirebaseAuth.getInstance();
                String uid = auth.getCurrentUser().getUid();
                m.setName(uid);
                String key = reference.child("medicine").push().getKey();
                m.setPrice(key);
                reference.child(uid).child("medicine").child(key).setValue(m);
                reference.child("medicine").child(uid).child(key).setValue(m).addOnCompleteListener(AddMedicine.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> medicine)
                    {
                        if (medicine.isSuccessful())
                        {
                            Toast.makeText(AddMedicine.this,"add sucessful",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else
                        {
                            Toast.makeText(AddMedicine.this,"add falied"+medicine.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            medicine.getException().printStackTrace();
                        }
                    }
                });



            }



        }










