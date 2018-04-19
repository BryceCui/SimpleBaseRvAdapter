package com.cuipengyu.simplebaservadapter;

import android.view.View;
import android.widget.Toast;

import java.util.List;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/13
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public class RecycleViewAdapter extends BaseComRvAdapter implements View.OnClickListener {

    RecycleViewAdapter( List<Integer> data) {
        super(R.layout.item_rv,data);
    }

    @Override
    public void onBindView(BaseRvViewHolder holder, Object p) {
        holder.setText(R.id.list_item,String.valueOf(p));

    }

    @Override
    public View getContentView(BaseRvViewHolder holder) {
        return holder.getView(R.id.item_connext);
    }

    @Override
    public int getMenuWidth(BaseRvViewHolder holder) {
        return holder.getView(R.id.more).getWidth()+holder.getView(R.id.delete).getWidth();
    }


    @Override
    public void onClick(View v) {
         Toast.makeText(getParntContext(), "itemView", Toast.LENGTH_SHORT).show();
    }

}
