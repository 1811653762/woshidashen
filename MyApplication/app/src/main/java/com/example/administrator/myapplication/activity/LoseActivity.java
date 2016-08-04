package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;

public class LoseActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView phone_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        phone_back = (ImageView) findViewById(R.id.phone_back);
        phone_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //点击返回
        switch (view.getId()) {
            case R.id.phone_back:
            finish();
                break;
        }
    }
}
