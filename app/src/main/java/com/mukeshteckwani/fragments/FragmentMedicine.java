package com.mukeshteckwani.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mukeshteckwani.R;
import com.mukeshteckwani.adapter.ViewPagerAdapter;
import com.mukeshteckwani.models.Result;

/**
 * Created by mukeshteckwani on 16/08/16.
 */
public class FragmentMedicine extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_medicine,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAndSetViews(view);
    }

    private void initAndSetViews(View view) {
        Result medicine = (Result) getArguments().getSerializable(ViewPagerAdapter.MEDICINE);
        TextView tvMedicine = (TextView) view.findViewById(R.id.tv_medicine);
        TextView tvId = (TextView) view.findViewById(R.id.tv_id);
        TextView tvAvailablity = (TextView) view.findViewById(R.id.tv_availablity);

        tvMedicine.setText(" Name: "+medicine.getName());
        tvId.setText(" Id: "+medicine.getId());
        tvAvailablity.setText(" Availability: "+medicine.getAvailable());
    }
}
