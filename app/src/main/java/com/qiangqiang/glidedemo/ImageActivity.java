package com.qiangqiang.glidedemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.net.URI;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;

public class ImageActivity extends AppCompatActivity {
    String gifUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558973881121&di=baea5109e503ea146b69ea3087f725a8&imgtype=0&src=http%3A%2F%2Fphotocdn.sohu.com%2F20150909%2Fmp31139342_1441765361306_3.gif";
    String imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559217665336&di=16f49d01d778c6e89e7e40bb64490e78&imgtype=0&src=http%3A%2F%2Fimg.m.focus.cn%2Fq_70%2Fapp%2Fde%2Fde40c55062c28e4ac95bc6a49c9afc96.jpg";
    private MyLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        myLayout = (MyLayout) findViewById(R.id.background);
        ImageView image = findViewById(R.id.image);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        switch (type) {
            case "load_net":
                Glide.with(this).load(imageUrl).into(image);
                break;
            case "load_local":
                File file = new File("/storage/emulated/0/Download/flower.jpg");
                Glide.with(this).load(file).into(image);

                break;
            case "load_res":
                Glide.with(this).load(R.mipmap.image).into(image);
                break;
            case "load_binary":
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.luffy);
                byte[] b = Utils.getBitmapByte(bitmap);

                Glide.with(this).load(b).into(image);
                break;
            case "load_uri":
                File f = new File("/storage/emulated/0/Download/zero.jpg");
                Uri uri = Uri.fromFile(f);
                Glide.with(this).load(uri).into(image);
                break;
            case "load_placeholder":
                String url = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2814607337,2734621788&fm=26&gp=0.jpg";
                Glide.with(this).load(url).placeholder(R.drawable.ic_launcher_background).into(image);
                break;
            case "load_error":
                Glide.with(this).load(imageUrl).placeholder(R.drawable.ic_launcher_background).error(android.R.drawable.stat_notify_error)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)//关闭Glide的硬盘缓存机制
                        .into(image);
                //DiskCacheStrategy.NONE： 表示不缓存任何内容。
                //DiskCacheStrategy.SOURCE： 表示只缓存原始图片。
                //DiskCacheStrategy.RESULT： 表示只缓存转换过后的图片（默认选项）。
                //DiskCacheStrategy.ALL ： 表示既缓存原始图片，也缓存转换过后的图片。
                break;
            case "load_img":
                Glide.with(this)
                        .asBitmap()//只加载静态图片，如果是git图片则只加载第一帧。
                        .load(imageUrl)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(android.R.drawable.stat_notify_error)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(image);
                break;
            case "load_gif":
                Glide.with(this)
                        .asGif()//加载动态图片，若现有图片为非gif图片，则直接加载错误占位图。
                        .load(gifUrl)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(android.R.drawable.stat_notify_error)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(image);
                break;
            case "load_specify":
                Glide.with(this)
                        .load(imageUrl)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(android.R.drawable.stat_notify_error)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .override(100, 100)//指定图片大小
                        .into(image);
                break;
            case "load_toLayout":
                String img = "http://cn.bing.com/az/hprichbg/rb/TOAD_ZH-CN7336795473_1920x1080.jpg";
                Glide.with(this)
                        .load(img)
                        .centerCrop()
                        .into((Target) myLayout.getTarget());
                break;
            case "load_blurTrans":
                Glide.with(this)
                        .load(imageUrl)
                        .transform(new BlurTransformation(25))
                        .into(image);
                break;
            case "load_grayscale":
                Glide.with(this)
                        .load(imageUrl)
                        .transform(new GrayscaleTransformation())
                        .into(image);
                break;

        }

    }

}
