package com.example.crudammi.ui.aktivitasfisik;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.crudammi.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DuoChoiceDialogFragment extends DialogFragment {

    private int position=0; //default selected position

    private SingleChoiceDialogFragment.SingleChoiceListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener= (SingleChoiceDialogFragment.SingleChoiceListener) context;
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString()+"SingleChoiceListener must implemented");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        final String[] list = getActivity().getResources().getStringArray(R.array.waktu);

        builder.setTitle("Pilih Waktu Berolahraga");
        builder.setSingleChoiceItems(list, position, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                position = i;
               // Toast.makeText(getActivity(),"Waktu Berolahraga : "+list[i],Toast.LENGTH_SHORT).show();

            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onPositiveButtonClicked(list,position, false);
                Toast.makeText(getActivity(),"Data Tersimpan",Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onNegativeButtonClicked();
                Toast.makeText(getActivity(),"Keluar",Toast.LENGTH_SHORT).show();

            }
        });


        return builder.create();
    }
}
