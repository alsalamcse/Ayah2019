package com.example.ayah2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class TempAllMedicineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_all_medicine);

        Intent intent=new Intent(getApplication(),AddMedicine.class);
        startActivity(intent);
    }
}
