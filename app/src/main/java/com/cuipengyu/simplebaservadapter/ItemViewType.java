package com.cuipengyu.simplebaservadapter;

import android.support.annotation.IdRes;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/18
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public class ItemViewType {
    private String mType;
    private int mIdRes;

    public String getmType() {
        return mType == null ? "" : mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public int getmIdRes() {
        return mIdRes;
    }

    public void setmIdRes(@IdRes int mIdRes) {
        this.mIdRes = mIdRes;
    }
}
