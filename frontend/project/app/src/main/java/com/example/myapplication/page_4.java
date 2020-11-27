package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class page_4 extends AppCompatActivity {
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_4);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page_4_Fragment1 fragment1 = new page_4_Fragment1();
                final android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, fragment1);
                transaction.commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                page_4_Fragment2 fragment2 = new page_4_Fragment2();
                transaction.replace(R.id.frame, fragment2);
                transaction.commit();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                page_4_Fragment3 fragment3 = new page_4_Fragment3();
                transaction.replace(R.id.frame, fragment3);
                transaction.commit();
            }
        });

    }
}