package com.example.todolist;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class InNoteActivity extends AppCompatActivity {


    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_note);

        editTextTitle = findViewById(R.id.editText_title);
        editTextDescription = findViewById(R.id.editText_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);

        //Sets 1 as the lowest priority
        numberPickerPriority.setMinValue(1);

        //Sets 10 as highest priority
        numberPickerPriority.setMaxValue(10);

    }

    //inflates the menu resource
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();

        //tells the system to use the new_note_menu & to ask the Menu activity
        menuInflater.inflate(R.menu.new_note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Tells the system what to do once item is collected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void saveNote() {

        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPickerPriority.getValue();

        if(title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Fill Out The Form", Toast.LENGTH_SHORT).show();
            return;
        }

        //Important to be consistent with collectionPath. Otherwise it won't show in RecyclerView
        CollectionReference notebookReference = FirebaseFirestore.getInstance()
                .collection("Notes");
        notebookReference.add(new Note(title, description, priority));

        Toast.makeText(this, "Note Successfully Added", Toast.LENGTH_SHORT).show();

        //Close this activity once it is done
        finish();



    }
}
