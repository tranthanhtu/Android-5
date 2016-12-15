package com.example.haduo.networking.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.haduo.networking.R;
import com.example.haduo.networking.models.Post;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dell latitude E6520 on 10/23/2016.
 */

public class PostViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Post post){
        tvTitle.setText(post.getTitle());
        tvContent.setText(post.getContent());
    }
}
