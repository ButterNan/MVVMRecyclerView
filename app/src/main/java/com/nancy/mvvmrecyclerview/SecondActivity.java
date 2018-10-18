package com.nancy.mvvmrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.nancy.mvvmrecyclerview.databinding.ActivitySecondBinding;
import com.nancy.mvvmrecyclerview.model.ListViewModel;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_second);

        ListViewModel list = new ListViewModel();
        list.setName("Hero");
        list.setText("Hi");

        binding.setList(list);
    }
}
