package com.cuipengyu.simplebaservadapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/13
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> implements RvItemHelperInterface {
    List<Integer> mData;
    Context mContext;

    RecycleViewAdapter(Context context, List<Integer> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_rv, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,  int position) {
        holder.contentTv.setText(String.valueOf(mData.get(position)));
        holder.itemView.setBackgroundColor(Color.RED);
        holder.deleteTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemRemove(holder.getAdapterPosition());
            }
        });

        holder.moreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });



    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public void onItemMove(int fromPostion, int toPostion) {
        Collections.swap(mData,fromPostion,toPostion);
        notifyItemMoved(fromPostion,toPostion);
    }

    @Override
    public void onItemRemove(int Postion) {
       mData.remove(Postion);
       notifyItemRemoved(Postion);
    }

    @Override
    public View getContentView(RecyclerView.ViewHolder holder) {
        ViewHolder messageHolder = (ViewHolder) holder;
        return messageHolder.item_connext;
    }

    @Override
    public int getMenuWidth(RecyclerView.ViewHolder holder) {
        ViewHolder messageHolder = (ViewHolder) holder;
        return messageHolder.moreTv.getWidth() + messageHolder.deleteTv.getWidth();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView contentTv;
        public TextView deleteTv;
        public TextView moreTv;
        public LinearLayout mLinearLayout;
        public ImageView duo_a;
        public RelativeLayout item_connext;

        public ViewHolder(View itemView) {
            super(itemView);
            contentTv = itemView.findViewById(R.id.list_item);
            deleteTv = itemView.findViewById(R.id.delete);
            moreTv = itemView.findViewById(R.id.more);
            item_connext = itemView.findViewById(R.id.item_connext);
            duo_a = (ImageView) itemView.findViewById(R.id.duo_a);
            mLinearLayout = itemView.findViewById(R.id.delete_layout);
        }
    }


}
