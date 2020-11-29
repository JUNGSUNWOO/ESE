package com.example.myapplication;

import android.app.ListFragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class page_4_Fragment1 extends ListFragment {
    static final String[] LIST_MENU = {"정선우", "정선우", "정선우", "정선우", "정선우", "정선우"};
    page4_adapter adapter;

    public page_4_Fragment1() {
    }

    //    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_multiple_choice, LIST_MENU);
//        ListFragment ListFrag = (ListFragment) getFragmentManager().findFragmentById(R.id.frame);
//        ListFrag.setListAdapter(adapter);
//    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new page4_adapter();
        page_4_Fragment1 fragment1 = (page_4_Fragment1) getFragmentManager().findFragmentById(R.id.frame);
        fragment1.setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_foreground),
                "정선우", "정선우");
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_foreground),
                "안드로이드", "재밌어");
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_foreground),
                "파이썬은", "더 재밌어");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, @NonNull View v, int position, long id) {
        // get TextView's Text.
        page4_Item item = (page4_Item) l.getItemAtPosition(position);

        String titleStr = item.getTitle();
        String descStr = item.getDesc();
        Drawable iconDrawable = item.getIcon();

        // TODO : use item data.
    }

    // ... 코드 계속
    public void addItem(Drawable icon, String title, String desc) {
        adapter.addItem(icon, title, desc);
    }


    //    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.page_4_fragment1, container, false);
//        lv_1 = (ListView) view.findViewById(R.id.lv_1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(container.getContext(), android.R.layout.simple_list_item_1) ;
//        adapter.add("정정선선우우");
//        adapter.add("박박재재현현");
//        adapter.add("서서영영준준");
//        lv_1.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//        return inflater.inflate(R.layout.page_4_fragment2, container, false);
//    }


}

