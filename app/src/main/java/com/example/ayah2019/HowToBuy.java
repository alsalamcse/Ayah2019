package com.example.ayah2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Ayah2019.MedicineAdapter;

public class HowToBuy extends AppCompatActivity {
    private Button btnBalone;
    private Button btnBtaxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_buy);

        btnBalone=findViewById(R.id.btnBalone);
        btnBtaxi=findViewById(R.id.btnBtaxsi);


        btnBtaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), MedicineAdapter.class);
                startActivity(i);

            }
        });

        btnBalone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), MedicineAdapter.class);
                startActivity(i);

            }
        });
    }
}
