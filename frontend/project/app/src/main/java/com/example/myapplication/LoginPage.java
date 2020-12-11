package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Intent intent = new Intent(this, activity_loading.class);
        startActivity(intent);
        public_url.getInstance().setPer_url("http://192.168.0.6:3000/post");
        Button button;
        button = (Button)findViewById(R.id.btn_login);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(LoginPage.this, HomePage.class);
                startActivity(intent);
            }
        });
    }
}