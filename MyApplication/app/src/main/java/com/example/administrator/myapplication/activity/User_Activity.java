package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import org.w3c.dom.Text;

public class User_Activity extends AppCompatActivity implements View.OnClickListener{
    private TextView lose_pass,log_on;
    private Button log_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_);
        lose_pass = (TextView) findViewById(R.id.lose_pass);
        log_on = (TextView) findViewById(R.id.log_on);
        lose_pass.setOnClickListener(this);
        log_on.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lose_pass:
                Intent intetn1=  new Intent(getApplication(),LoseActivity.class);
                startActivity(intetn1);
                break;
            case R.id.log_on:
                Intent intetn2=  new Intent(getApplication(),Logon_Activity.class);
                startActivity(intetn2);
                break;
            default:

        }
    }
}
