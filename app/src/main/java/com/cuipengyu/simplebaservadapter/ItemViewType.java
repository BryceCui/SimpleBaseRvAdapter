package com.cuipengyu.simplebaservadapter;

import android.support.annotation.LayoutRes;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/18
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public interface ItemViewType<T> {
    int getItemType(int position, T t);

    int getLayoutId(@LayoutRes int id);
}
