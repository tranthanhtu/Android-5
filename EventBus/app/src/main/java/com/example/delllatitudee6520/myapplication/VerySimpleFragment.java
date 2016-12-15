package com.example.delllatitudee6520.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.delllatitudee6520.eventbus.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class VerySimpleFragment extends Fragment {


    public VerySimpleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_very_simple, container, false);
    }

}
