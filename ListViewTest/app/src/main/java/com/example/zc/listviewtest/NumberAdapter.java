package com.example.zc.listviewtest;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 类描述：
 * 作者：Zhou Cong on 2017/4/15 10:40
 * 邮箱：739094973@qq.com
 */

public class NumberAdapter extends ArrayAdapter<Number> {

    private int resouceId;

    public NumberAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
        resouceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Number number=getItem(position);//获取当前Number实例
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resouceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.imageView=(ImageView)view.findViewById(R.id.num_img);
            viewHolder.textView=(TextView)view.findViewById(R.id.num_text);
            view.setTag(viewHolder);
        }
        else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }

        viewHolder.imageView.setImageResource(number.getImg());
        viewHolder.textView.setText(String.valueOf(number.getNum()));
        return view;
    }

    public class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
