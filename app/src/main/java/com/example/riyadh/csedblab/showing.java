package com.example.riyadh.csedblab;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class showing extends AppCompatActivity {

    ListView lv;
    BaseFun b = new BaseFun(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing);

        ArrayList<String> tempList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.myList);
        Cursor res = b.getAllByCursor();
        while (res.moveToNext()) {
            tempList.add(res.getString(0));
            ListAdapter myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tempList);
            lv.setAdapter(myAdapter);

        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                display.regId = (String) lv.getItemAtPosition(i);
                Toast.makeText(showing.this, "Item Clicked " + display.regId, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), display.class));



            }
        });

    }
}
