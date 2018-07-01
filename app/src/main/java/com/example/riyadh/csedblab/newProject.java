package com.example.riyadh.csedblab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class newProject extends AppCompatActivity {

    Spinner s1;
    Button b1;
    EditText e1,e2,e3;
    BaseFun dbHelper = new BaseFun(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);

        s1 = (Spinner) findViewById(R.id.courseSpin);
        b1 = (Button) findViewById(R.id.saveBT);
        e1 = (EditText) findViewById(R.id.regET);
        e2 = (EditText) findViewById(R.id.titleET);
        e3 = (EditText) findViewById(R.id.desET);

        // setting up course spinner/dropdown
        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this,R.array.courseSA,android.R.layout.simple_spinner_dropdown_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(myAdapter);

        //save button fun
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something
                String reg = String.valueOf(e1.getText());
                String course = String.valueOf(s1.getSelectedItem());
                String title = String.valueOf(e2.getText());
                String des = String.valueOf(e3.getText());

                if(dbHelper.addData(reg,course,title,des)) Toast.makeText(newProject.this,"Done Successfully!", Toast.LENGTH_SHORT).show();
                e1.setText("");
                e2.setText("");
                e3.setText("");

            }
        });


    }
}
