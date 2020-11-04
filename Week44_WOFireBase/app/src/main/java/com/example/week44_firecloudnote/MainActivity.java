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

    //Listview variable - To be referenced later
    ListView listView;
    //Defining an arraylist in the class scope - Not inside a method so it's usage is not limited to that method
    //set to static in order to be accesible from DetailActivity
    static ArrayList<String> myList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gets the listview from the ID given in the layout res file
        listView = findViewById(R.id.listView);


        //Dummy data
        myList.add("Item1");
        myList.add("Item2");
        myList.add("Item3");
        myList.add("Item4");
        myList.add("Item5");
        myList.add("Item6");
        myList.add("Item7");

        //ArrayAdapter takes instance of current class, format (simple list) and the arraylist
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myList);

        //sets an adapter to the listview (the arrayadapter we just made)
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myList.get(position);
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                //Lets the new activity know which item was tapped
                intent.putExtra("ID", position);
                //Starts the activity
                startActivity(intent);



            }
        });

    }

}