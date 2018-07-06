package com.example.riyadh.csedblab;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by riyadh on 06-Jul-18.
 */

public class DialogCustom extends DialogFragment {
    EditText e1, e2;
    BaseFun fun = new BaseFun(getActivity());

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        /*
        View mView = getLayoutInflater().inflate(R.layout.dialog_edit,null);
        final
        */
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_edit, null))
                // Add action buttons
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        Toast.makeText(getContext(), "chole na", Toast.LENGTH_SHORT).show();

                       // String title = builder.getContext().findViewById(R.id.dlogTitleET).toString();
                        Log.d("say",getView().toString());

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DialogCustom.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

}
