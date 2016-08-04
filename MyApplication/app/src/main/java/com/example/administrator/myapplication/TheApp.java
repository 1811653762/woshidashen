package com.example.administrator.myapplication;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.util.Size;

import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by ldx on 2016/8/3 0003.
 */
public class TheApp extends Application {
        private static TheApp app;
        private  static RequestQueue requestQueue;

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static void setRequestQueue(RequestQueue requestQueue) {
        TheApp.requestQueue = requestQueue;
    }

    public static TheApp getApp() {
        return app;
    }

    public static void setApp(TheApp app) {
        TheApp.app = app;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        this.app = this;
        initRequest();
    }

    private void initRequest() {
    requestQueue = Volley.newRequestQueue(this);
         ImageLoader.ImageCache cache = new ImageLoader.ImageCache() {
            LruCache<String,Bitmap>lru = new LruCache<String , Bitmap>(10<<20){
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return super.sizeOf(key, value);
                }
            };
            @Override
            public Bitmap getBitmap(String url) {
                return lru.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                    lru.put(url,bitmap);

            }
        };
    }
}
