package com.example.administrator.myapplication.config;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.administrator.myapplication.TheApp;

import java.util.Map;

/**
 * Created by ldx on 2016/8/4 0004.
 */
public class PostMethod {
    private void volley_post(String url,Map<String,String>map) {
            String name = map.get("name");
        StringRequest mStringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("请求结果:" + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        TheApp.getRequestQueue().add(mStringRequest);

    }
}
