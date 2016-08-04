package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.TheApp;

import java.util.HashMap;
import java.util.Map;

public class Logon_Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText in_num, in_pass, in_code, in_inv;
    private TextView in_sendCode;
    private String pass;
    private String num, code, inv;
    private ImageView back;
    private Button in_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);
        initView();
        pass = in_pass.getText().toString();
        JudgePass(pass);
        num = in_num.getText().toString();
        code = in_code.getText().toString();
        inv = in_inv.getText().toString();
        initSend();
    }

    //讲输入的内容进行发送
    private void initSend() {
        StringRequest request = new StringRequest(Request.Method.POST, "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("code", code);
                map.put("", pass);
                map.put("", num);
                map.put("", inv);
                return map;
            }
        };
        //加入队列
        TheApp.getApp().getRequestQueue().add(request);
    }

    //判断密码的长度
    public void JudgePass(String s) {
        if (s.length() < 6 && s.length() > 16) {
            Toast.makeText(getApplicationContext(), "您输入的密码不合法", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        in_code = (EditText) findViewById(R.id.in_code);
        in_inv = (EditText) findViewById(R.id.in_inv);
        in_num = (EditText) findViewById(R.id.in_num);
        in_pass = (EditText) findViewById(R.id.in_pass);
        back = (ImageView) findViewById(R.id.in_back);
        in_sendCode = (TextView) findViewById(R.id.in_sendCode);
        in_next = (Button) findViewById(R.id.in_next);
        //点击事件
        back.setOnClickListener(this);
        in_next.setOnClickListener(this);
        in_sendCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.in_next:

                break;
            case R.id.in_sendCode:

                break;
            //返回上一个界面
            case R.id.in_back:
                finish();

                break;
        }
    }
}
