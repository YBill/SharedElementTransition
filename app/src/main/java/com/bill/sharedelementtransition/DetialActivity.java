package com.bill.sharedelementtransition;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetialActivity extends AppCompatActivity {

    public static final String KEY_IMAGE = "image";
    public static final String KEY_TEXT = "text";

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);

        imageView = (ImageView) findViewById(R.id.detial_image);
        textView = (TextView) findViewById(R.id.detail_text);

        textView.setText(getIntent().getStringExtra("title") + " 我是详情");

        // 将当前Activity的View和自己定义的Key绑定起来
        ViewCompat.setTransitionName(imageView, KEY_IMAGE);
        ViewCompat.setTransitionName(textView, KEY_TEXT);

    }
}
