package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class myfighting extends AppCompatActivity {

    private ListView LV3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfighting);

        LV3 = (ListView)findViewById(R.id.list3);

        myfightingAdapter adapter = new myfightingAdapter();
        LV3.setAdapter(adapter);
        adapter.addItem(new myfighting_item("100m", "10km/h","5km/h","7km/h"));
        adapter.notifyDataSetChanged();
    }
    class myfightingAdapter extends BaseAdapter {

        ArrayList<myfighting_item> items = new ArrayList<myfighting_item>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(myfighting_item item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            myfighting_itemView view = new myfighting_itemView(getApplicationContext());

            myfighting_item item2 = items.get(position);
            view.setA(item2.getDistance2());
            view.setB(item2.getBest_race2());
            view.setC(item2.getWorst_race2());
            view.setD(item2.getNormal_race2());

            Button btn_3 = (Button)view.findViewById(R.id.btn_3);
            btn_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(myfighting.this,map_page_7.class);
                    startActivity(intent);
                }
            });
            return view;
        }
    }
}