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

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_ONE = 0;
    public static final int TYPE_TWO = 1;
    private List<String> typeOneList;
    private List<String> typeTwoList;
    private Context context;

    public MainAdapter(Context context, List<String> typeOneList, List<String> typeTwoList) {
        this.context = context;
        this.typeOneList = typeOneList;
        this.typeTwoList = typeTwoList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_ONE: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.type_1, parent, false);
                return new TypeOneViewHolder(view);
            }

            case TYPE_TWO:{
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.type_2, parent,false);
                return new TypeTwoViewHolder(view);
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TypeOneViewHolder){
            TypeOneViewHolder typeOneViewHolder = (TypeOneViewHolder) holder;
            typeOneViewHolder.tvContact.setText(typeOneList.get(position));
        }else if (holder instanceof TypeTwoViewHolder){
            TypeTwoViewHolder typeTwoViewHolder = (TypeTwoViewHolder) holder;
            typeTwoViewHolder.tvAccount.setText(typeTwoList.get(position - typeOneList.size()));
        }
    }

    @Override
    public int getItemCount() {
        return typeOneList.size() + typeTwoList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= 0 && position < typeOneList.size()){
            return TYPE_ONE;
        }else {
            return TYPE_TWO;
        }
    }

    static class TypeOneViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvContact)
        TextView tvContact;

        public TypeOneViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class TypeTwoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvAccount)
        TextView tvAccount;

        public TypeTwoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
