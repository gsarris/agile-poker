package com.sarris.poker.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.sarris.models.Card;
import com.sarris.poker.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by georgiossarris on 15/07/16.
 */

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.RecyclerViewHolders> {

    private final List<Card> cards;
    private final Context context;

    public CardListAdapter(Context context, List<Card> cards) {
        this.cards = cards;
        this.context = context;
    }

    @Override
    public CardListAdapter.RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        int number = cards.get(position).getNumber();
        String stringedNumber = String.valueOf(number);
        if (number == -1) {
            stringedNumber = "1/2";
        }
        holder.textView.setTag(number);
        holder.textView.setText(stringedNumber);
        holder.textView.setBackgroundColor(ContextCompat.getColor(context, cards.get(position).getColorHex()));
    }

    @Override
    public int getItemCount() {
        return this.cards.size();
    }

    class RecyclerViewHolders extends RecyclerView.ViewHolder {

        @BindView(R.id.textView)
        TextView textView;

        RecyclerViewHolders(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
