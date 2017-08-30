package com.mm.renrenhua.custom.demo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mm.renrenhua.custom.R;

public class RippleActivity extends AppCompatActivity implements View.OnClickListener {

    private RippleView rippleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ripple);

        rippleView = (RippleView) findViewById(R.id.ripple);
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                rippleView.startAnim();
                break;
            case R.id.btn_cancel:
                rippleView.cancel();
                break;
        }
    }
}
