package com.example.administrator.myapplication.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/8/3 0003.
 */
public abstract class TheBaseAdapter<T> extends BaseAdapter {
    List<T> list = new ArrayList<>();
    Inflater inflater;

    public Inflater getInflater() {
        return inflater;
    }

    public TheBaseAdapter(List<T> list, Inflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemView(i,view,viewGroup);
    }
    public abstract View getItemView(int position,View view , ViewGroup viewGroup);
}
