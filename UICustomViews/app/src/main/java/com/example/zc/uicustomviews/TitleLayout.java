package com.example.zc.uicustomviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * 类描述：
 * 作者：Zhou Cong on 2017/4/13 22:22
 * 邮箱：739094973@qq.com
 */

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button back=(Button)findViewById(R.id.title_back);
        Button edit=(Button)findViewById(R.id.title_edit);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"back",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
