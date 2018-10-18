package com.nancy.mvvmrecyclerview.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;


import com.nancy.mvvmrecyclerview.BR;

public class ListViewModel extends BaseObservable {

    String name;
    String text;
    String time;

    public ListViewModel(String name, String text, String time) {
        this.name = name;
        this.text = text;
        this.time = time;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }


    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }


    @Bindable
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
        notifyPropertyChanged(BR.time);
    }
}
