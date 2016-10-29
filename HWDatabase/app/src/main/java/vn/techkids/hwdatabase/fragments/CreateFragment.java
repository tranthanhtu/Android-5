package vn.techkids.hwdatabase.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.techkids.hwdatabase.MainActivity;
import vn.techkids.hwdatabase.R;
import vn.techkids.hwdatabase.managers.DBHepler;
import vn.techkids.hwdatabase.models.ListModel;
import vn.techkids.hwdatabase.models.NoteModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateFragment extends Fragment {

    @BindView(R.id.btn_add)
    Button btn_add;

    @BindView(R.id.et_title)
    EditText et_title;
    @BindView(R.id.et_content)
    EditText et_content;
    @BindView(R.id.et_create_time)
    EditText et_create_time;

    public CreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create, container, false);
        ButterKnife.bind(this, v);
        addListeners();
        return v;
    }

    private void addListeners() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteModel tempNote = new NoteModel(
                        et_title.getText().toString(),
                        et_content.getText().toString(),
                        et_create_time.getText().toString()
                );
                DBHepler.getInstance().insert(tempNote);
                ListModel.list.add(new ListModel(tempNote.getTitle()));
                ((MainActivity)getActivity()).notifiDataSetchange();
                ((MainActivity)getActivity()).reset();

                getFragmentManager().popBackStack();
            }
        });
    }

}