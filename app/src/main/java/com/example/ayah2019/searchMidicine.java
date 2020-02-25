package com.example.ayah2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class searchMidicine extends AppCompatActivity {
    private static final String[] MEDICINES=new String[]{
            "acamol","acamol pocos","advil","dicsimol baby","cataflam pro","cataflam","optalgen","easy sotomach",
            "dicsimol","cemecol"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_midicine);
        AutoCompleteTextView editText=findViewById(R.id.actv);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,MEDICINES);
        editText.setAdapter(adapter);

    }
}
