package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class myinformation extends AppCompatActivity {

    private ListView LV2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinformation);

        LV2 = (ListView)findViewById(R.id.list2);

        myinformationAdapter adapter = new myinformationAdapter();
        LV2.setAdapter(adapter);
        adapter.addItem(new myinformation_item("9/15", "1000m","10km/h","5km/h","7km/h"));
        adapter.addItem(new myinformation_item("9/15", "1000m", "10km/h", "5km/h", "7km/h"));
        adapter.addItem(new myinformation_item("9/15", "1000m", "10km/h", "5km/h", "7km/h"));
        adapter.addItem(new myinformation_item("9/15", "1000m", "10km/h", "5km/h", "7km/h"));
        adapter.notifyDataSetChanged();

    }

    class myinformationAdapter extends BaseAdapter {

        ArrayList<myinformation_item> items = new ArrayList<myinformation_item>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(myinformation_item item){
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
            myinformation_itemView view = new myinformation_itemView(getApplicationContext());

            myinformation_item item2 = items.get(position);
            view.setA(item2.getDate());
            view.setB(item2.getDistance());
            view.setC(item2.getBest_race());
            view.setD(item2.getWorst_race());
            view.setE(item2.getNormal_race());


            return view;
        }
    }
}