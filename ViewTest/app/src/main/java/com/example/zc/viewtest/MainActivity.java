package com.example.zc.viewtest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button progressBtn;
    private Button alertBtn;
    private Button progressDialog;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBtn=(Button)findViewById(R.id.progress_bar_btn);
        alertBtn=(Button)findViewById(R.id.alert_dialog_btn);
        progressDialog=(Button)findViewById(R.id.progress_dialog_btn);
        progressBar=(ProgressBar)findViewById(R.id.progress_bar);

        progressBtn.setOnClickListener(this);
        alertBtn.setOnClickListener(this);
        progressDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.progress_bar_btn:
                if(progressBar.getVisibility()==View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }
                else if(progressBar.getVisibility()==View.VISIBLE){
                    progressBar.setVisibility(View.GONE);
                }
                break;
            case R.id.alert_dialog_btn:
                AlertDialog.Builder dialog=new AlertDialog.Builder(this);
                dialog.setTitle("对话框");
                dialog.setMessage("对话框好难写啊");
                dialog.setCancelable(false);
                dialog.setPositiveButton("是啊", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"那也得写啊",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("不是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"你还是人吗，居然不觉得难！",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
                break;
            case R.id.progress_dialog_btn:
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("进度条对话框");
                progressDialog.setMessage("loading。。。");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
        }
    }
}
