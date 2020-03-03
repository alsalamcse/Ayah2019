package com.example.ayah2019.ui.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ayah2019.R;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Ayah2019.data.MedicineAdapter;
import Ayah2019.data.MyMedicine;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllMedicineFragment extends Fragment {
    private MedicineAdapter medicineAdapter;
    private ListView lsvmedicine;


    public AllMedicineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        medicineAdapter = new MedicineAdapter(getContext());
        View view = inflater.inflate(R.layout.fragment_all_medicine, container, false);
        lsvmedicine = view.findViewById(R.id.lsvMedicine);
        lsvmedicine.setAdapter(medicineAdapter);
        return view;

        //return inflater.inflate(R.layout.fragment_all_medicine, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        readMedicineFromFirebase();
    }

    public void readMedicineFromFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();//to connect to database
        FirebaseAuth auth = FirebaseAuth.getInstance();//to get current UID
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();

        reference.child("medicines").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                medicineAdapter.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    MyMedicine m = d.getValue(MyMedicine.class);
                    Log.d("MyMedicine", m.toString());
                    medicineAdapter.add(m);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }
}


