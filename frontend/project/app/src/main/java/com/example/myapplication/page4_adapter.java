package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
<<<<<<< HEAD
=======
import android.content.Intent;
>>>>>>> origin/zaqws4894
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
<<<<<<< HEAD
=======
import android.widget.Button;
>>>>>>> origin/zaqws4894
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

<<<<<<< HEAD
public class page4_adapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<page4_Item> items = new ArrayList<page4_Item>() ;
=======

public class page4_adapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<page4_Item> items = new ArrayList<page4_Item>();
>>>>>>> origin/zaqws4894

    // ListViewAdapter의 생성자
    public page4_adapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
<<<<<<< HEAD
        return items.size() ;
=======
        return items.size();
>>>>>>> origin/zaqws4894
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
<<<<<<< HEAD
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int pos = position;
        Context context = parent.getContext();

=======
    public @NonNull
    View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int pos = position;
        Context context = parent.getContext();


>>>>>>> origin/zaqws4894
        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.page4_itemview, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
<<<<<<< HEAD
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1) ;
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2) ;

=======

        TextView maxspeedview = (TextView) convertView.findViewById(R.id.textView1);
        TextView lowspeedview = (TextView) convertView.findViewById(R.id.textView2);
        TextView avespeedview = (TextView) convertView.findViewById(R.id.textView3);
        TextView timeview = (TextView) convertView.findViewById(R.id.textView4);
        Button btn_ghost = (Button)convertView.findViewById(R.id.btn_ghost);
        btn_ghost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), map_page_7.class);
                v.getContext().startActivity(intent);
            }
        });
>>>>>>> origin/zaqws4894
        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        page4_Item item = items.get(position);

        // 아이템 내 각 위젯에 데이터 반영
<<<<<<< HEAD
        iconImageView.setImageDrawable(item.getIcon());
        titleTextView.setText(item.getTitle());
        descTextView.setText(item.getDesc());
=======
        maxspeedview.setText(item.getMax());
        lowspeedview.setText(item.getLow());
        avespeedview.setText(item.getAve());
        timeview.setText(item.getTime());
>>>>>>> origin/zaqws4894
        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
<<<<<<< HEAD
        return position ;
=======
        return position;
>>>>>>> origin/zaqws4894
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
<<<<<<< HEAD
        return items.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(Drawable icon, String title, String desc) {
        page4_Item item = new page4_Item();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);
=======
        return items.get(position);
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String max, String low, String ave, String time) {
        page4_Item item = new page4_Item();

        item.setMax(max);
        item.setLow(low);
        item.setAve(ave);
        item.setTime(time);
>>>>>>> origin/zaqws4894

        items.add(item);
    }
}