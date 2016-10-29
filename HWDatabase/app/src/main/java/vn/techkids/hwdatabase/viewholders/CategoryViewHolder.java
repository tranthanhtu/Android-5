package vn.techkids.hwdatabase.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.techkids.hwdatabase.R;
import vn.techkids.hwdatabase.models.ListModel;

/**
 * Created by Dell latitude E6520 on 10/29/2016.
 */

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_title)
    TextView tv;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(ListModel categoryModel) {
        tv.setText(categoryModel.getTitle());
    }
}
