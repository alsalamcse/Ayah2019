package com.example.ayah2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Ayah2019.MedicineAdapter;
import Ayah2019.MyMedicine;

public class AddMedicine extends AppCompatActivity {
    private Button btnSave;
    private EditText etMname,etTitle,etGps,etMprice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        btnSave = findViewById(R.id.btnSave);
        etMname = findViewById(R.id.etMname);
        etMprice = findViewById(R.id.etMprice);
        etTitle= findViewById(R.id.etTitle);
        etGps= findViewById(R.id.etGps);




        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
                Intent i = new Intent(getApplication(), searchMidicine.class);
                startActivity(i);
            }
        });
    }

            private void dataHandler() {
                String MedicineName=etMname.getText().toString();
                String MedicinePrice=etMprice.getText().toString();
                String title=etTitle.getText().toString();
                String Gps=etGps.getText().toString();

                boolean isok=true;
                if(MedicineName.length()<0)
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
                if (title.length()<0)
                {
                    etTitle.setError("you have to write title");
                    isok=false;
                }
                if (isok)
                {
                    MyMedicine m=new MyMedicine();
                    m.setTitle(title);
                }
                if (Gps.length()<0)
                {
                    etGps.setError("you have to write Gps");
                    isok=false;
                }
                if (isok)
                {
                    MyMedicine m= new MyMedicine();
                    m.setGps(Gps);
                }
             //   if (chvisa==)
             //   {

             //   }
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
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(AddMedicine.this,"add sucessful",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else
                        {
                            Toast.makeText(AddMedicine.this,"add falied"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            task.getException().printStackTrace();
                        }
                    }
                });



            }


        }









