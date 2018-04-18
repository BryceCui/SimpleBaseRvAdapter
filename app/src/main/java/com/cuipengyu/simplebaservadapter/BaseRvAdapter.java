package com.cuipengyu.simplebaservadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/18
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public abstract class BaseRvAdapter<T, K extends BaseRvViewHolder> extends RecyclerView.Adapter<K> {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<ItemViewType> itemViewTypes;

    public BaseRvAdapter() {
        super();
        itemViewTypes = new ArrayList<>();
    }

    @Override
    public K onCreateViewHolder(ViewGroup parent, int viewType) {
        K baseviewHolder = null;
        this.mContext = parent.getContext();
        this.mLayoutInflater = LayoutInflater.from(mContext);
        View view;
        return view;
    }

    @Override
    public void onBindViewHolder(K holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
