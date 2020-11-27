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
<<<<<<< HEAD
        Button btn_me;
        Button btn_fri;
        btn_me = (Button)findViewById(R.id.btn_me);
        btn_me.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(HomePage.this, page_4.class);
                startActivity(intent);
            }
        });
        btn_fri = (Button)findViewById(R.id.btn_fri);
        btn_fri.setOnClickListener(new View.OnClickListener(){
=======
        Button button;
        Button button3;
        button3 = (Button)findViewById(R.id.button3);
        button = (Button)findViewById(R.id.button);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(HomePage.this,myinformation.class);
                startActivity(intent);
            }

        });
        button.setOnClickListener(new View.OnClickListener(){
>>>>>>> b5f106e2d58a58c0fc6b38b584cc973523f21925
            public void onClick(View v){
                Intent intent = new Intent(HomePage.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}