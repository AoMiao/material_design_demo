package com.vince.masterial_design_demo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vince.masterial_design_demo.model.Character;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/19.
 */

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private Context mContext;
    private List<Character> mList;
    private ArrayList<Integer> text = new ArrayList<>();

    public CharacterAdapter(List<Character> mList){
        text.add(R.string.a);
        text.add(R.string.b);
        text.add(R.string.c);
        text.add(R.string.d);
        text.add(R.string.e);
        text.add(R.string.f);
        text.add(R.string.g);
        text.add(R.string.h);
        text.add(R.string.i);
        text.add(R.string.j);
        text.add(R.string.k);
        text.add(R.string.l);
        text.add(R.string.m);
        this.mList = mList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            imageView = (ImageView) itemView.findViewById(R.id.character_image);
            textView = (TextView) itemView.findViewById(R.id.character_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.character_item,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);//viewHolder类似代理，当成carview
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {//注册点击事件
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();//获取点击位置的ID
                Character character = mList.get(position);
                Intent intent = new Intent(mContext,ItemActivity.class);
                intent.putExtra(ItemActivity.CHARACTER_NAME,character.getName());
                intent.putExtra("text",text.get(position));
                intent.putExtra(ItemActivity.CHARACTER_IMAGE,character.getImageId());
                mContext.startActivity(intent);
            }
        });
        return viewHolder;//cardview实例传进去
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {//滚动到屏幕里执行的方法
        Character character = mList.get(position);
        holder.textView.setText(character.getName());
        Glide.with(mContext).load(character.getImageId()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }
}
