package com.codepath.keeper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.codepath.keeper.R;
import com.codepath.keeper.models.User;

public class MatchmakingMenuActivity extends AppCompatActivity {

    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchmaking_menu);
        mUser = (User) getIntent().getSerializableExtra(User.CURRENT_USER);
    }

    public void onClickVouchList(View view) {
        Intent i = new Intent(this, VouchListActivity.class);
        i.putExtra(User.CURRENT_USER, mUser);
        startActivity(i);
    }

    public void onVouchForAFriendClick(View view) {
        Intent i = new Intent(this, VouchForAFriendActivity.class);
        i.putExtra(User.CURRENT_USER, mUser);
        startActivity(i);
    }

    public void onSwipeForAFriendClick(View view) {
        Intent i = new Intent(this, SwipeActivity.class);
        i.putExtra(User.CURRENT_USER, mUser);
        startActivity(i);
    }

    public void onMatchmakerClick(View view) {
        Intent i = new Intent(this, MatchmakerActivity.class);
        i.putExtra(User.CURRENT_USER, mUser);
        startActivity(i);
    }

    public void onSettingsClick(View view) {
        Intent i = new Intent(this, SettingsActivity.class);
        i.putExtra(User.CURRENT_USER, mUser);
        startActivity(i);
    }

    public void onSwitchToSingleModeClick(View view) {
        Intent i = new Intent(this, SingleMenuActivity.class);
        i.putExtra(User.CURRENT_USER, mUser);
        startActivity(i);
    }
}
