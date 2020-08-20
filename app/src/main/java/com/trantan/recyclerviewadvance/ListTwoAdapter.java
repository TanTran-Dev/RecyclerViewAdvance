package com.trantan.recyclerviewadvance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListTwoAdapter extends RecyclerView.Adapter<ListTwoAdapter.TypeTwoViewHolder> {
    private Context context;
    private List<String> typeTwoList;

    public ListTwoAdapter(Context context, List<String> typeTwoList) {
        this.context = context;
        this.typeTwoList = typeTwoList;
    }

    @NonNull
    @Override
    public TypeTwoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.type_2, parent, false);
        return new TypeTwoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeTwoViewHolder holder, int position) {
        holder.tvAccount.setText(typeTwoList.get(position));
    }

    @Override
    public int getItemCount() {
        return typeTwoList.size();
    }

    static class TypeTwoViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvAccount)
        TextView tvAccount;
        public TypeTwoViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
