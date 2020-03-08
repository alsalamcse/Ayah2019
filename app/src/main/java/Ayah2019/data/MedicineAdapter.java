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
//0
// 1 new class                     //2 extend......
public class MedicineAdapter extends ArrayAdapter<MyMedicine>
{
    //3 fix error
    public MedicineAdapter(@NonNull Context context) {
        super(context, R.layout.medicineitem);
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View vitem = LayoutInflater.from(getContext()).inflate(R.layout.medicineitem, parent, false);
        //4.2
        //.findViewById
        TextView amount = vitem.findViewById(R.id.Mamount);
       // final TextView tvtitle=vitem.findViewById(R.id.)
        TextView price = vitem.findViewById(R.id.Mprice);
        TextView name = vitem.findViewById(R.id.Mname);

        //4.3 get data object
        final MyMedicine myMedicine = getItem(position);
        //4.4 set object data on the view
        amount.setText(myMedicine.getAmount());
        price.setText(myMedicine.getPrice());
        name.setText(myMedicine.getName());


        return vitem;
    }


//    public void ShowMenu ()
//    {
//        final String[] option = {"Add", "View", "Select", "Delete"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_item);
//        adapter.addAll(option);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        builder.setTitle("Select option");
//        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//                if (i == 0)
//                {
//                    Toast.makeText(getContext(), "Add", Toast.LENGTH_SHORT).show();
//                }
//                if (i == 1)
//                {
//                    Toast.makeText(getContext(), "View", Toast.LENGTH_SHORT).show();
//                }
//                if (i == 2)
//                {
//                    Toast.makeText(getContext(), "Select", Toast.LENGTH_SHORT).show();
//                }
//                if (i == 3)
//                {
//                    Toast.makeText(getContext(), "Delete", Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//        });
//        final AlertDialog a = builder.create();
//        a.show();
//
//    }




}