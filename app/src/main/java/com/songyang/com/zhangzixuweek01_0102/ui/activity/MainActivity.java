package com.songyang.com.zhangzixuweek01_0102.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.songyang.com.zhangzixuweek01_0102.R;
import com.songyang.com.zhangzixuweek01_0102.adapters.GoodsAdapter;
import com.songyang.com.zhangzixuweek01_0102.bean.GoodsBean;
import com.songyang.com.zhangzixuweek01_0102.di.core.DataCall;
import com.songyang.com.zhangzixuweek01_0102.di.presenter.GoodsPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements DataCall {

    @BindView(R.id.recy)
    RecyclerView recy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        GoodsPresenter goodsPresenter = new GoodsPresenter(this);
        goodsPresenter.showGoods();
    }

    @Override
    public void showGoods(GoodsBean goodsBean) {
        Toast.makeText(this, goodsBean.getMsg(), Toast.LENGTH_SHORT).show();
        List<GoodsBean.DataBean> list = goodsBean.getData();
        //布局管理
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,
                3);
        recy.setLayoutManager(gridLayoutManager);
        //设置适配器
        GoodsAdapter goodsAdapter = new GoodsAdapter(list, MainActivity.this);
        recy.setAdapter(goodsAdapter);

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context CONTEXT() {
        return this;
    }
}
