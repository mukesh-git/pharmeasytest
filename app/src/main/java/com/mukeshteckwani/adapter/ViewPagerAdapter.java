package com.mukeshteckwani.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mukeshteckwani.DBHandler;
import com.mukeshteckwani.fragments.FragmentMedicine;
import com.mukeshteckwani.models.Result;

/**
 * Created by mukeshteckwani on 16/08/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    public static final String MEDICINE = "MEDICINE";
    private final int count;
    private Activity mActivity;

    public ViewPagerAdapter(FragmentManager fm,Activity mActivity) {
        super(fm);
        this.mActivity = mActivity;
        count = (int)DBHandler.getInstance(mActivity).getMedicineCount();
    }

    @Override
    public Fragment getItem(int position) {
        Result medicine = DBHandler.getInstance(mActivity).getMedicineName(position);

            FragmentMedicine fragmentMedicine = new FragmentMedicine();
            Bundle bundle = new Bundle();
            bundle.putSerializable(MEDICINE,medicine);
            fragmentMedicine.setArguments(bundle);
            return fragmentMedicine;

    }

    @Override
    public int getCount() {
        return count;
    }
}
