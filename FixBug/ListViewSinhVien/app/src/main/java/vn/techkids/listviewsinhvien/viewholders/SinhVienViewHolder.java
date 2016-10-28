package vn.techkids.listviewsinhvien.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.techkids.listviewsinhvien.R;
import vn.techkids.listviewsinhvien.models.SinhVienModels;

/**
 * Created by Dell latitude E6520 on 10/28/2016.
 */

public class SinhVienViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_id)
    TextView tvId;
    @BindView(R.id.tv_hoten)
    TextView tvHoten;
    @BindView(R.id.tv_mssv)
    TextView tvMssv;
    @BindView(R.id.tv_lop)
    TextView tvLop;
    public SinhVienViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(SinhVienModels sinhVienModels){
        tvId.setText(String.valueOf(sinhVienModels.getId()));
        tvHoten.setText(sinhVienModels.getHoten());
        tvMssv.setText(String.valueOf(sinhVienModels.getMssv()));
        tvLop.setText(sinhVienModels.getLop());
    }
}
