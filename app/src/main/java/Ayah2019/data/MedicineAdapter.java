package Ayah2019.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.ayah2019.R;
//1                                          //2
public class MedicineAdapter extends ArrayAdapter<MyMedicine>
{
    public MedicineAdapter(@NonNull Context context) {
        super(context, R.layout.medicineitem);

    }
    @NonNull
    @Override
    //3
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View vitem = LayoutInflater.from(getContext()).inflate(R.layout.medicineitem, parent, false);
         TextView amount = vitem.findViewById(R.id.Mamount);

        TextView price = vitem.findViewById(R.id.Mprice);
        TextView name = vitem.findViewById(R.id.Mname);




         MyMedicine myMedicine = getItem(position);

        amount.setText(myMedicine.getAmount());
        price.setText(myMedicine.getPrice());
        name.setText(myMedicine.getName());



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