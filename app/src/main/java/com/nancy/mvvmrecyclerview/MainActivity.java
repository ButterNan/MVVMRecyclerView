package com.nancy.mvvmrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.nancy.mvvmrecyclerview.Adapter.RecyclerViewAdapter;
import com.nancy.mvvmrecyclerview.model.ListViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private RecyclerViewAdapter mAdapter;
    private RecyclerView recyclerView;
    //private ListItemBinding binding;
    private ListViewModel user;
    private RecyclerViewAdapter.ListListener listener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        listener = new RecyclerViewAdapter.ListListener() {
            @Override
            public void onRowClicked(View v, int position) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
               String name = getList().get(position).getName();
               Bundle bun= new Bundle();
               bun.putString("Name",name);
           intent.putExtras(bun);
                startActivity(intent);

            }

            @Override
            public void onButtonClick(View v, int position) {
                Toast.makeText(getApplicationContext(), "Button is clicked!" + position , Toast.LENGTH_SHORT).show();
            }
        };

        mAdapter = new RecyclerViewAdapter(getList(), listener);



        recyclerView.setAdapter(mAdapter);
    }


    public ArrayList<ListViewModel> getList(){
        ArrayList<ListViewModel> l=new ArrayList<>();
        ListViewModel l1=new ListViewModel();
        l1.time.set("12:00");
        l1.setText("Hi");
        l1.setName("Nancy");

        ListViewModel l2=new ListViewModel();
        l2.time.set("1:00");
        l2.setText("Hi bye");
        l2.setName("Adi");

//   ListViewModel item=new ListViewModel("nancy","hi", l1);
   l.add(l1);
   l.add(l2);
   return l;

    }

//    public class MyClickHandlers {
//
//        Context context;
//
//        public MyClickHandlers(Context context) {
//            this.context = context;
//        }
//
//        public void onButtonClicked(View view) {
//            Toast.makeText(context, "Posts is clicked!", Toast.LENGTH_SHORT).show();
//        }
//    }
}
