package com.example.zc.offlinetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserView extends BaseActiviity {

    Button offlineBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);

        offlineBtn=(Button)findViewById(R.id.offline_btn);

        offlineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.zc.offlinetest.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
