package com.nancy.mvvmrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nancy.mvvmrecyclerview.Adapter.RecyclerViewAdapter;
import com.nancy.mvvmrecyclerview.model.ListViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ListListener {

    private RecyclerViewAdapter mAdapter;
    private RecyclerView recyclerView;
    //private ListItemBinding binding;
    private ListViewModel user;

    @Override
    public void onRowClicked(ListViewModel post) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new RecyclerViewAdapter(getList());
        recyclerView.setAdapter(mAdapter);
    }


    public ArrayList<ListViewModel> getList(){
        ArrayList<ListViewModel> l=new ArrayList<>();
   ListViewModel item=new ListViewModel("nancy","hi","12:00");
   l.add(item);
   return l;

    }
}
