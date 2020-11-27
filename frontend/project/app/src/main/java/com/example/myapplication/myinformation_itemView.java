package com.example.myapplication;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class myinformation_itemView extends LinearLayout {
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;

    public myinformation_itemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.myinformation_item, this, true);

        tv1= (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
    }

    public void setA(String name){
        tv1.setText(name);
    }
    public void setB(String name){
        tv2.setText(name);
    }
    public void setC(String name){
        tv3.setText(name);
    }
    public void setD(String name){
        tv4.setText(name);
    }
    public void setE(String name){
        tv5.setText(name);
    }

    public myinformation_itemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public myinformation_itemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public myinformation_itemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}

