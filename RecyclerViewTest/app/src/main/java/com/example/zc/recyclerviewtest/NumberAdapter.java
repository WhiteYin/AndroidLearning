package com.example.zc.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * 类描述：
 * 作者：Zhou Cong on 2017/4/15 18:33
 * 邮箱：739094973@qq.com
 */

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.ViewHolder> {

    private List<Number> numberList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View numView;
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            numView=itemView;
            imageView=(ImageView)itemView.findViewById(R.id.num_img);
            textView=(TextView)itemView.findViewById(R.id.num_text);
        }
    }

    public NumberAdapter(List<Number> numberList) {
        this.numberList = numberList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.num_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);

        holder.numView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Number number=numberList.get(position);
                Toast.makeText(v.getContext(),"View"+String.valueOf(number.getNumber()),Toast.LENGTH_SHORT).show();
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Number number=numberList.get(position);
                Toast.makeText(v.getContext(),"ImageView"+String.valueOf(number.getNumber()),Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Number number=numberList.get(position);
        holder.imageView.setImageResource(number.getImg());
        holder.textView.setText(String.valueOf(number.getNumber()));
    }

    @Override
    public int getItemCount() {
        return numberList.size();
    }
}
