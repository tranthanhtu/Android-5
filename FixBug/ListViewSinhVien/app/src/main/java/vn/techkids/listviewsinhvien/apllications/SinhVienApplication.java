package vn.techkids.listviewsinhvien.apllications;

import android.app.Application;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import vn.techkids.listviewsinhvien.R;
import vn.techkids.listviewsinhvien.managers.DbHelper;
import vn.techkids.listviewsinhvien.models.SinhVienModels;

/**
 * Created by Dell latitude E6520 on 10/28/2016.
 */

public class SinhVienApplication extends Application {
    @BindView(R.id.edt_hoten)
    EditText edtHoten;
    @BindView(R.id.edt_mssv)
    EditText edtMssv;
    @BindView(R.id.edt_lop)
    EditText edtLop;
    @BindView(R.id.btn_save)
    Button btnSave;
    @Override
    public void onCreate() {
        super.onCreate();
        DbHelper.init(this);
        DbHelper.getInstance().selectAllSinhVien().toString();
    }

}
