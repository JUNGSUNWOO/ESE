package com.example.myapplication;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class myfighting_itemView extends LinearLayout {
    TextView tv_1;
    TextView tv_2;
    TextView tv_3;
    TextView tv_4;
    public myfighting_itemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_myfighting_item, this, true);

        tv_1= (TextView) findViewById(R.id.tv1);
        tv_2 = (TextView) findViewById(R.id.tv2);
        tv_3 = (TextView) findViewById(R.id.tv3);
        tv_4 = (TextView) findViewById(R.id.tv4);

    }


    public void setA(String name){
        tv_1.setText(name);
    }
    public void setB(String name){
        tv_3.setText(name);
    }
    public void setC(String name){
        tv_4.setText(name);
    }
    public void setD(String name){
        tv_2.setText(name);
    }

    public myfighting_itemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public myfighting_itemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public myfighting_itemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}


