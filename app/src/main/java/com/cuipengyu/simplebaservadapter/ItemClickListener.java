package com.cuipengyu.simplebaservadapter;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/19
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ： recyclerview 点击事件
 */
public class ItemClickListener extends RecyclerView.SimpleOnItemTouchListener {
    private onItemClickListener clickListener;
    private onItemLongClickListener clickLongListener;
    private GestureDetectorCompat gestureDetector;

    public ItemClickListener(final RecyclerView recyclerView, onItemClickListener listener) {
        this.clickListener = listener;
        gestureDetector = new GestureDetectorCompat(recyclerView.getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childView != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                    clickListener.onItemClick(childView, recyclerView.getChildAdapterPosition(childView));
                }
                return true;
            }


        });
    }
    public ItemClickListener(final RecyclerView recyclerView, onItemLongClickListener listener) {
        this.clickLongListener = listener;
        gestureDetector = new GestureDetectorCompat(recyclerView.getContext(), new GestureDetector.SimpleOnGestureListener() {

            @Override
            public void onLongPress(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childView != null && clickListener != null) {
                    clickLongListener.onItemLongClick(childView, recyclerView.getChildAdapterPosition(childView));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        super.onTouchEvent(rv, e);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.onRequestDisallowInterceptTouchEvent(disallowIntercept);
    }

    /**
     * 监听接口
     */
    public interface onItemClickListener {

        void onItemClick(View view, int position);

    }
    public interface onItemLongClickListener {

        void onItemLongClick(View view, int position);

    }
}
