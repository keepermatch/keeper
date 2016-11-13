package com.codepath.keeper.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.codepath.keeper.R;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdvancedUserInfoFragment extends Fragment {

    @BindView(R.id.btnAgnostic)
    Button btnAgnostic;
    


    public AdvancedUserInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advanced_user_info, container, false);
        if (container != null) {
            container.removeAllViews();
        }
        return view;
    }

}
