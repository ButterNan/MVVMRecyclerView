package com.nancy.mvvmrecyclerview.Adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.nancy.mvvmrecyclerview.R;
import com.nancy.mvvmrecyclerview.databinding.ListRowBinding;
import com.nancy.mvvmrecyclerview.model.ListViewModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private List<ListViewModel> itemList;
    private LayoutInflater layoutInflater;
    private ListListener listener;

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.binding.setList(itemList.get(position));
                //setListViewModel(itemList.get(position));


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public RecyclerViewAdapter(List<ListViewModel> postList) {
        this.itemList = postList;
        //this.listener = listener;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ListRowBinding binding = ListRowBinding.inflate(layoutInflater,parent,false);
               // DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new RecyclerViewHolder(binding);
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{
        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }

        private ListRowBinding binding;
        public RecyclerViewHolder(final ListRowBinding itemBinding) {
            super(itemBinding.getRoot());
           this.binding = itemBinding;
        }
    }

    public interface ListListener {
        void onRowClicked(ListViewModel post);
    }
}
