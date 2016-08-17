package com.mukeshteckwani.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mukeshteckwani.R;
import com.mukeshteckwani.adapter.ViewPagerAdapter;
import com.mukeshteckwani.services.ParseAndSaveData;
import com.mukeshteckwani.services.ServiceResultReciever;

public class ActivityHome extends AppCompatActivity  {
    public static String RECIEVER_TAG = "recieverTag";
    private ViewPagerAdapter pagerAdapter;
    private ProgressBar pbLoader;
    private ViewPager viewPagerMedicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        String url = "https://www.1mg.com/api/v1/search/autocomplete?name=b&pageSize=10&_=1435404923427";
        if (!getSharedPreferences("PREFS",MODE_PRIVATE).getBoolean("DATA_DOWNLOADED",false))
            downloadData(url);
        else
            updateUI();
    }

    private void initViews() {
        pbLoader = (ProgressBar) findViewById(R.id.pb_loader);
        viewPagerMedicine = (ViewPager) findViewById(R.id.vp_medicine);
    }


    private void downloadData(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                handleResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }));
    }

    private void handleResponse(String response) {
        Intent intent = new Intent(ActivityHome.this,ParseAndSaveData.class);
        ServiceResultReciever mReciever = new ServiceResultReciever(new Handler());
        mReciever.setResultReciever(new ServiceResultReciever.InterfaceResultReceiver() {
            @Override
            public void onResultRecieved(Bundle resultData) {
                updateUI();
            }
        });
        intent.putExtra(RECIEVER_TAG,mReciever);
        intent.putExtra("JSON",response);
        startService(intent);
    }

    private void updateUI() {
        pbLoader.setVisibility(View.GONE);
        pagerAdapter = new ViewPagerAdapter(ActivityHome.this.getSupportFragmentManager(),ActivityHome.this);
        viewPagerMedicine.setAdapter(pagerAdapter);
    }

}
