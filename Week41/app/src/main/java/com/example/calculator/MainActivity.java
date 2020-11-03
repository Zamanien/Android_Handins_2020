package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button myButton;
    private EditText myNumberInput;
    private TextView textView;
    private int output = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Static fields
        textView = findViewById(R.id.myTextView);
        myNumberInput = findViewById(R.id.Input1);
        myButton = findViewById(R.id.myButton);

    }

    public void add(View view){

        int in1 = Integer.parseInt(myNumberInput.getText().toString());

        output = output + in1;
        myNumberInput.setText("");
        textView.setText(output+"");
    }

    public void multiply(View view){

        int in1 = Integer.parseInt(myNumberInput.getText().toString());

        if(in1 == 0){
            in1 = 1;
        }
        output = output * in1;
        myNumberInput.setText("");
        textView.setText(output+"");
    }
    public void minus (View view){

        int in1 = Integer.parseInt(myNumberInput.getText().toString());

        output = output - in1;
        myNumberInput.setText("");
        textView.setText(output+"");
    }

    public void page2(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}
