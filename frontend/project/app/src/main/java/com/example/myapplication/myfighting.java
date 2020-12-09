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
    class myfightingAdapter extends BaseAdapter { //adapter 클래스 구현

        ArrayList<myfighting_item> items = new ArrayList<myfighting_item>(); //구현해놓은 myfighting_item 데이터들 arrary리스트에 넣어주기

        @Override
        public int getCount() {
            return items.size();
        } //아이템 사이즈

        public void addItem(myfighting_item item){
            items.add(item);
        } //아이템 배열에 넣어주기

        @Override
        public Object getItem(int position) {
            return items.get(position);
        } //아이템이 있는 위치 불러오기

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) { //인터페이스 화면에 보여질 View 함수, 아이템의 위체 불러와서 보여주기
            myfighting_itemView view = new myfighting_itemView(getApplicationContext());

            myfighting_item item2 = items.get(position); //
            view.setA(item2.getDistance2());
            view.setB(item2.getBest_race2());
            view.setC(item2.getWorst_race2());
            view.setD(item2.getNormal_race2());

            Button btn_3 = (Button)view.findViewById(R.id.btn_3);
            btn_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(myfighting.this,HomePage.class);
                    startActivity(intent);
                }
            });
            return view;
        }
    }
}