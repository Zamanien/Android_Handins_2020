package com.example.week44_firecloudnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        final ArrayList<String> myList = new ArrayList<>();

        myList.add("Item1");
        myList.add("Item2");
        myList.add("Item3");
        myList.add("Item4");
        myList.add("Item5");
        myList.add("Item6");
        myList.add("Item7");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, myList);

        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myList.get(position);
                Intent intent = new Intent(getApplicationContext(), myList.get(position   ));
                startActivity(intent);

            }
        });

    }

}