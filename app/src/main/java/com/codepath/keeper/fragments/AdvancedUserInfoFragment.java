package com.codepath.keeper.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.keeper.R;
import com.codepath.keeper.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AdvancedUserInfoFragment extends Fragment {

    // view bindings
    @BindView(R.id.btnUserDone)
    Button btnUserDone;
    @BindView(R.id.tvUserHeight)
    TextView tvUserHeight;
    SeekBar sbHeight;

    // instance vars
    User mUser;
    Unbinder mUnbinder;
    private static final int SB_HEIGHT_OFFSET = 57;

    // constructors
    public AdvancedUserInfoFragment() {
        // Required empty public constructor
    }

    // lifecycle methods
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advanced_user_info, container, false);
        if (container != null) {
            container.removeAllViews();
        }

        mUnbinder = ButterKnife.bind(this, view);
        sbHeight = (SeekBar) view.findViewById(R.id.sbHeight);
        tvUserHeight.setText(User.getHeightInFeetAndInches(sbHeight.getProgress() + SB_HEIGHT_OFFSET));
        sbHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvUserHeight.setText(User.getHeightInFeetAndInches(progress + SB_HEIGHT_OFFSET));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mUser = new User();
        return view;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    // butterknife click handlers
    @OnClick({R.id.btnAgnostic, R.id.btnAtheist, R.id.btnBuddhist, R.id.btnCatholic,
    R.id.btnChristian, R.id.btnHindu, R.id.btnJewish, R.id.btnMuslim, R.id.btnOtherReligion,
    R.id.btnSpiritual})
    public void onTapReligion(Button button){
        List<String> religion = mUser.getReligion();
        if (religion.contains(button.getText().toString())) {
            religion.remove(button.getText().toString());
            button.setTextColor(Color.BLACK);
        } else {
            religion.add(button.getText().toString());
            button.setTextColor(Color.RED);
        }
        mUser.setReligion(religion);
    }

    @OnClick({R.id.btnBlack, R.id.btnEastAsian, R.id.btnHispanic, R.id.btnAmericanIndian,
    R.id.btnWhite, R.id.btnMiddleEastern, R.id.btnPacificIslander, R.id.btnSouthAsian,
    R.id.btnOtherEthnicity})
    public void onTapEthnicity(Button button) {
        List<String> ethnicity = mUser.getEthnicity();
        if (ethnicity.contains(button.getText().toString())) {
            ethnicity.remove(button.getText().toString());
            button.setTextColor(Color.BLACK);
        } else {
            ethnicity.add(button.getText().toString());
            button.setTextColor(Color.RED);
        }
        mUser.setEthnicity(ethnicity);
    }

    @OnClick(R.id.btnUserDone)
    public void onUserDone() {
        // call api
        Toast.makeText(getContext(), "Posting new user data to Keeper API", Toast.LENGTH_SHORT).show();
        //TODO make api call
        
        // close fragment
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(this);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        ft.commit();
    }

}
