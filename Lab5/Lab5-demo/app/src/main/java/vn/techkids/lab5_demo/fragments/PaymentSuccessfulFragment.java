package vn.techkids.lab5_demo.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.techkids.lab5_demo.MainActivity;
import vn.techkids.lab5_demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentSuccessfulFragment extends Fragment {

    @BindView(R.id.imageView)
    ImageView imageView;
    public PaymentSuccessfulFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity)getActivity()).showActionBar(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment_successful, container, false);
        ButterKnife.bind(this, view);
        successfulClick();
        return view;
    }

    private void successfulClick() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
