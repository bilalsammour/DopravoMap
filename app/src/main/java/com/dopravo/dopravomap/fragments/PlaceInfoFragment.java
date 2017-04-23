package com.dopravo.dopravomap.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dopravo.dopravomap.R;

public class PlaceInfoFragment extends Fragment {

    public PlaceInfoFragment() {
        // Required empty public constructor
    }

    public static PlaceInfoFragment newInstance() {
        return new PlaceInfoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_info, container, false);
    }

}
