package com.example.tu.homeworkss15_daily_quote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.hau.homeworkss15_daily_quote.R;
import com.example.tu.homeworkss15_daily_quote.managers.Preferrences;
import com.example.tu.homeworkss15_daily_quote.models.FragmentEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    @BindView(R.id.et_username)
    EditText etUsername;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.bt_save)
    public void onClick(View view) {
        String username = etUsername.getText().toString();

        Preferrences.getInstance().putUsername(username);

        EventBus.getDefault().post(new FragmentEvent(new QuoteFragment(), false));
    }

}
