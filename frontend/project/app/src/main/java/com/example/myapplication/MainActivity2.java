package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.listView);

        SingerAdapter adapter = new SingerAdapter();
        listView.setAdapter(adapter);
        adapter.addItem(new SingerItem("소녀시대", "010-1000-1000"));
        adapter.addItem(new SingerItem("아이즈원", "010-1022-1123"));
        adapter.addItem(new SingerItem("소녀시대", "010-1004-1121"));
        adapter.addItem(new SingerItem("소녀시대", "010-1020-1142"));
        adapter.addItem(new SingerItem("소녀시대", "010-1013-1022"));
        adapter.notifyDataSetChanged();

    }

    class SingerAdapter extends BaseAdapter{

        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item){
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
            SingeritemView view = new SingeritemView(getApplicationContext());

            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());

            return view;
        }
    }
}
