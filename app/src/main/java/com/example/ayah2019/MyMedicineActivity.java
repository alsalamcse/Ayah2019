package com.example.ayah2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Ayah2019.data.FirebaseUtils;
import Ayah2019.data.MedicineAdapter;
import Ayah2019.data.MyMedicine;

public class MyMedicineActivity extends AppCompatActivity {
    //5.2
    private ListView listView;
    private MedicineAdapter medicineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_medicine);
        //5.3
        listView=findViewById(R.id.ListView);
        medicineAdapter= new MedicineAdapter(getBaseContext(),R.layout.medicineitem);
        //5.4
        listView.setAdapter(medicineAdapter);

    }
    //5.5 download from firebase

    public void readTasksFromeFirebase(){
        FirebaseDatabase database=FirebaseDatabase.getInstance();//to connect to database
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get correct id
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();

        FirebaseUtils.getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                medicineAdapter.clear();
                //**fe al datachange m3alg al7dth
                for (DataSnapshot d:dataSnapshot.getChildren()) {
                    MyMedicine t=d.getValue(MyMedicine.class);
                    Log.d("MyTask",t.toString());
                    medicineAdapter.add(t);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

}
