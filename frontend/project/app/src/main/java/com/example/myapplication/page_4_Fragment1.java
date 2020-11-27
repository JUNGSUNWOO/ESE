package com.example.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.ListFragment;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class page_4_Fragment1 extends Fragment {
    public page_4_Fragment1(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.page_4_fragment1, container, false);
    }
}