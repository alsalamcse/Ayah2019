package Ayah2019;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.ayah2019.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

public class MedicineAdapter extends ArrayAdapter<MyMedicine>
{
    public MedicineAdapter(@NonNull Context context) {
        super(context, R.layout.activity_medicine_item);

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View vitem = LayoutInflater.from(getContext()).inflate(R.layout.activity_all_medicineadapter, parent, false);
        final TextView title = vitem.findViewById(R.id.tvtitle);
        TextView Gps = vitem.findViewById(R.id.tvGps);
        TextView price = vitem.findViewById(R.id.tvprice);
        TextView name = vitem.findViewById(R.id.tvname);
        CheckBox cach =vitem.findViewById(R.id.cBcash);
        CheckBox credit=vitem.findViewById(R.id.cBcredit);


        //  CheckBox  = vitem.findViewById(R.id.itmChbxlsCompleted);
        //getting data source

        final MyMedicine myMedicine = getItem(position);

       // chIsComplete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           // @Override
           // public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               // if (isChecked) {
                    //todo delete this item
                   // FirebaseU.getReference().child(myMedicine.getKey()).removeValue(new DatabaseReference.CompletionListener() {
                     //   @Override
                      //  public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                         //   if (databaseError == null) {
                            //    Toast.makeText(getContext(), "delete", Toast.LENGTH_SHORT).show();
                           // } else {
                          //      Toast.makeText(getContext(), "not delete", Toast.LENGTH_SHORT).show();
                          //  }
                       // }
                  //  });
              //  }

          //  }
       // });
       // ivInfo.setOnClickListener(new View.OnClickListener() {
           // @Override
          //  public void onClick(View v)
         //   {
         //       Toast.makeText(getContext(), myMedicine.getTittle(), Toast.LENGTH_SHORT).show();
          //     ShowMenu();
         //   }
       // });



        title.setText(myMedicine.getTitle());
        price.setText(myMedicine.getPrice());
        Gps.setText(myMedicine.getGps());
        name.setText(myMedicine.getName());

        cach.setChecked(true);
        credit.setChecked(true);


        // chIsComplete.setChecked(false);
        return vitem;
    }
    public void ShowMenu ()
    {
        final String[] option = {"Add", "View", "Select", "Delete"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_item);
        adapter.addAll(option);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Select option");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0)
                {
                    Toast.makeText(getContext(), "Add", Toast.LENGTH_SHORT).show();
                }
                if (i == 1)
                {
                    Toast.makeText(getContext(), "View", Toast.LENGTH_SHORT).show();
                }
                if (i == 2)
                {
                    Toast.makeText(getContext(), "Select", Toast.LENGTH_SHORT).show();
                }
                if (i == 3)
                {
                    Toast.makeText(getContext(), "Delete", Toast.LENGTH_SHORT).show();
                }


            }
        });
        final AlertDialog a = builder.create();
        a.show();

    }




}