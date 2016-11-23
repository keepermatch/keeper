package com.codepath.keeper.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codepath.keeper.Adapters.ProfilePicturesAdapter;
import com.codepath.keeper.R;
import com.codepath.keeper.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private static final String NULL_IN_STRING = "null";
    public static final String USER_KEY = "user";
    private User mUser;
    @BindView(R.id.tvProfileNameAndAge) TextView tvProfileNameAndAge;
    @BindView(R.id.tvProfileEducation) TextView tvProfileEducation;
    @BindView(R.id.tvProfileOccupation) TextView tvProfileOccupation;
    @BindView(R.id.tvProfileReligion) TextView tvProfileReligion;
    @BindView(R.id.tvProfileLocationAndHeight) TextView tvProfileLocationAndHeight;
    @BindView(R.id.rvProfilePictures) RecyclerView rvProfilePictures;
    private Unbinder mUnbinder;
    private List<String> mProfilePictureUrls;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        mUser = (User) getArguments().getSerializable(USER_KEY);

        String locationAndHeight = "";
        String location = mUser.getLocation();
        String height = mUser.getHeight();
        String age = Integer.toString(mUser.getAge());
        if (location != null && !location.equalsIgnoreCase(NULL_IN_STRING)) {
            locationAndHeight += location;
        }
        if (height != null && !height.equalsIgnoreCase(NULL_IN_STRING)) {
            locationAndHeight += height;
        }
        String nameAndAge = mUser.getFirstName() + ", " + age;
        String education = mUser.getEducation().toString();
        String occupation = mUser.getOccupation();
        List<String> pictures = mUser.getPictureUrls();
        loadVouchesFragment();

        if (locationAndHeight != null) tvProfileLocationAndHeight.setText(locationAndHeight);
        if (education != null) tvProfileEducation.setText(education);
        if (nameAndAge != null) tvProfileNameAndAge.setText(nameAndAge);
        if (occupation != null) tvProfileOccupation.setText(occupation);
        if (pictures.size() > 0) {
            mProfilePictureUrls = pictures;
            ProfilePicturesAdapter profilePicturesAdapter = new ProfilePicturesAdapter(getContext(), mProfilePictureUrls);
            rvProfilePictures.setAdapter(profilePicturesAdapter);
            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
            rvProfilePictures.setLayoutManager(horizontalLayoutManager);
        }

        return view;
    }

    public static ProfileFragment newInstance(User user) {
        ProfileFragment profileFragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putSerializable(USER_KEY, user);
        profileFragment.setArguments(args);
        return profileFragment;
    }

    private void loadVouchesFragment() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        VouchListFragment vouchListFragment = VouchListFragment.newInstance(mUser.getVouchesReceived());
        ft.replace(R.id.flProfileVouches, vouchListFragment);
        ft.commit();
    }
}
