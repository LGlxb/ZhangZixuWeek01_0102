package com.songyang.com.zhangzixuweek01_0102.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.songyang.com.zhangzixuweek01_0102.R;
import com.songyang.com.zhangzixuweek01_0102.bean.GoodsBean;
import com.songyang.com.zhangzixuweek01_0102.ui.activity.ShowActivity;

import java.util.List;

public class GoodsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GoodsBean.DataBean> list;
    private Context context;
    private String[] split;

    public GoodsAdapter(List<GoodsBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ((ViewHolder) viewHolder).txt_name.setText(list.get(i).getTitle());
        ((ViewHolder) viewHolder).txt_price.setText(list.get(i).getPrice() + "");
        String images = list.get(i).getImages();
        final String imgurl = "http" + images.substring(5);
        split = imgurl.split("\\|");
        if (split.length > 0) {
            Glide.with(context).load(split[0]).into(((ViewHolder) viewHolder).img_icon);
        }
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                list.remove(i);
                notifyDataSetChanged();
                Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ShowActivity.class);
                intent.putExtra("sname", list.get(i).getTitle());
                intent.putExtra("sprice", list.get(i).getPrice() + "");
                intent.putExtra("simage", split[0]);
                Toast.makeText(context, "点击了" + i, Toast.LENGTH_LONG).show();
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img_icon;
        private final TextView txt_price;
        private final TextView txt_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_price = itemView.findViewById(R.id.txt_price);
            img_icon = itemView.findViewById(R.id.img_icon);
        }
    }

}
