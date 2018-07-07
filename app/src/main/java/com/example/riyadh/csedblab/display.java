package com.example.riyadh.csedblab;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class display extends AppCompatActivity {

    EditText e1,e2;
    public static String regId = "";
    TextView t1, t2, t3;
    Button b1, b2;
    BaseFun fun = new BaseFun(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        t1 = (TextView) findViewById(R.id.regTV);
        t2 = (TextView) findViewById(R.id.titleTV);
        t3 = (TextView) findViewById(R.id.desTV);
        b1 = (Button) findViewById(R.id.editBT);
        b2 = (Button) findViewById(R.id.removeBT);

        t1.setText(regId);
        Cursor c = fun.getByReg(Integer.parseInt(regId));
        Log.d("displayMsg", String.valueOf(c));

        c.moveToFirst();
        t2.setText(String.valueOf(c.getString(2)));
        t3.setText(String.valueOf(c.getString(3)));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //alert dialog
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(display.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_edit, null);


                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                e1 = (EditText) dialog.findViewById(R.id.dlogTitleET);
                e2 = (EditText) dialog.findViewById(R.id.dlogDesET);


                Button update = dialog.findViewById(R.id.dlogUpdateBT);
                Button cancel = dialog.findViewById(R.id.dlogCancelBT);
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String title = e1.getText().toString();
                        String des = e2.getText().toString();
                        Log.d("say", regId);
                        //updating database

                        Toast.makeText(display.this, "Database Updated", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        fun.update(regId,title,des);
                        //updating display
                        t2.setText(title);
                        t3.setText(des);
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fun.removeByReg(Integer.parseInt(regId));
                startActivity(new Intent(getApplicationContext(), showing.class));
            }
        });


    }
}
