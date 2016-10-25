package com.example.haduo.networking.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haduo.networking.R;
import com.example.haduo.networking.models.Post;
import com.example.haduo.networking.viewholders.PostViewHolder;

/**
 * Created by Dell latitude E6520 on 10/23/2016.
 */

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    //creat new
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1 Inflate view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_post, parent, false);

        //2 Creat ViewHolder
        PostViewHolder postViewHolder = new PostViewHolder(itemView);
        return postViewHolder;
    }
    //update
    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        //Model
        Post post = Post.list.get(position);
        holder.bind(post);

    }
    //get cound
    @Override
    public int getItemCount() {
        return Post.list.size();
    }
}
