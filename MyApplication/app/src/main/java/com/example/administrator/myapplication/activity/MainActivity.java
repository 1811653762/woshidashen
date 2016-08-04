package com.example.administrator.myapplication.activity;
/*
* create by LDX
* */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.FirstFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton fourPage, firstPage, secondPage, thirdPage;
    private FrameLayout frame;
    private FragmentManager fManager;
    private Fragment first, second, third, four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        initSelected();

    }

    private void initView() {
        fManager = getSupportFragmentManager();
        frame = (FrameLayout) findViewById(R.id.main_fram);

        fourPage = (RadioButton) findViewById(R.id.fourPage);
        firstPage = (RadioButton) findViewById(R.id.firstPage);
        secondPage = (RadioButton) findViewById(R.id.secondPage);
        thirdPage = (RadioButton) findViewById(R.id.thirdPage);

        firstPage.setOnClickListener(this);
        secondPage.setOnClickListener(this);
        thirdPage.setOnClickListener(this);
        fourPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (view.getId()) {
            //点击跳转
            //第一个
            case R.id.firstPage:

                initSelected();
                firstPage.setSelected(true);
                if (first == null) {
                    first = new FirstFragment();
                    fTransaction.add(R.id.main_fram, first);
                } else {
                    fTransaction.show(first);
                }
                break;
            //第二个
            case R.id.secondPage:
                initSelected();
                secondPage.setSelected(true);
                if (second == null) {
                    second = new FirstFragment();
                    fTransaction.add(R.id.main_fram, second);
                } else {
                    fTransaction.show(second);
                }
                break;
            //第三个
            case R.id.thirdPage:
                initSelected();
                thirdPage.setSelected(true);
                if (third == null) {
                    third = new FirstFragment();
                    fTransaction.add(R.id.main_fram, third);
                } else {
                    fTransaction.show(third);
                }
                break;
            //第四个
            case R.id.fourPage:
                Intent intent = new Intent(getApplication(), User_Activity.class);
                startActivity(intent);
//                initSelected();
//                fourPage.setSelected(true);
//                if(four==null){
//                    four = new FirstFragment();
//                    fTransaction.add(R.id.main_fram,four);
//                }else{
//                    fTransaction.show(four);
//                }
                break;
        }
        fTransaction.commit();
    }

    private void initSelected() {
        fourPage.setSelected(false);
        firstPage.setSelected(false);
        thirdPage.setSelected(false);
        secondPage.setSelected(false);
    }


    private void hideAllFragment(FragmentTransaction fTransaction) {
        if (first != null) {
            fTransaction.hide(first);
        }
        if (second != null) {
            fTransaction.hide(second);
        }
        if (third != null) {
            fTransaction.hide(third);
        }
        if (four != null) {
            fTransaction.hide(four);
        }
    }

}
