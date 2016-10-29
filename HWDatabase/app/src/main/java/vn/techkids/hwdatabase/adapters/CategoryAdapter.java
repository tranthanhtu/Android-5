package vn.techkids.hwdatabase.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.techkids.hwdatabase.R;
import vn.techkids.hwdatabase.models.ListModel;
import vn.techkids.hwdatabase.viewholders.CategoryViewHolder;

/**
 * Created by Dell latitude E6520 on 10/29/2016.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {


    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 1 Inflate View
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_category, parent, false);

        // 2 Create View Holder
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(itemView);

        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        ListModel categoryModel = ListModel.list.get(position);
        holder.bind(categoryModel);
    }

    @Override
    public int getItemCount() {
        return ListModel.list.size();
    }
}