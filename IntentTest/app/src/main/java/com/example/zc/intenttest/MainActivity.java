package com.example.zc.intenttest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button browserBtn;
    private Button dialBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browserBtn=(Button)findViewById(R.id.browser);
        dialBtn=(Button)findViewById(R.id.dial);

        browserBtn.setOnClickListener(this);
        dialBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.browser:
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.dial:
                Intent intent1=new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:10086"));//必须tel:号码
                startActivity(intent1);
                break;
            default:
        }
    }
}
