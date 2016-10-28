package vn.techkids.listviewsinhvien.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

import vn.techkids.listviewsinhvien.R;
import vn.techkids.listviewsinhvien.models.SinhVienModels;
import vn.techkids.listviewsinhvien.viewholders.SinhVienViewHolder;

/**
 * Created by Dell latitude E6520 on 10/28/2016.
 */

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienViewHolder> {
    @Override
    public SinhVienViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_sinhvien, parent, false);

        SinhVienViewHolder sinhVienViewHolder = new SinhVienViewHolder(view);
        return sinhVienViewHolder;
    }

    @Override
    public void onBindViewHolder(SinhVienViewHolder holder, int position) {
        SinhVienModels sinhVienModels = SinhVienModels.list.get(position);
        holder.bind(sinhVienModels);
    }

    @Override
    public int getItemCount() {
        return SinhVienModels.list.size();
    }
}
