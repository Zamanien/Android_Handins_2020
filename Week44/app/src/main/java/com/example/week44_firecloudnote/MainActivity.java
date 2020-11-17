package com.example.week44_firecloudnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Listview variable - To be referenced later
    ListView listView;
    Button addNote;
    //Defining an arraylist in the class scope - Not inside a method so it's usage is not limited to that method
    //set to static in order to be accesible from DetailActivity
    static ArrayList<String> myList = new ArrayList<>();
    static ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gets the listview from the ID given in the layout res file
        listView = findViewById(R.id.listView);
        addNote = findViewById(R.id.addNote);

        //ArrayAdapter takes instance of current class, format (simple list) and the arraylist
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myList);

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

        //Deletes the item on long click
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //if id is not less than -1 (empty list)
                if (id != -1) {
                    //remove item - the position as paramter
                    myList.remove(position);
                    //shows the data change in the listview
                    arrayAdapter.notifyDataSetChanged();
                    //Toast with message
                    Toast.makeText(getApplicationContext(), "Item deleted", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        //back button takes the user to empty note through DetailActivty
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(intent);

            }
        });

    }

}