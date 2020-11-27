package com.example.myapplication;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class page_4_Fragment2 extends ListFragment {
    private ListView lv_2;
    public page_4_Fragment2() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_4_fragment2, container, false);
        lv_2 = (ListView) view.findViewById(R.id.lv_2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(container.getContext(), android.R.layout.simple_list_item_1) ;
        adapter.add("정정선선우우");
        adapter.add("박박재재현현");
        adapter.add("서서영영준준");
        adapter.add("정정선선우우");
        adapter.add("박박재재현현");
        adapter.add("서서영영준준");
        lv_2.setAdapter(adapter) ;
        adapter.notifyDataSetChanged();
        return inflater.inflate(R.layout.page_4_fragment2, container, false);
    }


}

