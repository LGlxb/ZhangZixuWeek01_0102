package com.songyang.com.zhangzixuweek01_0102.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.songyang.com.zhangzixuweek01_0102.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity {

    @BindView(R.id.img_icon1)
    SimpleDraweeView imgIcon1;
    @BindView(R.id.txt_name1)
    TextView txtName1;
    @BindView(R.id.txt_price1)
    TextView txtPrice1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String sname = intent.getStringExtra("sname");
        String sprice = intent.getStringExtra("sprice");
        String simage = intent.getStringExtra("simage");
        txtName1.setText(sname);
        txtName1.setText(sprice);
        imgIcon1.setImageURI(simage);
    }
}
