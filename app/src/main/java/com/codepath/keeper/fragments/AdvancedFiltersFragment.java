package com.codepath.keeper.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.keeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdvancedFiltersFragment extends Fragment {


    public AdvancedFiltersFragment() {
        // Required empty public constructor
    }

    public static AdvancedFiltersFragment newInstance() {
        AdvancedFiltersFragment fragment = new AdvancedFiltersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_advanced_filters, container, false);
    }



}
