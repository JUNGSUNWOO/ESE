package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Button button;
        Button button3;
        Button button2;
        button3 = (Button)findViewById(R.id.button3);
        button2 = (Button)findViewById(R.id.button2);
        button = (Button)findViewById(R.id.button);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(HomePage.this,myinformation.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,myfighting.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(HomePage.this, page_4.class);
                startActivity(intent);
            }
        });

    }
}