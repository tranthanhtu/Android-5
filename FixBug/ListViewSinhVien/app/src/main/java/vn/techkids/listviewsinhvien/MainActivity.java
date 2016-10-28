package vn.techkids.listviewsinhvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import vn.techkids.listviewsinhvien.adapters.SinhVienAdapter;
import vn.techkids.listviewsinhvien.managers.DbHelper;
import vn.techkids.listviewsinhvien.models.SinhVienModels;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_listsinhvien)
    RecyclerView rvListSinhVien;
    @BindView(R.id.edt_hoten)
    EditText edtHoten;
    @BindView(R.id.edt_mssv)
    EditText edtMssv;
    @BindView(R.id.edt_lop)
    EditText edtLop;
    @BindView(R.id.btn_save)
    Button btnSave;

    private SinhVienAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        onSave();

    }

    @OnClick(R.id.btn_save)
    public void onSave(){
        SinhVienModels addSV = new SinhVienModels(
                edtHoten.getText().toString(),
                edtMssv.getText().toString(),
                edtLop.getText().toString()
        );
        DbHelper.getInstance().insert(addSV);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    }



    private void setupUI() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rvListSinhVien.setLayoutManager(layoutManager);

        adapter = new SinhVienAdapter();
        rvListSinhVien.setAdapter(adapter);
    }
}
