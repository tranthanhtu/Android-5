package com.example.delllatitudee6520.company;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CompanyListActivity extends AppCompatActivity {

    ListView lvCompany;

    List<Company> listCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
        initData();
        getReferences();
        setupUI();
        addListeners();
    }

    private void setupUI() {
        ArrayAdapter<Company> companyArrayAdapter = new ArrayAdapter<Company>(this, android.R.layout.simple_list_item_1, listCompany);

        lvCompany.setAdapter(companyArrayAdapter);

    }

    private void initData() {
        listCompany = Company.getCompanyList();

    }

    private void getReferences() {
        lvCompany = (ListView) findViewById(R.id.lv_company);

    }

    private void addListeners() {
        lvCompany.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Company contact = listCompany.get(position);
                if (findViewById(R.id.fl_container) == null) {

                    DetailCompanyFragment companyDetailFragment = new DetailCompanyFragment();
                    companyDetailFragment.setCompany(contact);

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.replace(R.id.fl_container_detail, companyDetailFragment);
                    fragmentTransaction.commit();

                }else {
                    DetailCompanyFragment companyDetailFragment = new DetailCompanyFragment();
                    companyDetailFragment.setCompany(contact);

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.replace(R.id.fl_container, companyDetailFragment);
                    fragmentTransaction.commit();

                }
            }
        });
    }
}
