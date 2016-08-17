package com.mukeshteckwani.services;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

/**
 * Created by mukeshteckwani on 15/08/16.
 */

public class ServiceResultReciever extends ResultReceiver {
    private InterfaceResultReceiver mReciever;
    /**
     * Create a new ResultReceive to receive results.  Your
     * {@link #onReceiveResult} method will be called from the thread running
     * <var>handler</var> if given, or from an arbitrary thread if null.
     *
     * @param handler
     */
    public ServiceResultReciever(Handler handler) {
        super(handler);
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);
        Log.d("ServiceResultReciever", "onReceiveResult: rating");
        mReciever.onResultRecieved(resultData);
    }

    public void setResultReciever(InterfaceResultReceiver reciever) {
        mReciever = reciever;
    }

    public interface InterfaceResultReceiver {
        void onResultRecieved(Bundle resultData);
    }
}
