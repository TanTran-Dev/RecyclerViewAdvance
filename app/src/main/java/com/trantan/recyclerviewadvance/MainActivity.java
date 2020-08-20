package com.trantan.recyclerviewadvance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private MainAdapter adapter;

    private List<String> typeOneList;
    private List<String> typeTwoList;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        addTypeList1();
        addTypeList2();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(this, typeOneList, typeTwoList);
        recyclerView.setAdapter(adapter);
    }

    private void addTypeList1() {
        typeOneList = new ArrayList<>();
        typeOneList.add("type 1 1");
        typeOneList.add("type 1 2");
        typeOneList.add("type 1 3");
        typeOneList.add("type 1 4");
        typeOneList.add("type 1 5");
    }

    private void addTypeList2() {
        typeTwoList = new ArrayList<>();
        typeTwoList.add("type 2 1");
        typeTwoList.add("type 2 2");
        typeTwoList.add("type 2 3");
        typeTwoList.add("type 2 4");
        typeTwoList.add("type 2 5");
    }
}