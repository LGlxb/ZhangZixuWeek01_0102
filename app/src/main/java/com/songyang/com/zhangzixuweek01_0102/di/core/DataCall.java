package com.songyang.com.zhangzixuweek01_0102.di.core;

import com.songyang.com.zhangzixuweek01_0102.bean.GoodsBean;

public interface DataCall extends IView {
    void showGoods(GoodsBean goodsBean);

    void showError(String error);
}
