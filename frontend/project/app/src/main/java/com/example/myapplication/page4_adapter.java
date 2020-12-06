package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class page4_adapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<page4_Item> items = new ArrayList<page4_Item>() ;

    // ListViewAdapter의 생성자
    public page4_adapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return items.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int pos = position;
        Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.page4_itemview, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득

        TextView maxspeedview = (TextView) convertView.findViewById(R.id.textView1) ;
        TextView lowspeedview = (TextView) convertView.findViewById(R.id.textView2) ;
        TextView avespeedview = (TextView) convertView.findViewById(R.id.textView3) ;
        TextView timeview = (TextView) convertView.findViewById(R.id.textView4) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        page4_Item item = items.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        maxspeedview.setText(item.getMax());
        lowspeedview.setText(item.getLow());
        avespeedview.setText(item.getAve());
        timeview.setText(item.getTime());
        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return items.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String max, String low, String ave, String time) {
        page4_Item item = new page4_Item();

        item.setMax(max);
        item.setLow(low);
        item.setAve(ave);
        item.setTime(time);

        items.add(item);
    }
}