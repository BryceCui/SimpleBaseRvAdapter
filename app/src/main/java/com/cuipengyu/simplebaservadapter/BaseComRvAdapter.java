package com.cuipengyu.simplebaservadapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/18
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public abstract class BaseComRvAdapter<T> extends RecyclerView.Adapter<BaseRvViewHolder> implements RvItemHelperInterface {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<T> mData;
    private int mLayoutId;


    public BaseComRvAdapter(@LayoutRes int layoutId, List<T> mData) {
        this.mData = mData;
        this.mLayoutId = layoutId;
    }

    @Override
    public BaseRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        this.mLayoutInflater = LayoutInflater.from(mContext);
        View view=mLayoutInflater.inflate(mLayoutId, parent, false);
        return new BaseRvViewHolder(view);

    }

    @Override
    public void onBindViewHolder(BaseRvViewHolder holder, int position) {
        onBindView(holder, mData.get(position));
    }

    public abstract void onBindView(BaseRvViewHolder holder, T p);

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * 移动item所需要调用的方法
     *
     * @param fromPostion
     * @param toPostion
     */
    @Override
    public void onItemMove(int fromPostion, int toPostion) {
        Collections.swap(mData, fromPostion, toPostion);
        notifyItemMoved(fromPostion, toPostion);
    }

    /**
     * 删除item所需要调用的方法
     *
     * @param Postion
     */
    @Override
    public void onItemRemove(int Postion) {
        mData.remove(Postion);
        notifyItemRemoved(Postion);

    }

    public Context getParntContext() {
        return mContext;
    }

}
