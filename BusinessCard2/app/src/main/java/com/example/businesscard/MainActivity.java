package com.example.businesscard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void aboutUs(View view){
        //Key element is: Intent -> message object that allows communication between components, fx. Activities
        Intent intent = new Intent(this,  AboutUs.class);
        //starts activity and takes intent as paramter
        startActivity(intent);
    }

    public void contactInfo(View view){
        Intent intent = new Intent(this, ContactInfo.class);
        startActivity(intent);
        //System.out.println(getString(R.string.quoteAndre));
    }
}