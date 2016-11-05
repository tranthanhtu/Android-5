package com.example.tu.homeworkss15_daily_quote.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hau.homeworkss15_daily_quote.R;
import com.example.tu.homeworkss15_daily_quote.models.Quote;
import com.example.tu.homeworkss15_daily_quote.viewholders.QuoteViewHolder;

/**
 * Created by Hau on 25/10/2016.
 */
public class QuoteAdapter extends RecyclerView.Adapter<QuoteViewHolder> {
    @Override
    public QuoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_quote, parent, false);

        QuoteViewHolder quoteViewHolder = new QuoteViewHolder(view);
        return quoteViewHolder;
    }

    @Override
    public void onBindViewHolder(QuoteViewHolder holder, int position) {
        Quote quote = Quote.list.get(position);

        holder.bind(quote);
    }

    @Override
    public int getItemCount() {
        return Quote.list.size();
    }
}
