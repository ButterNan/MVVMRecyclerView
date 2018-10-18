package com.nancy.mvvmrecyclerview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.nancy.mvvmrecyclerview.MainActivity;
import com.nancy.mvvmrecyclerview.R;
import com.nancy.mvvmrecyclerview.SecondActivity;
import com.nancy.mvvmrecyclerview.databinding.ListRowBinding;
import com.nancy.mvvmrecyclerview.model.ListViewModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private List<ListViewModel> itemList;
    private LayoutInflater layoutInflater;
    private ListListener listener;
    MainActivity.MyClickHandlers click;

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        //holder.binding.setList(itemList.get(position));
        holder.bind(itemList.get(position));


                //setListViewModel(itemList.get(position));


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public RecyclerViewAdapter(List<ListViewModel> postList, ListListener listener, MainActivity.MyClickHandlers click) {
        this.itemList = postList;
        this.listener = listener;
        this.click = click;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ListRowBinding binding = ListRowBinding.inflate(layoutInflater,parent,false);
               // DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new RecyclerViewHolder(binding,listener);
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }

        private ListRowBinding binding;
        private ListListener listener;
        Context context;
        public RecyclerViewHolder(final ListRowBinding itemBinding, final ListListener listener) {
            super(itemBinding.getRoot());
           this.binding = itemBinding;
           this.listener=listener;
           context=binding.getRoot().getContext();

           binding.button.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   listener.onButtonClick(view,getAdapterPosition());
               }
           });

           //binding.getHandlers().onFabClicked(view);

           binding.getRoot().setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   listener.onRowClicked(view,getAdapterPosition());
               }
           });

           binding.setHandle(click);
        }

        public void bind(ListViewModel list) {
             binding.setList(list);
//            binding.setVariable(BR.text, obj);
            //binding.setHandle(click);

            binding.executePendingBindings();



        }


    }

    public interface ListListener {
        void onRowClicked(View v,int position);
        void onButtonClick(View v,int position);
    }
}

