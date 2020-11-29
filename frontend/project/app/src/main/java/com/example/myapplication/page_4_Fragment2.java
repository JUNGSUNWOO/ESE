package com.example.myapplication;

import android.app.Fragment;
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

public class page_4_Fragment2 extends ListFragment {
    static final String[] LIST_MENU = {"박재현", "박재현", "박재현", "박재현"};
    page4_adapter adapter;

    public page_4_Fragment2() {
    }

    //    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_single_choice, LIST_MENU);
//        ListFragment ListFrag = (ListFragment)getFragmentManager().findFragmentById(R.id.frame);
//        ListFrag.setListAdapter(adapter);
//    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new page4_adapter();
        page_4_Fragment2 fragment2 = (page_4_Fragment2) getFragmentManager().findFragmentById(R.id.frame);
        fragment2.setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_foreground),
                "정선우", "정선우");
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_foreground),
                "Circle", "Account Circle Black 36dp");
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_foreground),
                "Ind", "Assignment Ind Black 36dp");
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

}