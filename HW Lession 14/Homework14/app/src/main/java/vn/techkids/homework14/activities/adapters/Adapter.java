package vn.techkids.homework14.activities.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nostra13.universalimageloader.core.ImageLoader;

import vn.techkids.homework14.R;
import vn.techkids.homework14.activities.activities.MainActivity;
import vn.techkids.homework14.activities.models.Menu;
import vn.techkids.homework14.activities.viewholders.MenuViewHolder;

/**
 * Created by Dell latitude E6520 on 10/25/2016.
 */

public class Adapter extends RecyclerView.Adapter<MenuViewHolder> {
    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View menuView = layoutInflater.inflate(R.layout.menu_list, parent, false);

        MenuViewHolder menuViewHolder = new MenuViewHolder(menuView);
        return menuViewHolder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        Menu menu = Menu.list.get(position);
        holder.bind(menu);
        
    }

    @Override
    public int getItemCount() {
        return Menu.list.size();
    }
}
