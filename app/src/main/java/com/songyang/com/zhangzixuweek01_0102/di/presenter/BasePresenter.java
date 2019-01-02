package com.songyang.com.zhangzixuweek01_0102.di.presenter;

import com.songyang.com.zhangzixuweek01_0102.di.core.IView;

import java.lang.ref.SoftReference;

public abstract class BasePresenter<V extends IView> {
    protected V view;
    private final SoftReference<V> vSoftReference;

    public BasePresenter(V view) {
        //软引用包裹
        vSoftReference = new SoftReference<>(view);
        this.view = view;
        initModel();
    }

    protected abstract void initModel();

    public void onDestory() {
        view = null;
    }
}
