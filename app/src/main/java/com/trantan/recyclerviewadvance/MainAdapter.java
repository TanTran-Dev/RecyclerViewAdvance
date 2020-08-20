package com.trantan.recyclerviewadvance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_LIST_ONE = 0;
    public static final int TYPE_LIST_TWO = 1;
    private List<String> typeOneList;
    private List<String> typeTwoList;

    private ListOneAdapter listOneAdapter;
    private ListTwoAdapter listTwoAdapter;
    private Context context;

    public MainAdapter(Context context, List<String> typeOneList, List<String> typeTwoList) {
        this.context = context;
        this.typeOneList = typeOneList;
        this.typeTwoList = typeTwoList;
        this.listOneAdapter = new ListOneAdapter(context, typeOneList);
        this.listTwoAdapter = new ListTwoAdapter(context, typeTwoList);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_LIST_ONE: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_list_1, parent, false);
                return new ListOneViewHolder(view);
            }

            case TYPE_LIST_TWO:{
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_list_2, parent,false);
                return new ListTwoViewHolder(view);
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ListOneViewHolder){
            ListOneViewHolder typeOneViewHolder = (ListOneViewHolder) holder;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
            typeOneViewHolder.rclList1.setLayoutManager(linearLayoutManager);
            typeOneViewHolder.rclList1.setAdapter(listOneAdapter);
        }else if (holder instanceof ListTwoViewHolder){
            ListTwoViewHolder listTwoViewHolder = (ListTwoViewHolder) holder;
            listTwoViewHolder.rclList2.setLayoutManager(new LinearLayoutManager(context));
            listTwoViewHolder.rclList2.setAdapter(listTwoAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return TYPE_LIST_ONE;
        }else {
            return TYPE_LIST_TWO;
        }
    }

    static class ListOneViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rclList1)
        RecyclerView rclList1;

        public ListOneViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ListTwoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rclList2)
        RecyclerView rclList2;

        public ListTwoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
