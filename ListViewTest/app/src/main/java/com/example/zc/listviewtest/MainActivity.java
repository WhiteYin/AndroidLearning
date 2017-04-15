package com.example.zc.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Number> numberList=new ArrayList<>();
    //private Integer[] data={1,2,3,4,5,6,7,8,9,10,11,12,13};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNumber();
        //DIY
        NumberAdapter adapter=new NumberAdapter(this,R.layout.list_item,numberList);
        //默认ListView布局
        //ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,data);
        ListView listView=(ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Number number=numberList.get(position);
                Toast.makeText(MainActivity.this,String.valueOf(number.getNum()),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initNumber(){
        for(int i=0;i<15;i++){
            Number number=new Number(i,R.mipmap.ic_launcher);
            numberList.add(number);
        }
    }
}
