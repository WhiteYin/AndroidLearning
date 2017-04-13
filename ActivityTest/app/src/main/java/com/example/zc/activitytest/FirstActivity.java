package com.example.zc.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "FirstActivity";
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        button=(Button)findViewById(R.id.button_1);
        button.setOnClickListener(this);

        ActivityCollector.addActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_1:
                Intent intent=new Intent("com.example.zc.activitytest.ACTION_START");
                intent.putExtra("name","FirstActivity");
                startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(RESULT_OK==resultCode){
                    String name=data.getStringExtra("name");
                    Log.i(TAG, name);
                }
                break;
            default:
        }
    }

    /**
     * 重写onCreateOptionMenu、onOptionsItemSelected方法。
     * 选择添加、删除和退出。退出调用finish()方法销毁Activity
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"Remove",Toast.LENGTH_SHORT).show();
                break;
            case R.id.quit:
                finish();
            default:
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
