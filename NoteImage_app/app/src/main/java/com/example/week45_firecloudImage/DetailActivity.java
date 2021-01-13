package com.example.week45_firecloudImage;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.week45_firecloudImage.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class DetailActivity extends AppCompatActivity {

    EditText editText;
    Button backButton;
    Button saveFirebase;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    //defined as global variable - in order to be called everywhere in current class
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        editText = findViewById(R.id.editText);
        backButton = findViewById(R.id.saveButton);
        saveFirebase = findViewById(R.id.saveFirebase);

        //Intent used to get the Note ID passed by the Mainactivity - Passes data from one activity to another
        Intent intent = getIntent();

        //Declaring an int called ID. Getting the id from the intent
        //In case of invalid id -> Impossible default value to get because the arraylist starts with 0
        id = intent.getIntExtra("ID", -1);

        //if not -1, get the value from the item and display it in edittext | Checks for valid note id
        if (id != -1) {
            //setting the text of the edittext to the id from myList in Mainactivity
            editText.setText(MainActivity.myList.get(id));

        } else {
            //creates an empty note
            MainActivity.myList.add("");

            //id to access this note later
            //-1 in order to get latest added note
            id = MainActivity.myList.size() - 1;

            //Updating the arrayadapter to display in the listview
            MainActivity.arrayAdapter.notifyDataSetChanged();
        }


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //Content of the editText
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Takes the Arraylist from MainActiviy, which then takes the id (Declared earlier) and the charsequence, which then is parsed into a String
                //The arraylist is chosen because we want to change it and s because that's what we want to change it to
                MainActivity.myList.set(id, String.valueOf(s));
                //updates the listview itself via the adapter
                MainActivity.arrayAdapter.notifyDataSetChanged();
                Log.d("Saved", "Note saved locally");


            }

            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(getApplicationContext(), "Saved to List", Toast.LENGTH_LONG).show();

            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Log.d("Home", "Clicked Home");
            }
        });

        //Save note to firestore
        saveFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = editText.getText().toString();
                Map<String, String> noteMap = new HashMap<>();
                noteMap.put("note", note);

                db.collection("note")
                        .add(noteMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(DetailActivity.this, "Note added to Firebase", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(DetailActivity.this, "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }


}