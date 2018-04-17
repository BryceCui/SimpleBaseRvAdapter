package com.cuipengyu.simplebaservadapter;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/17
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public class RvItemCallBack extends RvItemOnTouchHelperCallBack {
    public final static int RVHELPER_LEFT_RIGHT = RvItemTouchHelper.LEFT | RvItemTouchHelper.RIGHT;
    public final static int RVHELPER_RIGHT = RvItemTouchHelper.RIGHT;
    private boolean swipeEnabled = false;
    private boolean longEnabled = false;
    private int swipeFlags = RvItemTouchHelper.LEFT;

    RvItemCallBack(RvItemHelperInterface mAnInterface) {
        super(mAnInterface);
    }

    @Override
    public boolean isSwipeEnabled() {
        return swipeEnabled;
    }

    public void setSwipeEnabled(boolean is) {
        swipeEnabled = is;
    }

    @Override
    public boolean isLongEnabled() {
        return longEnabled;
    }

    public void setLongEnabled(boolean is) {
        swipeEnabled = is;
    }

    @Override
    public int getSwipeFlags() {
        return swipeFlags;
    }

    public void setSwipeFlags(int i) {
        swipeFlags = i;
    }
}
