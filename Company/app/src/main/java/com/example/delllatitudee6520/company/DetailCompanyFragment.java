package com.example.delllatitudee6520.company;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCompanyFragment extends Fragment {
    TextView tvname;
    TextView tvphone;
    TextView tvwebside;
    private Company company;

    public DetailCompanyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_company, container, false);
        getReferences(view);
        setupUI();
        addListeners();

        return view;
    }

    public void setCompany(Company company){
        this.company = company;
    }

    private void addListeners() {
        tvwebside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(company.getWebside()));
                startActivity(intent);
            }
        });

        tvphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+company.getPhone()));
                startActivity(intent);
            }
        });
    }

    private void setupUI() {
        tvname.setText(company.getName());
        tvphone.setText(company.getPhone());
        tvwebside.setText(company.getWebside());

    }

    private void getReferences(View view) {
        tvname = (TextView) view.findViewById(R.id.tvName);
        tvphone = (TextView) view.findViewById(R.id.tvPhone);
        tvwebside = (TextView) view.findViewById(R.id.tvWebside);

    }

}
