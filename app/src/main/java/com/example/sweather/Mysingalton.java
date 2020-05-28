package com.example.sweather;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class Mysingalton {

    private static Mysingalton mInstance;
    private RequestQueue requestQueue;
    private static Context mCtx;

    private Mysingalton(Context context){
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized Mysingalton getInstance(Context context){
        if(mInstance==null){
            mInstance = new Mysingalton(context);
        }
        return mInstance;
    }

    public void addToRequestQue(JsonObjectRequest request){
        requestQueue.add(request);
    }
}
