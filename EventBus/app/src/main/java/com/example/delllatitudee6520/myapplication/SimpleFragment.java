package com.example.delllatitudee6520.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.delllatitudee6520.eventbus.OpenFragmentListener;
import com.example.delllatitudee6520.eventbus.R;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static org.greenrobot.eventbus.EventBus.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends Fragment {

    @BindView(R.id.bt_OK) Button btn_ok;
    @BindColor(R.color.colorAccent) int accentColor;

    private OpenFragmentListener openFragmentListener;

    public void setOpenFragmentListener(OpenFragmentListener openFragmentListener) {
        this.openFragmentListener = openFragmentListener;
    }

    public SimpleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void setupUI() {
        btn_ok.setBackgroundColor(accentColor);
    }

    @OnClick(R.id.bt_OK)
    public void onButtonOKClick(View view){
        Log.d(TAG,"onButtonOKClick");
        if (openFragmentListener != null){
            openFragmentListener.openFragment(new VerySimpleFragment());
        }

    }


}
