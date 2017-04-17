package com.example.zc.offlinetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 类描述：
 * 作者：Zhou Cong on 2017/4/17 11:05
 * 邮箱：739094973@qq.com
 */

public class BaseActiviity extends AppCompatActivity {
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityList.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityList.removeActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.zc.offlinetest.FORCE_OFFLINE");
        broadcastReceiver=new OfflineReceiver();
        registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(broadcastReceiver!=null){
            unregisterReceiver(broadcastReceiver);
            broadcastReceiver=null;
        }
    }

    class OfflineReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ActivityList.removeAll();
            Intent intent1=new Intent(context,MainActivity.class);
            context.startActivity(intent1);
        }
    }
}
