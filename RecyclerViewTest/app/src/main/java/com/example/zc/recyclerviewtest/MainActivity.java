package com.example.zc.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Number> numberList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recycler_view_1);
        NumberAdapter adapter=new NumberAdapter(numberList);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);

        //如果想要横向布局
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void init(){
        for(int i=0;i<15;i++){
            Number number=new Number(i,R.mipmap.ic_launcher);
            numberList.add(number);
        }
    }
}
