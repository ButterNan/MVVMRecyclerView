package com.nancy.mvvmrecyclerview.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;


import com.nancy.mvvmrecyclerview.BR;

public class ListViewModel extends BaseObservable {

    String name;
    String text;
    //String time;

    public static ObservableField<String> time = new ObservableField<>();

    public ListViewModel(String name, String text, ObservableField<String> time) {
        this.name = name;
        this.text = text;
        this.time = time;
    }


    public ListViewModel() {
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


//    @Bindable
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//        notifyPropertyChanged(BR.time);
//    }

    public ObservableField<String> getTime() {
        return time;
    }
}
