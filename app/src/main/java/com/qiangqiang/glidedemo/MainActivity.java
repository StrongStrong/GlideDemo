package com.qiangqiang.glidedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, ImageActivity.class);
        findViewById(R.id.load_net).setOnClickListener(this);
        findViewById(R.id.load_local).setOnClickListener(this);
        findViewById(R.id.load_res).setOnClickListener(this);
        findViewById(R.id.load_binary).setOnClickListener(this);
        findViewById(R.id.load_uri).setOnClickListener(this);
        findViewById(R.id.load_placeholder).setOnClickListener(this);
        findViewById(R.id.load_error).setOnClickListener(this);
        findViewById(R.id.load_img).setOnClickListener(this);
        findViewById(R.id.load_gif).setOnClickListener(this);
        findViewById(R.id.load_specify).setOnClickListener(this);
        findViewById(R.id.load_toLayout).setOnClickListener(this);
        findViewById(R.id.load_blurTrans).setOnClickListener(this);
        findViewById(R.id.load_grayscale).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.load_net:
                intent.putExtra("type", "load_net");
                startActivity(intent);
                break;
            case R.id.load_local:
                intent.putExtra("type", "load_local");
                startActivity(intent);
                break;
            case R.id.load_res:
                intent.putExtra("type", "load_res");
                startActivity(intent);
                break;
            case R.id.load_binary:
                intent.putExtra("type", "load_binary");
                startActivity(intent);
                break;
            case R.id.load_uri:
                intent.putExtra("type", "load_uri");
                startActivity(intent);
                break;
            case R.id.load_placeholder:
                intent.putExtra("type", "load_placeholder");
                startActivity(intent);
                break;
            case R.id.load_error:
                intent.putExtra("type", "load_error");
                startActivity(intent);
                break;
            case R.id.load_img:
                intent.putExtra("type", "load_img");
                startActivity(intent);
                break;
            case R.id.load_gif:
                intent.putExtra("type", "load_gif");
                startActivity(intent);
                break;
            case R.id.load_specify:
                intent.putExtra("type", "load_specify");
                startActivity(intent);
                break;
            case R.id.load_toLayout:
                intent.putExtra("type", "load_toLayout");
                startActivity(intent);
                break;
            case R.id.load_blurTrans:
                intent.putExtra("type", "load_blurTrans");
                startActivity(intent);
                break;
            case R.id.load_grayscale:
                intent.putExtra("type", "load_grayscale");
                startActivity(intent);
                break;

        }
    }
}
