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

        Intent intent = getIntent();

        String list = intent.getStringExtra("text");
    }
}