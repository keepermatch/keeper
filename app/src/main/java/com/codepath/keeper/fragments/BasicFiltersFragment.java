package com.codepath.keeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.codepath.keeper.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class BasicFiltersFragment extends Fragment {


    @BindView(R.id.btnLetsSwipe)
    Button btnLetsSwipe;

    Unbinder mUnbinder;
    public BasicFiltersFragment() {
        // Required empty public constructor
    }

    public static BasicFiltersFragment newInstance() {
        BasicFiltersFragment fragment = new BasicFiltersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }


    }

    @OnClick(R.id.btnLetsSwipe)
    public void onClickLetsSwipe(Button button) {
       //TODO how to dismiss fragment within dialogfragment?
    }

    @OnClick(R.id.btnAdvancedFilters)
    public void onClickAdvancedFilters(Button button) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_basic_filters, container, false);
        mUnbinder = ButterKnife.bind(this, v);

        return v;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

}
