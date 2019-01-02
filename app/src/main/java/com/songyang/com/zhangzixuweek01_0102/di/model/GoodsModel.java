package com.songyang.com.zhangzixuweek01_0102.di.model;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.songyang.com.zhangzixuweek01_0102.bean.GoodsBean;

public class GoodsModel {
    public void showGoods(final GoodsModelCallBack goodsModelCallBack) {
        String GOODS_URL = "http://www.zhaoapi.cn/product/searchProducts?keywords=手机&page=1";
        OkGo.<String>get(GOODS_URL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                GoodsBean goodsBean = new Gson().fromJson(response.body().toString(), GoodsBean
                        .class);
                if (goodsBean.getCode().equals("0")) {
                    goodsModelCallBack.onResponse(goodsBean);
                } else {
                    goodsModelCallBack.onFaild("网络连接异常");
                }
            }
        });
    }

    public interface GoodsModelCallBack {
        void onResponse(GoodsBean goodsBean);

        void onFaild(String error);
    }
}
