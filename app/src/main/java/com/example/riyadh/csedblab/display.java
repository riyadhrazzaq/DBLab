package com.example.riyadh.csedblab;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class display extends AppCompatActivity {

    public static String regId ="";
    TextView t1,t2,t3;
    Button b1,b2;
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
        int c= fun.getByReg(Integer.parseInt(regId));
        Log.d("displayMsg", String.valueOf(c));
        Toast.makeText(this, c, Toast.LENGTH_SHORT).show();


        /*
        t2.setText( c.getString(c.getColumnIndex("title")) );
        t3.setText(c.getString(2));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Not yet working",Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fun.removeByReg(Integer.parseInt(regId));
                startActivity(new Intent(getApplicationContext(),showing.class));
            }
        });
        */



    }
}
