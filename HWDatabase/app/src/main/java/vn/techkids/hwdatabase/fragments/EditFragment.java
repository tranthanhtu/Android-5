package vn.techkids.hwdatabase.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
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
import vn.techkids.hwdatabase.models.NoteModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditFragment extends Fragment {


    @BindView(R.id.btn_save)
    Button btn_save;

    @BindView(R.id.et_title)
    EditText et_title;
    @BindView(R.id.et_content)
    EditText et_content;
    @BindView(R.id.et_create_time)
    EditText et_create_time;


    public EditFragment(){

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_edit, container, false);
        ButterKnife.bind(this, v);
        setupUI();
        addListeners();
        return v;
    }

    private void setupUI() {
        NoteModel tempNote = ((MainActivity)getActivity()).getNote();
        et_title.setText(tempNote.getTitle());
        et_content.setText(Html.fromHtml(tempNote.getContent()));
        et_create_time.setText(tempNote.getTime_created());
    }


    private void addListeners() {
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteModel noteModel = new NoteModel(
                        ((MainActivity)getActivity()).getNote().getId(),
                        et_title.getText().toString(),
                        et_content.getText().toString(),
                        et_create_time.getText().toString()
                );
                DBHepler.getInstance().update(noteModel);
                ((MainActivity)getActivity()).reset();
                getFragmentManager().popBackStack();
            }
        });

    }

}
