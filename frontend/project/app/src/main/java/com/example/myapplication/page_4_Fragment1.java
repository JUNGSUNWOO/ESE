package com.example.myapplication;

import android.app.Fragment;
import android.app.ListFragment;
import android.icu.text.ListFormatter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class page_4_Fragment1 extends ListFragment {
    static final String[] LIST_MENU = {"정선우", "정선우","정선우", "정선우","정선우", "정선우"};
    public page_4_Fragment1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, LIST_MENU);
        ListFragment ListFrag = (ListFragment)getFragmentManager().findFragmentById(R.id.frame);
        ListFrag.setListAdapter(adapter);
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

