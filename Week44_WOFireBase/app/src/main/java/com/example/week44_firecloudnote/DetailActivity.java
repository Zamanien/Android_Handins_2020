package com.example.week44_firecloudnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;


public class DetailActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        editText = findViewById(R.id.editText);

        //Intent used to get the Note ID passed by the Mainactivity - Passes data from one activity to another
        Intent intent = getIntent();

        //Declaring an int called ID. Getting the id from the intent
        //In case of invalid id -> Impossible default value to get because the arraylist starts with 0
        int id = intent.getIntExtra("ID", -1);

        //if not -1, get the value from the item and display it in edittext
        if (id != -1){
            //setting the text of the edittext to the id from myList in Mainactivity
            editText.setText(MainActivity.myList.get(id));
        }
    }
}