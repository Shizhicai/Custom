package com.mm.renrenhua.custom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mm.renrenhua.custom.demo1.IndexActivity;
import com.mm.renrenhua.custom.demo2.TextImgActivity;
import com.mm.renrenhua.custom.demo3.RippleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_index).setOnClickListener(this);
        findViewById(R.id.btn_center).setOnClickListener(this);
        findViewById(R.id.btn_ripple).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_index:
                startActivity(new Intent(this, IndexActivity.class));
                break;
            case R.id.btn_center:
                startActivity(new Intent(this, TextImgActivity.class));
                break;
            case R.id.btn_ripple:
                startActivity(new Intent(this, RippleActivity.class));
                break;
        }
    }
}
