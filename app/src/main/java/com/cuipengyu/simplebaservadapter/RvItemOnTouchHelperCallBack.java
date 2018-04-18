package com.cuipengyu.simplebaservadapter;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import static com.cuipengyu.simplebaservadapter.RvItemTouchHelper.ACTION_STATE_SWIPE;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/13
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public abstract class RvItemOnTouchHelperCallBack extends RvItemTouchHelper.Callback {
    private RvItemHelperInterface mAnInterface;

    RvItemOnTouchHelperCallBack(RvItemHelperInterface mAnInterface) {
        this.mAnInterface = mAnInterface;
    }

    /**
     * Callback回调监听时先调用的，用来判断当前是什么动作，比如判断方向
     * 作用：哪个方向的拖动
     *
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
//        //我要监听的拖拽方向是哪个方向
        int dragFlags = RvItemTouchHelper.UP | RvItemTouchHelper.DOWN;
//        //我要监听的swipe侧滑方向是哪个方向
//        int swipeFlags = RvItemTouchHelper.LEFT | RvItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags, getSwipeFlags());
    }

    /**
     * @param recyclerView 当上下移动的时候回调的方法
     * @param viewHolder   被拖拽的条目所持有的viewHolder
     * @param target       目标条目所持有的viewHolder
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mAnInterface.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    /**
     * 是否打开长按拖拽效果
     *
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return isLongEnabled();
    }

    /**
     * 是否打开侧滑删除效果
     *
     * @return
     */
    @Override
    public boolean isItemViewSwipeEnabled() {
        return isSwipeEnabled();
    }

    /**
     * 侧滑删除调用
     *
     * @param viewHolder The ViewHolder which has been swiped by the user.
     * @param direction  The direction to which the ViewHolder is swiped. It is one of
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//        mAnInterface.onItemRemove(viewHolder.getAdapterPosition());
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);

    }

    //防止复用出现问题
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
    }

    /**
     * 效果绘制，重绘时调用
     *
     * @param c                 The canvas which RecyclerView is drawing its children
     * @param recyclerView      The RecyclerView to which ItemTouchHelper is attached to
     * @param viewHolder        The ViewHolder which is being interacted by the User or it was
     *                          interacted and simply animating to its original position
     * @param dX                The amount of horizontal displacement caused by user's action
     * @param dY                The amount of vertical displacement caused by user's action
     * @param actionState       The type of interaction on the View. Is either {@link
     * @param isCurrentlyActive True if this view is currently being controlled by the user or
     *                          false it is simply animating back to its original state.
     */
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        //如果是侧滑行为
        if (actionState == ACTION_STATE_SWIPE) {
            int translax = mAnInterface.getMenuWidth(viewHolder); //获取菜单的宽度
            View contentView = mAnInterface.getContentView(viewHolder);//获取view的宽度
            if (contentView == null) return;
            Log.e("translax-----",translax+"");
            if (dX < -translax) {//向左滑动dx是小于的 ，最大滑动距离当然不能超过菜单宽度了
                dX = -translax;
//                Log.e("dX1-----",dX+"");
                contentView.setTranslationX(dX);
            } else {
                Log.e("dX2-----",dX+"");
                contentView.setTranslationX(dX);
            }
        } else {
//            Log.e("dX3-----",dX+"");
            //不是侧滑，可能是长按拖拽也可能是上下滑动，点击啊 什么动作的执行原来的行为。
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    }

    public abstract boolean isSwipeEnabled();

    public abstract boolean isLongEnabled();


    public abstract int getSwipeFlags();
}
