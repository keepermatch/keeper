package com.codepath.keeper.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.codepath.keeper.R;
import com.codepath.keeper.models.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class BasicUserInfoFragment extends Fragment {

    // butterknife
    @BindView(R.id.btnSingle)
    Button btnSingle;

    @BindView(R.id.btnTaken)
    Button btnTaken;

    @BindView(R.id.llInterestedIn)
    LinearLayout llInterestedIn;

    @BindView(R.id.llEducation)
    LinearLayout llEducation;

    @BindView(R.id.llOccupation)
    LinearLayout llOccupation;

    @BindView(R.id.llZipCode)
    LinearLayout llZipCode;

    @BindView(R.id.btnGirls)
    Button btnGirls;

    @BindView(R.id.btnGuys)
    Button btnGuys;

    @BindView(R.id.btnBoth)
    Button btnBoth;

    @BindView(R.id.btnContinue)
    Button btnContinue;

    // instance vars
    private Unbinder mUnbinder;
    private User mUser;


    // constructor
    public BasicUserInfoFragment() {
        // Required empty public constructor
    }


    // lifecycle methods
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basic_user_info, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        mUser = new User();


        return view;
    }

    // When binding a fragment in onCreateView, set the views to null in onDestroyView.
    // ButterKnife returns an Unbinder on the initial binding that has an unbind method to do this automatically.
    @Override public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    // onclicks
    @OnClick(R.id.btnSingle)
    public void onTapSingle(Button button) {
        btnSingle.setTextColor(Color.RED);
        btnTaken.setTextColor(Color.BLACK);
        mUser.setSingle(true);
        llInterestedIn.setVisibility(View.VISIBLE);

        if (mUser.getZipcode() == null || mUser.getZipcode().equals("")) {
            llZipCode.setVisibility(View.VISIBLE);
        }

        if (mUser.getEducation().size() == 0) {
            llEducation.setVisibility(View.VISIBLE);
        }

        if (mUser.getOccupation() == null || mUser.getOccupation().equals("")) {
            llOccupation.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.btnTaken)
    public void onTapTaken(Button button) {
        btnSingle.setTextColor(Color.BLACK);
        btnTaken.setTextColor(Color.RED);
        mUser.setSingle(false);
    }

    @OnClick(R.id.btnGirls)
    public void onTapGirls(Button button) {
        btnGirls.setTextColor(Color.RED);
        btnGuys.setTextColor(Color.BLACK);
        btnBoth.setTextColor(Color.BLACK);
    }

    @OnClick(R.id.btnGuys)
    public void onTapGuys(Button button) {
        btnGirls.setTextColor(Color.BLACK);
        btnGuys.setTextColor(Color.RED);
        btnBoth.setTextColor(Color.BLACK);
    }

    @OnClick(R.id.btnBoth)
    public void onTapBoth(Button button) {
        btnGirls.setTextColor(Color.BLACK);
        btnGuys.setTextColor(Color.BLACK);
        btnBoth.setTextColor(Color.RED);
    }

    @OnClick(R.id.btnContinue)
    public void onTapContinue(Button button) {
        
    }

}
