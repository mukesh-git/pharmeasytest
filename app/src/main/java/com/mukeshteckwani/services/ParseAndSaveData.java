package com.mukeshteckwani.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.os.ResultReceiver;

import com.google.gson.Gson;
import com.mukeshteckwani.DBHandler;
import com.mukeshteckwani.activities.ActivityHome;
import com.mukeshteckwani.models.MedicineName;
import com.mukeshteckwani.models.Result;

/**
 * Created by mukeshteckwani on 14/08/16.
 */
public class ParseAndSaveData extends IntentService {
    public ParseAndSaveData(String name) {
        super(name);
    }

    public ParseAndSaveData() {
        super("ParseAndSaveData");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Gson gson = new Gson();
        MedicineName medicineName = gson.fromJson(intent.getStringExtra("JSON"), MedicineName.class);
        for (Result result: medicineName.getResult()) {
            DBHandler.getInstance(this).insertToMedicinesTable(result);
        }
        getSharedPreferences("PREFS",MODE_PRIVATE).edit().putBoolean("DATA_DOWNLOADED",true).apply();
        ((ResultReceiver) (intent.getParcelableExtra(ActivityHome.RECIEVER_TAG))).send(0, null);

    }
}
