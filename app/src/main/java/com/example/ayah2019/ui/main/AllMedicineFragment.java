package com.example.ayah2019.ui.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
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
    private ImageView imSearch;
    private EditText etTitleToSearch;



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
        //search2
        imSearch=view.findViewById(R.id.imSearch);
        etTitleToSearch=view.findViewById(R.id.etTitleToSearch);
        //3 search event
        imSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSearch=etTitleToSearch.getText().toString();
            }
        });
        lsvmedicine.setAdapter(medicineAdapter);
        return view;

        //return inflater.inflate(R.layout.fragment_all_medicine, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        //search:delete method colling
       // readMedicineFromFirebase("");
    }

    //4 search :add parameter toi search

    public void readMedicineFromFirebase( final String stTosearch) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();//to connect to database
        FirebaseAuth auth = FirebaseAuth.getInstance();//to get current UID
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();

        reference.child("medicines").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                medicineAdapter.clear();
                //**fe al datachange m3alg al7dth
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    MyMedicine m = d.getValue(MyMedicine.class);
                    Log.d("MyMedicine", m.toString());
                    if (stTosearch==null || stTosearch.length()==0)
                    {
                        medicineAdapter.add(m);
                    }
                    else //search
                    if(m.getTitle().contains(stTosearch))
                    medicineAdapter.add(m);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }
}


