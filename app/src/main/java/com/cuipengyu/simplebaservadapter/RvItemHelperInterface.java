package com.cuipengyu.simplebaservadapter;

import android.view.View;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/4/13
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public interface RvItemHelperInterface {
    void onItemMove(int fromPostion, int toPostion);

    void onItemRemove(int Postion);

    /**
     * @param holder 手指所在条目所持有的viewhodler
     * @return 返回侧滑时需要跟着手指移动的View, 如果该条目不可滑动，请返回null
     */
    View getContentView(BaseRvViewHolder holder);

    /**
     * 请告诉我们你的侧滑菜单宽度是多少，才能准确的计算视图最大滑动距离
     *
     * @param holder
     * @return
     */
    int getMenuWidth(BaseRvViewHolder holder);
}
