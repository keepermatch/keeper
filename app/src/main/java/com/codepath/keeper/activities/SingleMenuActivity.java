package com.codepath.keeper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.codepath.keeper.R;
import com.codepath.keeper.models.User;

public class SingleMenuActivity extends AppCompatActivity {

    User mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_menu);
        mCurrentUser = (User) getIntent().getSerializableExtra(User.CURRENT_USER);
    }

    public void onSwitchToMatchmakerModeClick(View view) {
        Intent i = new Intent(this, SwipeActivity.class);
        i.putExtra(User.CURRENT_USER, mCurrentUser);
        startActivity(i);
    }

    public void onSingleSettingsClick(View view) {
        Intent i = new Intent(this, SettingsActivity.class);
        i.putExtra(User.CURRENT_USER, mCurrentUser);
        startActivity(i);
    }

    public void onSingleVouchingForMeClick(View view) {
        Intent i = new Intent(this, VouchListActivity.class);
        i.putExtra(User.CURRENT_USER, mCurrentUser);
        startActivity(i);
    }

    public void onSingleSwipingForMeClick(View view) {
        Intent i = new Intent(this, MatchmakerActivity.class);
        i.putExtra(User.CURRENT_USER, mCurrentUser);
        startActivity(i);
    }

    public void onEditProfileClick(View view) {
        Intent i = new Intent(this, EditProfileActivity.class);
        i.putExtra(User.CURRENT_USER, mCurrentUser);
        startActivity(i);
    }

}