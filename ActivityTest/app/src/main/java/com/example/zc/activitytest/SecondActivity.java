package com.example.zc.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button button;
    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        Log.i(TAG, name);

        ActivityCollector.addActivity(this);

        button=(Button)findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("name","SecondActivity");
                setResult(RESULT_OK,intent);
                finish();//销毁活动。按后退键返回也能有效果
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putExtra("name","SecondActivity");
        setResult(RESULT_OK,intent);
        ActivityCollector.removeAll();
    }
}
