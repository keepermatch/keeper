package com.codepath.keeper.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codepath.keeper.R;
import com.codepath.keeper.fragments.ProfileFragment;

public class SwipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        // Get the screen name passed in from parent activity that launches this
        if (savedInstanceState == null) {
            // Create the user timeline fragment
            ProfileFragment profileFragment = ProfileFragment.newInstance();
            // Display user fragment within the activity
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flProfile, profileFragment);
            ft.commit();
        }
    }


}
