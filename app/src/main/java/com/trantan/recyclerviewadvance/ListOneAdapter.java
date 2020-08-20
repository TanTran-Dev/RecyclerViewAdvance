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

public class ListOneAdapter extends RecyclerView.Adapter<ListOneAdapter.TypeOneViewHolder> {
    private Context context;
    private List<String> typeOneList;

    public ListOneAdapter(Context context, List<String> typeOneList) {
        this.context = context;
        this.typeOneList = typeOneList;
    }

    @NonNull
    @Override
    public TypeOneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.type_1, parent, false);
        return new TypeOneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeOneViewHolder holder, int position) {
        holder.tvContact.setText(typeOneList.get(position));
    }

    @Override
    public int getItemCount() {
        return typeOneList.size();
    }

    static class TypeOneViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvContact)
        TextView tvContact;
        public TypeOneViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
