package com.codepath.keeper.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codepath.keeper.Adapters.FiltersPagerAdapter;
import com.codepath.keeper.R;


public class FiltersFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    FiltersPagerAdapter filtersPagerAdapter;


    public FiltersFragment() {
        // Required empty public constructor
    }


    public static FiltersFragment newInstance() {
        FiltersFragment fragment = new FiltersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filters, container, false);

        ViewPager vpPager = (ViewPager) view.findViewById(R.id.vpPager);
        filtersPagerAdapter = new FiltersPagerAdapter(getChildFragmentManager());
        vpPager.setAdapter(filtersPagerAdapter);



        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(getActivity(),
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Toast.makeText(getActivity(),
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
//                Toast.makeText(getActivity(),
//                        "scroll state change ", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
