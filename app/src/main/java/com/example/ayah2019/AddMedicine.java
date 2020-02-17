package com.example.ayah2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Ayah2019.MedicineAdapter;
import Ayah2019.MyMedicine;

public class AddMedicine extends AppCompatActivity {
    private Button btnSave;
    private EditText etMname,etMprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        btnSave=findViewById(R.id.btnSave);
        etMname=findViewById(R.id.etMname);
        etMprice=findViewById(R.id.etMprice);

        btnSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), MedicineAdapter.class);
                startActivity(i);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }

            private void dataHandler() {
                String MedicineName=etMname.getText().toString();
                String MedicinePrice=etMprice.getText().toString();
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
            }


            public void  creatMyMedicine (MyMedicine m)
            {



            }


        });







    }
}
