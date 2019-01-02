package com.songyang.com.zhangzixuweek01_0102.di.presenter;

import com.songyang.com.zhangzixuweek01_0102.bean.GoodsBean;
import com.songyang.com.zhangzixuweek01_0102.di.core.DataCall;
import com.songyang.com.zhangzixuweek01_0102.di.model.GoodsModel;

public class GoodsPresenter extends BasePresenter<DataCall> {

    private GoodsModel goodsModel;

    public GoodsPresenter(DataCall view) {
        super(view);
    }

    @Override
    protected void initModel() {
        goodsModel = new GoodsModel();
    }

    public void showGoods() {
        goodsModel.showGoods(new GoodsModel.GoodsModelCallBack() {


            @Override
            public void onResponse(GoodsBean goodsBean) {
                view.showGoods(goodsBean);
            }

            @Override
            public void onFaild(String error) {
                view.showError(error);
            }
        });
    }
}
